# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
# IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
# FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
# AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
# LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
# OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

package br.com.company.servico;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import br.com.company.bean.ConfigurationBean;
import br.com.company.bean.TemplateMessageBean;



public abstract class MessageServiceStrategy {

	private TemplateMessageBean templateMessage;
	private StringBuffer sbMessage = new StringBuffer();
	
	protected ConfigurationBean config;
	protected BufferedWriter logIN;
	protected BufferedWriter logOUT;
	
	/**
	 * @param beanConfig
	 */
	public MessageServiceStrategy (ConfigurationBean beanConfig) {
		config = beanConfig;
	}
	
	/**
	 * @param index
	 * @param config
	 * @return
	 * @throws Exception
	 */
	protected String formatMessage(int index, ConfigurationBean config) throws Exception {
		TemplateMessageBean template = getTemplateMessage(config.getFileTemplate());
		if (index == 1) {
			sbMessage.append(template.getCodigoTransacao());
			sbMessage.append(template.getSequenciaTransacao());
			sbMessage.append(formatIPAddress(InetAddress.getLocalHost().getHostAddress(), template.getIpMaquina()));	
			sbMessage.append(formatCurrentTimestamp("yyyyMMddHHmmss"));
			sbMessage.append(template.getMessage());
		} 
		sbMessage.replace(4, 12, formatSequential(index, template.getSequenciaTransacao()));
		sbMessage.replace(27, 41, formatCurrentTimestamp("yyyyMMddHHmmss"));
		return sbMessage.toString();
	}
	
	/**
	 * @param input
	 * @return
	 * @throws Exception
	 */
	private TemplateMessageBean getTemplateMessage(File input) throws Exception{
		
		if (templateMessage == null) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(input)));
			String line = null;
			if((line = reader.readLine()) != null) {
				if (line.length() > 41) {
					templateMessage = new TemplateMessageBean();
					templateMessage.setCodigoTransacao(line.substring(0, 4));
					templateMessage.setSequenciaTransacao(line.substring(4, 12));
					templateMessage.setIpMaquina(line.substring(12, 27));
					templateMessage.setData(line.substring(27, 35));
					templateMessage.setHora(line.substring(35, 41));
					templateMessage.setMessage(line.substring(41));
				}
			}
		}
		return templateMessage;
	}
	
	/**
	 * Gera uma marca com data e hora correntes 
	 * no fuso horário de Brasília sem horário de verão.<br>
	 * Formato: <pre>yyyy/MM/dd HH:mm:ssss</pre>
	 * 
	 * @return Data e hora atuais
	 */ 
	private String formatCurrentTimestamp(String pattern) {
		TimeZone timeZone = TimeZone.getTimeZone("GMT-03:00");
		Calendar calendar = Calendar.getInstance(timeZone);
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		sdf.setTimeZone(timeZone);
		return sdf.format(calendar.getTime());
	}
	
	/**
	 * @param seq
	 * @param pattern
	 * @return
	 */
	private String formatSequential(int seq, String pattern) {
		int contZero = pattern.length() - Integer.toString(seq).length();
		StringBuffer sbSeqWithZeros = new StringBuffer();
		for (int i = 0; i < contZero; i++) {
			sbSeqWithZeros.append("0");
		}
		sbSeqWithZeros.append(seq);
		return sbSeqWithZeros.toString();
	}
	
	/**
	 * @param ip
	 * @param pattern
	 * @return
	 */
	private String formatIPAddress(String ip, String pattern) {
		StringBuffer sbSeqWithSpaces = new StringBuffer();
		sbSeqWithSpaces.append(ip);
		int tam = pattern.length() - ip.length(); 
		for (int i = 0; i < tam; i++) {
			sbSeqWithSpaces.append(" ");
		}
		return sbSeqWithSpaces.toString();
	}
	
	protected void writeOut(String msg) throws Exception {
		if (logOUT == null) {
			logOUT = new BufferedWriter(new PrintWriter(config.getFileOut()));
		}
		logOUT.write(msg);
		logOUT.write(System.getProperty("line.separator"));
	}
	
	protected void writeIn(String msg) throws Exception {
		if (logIN == null) {
			logIN = new BufferedWriter(new PrintWriter(config.getFileIn()));
		}
		logIN.write(msg);
		logIN.write(System.getProperty("line.separator"));
	}
	
	/**
	 * @throws Exception
	 */
	public abstract void processInputMessages() throws Exception;
	
	/**
	 * @param type
	 * @throws Exception
	 */
	public abstract void processOutputMessages() throws Exception;
}
