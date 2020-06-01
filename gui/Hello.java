// Daniel Chen
// 18 December 2019
// Hello user!

// import things
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Hello extends JFrame implements ActionListener {	
	// begin gooui elements
	JPanel[] panels = {new JPanel(), new JPanel(), new JPanel()};
	JTextField[] tfs = {new JTextField("", 15), new JTextField("", 15)};
	JLabel[] labels = {new JLabel("Name"), new JLabel("Message")};
	JButton[] buttons = {new JButton("OK")};
	// end gooui layouts
	
	public static void main(String[] args) {
		Hello window = new Hello(); // create new thingy
	} // end main
	
	public void actionPerformed(ActionEvent event) {
		if (buttons[0] == event.getSource()) { // check for button in prep for future
			if (! tfs[0].getText().equals("")) { // Don't want it to show up blank
				tfs[1].setText("Hello, " + tfs[0].getText() + "!");
				panels[1].setVisible(true); // magic appearing box
			} // end if getText
		} // end if button
	} // end actionPerformed
	
	public Hello() {
		for (int i = 0; i < 2; i++) {
			panels[i].add(labels[i]);
			panels[i].add(tfs[i]);
		} // less typing
		
		buttons[0].addActionListener(this); // make button do something
		panels[2].add(buttons[0]); // add button to last movable panel
		
		panels[0].setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10)); // make things look nice
		panels[1].setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0)); // make things look nicer
		setSize(320, 150); // this seems like a good size
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); // align everything
		setTitle("Hello!");
		
		for (JPanel panel : panels) { // technically not learned but it's so convenient
			add(panel);
		} // end for
		
		panels[1].setVisible(false); // hide until needed
		
		setVisible(true); // show frame
	} // end constructor
} // end class
