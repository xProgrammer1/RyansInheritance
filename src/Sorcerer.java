import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;


public class Sorcerer extends Tile {
	// defines image based on direction sorcerer is facing
	public Sorcerer(int direction){
		super(getImageFromDirection(direction));
	}
	
	static String getImageFromDirection(int direction){
		if(direction == 0){
			return "sorcerer.png";
		}
		if (direction == 1){
			return "sorcererdown.png";
		}
		return "";
	}
	

}
