# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
# IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
# FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
# AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
# LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
# OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

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
