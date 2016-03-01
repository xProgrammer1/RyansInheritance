import java.util.Random;

import javax.swing.JFrame;

public class InheritanceDriver {
  
  // The main driver method.
  public static void main(String args[]) {
    System.out.println("\n"+"\n"+"\n"+"Sorcerer, you must find your way back home. Use your knowledge to guide you...");
    OurArea area = new OurArea(3); // creates and runs an object for OurArea class
    Window window = new Window("Inheritance Window");
    window.add(area);
    window.setVisible(true);
    window.addKeyListener(area); // adds KeyListener 
  }
  
}
