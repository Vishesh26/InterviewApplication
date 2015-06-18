import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class LoginWindow {

	static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	private JTextField UsernametextField;
	private JPasswordField passwordField;
	private JButton btnLogin;
	private JButton btnNewButton;
	/**
	 * Create the application.
	 */
	public LoginWindow() {
		initialize();
		connection = Connectionclass.Connect();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 588, 322);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setTitle("Login Page");
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(94, 39, 106, 39);
		frame.getContentPane().add(lblUsername);
		
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(94, 106, 75, 29);
		frame.getContentPane().add(lblPassword);
		
		UsernametextField = new JTextField();
		UsernametextField.setBackground(Color.WHITE);
		UsernametextField.setForeground(Color.BLACK);
		UsernametextField.setBounds(212, 50, 207, 22);
		frame.getContentPane().add(UsernametextField);
		UsernametextField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(212, 109, 207, 22);
		frame.getContentPane().add(passwordField);
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try
				{
					String query = "SELECT * FROM UserTable WHERE Username = ? AND Password = ?";
			        PreparedStatement ps = connection.prepareStatement(query);
			        ps.setString(1, UsernametextField.getText());
			        ps.setString(2, passwordField.getText());
			        ps.executeQuery();
			        ResultSet rs = ps.executeQuery();
					int count =0;
					while(rs.next())
					{
						count++;
						
					}
					if(count==1) {
						JOptionPane.showMessageDialog(null, "Username and Password is correct");
						frame.dispose();
						AdminWindow ad = new AdminWindow();
						ad.setVisible(true);
					}
					
					
					else if(count>1) {
						
						JOptionPane.showMessageDialog(null, "Duplicate Username and Password ");
						UsernametextField.setBackground(Color.RED);
						passwordField.setBackground(Color.RED);
					
					}
					
					else JOptionPane.showMessageDialog(null, "Username or Password is incorrect.Try Again.");
				
					rs.close();
					ps.close();
					}	
				
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex);
					
				}
				finally{
					try
					{
					
						 
					}	
					
					catch(Exception ex)
					{
						
						
						 JOptionPane.showMessageDialog(null, ex);
						
					}
				
				}
				}
		});
		btnLogin.setBounds(111, 182, 140, 50);
		frame.getContentPane().add(btnLogin);
		
		btnNewButton = new JButton("Cancel");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
			}
		});
		btnNewButton.setBounds(314, 182, 154, 50);
		frame.getContentPane().add(btnNewButton);
	}
}
