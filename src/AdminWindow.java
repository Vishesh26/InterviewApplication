
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JComboBox;


public class AdminWindow extends JFrame {

	private JPanel contentPane;
	JPanel panel_1;
	JPanel panel_2;
	JPanel panel_3;
	static AdminWindow frame = new AdminWindow();
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	
	JLabel lblNewLabel_6 = null;

	/**
	 * Launch the application.
	 */
	public static void Admin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	/**
	 * Create the frame.
	 */
	Connection connectQ = null;
	
	public AdminWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		connection = Connectionclass.Connect();
		connectQ = ConnectToQuestion.ConnectToQues();
		setTitle("Admin ");
		setBounds(100, 100, 691, 385);
		contentPane = new JPanel();
		contentPane.setToolTipText("Admin ");
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		
		 final JPanel panel = new JPanel();
		panel.setToolTipText("");
		
		panel.setForeground(new Color(255, 102, 51));
		contentPane.add(panel, "name_189122423308984");
		panel.setLayout(null);
		
		JLabel lblHelloAdmin = new JLabel("Hello Admin!!");
		lblHelloAdmin.setForeground(new Color(255, 0, 51));
		lblHelloAdmin.setFont(new Font("Verdana", Font.PLAIN, 25));
		lblHelloAdmin.setBounds(40, 23, 197, 23);
		panel.add(lblHelloAdmin);
		
		JLabel lblNewLabel = new JLabel("Please Select a task to perform.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(182, 114, 353, 39);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add Question");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					
					
					panel.setVisible(false);
					panel_1.setVisible(true);
					
				}	
				
				catch(Exception ex)
				{
					
					
					 JOptionPane.showMessageDialog(null, ex);
					 
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(40, 220, 154, 52);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add Account");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel.setVisible(false);
				panel_2.setVisible(true);
				
				
			}
		});
		btnNewButton_1.setBounds(259, 220, 154, 52);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Add test");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_3.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setBounds(473, 220, 128, 52);
		panel.add(btnNewButton_2);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				dispose();
				//LoginWindow.frame.setVisible(true);
				new LoginWindow();
				LoginWindow.frame.setVisible(true);
			}
		});
		btnLogout.setBounds(519, 22, 103, 52);
		panel.add(btnLogout);
		
		
		 panel_1 = new JPanel();
		contentPane.add(panel_1, "name_189128427781817");
		panel_1.setLayout(null);
		
		JFilePicker filePicker = new JFilePicker("Pick a file", "Browse...");
        filePicker.setMode(JFilePicker.MODE_SAVE);
        filePicker.addFileTypeFilter(".jpg", "JPEG Images");
        filePicker.addFileTypeFilter(".mp4", "MPEG-4 Videos");
         
        // access JFileChooser class directly
        JFileChooser fileChooser = filePicker.getFileChooser();
        fileChooser.setCurrentDirectory(new File("C:/"));
         
        // add the component to the frame
        filePicker.setBounds(24,131, 579, 70);
        panel_1.add(filePicker);
		
		JLabel lblPleaseProvideThe_1 = new JLabel("Please provide the path to the Question file");
		lblPleaseProvideThe_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPleaseProvideThe_1.setBounds(87, 57, 470, 25);
		panel_1.add(lblPleaseProvideThe_1);
		
		JButton btnAddToThe = new JButton("Add to the List");
		btnAddToThe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BufferedReader br = null;
				try
				{   String path = JFilePicker.textField.getText();
					String query = "INSERT INTO QA (Subject,Question,OptionA,OptionB ,OptionC,OptionD,Answer,SubID) VALUES (?,?,?,?,?,?,?,?)";
			        PreparedStatement ps = connectQ.prepareStatement(query);
			        String read=null;
			        BufferedReader in = new BufferedReader(new FileReader(path));
			        while ((read = in.readLine()) != null) {
			            String[] splited = read.split("\\|");
			            
			            ps.setString(1, splited[0]);
			            ps.setString(2, splited[1]);
			            ps.setString(3, splited[2]);
			            ps.setString(4, splited[3]);
			            ps.setString(5, splited[4]);
			            ps.setString(6, splited[5]);
			            ps.setString(7, splited[6]);
			            ps.setInt(8, Integer.parseInt(splited[7]));
			            
			            ps.execute();
			        }
			        
			        
			   //    ps.execute();
			        JOptionPane.showMessageDialog(null, "Questions Added");
			        in.close();
					ps.close();
					

				}	
				
				catch(Exception ex)
				{
					
					
					 JOptionPane.showMessageDialog(null, ex);
					 
				}
				
			}
		});
		btnAddToThe.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnAddToThe.setBounds(227, 225, 164, 52);
		panel_1.add(btnAddToThe);
		
		 panel_2 = new JPanel();
		contentPane.add(panel_2, "name_189130971178791");
		panel_2.setLayout(null);
		
		JLabel lblPleaseProvideThe = new JLabel("Please provide the details of the account to be added");
		lblPleaseProvideThe.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblPleaseProvideThe.setBounds(77, 24, 561, 31);
		panel_2.add(lblPleaseProvideThe);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(150, 86, 79, 31);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(150, 146, 79, 16);
		panel_2.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(307, 91, 176, 22);
		panel_2.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(307, 144, 176, 22);
		panel_2.add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("Confirm Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(150, 195, 160, 31);
		panel_2.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(307, 200, 176, 22);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Save");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					String s1 = passwordField.getText();
					String s2 = textField_1.getText();
					
					
					if( !s1.equals(s2)) 
					{
						JOptionPane.showMessageDialog(null, "Password does not match.Confirm Password");
						
						textField_1.setBackground(Color.RED);
						passwordField.setBackground(Color.RED);
					}
					
					else{	
					String query = "INSERT INTO UserTable (Username,Password) VALUES (?,?)";
			        PreparedStatement ps = connection.prepareStatement(query);
			        ps.setString(1, textField.getText());
			        ps.setString(2, passwordField.getText());
			        ps.execute();
			  
			        JOptionPane.showMessageDialog(null,"Account Created");
					ps.close();
					}
						
					}
					
					
					
				
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex);
					
				}
			
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_3.setBounds(293, 270, 97, 39);
		panel_2.add(btnNewButton_3);
		
		 panel_3 = new JPanel();
		contentPane.add(panel_3, "name_626448314993969");
		panel_3.setLayout(null);
		
		JLabel lblPleaseProvideBelow = new JLabel("Please provide below details to prepare test.");
		lblPleaseProvideBelow.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPleaseProvideBelow.setBounds(39, 27, 421, 25);
		panel_3.add(lblPleaseProvideBelow);
		
		String[] array = {"1","2","3","4","5","6","7","8","9","10"};
		final JComboBox comboBox = new JComboBox(array);
		
		comboBox.setMaximumRowCount(10);
		comboBox.setEditable(true);
		comboBox.setBounds(117, 114, 42, 25);
	
		panel_3.add(comboBox);
		
		JLabel lblChooseNoOf = new JLabel("Choose no. of questions in category");
		lblChooseNoOf.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblChooseNoOf.setBounds(39, 79, 363, 16);
		panel_3.add(lblChooseNoOf);
		
		JLabel lblNewLabel_3 = new JLabel("Java");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(49, 117, 56, 16);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("SQL");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(233, 117, 56, 16);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Python");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(388, 117, 93, 16);
		panel_3.add(lblNewLabel_5);
		
		
		
		final JComboBox comboBox_1 = new JComboBox(array);
		comboBox_1.setMaximumRowCount(10);
		comboBox_1.setEditable(true);
		comboBox_1.setBounds(288, 114, 42, 24);
		
		
		panel_3.add(comboBox_1);
		final int DEFAULT_SIZE = 12;
		
		
		
	
		
		final JComboBox comboBox_2 = new JComboBox(array);
		comboBox_2.setMaximumRowCount(10);
          panel_3.add(comboBox_2);
		
		
		
          comboBox.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				
  				int i = Integer.parseInt(comboBox_1.getSelectedItem().toString()) + 
  						Integer.parseInt(comboBox_2.getSelectedItem().toString()) + 
  						Integer.parseInt(comboBox.getSelectedItem().toString());

  						 String s = Integer.toString(i);
  				        lblNewLabel_6.setText(s);
  			}
  		});	


          comboBox_1.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				
    				int i = Integer.parseInt(comboBox_1.getSelectedItem().toString()) + 
    						Integer.parseInt(comboBox_2.getSelectedItem().toString()) + 
    						Integer.parseInt(comboBox.getSelectedItem().toString());

    						 String s = Integer.toString(i);
    				        lblNewLabel_6.setText(s);
    			}
    		});
          
          
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
					
				
				
				 int i = Integer.parseInt(comboBox_1.getSelectedItem().toString()) + 
						Integer.parseInt(comboBox_2.getSelectedItem().toString()) + 
						Integer.parseInt(comboBox.getSelectedItem().toString());

						 String s = Integer.toString(i);
				        lblNewLabel_6.setText(s);
				        
				
				
				
			}
		});
		comboBox_2.setEditable(true);
		comboBox_2.setBounds(479, 114, 42, 25);
		
		
		
		
	    lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(247, 177, 84, 16);
		
		panel_3.add(lblNewLabel_6);
		
		JLabel lblTotalQuestionsSelected = new JLabel("Total Questions Selected:");
		lblTotalQuestionsSelected.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotalQuestionsSelected.setBounds(49, 177, 201, 16);
		panel_3.add(lblTotalQuestionsSelected);
	}
}
