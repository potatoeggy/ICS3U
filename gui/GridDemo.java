// Daniel Chen
// 17 December 2019
// Not boxes :(

import java.awt.*;
import javax.swing.*;

public class GridDemo extends JFrame {
	public static void main(String[] args) {
		GridDemo window = new GridDemo();
	}
	
	public GridDemo() {
		setSize(400, 200);
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		FlowLayout f1 = new FlowLayout();
		GridLayout g1 = new GridLayout(3, 2);
		GridLayout g2 = new GridLayout(2, 3);
		
		JButton[] p1buttons = {new JButton("Button 1"), new JButton("Button 2"), new JButton("Button 3"), new JButton("Long-Named Button 4"), new JButton("5")};
		JLabel[] labels = {new JLabel("Horizontal gap:"), new JLabel("Vertical gap:"), new JLabel(" ")};
		
		String[] numArray = {"0", "1", "2", "3"};
		JComboBox[] dropdowns = {new JComboBox(numArray), new JComboBox(numArray)};
		JButton p2button = new JButton("Apply gaps");
		
		for (JButton button : p1buttons) {
			p1.add(button);
		}
		
		for (JLabel label : labels) {
			p2.add(label);
		}
		
		for (JComboBox dropdown : dropdowns) {
			p2.add(dropdown);
		}
		
		p2.add(p2button);
		
		p1.setLayout(g1);
		p2.setLayout(g2);
		
		add(p1);
		add(p2);
		
		setTitle("GridLayoutDemo");
		setLayout(f1);
		setVisible(true);
	}
}
		
		
