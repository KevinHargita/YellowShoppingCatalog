package login_Sys;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class deleteInventory {
	JFrame frmDeleteInventory;
	private JTextField txtSearch;
	private static String email;
	JScrollPane scrollPane;
	final JTable table = new JTable();
	final String imagePath = "C:/Users/kevin/eclipse-workspace/YellowShoppingCatalog/images/items/";


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteInventory window = new deleteInventory(email);
					window.frmDeleteInventory.setVisible(true);
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
	public deleteInventory(String email) {
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
					return String.class;
				case 4:
					return ImageIcon.class;
				case 5:
					return String.class;
				case 6:
					return Double.class;
				case 7:
					return Integer.class;
				case 8:
					return Boolean.class;
					
					default: 
						return String.class;
				}
				
			}
		};

		frmDeleteInventory = new JFrame("Yellow Shopping System");
		frmDeleteInventory.setSize(1000, 800);
		frmDeleteInventory.getContentPane().setBackground(Color.WHITE);
		frmDeleteInventory.setTitle("Shopping Cart");
		frmDeleteInventory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDeleteInventory.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmDeleteInventory.getContentPane().setLayout(null);
		
		JButton btnMens = new JButton("Men's");
		btnMens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDeleteInventory.dispose();
				mens men = new mens(email);
				men.getFrame().setVisible(true);
			}
		});
		btnMens.setBounds(35, 107, 77, 23);
		frmDeleteInventory.getContentPane().add(btnMens);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDeleteInventory.dispose();
				Login_S login = new Login_S();
				login.frmYellowShoppingSystem.setVisible(true);

			}
		});
		btnLogin.setBounds(814, 107, 89, 23);
		frmDeleteInventory.getContentPane().add(btnLogin);

		JButton btnWomens = new JButton("Women's");
		btnWomens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDeleteInventory.dispose();
				womens women = new womens(email);
				women.getFrame().setVisible(true);
			}
		});
		btnWomens.setBounds(122, 107, 89, 23);
		frmDeleteInventory.getContentPane().add(btnWomens);

		JButton btnCart = new JButton("Home");
		btnCart.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				frmDeleteInventory.dispose();
				Home Home = new Home(email);
				Home.frame.setVisible(true);
			}
		});
		btnCart.setBounds(589, 107, 116, 23);
		frmDeleteInventory.getContentPane().add(btnCart);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDeleteInventory.dispose();
				search srch = new search();
				srch.getFrame().setVisible(true);
			}
		});
		btnSearch.setBounds(456, 107, 89, 23);
		frmDeleteInventory.getContentPane().add(btnSearch);

		JButton btnCheckout = new JButton("Checkout");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDeleteInventory.dispose();
				CreditCard ccard = new CreditCard(email);
				ccard.frmCheckout.setVisible(true);
			}
		});
		btnCheckout.setBounds(715, 107, 89, 23);
		frmDeleteInventory.getContentPane().add(btnCheckout);

		txtSearch = new JTextField();
		txtSearch.setText("Enter Keyword");
		txtSearch.setBounds(221, 108, 225, 20);
		frmDeleteInventory.getContentPane().add(txtSearch);
		txtSearch.setColumns(10);

		JLabel lblYellowShoppingSystem = new JLabel("Yellow Shopping System");
		lblYellowShoppingSystem.setForeground(Color.WHITE);
		lblYellowShoppingSystem.setFont(new Font("Sitka Heading", Font.BOLD, 48));
		lblYellowShoppingSystem.setBounds(231, 0, 580, 137);
		frmDeleteInventory.getContentPane().add(lblYellowShoppingSystem);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 204, 204));
		panel.setBounds(0, 0, 1367, 137);
		frmDeleteInventory.getContentPane().add(panel);
		table.setRowSelectionAllowed(false);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		

		 // needs set size. test only changes these sections. I need to make max cart size
				
		
		// to test and see what value will be added into the cart. can be implemented in the product page
		table.setRowHeight(100);
		table.setModel(model);
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Brand");
		model.addColumn("Description");
		model.addColumn("Image");
		model.addColumn("Gender");
		model.addColumn("Price");
		model.addColumn("Stock");
		model.addColumn("Delete");
		List<Item> items = DB.getAllItems();		
		for(int i = 0; i < items.size(); i++) {
			Item item = items.get(i);
			System.out.println(item.getItemName());
			model.addRow(new Object[0]);
			model.setValueAt(item.getId(),i,0);
			model.setValueAt(item.getItemName(),i,1);
			model.setValueAt(item.getBrand(), i, 2);
			model.setValueAt(item.getDescription(), i, 3);
			Image im = null;
			try {
				im = ImageIO.read(new File(imagePath + item.getItemImage()));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			im = im.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
			model.setValueAt(new ImageIcon(im), i, 4);
			model.setValueAt(item.getGender(), i, 5);
			model.setValueAt(item.getPrice(), i, 6);
			model.setValueAt(item.getStock(), i, 7);
			model.setValueAt(false, i, 8);
		}

		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(97, 203, 780, 446); // used for the names of the columns
		frmDeleteInventory.getContentPane().add(scrollPane);
		
		//Gray table looked weird this code changes that.
				table.setBackground(Color.white);
				table.setOpaque(true);
				scrollPane.setBackground(Color.white);
				scrollPane.setOpaque(true);
				scrollPane.getVerticalScrollBar().setBackground(new Color(51, 204, 204));
		
		JButton btnDelete = new JButton("Delete Item From Catalog");
		btnDelete.setBounds(353, 680, 273, 29);
		frmDeleteInventory.getContentPane().add(btnDelete);
		frmDeleteInventory.setVisible(true);
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<table.getRowCount();i++) {
					Boolean checked = Boolean.valueOf(table.getValueAt(i, 8).toString());
					String id = table.getValueAt(i, 0).toString();
					if(checked) {
						DB.deleteItemFromDB(Integer.parseInt(id));
						System.out.println("item removed: " + id);
					}
				}
				deleteInventory window = new deleteInventory(email);
				frmDeleteInventory.dispose();
				window.frmDeleteInventory.setVisible(true);
			}
		});
		

		
		

	}
}
