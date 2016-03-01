import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;



public class Tile {
	// attributes and methods that are common to every time
	// each tile has some constant associated with it
	
	private BufferedImage tileImage;
	private Graphics2D g2;
	
	public Tile(String fileName){
		//Load the stone image from the file.
		try{
			tileImage = ImageIO.read(new URL("file:"+ fileName));
			
		} catch (IOException e){
			System.out.println("Failed to load"+ fileName +"image.");
		}
	}
	
	protected void drawTile (Graphics2D g2,int i, int j){
		g2.drawImage(tileImage, null, i*64, j*64);
	}
}
