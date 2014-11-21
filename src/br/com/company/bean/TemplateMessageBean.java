# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
# IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
# FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
# AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
# LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
# OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.


package br.com.company.bean;

/*
  Pos.Inicial	Pos.Final	Tamanho	Formato	Elemento de dados
	001			004			  04	  AN	Código de transação
	005			012			  08	  N		Seqüência da transação
	013			027			  15	  AN	IP da máquina que está enviando a string
	028			035			  08	  N		Data da máquina no formato aaaammdd
	036			041			  06	  N		Hora da máquina no formato hhmmss
  
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
