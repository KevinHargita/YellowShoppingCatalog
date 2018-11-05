package login_Sys;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.sql.SQLException;
import java.util.List;

public class Cart {

	JFrame frame;
	private static String email;
	private JTextField txtSearch;
	private JTable table;
	static double sum;
	static double price;
	static String total;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cart window = new Cart(email);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	@SuppressWarnings("static-access")
	public Cart(String email) {
		this.email = email;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		YellowDB DB = new YellowDB();

		frame = new JFrame("Yellow Shopping System");
		frame.setSize(1000, 800);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setTitle("Shopping Cart");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setLayout(null);
		
		JButton btnMens = new JButton("Men's");
		btnMens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				mens men = new mens(email);
				men.getFrame().setVisible(true);
			}
		});
		btnMens.setBounds(35, 107, 77, 23);
		frame.getContentPane().add(btnMens);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login_S login = new Login_S();
				login.frmYellowShoppingSystem.setVisible(true);

			}
		});
		btnLogin.setBounds(814, 107, 89, 23);
		frame.getContentPane().add(btnLogin);

		JButton btnWomens = new JButton("Women's");
		btnWomens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				womens women = new womens(email);
				women.getFrame().setVisible(true);
			}
		});
		btnWomens.setBounds(122, 107, 89, 23);
		frame.getContentPane().add(btnWomens);

		JButton btnCart = new JButton("Home");
		btnCart.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Home Home = new Home(email);
				Home.frame.setVisible(true);
			}
		});
		btnCart.setBounds(589, 107, 116, 23);
		frame.getContentPane().add(btnCart);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				search srch = new search();
				srch.getFrame().setVisible(true);
			}
		});
		btnSearch.setBounds(456, 107, 89, 23);
		frame.getContentPane().add(btnSearch);

		JButton btnCheckout = new JButton("Checkout");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				CreditCard ccard = new CreditCard(email);
				ccard.frmCheckout.setVisible(true);
			}
		});
		btnCheckout.setBounds(715, 107, 89, 23);
		frame.getContentPane().add(btnCheckout);

		txtSearch = new JTextField();
		txtSearch.setText("Enter Keyword");
		txtSearch.setBounds(221, 108, 225, 20);
		frame.getContentPane().add(txtSearch);
		txtSearch.setColumns(10);

		JLabel lblYellowShoppingSystem = new JLabel("Yellow Shopping System");
		lblYellowShoppingSystem.setForeground(Color.WHITE);
		lblYellowShoppingSystem.setFont(new Font("Sitka Heading", Font.BOLD, 48));
		lblYellowShoppingSystem.setBounds(231, 0, 580, 137);
		frame.getContentPane().add(lblYellowShoppingSystem);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 204, 204));
		panel.setBounds(0, 0, 1367, 137);
		frame.getContentPane().add(panel);

		 // needs set size. test only changes these sections. I need to make max cart size
				
		
		// to test and see what value will be added into the cart. can be implemented in the product page
		Object[][] data = null;
		try {
//			DB.add("name2","brand","description","image","gender","size","3.25","stock"); //adds new values to columns.
			//number needs to match YellowDB line 244. name needs to be unique
			//use this code to test the data. can probably re use the DB.add for the product page.
			
			
			DB.displayTable();
			List<Item> items = DB.getShoppingCart(email);
			data = new Object[items.size()][7];
			
			
			for(int i = 0; i < items.size(); i++) {
				Item item = items.get(i);
				data[i][0]=item.getId();
				data[i][1]=item.getItemName();
				data[i][2]=item.getItemImage();
				data[i][3]=item.getGender();
				data[i][4]=item.getSize();
				data[i][5]=item.getPrice();
				data[i][6]=false;
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Column Names
		String[] columnNames = { "ID", "Name", "Image", "Gender", "Size", "Price", "Boolean" };

		table = new JTable(data, columnNames); // used for listing the items
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(235, 203, 574, 309); // used for the names of the columns
		frame.getContentPane().add(scrollPane);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(715, 587, 117, 29);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				CreditCard creditCard = new CreditCard(email);
				creditCard.frmCheckout.setVisible(true);
			}
		});
		frame.getContentPane().add(btnConfirm);

		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(660, 531, 61, 16);
		frame.getContentPane().add(lblTotal);

		for (int i = 0; i < data.length; i++) { // Adds the prices together
			sum = sum + (double)data[i][5]; // changes string to double so it can be added
		}
		total = Double.toString(sum); // converts double to string
		sum = 0;

		JTextArea txtrS = new JTextArea();
		txtrS.setText("$ ");
		txtrS.append(total); // prints string into GUI
		txtrS.setBounds(710, 531, 61, 16);
		frame.getContentPane().add(txtrS);
		frame.setVisible(true);

	}
}