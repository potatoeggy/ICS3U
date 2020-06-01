// Daniel Chen
// 19 December 2019
// Hypotenuse calculator

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HypotenuseCalculator extends JFrame implements ActionListener {
	// make things
	JPanel[] panels = {new JPanel(), new JPanel()};
	JButton[] buttons = {new JButton("Submit")};
	JLabel[] labels = {new JLabel("Side 1"), new JLabel("Side 2"), new JLabel("Hypotenuse")};
	JTextField[] tfs = {new JTextField(), new JTextField(), new JTextField()};
	
	
	public HypotenuseCalculator() {
		// add things to panel
		panels[0].setLayout(new GridLayout(3, 2));		
		for (int i = 0; i < 3; i++) {
			panels[0].add(labels[i]);
			panels[0].add(tfs[i]);
		}
		// add button to panel and manage button click
		panels[1].add(buttons[0]);
		buttons[0].addActionListener(this);
		
		// add to main thing
		for (JPanel panel : panels) {
			add(panel);
		}
		
		// frame config
		setTitle("Hypotenuse Calculator");
		setLayout(new FlowLayout());
		setSize(320, 200);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == buttons[0]) {
			double x = Double.parseDouble(tfs[0].getText());
			double y = Double.parseDouble(tfs[1].getText());
			double z = Math.sqrt(x*x + y*y);
			tfs[2].setText("" + z);
		}
		return;
	}
	
	public static void main(String[] args) {
		HypotenuseCalculator window = new HypotenuseCalculator();
	}
}
