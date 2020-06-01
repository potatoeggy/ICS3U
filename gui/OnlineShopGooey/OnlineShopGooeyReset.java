// Daniel Chen
// 14 January 2020
// Online shop but with a gooey

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

class OnlineShopGooeyReset extends JFrame implements ActionListener {
	static File manFile = new File("man.conf"); // configuration file to read later
	static File recFile = new File("receipt.txt"); // receipt

	static String[] names = new String[10]; // internal variables
	static double[] cost = new double[10];
	static int[] stock = new int[10];
	static int[] cart = new int[10];
	static double[] taxprovters = {0, 5, 12, 13, 15, 15, 5, 15, 5, 13, 15, 14.975, 11, 5}; // contains tax rates for provinces and territories
	static String[] provters = {"(Select province/territory)", "Alberta", "British Columbia", "Manitoba", "New Brunswick", "Newfoundland", "Northwest Territories", "Nova Scotia", "Nunavut Territory", "Ontario", "Prince Edward Island", "Quebec", "Saskatchewan", "Yukon Territory"};
	static double revenue = 0; // global revenue
	
	static JPanel mainMenu = new JPanel(); // gooey main menu
	static JButton[] mainMenuButton = {new JButton("Manager"), new JButton("Customer"), new JButton("Exit")};
	static JLabel mainMenuLabel = new JLabel(new ImageIcon("os.png"));
	static JLabel welcomeLabel = new JLabel("");
	
	static JPanel manMenu = new JPanel(); // gooey manager menu
	static JPanel manMenu2 = new JPanel();
	static JLabel[] revenueLabels = {new JLabel(""), new JLabel(""), new JLabel("")};
	static JLabel[] manCategories = {new JLabel("Name"), new JLabel("Price"), new JLabel("Stock")};
	static JLabel manBlank = new JLabel("");
	static JButton[] manButton = {new JButton("Cancel"), new JButton("OK")};
	static JTextField[] manNames = new JTextField[10];
	static JTextField[] manPrices = new JTextField[10];
	static JTextField[] manStocks = new JTextField[10];
	
	static JPanel cusMenu = new JPanel(); // gooey customer menu
	static JLabel[] cusBlank = {new JLabel(""), new JLabel("")};
	static JLabel[] cusCategories = {new JLabel("Name", JLabel.LEFT), new JLabel("Price", JLabel.RIGHT), new JLabel("Stock", JLabel.LEFT), new JLabel("In cart", JLabel.LEFT)};
	static JLabel[] cusNames = new JLabel[10];
	static JLabel[] cusPrices = new JLabel[10];
	static JLabel[] cusStocks = new JLabel[10];
	static JTextField[] cusCart = new JTextField[10];
	
	static JPanel checkoutMenu = new JPanel(); // gooey checkout menu
	static JPanel checkoutRight = new JPanel();
	static JPanel checkoutInfo = new JPanel();
	static JComboBox<String> taxBox = new JComboBox<>(provters);
	static JLabel taxLabel = new JLabel("Province/Territory");
	static JLabel[] miniReceipt = {new JLabel("Subtotal: "), new JLabel("Random discount: "), new JLabel("Subtotal after discount: "), new JLabel("Tax: "), new JLabel("Total: ")};
	static JLabel[] miniReceiptValues = {new JLabel("$0.00"), new JLabel("$0.00 (0% off)"), new JLabel("$0.00"), new JLabel("$0.00 (0%)"), new JLabel("$0.00")};
	static JButton[] checkoutButton = {new JButton("Cancel/Exit"), new JButton("Checkout")};
	
	static double subtotal = 0; // checkout internal variables
	static double tax = 0;
	static double taxRate = 0;
	static int discount = 0;
	static double total = 0;
	
	// cool pics
	static ImageIcon[] icons = {new ImageIcon("windows.png"), new ImageIcon("macos.png"), new ImageIcon("linux.png"), new ImageIcon("android.png")};
	
	// gooey methods
	public OnlineShopGooeyReset() {
		// image setup
		initAll();
		resetAll();
		
		// manager setup
		manMenu.setLayout(new GridLayout(13, 3, 5, 5));
		manMenu2.setLayout(new FlowLayout());
		manBlank.setForeground(Color.red);
		for (JLabel label : revenueLabels) { // add revenue and value
			manMenu.add(label);
		}
		for (JLabel label : manCategories) { // give titles
			manMenu.add(label);
			label.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0)); // make look pretty margins
		}
		for (int i = 0; i < names.length; i++) { // add editable boxes
			manMenu.add(manNames[i]);
			manMenu.add(manPrices[i]);
			manMenu.add(manStocks[i]);
		}
		manMenu.add(manBlank);
		for (JButton butt : manButton) { // make buttons look pretty
			butt.setBackground(Color.white);
			butt.addActionListener(this);
			manMenu2.add(butt);
		}
		
		// customer setup
		cusMenu.setLayout(new GridLayout(12, 4, 0, 5)); // padding the gridlayout
		for (JLabel label : cusCategories) {
			label.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 0)); // add padding for labels
			cusMenu.add(label);
		}
		for (int i = 0; i < names.length; i++) { // add textfields and info for user
			cusMenu.add(cusNames[i]);
			cusMenu.add(cusPrices[i]);
			cusMenu.add(cusStocks[i]);
			cusMenu.add(cusCart[i]);
		}
		for (JLabel label : cusBlank) { // stupid gridlayout
			cusMenu.add(label);
		}
		cusBlank[0].setForeground(Color.red); // prepare to yell at user
		
		mainMenu.setLayout(new BoxLayout(mainMenu, BoxLayout.Y_AXIS));
		// make things more user-friendly, literally
		mainMenu.add(welcomeLabel);
		welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainMenu.add(Box.createVerticalStrut(50));
		
		for (JButton butt : mainMenuButton) { // make buttons look pretty
			butt.setBackground(Color.WHITE);
			mainMenu.add(butt);
			butt.setAlignmentX(Component.CENTER_ALIGNMENT);
			mainMenu.add(Box.createVerticalStrut(10)); // button spacing
			butt.addActionListener(this);
		}
		
		mainMenu.add(Box.createVerticalStrut(150)); // spacing between buttons and logo
		mainMenu.add(mainMenuLabel); // big cool logo
		mainMenuLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		checkoutInfo.setLayout(new GridLayout(6, 2)); // minireceipt
		checkoutInfo.add(taxLabel);
		taxBox.addActionListener(this);
		taxBox.setVisible(false);
		taxLabel.setVisible(false);
		checkoutInfo.add(taxBox);
		
		for (int i = 0; i < miniReceipt.length; i++) { // add minireceipt that f
			checkoutInfo.add(miniReceipt[i]);
			checkoutInfo.add(miniReceiptValues[i]);
		}
		
		checkoutRight.setLayout(new FlowLayout());
		taxBox.setBackground(Color.white);
		
		for (JButton butt : checkoutButton) { // make more buttons prettier
			butt.setBackground(Color.WHITE);
			checkoutRight.add(butt);
			butt.addActionListener(this);
		}
		checkoutMenu.setLayout(new GridLayout(1, 2));
		checkoutMenu.add(checkoutInfo);
		checkoutMenu.add(checkoutRight);

		for (JPanel panel : new JPanel[] {manMenu, manMenu2, cusMenu, mainMenu, checkoutMenu, checkoutInfo, checkoutRight}) {
			panel.setBackground(Color.WHITE); // make everything uniform and get rid of the ugly metal look-and-feel
		}
		
		add(mainMenu);
		add(manMenu);
		add(manMenu2);
		add(cusMenu);
		add(checkoutMenu);
		
		clearFrame();
		mainMenu.setVisible(true);
		getRootPane().setBorder(BorderFactory.createLineBorder(Color.white, 20)); // create margins
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
		setSize(800, 700);
		setTitle("Welcome to " + rngName()); // rng the name every time
		getContentPane().setBackground(Color.WHITE);
		setLocationRelativeTo(null); // centre things
		setVisible(true);
	}
	
	public static void main(String[] args) throws Exception {
		try {
			readAll(); // load from file
		} catch (Exception e) {
		}
		initAll();
		OnlineShopGooeyReset window = new OnlineShopGooeyReset();
		while (window.isVisible()) { // sketchy solution to updating things live
			while (cusMenu.isVisible()) {
				Thread.sleep(1000); // wait 
				if (changeCart()) {
					updateMiniReceipt();
				}
			}
			Thread.sleep(2000); // give time for the receipt to go away
		}
	}
	
	public void actionPerformed(ActionEvent event) {
		boolean reset = true;
		cusBlank[0].setForeground(Color.red);
		
		for (Component thing : new Component[] {taxBox, taxLabel, miniReceipt[3], miniReceipt[4], miniReceiptValues[3], miniReceiptValues[4]}) {
			thing.setVisible(false); // more sketchy solutions to getting rid of things in cusmenu
		}

		setTitle("Welcome to " + rngName());
		if (event.getSource() == mainMenuButton[0]) {
			revenueLabels[0].setText("Revenue = $" + String.format("%.2f", revenue));
			clearFrame();
			manMenu.setVisible(true);
			manMenu2.setVisible(true);
		} else if (event.getSource() == mainMenuButton[1]) { // go to customer menu
			cusBlank[0].setText(""); // clear error box
			clearFrame();
			cusMenu.setVisible(true);
			checkoutMenu.setVisible(true);
		} else if (event.getSource() == mainMenuButton[2]) { // exit
			dispose();
		} else if (event.getSource() == checkoutButton[0]) { // go back to main from customer menu
			if (! cusMenu.isVisible()) { // go back to customer menu if we're done a transaction
				resetAll();
				cusMenu.setVisible(true);
			} else { // otherwise go back to main menu because we're actually still at customer menu
				clearFrame();
				mainMenu.setVisible(true);
			}	
		} else if (event.getSource() == checkoutButton[1]) { // checkout button
			if (cusMenu.isVisible()) {
				if (changeCart()) {
					cusMenu.setVisible(false);
					for (Component thing : new Component[] {taxBox, taxLabel, miniReceipt[3], miniReceipt[4], miniReceiptValues[3], miniReceiptValues[4]}) {
						thing.setVisible(true); // make all the checkout things visible
					}
				}
			} else {
				if (taxBox.getBorder() == new JComboBox().getBorder()) { // checking if combobox is not red because that means there's an error
					checkout();
					cusMenu.setVisible(true);
				} else {
					for (Component thing : new Component[] {taxBox, taxLabel, miniReceipt[3], miniReceipt[4], miniReceiptValues[3], miniReceiptValues[4]}) {
						thing.setVisible(true); // override for loop at beginning of method
					}
				} // end else
			} // end bigger else
		} else if (event.getSource() == manButton[1]) { // ok button in manager
			if (changeInv()) { // checking if input is valid
				resetBorders(); // make everything unred
				clearFrame();
				mainMenu.setVisible(true);
				try { // stupid exception throwers
					writeAll();
				} catch (Exception e) {
				}
			}
		} else if (event.getSource() == manButton[0]) { // cancel button in manager
			resetBorders();
			clearFrame();
			mainMenu.setVisible(true);
		} else if (event.getSource() == taxBox) { // if user changes provinces:
			if (changeCart()) { // these two basically update cart and receipt
				updateMiniReceipt();
			}
			for (Component thing : new Component[] {taxBox, taxLabel, miniReceipt[3], miniReceipt[4], miniReceiptValues[3], miniReceiptValues[4]}) {
				thing.setVisible(true); // override thing on top
			}
			reset = false; // override thing on bottom
		}	
		
		if (reset) {
			resetAll();
		}
		repaint(); // redraw just in case
	} // end actionPerformed
	
	static String rngName() {
		String[] storeNames = {"Osrus", "OS R'US", "A store", "Canada Operating Systems", "eBay", "Piracy Enterprises", "GNU", "Arduino", "Raspberry", "Pi", "Xunil", "Microsoft", "Amazon"}; // various store names 
		return storeNames[(int)(Math.random() * 13)];
	} // end rngname
	
	static void checkout() {
		try {
			writeReceipt(); // write to receipt before cart is reset
		} catch (Exception e) {
		}
		
		for (int i = 0; i < cart.length; i++) {
			stock[i] -= cart[i]; // process cart and stock
			cart[i] = 0; // reset cart
		}
		revenue += subtotal; // gib revenue
		try {
			writeAll(); // save so user can't reset
		} catch (Exception e) {
		}
		
		resetAll(); // wipe to original state
		cusBlank[0].setForeground(Color.green);
		cusBlank[0].setText("receipt.txt saved."); // hopefully this is user-friendly enough
	} // end checkout
	
	static void updateMiniReceipt() { // updates the live counter at the left with dynamic discounts
		subtotal = 0; // because i didn't plan ahead
		tax = 0;
		taxRate = 0;
		total = 0;
		
		resetBorders();
		taxBox.setBorder(new JComboBox().getBorder()); // reset border which should really be in the method above
		cusBlank[0].setText("");
		String string = (String) taxBox.getSelectedItem();
		
		if (string.equals("(Select province/territory)")) {
			taxBox.setBorder(BorderFactory.createLineBorder(Color.red)); // not a valid province/territory
		} else {
			for (int i = 0; i < taxprovters.length; i++) { // calculate tax
				if (string.equals(provters[i])) {
					taxRate = taxprovters[i];
					break;
				}
			} // end for
		} // end else
		
		for (int i = 0; i < names.length; i++) {
			subtotal += cart[i] * cost[i]; // calculate subtotal every 2 seconds
		}
		
		miniReceiptValues[0].setText("$" + String.format("%.2f", subtotal)); // display subtotal
		
		// randomly determine if they get a discount (1 in 5 chance)
		if ((int) (Math.random() * 10) < 2) {
			discount = (int) (Math.random() * 10) * 5; // it's a pretty big discount
		} // end if
		
		subtotal -= subtotal * discount / 100; // take their costs away
		tax = subtotal * taxRate / 100;
		total = subtotal + tax;
		
		miniReceiptValues[1].setText("-$" + String.format("%.2f", subtotal/(1 - discount/100.0) - subtotal) + " (" + discount + "% off)"); // display discount
		miniReceiptValues[2].setText("$" + String.format("%.2f", subtotal)); // display subtotal after discount
		miniReceiptValues[3].setText("$" + String.format("%.2f", tax) + " (" + taxRate + "%)"); // display tax
		miniReceiptValues[4].setText("$" + String.format("%.2f", subtotal + tax)); // display total
	}
	
	static void clearFrame() { // wipes all panels
		for (JPanel panel : new JPanel[] {manMenu, manMenu2, mainMenu, cusMenu, checkoutMenu}) {
			if (panel.isVisible()) {
				panel.setVisible(false);
			}
		} // end for
	} // end clearFrame
	
	static void resetBorders() { // resets most borders to default
		for (int i = 0; i < 10; i++) {
			manPrices[i].setBorder(new JTextField().getBorder());
			manStocks[i].setBorder(new JTextField().getBorder());
			cusCart[i].setBorder(new JTextField().getBorder());
		}
		manBlank.setText(""); // also clears errors
	} // end resetBorders
	
	static boolean changeCart() { // returns true if no errors are found in modifying art
		cusBlank[0].setText(""); // reset errors
		for (int i = 0; i < cart.length; i++) {
			try { // used to catch for invalid input
				int temp = Integer.parseInt(cusCart[i].getText());
				if (temp < 0 || temp > stock[i]) {
					cusBlank[0].setText("Invalid input.");
					cusCart[i].setBorder(BorderFactory.createLineBorder(Color.red)); // angry red user
				} else {
					cart[i] = temp; // no errors, everything should work
				}
			} catch (Exception e) {
				cusBlank[0].setText("Invalid input.");
				cusCart[i].setBorder(BorderFactory.createLineBorder(Color.red));
			}
		} // end for
		return ! cusBlank[0].getText().equals("Invalid input."); // check for if things failed and return the opposite 
	} // end changeCart
	
	static boolean changeInv() { // basically changecart but for manager inventory
		manBlank.setText("");
		for (int i = 0; i < names.length; i++) {
			names[i] = manNames[i].getText(); // shouldn't be any problems here
			try { // same as above section in changeCart
				double tempDouble = Double.parseDouble(manPrices[i].getText());
				
				if (tempDouble < 0) {
					manBlank.setText("Invalid input.");
					manPrices[i].setBorder(BorderFactory.createLineBorder(Color.red));
				} else {
					cost[i] = tempDouble;
				}				
			} catch (Exception e) {
				manBlank.setText("Invalid input.");
				manPrices[i].setBorder(BorderFactory.createLineBorder(Color.red));
			}
			
			try { // we split this up because i dont wanna handle figuring out which box is which in a single catch
				int tempInt = Integer.parseInt(manStocks[i].getText());
				if (tempInt < 0) {
					manBlank.setText("Invalid input.");
					manStocks[i].setBorder(BorderFactory.createLineBorder(Color.red));
				} else {
					stock[i] = tempInt;
				}
			} catch (Exception e) {
				manBlank.setText("Invalid input.");
				manStocks[i].setBorder(BorderFactory.createLineBorder(Color.red));
			}
		}
		
		if (manBlank.getText().equals("Invalid input.")) { // if things failed yell and complain
			return false;
		} else {
			resetBorders();
			return true;
		}
	}
	
	// io methods
	static void readAll() throws Exception { // load from file
		if (manFile.exists() && !manFile.isDirectory()) { // ensuring things don't break
			Scanner finput = new Scanner(manFile); // read from file at top
			try {
				for (int i = 0; i < 10; i++) { // parse config file that user should not be touching
					names[i] = finput.nextLine();
					cost[i] = Double.parseDouble(finput.nextLine());
					stock[i] = Integer.parseInt(finput.nextLine());
					cart[i] = Integer.parseInt(finput.nextLine());
					try {
						finput.nextLine(); // there's a newline between everything for readability
					} catch (Exception e) {
					}
				} // end for
			} catch (Exception e) { // if anything goes wrong and/or config file is incomplete reset it
				for (int i = 0; i < 10; i++) {
					names[i] = "";
					cost[i] = 0;
					stock[i] = 0;
					cart[i] = 0;
				}
			} // end catch
			finput.close();
		} else {
			for (int i = 0; i < 10; i++) {
				names[i] = "";
				cost[i] = 0;
				stock[i] = 0;
				cart[i] = 0;
			}
		} // end else
	} // end readAll
	
	static void writeAll() throws Exception { // save to file
		PrintWriter foutput = new PrintWriter(manFile);
		for (int i = 0; i < 10; i++) {
			foutput.println(names[i]);
			foutput.println(cost[i]);
			foutput.println(stock[i]);
			foutput.println(cart[i]);
			foutput.println();
		}
		foutput.close();
	} // end writeAll
	
	static void initAll() { // initialise arrays and gooey objects, should only be needed once
		for (int i = 0; i < 10; i++) {
			cusNames[i] = new JLabel(names[i], SwingConstants.LEFT);
			manNames[i] = new JTextField(names[i], SwingConstants.LEFT);
			
			cusPrices[i] = new JLabel("$" + String.format("%.2f", cost[i]), SwingConstants.RIGHT);
			manPrices[i] = new JTextField(String.format("%.2f", cost[i]));
			
			cusStocks[i] = new JLabel("      " + stock[i], SwingConstants.LEFT);
			manStocks[i] = new JTextField(Integer.toString(stock[i]), SwingConstants.LEFT);
			
			cusCart[i] = new JTextField(Integer.toString(cart[i]), SwingConstants.LEFT);
		} // end for
	} // end initAll
	
	static void resetAll() { // modifies gooey objects to match them with current internal variables
		for (int i = 0; i < 10; i++) {
			cusNames[i].setText(names[i]);
			manNames[i].setText(names[i]);
			
			cusPrices[i].setText("$" + String.format("%.2f", cost[i]));
			manPrices[i].setText(String.format("%.2f", cost[i]));
			
			if (stock[i] > 0) {
				cusStocks[i].setText("      " + stock[i]);
			} else {
				cusStocks[i].setText("      Out of stock");
			}
			
			manStocks[i].setText(Integer.toString(stock[i]));
			
			cusCart[i].setText(Integer.toString(cart[i]));
			if (manNames[i].getText().equals("")) { // if there's nothing there don't show it
				cusNames[i].setVisible(false);
				cusPrices[i].setVisible(false);
				cusStocks[i].setVisible(false);
				cusCart[i].setVisible(false);
			} else {
				cusNames[i].setVisible(true);
				cusPrices[i].setVisible(true);
				cusStocks[i].setVisible(true);
				cusCart[i].setVisible(true);
			}
			if (cusNames[i].getText().toLowerCase().contains("windows")) { // pictures in customer menu
				cusNames[i].setIcon(icons[0]);
			} else if (cusNames[i].getText().toLowerCase().contains("macos")) {
				cusNames[i].setIcon(icons[1]);
			} else if (cusNames[i].getText().toLowerCase().contains("android")) {
				cusNames[i].setIcon(icons[3]);
			} else {
				cusNames[i].setIcon(icons[2]);
			}
		}
		miniReceiptValues[0].setText("$0.00"); // reset checkout menu
		miniReceiptValues[1].setText("-$0.00 (0% off)");
		miniReceiptValues[2].setText("$0.00");
		miniReceiptValues[3].setText("$0.00 (0%)");
		miniReceiptValues[4].setText("$0.00");
		
		welcomeLabel.setText("Welcome to " + rngName()); // rng for fun
	}
	
	static void writeReceipt() throws Exception { // shop name, normal receipt stuff
		PrintWriter foutput = new PrintWriter(recFile);
		foutput.println("Thank you for shopping at " + rngName()); // because rng is fun
		foutput.println(); // pretty receipt has spacing
		for (int i = 0; i < names.length; i++) {
			if (cart[i] > 0) { // output products
				foutput.println(cart[i] + "x " + names[i] + " - $" + String.format("%.2f", (double) cost[i] * cart[i]) + " - $" + String.format("%.2f", cost[i]) + " ea");
			}
		} // end for
		
		foutput.println();
		
		if (discount != 0) { // print calculations and all that
			foutput.println("Subtotal: $" + String.format("%.2f", subtotal/(1 - discount/100.0))); // output original price
			foutput.println("Discount: " + discount + "% off ($" + String.format("%.2f", subtotal/(1 - discount/100.0) - subtotal) + " off)"); // remind user they got a discount
			foutput.println("Subtotal after discount: $" + String.format("%.2f", subtotal)); // output calculated price
		} else {
			foutput.println("Subtotal: $" + subtotal); // if there is no discount ignore that
		} // end else
		
		foutput.println("Tax: $" + String.format("%.2f", tax) + " (" + taxRate + "%)");
		foutput.println("Total: $" + String.format("%.2f",total));
		foutput.println();
		foutput.close();
	} // end writeReceipt
} // end class
