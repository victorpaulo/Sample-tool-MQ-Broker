package br.com.company.gui;
 
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.prefs.Preferences;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import br.com.company.bean.ConfigurationBean;
import br.com.company.servico.JMSService;
import br.com.company.servico.MQService;
import br.com.company.servico.MessageContext;

public class InterfaceTeste extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JTabbedPane jTabbedPane = null;

	private JTabbedPane jTabbedPane2 = null;

	private JPanel pnlJMS = null;

	private JLabel lblHost = null;

	private JLabel lblPort = null;

	private JLabel lblQMGR = null;

	private JLabel lblChannel = null;

	private JTextField txtHost = null;

	private JTextField txtPort = null;

	private JTextField txtQMGR = null;

	private JTextField txtChannel = null;

	private JButton btnAplicar = null;

	private JLabel lblQueueIn = null;

	private JLabel lblQueueOut = null;

	private JTextField txtQueueIn = null;

	private JTextField txtQueueOut = null;

	private JLabel lblMesg = null;

	private JTextField txtMsg = null;

	private JLabel lblQtdeMsg = null;

	private JTextField txtQtdeMsg = null;

	private JTabbedPane tabPanelLog = null;

	private JPanel pnlData = null;

	private JScrollPane jScrollPane2 = null;

	private JLabel lblLogOut = null;

	private JLabel lblArqTemplate = null;

	private JTextField txtNomeArq = null;

	private JLabel lblTmplateOut = null;

	private JTextField txtArqSaida = null;
	
	private JTextArea txtLog2 = null;

	private JButton btnLoad = null;

	private JButton btnLimparLog = null;

	private JLabel lblTypeAPI = null;

	private JRadioButton jRbJMS = null;

	private JRadioButton jRbMQ = null;

	private JLabel lblJMS = null;

	private JLabel lblMQ = null;

	private JPanel pnlData1 = null;

	private JScrollPane jScrollPane21 = null;

	private JTextArea txtLog21 = null;

	private JLabel lblLogOut1 = null;

	private JButton btnLoad1 = null;

	private JButton btnLimparLog1 = null;

	private JLabel lblLogIn = null;

	private JTextField txtLogEntrada = null;

	private JLabel lbltypeProcess = null;

	private JLabel lblPut = null;

	private JLabel lblGet = null;

	private JCheckBox chkPut = null;

	private JCheckBox chkGet = null;

	private JLabel lblUser = null;

	private JLabel lblPassword = null;

	private JTextField txtUser = null;

	private JPasswordField txtPassword = null;

	private JLabel lblSleep = null;

	private JTextField txtSleep = null;

	/**
	 * This method initializes jTabbedPane	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
private JTabbedPane getJTabbedPane() {
		if (jTabbedPane == null) {
			jTabbedPane = new JTabbedPane();
			jTabbedPane.setName("tab1");
			jTabbedPane.addTab("Manager", null, getJTabbedPane2(), null);
			jTabbedPane.addTab("Data", null, getTabPanelLog(), null);
			
		}
		return jTabbedPane;
	}

	/**
	 * This method initializes jTabbedPane2	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getJTabbedPane2() {
		if (jTabbedPane2 == null) {
			jTabbedPane2 = new JTabbedPane();
			jTabbedPane2.addTab("Configuração", null, getPnlJMS(), null);
		}
		return jTabbedPane2;
	}

	/**
	 * This method initializes pnlJMS	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPnlJMS() {
		if (pnlJMS == null) {
			lblSleep = new JLabel();
			lblSleep.setBounds(new Rectangle(317, 358, 132, 16));
			lblSleep.setFont(new Font("Verdana", Font.PLAIN, 12));
			lblSleep.setText("Intervalo de Envio:");
			lblPassword = new JLabel();
			lblPassword.setBounds(new Rectangle(405, 170, 93, 16));
			lblPassword.setText("Password:");
			lblPassword.setFont(new Font("Verdana", Font.PLAIN, 12));
			lblUser = new JLabel();
			lblUser.setBounds(new Rectangle(407, 141, 64, 16));
			lblUser.setText("User:");
			lblUser.setFont(new Font("Verdana", Font.PLAIN, 12));
			lblGet = new JLabel();
			lblGet.setBounds(new Rectangle(240, 393, 23, 16));
			lblGet.setText("GET");
			lblPut = new JLabel();
			lblPut.setBounds(new Rectangle(188, 393, 23, 16));
			lblPut.setText("PUT");
			lbltypeProcess = new JLabel();
			lbltypeProcess.setBounds(new Rectangle(13, 393, 110, 16));
			lbltypeProcess.setFont(new Font("Verdana", Font.PLAIN, 12));
			lbltypeProcess.setText("Process type:");
			lblLogIn = new JLabel();
			lblLogIn.setBounds(new Rectangle(12, 252, 91, 16));
			lblLogIn.setText("Log In:");
			lblLogIn.setFont(new Font("Verdana", Font.PLAIN, 12));
			lblMQ = new JLabel();
			lblMQ.setBounds(new Rectangle(255, 37, 25, 16));
			lblMQ.setText("MQ");
			lblJMS = new JLabel();
			lblJMS.setBounds(new Rectangle(185, 37, 38, 16));
			lblJMS.setText("JMS");
			lblTypeAPI = new JLabel();
			lblTypeAPI.setBounds(new Rectangle(12, 37, 112, 16));
			lblTypeAPI.setText("Conn. Type:");
			lblTypeAPI.setFont(new Font("Verdana", Font.PLAIN, 12));
			lblTmplateOut = new JLabel();
			lblTmplateOut.setBounds(new Rectangle(12, 285, 91, 16));
			lblTmplateOut.setText("Log Out:");
			lblTmplateOut.setFont(new Font("Verdana", Font.PLAIN, 12));
			lblArqTemplate = new JLabel();
			lblArqTemplate.setBounds(new Rectangle(12, 216, 117, 16));
			lblArqTemplate.setText("Template File:");
			lblArqTemplate.setFont(new Font("Verdana", Font.PLAIN, 12));
			lblQtdeMsg = new JLabel();
			lblQtdeMsg.setBounds(new Rectangle(13, 358, 112, 16));
			lblQtdeMsg.setFont(new Font("Verdana", Font.PLAIN, 12));
			lblQtdeMsg.setText("Qtde Mensagens:");
			lblMesg = new JLabel();
			lblMesg.setBounds(new Rectangle(12, 321, 73, 16));
			lblMesg.setFont(new Font("Verdana", Font.PLAIN, 12));
			lblMesg.setText("Mensagem:");
			lblQueueOut = new JLabel();
			lblQueueOut.setBounds(new Rectangle(407, 104, 80, 16));
			lblQueueOut.setFont(new Font("Verdana", Font.PLAIN, 12));
			lblQueueOut.setText("Queue Out:");
			lblQueueIn = new JLabel();
			lblQueueIn.setBounds(new Rectangle(407, 72, 80, 16));
			lblQueueIn.setFont(new Font("Verdana", Font.PLAIN, 12));
			lblQueueIn.setText("Queue In:");
			lblChannel = new JLabel();
			lblChannel.setBounds(new Rectangle(12, 180, 57, 16));
			lblChannel.setFont(new Font("Verdana", Font.PLAIN, 12));
			lblChannel.setText("Channel:");
			lblQMGR = new JLabel();
			lblQMGR.setBounds(new Rectangle(12, 144, 110, 16));
			lblQMGR.setFont(new Font("Verdana", Font.PLAIN, 12));
			lblQMGR.setText("Queue Manager: ");
			lblPort = new JLabel();
			lblPort.setBounds(new Rectangle(12, 104, 39, 16));
			lblPort.setFont(new Font("Verdana", Font.PLAIN, 12));
			lblPort.setText("Porta:");
			lblHost = new JLabel();
			lblHost.setBounds(new Rectangle(12, 72, 38, 16));
			lblHost.setFont(new Font("Verdana", Font.PLAIN, 12));
			lblHost.setText("Host: ");
			pnlJMS = new JPanel();
			pnlJMS.setLayout(null);
			pnlJMS.add(lblHost, null);
			pnlJMS.add(lblPort, null);
			pnlJMS.add(lblQMGR, null);
			pnlJMS.add(lblChannel, null);
			pnlJMS.add(getTxtHost(), null);
			pnlJMS.add(getTxtPort(), null);
			pnlJMS.add(getTxtQMGR(), null);
			pnlJMS.add(getTxtChannel(), null);
			pnlJMS.add(getBtnAplicar(), null);
			pnlJMS.add(lblQueueIn, null);
			pnlJMS.add(lblQueueOut, null);
			pnlJMS.add(getTxtQueueIn(), null);
			pnlJMS.add(getTxtQueueOut(), null);
			pnlJMS.add(lblMesg, null);
			pnlJMS.add(getTxtMsg(), null);
			pnlJMS.add(lblQtdeMsg, null);
			pnlJMS.add(getTxtQtdeMsg(), null);
			pnlJMS.add(lblArqTemplate, null);
			pnlJMS.add(getTxtNomeArq(), null);
			pnlJMS.add(lblTmplateOut, null);
			pnlJMS.add(getTxtArqSaida(), null);
			pnlJMS.add(lblTypeAPI, null);
			pnlJMS.add(getJRbJMS(), null);
			pnlJMS.add(getJRbMQ(), null);
			pnlJMS.add(lblJMS, null);
			pnlJMS.add(lblMQ, null);
			pnlJMS.add(lblLogIn, null);
			pnlJMS.add(getTxtLogEntrada(), null);
			pnlJMS.add(lbltypeProcess, null);
			pnlJMS.add(lblPut, null);
			pnlJMS.add(lblGet, null);
			pnlJMS.add(getChkPut(), null);
			pnlJMS.add(getChkGet(), null);
			pnlJMS.add(lblUser, null);
			pnlJMS.add(lblPassword, null);
			pnlJMS.add(getTxtUser(), null);
			pnlJMS.add(getTxtPassword(), null);
			pnlJMS.add(lblSleep, null);
			pnlJMS.add(getTxtSleep(), null);
		}
		return pnlJMS;
	}

	/**
	 * This method initializes txtHost	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtHost() {
		if (txtHost == null) {
			txtHost = new JTextField();
			txtHost.setName("host");
			txtHost.setBounds(new Rectangle(164, 68, 226, 20));
			txtHost.setToolTipText("Informe o Host ou IP da máquina onde esta o MQ.");
			txtHost.setText(myPreferences.get(txtHost.getName(), "localhost"));
		}
		return txtHost;
	}

	/**
	 * This method initializes txtPort	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtPort() {
		if (txtPort == null) {
			txtPort = new JTextField();
			txtPort.setBounds(new Rectangle(164, 100, 227, 20));
			txtPort.setToolTipText("Informe a Porta, nao pode ser caracter.");
			txtPort.setName("port");
			txtPort.setText(myPreferences.get(txtPort.getName(), "1414"));
		}
		return txtPort;
	}

	/**
	 * This method initializes txtQMGR	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtQMGR() {
		if (txtQMGR == null) {
			txtQMGR = new JTextField();
			txtQMGR.setBounds(new Rectangle(164, 140, 225, 20));
			txtQMGR.setToolTipText("Informe o Queue Manager ao qual deseja conectar.");
			txtQMGR.setName("qmgr");
			txtQMGR.setText(myPreferences.get(txtQMGR.getName(), "QMGR"));
		}
		return txtQMGR;
	}

	/**
	 * This method initializes txtChannel	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtChannel() {
		if (txtChannel == null) {
			txtChannel = new JTextField();
			txtChannel.setBounds(new Rectangle(164, 176, 225, 20));
			txtChannel.setToolTipText("Informe o Canal que esta definido no MQ.");
			txtChannel.setName("channel");
			txtChannel.setText(myPreferences.get(txtChannel.getName(), "SYSTEM.DEF.SVRCONN"));
			
		}
		return txtChannel;
	}

	/**
	 * This method initializes btnAplicar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnAplicar() {
		if (btnAplicar == null) {
			btnAplicar = new JButton();
			btnAplicar.setBounds(new Rectangle(521, 385, 141, 34));
			btnAplicar.setText("Processar");
			btnAplicar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ConfigurationBean bean = getConfigurationBean();
					final MessageContext  context = new MessageContext();
					if (jRbJMS.isSelected()) {
						context.setMessageStrategy(new JMSService(bean));	
					} else {
						context.setMessageStrategy(new MQService(bean));
					}
					
					if (chkPut.isSelected()) {
						Thread threadInputProcess = new Thread(new Runnable() {
							public void run() {
								try {
									context.processInputMessages();
								} catch (Exception e) {
									e.printStackTrace();
									JOptionPane.showMessageDialog(new InterfaceTeste(), e.getMessage(),
										      "Error", JOptionPane.ERROR_MESSAGE);
								}
							}
						});
						threadInputProcess.start();
					}
					
					if (chkGet.isSelected()) {
						Thread threadOutputProcess = new Thread(new Runnable() {
							public void run() {
								try {
									context.processOutputMessages();
								} catch (Exception e) {
									e.printStackTrace();
									JOptionPane.showMessageDialog(new InterfaceTeste(), e.getMessage(),
										      "Error", JOptionPane.ERROR_MESSAGE);
								}
							}
						});
						threadOutputProcess.start();
					}
					JOptionPane.showMessageDialog(new InterfaceTeste(),  " Processando ["+ bean.getNumberOfMessages() +"] msgs ...!" ,
						      "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				}
			});
		}
		return btnAplicar;
	}

	private ConfigurationBean getConfigurationBean() {
		ConfigurationBean configuracao = new ConfigurationBean();
		configuracao.setHost(txtHost.getText());
		if (txtPort.getText() != null && !"".equals(txtPort.getText()))
			configuracao.setPort(Integer.parseInt(txtPort.getText()));
		configuracao.setQmgr(txtQMGR.getText());
		configuracao.setUser(txtUser.getText());
		if (txtPassword.getPassword()!= null && txtPassword.getPassword().length > 0){
			configuracao.setPassword(new String(txtPassword.getPassword()));	
		}
		configuracao.setChannel(txtChannel.getText());
		configuracao.setQueueIn(txtQueueIn.getText());
		configuracao.setQueueOut(txtQueueOut.getText());
		configuracao.setMessage(txtMsg.getText());
		configuracao.setFileTemplate(new File(txtNomeArq.getText()));
		configuracao.setFileIn(new File(txtLogEntrada.getText()));
		configuracao.setFileOut(new File(txtArqSaida.getText()));
		if (txtQtdeMsg.getText() != null && !"".equals(txtQtdeMsg.getText()))
			configuracao.setNumberOfMessages(Integer.parseInt(txtQtdeMsg.getText()));
		
		if (txtSleep.getText() != null && !"".equals(txtSleep.getText())) 
			configuracao.setSleep(Integer.parseInt(txtSleep.getText()));
		return configuracao;
		
	}
	
	/**
	 * This method initializes txtQueueIn	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtQueueIn() {
		if (txtQueueIn == null) {
			txtQueueIn = new JTextField();
			txtQueueIn.setBounds(new Rectangle(515, 68, 141, 20));
			txtQueueIn.setToolTipText("Informe o nome da Fila de Entrada.");
			txtQueueIn.setName("queueIn");
			txtQueueIn.setText(myPreferences.get(txtQueueIn.getName(), "JMSQ1"));
		}
		return txtQueueIn;
	}

	/**
	 * This method initializes txtQueueOut	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtQueueOut() {
		if (txtQueueOut == null) {
			txtQueueOut = new JTextField();
			txtQueueOut.setSize(new Dimension(141, 20));
			txtQueueOut.setToolTipText("Informe o nome da Fila de Saida.");
			txtQueueOut.setName("queueOut");
			txtQueueOut.setText(myPreferences.get(txtQueueOut.getName(), "JMSQ1"));
			txtQueueOut.setLocation(new Point(515, 100));
		}
		return txtQueueOut;
	}

	/**
	 * This method initializes txtMsg	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtMsg() {
		if (txtMsg == null) {
			txtMsg = new JTextField();
			txtMsg.setText("");
			txtMsg.setSize(new Dimension(496, 20));
			txtMsg.setEditable(false);
			txtMsg.setLocation(new Point(164, 317));
		}
		return txtMsg;
	}

	/**
	 * This method initializes txtQtdeMsg	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtQtdeMsg() {
		if (txtQtdeMsg == null) {
			txtQtdeMsg = new JTextField();
			txtQtdeMsg.setBounds(new Rectangle(164, 355, 138, 20));
			txtQtdeMsg.setToolTipText("Informe a quantidade de msgs que deseja ler ou escrever no MQ. Quando nao definido ler ate msg=0 ou coloca ate msg=depthQueue.");
			txtQtdeMsg.setName("numMsg");
			txtQtdeMsg.setText(myPreferences.get(txtQtdeMsg.getName(), ""));
		}
		return txtQtdeMsg;
	}

	/**
	 * This method initializes tabPanelLog	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getTabPanelLog() {
		if (tabPanelLog == null) {
			tabPanelLog = new JTabbedPane();
			tabPanelLog.addTab("Log In", null, getPnlData(), null);
			tabPanelLog.addTab("Log Out", null, getPnlData1(), null);
		}
		return tabPanelLog;
	}

	/**
	 * This method initializes pnlData	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPnlData() {
		if (pnlData == null) {
			lblLogOut = new JLabel();
			lblLogOut.setBounds(new Rectangle(22, 15, 634, 22));
			lblLogOut.setText("Log Retorno :: Qtde Linhas = 0");
			lblLogOut.setFont(new Font("Verdana", Font.PLAIN, 14));
			pnlData = new JPanel();
			pnlData.setLayout(null);
			pnlData.add(getJScrollPane2(), null);
			pnlData.add(lblLogOut, null);
			pnlData.add(getBtnLoad(), null);
			pnlData.add(getBtnLimparLog(), null);
		}
		return pnlData;
	}

	/**
	 * This method initializes jScrollPane2	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane2() {
		if (jScrollPane2 == null) {
			jScrollPane2 = new JScrollPane();
			jScrollPane2.setBounds(new Rectangle(22, 49, 693, 311));
			jScrollPane2.setViewportView(getTxtLog2());
		}
		return jScrollPane2;
	}

	/**
	 * This method initializes txtNomeArq	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtNomeArq() {
		if (txtNomeArq == null) {
			txtNomeArq = new JTextField();
			txtNomeArq.setBounds(new Rectangle(164, 212, 496, 20));
			txtNomeArq.setToolTipText("Informe o arquivo de template de formatacao das mensagens.");
			txtNomeArq.setName("templateFile");
			txtNomeArq.setText(myPreferences.get(txtNomeArq.getName(), "C:/temp/ipba.txt"));
		}
		return txtNomeArq;
	}

	/**
	 * This method initializes txtArqSaida	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtArqSaida() {
		if (txtArqSaida == null) {
			txtArqSaida = new JTextField();
			txtArqSaida.setSize(new Dimension(496, 20));
			txtArqSaida.setToolTipText("Informe o Log referente ao processamento da Fila de Saida.");
			txtArqSaida.setName("logOut");
			txtArqSaida.setText(myPreferences.get(txtArqSaida.getName(), "c:/temp/logOut.txt"));
			txtArqSaida.setLocation(new Point(164, 281));
		}
		return txtArqSaida;
	}

	/**
	 * This method initializes txtLog2	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getTxtLog2() {
		if (txtLog2 == null) {
			txtLog2 = new JTextArea();
		}
		return txtLog2;
	}

	/**
	 * This method initializes btnLoad	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnLoad() {
		if (btnLoad == null) {
			btnLoad = new JButton();
			btnLoad.setBounds(new Rectangle(194, 377, 136, 30));
			btnLoad.setText("Load");
			btnLoad.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					BufferedReader reader = null;
					String line = null;
					String arqEntrada = txtLogEntrada.getText();
					if (arqEntrada != null & !"".equals(arqEntrada)) {
						try {
							File arq = new File(arqEntrada);
							long fileSize = arq.length();
							if (!(fileSize == txtLog2.getText().length())) {
								reader = new BufferedReader(new InputStreamReader(new FileInputStream(arq)));
								int pos = 0;
								while((line = reader.readLine()) != null) {
									txtLog2.insert(line + System.getProperty("line.separator"), pos++);
								}
								lblLogOut.setText("Log Retorno :: Qtde Linhas = "+ pos);
							} 
							
							
						} catch(Exception ex) {
							ex.printStackTrace();
							JOptionPane.showMessageDialog(new InterfaceTeste(),  ex.getMessage(),
								      "Error", JOptionPane.ERROR_MESSAGE);
						} finally {
							try {
								if (reader != null)
									reader.close();
							} catch (IOException ex1) {}
						}
					}
				}
			});
		}
		return btnLoad;
	}

	/**
	 * This method initializes btnLimparLog	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnLimparLog() {
		if (btnLimparLog == null) {
			btnLimparLog = new JButton();
			btnLimparLog.setText("Limpar");
			btnLimparLog.setSize(new Dimension(136, 30));
			btnLimparLog.setLocation(new Point(376, 377));
			btnLimparLog.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtLog2.setText("");
					lblLogOut.setText("Log Retorno :: Qtde Linhas = 0");
				}
			});
		}
		return btnLimparLog;
	}

	/**
	 * This method initializes jRbJMS	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRbJMS() {
		if (jRbJMS == null) {
			jRbJMS = new JRadioButton();
			jRbJMS.setBounds(new Rectangle(163, 32, 21, 21));
			jRbJMS.setName("connTypeJMS");
			jRbJMS.setSelected(myPreferences.getBoolean(jRbJMS.getName(), true));
			jRbJMS.setText("");
			jRbJMS.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jRbMQ.setSelected(false);
				}
			});
			
		}
		return jRbJMS;
	}

	/**
	 * This method initializes jRbMQ	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRbMQ() {
		if (jRbMQ == null) {
			jRbMQ = new JRadioButton();
			jRbMQ.setBounds(new Rectangle(230, 32, 21, 21));
			jRbMQ.setMnemonic(KeyEvent.VK_UNDEFINED);
			jRbMQ.setName("connTypeMQ");
			jRbMQ.setSelected(myPreferences.getBoolean(jRbMQ.getName(), false));
			jRbMQ.setText("");
			jRbMQ.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jRbJMS.setSelected(false);
				}
			});
		}
		return jRbMQ;
	}

	/**
	 * This method initializes pnlData1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPnlData1() {
		if (pnlData1 == null) {
			lblLogOut1 = new JLabel();
			lblLogOut1.setBounds(new Rectangle(22, 15, 634, 22));
			lblLogOut1.setText("Log Retorno :: Qtde Linhas = 0");
			lblLogOut1.setFont(new Font("Verdana", Font.PLAIN, 14));
			pnlData1 = new JPanel();
			pnlData1.setLayout(null);
			pnlData1.add(getJScrollPane21(), null);
			pnlData1.add(lblLogOut1, null);
			pnlData1.add(getBtnLoad1(), null);
			pnlData1.add(getBtnLimparLog1(), null);
		}
		return pnlData1;
	}

	/**
	 * This method initializes jScrollPane21	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane21() {
		if (jScrollPane21 == null) {
			jScrollPane21 = new JScrollPane();
			jScrollPane21.setLocation(new Point(22, 49));
			jScrollPane21.setSize(new Dimension(693, 311));
			jScrollPane21.setViewportView(getTxtLog21());
		}
		return jScrollPane21;
	}

	/**
	 * This method initializes txtLog21	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getTxtLog21() {
		if (txtLog21 == null) {
			txtLog21 = new JTextArea();
		}
		return txtLog21;
	}

	/**
	 * This method initializes btnLoad1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnLoad1() {
		if (btnLoad1 == null) {
			btnLoad1 = new JButton();
			btnLoad1.setBounds(new Rectangle(180, 382, 136, 30));
			btnLoad1.setText("Load");
			btnLoad1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					BufferedReader reader = null;
					String line = null;
					String arqSaida = txtArqSaida.getText();
					if (arqSaida != null & !"".equals(arqSaida)) {
						try {
							File arq = new File(arqSaida);
							long fileSize = arq.length();
							if (!(fileSize == txtLog21.getText().length())) {
								reader = new BufferedReader(new InputStreamReader(new FileInputStream(arq)));
								int pos = 0;
								while((line = reader.readLine()) != null) {
									txtLog21.insert(line + System.getProperty("line.separator"), pos++);
								}
								lblLogOut1.setText("Log Retorno :: Qtde Linhas = "+ pos);
							} 
							
							
						} catch(Exception ex) {
							ex.printStackTrace();
							JOptionPane.showMessageDialog(new InterfaceTeste(),  ex.getMessage(),
								      "Error", JOptionPane.ERROR_MESSAGE);
						} finally {
							try {
								if (reader != null)
									reader.close();
							} catch (IOException ex1) {}
						}
					}

				}
			});
		}
		return btnLoad1;
	}

	/**
	 * This method initializes btnLimparLog1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnLimparLog1() {
		if (btnLimparLog1 == null) {
			btnLimparLog1 = new JButton();
			btnLimparLog1.setLocation(new Point(360, 382));
			btnLimparLog1.setText("Limpar");
			btnLimparLog1.setSize(new Dimension(136, 30));
			btnLimparLog1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txtLog21.setText("");
					lblLogOut1.setText("Log Retorno :: Qtde Linhas = 0");
				}
			});
		}
		return btnLimparLog1;
	}

	/**
	 * This method initializes txtLogEntrada	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtLogEntrada() {
		if (txtLogEntrada == null) {
			txtLogEntrada = new JTextField();
			txtLogEntrada.setName("logIn");
			txtLogEntrada.setText(myPreferences.get(txtLogEntrada.getName(), "c:/temp/logIn.txt"));
			txtLogEntrada.setSize(new Dimension(496, 20));
			txtLogEntrada.setToolTipText("Informe o Log referente ao processamento da Fila de Entrada.");
			txtLogEntrada.setLocation(new Point(164, 248));
		}
		return txtLogEntrada;
	}

	/**
	 * This method initializes chkPut	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkPut() {
		if (chkPut == null) {
			chkPut = new JCheckBox();
			chkPut.setBounds(new Rectangle(164, 388, 23, 21));
			chkPut.setName("processPut");
			chkPut.setSelected(myPreferences.getBoolean(chkPut.getName(), false));
			chkPut.setToolTipText("Se checado, coloca mensagens na Fila de Entrada.");
		}
		return chkPut;
	}

	/**
	 * This method initializes chkGet	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getChkGet() {
		if (chkGet == null) {
			chkGet = new JCheckBox();
			chkGet.setBounds(new Rectangle(216, 389, 23, 21));
			chkGet.setName("processGet");
			chkGet.setSelected(myPreferences.getBoolean(chkGet.getName(), false));
			chkGet.setToolTipText("Se checado, obtem mensagens da Fila de Saida.");
		}
		return chkGet;
	}

	/**
	 * This method initializes txtUser	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtUser() {
		if (txtUser == null) {
			txtUser = new JTextField();
			txtUser.setName("user");
			txtUser.setText(myPreferences.get(txtUser.getName(), ""));
			txtUser.setSize(new Dimension(141, 20));
			txtUser.setToolTipText("Informe o usuario para o MQ com seguranca habilitada.");
			txtUser.setLocation(new Point(514, 133));
		}
		return txtUser;
	}

	/**
	 * This method initializes txtPassword	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getTxtPassword() {
		if (txtPassword == null) {
			txtPassword = new JPasswordField();
			txtPassword.setLocation(new Point(514, 167));
			txtPassword.setToolTipText("Informe a senha para o MQ com seguranca habilitada.");
			txtPassword.setName("password");
			txtPassword.setText(myPreferences.get(txtPassword.getName(), ""));
			txtPassword.setSize(new Dimension(141, 20));
		}
		return txtPassword;
	}

	/**
	 * This method initializes txtSleep	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtSleep() {
		if (txtSleep == null) {
			txtSleep = new JTextField();
			txtSleep.setBounds(new Rectangle(462, 355, 68, 20));
			txtSleep.setName("sleep");
			txtSleep.setText(myPreferences.get(txtSleep.getName(), "100"));
			txtSleep.setToolTipText("Define o intervalo de envio entre uma msg e outra em milisegundos.");
		}
		return txtSleep;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				InterfaceTeste thisClass = new InterfaceTeste();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
				
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public InterfaceTeste() {
		super();
		myPreferences = Preferences.userNodeForPackage(this.getClass());
		initialize();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				savePreferences();
				System.exit(0);
			}
		});
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setContentPane(getJContentPane());
		this.setTitle("Stress Test MQ/Broker");
		this.setBounds(new Rectangle(0, 0, 776, 525));
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.BOTH;
			gridBagConstraints.gridx = 0;
			gridBagConstraints.weighty = 1.0;
			gridBagConstraints.weightx = 1.0;
			gridBagConstraints.gridy = 0;
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(getJTabbedPane(), gridBagConstraints);
		}
		return jContentPane;
	}
	
	private void savePreferences() {
		Component [] comps = getPnlJMS().getComponents();
		for (int i=0; i < comps.length; i++) {
			Component comp = comps[i];
			if (comp instanceof JTextField) {
				JTextField text = (JTextField) comp;
				if (text.getName()!= null)
					myPreferences.put(text.getName(), text.getText());
			} else if (comp instanceof JPasswordField) {
				JPasswordField pass = (JPasswordField) comp;
				if (pass.getName() != null)
					myPreferences.put(pass.getName(), new String(pass.getPassword()));
			} else if (comp instanceof JCheckBox) {
				JCheckBox chkBox = (JCheckBox) comp;
				if (chkBox.getName() != null)
					myPreferences.putBoolean(chkBox.getName(), chkBox.isSelected());
			} else if (comp instanceof JRadioButton) {
				JRadioButton radio = (JRadioButton) comp;
				if (radio.getName() != null)
					myPreferences.putBoolean(radio.getName(), radio.isSelected());
			}
		}
		
	}
	
	private Preferences myPreferences = null;

}  //@jve:decl-index=0:visual-constraint="10,10"
