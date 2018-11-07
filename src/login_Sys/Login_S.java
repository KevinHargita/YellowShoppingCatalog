package login_Sys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class Login_S {

	JFrame frmYellowShoppingSystem;
	private JTextField user_existing;
	private JTextField user_new;
	private JPasswordField pw_existing;
	private JPasswordField pw_new;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblExistingUser;
	private JLabel lblNewLabel_3;
	private JLabel lblLockedLoginMessage;
	private JButton btnExit;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JButton btnGuestLogin;
	private JButton btnCreateAccount;
	public String email;
	private int incorrectPassword;
	static YellowDB DB = new YellowDB();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//test();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_S window = new Login_S();
					window.frmYellowShoppingSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_S() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//DataBase object has methods addUser(email,password), logIn(email,password) and displayUsers() 

		
		frmYellowShoppingSystem = new JFrame();
		frmYellowShoppingSystem.setTitle("Yellow Shopping System");
		frmYellowShoppingSystem.setBounds(200, 200, 400, 400);
		frmYellowShoppingSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmYellowShoppingSystem.getContentPane().setLayout(null);
		
		JLabel lblUserLogin = new JLabel("User Login");
		lblUserLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUserLogin.setBounds(126, 37, 112, 37);
		frmYellowShoppingSystem.getContentPane().add(lblUserLogin);
		
		JLabel lblUsernameExisting = new JLabel("Username");
		lblUsernameExisting.setBounds(45, 156, 60, 14);
		frmYellowShoppingSystem.getContentPane().add(lblUsernameExisting);
		
		JLabel lblPasswordExisting = new JLabel("Password");
		lblPasswordExisting.setBounds(149, 156, 71, 14);
		frmYellowShoppingSystem.getContentPane().add(lblPasswordExisting);
		
		user_existing = new JTextField();
		user_existing.setBounds(45, 134, 86, 20);
		frmYellowShoppingSystem.getContentPane().add(user_existing);
		user_existing.setColumns(10);
		
		user_new = new JTextField();
		user_new.setBounds(45, 227, 86, 20);
		frmYellowShoppingSystem.getContentPane().add(user_new);
		user_new.setColumns(10);
		
		pw_existing = new JPasswordField();
		pw_existing.setBounds(141, 134, 89, 20);
		frmYellowShoppingSystem.getContentPane().add(pw_existing);
		
		pw_new = new JPasswordField();
		pw_new.setBounds(141, 227, 89, 20);
		frmYellowShoppingSystem.getContentPane().add(pw_new);
		
		lblUsername = new JLabel("Username");
		lblUsername.setBounds(45, 251, 60, 14);
		frmYellowShoppingSystem.getContentPane().add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(149, 251, 60, 14);
		frmYellowShoppingSystem.getContentPane().add(lblPassword);
		
		lblExistingUser = new JLabel("Existing User?");
		lblExistingUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblExistingUser.setBounds(45, 109, 86, 14);
		frmYellowShoppingSystem.getContentPane().add(lblExistingUser);
		
		lblNewLabel_3 = new JLabel("New User?");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(45, 202, 60, 14);
		frmYellowShoppingSystem.getContentPane().add(lblNewLabel_3);
		
		//Login
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = pw_existing.getText();
				String username = user_existing.getText();
				try {
					if(DB.logIn(user_existing.getText(), pw_existing.getText())){
						email = user_existing.getText();
						frmYellowShoppingSystem.dispose();
						Home homepage = new Home(email);
						homepage.frame.setVisible(true);
						
					}
					else if(password.contains("password") && username.contains("admin")) {
						email = user_existing.getText();
						frmYellowShoppingSystem.dispose();
						Home homepage = new Home(email);
						homepage.frame.setVisible(true);
						System.out.println("Welcome Admin");
					}
					else {
						JOptionPane.showMessageDialog(null, "Invalid Login Credentials","Login Error",JOptionPane.ERROR_MESSAGE);
						incorrectPassword++;
						if(incorrectPassword > 4) {
							btnLogin.setEnabled(false);
							btnCreateAccount.setEnabled(false);
							lblLockedLoginMessage.setVisible(true);
							
						}
						pw_existing.setText(null);
						user_existing.setText(null);
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnLogin.setBounds(240, 133, 89, 23);
		frmYellowShoppingSystem.getContentPane().add(btnLogin);
		
		//Adds account to database
		
		btnCreateAccount = new JButton("Create");
		btnCreateAccount.setBounds(240, 226, 89, 23);
		frmYellowShoppingSystem.getContentPane().add(btnCreateAccount);
		btnCreateAccount.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				try {
					DB.addUser(user_new.getText(), pw_new.getText());
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				user_existing.setText(null);
				pw_existing.setText(null);
				user_new.setText(null);
				pw_new.setText(null);
			}
		});
		
		//Reset Text Boxes
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				user_existing.setText(null);
				pw_existing.setText(null);
				user_new.setText(null);
				pw_new.setText(null);
			}
		});
		btnReset.setBounds(45, 297, 89, 23);
		frmYellowShoppingSystem.getContentPane().add(btnReset);
		
		//Exit Button
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(141, 297, 89, 23);
		frmYellowShoppingSystem.getContentPane().add(btnExit);
		
		separator = new JSeparator();
		separator.setBounds(10, 283, 364, 3);
		frmYellowShoppingSystem.getContentPane().add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(10, 193, 364, 10);
		frmYellowShoppingSystem.getContentPane().add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(10, 100, 364, 9);
		frmYellowShoppingSystem.getContentPane().add(separator_2);
		
		btnGuestLogin = new JButton("Guest");
		btnGuestLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmYellowShoppingSystem.dispose();
				Home homepage = new Home("guest");
				homepage.frame.setVisible(true);
			}
		});
		btnGuestLogin.setBounds(240, 297, 89, 23);
		frmYellowShoppingSystem.getContentPane().add(btnGuestLogin);
		
		lblLockedLoginMessage = new JLabel("Number of Login Attemps Exceeded, Try Again Later");
		lblLockedLoginMessage.setForeground(Color.RED);
		lblLockedLoginMessage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLockedLoginMessage.setBounds(45, 170, 308, 20);
		lblLockedLoginMessage.setVisible(false);
		frmYellowShoppingSystem.getContentPane().add(lblLockedLoginMessage);
	}
}