package login_Sys;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class addInventory {

	JFrame frmAddInventory;
	
	private static String email;
	private JTextField txtSearch;
	private JTextField itemName;
	private JTextField brand;
	private JTextField description;
	private JTextField itemImage;
	private JTextField gender;
	private JTextField size;
	private JTextField price;
	private JTextField stock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addInventory window = new addInventory(email);
					window.frmAddInventory.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public addInventory(String email) {
		this.email = email;
		initialize();
	}

	public boolean isvalidstock( String textStock ) {
	    try {
	        Integer.parseInt( textStock );
	        return true;
	    }
	    catch( Exception e ) {
	        return false;
	    }
	}
	public boolean isvalidprice( String textPrice ) {
	    try {
	        Double.parseDouble(textPrice);
	        return true;
	    }
	    catch( Exception e ) {
	        return false;
	    }
	}
	public void nullify() {
		itemName.setText(null);
		brand.setText(null);
		description.setText(null);
		itemImage.setText(null);
		gender.setText(null);
		size.setText(null);
		price.setText("00.00");
		stock.setText(null);
	}
	private void addItemToDB() {
		YellowDB DB = new YellowDB();
		Item item = new Item();
		item.setItemName(itemName.getText());
		item.setBrand(brand.getText());
		item.setDescription(description.getText());
		item.setItemImage(itemImage.getText());
		item.setGender(gender.getText());
		item.setSize(size.getText());
		item.setPrice(Double.parseDouble(price.getText()));
		item.setStock(Integer.parseInt(stock.getText()));
		DB.addItemToDB(item);

	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddInventory = new JFrame("Yellow Shopping System");
		frmAddInventory.getContentPane().setBackground(Color.WHITE);
		frmAddInventory.setTitle("Add Inventory");
		frmAddInventory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddInventory.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmAddInventory.setSize(1000, 800);
		frmAddInventory.getContentPane().setLayout(null);
		JButton btnMens = new JButton("Men's");
		btnMens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAddInventory.dispose();
				mens men = new mens(email);
				men.getFrame().setVisible(true);
			}
		});
		btnMens.setBounds(35, 107, 77, 23);
		frmAddInventory.getContentPane().add(btnMens);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAddInventory.dispose();
				Login_S login = new Login_S();
				login.frmYellowShoppingSystem.setVisible(true);

			}
		});
		btnLogin.setBounds(814, 107, 89, 23);
		frmAddInventory.getContentPane().add(btnLogin);

		JButton btnWomens = new JButton("Women's");
		btnWomens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAddInventory.dispose();
				womens women = new womens(email);
				women.getFrame().setVisible(true);
			}
		});
		btnWomens.setBounds(122, 107, 89, 23);
		frmAddInventory.getContentPane().add(btnWomens);

		JButton btnShoppingCart = new JButton("Shopping Cart");
		btnShoppingCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAddInventory.dispose();
				Cart cart = new Cart(email);
				cart.frame.setVisible(true);
			}
		});
		btnShoppingCart.setBounds(589, 107, 116, 23);
		frmAddInventory.getContentPane().add(btnShoppingCart);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAddInventory.dispose();
				search srch = new search();
				srch.getFrame().setVisible(true);
			}
		});
		btnSearch.setBounds(456, 107, 89, 23);
		frmAddInventory.getContentPane().add(btnSearch);

		JButton btnCheckout = new JButton("Checkout");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAddInventory.dispose();
				CreditCard ccard = new CreditCard(email);
				ccard.frmCheckout.setVisible(true);
			}
		});
		btnCheckout.setBounds(715, 107, 89, 23);
		frmAddInventory.getContentPane().add(btnCheckout);

		txtSearch = new JTextField();
		txtSearch.setText("Enter Keyword");
		txtSearch.setBounds(221, 108, 225, 20);
		frmAddInventory.getContentPane().add(txtSearch);
		txtSearch.setColumns(10);

		JLabel lblYellowShoppingSystem = new JLabel("Yellow Shopping System");
		lblYellowShoppingSystem.setForeground(Color.WHITE);
		lblYellowShoppingSystem.setFont(new Font("Sitka Heading", Font.BOLD, 48));
		lblYellowShoppingSystem.setBounds(231, 0, 580, 137);
		frmAddInventory.getContentPane().add(lblYellowShoppingSystem);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 204, 204));
		panel.setBounds(0, 0, 1367, 137);
		frmAddInventory.getContentPane().add(panel);

		itemName = new JTextField();
		itemName.setBounds(335, 280, 273, 20);
		frmAddInventory.getContentPane().add(itemName);
		itemName.setColumns(10);

		brand = new JTextField();
		brand.setBounds(335, 311, 273, 20);
		frmAddInventory.getContentPane().add(brand);
		brand.setColumns(10);

		description = new JTextField();
		description.setBounds(335, 341, 273, 20);
		frmAddInventory.getContentPane().add(description);
		description.setColumns(10);

		itemImage = new JTextField();
		itemImage.setBounds(335, 372, 273, 20);
		frmAddInventory.getContentPane().add(itemImage);
		itemImage.setColumns(10);

		gender = new JTextField();
		gender.setBounds(335, 403, 46, 20);
		frmAddInventory.getContentPane().add(gender);
		gender.setColumns(10);

		size = new JTextField();
		size.setBounds(335, 434, 46, 20);
		frmAddInventory.getContentPane().add(size);
		size.setColumns(10);

		price = new JTextField();
		price.setText("00.00\r\n");
		price.setBounds(335, 465, 46, 20);
		frmAddInventory.getContentPane().add(price);
		price.setColumns(10);

		stock = new JTextField();
		stock.setBounds(335, 496, 46, 20);
		frmAddInventory.getContentPane().add(stock);
		stock.setColumns(10);

		JLabel lblAddInventory = new JLabel("Add Inventory");
		lblAddInventory.setFont(new Font("Sitka Heading", Font.PLAIN, 28));
		lblAddInventory.setBounds(335, 207, 174, 49);
		frmAddInventory.getContentPane().add(lblAddInventory);

		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setBounds(256, 283, 69, 14);
		frmAddInventory.getContentPane().add(lblItemName);

		JLabel lblBrand = new JLabel("Brand");
		lblBrand.setBounds(266, 314, 46, 14);
		frmAddInventory.getContentPane().add(lblBrand);

		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(256, 344, 69, 14);
		frmAddInventory.getContentPane().add(lblDescription);

		JLabel lblNewLabel = new JLabel("Image");
		lblNewLabel.setBounds(266, 375, 59, 14);
		frmAddInventory.getContentPane().add(lblNewLabel);

		JLabel lblSize = new JLabel("Gender");
		lblSize.setBounds(266, 406, 46, 14);
		frmAddInventory.getContentPane().add(lblSize);

		JLabel lblQty = new JLabel("QTY");
		lblQty.setBounds(276, 499, 49, 14);
		frmAddInventory.getContentPane().add(lblQty);

		JLabel lblSize_1 = new JLabel("  Size");
		lblSize_1.setBounds(266, 437, 46, 14);
		frmAddInventory.getContentPane().add(lblSize_1);

		JLabel lblPrice = new JLabel("  Price");
		lblPrice.setBounds(266, 468, 46, 14);
		frmAddInventory.getContentPane().add(lblPrice);

		JButton btnAddItemTo = new JButton("Add Item to Inventory");
		btnAddItemTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String textStock = stock.getText();
				String textPrice = price.getText();
				
				if (itemName.getText().trim().isEmpty() || brand.getText().trim().isEmpty()
						|| description.getText().trim().isEmpty() || itemImage.getText().trim().isEmpty()
						|| gender.getText().trim().isEmpty() || size.getText().trim().isEmpty()
						|| price.getText().trim().isEmpty() || stock.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill out required fields.", "Inventory Error",
							JOptionPane.ERROR_MESSAGE);
				}
				else if(isvalidstock(textStock)==false) {
					JOptionPane.showMessageDialog(null, "Please enter a valid value for for QTY", "Inventory Error",
							JOptionPane.ERROR_MESSAGE);
					
				}
				else if(isvalidprice(textPrice)==false) {
					JOptionPane.showMessageDialog(null, "Please enter a valid value for for PRICE", "Inventory Error",
							JOptionPane.ERROR_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Inventory Succesfully Added");
					addItemToDB();
					nullify();
				}
			}
		});
		btnAddItemTo.setBounds(335, 527, 170, 23);
		frmAddInventory.getContentPane().add(btnAddItemTo);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nullify();
			}
		});
		btnReset.setBounds(515, 527, 89, 23);
		frmAddInventory.getContentPane().add(btnReset);

	}
}