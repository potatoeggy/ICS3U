// Daniel Chen
// 17 December 2019
// Boxes!

import java.awt.*;
import javax.swing.*;

public class BoxDemo extends JFrame {
	public BoxDemo() {
		FlowLayout flow1 = new FlowLayout();
		JPanel p1 = new JPanel();
		BoxLayout box1 = new BoxLayout(p1, BoxLayout.PAGE_AXIS);
		
		p1.setLayout(box1);
		
		JButton[] buttons = {new JButton("Button 1"), new JButton("Button 2"), new JButton("Button 3"), new JButton("Long-Named Button 4"), new JButton("5")};
		
		for (JButton button : buttons) {
			button.setAlignmentX(Component.CENTER_ALIGNMENT);
			p1.add(button);
		}
		
		add(p1);
		
		setLayout(flow1);
		setTitle("BoxLayoutDemo");
		setSize(320, 200);
		setVisible(true);
	}
	public static void main(String[] args) {
		BoxDemo box = new BoxDemo();
	}
}
