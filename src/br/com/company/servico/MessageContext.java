package br.com.company.servico;

public class MessageContext {

	private MessageServiceStrategy strategy;
	
	public MessageContext() {
		
	}
	
	public void setMessageStrategy(MessageServiceStrategy pStrategy) {
		this.strategy = pStrategy;
	}
	
	
	/**
	 * @throws Exception
	 */
	public void processInputMessages() throws Exception {
		strategy.processInputMessages();
	}
	
	/**
	 * @param type
	 * @throws Exception
	 */
	public void processOutputMessages() throws Exception {
		strategy.processOutputMessages();
	}
}
