import javax.swing.*;//You need these two libraries to do the GUI stuff
import java.awt.*;

public class GUIExample1 extends JFrame //You are telling Java that this is a GUI application
{ 
  
  // *** CREATE THE GUI COMPONENTS: Here we are only creating the following: Buttons, Labels, and Text field
  
  JButton okButton = new JButton("OK");                    //create a button
  JLabel nameLabel = new JLabel("Name: ", JLabel.RIGHT);    //create a label
  JTextField nameField = new JTextField("Enter name here",20);   //create a text field
  // **********                      
  
  // *** CONSTRUCTOR - Has the same name as the class and it runs once (when the program begins)
  // This is were the GUI should be configured.
  
  public GUIExample1() //This section adds the components on to the frame
  { 
    setTitle("Hello World!");  //Set the window title or  frame
    setSize(640, 480);         //Set the dimensions of
    
    //Flow layout fills each row with the GUI components that you add and it will
    //go to the next row when the previous row fills up
    
    FlowLayout fl1 = new FlowLayout(); //used to organize window
    
    setLayout(fl1);                    //organize the layout for the whole frame 
    
    add(okButton);          // add the button to the frame
    add(nameLabel);         // add the label to the frame
    add(nameField);         // add the text field to the frame 
    setVisible(true);       // display the gui on the screen
    
  }
  
  // **** This is the main method - It just starts the GUI
  public static void main(String[] args) {
    GUIExample1 frame1 = new GUIExample1();  //start the GUI!
  }
  
}
