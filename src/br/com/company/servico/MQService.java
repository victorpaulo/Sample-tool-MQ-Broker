package br.com.company.servico;

import br.com.company.bean.ConfigurationBean;

import com.ibm.mq.MQC;
import com.ibm.mq.MQEnvironment;
import com.ibm.mq.MQException;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQPutMessageOptions;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;

public class MQService extends MessageServiceStrategy {

	private static final int openOptions = MQC.MQOO_FAIL_IF_QUIESCING | MQC.MQOO_OUTPUT;

	/**
	 * @param beanConfig
	 */
	public MQService(ConfigurationBean beanConfig) {
		super(beanConfig);

	}

	/* (non-Javadoc)
	 * @see br.com.company.servico.AbstractMessageService#processInputMessages()
	 */
	public void processInputMessages() throws Exception{
		
		MQQueue queueIn = null;
		MQQueueManager qmgr = null;
		try {
			MQEnvironment.hostname = config.getHost(); // Servidor MQ
			MQEnvironment.port = config.getPort(); // porta listening do QManager
			MQEnvironment.channel = config.getChannel(); // Nome do canal
			MQEnvironment.properties.put(MQC.TRANSPORT_PROPERTY, MQC.TRANSPORT_MQSERIES);
			qmgr = new MQQueueManager(config.getQmgr());
			MQPutMessageOptions pmo = new MQPutMessageOptions();
			pmo.options = MQC.MQPMO_LOGICAL_ORDER;
			queueIn = qmgr.accessQueue(config.getQueueIn(), openOptions, null, null, null);
			
			int cont = 0;
			do {
				try { 
					
					String strMsg = formatMessage(++cont, config);
					MQMessage mqMessage = new MQMessage();
					mqMessage.format = MQC.MQFMT_STRING;
					mqMessage.writeString(strMsg);
					Thread.sleep(config.getSleep());
					queueIn.put(mqMessage, pmo);
					writeIn(strMsg);
					
				} catch (MQException mqex) {
					if (mqex.reasonCode == MQException.MQRC_Q_FULL) {
						try {
							Thread.sleep(config.getSleep() * 2);
							cont--;
						} catch (InterruptedException ignore) {}
					}
					if (mqex.reasonCode == MQException.MQRC_UNEXPECTED_ERROR) {
						System.exit(-1);
					}
				}
				
			} while(cont != config.getNumberOfMessages());
			
		} finally {
			try {
				if (queueIn != null) {
					queueIn.close();
				}
				if (qmgr != null) {
					qmgr.disconnect();
				}
				
				if (logIN != null) {
					logIN.close();
				}
					
			} catch (Exception ignore) {}
		}
		
	}
	
	/* (non-Javadoc)
	 * @see br.com.company.servico.AbstractMessageService#processOutputMessages(java.lang.String)
	 */
	public void processOutputMessages() throws Exception {
		
		MQQueue queueOut = null;
		MQQueueManager qmgr = null;
		try {
			MQEnvironment.hostname = config.getHost();
			MQEnvironment.port = config.getPort();
			MQEnvironment.channel = config.getChannel();
			MQEnvironment.disableTracing();
			MQException.log = null; 
			MQEnvironment.properties.put(MQC.TRANSPORT_PROPERTY, MQC.TRANSPORT_MQSERIES);
			qmgr = new MQQueueManager(config.getQmgr());
			queueOut = qmgr.accessQueue(config.getQueueOut(), MQC.MQOO_INPUT_AS_Q_DEF +   MQC.MQOO_FAIL_IF_QUIESCING);
			
			String msg = null;
			int cont = 0;
			do {
				MQMessage message = new MQMessage();
				try { 
					Thread.sleep(config.getSleep());
					queueOut.get(message);
				} catch (MQException mqex) {
					if (mqex.reasonCode == MQException.MQRC_NO_MSG_AVAILABLE) {
						try {
							Thread.sleep(config.getSleep() * 2);
							queueOut.get(message);
						} catch (InterruptedException ignore) {}
					}
					if (mqex.reasonCode == MQException.MQRC_UNEXPECTED_ERROR) {
						System.exit(-1);
					}
				}
				msg =  message.readStringOfCharLength(message.getDataLength());
				writeOut(msg);
				cont++;
			} while (cont != config.getNumberOfMessages() && msg != null);
			
		} finally {
			try {
				if (queueOut != null) {
					queueOut.close();
				}
				if (qmgr != null) {
					qmgr.disconnect();
				}
				
				if (logOUT != null) {
					logOUT.close();
				}
					
			} catch (Exception ignore) {}
		}
		
	} 
}
