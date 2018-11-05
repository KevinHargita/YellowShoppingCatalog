package login_Sys;

//Presents a GUI to verify credit card numbers.
//Example valid numbers: 4111111111111111, 4408041234567893

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class CreditCard {
	public static void main(String[] args) {
		new CreditCard(email);
	}

	JFrame frmCheckout;
	private JTextField numberField;
	private JLabel validLabel;
	private JButton verifyButton;
	private JTextField fName;
	private JTextField lName;
	private JTextField sAddress;
	private JTextField sCity;
	private JTextField sState;
	private JTextField sZip;
	private JTextField exp;
	private JTextField cvn;
	private JLabel lblBillingAddress;
	private JTextField bAddress;
	private JTextField bCity;
	private JTextField bState;
	private JTextField bZip;
	private JSeparator separator_1;
	private JCheckBox chckbxSameAsShipping;
	private JCheckBox savePaymentInformation;
	private static String email;
	YellowDB DB = new YellowDB();
	private double total;
	
	public CreditCard(String email) {
		this.email = email;
		// set up components
		frmCheckout = new JFrame("Credit card number verifier");
		frmCheckout.setTitle("Checkout");
		frmCheckout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCheckout.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmCheckout.setSize(1000, 800);
		numberField = new JTextField(16);
		numberField.setBounds(53, 509, 184, 20);
		validLabel = new JLabel("not yet verified");
		validLabel.setBounds(53, 587, 111, 14);
		verifyButton = new JButton("Checkout");
		verifyButton.setBounds(53, 612, 100, 23);

		// event listeners
		verifyButton.addActionListener(new VerifyListener());
		frmCheckout.getContentPane().setLayout(null);
		frmCheckout.getContentPane().add(verifyButton);
		frmCheckout.getContentPane().add(numberField);
		frmCheckout.getContentPane().add(validLabel);

		JLabel lblFirstName = new JLabel("First Name*");
		lblFirstName.setBounds(53, 88, 66, 14);
		frmCheckout.getContentPane().add(lblFirstName);

		fName = new JTextField();
		fName.setBounds(53, 105, 144, 20);
		frmCheckout.getContentPane().add(fName);
		fName.setColumns(10);

		JLabel lblLastName = new JLabel("Last Name*");
		lblLastName.setBounds(207, 88, 86, 14);
		frmCheckout.getContentPane().add(lblLastName);

		lName = new JTextField();
		lName.setBounds(207, 105, 144, 20);
		frmCheckout.getContentPane().add(lName);
		lName.setColumns(10);

		JLabel lblShippingAddress = new JLabel("Shipping Address*");
		lblShippingAddress.setBounds(53, 136, 123, 14);
		frmCheckout.getContentPane().add(lblShippingAddress);

		sAddress = new JTextField();
		sAddress.setBounds(53, 150, 298, 20);
		frmCheckout.getContentPane().add(sAddress);
		sAddress.setColumns(10);

		JLabel lblCity = new JLabel("City*");
		lblCity.setBounds(53, 181, 46, 14);
		frmCheckout.getContentPane().add(lblCity);

		JLabel lblState = new JLabel("State*");
		lblState.setBounds(207, 181, 46, 14);
		frmCheckout.getContentPane().add(lblState);

		sCity = new JTextField();
		sCity.setBounds(53, 195, 144, 20);
		frmCheckout.getContentPane().add(sCity);
		sCity.setColumns(10);

		sState = new JTextField();
		sState.setBounds(207, 195, 144, 20);
		frmCheckout.getContentPane().add(sState);
		sState.setColumns(10);

		JLabel lblZipCode = new JLabel("Zip Code*");
		lblZipCode.setBounds(53, 226, 86, 14);
		frmCheckout.getContentPane().add(lblZipCode);

		sZip = new JTextField();
		sZip.setBounds(53, 242, 86, 20);
		frmCheckout.getContentPane().add(sZip);
		sZip.setColumns(10);

		JLabel lblCreditCard = new JLabel("Credit Card*");
		lblCreditCard.setBounds(53, 491, 86, 14);
		frmCheckout.getContentPane().add(lblCreditCard);

		JLabel lblExp = new JLabel("Exp. ##/##");
		lblExp.setBounds(53, 540, 66, 14);
		frmCheckout.getContentPane().add(lblExp);

		exp = new JTextField();
		exp.setBounds(53, 556, 58, 20);
		frmCheckout.getContentPane().add(exp);
		exp.setColumns(10);

		JLabel lblCvn = new JLabel("CVN");
		lblCvn.setBounds(151, 540, 46, 14);
		frmCheckout.getContentPane().add(lblCvn);

		cvn = new JTextField();
		cvn.setBounds(146, 556, 51, 20);
		frmCheckout.getContentPane().add(cvn);
		cvn.setColumns(10);

		lblBillingAddress = new JLabel("Billing Address");
		lblBillingAddress.setBounds(55, 311, 135, 14);
		frmCheckout.getContentPane().add(lblBillingAddress);

		JSeparator separator = new JSeparator();
		separator.setBounds(53, 291, 298, 9);
		frmCheckout.getContentPane().add(separator);

		chckbxSameAsShipping = new JCheckBox("Same as Shipping");
		chckbxSameAsShipping.setBounds(53, 448, 135, 18);
		frmCheckout.getContentPane().add(chckbxSameAsShipping);
		
		savePaymentInformation = new JCheckBox("Save Payment Information");
		savePaymentInformation.setBounds(207, 448, 194, 18);
		frmCheckout.getContentPane().add(savePaymentInformation);
		
		bAddress = new JTextField();
		bAddress.setBounds(55, 329, 298, 20);
		frmCheckout.getContentPane().add(bAddress);
		bAddress.setColumns(10);

		JLabel lblCity_1 = new JLabel("City");
		lblCity_1.setBounds(55, 360, 46, 14);
		frmCheckout.getContentPane().add(lblCity_1);

		JLabel lblState_1 = new JLabel("State");
		lblState_1.setBounds(209, 360, 46, 14);
		frmCheckout.getContentPane().add(lblState_1);

		bCity = new JTextField();
		bCity.setBounds(53, 375, 144, 20);
		frmCheckout.getContentPane().add(bCity);
		bCity.setColumns(10);

		bState = new JTextField();
		bState.setBounds(209, 375, 144, 20);
		frmCheckout.getContentPane().add(bState);
		bState.setColumns(10);

		JLabel lblZipCode_1 = new JLabel("Zip Code");
		lblZipCode_1.setBounds(55, 405, 89, 14);
		frmCheckout.getContentPane().add(lblZipCode_1);

		bZip = new JTextField();
		bZip.setBounds(55, 421, 86, 20);
		frmCheckout.getContentPane().add(bZip);
		bZip.setColumns(10);
		List <String> shippingInfo;
		List <String> billingInfo;
		try {
			billingInfo = DB.getBillingInfo(email);
			shippingInfo = DB.getShippingInfo(email);
			
			lName.setText(shippingInfo.get(2));
			fName.setText(shippingInfo.get(1));
			sAddress.setText(shippingInfo.get(3));
			bAddress.setText(billingInfo.get(0));
			sCity.setText(shippingInfo.get(4));
			bCity.setText(billingInfo.get(1));
			sZip.setText(shippingInfo.get(6));
			bZip.setText(billingInfo.get(3));
			sState.setText(shippingInfo.get(5));
			bState.setText(billingInfo.get(2));
			exp.setText(billingInfo.get(5));
			cvn.setText(null);
			numberField.setText(billingInfo.get(4));
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
		
		

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				lName.setText(null);
				fName.setText(null);
				sAddress.setText(null);
				bAddress.setText(null);
				sCity.setText(null);
				bCity.setText(null);
				sZip.setText(null);
				bZip.setText(null);
				sState.setText(null);
				bState.setText(null);
				exp.setText(null);
				cvn.setText(null);
				numberField.setText(null);

				chckbxSameAsShipping.setSelected(false);
				savePaymentInformation.setSelected(false);

			}
		});
		btnReset.setBounds(166, 612, 89, 23);
		frmCheckout.getContentPane().add(btnReset);

		separator_1 = new JSeparator();
		separator_1.setBounds(53, 483, 298, 9);
		frmCheckout.getContentPane().add(separator_1);
		
		JButton btnBackToCart = new JButton("Back to Cart");
		btnBackToCart.setBounds(270, 612, 123, 23);
		frmCheckout.getContentPane().add(btnBackToCart);
		frmCheckout.setVisible(true);
		btnBackToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCheckout.dispose();
				Cart cart = new Cart(email);
				cart.frame.setVisible(true);
			}
		});
		
	}

	// Returns whether the given string is a valid Visa card number
	// according to the Luhn checksum algorithm.
	public boolean isValidCreditCardNumber(String text) {
		if (!text.startsWith("4")) {
			return false;
		}

		// add all of the digits
		int sum = 0;
		for (int i = 0; i < text.length(); i++) {
			int digit = Integer.valueOf(text.substring(i, i + 1));
			if (i % 2 == 0) { // double every other number, add digits
				digit *= 2;
				sum += (digit / 10) + (digit % 10);
			} else {
				sum += digit;
			}
		}
		// valid numbers add up to a multiple of 10
		return (sum % 10 == 0);
	}

	// Sets the label's text to show whether the credit card number is valid.
	public class VerifyListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String text = numberField.getText();

			if (fName.getText().trim().isEmpty() || lName.getText().trim().isEmpty()
					|| sAddress.getText().trim().isEmpty() || sCity.getText().trim().isEmpty()
					|| sState.getText().trim().isEmpty() || sZip.getText().trim().isEmpty()
					|| numberField.getText().trim().isEmpty() || exp.getText().trim().isEmpty()
					|| cvn.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please fill out required fields.", "Checkout Error",
						JOptionPane.ERROR_MESSAGE);
			}

			else if (isValidCreditCardNumber(text)) {
				if(savePaymentInformation.isSelected()){
					try {
						DB.saveInfo(email, fName.getText(), lName.getText(), sAddress.getText(), sCity.getText(), sState.getText(), Integer.parseInt(sZip.getText()));
						DB.saveBilling(email, bAddress.getText(), bCity.getText(), bState.getText(), bZip.getText(), numberField.getText(), exp.getText());
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(chckbxSameAsShipping.isSelected()){
					bAddress.setText(sAddress.getText());
					bCity.setText(sCity.getText());
					bState.setText(sState.getText());
					bZip.setText(sZip.getText());
				}
				JOptionPane.showMessageDialog(null, "Checkout Succesful");
				frmCheckout.dispose();
				Home homepage = new Home(email);
				homepage.frame.setVisible(true);
				
			} else {
				JOptionPane.showMessageDialog(null, "Invalid credit card information.", "Checkout Error",
						JOptionPane.ERROR_MESSAGE);
			}

		}
	}
}
