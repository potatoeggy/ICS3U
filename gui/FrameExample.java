// Daniel Chen
// 16 December 2019
// Testing gooy

import javax.swing.*;
import java.awt.*;

class FrameExample extends JFrame {
	JButton okButton = new JButton("OK");
	JTextField nameText = new JTextField("Potato");
	JTextField blank30 = new JTextField(" ", 30);
	JLabel nameLabel = new JLabel("Name: ", JLabel.RIGHT);
	
	public static void main(String[] args) {
		FrameExample frame = new FrameExample();
	}
	public FrameExample() {
		setTitle("Test");
		setSize(640, 480);
		
		add(okButton);
		add(nameText);
		add(nameLabel);
		add(blank30);
		
		setVisible(true);
	}
}
