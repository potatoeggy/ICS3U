// Daniel Chen
// 7 January 2020
// Thank you user!

// import things
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

public class ThankYou extends JFrame implements ActionListener {
	JPanel[] panels = {new JPanel(), new JPanel()};
	JButton ok = new JButton("OK");
	JLabel[] labels = {new JLabel("Name ", JLabel.RIGHT), new JLabel("Email (optional) ", JLabel.RIGHT), new JLabel("Address (optional) ", JLabel.RIGHT), new JLabel("Message ", JLabel.RIGHT)};
	JLabel[] blankLabels = {new JLabel(), new JLabel(), new JLabel(), new JLabel()};
	JTextField[] tfs = {new JTextField(10), new JTextField(10), new JTextField(10), new JTextField(15)};
	
	static File file = new File("hs.conf");
	static PrintWriter output = new PrintWriter("hs.conf"); // crashses must be caught
	
	public ThankYou() {
		panels[1].setLayout(new GridLayout(5, 3));
		panels[0].setLayout(new GridLayout(4, 3));
		panels[0].add(labels[0]);
		panels[0].add(tfs[0]);
		panels[0].add(ok);
		
		for (int i = 1; i < blankLabels.length; i++) {
			panels[0].add(labels[i]);
			panels[0].add(tfs[i]);
			panels[0].add(blankLabels[i]);
		}
		
		ok.addActionListener(this);
		
		for (JPanel panel : panels) {
			add(panel);
		}
		
		setLayout(new FlowLayout());
		setTitle("Tank you");
		setSize(500, 500);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == ok) {
			if (! tfs[0].getText().equals("")) {
				tfs[3].setText("Thank you, " + tfs[0].getText() + "!");
				for (int i = 0; i < 3; i++) {
					output.println(tfs[i].getText()); // resolve thing above first
				}
				output.println(); // need to resolve thing above first
			}
		}
	}
	
	public static void main(String[] args) {
		ThankYou window = new ThankYou();
	}
}
