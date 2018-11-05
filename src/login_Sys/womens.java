package login_Sys;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class womens {

	private JFrame frmWomensClothing;
	private static String email;
	private JTextField txtSearch;
	private String imagePath = "C:/Users/kevin/eclipse-workspace/YellowShoppingCatalog/images/";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					womens window = new womens(email);
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public womens(String email) {
		this.email = email;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWomensClothing = new JFrame("Yellow Shopping System");
		frmWomensClothing.getContentPane().setBackground(Color.WHITE);
		frmWomensClothing.setTitle("Women's Clothing");
		frmWomensClothing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWomensClothing.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmWomensClothing.setSize(1000, 800);
		frmWomensClothing.getContentPane().setLayout(null);
		ImageIcon womenshirts = new ImageIcon(imagePath + "wshirt.jpg");
		ImageIcon wpants = new ImageIcon(imagePath + "wpants.jpg");

		JButton btnHome = new JButton("Home\r\n");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmWomensClothing.dispose();
				Home hpage = new Home(email);
				hpage.frame.setVisible(true);
			}
		});
		btnHome.setBounds(35, 107, 77, 23);
		frmWomensClothing.getContentPane().add(btnHome);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmWomensClothing.dispose();
				Login_S login = new Login_S();
				login.frmYellowShoppingSystem.setVisible(true);

			}
		});
		btnLogin.setBounds(814, 107, 89, 23);
		frmWomensClothing.getContentPane().add(btnLogin);

		JButton btnMens = new JButton("Men's");
		btnMens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmWomensClothing.dispose();
				mens men = new mens(email);
				men.getFrame().setVisible(true);
			}
		});
		btnMens.setBounds(122, 107, 89, 23);
		frmWomensClothing.getContentPane().add(btnMens);

		JButton btnShoppingCart = new JButton("Shopping Cart");
		btnShoppingCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmWomensClothing.dispose();
				Cart cart = new Cart(email);
				cart.frame.setVisible(true);
			}
		});
		btnShoppingCart.setBounds(589, 107, 116, 23);
		frmWomensClothing.getContentPane().add(btnShoppingCart);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmWomensClothing.dispose();
				search srch = new search();
				srch.getFrame().setVisible(true);
			}
		});
		btnSearch.setBounds(456, 107, 89, 23);
		frmWomensClothing.getContentPane().add(btnSearch);

		JButton btnCheckout = new JButton("Checkout");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmWomensClothing.dispose();
				CreditCard ccard = new CreditCard(email);
				ccard.frmCheckout.setVisible(true);
			}
		});
		btnCheckout.setBounds(715, 107, 89, 23);
		frmWomensClothing.getContentPane().add(btnCheckout);

		txtSearch = new JTextField();
		txtSearch.setText("Enter Keyword");
		txtSearch.setBounds(221, 108, 225, 20);
		frmWomensClothing.getContentPane().add(txtSearch);
		txtSearch.setColumns(10);

		JLabel lblYellowShoppingSystem = new JLabel("Yellow Shopping System");
		lblYellowShoppingSystem.setForeground(Color.WHITE);
		lblYellowShoppingSystem.setFont(new Font("Sitka Heading", Font.BOLD, 48));
		lblYellowShoppingSystem.setBounds(231, 0, 580, 137);
		frmWomensClothing.getContentPane().add(lblYellowShoppingSystem);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 204, 204));
		panel.setBounds(0, 0, 1367, 137);
		frmWomensClothing.getContentPane().add(panel);

		JLabel lblWomensShirts = new JLabel("Women's Shirts");
		lblWomensShirts.setFont(new Font("Sitka Heading", Font.PLAIN, 28));
		lblWomensShirts.setBounds(235, 203, 211, 49);
		frmWomensClothing.getContentPane().add(lblWomensShirts);

		JLabel lblWomensPants = new JLabel("Women's Pants");
		lblWomensPants.setFont(new Font("Sitka Subheading", Font.PLAIN, 28));
		lblWomensPants.setBounds(552, 203, 245, 49);
		frmWomensClothing.getContentPane().add(lblWomensPants);

		JLabel wShirts = new JLabel("");
		wShirts.setIcon(womenshirts);
		wShirts.setBounds(185, 263, 300, 300);
		frmWomensClothing.getContentPane().add(wShirts);

		JLabel wPants = new JLabel("");
		wPants.setIcon(wpants);
		wPants.setBounds(534, 263, 300, 300);
		frmWomensClothing.getContentPane().add(wPants);
		
		//listeners to clear images. Add show images to show inventory/products
		wPants.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmWomensClothing.dispose();
				ProductPage productPage = new ProductPage(email, "wPants", 0);
				productPage.frmProductPage.setVisible(true);
			}
		});
		wShirts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmWomensClothing.dispose();
				ProductPage productPage = new ProductPage(email, "wShirt", 0);
				productPage.frmProductPage.setVisible(true);
			}
		});
	}

	public JFrame getFrame() {
		return frmWomensClothing;
	}

	public void setFrame(JFrame frame) {
		this.frmWomensClothing = frame;
	}

}
