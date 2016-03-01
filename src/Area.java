import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.imageio.ImageIO;




public class Area extends JPanel implements KeyListener, ActionListener {

  // The trees that are scattered around the area.
  protected Tree trees[];
  
  // The area tile map.
  protected int tiles[][];
  
  // The grass and stone images used as the floor texture.
  private BufferedImage grassImage;
  private BufferedImage stoneImage;
  
  // To hide this parameter from being passed around.
  private Graphics2D g2;
  
  // Defined constants.
  protected static final int grass = 0;
  protected static final int stone = 1;
  protected static final int fire = 2;
  protected static final int building = 3;
  protected static final int portal = 4;
  protected static final int portal1 = 5;
  protected static final int portal2 = 6;
  protected static final int portal3 = 7;
  protected static final int home = 8;
  protected static final int numTilesX = Window.WIDTH / 64;
  protected static final int numTilesY = Window.HEIGHT / 64;
  protected static final double maxTreeX = Window.WIDTH - Tree.WIDTH;
  protected static final double maxTreeY = Window.HEIGHT - Tree.HEIGHT;

  int direction = 0;
	int x = 9, y = 4;
	

	
	ImageIcon upSorcerer = new ImageIcon("sorcerer.png");
	ImageIcon downSorcerer = new ImageIcon("sorcererdown.png");
  
  // The constructor for the Area class.
  public Area() {
    
    g2 = null;
    
    setBackground(Color.BLACK);
    setPreferredSize(new Dimension(Window.WIDTH, Window.HEIGHT));
    
	addKeyListener(this);
	setFocusable(true);
	setFocusTraversalKeysEnabled(false);
    
  }
  // draws tile within 2D graphics window
  protected void drawTile(Tile t, int i, int j){
	  t.drawTile(g2, i, j);
  }
  
  protected void drawTree(int i) {
    if (trees != null) {
      trees[i].draw(g2);
    }
  }
  
  // Overridden function from JPanel, which allows us to
  // write our own paint method which draws our area.
  @Override
  public void paint(Graphics g) {
    // This calls JPanel's paintComponent method to handle
    // the lower-level details of drawing in a window.
    super.paint(g);
    
    g2 = (Graphics2D)g;
    
    drawTiles();
    drawTrees();
    
    // Sync for cross-platform smooth rendering.
    Toolkit.getDefaultToolkit().sync();
  }
  
  protected void drawTiles() {
    // TODO: Implement in a child class.
  }
  
  protected void drawTrees() {
    // TODO: Implement in a child class.
  }


// Method that defines when and by how much the Sorcerer character moves up.	
	public void up(){
		if(tiles[x][y-1] == stone){
			System.out.println("\n"+"\n"+"\n"+"This rock is too big for even you to move.");
			return;
		}
		if(tiles[x][y-1] == fire){
			repaint();
			x=9; // moves Sorcerer to default location
			y=4;
			System.out.println("\n"+"\n"+"\n"+"Feel the burn...");
			return;
		}
		if(tiles[x][y-1] == building){
			return;
		}
		if (tiles[x][y-1]==portal){
			repaint();
			x=0; // moves Sorcerer to new location.
			y=0;
			System.out.println("\n"+"\n"+"\n"+"Whoosh.. The blue aura has taken you to a new location. Proceed with caution.");
			return;
		}
		if (tiles[x][y-1]==portal1){
			repaint();
			x=0;
			y=9;
			System.out.println("\n"+"\n"+"\n"+"Whoosh.. The dark vortex has taken hold of you. Proceed with caution.");
			return;
		}
		if (tiles[x][y-1]==portal2){
			repaint();
			x=2;
			y=7;
			System.out.println("\n"+"\n"+"\n"+"Whoosh.. A Maelstrom of colors surrounds you. Proceed with caution.");
			return;
		}
		if (tiles[x][y-1]==portal3){
			repaint();
			x=17;
			y=9;
			System.out.println("\n"+"\n"+"\n"+"Whoosh.. You have been whisked away. Proceed with caution.");
			return;
		}
		if (tiles[x][y-1]== home){
			System.out.println("\n"+"\n"+"\n"+"Your long journey has finally ended. Welcome home, Sorcerer!");
		}
		y += -1;
		x += 0;
		repaint();
	}
	
	// Method that defines when and by how much the Sorcerer character moves down.	
	public void down(){
		if(tiles[x][y+1] == stone){
			System.out.println("\n"+"\n"+"\n"+"This rock is too big for even you to move.");
			return;
		}
		if(tiles[x][y+1] == fire){
			repaint();
			x=9;
			y=4;
			System.out.println("\n"+"\n"+"\n"+"Feel the burn...");
			return;
		}
		if(tiles[x][y+1] == building){
			return;
		}
		if (tiles[x][y+1]==portal){
			repaint();
			x=0;
			y=0;
			System.out.println("\n"+"\n"+"\n"+"Whoosh.. The blue aura has taken you to a new location. Proceed with caution.");
			return;
		}
		if (tiles[x][y+1]==portal1){
			repaint();
			x=0;
			y=9;
			System.out.println("\n"+"\n"+"\n"+"Whoosh.. The dark vortex has taken hold of you. Proceed with caution.");
			return;
		}
		if (tiles[x][y+1]==portal2){
			repaint();
			x=2;
			y=7;
			System.out.println("\n"+"\n"+"\n"+"Whoosh.. A Maelstrom of colors surrounds you. Proceed with caution.");
			return;
		}
		if (tiles[x][y+1]==portal3){
			repaint();
			x=17;
			y=9;
			System.out.println("\n"+"\n"+"\n"+"Whoosh.. You have been whisked away. Proceed with caution.");
			return;
		}
		if (tiles[x][y+1]== home){
			System.out.println("\n"+"\n"+"\n"+"Your long journey has finally ended. Welcome home, Sorcerer!");
		}
		y += 1;
		x += 0;
		repaint();
		
	}
	// Method that defines when and by how much the Sorcerer character moves left.	
	public void left() {
		if(tiles[x-1][y] == stone){
			System.out.println("\n"+"\n"+"\n"+"This rock is too big for even you to move.");
			return;
		}
		if(tiles[x-1][y] == fire){
			repaint();
			x=9;
			y=4;
			System.out.println("\n"+"\n"+"\n"+"Feel the burn...");
			return;
		}
		if(tiles[x-1][y] == building){
			return;
		}
		if (tiles[x-1][y]==portal){
			repaint();
			x=0;
			y=0;
			System.out.println("\n"+"\n"+"\n"+"Whoosh.. The blue aura has taken you to a new location. Proceed with caution.");
			return;
		}
		if (tiles[x-1][y]==portal1){
			repaint();
			x=0;
			y=9;
			System.out.println("\n"+"\n"+"\n"+"Whoosh.. The dark vortex has taken hold of you. Proceed with caution.");
			return;
		}
		if (tiles[x-1][y]==portal2){
			repaint();
			x=2;
			y=7;
			System.out.println("\n"+"\n"+"\n"+"Whoosh.. A Maelstrom of colors surrounds you. Proceed with caution.");
			return;
		}
		if (tiles[x-1][y]==portal3){
			repaint();
			x=17;
			y=9;
			System.out.println("\n"+"\n"+"\n"+"Whoosh.. You have been whisked away. Proceed with caution.");
			return;
		}
		if (tiles[x-1][y]== home){
			System.out.println("\n"+"\n"+"\n"+"Your long journey has finally ended. Welcome home, Sorcerer!");
		}
		
		x += -1;
		y += 0;
		repaint();
	}
	// Method that defines when and by how much the Sorcerer character moves right.	
	public void right(){
		if(tiles[x+1][y] == stone){
			System.out.println("\n"+"\n"+"\n"+"This rock is too big for even you to move.");
			return;
		}
		if(tiles[x+1][y] == fire){
			repaint();
			x=9;
			y=4;
			System.out.println("\n"+"\n"+"\n"+"Feel the burn...");
			return;
		}
		if(tiles[x+1][y] == building){
			return;
		}
		if (tiles[x+1][y]==portal){
			repaint();
			x=0;
			y=0;
			System.out.println("\n"+"\n"+"\n"+"Whoosh.. The blue aura has taken you to to a new location. Proceed with caution.");
			return;
		}
		if (tiles[x+1][y]==portal1){
			repaint();
			x=0;
			y=9;
			System.out.println("\n"+"\n"+"\n"+"Whoosh.. The dark vortex has taken hold of you. Proceed with caution.");
			return;
		}
		if (tiles[x+1][y]==portal2){
			repaint();
			x=2;
			y=7;
			System.out.println("\n"+"\n"+"\n"+"Whoosh.. A Maelstrom of colors surrounds you. Proceed with caution.");
			return;
		}
		if (tiles[x+1][y]==portal3){
			repaint();
			x=17;
			y=9;
			System.out.println("\n"+"\n"+"\n"+"Whoosh.. You have been whisked away. Proceed with caution.");
			return;
		}
		if (tiles[x+1][y]== home){
			System.out.println("\n"+"\n"+"\n"+"Your long journey has finally ended. Welcome home, Sorcerer!");
		}
		x += 1;
		y += 0;
		repaint();
	}
	
	// Coordinates keys pressed with methods and direction. Direction corresponds with sorcerer image. 
	// if direction = 0, sorcerer faces upwards; if direction = 1, sorcerer faces upside down. (Within Sorcerer.java)
	public void keyPressed(KeyEvent e){
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_UP){
			up();
			direction = 0;
		}
		if (code == KeyEvent.VK_DOWN){
			down();
			direction = 1;
		}
		if (code == KeyEvent.VK_RIGHT){
			right();
		}
		if (code == KeyEvent.VK_LEFT){
			left();
		}
		
		
	}
	public void keyTyped(KeyEvent e){}
	public void keyReleased(KeyEvent e){}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}  
