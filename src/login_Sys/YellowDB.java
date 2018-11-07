package login_Sys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class YellowDB {

	private static Connection con;

	// makes connection if none and returns entries in database
	public ResultSet displayUsers() throws ClassNotFoundException, SQLException {
		if (con == null) {
			getConnection();
		}
		Statement state = con.createStatement();
		// Receives all emails and passwords
		ResultSet res = state.executeQuery("SELECT email, password FROM users");
		return res;
	}

	// connects to database
	private void getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		con = DriverManager.getConnection("jdbc:sqlite:YellowDB.db");
		initialize();
	}

	// creates table with id, email, and password
	private void initialize() throws SQLException {

		Statement state = con.createStatement();
		// creates all the tables in database and determines column name and types
		String sql1 = "CREATE TABLE IF NOT EXISTS users(\n" + "id integer PRIMARY KEY,\n"
				+ "email text NOT NULL UNIQUE,\n" + "password text NOT NULL\n" + ");";
		state.execute(sql1);

		String sql2 = "CREATE TABLE IF NOT EXISTS items(\n" + "id integer PRIMARY KEY,\n"
				+ "itemName text NOT NULL UNIQUE,\n" + "brand text,\n" + "description text,\n"
				+ "itemImage text NOT NULL,\n" + "gender text NOT NULL,\n" + "size text NOT NULL,\n"
				+ "price real NOT NULL,\n" + "stock integer NOT NULL\n" + ");";
		state.execute(sql2);
		String sql3 = "CREATE TABLE IF NOT EXISTS shippingInfo(\n" + "id integer PRIMARY KEY,\n"
				+ "email text NOT NULL UNIQUE,\n" + "fName text NOT NULL,\n" + "lName text NOT NULL,\n"
				+ "address text NOT NULL,\n" + "city text NOT NULL,\n" + "state text NOT NULL,\n"
				+ "zipCode text NOT NULL\n" + ");";
		state.execute(sql3);
		String sql4 = "CREATE TABLE IF NOT EXISTS billingInfo(\n" + "id integer PRIMARY KEY,\n"
				+ "email text NOT NULL UNIQUE,\n" + "address text NOT NULL,\n" + "city text NOT NULL,\n"
				+ "state text NOT NULL,\n" + "zipCode text NOT NULL,\n" + "cardNumber text NOT NULL,\n"
				+ "expirationDate text NOT NULL\n" + ");";
		state.execute(sql4);
		String sql5 = "CREATE TABLE IF NOT EXISTS shoppingCart(\n"
                + "id integer PRIMARY KEY,\n"
                + "itemName text NOT NULL UNIQUE,\n"
                + "brand text,\n"
                + "description text,\n"
                + "itemImage text NOT NULL,\n"
                + "gender text NOT NULL,\n"
                + "size text NOT NULL,\n"
                + "price text NOT NULL,\n"
                + "stock integer NOT NULL,\n"
                + "email text NOT NULL\n" + ");";
        state.execute(sql5);
	}
	
	
	
	
	

	/*
	 * ************* LoginPage *************
	 */

	// method that can be accessed to add users to database
	public void addUser(String email, String password) throws ClassNotFoundException, SQLException {

		if (con == null) {
			getConnection();
		}

		PreparedStatement prep = con.prepareStatement("INSERT INTO users values(?,?,?);");
		prep.setString(2, email);
		prep.setString(3, password);
		prep.execute();
		System.out.println("Account successfully created!");
	}

	// Queries the DB for email and password and compares input email and
	// password to DB
	// if 1 exact match
	public boolean logIn(String email, String password) throws ClassNotFoundException, SQLException {
		if (con == null) {
			getConnection();
		}
		String sql = "SELECT * FROM users WHERE email='" + email + "' and password='" + password + "'";
		PreparedStatement prep1;
		try {
			prep1 = con.prepareStatement(sql);
			ResultSet rs = prep1.executeQuery();
			int count = 0;
			while (rs.next()) {
				count++;
			}
			rs.close();
			if (count >= 1) {
				System.out.println("Logging In");
				System.out.println("Welcome, " + email);
				return true;
			} else {
				System.out.println("email or password is incorrect");
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//Checks if user is Admin
	public boolean isAdmin(String email) {
    	if (con == null) {
			try {
				getConnection();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    	try {
			ResultSet rs = con.prepareStatement("SELECT * FROM users WHERE email ='" + email + "'")
					.executeQuery();
			String type = rs.getString("type");
			rs.close();
			if(type.equals("admin")) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return false;
    }
	
	
	
	
	
	

	/*
	 * ************* CheckoutPage *************
	 */

	// Used on the CreditCard window to save shipping information for accounts
	public void saveInfo(String email, String fName, String lName, String address, String city, String state,
			int zipCode) throws SQLException, ClassNotFoundException {
		if (con == null) {
			getConnection();
		}
		PreparedStatement prep = con.prepareStatement("INSERT INTO shippingInfo values(?,?,?,?,?,?,?,?);");
		prep.setString(2, email);
		prep.setString(3, fName);
		prep.setString(4, lName);
		prep.setString(5, address);
		prep.setString(6, city);
		prep.setString(7, state);
		prep.setInt(8, zipCode);
		prep.execute();
	}

	// Used on CreditCard window to save billing information for accounts
	public void saveBilling(String email, String address, String city, String state, String zipCode, String card,
			String expirationDate) throws SQLException, ClassNotFoundException {
		if (con == null) {
			getConnection();
		}
		PreparedStatement prep = con.prepareStatement("INSERT INTO billingInfo values(?,?,?,?,?,?,?,?);");
		prep.setString(2, email);
		prep.setString(3, address);
		prep.setString(4, city);
		prep.setString(5, state);
		prep.setString(6, zipCode);
		prep.setString(7, card);
		prep.setString(8, expirationDate);
		prep.execute();
	}

	public List<String> getShippingInfo(String email) throws ClassNotFoundException, SQLException {
		List<String> shippingInfo = new ArrayList<String>();
		if (con == null) {
			getConnection();
		}

		ResultSet rsShipping = con.prepareStatement("SELECT * FROM shippingInfo WHERE email ='" + email + "'")
				.executeQuery();
		shippingInfo.add(rsShipping.getString("email"));
		shippingInfo.add(rsShipping.getString("fname"));
		shippingInfo.add(rsShipping.getString("lname"));
		shippingInfo.add(rsShipping.getString("address"));
		shippingInfo.add(rsShipping.getString("city"));
		shippingInfo.add(rsShipping.getString("state"));
		shippingInfo.add(rsShipping.getString("zipCode"));
		rsShipping.close();
		return shippingInfo;

	}
	//Figured out you can't return resultSets without getting really annoying errors
	//To avoid this methods that query the DB should return Lists, or arrays, or something else thats not resultSets
	//Returns BillingInfo
	public List<String> getBillingInfo(String email) throws ClassNotFoundException, SQLException {
		List<String> billingInfo = new ArrayList<String>();
		if (con == null) {
			getConnection();
		}
		ResultSet rsBilling = con.prepareStatement("SELECT * FROM billingInfo WHERE email = '" + email + "'")
				.executeQuery();
		billingInfo.add(rsBilling.getString("address"));
		billingInfo.add(rsBilling.getString("city"));
		billingInfo.add(rsBilling.getString("state"));
		billingInfo.add(rsBilling.getString("zipCode"));
		billingInfo.add(rsBilling.getString("cardNumber"));
		billingInfo.add(rsBilling.getString("expirationDate"));
		rsBilling.close();
		return billingInfo;

	}

	// May be easier way to do this but transfers data from shipping information
	// DB to billing information DB
	// Intended to make useShippingAddress button work
	public void useShippingAddress(String email) throws ClassNotFoundException, SQLException {
		if (con == null) {
			getConnection();
		}
		String sqlShipping = "SELECT * FROM shippingInfo WHERE email ='" + email + "'";
		String sqlBilling = "INSERT INTO billingInfo values(?,?,?,?,?,?,?,?);";
		PreparedStatement prepShipping;
		PreparedStatement prepBilling;
		prepShipping = con.prepareStatement(sqlShipping);
		prepBilling = con.prepareStatement(sqlBilling);
		ResultSet rsShipping = prepShipping.executeQuery();
		if (rsShipping.next()) {
			prepBilling.setString(2, rsShipping.getString("email"));
			prepBilling.setString(3, rsShipping.getString("address"));
			prepBilling.setString(4, rsShipping.getString("city"));
			prepBilling.setString(5, rsShipping.getString("state"));
			prepBilling.setString(6, rsShipping.getString("zipCode"));
		}
		rsShipping.close();
	}
	
	
	
	
	
	
	

	/*
	 * ************* ProductPage *************
	 */
	
	//Returns a list of Item Objects(See item class it's pretty straight forward) for manipulation in other classes.
	//Has "description" as a parameter and acts like a filter for the database to choose what data to fetch.
	//pass descriptions right now can be "mShirt", "mPants", "wShirt", "wPants" 
	//however only current items are those with the mShirt description
	public List<Item> getItemInfo(String description) {
		List<Item> itemList = new ArrayList<Item>();
		if (con == null) {
			try {
				getConnection();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		try {
			ResultSet rsItems = con.prepareStatement("SELECT * FROM items WHERE description ='" + description + "'")
					.executeQuery();
			while (rsItems.next()) {
				Item item = new Item();
				item.setItemName(rsItems.getString("itemName"));
				item.setBrand(rsItems.getString("brand"));
				item.setDescription(rsItems.getString("description"));
				item.setItemImage(rsItems.getString("itemImage"));
				item.setGender(rsItems.getString("gender"));
				item.setSize(rsItems.getString("size"));
				item.setPrice(rsItems.getDouble("price"));
				item.setStock(rsItems.getInt("stock"));
				itemList.add(item);
			}
			rsItems.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemList;
	}
	
	
	
	

	/*
	 * ************** ShoppingCart **************
	 */
	

	//adds data into the shopping cart database, but does not add the data into the gui
    
    public void add(String itemName,String brand,String description,String itemImage,String gender,String size,double price,int stock, String email) throws ClassNotFoundException, SQLException{
        if(con == null){
            getConnection();
        }
        try {
        
            PreparedStatement prep = con.prepareStatement("insert into shoppingCart values(?,?,?,?,?,?,?,?,?,?);");

            prep.setString(2, itemName);
            prep.setString(3, brand);
            prep.setString(4, description);
            prep.setString(5, itemImage);
            prep.setString(6, gender);
            prep.setString(7, size);
            prep.setDouble(8, price);
            prep.setInt(9, stock);
            prep.setString(10, email);
            
            prep.executeUpdate();
            prep.close();
            
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //shows everything in shopping cart database. doesn't display data in the gui.
    
    public void displayTable() throws ClassNotFoundException, SQLException{ 
        if(con == null){
            getConnection();
        }
        PreparedStatement prep=null;
        try {
        
            prep = con.prepareStatement("select * from shoppingCart");
            
            ResultSet show = prep.executeQuery();
            
            while(show.next()) {
                int id = show.getInt("id");
                String name = show.getString("itemName");
                String image = show.getString("itemImage");
                String gender = show.getString("gender");
                String size = show.getString("size");
                String price = show.getString("price");
                
                System.out.printf("%d, %s, %s, %s,%s,%s\n", id, name, image, gender,size,price);
            }
            show.close();
        
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //gets the data from shopping cart database for use in the shoppingCart.java
    public List<Item> getShoppingCart(String email) throws ClassNotFoundException, SQLException{ //gets the name of the item only
    	List<Item> itemList = new ArrayList<Item>();
		if (con == null) {
			try {
				getConnection();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		try {
			ResultSet rsItems = con.prepareStatement("SELECT * FROM shoppingCart WHERE email ='" + email + "'")
					.executeQuery();
			while (rsItems.next()) {
				Item item = new Item();
				item.setId(rsItems.getString("id"));
				item.setItemName(rsItems.getString("itemName"));
				item.setBrand(rsItems.getString("brand"));
				item.setDescription(rsItems.getString("description"));
				item.setItemImage(rsItems.getString("itemImage"));
				item.setGender(rsItems.getString("gender"));
				item.setSize(rsItems.getString("size"));
				item.setPrice(rsItems.getDouble("price"));
				item.setStock(rsItems.getInt("stock"));
				itemList.add(item);
			}
			rsItems.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemList;
    }
    
    //Removes items from shopping cart
    //Takes Shopping cart id, and email.(Using name instead of id would have resulted in any duplicates being deleted
    public void remove(String id, String email) {
    	if (con == null) {
			try {
				getConnection();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    	String sql = "Delete FROM shoppingCart WHERE email = ? AND id = ?";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			 // set the corresponding param
	        pstmt.setString(1, email);
	        pstmt.setString(2, id);
	        // execute the delete statement
	        pstmt.executeUpdate();
	        pstmt.close();
	        
	    	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    }
    
    
    
    
    
    
    /*
	 * ************** InventoryPages **************
	 */
    //Takes item object so there isn't a ton of parameters
    public void addItemToDB(Item item) {
    	if (con == null) {
			try {
				getConnection();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    	String sql = "INSERT INTO items values(?,?,?,?,?,?,?,?,?);";
    	PreparedStatement pstmt;
    	try {
			pstmt = con.prepareStatement(sql);
	        pstmt.setString(2, item.getItemName());
	        pstmt.setString(3, item.getBrand());
	        pstmt.setString(4, item.getDescription());
	        pstmt.setString(5, item.getItemImage());
	        pstmt.setString(6, item.getGender());
	        pstmt.setString(7, item.getSize());
	        pstmt.setDouble(8, item.getPrice());
	        pstmt.setInt(9, item.getStock());
	        pstmt.executeUpdate();
	        pstmt.close();
	    	
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    }
    public void deleteItemFromDB(int id) {
    	if (con == null) {
			try {
				getConnection();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    	String sql = "DELETE FROM items WHERE id = ?";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			 // set the corresponding param
	        pstmt.setInt(1, id);
	        // execute the delete statement
	        pstmt.executeUpdate();
	        pstmt.close();
	    	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    }
    public List<Item> getAllItems() {
    	List<Item> itemList = new ArrayList<Item>();
    	if (con == null) {
			try {
				getConnection();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    	try {
			ResultSet rsItems = con.prepareStatement("SELECT * FROM items").executeQuery();
			while(rsItems.next()) {
				Item item = new Item();
				item.setId(rsItems.getString("id"));
				item.setItemName(rsItems.getString("itemName"));
				item.setBrand(rsItems.getString("brand"));
				item.setDescription(rsItems.getString("description"));
				item.setItemImage(rsItems.getString("itemImage"));
				item.setGender(rsItems.getString("gender"));
				item.setSize(rsItems.getString("size"));
				item.setPrice(rsItems.getDouble("price"));
				item.setStock(rsItems.getInt("stock"));
				itemList.add(item);
			}
			rsItems.close();
			return itemList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
}
