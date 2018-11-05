package login_Sys;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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

public class mens {

	JFrame frmMensClothing;
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
					mens window = new mens(email);
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
	@SuppressWarnings("static-access")
	public mens(String email) {
		this.email = email;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMensClothing = new JFrame("Yellow Shopping System");
		frmMensClothing.getContentPane().setBackground(Color.WHITE);
		frmMensClothing.setTitle("Men's Clothing");
		frmMensClothing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMensClothing.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmMensClothing.setSize(1000, 800);
		frmMensClothing.getContentPane().setLayout(null);
		ImageIcon mshirt = new ImageIcon(imagePath + "mshirt.jpg");
		ImageIcon mpants = new ImageIcon(imagePath + "mpants.jpg");

		JButton btnHome = new JButton("Home\r\n");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMensClothing.dispose();
				Home hpage = new Home(email);
				Home.frame.setVisible(true);
			}
		});
		btnHome.setBounds(35, 107, 77, 23);
		frmMensClothing.getContentPane().add(btnHome);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMensClothing.dispose();
				Login_S login = new Login_S();
				login.frmYellowShoppingSystem.setVisible(true);

			}
		});
		btnLogin.setBounds(814, 107, 89, 23);
		frmMensClothing.getContentPane().add(btnLogin);

		JButton btnWomens = new JButton("Women's");
		btnWomens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMensClothing.dispose();
				womens women = new womens(email);
				women.getFrame().setVisible(true);
			}
		});
		btnWomens.setBounds(122, 107, 89, 23);
		frmMensClothing.getContentPane().add(btnWomens);

		JButton btnShoppingCart = new JButton("Shopping Cart");
		btnShoppingCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMensClothing.dispose();
				Cart cart = new Cart(email);
				cart.frame.setVisible(true);
			}
		});
		btnShoppingCart.setBounds(589, 107, 116, 23);
		frmMensClothing.getContentPane().add(btnShoppingCart);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMensClothing.dispose();
				search srch = new search();
				srch.getFrame().setVisible(true);
			}
		});
		btnSearch.setBounds(456, 107, 89, 23);
		frmMensClothing.getContentPane().add(btnSearch);

		JButton btnCheckout = new JButton("Checkout");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMensClothing.dispose();
				CreditCard ccard = new CreditCard(email);
				ccard.frmCheckout.setVisible(true);
			}
		});
		btnCheckout.setBounds(715, 107, 89, 23);
		frmMensClothing.getContentPane().add(btnCheckout);

		txtSearch = new JTextField();
		txtSearch.setText("Enter Keyword");
		txtSearch.setBounds(221, 108, 225, 20);
		frmMensClothing.getContentPane().add(txtSearch);
		txtSearch.setColumns(10);

		JLabel lblYellowShoppingSystem = new JLabel("Yellow Shopping System");
		lblYellowShoppingSystem.setForeground(Color.WHITE);
		lblYellowShoppingSystem.setFont(new Font("Sitka Heading", Font.BOLD, 48));
		lblYellowShoppingSystem.setBounds(231, 0, 580, 137);
		frmMensClothing.getContentPane().add(lblYellowShoppingSystem);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 204, 204));
		panel.setBounds(0, 0, 1367, 137);
		frmMensClothing.getContentPane().add(panel);

		JLabel lblMensShirts = new JLabel("Men's Shirts");
		lblMensShirts.setFont(new Font("Sitka Heading", Font.PLAIN, 28));
		lblMensShirts.setBounds(249, 203, 160, 49);
		frmMensClothing.getContentPane().add(lblMensShirts);

		JLabel lblMensPants = new JLabel("Men's Pants");
		lblMensPants.setFont(new Font("Sitka Subheading", Font.PLAIN, 28));
		lblMensPants.setBounds(601, 203, 196, 49);
		frmMensClothing.getContentPane().add(lblMensPants);

		JLabel mShirts = new JLabel("");
		mShirts.setIcon(mshirt);
		mShirts.setBounds(185, 263, 300, 300);
		frmMensClothing.getContentPane().add(mShirts);

		JLabel mPants = new JLabel("");
		mPants.setIcon(mpants);
		mPants.setBounds(534, 263, 300, 300);
		frmMensClothing.getContentPane().add(mPants);
		
		//listeners to clear images. Add show images to show inventory/products
		mPants.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmMensClothing.dispose();
				ProductPage productPage = new ProductPage(email, "mPants", 0);
				productPage.frmProductPage.setVisible(true);
			}
		});
		mShirts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmMensClothing.dispose();
				ProductPage productPage = new ProductPage(email, "mShirt", 0);
				productPage.frmProductPage.setVisible(true);
			}
		});


	}

	public JFrame getFrame() {
		return frmMensClothing;
	}

	public void setFrame(JFrame frame) {
		this.frmMensClothing = frame;
	}

}
