
/*
 * Steven Hui
 * online shop assignment
 * Product names: California rolls(2 pieces), Salmon roses(2pieces), Black dragon rolls(2 pieces), Salmon slices(1 slice), Shrimp tempura(1 piece), Miso soup(1 bowl), Water bottle, Gumball
 * prices: 1.5, 1.5, 2, 1, 1, 1, 1, 0.25
 * stock: 20, 20, 20, 20, 20, 20, 25, 25
 */

//note: html may be needed for newline characters in jLabels, as \n doesn't work.

import java.util.*; //import util
import javax.swing.*;//import statement
import java.awt.*;
import java.awt.event.*;
import java.io.*;




public class onlineshop3 extends JFrame implements MouseListener{ 


 //these three arrays hold the data for all the products
 int[] stocks = new int[10];//create array
 double[] prices = new double[10];//create array
 String[] names = new String[10];//create array

 double revenue = 0;//create variable
 int gameChoice= 0;

 //this array is esssentially the "cart" that the customer has
 int[] cart = new int[10];


 String currentMenu = "start"; //the current menu that is open
 //current menu options include:
 //start, managerMenu, customerMenu, cart

 //font presets
 Font title = new Font("Verdana", Font.PLAIN, 30);
 Font normalFont = new Font("Verdana", Font.PLAIN, 16);

 //each individual menu is a JPanel
 JPanel startMenu = new JPanel();//create panel
 JPanel managerMenu = new JPanel();//create panel
 JPanel salesUpdate = new JPanel();//create panel
 JPanel customerMenu = new JPanel();//create panel
 JPanel cartMenu = new JPanel();//create panel
 
 
 JPanel checkoutMenu = new JPanel();//create panel
 JPanel randomMenu = new JPanel();//create panel
 JPanel taxfreeMenu= new JPanel();//create panel


 //start menu components
 JLabel startTitle = new JLabel("Welcome to Ninja's Sushi! Please select your role:");//create label
 JButton customerButton = new JButton("Customer");//create button
 JButton managerButton = new JButton("Manager");//create button


 //managerMenu components
 JPanel managerGrid = new JPanel();//create panels
 JTextField[] _names = new JTextField[10];//create textfield
 JTextField[] _prices = new JTextField[10];//create textfield
 JTextField[] _stocks = new JTextField[10];//create textfield

 JLabel managerTitle = new JLabel("<html><br/>MANAGER MODE</html>", SwingConstants.CENTER);//create label
 JLabel _namesTitle = new JLabel("Name");//create label
 JLabel _pricesTitle = new JLabel("Price ($CAD)");//create label
 JLabel _stocksTitle = new JLabel("Stock");

 JPanel managerBottomPanel = new JPanel();
 JLabel sales = new JLabel("Total revenue this session: ");
 JButton managerExitButton = new JButton("Save and exit");



 //customerMenu components
 JPanel customerGrid = new JPanel();
 JLabel[] c_names = new JLabel[10];
 JLabel[] c_prices = new JLabel[10];
 JLabel[] c_stocks = new JLabel[10];
 JTextField[] c_itemsInCart = new JTextField[10];

 JLabel customerTitle = new JLabel("You are now shopping at Ninja's Sushi! (Invalid inputs will turn red.)", SwingConstants.CENTER);
 JLabel c_namesTitle = new JLabel("Name");
 JLabel c_pricesTitle = new JLabel("Price ($CAD)");
 JLabel c_stocksTitle = new JLabel("Stock");
 JLabel c_cartTitle = new JLabel("# Items in cart");

 JButton reviewButton = new JButton("Review my cart");



 //cartMenu components
 JLabel cartTitle = new JLabel("MY CART", SwingConstants.CENTER);
 JLabel[] cartItemNames = new JLabel[10];
 JPanel cartGrid = new JPanel();
 JLabel[] itemQuantities = new JLabel[10];
 JLabel[] cartPrices = new JLabel[10];

 JLabel cartNameTitle = new JLabel("Item Name");
 JLabel cartStockTitle = new JLabel("Quantity");
 JLabel cartPriceTitle = new JLabel("Cost");

 JPanel bottomPanel = new JPanel();
 JButton continueShoppingButton = new JButton("Continue shopping");
 JButton checkoutButton = new JButton("Checkout");
 JLabel totalPrice = new JLabel();

 //random menu components
 JLabel gameDescription = new JLabel("Guess a number from 0 to 9 for a chance of tax free shopping", SwingConstants.CENTER);
 String [] numArray= {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
 JComboBox<String> falldown = new JComboBox<String>(numArray);
 JButton submitButton = new JButton("Submit");

 
 //checkout menu components
 JLabel checkoutTitle = new JLabel("Checkout", SwingConstants.CENTER);
 JLabel selectProvince = new JLabel("Please select your province", SwingConstants.CENTER);
 JLabel finalPrice = new JLabel("Final price: ", SwingConstants.CENTER);

 String[] provinces = {"Alberta", "British Columbia", "Manitoba", "New Brunswick", "Newfoundland and Labrador", 
   "Northwest Territories", "Nova Scotia", "Nunavut", "Ontario", "PEI", "Quebec", "Saskatchewan", "Yukon"};
 double [] taxRates= {1.05, 1.05, 1.12, 1.13, 1.15, 1.15, 1.05, 1.15, 1.05, 1.13, 1.15, 1.14975, 1.11, 1.05};
 JComboBox<String> dropdown = new JComboBox<String>(provinces);

 JButton purchaseButton = new JButton("Purchase!");
 
 //Taxfree menu components
 JLabel dutyfree = new JLabel("Final Price:", SwingConstants.CENTER);
 JButton dutyfreepurchaseButton = new JButton("Purchase!");


 //////////////////////////////////////////////////////////////////////////////////////end of variable declaration
 /////////////////////////////////////////////////these comments here so its easier to scroll and see this
 //////////////////////////////////////////////////////////////////////////////////////constructor

 public onlineshop3() {

  setSize(1280, 700); //set the size of the window
  setTitle("Ninja's Sushi");

  loadData();

  //////////////////////////////////////////////////////creating the start menu

  startMenu.setLayout(null);

  startTitle.setFont(title);
  customerButton.setFont(normalFont);
  managerButton.setFont(normalFont);

  startTitle.setBounds(280, 50, 800, 200);  
  customerButton.setBounds(300, 300, 200, 50);
  managerButton.setBounds(700, 300, 200, 50);

  customerButton.addMouseListener(this);
  managerButton.addMouseListener(this);

  startMenu.add(startTitle);
  startMenu.add(customerButton);
  startMenu.add(managerButton);


  ////////////////////////////////////////////////////////////Creating the manager menu
  managerMenu.setLayout(new BorderLayout()); //set the layout
  managerMenu.setBorder(BorderFactory.createEmptyBorder(0, 40, 20, 40)); //set border for some nice spacing


  //creating the title
  managerTitle.setFont(title);
  managerMenu.add(managerTitle, BorderLayout.PAGE_START);

  //setting the inner grid
  managerGrid.setLayout(new GridLayout(11, 3));

  //adding the elements to the grid
  managerGrid.add(_namesTitle);
  managerGrid.add(_stocksTitle);  
  managerGrid.add(_pricesTitle);
  for(int i = 0; i < 10; i ++)
  {
   _names[i] = new JTextField(names[i]);
   _stocks[i] = new JTextField("" + stocks[i]);
   _prices[i] = new JTextField("" + prices[i]);
   managerGrid.add(_names[i]);
   managerGrid.add(_stocks[i]);
   managerGrid.add(_prices[i]);
  }
  managerMenu.add(managerGrid, BorderLayout.CENTER);

  
  
  
  //adding the exit button and sales report
  managerBottomPanel.add(sales);
  managerExitButton.setFont(normalFont);
  managerExitButton.addMouseListener(this);
  managerBottomPanel.add(managerExitButton);
  
  managerMenu.add(managerBottomPanel, BorderLayout.PAGE_END);
  





  //////////////////////////////////////////////////////////creating the customer menu
  customerMenu.setLayout(new BorderLayout());
  customerMenu.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

  //setting the title
  customerTitle.setFont(title);
  customerMenu.add(customerTitle, BorderLayout.PAGE_START);

  //adding components to the customer grid
  customerGrid.setLayout(new GridLayout(0, 4));
  c_namesTitle.setFont(normalFont);
  c_stocksTitle.setFont(normalFont);
  c_pricesTitle.setFont(normalFont);
  c_cartTitle.setFont(normalFont);


  customerGrid.add(c_namesTitle);
  customerGrid.add(c_stocksTitle);
  customerGrid.add(c_pricesTitle);
  customerGrid.add(c_cartTitle);

  for(int i = 0; i < 10; i ++)
  {
   c_names[i] = new JLabel();
   c_stocks[i] = new JLabel();
   c_prices[i] = new JLabel();
   c_itemsInCart[i] = new JTextField();

  }

  UpdateCustomerGrid();
  UpdateNonBlankProducts();


  customerMenu.add(customerGrid, BorderLayout.CENTER);

  //creating the "review cart" button
  reviewButton.addMouseListener(this);
  customerMenu.add(reviewButton, BorderLayout.PAGE_END);



  //////////////////////////////////////////////////////////////////Creating the cart menu
  cartMenu.setLayout(new BorderLayout());
  cartMenu.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

  //creating the title
  cartTitle.setFont(title);
  cartMenu.add(cartTitle, BorderLayout.PAGE_START);


  //creating the grid of the products in the cart
  cartGrid.setLayout(new GridLayout(0, 3));
  cartNameTitle.setFont(normalFont);
  cartStockTitle.setFont(normalFont);
  cartPriceTitle.setFont(normalFont);

  //creating the list of how many of each item in cart
  for(int i = 0; i < 10; i ++)
  {
   itemQuantities[i] = new JLabel();
   cartItemNames[i] = new JLabel(names[i]);
   cartPrices[i] = new JLabel();
  }

  cartMenu.add(cartGrid, BorderLayout.CENTER);


  //adding the bottom panel
  continueShoppingButton.setFont(normalFont);
  checkoutButton.setFont(normalFont);
  continueShoppingButton.addMouseListener(this);
  checkoutButton.addMouseListener(this);

  bottomPanel.add(totalPrice);
  bottomPanel.add(continueShoppingButton);
  bottomPanel.add(checkoutButton);

  cartMenu.add(bottomPanel, BorderLayout.PAGE_END);

  //////////////////////////////////////////////////////////////////creating the random menu
  randomMenu.setLayout(new GridLayout(0,1));
  
  //adding title
  gameDescription.setFont(title);
  randomMenu.add(gameDescription);
  
  //adding the fallbox
  falldown.addActionListener (new ActionListener() 
  {
      public void actionPerformed(ActionEvent e)
      {
    	  gameChoice= falldown.getSelectedIndex();

 
      }
  });

  randomMenu.add(falldown);
  
  //adding the submit button
  submitButton.setFont(normalFont);
  submitButton.addMouseListener(this);
  randomMenu.add(submitButton);
  
  ////////////////////////////////////////////////////////////////////creating the taxfree menu
  taxfreeMenu.setLayout(new BoxLayout(taxfreeMenu, BoxLayout.Y_AXIS));
  
  //add total price
  dutyfree.setFont(title);
  taxfreeMenu.add(dutyfree);
  
  //add button
  dutyfreepurchaseButton.addMouseListener(this);
  taxfreeMenu.add(dutyfreepurchaseButton);
  

  ////////////////////////////////////////////////////////////////////creating the checkout menu
  checkoutMenu.setLayout(new GridLayout(0, 1));

  //adding the title
  checkoutTitle.setFont(title);
  checkoutMenu.add(checkoutTitle);

  //adding the province selection
  selectProvince.setFont(normalFont);
  checkoutMenu.add(selectProvince);

  dropdown.addActionListener (new ActionListener() 
  {
   public void actionPerformed(ActionEvent e)
   {

    //set the final price
    int tempPrice = 0;
    for(int i = 0; i < 10; i ++)
    {
     tempPrice += cart[i] * prices[i];
    }

    finalPrice.setText("Final price: $" + String.format("%.2f", (tempPrice * taxRates[dropdown.getSelectedIndex()])));



   }
  });
  checkoutMenu.add(dropdown);

  //adding the final price
  finalPrice.setFont(normalFont);
  checkoutMenu.add(finalPrice);

  //adding the purchase button
  purchaseButton.addMouseListener(this);
  purchaseButton.setFont(normalFont);
  checkoutMenu.add(purchaseButton);




  //////////////////////////////////////////////////////////////////////////////////////////starting the window
  //start with the "start" menu
  setContentPane(startMenu);

  setVisible(true);    //open the window on play

 }


 //main function
 public static void main(String[] args)
 {
  new onlineshop3();
 }


 //change menu
 public void changeMenu(JPanel menu)
 {
  setContentPane(menu);    //sets the correct menu
  validate();              //updates the screen so the correct menu actually shows
 }

 //save the inventory to a text file, and update the array values
 public void saveInventory(boolean manager) 
 {
  if(manager)
  {
   try
   {
    for(int i = 0; i < 10; i ++)
    {

     names[i] = _names[i].getText();
     stocks[i] = Integer.parseInt(_stocks[i].getText());
     prices[i] = Double.parseDouble(_prices[i].getText());

     //if the name is left blank, set it back to "PRODUCT NOT SET"
     if(names[i].trim().equals(""))
     {
      names[i] = "PRODUCT NOT SET";
      stocks[i] = 0;
      prices[i] = 1;
     }
    }
   }
   catch (NumberFormatException e)
   {
    System.out.println("Values have been validated but still didn't pass");
   }
  }
  
  

  //write to file
  try
  {
   PrintWriter output = new PrintWriter("inventory.txt");
   for(int i = 0; i < 10; i ++)
   {
    //this takes the information in the text boxes and writes them to the file

    //if product name left blank, change it back to PRODUCT NOT SET
    if(_names[i].getText().trim().equals(""))
    {
     output.println("PRODUCT NOT SET");
     output.println(0);
     output.println(1);
    }
    //if product name not blank, simply write the name, stock, and price to file
    else
    {
     output.println(names[i]);
     output.println(stocks[i]);
     output.println(prices[i]);
    }

   }
   output.close();
  }
  catch(Exception e)
  {
   System.out.println("Problem reading text file!");
  }
 }

 //load the inventory data from the file
 public void loadData()
 {
  //load in all the data from the text file
  File file = new File("inventory.txt");
  Scanner input;
  try 
  {
   input = new Scanner(file);
   for(int i = 0; i < 10; i ++)
   {
    names[i] = input.nextLine();
    stocks[i] = input.nextInt();
    prices[i] = input.nextDouble();
    input.nextLine();
   }

   input.close();
  } 
  catch (FileNotFoundException e) {
   e.printStackTrace();
  }
 }


 //upload the data from the file into the customerGrid
 public void UpdateCustomerGrid()
 {
  for(int i = 0; i < 10; i ++)
  {
   c_names[i].setText(names[i]);
   c_stocks[i].setText("" + stocks[i]);
   c_prices[i].setText("$" + prices[i]);
   c_itemsInCart[i].setText("0");
  }
 }







 //check if the values that the manager enters are actually numbers
 //also, turn a box red if the input is in the wrong format
 public boolean checkValues()
 {
  boolean endValue = true;
  for(int i = 0; i < 10; i ++)
  {
   //test if the stocks and prices inputted are real numbers using parse
   //if they are not valid, turn that box red.
   try
   {
    int k = Integer.parseInt(_stocks[i].getText());

    //cannot have a negative stock
    if(k < 0)
    {
     throw new NumberFormatException();
    }
    _stocks[i].setBackground(Color.white);
   }
   catch(NumberFormatException e)
   {
    _stocks[i].setBackground(Color.red);
    endValue = false;
   }
   try
   {
    double k = Double.parseDouble(_prices[i].getText());

    //price cannot be zero or below zero
    if(k <= 0)
    {
     throw new NumberFormatException();
    }
    _prices[i].setBackground(Color.white);
   }
   catch(NumberFormatException e)
   {
    _prices[i].setBackground(Color.red);
    endValue = false;
   }
  }

  return endValue;
 }


 //this method checks the input from the customer and makes sure they are all valid integers.
 public boolean checkCustomerValues()
 {
  boolean endValue = true;
  for(int i = 0; i < 10; i ++)
  {
   //ensure that the number entered is <= stock and is a valid integer.
   try
   {
    int k = Integer.parseInt(c_itemsInCart[i].getText());
    if(k < 0 || k > stocks[i])
    {
     throw new NumberFormatException();
    }
    c_itemsInCart[i].setBackground(Color.white);
   }

   //if not valid,
   catch (NumberFormatException e)
   {
    endValue = false;
    c_itemsInCart[i].setBackground(Color.red);
   }
  }
  return endValue;
 }



 //this method updates all the jLabels in the customer's cart
 public void UpdateCartMenu()
 {


  //only add the items that the customer actually purchased
  cartGrid.removeAll();
  cartGrid.add(cartNameTitle);
  cartGrid.add(cartStockTitle);
  cartGrid.add(cartPriceTitle);
  for(int i = 0; i < 10; i ++)
  {
   cart[i] = Integer.parseInt(c_itemsInCart[i].getText());
   itemQuantities[i].setText("" + cart[i]);
   cartPrices[i].setText("$" + (prices[i] * cart[i]));
   if(cart[i] != 0)
   {
    cartGrid.add(cartItemNames[i]);
    cartGrid.add(itemQuantities[i]);

    cartGrid.add(cartPrices[i]);
   }
  }


  //updating the total cost
  double total = 0;
  for(int i = 0; i < 10; i ++)
  {
   cartItemNames[i].setText(names[i]);
   total += cart[i] * prices[i];
  }
  totalPrice.setFont(normalFont);
  totalPrice.setText("Total cost (before tax): $" + total + "    ");
 }


 //this method checks which products are not set yet, and removes them from the customer menu
 public void UpdateNonBlankProducts()
 {
  customerGrid.removeAll();
  customerGrid.add(c_namesTitle);
  customerGrid.add(c_stocksTitle);
  customerGrid.add(c_pricesTitle);
  customerGrid.add(c_cartTitle);
  for(int i = 0; i < 10; i ++)
  {
   if(names[i].equals("PRODUCT NOT SET") || names[i].trim().equals(""))
   {
    //do nothing, since the name is not set or non-existent
   }
   else
   {
    customerGrid.add(c_names[i]);
    customerGrid.add(c_stocks[i]);
    customerGrid.add(c_prices[i]);
    customerGrid.add(c_itemsInCart[i]);
   }
  }
 }


 //update the manager grid, such as after a customer shops and the stock decreases
 public void UpdateManagerGrid()
 {
  loadData();
  for(int i = 0; i < 10; i ++)
  {
   _names[i].setText(names[i]);
   _stocks[i].setText("" + stocks[i]);
   _prices[i].setText("" + prices[i]);
  }
  
  sales.setText("Total revenue this session: $" + String.format("%.2f", revenue));
 }


 ///////////////////////////////////////////////////////////////////////////////MOUSE CLICK EVENTS
 //they are required to implement mouseListener, so they must be here even if not used
 public void mouseClicked(MouseEvent e) {

 }


 public void mousePressed(MouseEvent e) {

  if(e.getSource() == customerButton)
  {
   UpdateCustomerGrid();
   UpdateNonBlankProducts();
   changeMenu(customerMenu);
  }
  else if(e.getSource() == managerButton)
  {
   UpdateManagerGrid();
   changeMenu(managerMenu);
  }
  else if(e.getSource() == managerExitButton)
  {
   if(checkValues())
   {
    saveInventory(true);
    changeMenu(startMenu);
   }
  }
  else if(e.getSource() == reviewButton)
  {
   if(checkCustomerValues())
   {
    UpdateCartMenu();
    changeMenu(cartMenu);
   }
  }
  else if(e.getSource() == continueShoppingButton)
  {
   changeMenu(customerMenu);
  }
  else if(e.getSource() == checkoutButton)
  {
   changeMenu(randomMenu);
  }
  else if(e.getSource() == purchaseButton)
  {
   changeMenu(startMenu);

   //update the revenue
   try
   {
   revenue += Double.parseDouble(finalPrice.getText().substring(14));
   }
   catch(Exception ee) {}
   
   finalPrice.setText("Final price:" );

   //update the stock, since now some should be missing
   for(int i = 0; i < 10; i ++)
   {
    stocks[i] = stocks[i] - cart[i];
   }

   //clear all the customer's cart data
   for(int i = 0; i < 10; i ++)
   {
    cart[i] = 0;
   }

   saveInventory(false);


  }
  else if (e.getSource()== submitButton)
  {
	  Random rand= new Random();
	  int rng= rand.nextInt(10);
	  if (gameChoice== rng)
	  {
		  double temp= 0;
		  for(int i= 0; i<10; i++)
		  {
			  temp += prices [i]*cart[i];
		  }
		  dutyfree.setText("Congratulations, you will be shopping tax free today. Your total price is $" + temp);
		  changeMenu(taxfreeMenu);
	  }
	  else 
	  {
		  changeMenu(checkoutMenu);
	  }
  }
  else if (e.getSource()== dutyfreepurchaseButton)
  {
	  changeMenu(startMenu);
	//update the revenue
	   try
	   {
		   revenue += Double.parseDouble(dutyfree.getText().substring(dutyfree.getText().indexOf("$") + 1));
	   
	   }
	   catch(Exception ee) {}
	   

	   //update the stock, since now some should be missing
	   for(int i = 0; i < 10; i ++)
	   {
	    stocks[i] = stocks[i] - cart[i];
	   }

	   //clear all the customer's cart data
	   for(int i = 0; i < 10; i ++)
	   {
	    cart[i] = 0;
	   }

	   saveInventory(false);
  }



 }


 public void mouseReleased(MouseEvent e) {

 }

 public void mouseEntered(MouseEvent e) {

 }

 public void mouseExited(MouseEvent e) {
	 


  }
 }
