package login_Sys;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JCheckBox;

public class Cart extends JFrame{

	JFrame frame;
	private static String email;
	private JTextField txtSearch;
	final JTable table = new JTable();
	static double sum;
	static double price;
	static String total;
	final String imagePath = "C:/Users/kevin/eclipse-workspace/YellowShoppingCatalog/images/items/";

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
		DefaultTableModel model = new DefaultTableModel(){
			public Class <?> getColumnClass(int column){
				switch(column) {
				case 0:
					return String.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				case 3:
					return ImageIcon.class;
				case 4:
					return String.class;
				case 5:
					return String.class;
				case 6:
					return String.class;
				case 7:
					return Boolean.class;
					
					default: 
						return String.class;
				}
				
			}
		};

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
		table.setRowHeight(100);
		table.setModel(model);
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Brand");
		model.addColumn("Image");
		model.addColumn("Gender");
		model.addColumn("Size");
		model.addColumn("Price");
		model.addColumn("Remove");
		try {
//			DB.add("name2","brand","description","image","gender","size","3.25","stock"); //adds new values to columns.
			//number needs to match YellowDB line 244. name needs to be unique
			//use this code to test the data. can probably re use the DB.add for the product page.
			
			
			List<Item> items = DB.getShoppingCart(email);		
			for(int i = 0; i < items.size(); i++) {
				Item item = items.get(i);
				System.out.println(item.getItemName());
				model.addRow(new Object[0]);
				model.setValueAt(item.getId(),i,0);
				model.setValueAt(item.getItemName(),i,1);
				model.setValueAt(item.getBrand(), i, 2);
				Image im = null;
				try {
					im = ImageIO.read(new File(imagePath + item.getItemImage()));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				im = im.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
				model.setValueAt(new ImageIcon(im), i, 3);
				model.setValueAt(item.getGender(), i, 4);
				model.setValueAt(item.getSize(), i, 5);
				model.setValueAt(item.getPrice(), i, 6);
				model.setValueAt(false, i, 7);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(83, 203, 798, 423); // used for the names of the columns
		frame.getContentPane().add(scrollPane);
		
		//Gray table looked weird this code changes that.
		table.setBackground(Color.white);
		table.setOpaque(true);
		scrollPane.setBackground(Color.white);
		scrollPane.setOpaque(true);
		scrollPane.getVerticalScrollBar().setBackground(new Color(51, 204, 204));
		
		JButton btnRemove = new JButton("Remove Selected Items");
		btnRemove.setBounds(231, 685, 184, 29);
		frame.getContentPane().add(btnRemove);
		frame.setVisible(true);
		
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<table.getRowCount();i++) {
					Boolean checked = Boolean.valueOf(table.getValueAt(i, 7).toString());
					String id = table.getValueAt(i, 0).toString();
					if(checked) {
						DB.remove(id,email);
						System.out.println("item removed: " + id);
					}
				}
				Cart cart = new Cart(email);
				frame.dispose();
				cart.frame.setVisible(true);
			}
		});
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(687, 685, 117, 29);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				CreditCard creditCard = new CreditCard(email);
				creditCard.frmCheckout.setVisible(true);
			}
		});
		frame.getContentPane().add(btnConfirm);

		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(687, 653, 61, 16);
		frame.getContentPane().add(lblTotal);

		for (int i = 0; i < table.getRowCount(); i++) { // Adds the prices together
			sum = sum + (double)table.getValueAt(i, 6); // changes string to double so it can be added
		}
		total = Double.toString(sum); // converts double to string
		sum = 0;

		JTextArea txtrS = new JTextArea();
		txtrS.setText("$ ");
		txtrS.append(total); // prints string into GUI
		txtrS.setBounds(710, 531, 61, 16);
		frame.getContentPane().add(txtrS);
		
		

	}
}