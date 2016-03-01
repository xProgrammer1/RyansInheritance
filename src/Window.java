import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import javax.swing.JFrame;
//import Sorcerer.Craft;


public class Window extends JFrame {
  
  // The width and height of the window (in pixels).
  public static final int WIDTH = 1280;
  public static final int HEIGHT = 640;
  
  // The constructor for the Window class.
  public Window(String title) {
    setTitle(title);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    setSize(WIDTH, HEIGHT);
    setLocationRelativeTo(null);
    setResizable(false);
  }

}