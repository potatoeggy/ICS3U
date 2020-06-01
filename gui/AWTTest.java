// Daniel Chen
// 17 December 2019
// Fancy box thing

import javax.swing.*;
import java.awt.*;

public class AWTTest extends JFrame {
	public static void main(String[] args) {
		AWTTest window = new AWTTest();
	}
	public AWTTest() {
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		FlowLayout f1 = new FlowLayout();
		
		JLabel l1 = new JLabel("Label1");
		JTextField tf1 = new JTextField("TextField 1");
		JButton[] buttons = {new JButton("Button 1"), new JButton("Button 2"), new JButton("Button 3")};
		
		p1.add(l1);
		p1.add(tf1);
		
		for (JButton button : buttons) {
			p2.add(button);
		}
		
		p1.setLayout(f1);
		p2.setLayout(f1);
		
		add(p1);
		add(p2);
		
		setLayout(f1);
		setSize(320, 150);
		setTitle("AWT Test");
		setVisible(true);
	}
}
