package br.com.company.servico;

import javax.jms.Session;
import javax.jms.TextMessage;

import br.com.company.bean.ConfigurationBean;

import com.ibm.jms.JMSMessage;
import com.ibm.jms.JMSTextMessage;
import com.ibm.mq.jms.JMSC;
import com.ibm.mq.jms.MQQueue;
import com.ibm.mq.jms.MQQueueConnection;
import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.ibm.mq.jms.MQQueueReceiver;
import com.ibm.mq.jms.MQQueueSender;
import com.ibm.mq.jms.MQQueueSession;

public class JMSService extends MessageServiceStrategy {

	
	public JMSService(ConfigurationBean beanConfig) {
		super(beanConfig);
	}

	/* (non-Javadoc)
	 * @see br.com.company.servico.AbstractMessageService#processInputMessages()
	 */
	public void processInputMessages() throws Exception{
		
		MQQueueConnection connection = null;
		try {
			MQQueueConnectionFactory cf = new MQQueueConnectionFactory();
			cf.setHostName(config.getHost());
			cf.setPort(config.getPort());
			cf.setTransportType(JMSC.MQJMS_TP_CLIENT_MQ_TCPIP);
			cf.setQueueManager(config.getQmgr());
			cf.setChannel(config.getChannel());
			connection = (MQQueueConnection) cf.createQueueConnection(config.getUser(), config.getPassword());
			MQQueueSession session = (MQQueueSession) connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			MQQueue queueIn = (MQQueue) session.createQueue("queue:///" + config.getQueueIn());
			queueIn.setTargetClient(JMSC.MQJMS_CLIENT_NONJMS_MQ);
			MQQueueSender sender = (MQQueueSender) session.createSender(queueIn);
			int cont = 0;
			do {
				String strMsg = formatMessage(++cont, config);
				JMSTextMessage message = (JMSTextMessage) session.createTextMessage(strMsg);
				try {
					Thread.sleep(config.getSleep());
				} catch (InterruptedException iex) {} 
				sender.send(message);
				writeIn(strMsg);
			} while(cont != config.getNumberOfMessages());
			
		} finally {
			
			try {
				if (connection != null)
					connection.close();
				
				if (logIN != null)
					logIN.close();
			} catch (Exception ignore) {}
		}
		
	}
	
	/* (non-Javadoc)
	 * @see br.com.company.servico.AbstractMessageService#processOutputMessages(java.lang.String)
	 */
	public void processOutputMessages() throws Exception {
		
		MQQueueConnection connection = null;
		try {
			MQQueueConnectionFactory cf = new MQQueueConnectionFactory();
			cf.setHostName(config.getHost());
			cf.setPort(config.getPort());
			cf.setTransportType(JMSC.MQJMS_TP_CLIENT_MQ_TCPIP);
			cf.setQueueManager(config.getQmgr());
			cf.setChannel(config.getChannel());
			connection = (MQQueueConnection) cf.createQueueConnection();
			connection.start();
			MQQueueSession session = (MQQueueSession) connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			MQQueue queueOut = (MQQueue) session.createQueue("queue:///" + config.getQueueOut());
			
			MQQueueReceiver receiver = (MQQueueReceiver) session.createReceiver(queueOut);
			JMSMessage receivedMessage = null;
			int cont = 0;
			do {
				try {
					Thread.sleep(config.getSleep());
				} catch (InterruptedException iex) {} 
				
				receivedMessage = (JMSMessage) receiver.receive(5000);
				writeOut(((TextMessage) receivedMessage).getText());
				cont++;

			} while(cont != config.getNumberOfMessages() && receivedMessage != null);
			
			
		} finally {
			
			try {
				if (connection != null)
					connection.close();
				
				if (logOUT != null)
					logOUT.close();
			} catch (Exception ignore) {}
		}
		
	} 
	
	
}
