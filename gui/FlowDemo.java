// Daniel Chen
// 17 December 2019
// No panels yet

import java.awt.*;
import javax.swing.*;

public class FlowDemo extends JFrame {
	public static void main(String[] args) {
		FlowDemo window = new FlowDemo();
	}
	public FlowDemo() {
		JPanel p1 = new JPanel();
		FlowLayout f1 = new FlowLayout();
		JButton[] buttons = {new JButton("Button 1"), new JButton("Button 2"), new JButton("Button 3"), new JButton("Long-Named Button 4"), new JButton("5")};
		
		for (JButton button : buttons) {
			p1.add(button);
		}
		
		p1.setLayout(f1);
		add(p1);
		
		setSize(640, 160);
		setTitle("FlowLayoutDemo");
		setLayout(f1);
		setVisible(true);
	}
}
