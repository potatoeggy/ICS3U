// Daniel Chen
// 8 November 2019
// Online shop

import java.util.Scanner;

class OnlineShop {
	
	static String[] names = new String[10]; // init base arrays
	static double[] cost = new double[10];
	static int[] stock = new int[10];
	static int filled = 0;
	
	/* uncommment to use
	static String[] names = {"Microsoft Windows 10 Pro", "Solus 4", "Arch Linux 2019.11.01", "Ubuntu 18.04.2 LTS", "Microsoft Windows 7 Pro", "Microsoft Windows XP SP3", "Android 10", "macOS 10.15 Catalina", "Debian 10.1 Buster", "Android 8.1 Oreo"};
	static double[] cost = {199.99, 0.0, 15.0, 3.0, 159.99, 29.99, 20.0, 129.99, 1.0, 60.0};
	static int[] stock = {150, 2, 100, 1500, 5, 1, 50, 75, 3000, 10};
	static int filled = 10;
	*/
	
	static int[] cart = new int[10]; // cart variable
	static double[] taxprovters = {5, 12, 13, 15, 15, 5, 15, 5, 13, 15, 14.975, 11, 5}; // contains tax rates for provinces and territories
	static String[] provters = {"Alberta", "British Columbia", "Manitoba", "New Brunswick", "Newfoundland", "Northwest Territories", "Nova Scotia", "Nunavut Territory", "Ontario", "Prince Edward Island", "Quebec", "Saskatchewan", "Yukon Territory"};
	
	static double revenue = 0; // global revenue
	static Scanner input = new Scanner(System.in); // global scanner
	
	static double calcTax(double value, int area) {
		double rate = taxprovters[area]; // just returning calculations
		return value * rate / 100;
	}
	static void addProd() {
		while (true) { // loop indefinitely until user quits
			int chosenName = 0; // 0 to trigger loops
			int chosenStock = -1; // negative to trigger loops
			int holder = displayProd(); // everything returns int for what was originally navigational purposes
			System.out.println((filled + 1) + ". Back"); // provide user with option to quit
			System.out.println(); // make it look pretty
			do { // didn't think of making dotrycatchwhile function
				try {
					System.out.print("Product # to add: ");
					chosenName = input.nextInt() - 1; // align user input with array indexes
					if (chosenName == filled) {
						return; // leave method to return to main menu
					} else if (chosenName > filled || chosenName < 0) {
						error(1);
					} // end if
				} catch (Exception e) {
					error(0);
				} // end catch
			} while (chosenName > filled || chosenName < 0);
			
			do {
				try {
					System.out.print("Add count: ");
					chosenStock = input.nextInt();
					if (chosenStock > stock[chosenName] || chosenStock < 0) {
						System.out.println("Cannot add " + chosenStock + " of " + names[chosenName] + " to cart. Try again."); // handle out of stock items here or overstocking instead of checkout since it's easier
					} // end if
				} catch (Exception e) {
					error(0);
				} // end catch
			} while (chosenStock > stock[chosenName] || chosenStock < 0);
			
			cart[chosenName] += chosenStock;
			stock[chosenName] -= chosenStock; // add cart and reduce stock accordingly
			System.out.println("Added " + chosenStock + " of " + names[chosenName] + " to cart."); // user confirmation message
			System.out.println();
		} // end big while
	} // end addProd

	static int updateInv() {
		while (true) {
			int chosenName = 0;
			int chosenStock = -1;
			double chosenPrice = -1;
			int holder = displayInv();
			if (filled < 10) { // handle both updating products and new products here
				System.out.println((filled + 1) + ". New product");
				System.out.println((filled + 2) + ". Back");
			} else {
				System.out.println((filled + 1) + ". Back");
			}
			
			System.out.println(); // make it look pretty
			do {
				try {
					System.out.print("Product # to modify: ");
					chosenName = input.nextInt() - 1;
					if (chosenName == filled + 1) {
						return 0; // leave method
					} else if (chosenName == filled && filled == 10) {
						return 0; // leave method when you can't add new products
					} else if (chosenName > filled || chosenName < 0) {
						error(1);
					} // end if
				} catch (Exception e) {
					error(0);
				} // end catch
			} while (chosenName > filled || chosenName < 0);
			
			input.nextLine(); // clear scanner
			
			System.out.print("New product name: ");
			names[chosenName] = input.nextLine(); // modify everything in one go to avoid extra clicks
			
			do {
				try {
					System.out.print("New product price: ");
					chosenPrice = input.nextDouble();
					if (chosenPrice < 0) {
						System.out.println("Cannot set price less than zero. Try again."); // print out helpful error
					} //end if
				} catch (Exception e) {
					error(0);
				} // end catch 
			} while (chosenPrice < 0);
			
			cost[chosenName] = chosenPrice; // confirm and commit to global variable
			
			do {
				try {
					System.out.print("New product stock: ");
					chosenStock = input.nextInt();
					if (chosenStock < 0) {
						System.out.println("Cannot set total stock less than zero. Try again.");
					} // end if
				} catch (Exception e) {
					error(0);
				} // end catch
			} while (chosenStock < 0);
			
			stock[chosenName] = chosenStock;
			if (chosenName == filled) {
				filled++; // update total filled items
			} // end if
		} // end while
	} // end updateInv
	
	static int displayInv() {
		for (int i = 0; i < filled; i++) { // simple for loop to iterate through everything
			System.out.println((i + 1) + ". " + names[i] + " - $" + cost[i] + " - " + stock[i] + " in stock"); // formatted nicely
		}
		return 0; // everything was originally supposed to return int for navigational purposes
	}
	static int displayProd() {
		for (int i = 0; i < filled; i++) {
			if (stock[i] > 0) {
				System.out.println((i + 1) + ". " + names[i] + " - $" + String.format("%.2f", cost[i]) + " - " + stock[i] + " available - " + cart[i] + " in cart"); // formatting
			} else {
				System.out.println((i + 1) + ". " + names[i] + " - $" + String.format("%.2f", cost[i]) + " - Out of stock - " + cart[i] + " in cart"); // make distinction from "0" and out of stock because I like it more
			}
		}
		return 0;
	}
	static int showCart() {
		for (int i = 0; i < cart.length; i++) {
			if (cart[i] > 0) { // do not print if no item in that cart slot
				System.out.println((i + 1) + ". " + names[i] + " - " + cart[i]  + " in cart - $" + String.format("%.2f", (double) cost[i] * cart[i]) + " - $" + cost[i] + " ea"); // nicely formatted
			}
		}
		System.out.println(); // nice newline for prettiness
		return 0;
	}
	static String rngGreeting(int type) {
		// 0 is hello manager, 1 is bye manager, 2 is hi customer, 3 is by customer
		String[] hiManager = {"Manage " + rngName(), "Welcome back", "Fix stonks at " + rngName()};
		String[] byeManager = {"We will see you soon!", "Good luck!", "See you tomorrow!"};
		String[] hiCustomer = {"Welcome to " + rngName(), "Shop at " + rngName(), "Buy everything at " + rngName(), rngName()};
		String[] byeCustomer = {"We hope to see you soon!", "Goodbye!", "Come back soon!"};
		
		if (type == 0) {
			return hiManager[(int)(Math.random() * hiManager.length)];
		} else if (type == 1) {
			return byeManager[(int)(Math.random() * byeManager.length)];
		} else if (type == 2) {
			return hiCustomer[(int)(Math.random() * hiCustomer.length)];
		} else {
			return byeCustomer[(int)(Math.random() * byeCustomer.length)];
		}
	} // end rngGreeting
	
	static int checkout() {
		int holder = showCart(); // get customer to look over their stuff
		double subtotal = 0;
		double tax = -1.0;
		int location = -1; // holds province/territory
		int discount = 0; // holds discount percentage
		
		for (int i = 0; i < names.length; i++) {
			subtotal += cart[i] * cost[i]; // add everything to subtotal
		}
		
		// randomly determine if they get a discount (1 in 5 chance)
		if ((int) (Math.random() * 10) < 2) {
			discount = (int) (Math.random() * 10) * 5; // it's a pretty big discount
			System.out.println("Congratulations! You've won a " + discount + "% discount on your order, before tax!"); // tell user they got lucky
			subtotal -= subtotal * discount / 100; // take their costs away
		} // end if
		
		System.out.println();
		for (int i = 0; i < taxprovters.length; i++) {
			System.out.println((i + 1) + ". " + provters[i]); // output list of provinces and options
		}
		System.out.println();
		
		do {
			try {
				System.out.print("Yout province/territory #: ");
				location = input.nextInt() - 1; // ask where they live
				if (location < 0 || location > 12) {
					error(1);
				} else {
					tax = calcTax(subtotal, location);
				}
			} catch (Exception e) {
				error(0);
			}
			
			if (tax == -1) {
				error(2); // if tax hasn't changed yell at them
			}
		} while (tax == -1);
		
		// nicely formatted receipt
		double total;
		total = subtotal + tax;
		if (discount != 0) {
			System.out.println("Subtotal: $" + String.format("%.2f", subtotal/(1 - discount/100.0))); // output original price
			System.out.println("Discount: " + discount + "% off ($" + String.format("%.2f", subtotal/(1 - discount/100.0) - subtotal) + " off)"); // remind user they got a discount
			System.out.println("New subtotal: $" + String.format("%.2f", subtotal)); // output calculated price
		} else {
			System.out.println("Subtotal: $" + subtotal);
		} // end else
		
		System.out.println("Tax: $" + String.format("%.2f", tax) + " (" + taxprovters[location] + "%)");
		System.out.println("Total: $" + String.format("%.2f",total));
		System.out.println();
		
		String yn = "p"; // picked random letter
		do {
			try {
				System.out.print("Confirm? (y/N) ");
				do { // clear scanner
				yn = input.nextLine();
				} while (yn.equals(""));
				
				if (yn.toLowerCase().equals("n")) {
					System.out.println("Transaction cancelled.");
					System.out.println(); // just go back to main menu without touching cart
					return 0;
				} else if (yn.toLowerCase().equals("y")) {
					for (int i = 0; i < names.length; i++) {
						cart[i] = 0; // reset cart as order has been processed
					}
					
					revenue += subtotal; // transaction is non-returnable so we can safely add to revenue
					System.out.println("Transaction complete.");
				} else {
					error(1);
					yn = "p";
				} // end else
			} catch (Exception e) {
				error(0);
			} // end trycatch
		} while (yn.equals("p"));
		return 0;
	} // end checkout
	
	static String rngName() {
		String[] storeNames = {"Osrus", "OS R'US", "A store"}; // various store names 
		return storeNames[(int)(Math.random() * 3)];
	} // end rngname
	
	static int displaySales() {
		System.out.println("Revenue = $" + String.format("%.2f", revenue)); // format dollars like you would normally
		System.out.println();
		return 0;
	}
	
	static void error(int type) {
		String[] errorarray = {"input", "option", "province/territory"}; // what things can be invalid
		System.out.println("Error: Invalid " + errorarray[type] + ". Try again."); // lazy to type this out over and over again
		if (type == 0) {
			input.nextLine(); // clear scanner if input is invalid to be nice to more programs
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int menu = 1;
		int option = 0;
		while (true) {
			while (menu == 0) { // main menu
				try {
					System.out.println();
					System.out.println("Welcome to " + rngName());
					System.out.println();
					System.out.println("Who are you?");
					System.out.println("1. Manager");
					System.out.println("2. Customer");
					System.out.println("3. I don't know and I want to get out"); // this is exit button
					System.out.println();
					System.out.print("Option #: ");
					menu = input.nextInt();
					if (menu > 3 || menu < 1) {
						error(0);
						menu = 0;
					} else if (menu == 3) {
						return; // leave main method
					} // end if
					
				} catch (Exception e) {
					error(0);
				}
			} // end while
			
			while (menu == 1) { // manager loop
				System.out.println();
				System.out.println("Manage " + rngName());
				System.out.println();
				System.out.println("1. Update inventory");
				System.out.println("2. Display inventory");
				System.out.println("3. Display revenue");
				System.out.println("4. Return to main menu");
				System.out.println();
				
				do {
					try {
						System.out.print("Option #: ");
						option = input.nextInt();
						if (option < 1 || option > 4) {
							error(1);
						}
					} catch (Exception e) {
						error(1);
						input.nextLine();
					} // end catch
				} while (option < 1 || option > 5);
				
				if (option == 1) {
					option = updateInv(); // add or modify stock/prices/names
				} else if (option == 2) {
					option = displayInv(); // just display special manager inventory view
				} else if (option == 3) {
					option = displaySales(); // prints revenue
				} else if (option == 4) {
					System.out.println(rngGreeting(1)); // goodbye manager
					System.out.println();
					menu = 0; // reset just in case things break
				} // end if
				option = 0;
			} // end while
			
			while (menu == 2) { // customer loop
				System.out.println(); // looks nicer
				System.out.println(rngGreeting(2)); // say hi nicely
				System.out.println();
				System.out.println("1. Product list");
				System.out.println("2. Add items to cart");
				System.out.println("3. Show cart");
				System.out.println("4. Checkout");
				System.out.println("5. Return to main menu");
				System.out.println();
				try {
					System.out.print("Option #: ");
					option = input.nextInt();
					if (option < 1 || option > 5) {
						error(1);
					}
				} catch (Exception e) {
					error(0);
				}
				System.out.println();
				
				if (option == 1) {
					displayProd(); // customer only view of products probably is unnecessary but it was in my algorithm
				} else if (option == 2) {
					addProd(); // both display and add items to cart
				} else if (option == 3) {
					showCart();
				} else if (option == 4) {
					checkout(); // exit and pay
				} else if (option == 5) {
					System.out.println(rngGreeting(3)); // exit normally with nice message
					menu = 0;
				} // end if
					
			} // end while
		} // end big while
	} // end main
} // end class
