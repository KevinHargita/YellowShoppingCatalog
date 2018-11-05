package login_Sys;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home {

	static JFrame frame;
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
					Home window = new Home(email);
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
	public Home(String email) {
		this.email = email;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Yellow Shopping System");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setTitle("Home Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setSize(1000, 800);
		frame.getContentPane().setLayout(null);
		ImageIcon menImg = new ImageIcon(imagePath + "mens.jpg");
		ImageIcon womenImg = new ImageIcon(imagePath + "womens.jpg");

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

		JButton btnShoppingCart = new JButton("Shopping Cart");
		btnShoppingCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Cart cart = new Cart(email);
				cart.frame.setVisible(true);
			}
		});
		btnShoppingCart.setBounds(589, 107, 116, 23);
		frame.getContentPane().add(btnShoppingCart);

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

		JLabel lblMensClothing = new JLabel("Men's Clothing");
		lblMensClothing.setFont(new Font("Sitka Heading", Font.PLAIN, 28));
		lblMensClothing.setBounds(235, 203, 174, 49);
		frame.getContentPane().add(lblMensClothing);

		JLabel lblWomensClothing = new JLabel("Women's Clothing");
		lblWomensClothing.setFont(new Font("Sitka Subheading", Font.PLAIN, 28));
		lblWomensClothing.setBounds(552, 203, 245, 49);
		frame.getContentPane().add(lblWomensClothing);

		JLabel mens = new JLabel("");
		mens.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.dispose();
				mens men = new mens(email);
				men.getFrame().setVisible(true);
			}
		});
		mens.setIcon(menImg);
		mens.setBounds(185, 263, 300, 300);
		frame.getContentPane().add(mens);

		JLabel womens = new JLabel("");
		womens.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				womens women = new womens(email);
				women.getFrame().setVisible(true);
			}
		});
		womens.setIcon(womenImg);
		womens.setBounds(534, 263, 300, 300);
		frame.getContentPane().add(womens);

	}
}