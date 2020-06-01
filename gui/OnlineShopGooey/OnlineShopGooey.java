import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

class OnlineShopGooey extends JFrame implements ActionListener {
	static File manFile = new File("man.conf");
	static File recFile = new File("receipt.txt"); // receipt
	
	static String[] names = new String[10];
	static double[] cost = new double[10];
	static int[] stock = new int[10];
	static int filled;
	
	static int[] cart = new int[10];
	static double[] taxprovters = {5, 12, 13, 15, 15, 5, 15, 5, 13, 15, 14.975, 11, 5}; // contains tax rates for provinces and territories
	static String[] provters = {"Alberta", "British Columbia", "Manitoba", "New Brunswick", "Newfoundland", "Northwest Territories", "Nova Scotia", "Nunavut Territory", "Ontario", "Prince Edward Island", "Quebec", "Saskatchewan", "Yukon Territory"};
	
	static double revenue = 0; // global revenue
	
	static JPanel mainMenu = new JPanel();
	static JButton[] mainMenuButton = {new JButton("Manager Mode"), new JButton("Customer Mode"), new JButton("Exit")};
	
	static JPanel manMenu = new JPanel();
	static JLabel[] manCategories = {new JLabel("Name"), new JLabel("Price"), new JLabel("Stock")};
	static JButton[] manMenuButton = {new JButton("Back")};
	static JTextField[] manNames;
	static JTextField[] manPrices;
	static JTextField[] manStocks;
	
	static JPanel cusMenu = new JPanel();
	static JButton[] cusMenuButton;
	static JLabel[] cusCategories = {new JLabel("Name"), new JLabel("Price"), new JLabel("Stock"), new JLabel("In cart")};
	static JLabel[] cusNames;
	static JLabel[] cusPrices;
	static JLabel[] cusStocks;
	static JTextField[] cusCart;
	static JButton[] cusAddCart;
	static JButton[] cusRemoveCart;
	
	// gooey methods	
	public OnlineShopGooey() {	
		cusNames = new JLabel[10];
		for (int i = 0; i < names.length; i++) {
			cusNames[i] = new JLabel(names[i]);
		}
		
		manMenu.setLayout(new GridLayout(5, 3));
		for (JLabel label : manCategories) {
			manMenu.add(label);
		}
		
		cusMenu.setLayout(new GridLayout(5, 4));
		for (JLabel label : cusCategories) {
			cusMenu.add(label);
		}
		
		for (JLabel label : cusNames) {
			cusMenu.add(label);
		}
			
		mainMenu.setLayout(new BoxLayout(mainMenu, BoxLayout.PAGE_AXIS));		
		
		for (JButton butt : mainMenuButton) {
			mainMenu.add(butt);
			butt.setAlignmentX(Component.CENTER_ALIGNMENT);
			mainMenu.add(Box.createVerticalStrut(10));
			butt.addActionListener(this);
		}

		
		add(mainMenu);
		add(manMenu);
		manMenu.setVisible(false);
		add(cusMenu);
		cusMenu.setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridBagLayout());
		setSize(500, 500);
		setTitle("Welcome to " + rngName());
		setVisible(true);
	}
	
	public static void main(String[] args) throws Exception {
		readAll();
		OnlineShopGooey window = new OnlineShopGooey();
	}
	
	public void actionPerformed(ActionEvent event) {
		setTitle("Welcome to " + rngName());
		if (event.getSource() == mainMenuButton[0]) {
			mainMenu.setVisible(false);
			manMenu.setVisible(true);
		} else if (event.getSource() == mainMenuButton[1]) {
			mainMenu.setVisible(false);
			cusMenu.setVisible(true);
		} else if (event.getSource() == mainMenuButton[2]) {
			dispose();
		}
	}
	
	static String rngName() {
		String[] storeNames = {"Osrus", "OS R'US", "A store"}; // various store names 
		return storeNames[(int)(Math.random() * 3)];
	} // end rngname
	
	// io methods
	static void readAll() throws Exception {
		if (manFile.exists() && !manFile.isDirectory()) {
			Scanner finput = new Scanner(manFile);
			
			for (int i = 0; i < 10; i++) {
				names[i] = finput.nextLine();
				cost[i] = finput.nextDouble();
				stock[i] = finput.nextInt();
				cart[i] = finput.nextInt();
				
				finput.nextLine();
			}
		}
	}
	
	static void writeReceipt(double total, double subtotal, double discount, double tax, int location) throws Exception { // give time and day, shop name, normal receipt stuff
		// also check if file already exists and make new one with current day]
		PrintWriter foutput = new PrintWriter(recFile);
		foutput.println(rngName());
		foutput.println();
		for (int i = 0; i < names.length; i++) {
			if (cart[i] > 0) {
				foutput.println(cart[i] + "x " + names[i] + " - $" + String.format("%.2f", (double) cost[i] * cart[i]) + " - $" + cost[i] + " ea");
			}
		}
		
		if (discount != 0) {
			foutput.println("Subtotal: $" + String.format("%.2f", subtotal/(1 - discount/100.0))); // output original price
			foutput.println("Discount: " + discount + "% off ($" + String.format("%.2f", subtotal/(1 - discount/100.0) - subtotal) + " off)"); // remind user they got a discount
			foutput.println("New subtotal: $" + String.format("%.2f", subtotal)); // output calculated price
		} else {
			foutput.println("Subtotal: $" + subtotal);
		} // end else
		
		foutput.println("Tax: $" + String.format("%.2f", tax) + " (" + taxprovters[location] + "%)");
		foutput.println("Total: $" + String.format("%.2f",total));
		foutput.println();
		
	}
	
	static void writeManager() throws Exception { // call every time it's modified
		PrintWriter foutput = new PrintWriter(manFile);
	}
}
