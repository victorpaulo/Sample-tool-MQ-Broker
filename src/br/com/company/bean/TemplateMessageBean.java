package br.com.company.bean;

/*
  Pos.Inicial	Pos.Final	Tamanho	Formato	Elemento de dados
	001			004			  04	  AN	C�digo de transa��o
	005			012			  08	  N		Seq��ncia da transa��o
	013			027			  15	  AN	IP da m�quina que est� enviando a string
	028			035			  08	  N		Data da m�quina no formato aaaammdd
	036			041			  06	  N		Hora da m�quina no formato hhmmss
  
 */

public class TemplateMessageBean {

	private String codigoTransacao;
	private String sequenciaTransacao;
	private String ipMaquina;
	private String data;
	private String hora;
	private String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCodigoTransacao() {
		return codigoTransacao;
	}
	public void setCodigoTransacao(String codigoTransacao) {
		this.codigoTransacao = codigoTransacao;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getIpMaquina() {
		return ipMaquina;
	}
	public void setIpMaquina(String ipMaquina) {
		this.ipMaquina = ipMaquina;
	}
	public String getSequenciaTransacao() {
		return sequenciaTransacao;
	}
	public void setSequenciaTransacao(String sequenciaTransacao) {
		this.sequenciaTransacao = sequenciaTransacao;
	}
}
