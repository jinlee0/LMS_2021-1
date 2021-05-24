package windowsView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import control.CLogin;
import valueObject.OLogin;
import valueObject.OMember;

public class VLogin extends JFrame{
	
	private CLogin cLogin;

	private JTextField idText;
	private JTextField passwordText;
	
	private final int CONTENT_SIZE = 7;
	private final String ID_VALID_MSG = "���̵𿡴� ���ڸ� �Է��� �� �ֽ��ϴ�";
	private final String ID_BLANK_MSG = "���̵� �Է��ϼ���";
	private final String PSWD_BLANK_MSG = "��й�ȣ�� �Է��ϼ���"; 
	
	public VLogin() {
		this.setTitle("login");
		this.setSize(400,300);
		this.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setMaximumSize(new Dimension(400, 300));
		this.setContentPane(panel);
		
		JLabel loginLabel = new JLabel("���̵�(�й�)");
		panel.add(loginLabel, this.getGbc(0, 0));
		
		JLabel passwordLabel = new JLabel("��й�ȣ");
		panel.add(passwordLabel, this.getGbc(0, 1));
		
		this.idText = new JTextField(20);
		panel.add(this.idText, this.getGbc(1, 0, 4, 1));
		
		this.passwordText = new JPasswordField(20);
		panel.add(this.passwordText, this.getGbc(1, 1, 4, 1));
		
		
		JButton loginButton = new JButton("�α���");
		panel.add(loginButton, this.getGbc(0, 3, 5, 1));
		this.getRootPane().setDefaultButton(loginButton);
		
		JButton registrationButton = new JButton("ȸ������");
		panel.add(registrationButton, this.getGbc(0, 4, 5, 1));
		
		JLabel validText = new JLabel();
		validText.setForeground(Color.red);
		GridBagConstraints idValidTextGbc = this.getGbc(0, 2, 5, 1);
		idValidTextGbc.insets = new Insets(0, 10, 0, 10);
		panel.add(validText, idValidTextGbc);
		
		KeyAdapter keyAdapter = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String id = idText.getText();
				try {
					Integer.parseInt(id);
					validText.setText("");
				}catch(NumberFormatException ex) {
					validText.setText(ID_VALID_MSG);
				}
			}
			
		};
		this.idText.addKeyListener(keyAdapter);
		this.passwordText.addKeyListener(keyAdapter);
		
		this.cLogin = new CLogin();
		loginButton.addActionListener((e) -> {
			String id = this.idText.getText();
			String password = this.passwordText.getText();
			if(id.equals("")) {
				this.idText.requestFocus();
				this.idText.selectAll();
				validText.setText(this.ID_BLANK_MSG);
				return;
			}
			if(password.equals("")) {
				this.passwordText.requestFocus();
				this.passwordText.selectAll();
				validText.setText(this.PSWD_BLANK_MSG);
				return;
			}
			OLogin oLogin = new OLogin(id, password);
			OMember oMember = cLogin.validate(oLogin);
			System.out.println(oMember);
			
			if(oMember == null) {
				JOptionPane.showMessageDialog(null, "�α��� ����!");
				this.idText.requestFocus();
			}else {
				new VLogin();
				this.dispose();
				// return oMember;
			}
		});
		
		this.setVisible(true);
		
	}
	
	private GridBagConstraints getGbc(int x, int y) {
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = x;
		gbc.gridy = y;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.weightx = 1;
		gbc.weighty = 1;
		return gbc;
	}
	
	private GridBagConstraints getGbc(int x, int y, int width, int height) {
		GridBagConstraints gbc = this.getGbc(x, y);
		gbc.gridwidth = width;
		gbc.gridheight = height;
		gbc.fill = GridBagConstraints.BOTH;
		return gbc;
	}

}