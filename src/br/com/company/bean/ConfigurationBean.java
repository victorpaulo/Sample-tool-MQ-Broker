# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
# IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
# FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
# AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
# LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
# OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

package br.com.company.bean;

import java.io.File;


public class ConfigurationBean{

	private String host;
	private int port;
	private String user;
	private String password;
	private String channel;
	private String qmgr;
	private String queueIn;
	private String queueOut;
	private File fileTemplate;
	private File fileIn;
	private File fileOut;
	private String message;
	private int numberOfMessages;
	private int sleep;
	
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public File getFileIn() {
		return fileIn;
	}
	public void setFileIn(File fileIn) {
		this.fileIn = fileIn;
	}
	public File getFileOut() {
		return fileOut;
	}
	public void setFileOut(File fileOut) {
		this.fileOut = fileOut;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getQmgr() {
		return qmgr;
	}
	public void setQmgr(String qmgr) {
		this.qmgr = qmgr;
	}
	public String getQueueIn() {
		return queueIn;
	}
	public void setQueueIn(String queueIn) {
		this.queueIn = queueIn;
	}
	public String getQueueOut() {
		return queueOut;
	}
	public void setQueueOut(String queueOut) {
		this.queueOut = queueOut;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getNumberOfMessages() {
		return numberOfMessages;
	}
	public void setNumberOfMessages(int numberOfMessages) {
		this.numberOfMessages = numberOfMessages;
	}
	public File getFileTemplate() {
		return fileTemplate;
	}
	public void setFileTemplate(File fileTemplate) {
		this.fileTemplate = fileTemplate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public int getSleep() {
		return sleep;
	}
	public void setSleep(int sleep) {
		this.sleep = sleep;
	}
	
}
