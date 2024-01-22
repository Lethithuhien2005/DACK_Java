package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class AdminView extends JFrame {
	
	private JPanel jPanel1;
	private JLabel jLabel_img;
	private JPanel jPanel_img;
	private JLabel jLabel_account;
	private JTextField jTextField_account;
	private JLabel jLabel_pass;
	private JPanel jPanel_Input;
	private JButton jButton_logIn;
	private JPasswordField jPasswordField;
	private JCheckBox jCheckBox_showPass;
	private JLabel jLabel_showPass;
	private JLabel jLabel;

	public AdminView() {
	
		this.setTitle("Log In");
		this.setSize(480, 180);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(Toolkit.getDefaultToolkit().createImage(AdminView.class.getResource("LogIn.png")));
		
		Font font = new Font("Arial", Font.BOLD, 15);
		
		jPanel1 = new JPanel();
		
		jLabel_img = new JLabel();
		jLabel_img.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(AdminView.class.getResource("User2.png"))));
		
		jPanel_img = new JPanel();
		jPanel_img.setLayout(new FlowLayout());
		jPanel_img.add(jLabel_img);

		jLabel_account = new JLabel("Account", jLabel_account.RIGHT);
		jLabel_account.setFont(font);
		jTextField_account = new JTextField(10);
		jTextField_account.setFont(font);
		jLabel_pass = new JLabel("Password", jLabel_pass.RIGHT);
		jLabel_pass.setFont(font);
		jPasswordField = new JPasswordField(10);
		jPasswordField.setFont(font);
		jCheckBox_showPass = new JCheckBox("Show password");
		jCheckBox_showPass.setFont(font);
		jCheckBox_showPass.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jCheckBox_showPass.isSelected()) {
					jPasswordField.setEchoChar((char)0);
				} else {
					jPasswordField.setEchoChar('*');
				}
			}
		});
		jLabel = new JLabel(""); 
		
		jPanel_Input = new JPanel();
		jPanel_Input.setLayout(new GridLayout(3,2, 10, 10));
		jPanel_Input.add(jLabel_account);
		jPanel_Input.add(jTextField_account);
		jPanel_Input.add(jLabel_pass);
		jPanel_Input.add(jPasswordField);
		jPanel_Input.add(jCheckBox_showPass);
		jPanel_Input.add(jLabel);
		
		jPanel1.setLayout(new FlowLayout());
		jPanel1.add(jLabel_img);
		jPanel1.add(jPanel_Input);
		
		jButton_logIn = new JButton("Log in");
		jButton_logIn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String click = e.getActionCommand();
				String nameAccount = "lethithuhien";
				String pass = "123456789";
				if (jTextField_account.getText().equals(nameAccount) && jPasswordField.getText().equals(pass)) {
					if (click.equals("Log in")) {
							new HomePageView();
						}
				} else {
					if (click.equals("Log in")) {
						JOptionPane.showMessageDialog(rootPane, "Account is invalid!", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		jButton_logIn.setFont(font);
		jButton_logIn.setForeground(Color.BLUE);
		
		JPanel jPanel2 = new JPanel();
		jPanel2.add(jButton_logIn);	
		
		
		this.setLayout(new BorderLayout());
		this.add(jPanel1, BorderLayout.CENTER);
		this.add(jPanel2, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}

		public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new AdminView();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
