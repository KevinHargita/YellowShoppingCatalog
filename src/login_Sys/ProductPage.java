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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class ProductPage {

	public JFrame frmProductPage;
	private static String email;
	private static String filter;
	private JTextField txtSearch;
	private String imagePath = "C:/Users/kevin/eclipse-workspace/YellowShoppingCatalog/images/items/";
	YellowDB DB = new YellowDB();
	private static int page;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductPage window = new ProductPage(email, filter, page);
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
	public ProductPage(String email, String filter, int page) {
		this.email = email;
		this.filter = filter;
		this.page = page;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frmProductPage = new JFrame("Yellow Shopping System");
		frmProductPage.getContentPane().setBackground(Color.WHITE);
		frmProductPage.setTitle("Project Page");
		frmProductPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProductPage.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmProductPage.setSize(991, 861);
		frmProductPage.getContentPane().setLayout(null);


		JButton btnMens = new JButton("Men's");
		btnMens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmProductPage.dispose();
				mens men = new mens(email);
				men.frmMensClothing.setVisible(true);
			}
		});
		btnMens.setBounds(35, 107, 77, 23);
		frmProductPage.getContentPane().add(btnMens);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmProductPage.dispose();
				Login_S login = new Login_S();
				login.frmYellowShoppingSystem.setVisible(true);

			}
		});
		btnLogin.setBounds(814, 107, 89, 23);
		frmProductPage.getContentPane().add(btnLogin);

		JButton btnWomens = new JButton("Women's");
		btnWomens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmProductPage.dispose();
				womens women = new womens(email);
				women.getFrame().setVisible(true);
			}
		});
		btnWomens.setBounds(122, 107, 89, 23);
		frmProductPage.getContentPane().add(btnWomens);

		JButton btnShoppingCart = new JButton("Shopping Cart");
		btnShoppingCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmProductPage.dispose();
				Cart myCart = new Cart(email);
				myCart.frame.setVisible(true);
			}
		});
		btnShoppingCart.setBounds(589, 107, 116, 23);
		frmProductPage.getContentPane().add(btnShoppingCart);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmProductPage.dispose();
				search srch = new search();
				srch.getFrame().setVisible(true);
			}
		});
		btnSearch.setBounds(456, 107, 89, 23);
		frmProductPage.getContentPane().add(btnSearch);

		JButton btnCheckout = new JButton("Checkout");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmProductPage.dispose();
				CreditCard ccard = new CreditCard(email);
				ccard.frmCheckout.setVisible(true);
			}
		});
		btnCheckout.setBounds(715, 107, 89, 23);
		frmProductPage.getContentPane().add(btnCheckout);

		txtSearch = new JTextField();
		txtSearch.setText("Enter Keyword");
		txtSearch.setBounds(221, 108, 225, 20);
		frmProductPage.getContentPane().add(txtSearch);
		txtSearch.setColumns(10);

		JLabel lblYellowShoppingSystem = new JLabel("Yellow Shopping System");
		lblYellowShoppingSystem.setForeground(Color.WHITE);
		lblYellowShoppingSystem.setFont(new Font("Sitka Heading", Font.BOLD, 48));
		lblYellowShoppingSystem.setBounds(231, 0, 580, 137);
		frmProductPage.getContentPane().add(lblYellowShoppingSystem);

		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(new Color(51, 204, 204));
		headerPanel.setBounds(0, 0, 984, 137);
		frmProductPage.getContentPane().add(headerPanel);
		
		JPanel Item1 = new JPanel();
		Item1.setBackground(new Color(255, 255, 255));
		Item1.setBounds(35, 159, 278, 280);
		frmProductPage.getContentPane().add(Item1);
		Item1.setLayout(null);
		
		JLabel lblItemName1 = new JLabel("");
		lblItemName1.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemName1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblItemName1.setBounds(40, 30, 196, 17);
		Item1.add(lblItemName1);
		
		JLabel lblPrice1 = new JLabel("");
		lblPrice1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrice1.setBounds(190, 227, 78, 14);
		Item1.add(lblPrice1);
		
		JComboBox comboBox1 = new JComboBox();
		comboBox1.setModel(new DefaultComboBoxModel(new String[] {"S", "M", "L", "XL", "XXL"}));
		comboBox1.setBounds(40, 225, 60, 20);
		comboBox1.setVisible(false);
		Item1.add(comboBox1);
		
		JLabel lblSize1 = new JLabel("");
		lblSize1.setBounds(10, 228, 136, 14);
		Item1.add(lblSize1);
		
		JLabel lblBrand1 = new JLabel("");
		lblBrand1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrand1.setBounds(94, 49, 95, 14);
		Item1.add(lblBrand1);
		
		JLabel lblGender1 = new JLabel("");
		lblGender1.setBounds(104, 227, 76, 17);
		Item1.add(lblGender1);
		
		JLabel lblImage1 = new JLabel("");
		lblImage1.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage1.setBounds(66, 74, 142, 142);
		Item1.add(lblImage1);
		
		JButton btnAddToCart1 = new JButton("Add to Cart");
		btnAddToCart1.setBounds(85, 253, 100, 23);
		btnAddToCart1.setVisible(false);
		Item1.add(btnAddToCart1);
		
		JPanel Item2 = new JPanel();
		Item2.setBackground(new Color(255, 255, 255));
		Item2.setLayout(null);
		Item2.setBounds(326, 159, 278, 280);
		frmProductPage.getContentPane().add(Item2);
		
		JLabel lblItemName2 = new JLabel("");
		lblItemName2.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemName2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblItemName2.setBounds(40, 30, 196, 17);
		Item2.add(lblItemName2);
		
		JLabel lblPrice2 = new JLabel("");
		lblPrice2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrice2.setBounds(190, 227, 78, 14);
		Item2.add(lblPrice2);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"S", "M", "L", "XL", "XXL"}));
		comboBox_2.setBounds(40, 225, 60, 20);
		comboBox_2.setVisible(false);
		Item2.add(comboBox_2);
		
		JLabel lblSize2 = new JLabel("");
		lblSize2.setBounds(10, 228, 136, 14);
		Item2.add(lblSize2);
		
		JLabel lblBrand2 = new JLabel("");
		lblBrand2.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrand2.setBounds(94, 49, 95, 14);
		Item2.add(lblBrand2);
		
		JLabel lblGender2 = new JLabel("");
		lblGender2.setBounds(104, 227, 76, 17);
		Item2.add(lblGender2);
		
		JLabel lblImage2 = new JLabel("");
		lblImage2.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage2.setBounds(66, 74, 142, 142);
		Item2.add(lblImage2);
		
		JButton btnAddToCart2 = new JButton("Add to Cart");
		btnAddToCart2.setBounds(85, 253, 100, 23);
		btnAddToCart2.setVisible(false);
		Item2.add(btnAddToCart2);
		
		JPanel Item3 = new JPanel();
		Item3.setBackground(new Color(255, 255, 255));
		Item3.setLayout(null);
		Item3.setBounds(625, 159, 278, 280);
		frmProductPage.getContentPane().add(Item3);
		
		JLabel lblItemName3 = new JLabel("");
		lblItemName3.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemName3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblItemName3.setBounds(40, 30, 196, 17);
		Item3.add(lblItemName3);
		
		JLabel lblPrice3 = new JLabel("");
		lblPrice3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrice3.setBounds(190, 227, 78, 14);
		Item3.add(lblPrice3);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"S", "M", "L", "XL", "XXL"}));
		comboBox_3.setBounds(40, 225, 60, 20);
		comboBox_3.setVisible(false);
		Item3.add(comboBox_3);
		
		JLabel lblSize3 = new JLabel("");
		lblSize3.setBounds(10, 228, 136, 14);
		Item3.add(lblSize3);
		
		JLabel lblBrand3 = new JLabel("");
		lblBrand3.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrand3.setBounds(94, 49, 95, 14);
		Item3.add(lblBrand3);
		
		JLabel lblGender3 = new JLabel("");
		lblGender3.setBounds(104, 227, 76, 17);
		Item3.add(lblGender3);
		
		JLabel lblImage3 = new JLabel("");
		lblImage3.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage3.setBounds(66, 74, 142, 142);
		Item3.add(lblImage3);
		
		JButton btnAddToCart3 = new JButton("Add to Cart");
		btnAddToCart3.setBounds(85, 253, 100, 23);
		btnAddToCart3.setVisible(false);
		Item3.add(btnAddToCart3);
		
		JPanel Item4 = new JPanel();
		Item4.setBackground(new Color(255, 255, 255));
		Item4.setLayout(null);
		Item4.setBounds(35, 456, 278, 280);
		frmProductPage.getContentPane().add(Item4);
		
		JLabel lblItemName4 = new JLabel("");
		lblItemName4.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemName4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblItemName4.setBounds(40, 30, 196, 17);
		Item4.add(lblItemName4);
		
		JLabel lblPrice4 = new JLabel("");
		lblPrice4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrice4.setBounds(190, 227, 78, 14);
		Item4.add(lblPrice4);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"S", "M", "L", "XL", "XXL"}));
		comboBox_4.setBounds(40, 225, 60, 20);
		comboBox_4.setVisible(false);
		Item4.add(comboBox_4);
		
		JLabel lblSize4 = new JLabel("");
		lblSize4.setBounds(10, 228, 136, 14);
		Item4.add(lblSize4);
		
		JLabel lblBrand4 = new JLabel("");
		lblBrand4.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrand4.setBounds(94, 49, 95, 14);
		Item4.add(lblBrand4);
		
		JLabel lblGender4 = new JLabel("");
		lblGender4.setBounds(104, 227, 76, 17);
		Item4.add(lblGender4);
		
		JLabel lblImage4 = new JLabel("");
		lblImage4.setBackground(Color.LIGHT_GRAY);
		lblImage4.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage4.setBounds(66, 74, 142, 142);
		Item4.add(lblImage4);
		
		JButton btnAddToCart4 = new JButton("Add to Cart");
		btnAddToCart4.setBounds(85, 253, 100, 23);
		btnAddToCart4.setVisible(false);
		Item4.add(btnAddToCart4);
		
		JPanel Item5 = new JPanel();
		Item5.setBackground(new Color(255, 255, 255));
		Item5.setLayout(null);
		Item5.setBounds(326, 456, 278, 280);
		frmProductPage.getContentPane().add(Item5);
		
		JLabel lblItemName5 = new JLabel("");
		lblItemName5.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemName5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblItemName5.setBounds(40, 30, 196, 17);
		Item5.add(lblItemName5);
		
		JLabel lblPrice5 = new JLabel("");
		lblPrice5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrice5.setBounds(190, 227, 88, 14);
		Item5.add(lblPrice5);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"S", "M", "L", "XL", "XXL"}));
		comboBox_5.setBounds(40, 225, 60, 20);
		comboBox_5.setVisible(false);
		Item5.add(comboBox_5);
		
		JLabel lblSize5 = new JLabel("");
		lblSize5.setBounds(10, 228, 136, 14);
		Item5.add(lblSize5);
		
		JLabel lblBrand5 = new JLabel("");
		lblBrand5.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrand5.setBounds(94, 49, 95, 14);
		Item5.add(lblBrand5);
		
		JLabel lblGender5 = new JLabel("");
		lblGender5.setBounds(104, 227, 76, 17);
		Item5.add(lblGender5);
		
		JLabel lblImage5 = new JLabel("");
		lblImage5.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage5.setBounds(66, 74, 142, 142);
		Item5.add(lblImage5);
		
		JButton btnAddToCart5 = new JButton("Add to Cart");
		btnAddToCart5.setBounds(85, 253, 100, 23);
		btnAddToCart5.setVisible(false);
		Item5.add(btnAddToCart5);
		
		JPanel Item6 = new JPanel();
		Item6.setBackground(new Color(255, 255, 255));
		Item6.setLayout(null);
		Item6.setBounds(625, 456, 278, 280);
		frmProductPage.getContentPane().add(Item6);
		Item6.removeAll();
		
		JLabel lblItemName6 = new JLabel("");
		lblItemName6.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemName6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblItemName6.setBounds(40, 30, 196, 17);
		Item6.add(lblItemName6);
		
		JLabel lblPrice6 = new JLabel("");
		lblPrice6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrice6.setBounds(190, 227, 88, 14);
		Item6.add(lblPrice6);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"S", "M", "L", "XL", "XXL"}));
		comboBox_6.setBounds(40, 225, 60, 20);
		comboBox_6.setVisible(false);
		Item6.add(comboBox_6);
		
		JLabel lblSize6 = new JLabel("");
		lblSize6.setBounds(10, 228, 136, 14);
		Item6.add(lblSize6);
		
		JLabel lblBrand6 = new JLabel("");
		lblBrand6.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrand6.setBounds(94, 49, 95, 14);
		Item6.add(lblBrand6);
		
		JLabel lblGender6 = new JLabel("");
		lblGender6.setBounds(104, 227, 76, 17);
		Item6.add(lblGender6);
		
		JLabel lblImage6 = new JLabel("");
		lblImage6.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage6.setBounds(66, 74, 142, 142);
		Item6.add(lblImage6);
		
		JButton btnAddToCart6 = new JButton("Add to Cart");
		btnAddToCart6.setBounds(85, 253, 100, 23);
		btnAddToCart6.setVisible(false);
		Item6.add(btnAddToCart6);
		
		JLabel leftArrow = new JLabel("");
		leftArrow.setBounds(379, 756, 43, 43);
		Image imLeftArrow;
		try {
			imLeftArrow = ImageIO.read(new File("C:/Users/kevin/eclipse-workspace/YellowShoppingCatalog/images/leftArrow.jpg"));
			imLeftArrow = imLeftArrow.getScaledInstance(43, 43, Image.SCALE_DEFAULT);
			leftArrow.setIcon(new ImageIcon(imLeftArrow));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		frmProductPage.getContentPane().add(leftArrow);
		
		JLabel rightArrow = new JLabel("");
		rightArrow.setBounds(520, 756, 43, 43);
		Image imRightArrow;
		try {
			imRightArrow = ImageIO.read(new File("C:/Users/kevin/eclipse-workspace/YellowShoppingCatalog/images/rightArrow.jpg"));
			imRightArrow = imRightArrow.getScaledInstance(43, 43, Image.SCALE_DEFAULT);
			rightArrow.setIcon(new ImageIcon(imRightArrow));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		frmProductPage.getContentPane().add(rightArrow);
		
		
		//Sets the data for each item panel
		
		List<Item> items = DB.getItemInfo(filter);
		System.out.println("Items in this set: " + items.size());
		if(page == 0) {
			leftArrow.setVisible(false);
		}
		if((items.size() - page*6) <=6) {
			rightArrow.setVisible(false);
		}
		
		System.out.println("page = "+ page);
	
		
		
			//Panel 1
		if(items.size() > (0 + page*6)) {
				Item item1 = items.get(0 + page*6);
			
				comboBox1.setVisible(true);
				btnAddToCart1.setVisible(true);
				lblSize1.setText("Size:");
				lblItemName1.setText(item1.getItemName());
				lblPrice1.setText("Price: " + item1.getPrice());
				lblBrand1.setText(item1.getBrand());
				lblGender1.setText("Gender: " + item1.getGender());
				Image im1;
				try {
					im1 = ImageIO.read(new File(imagePath + item1.getItemImage()));
					im1 = im1.getScaledInstance(142, 142, Image.SCALE_DEFAULT);
					lblImage1.setIcon(new ImageIcon(im1));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				btnAddToCart1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null, "Item Added to Cart!","",JOptionPane.INFORMATION_MESSAGE);
						try {
							DB.add(item1.getItemName(), item1.getBrand(), item1.getDescription(), item1.getItemImage(), item1.getGender(), item1.getSize(), item1.getPrice(), item1.getStock(), email);
						} catch (ClassNotFoundException e1) {
							e1.printStackTrace();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				});
		}
				
		
			//Panel 2
		if(items.size() > (1 + page*6)) {
				Item item2 = items.get(1 + page*6);
				comboBox_2.setVisible(true);
				btnAddToCart2.setVisible(true);
				lblSize2.setText("Size:");
				lblItemName2.setText(item2.getItemName());
				lblPrice2.setText("Price: " + item2.getPrice());
				lblBrand2.setText(item2.getBrand());
				lblGender2.setText("Gender: " + item2.getGender());
				Image im2;
				try {
					im2 = ImageIO.read(new File(imagePath + item2.getItemImage()));
					im2 = im2.getScaledInstance(142, 142, Image.SCALE_DEFAULT);
					lblImage2.setIcon(new ImageIcon(im2));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				btnAddToCart2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null, "Item Added to Cart!","",JOptionPane.INFORMATION_MESSAGE);
						try {
							DB.add(item2.getItemName(), item2.getBrand(), item2.getDescription(), item2.getItemImage(), item2.getGender(), item2.getSize(), item2.getPrice(), item2.getStock(), email);
						} catch (ClassNotFoundException e1) {
							e1.printStackTrace();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				});
		}
				
			//Panel 3
		if(items.size() > (2 + page*6)) {
			Item item3 = items.get(2 + page*6);
				comboBox_3.setVisible(true);
				btnAddToCart3.setVisible(true);
				lblSize3.setText("Size:");
				lblItemName3.setText(item3.getItemName());
				lblPrice3.setText("Price: " + item3.getPrice());
				lblBrand3.setText(item3.getBrand());
				lblGender3.setText("Gender: " + item3.getGender());
				Image im3;
				try {
					im3 = ImageIO.read(new File(imagePath + item3.getItemImage()));
					im3 = im3.getScaledInstance(142, 142, Image.SCALE_DEFAULT);
					lblImage3.setIcon(new ImageIcon(im3));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				btnAddToCart3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null, "Item Added to Cart!","",JOptionPane.INFORMATION_MESSAGE);
						try {
							DB.add(item3.getItemName(), item3.getBrand(), item3.getDescription(), item3.getItemImage(), item3.getGender(), item3.getSize(), item3.getPrice(), item3.getStock(), email);
						} catch (ClassNotFoundException e1) {
							e1.printStackTrace();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				});
		}
				
			//Panel 4
		if(items.size() > (3 + page*6)) {
			Item item4 = items.get(3 + page*6);
				comboBox_4.setVisible(true);
				btnAddToCart4.setVisible(true);
				lblSize4.setText("Size:");
				lblItemName4.setText(item4.getItemName());
				lblPrice4.setText("Price: " + item4.getPrice());
				lblBrand4.setText(item4.getBrand());
				lblGender4.setText("Gender: " + item4.getGender());
				Image im4;
				try {
					im4 = ImageIO.read(new File(imagePath + item4.getItemImage()));
					im4 = im4.getScaledInstance(142, 142, Image.SCALE_DEFAULT);
					lblImage4.setIcon(new ImageIcon(im4));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				btnAddToCart4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null, "Item Added to Cart!","",JOptionPane.INFORMATION_MESSAGE);
						try {
							DB.add(item4.getItemName(), item4.getBrand(), item4.getDescription(), item4.getItemImage(), item4.getGender(), item4.getSize(), item4.getPrice(), item4.getStock(), email);
						} catch (ClassNotFoundException e1) {
							e1.printStackTrace();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				});
		}
				
			//Panel 5
		if (items.size() > (4 + page*6)) {
			Item item5 = items.get(4 + page*6);
				comboBox_5.setVisible(true);
				btnAddToCart5.setVisible(true);
				lblSize5.setText("Size:");
				lblItemName5.setText(item5.getItemName());
				lblPrice5.setText("Price: " + item5.getPrice());
				lblBrand5.setText(item5.getBrand());
				lblGender5.setText("Gender: " + item5.getGender());
				Image im5;
				try {
					im5 = ImageIO.read(new File(imagePath + item5.getItemImage()));
					im5 = im5.getScaledInstance(142, 142, Image.SCALE_DEFAULT);
					lblImage5.setIcon(new ImageIcon(im5));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				btnAddToCart5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null, "Item Added to Cart!","",JOptionPane.INFORMATION_MESSAGE);
						try {
							DB.add(item5.getItemName(), item5.getBrand(), item5.getDescription(), item5.getItemImage(), item5.getGender(), item5.getSize(), item5.getPrice(), item5.getStock(), email);
						} catch (ClassNotFoundException e1) {
							e1.printStackTrace();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				});
		}
				
			//Panel 6
		if (items.size() > (5 + page*6)) {
				Item item6 = items.get(5 + page*6);
				comboBox_6.setVisible(true);
				btnAddToCart6.setVisible(true);
				lblSize6.setText("Size:");
				lblItemName6.setText(item6.getItemName());
				lblPrice6.setText("Price: " + item6.getPrice());
				lblBrand6.setText(item6.getBrand());
				lblGender6.setText("Gender: " + item6.getGender());
				Image im6;
				try {
					im6 = ImageIO.read(new File(imagePath + item6.getItemImage()));
					im6 = im6.getScaledInstance(142, 142, Image.SCALE_DEFAULT);
					lblImage6.setIcon(new ImageIcon(im6));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				btnAddToCart6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null, "Item Added to Cart!","",JOptionPane.INFORMATION_MESSAGE);
						try {
							DB.add(item6.getItemName(), item6.getBrand(), item6.getDescription(), item6.getItemImage(), item6.getGender(), item6.getSize(), item6.getPrice(), item6.getStock(), email);
						} catch (ClassNotFoundException e1) {
							e1.printStackTrace();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				});
		}
		
		
		//Navigate between sets of 6 products per page.
		//Arrows disappear if you can no longer go in that direction.
		leftArrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmProductPage.dispose();
				ProductPage productPage = new ProductPage(email, filter, page-1);
				productPage.frmProductPage.setVisible(true);
			}
		});
		rightArrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmProductPage.dispose();
				ProductPage productPage = new ProductPage(email, filter, page+1);
				productPage.frmProductPage.setVisible(true);
			}
		});
		
		

	}

	public JFrame getFrame() {
		return frmProductPage;
	}

	public void setFrame(JFrame frame) {
		this.frmProductPage = frame;
	}
}
