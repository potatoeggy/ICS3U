import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;//Adding the event since we will now be using an action listener
import java.io.*;
import java.util.*;

public class ChallengeTask extends JFrame implements ActionListener {
	// Create some Panels
	JPanel pan1;
	JPanel pan2;

	// Added some code
	static final int MAX = 100;
	String[] names; // arrays to store data that user enters
	String[] emails;
	String[] addresses;
	int total; // number of records entered by the user

	// declare GUI Components for panel 1
	JLabel nameLabel;
	JTextField nameField;
	JLabel addressLabel;
	JTextField addressField;
	JLabel emailLabel;
	JTextField emailField;
	JButton addButton;
	JLabel noMoreCanBeAddedLabel;

	// declare GUI components for panel 2
	JLabel nameTitle;
	JLabel addressTitle;
	JLabel emailTitle;
	JLabel[] nameLabels;
	JLabel[] addressLabels;
	JLabel[] emailLabels;

	// CONSTRUCTOR - Setup your GUI here
	public ChallengeTask() {
		setTitle("Challenge Task!"); // Create a window with a title
		setSize(600, 450); // set the window size

		// create relevant objects to store data
		names = new String[MAX];
		emails = new String[MAX];
		addresses = new String[MAX];

		// create components for pan1
		pan1 = new JPanel();
		pan1.setSize(800, 300);
		nameLabel = new JLabel("Name: ", JLabel.RIGHT);
		nameField = new JTextField(10);
		addressLabel = new JLabel("Address: ", JLabel.RIGHT);

		addressField = new JTextField(10);
		emailLabel = new JLabel("Email: ", JLabel.RIGHT);

		emailField = new JTextField(10);
		addButton = new JButton("Add");
		addButton.addActionListener(this); // Add an action listener to the
											// button

		noMoreCanBeAddedLabel = new JLabel("");

		// Create some Layouts
		BorderLayout frameLayout = new BorderLayout();
		FlowLayout pan1Layout = new FlowLayout();

		// Set the frame and both panel layouts
		setLayout(frameLayout);// Setting layout for the whole frame
		pan1.setLayout(pan1Layout);// Layout for Pan1

		// Add all the components to panel 1 - this one is used for data entry
		pan1.add(nameLabel);
		pan1.add(nameField);
		pan1.add(addressLabel);
		pan1.add(addressField);
		pan1.add(emailLabel);
		pan1.add(emailField);
		pan1.add(addButton);
		pan1.add(noMoreCanBeAddedLabel);

		// add the panels to the frame and display the window
		add(BorderLayout.NORTH, pan1);

		// create and initialize components for panel 2
		GridLayout pan2Layout = new GridLayout(101, 3);
		pan2 = new JPanel();
		pan2.setLayout(pan2Layout);// Layout for Pan2
		pan2.setAutoscrolls(true);

		nameTitle = new JLabel("NAMES:", JLabel.CENTER);
		addressTitle = new JLabel("ADDRESSES:", JLabel.CENTER);
		emailTitle = new JLabel("EMAILS:", JLabel.CENTER);

		// add title labels to panel 2
		pan2.add(nameTitle);
		pan2.add(addressTitle);
		pan2.add(emailTitle);

		// initialize all label arrays
		nameLabels = new JLabel[100];
		addressLabels = new JLabel[100];
		emailLabels = new JLabel[100];
		for (int i = 0; i < nameLabels.length; i++) {
			nameLabels[i] = new JLabel("");
			addressLabels[i] = new JLabel("");
			emailLabels[i] = new JLabel("");

			// add the labels to the panel
			pan2.add(nameLabels[i]);
			pan2.add(addressLabels[i]);
			pan2.add(emailLabels[i]);
		}

		add(BorderLayout.CENTER, new JScrollPane(pan2)); // add a scroll bar to
															// the panel

		// load the data from file
		loadInfoFromFile();
		// add names to screen
		displayLoadedData();
		
		validate();
		
		setVisible(true);
	}

	/**
	 * method to load data from file
	 */
	private void loadInfoFromFile() {
		try {
			File file = new File("personInfo.txt");
			Scanner input = new Scanner(file);

			while (input.hasNextLine()) {
				String line = input.nextLine();
				String[] values = line.split("-");
				System.out.println(Arrays.toString(values));
				names[total] = values[0];
				addresses[total] = values[1];
				emails[total] = values[2];

				total++;
			}
			input.close();

		} catch (IOException e) {
			System.out.println("file does not exist!");
			e.printStackTrace();
		}
	}

	/**
	 * method to display data from the file
	 */
	private void displayLoadedData() {
		for (int i = 0; i < total; i++) {

			nameLabels[i].setText(names[i]);
			nameLabels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			addressLabels[i].setText(addresses[i]);
			addressLabels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			emailLabels[i].setText(emails[i]);
			emailLabels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}
	}

	/**
	 * method to add new info to file
	 * @param name - name
	 * @param address - address
	 * @param email - email address
	 */
	private void addInfoToFile(String name, String address, String email) {
		try {
			FileWriter writer = new FileWriter("personInfo.txt", true);
			PrintWriter output = new PrintWriter(writer);

			output.println(name + "-" + address + "-" + email);

			output.close();
		} catch (IOException e) {
			System.out.println("Error adding person to file...");
			e.printStackTrace();
		}
	}

	/**
	 * ACTION LISTENER - This method runs when an event occurs
	 * Code in here only runs when a user interacts with a component
	 * that has an action listener attached to it
	 */
	public void actionPerformed(ActionEvent event) {

		String command = event.getActionCommand(); // find out the name of the
													// component
		// that was used

		if (command.equals("Add")) { // if the OK button was pressed
			System.out.println("add button pressed"); // display message in
														// console(for testing)
			if (total < 100) {
				names[total] = nameField.getText();
				addresses[total] = addressField.getText();
				emails[total] = emailField.getText();

				nameLabels[total].setText(names[total]);
				addressLabels[total].setText(addresses[total]);
				emailLabels[total].setText(emails[total]);

				// add the info to the file
				addInfoToFile(names[total], addresses[total], emails[total]);

				total++;
			} else {
				noMoreCanBeAddedLabel.setText("No more entries can be added!");
			}
		} // no other conditions

	}

	/**
	 * Main method for launching the frame.
	 * @param args
	 */
	public static void main(String[] args) {
		ChallengeTask frame1 = new ChallengeTask(); // Start the GUI

	}

}
