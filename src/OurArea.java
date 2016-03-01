public class OurArea extends Area {
  
  /*
  // The trees that are scattered around the area.
  Tree trees[];
  
  // The area tile map, with each tile represented as an integer.
  int tiles[][];
  
  // The tile values for grass (0) and stone (1) tiles.
  int grass;
  int stone;
  
  // The number of tiles on the x-axis, and y-axis.
  int numTilesX;
  int numTilesY;
  
  // The maximum position of a tree on the x-axis and y-axis.
  // Note: The minimum is simply (0, 0).
  double maxTreeX;
  double maxTreeY;
  */
  
  // The constructor for OurArea. It takes in a parameter for the
  // number of trees to place in the area.
  public OurArea(int numberOfTrees) {
    super(); // A magic function. I wonder what it does? 
    
    //* Exercise #1. Setup the tree objects at random locations.
    trees = new Tree[numberOfTrees];
    for (int i = 0; i < numberOfTrees; i++) {
      trees[i] = new Tree((int)(Math.random() * maxTreeX),
                          (int)(Math.random() * maxTreeY));
    }
    //*/
    
    //* Exercise #3. Initialize the tiles.
    tiles = new int[numTilesX][numTilesY];
    for (int i = 0; i < numTilesX; i++) {
      for (int j = 0; j < numTilesY; j++) {
        // Example: Default to grass everywhere.
        tiles[i][j] = grass;
        
      }
    }
    
    // Example: Draw two stones at specific locations.
    tiles[0][1] = fire;
    tiles[0][4] = stone;
    tiles[0][8] = fire;
    
    
    tiles[1][1] = fire;
    tiles[1][4] = fire;
    tiles[1][5] = fire;
    tiles[1][6] = stone;
    tiles[1][8] = fire;
    tiles[1][9] = fire;
    
    tiles[2][1] = stone;
    tiles[2][3] = stone;
    tiles[2][6] = stone;
    
    tiles[3][4] = fire;
    tiles[3][7] = stone;
    tiles[3][8] = stone;
    
    tiles[4][1] = stone;
    tiles[4][5] = fire;
    
    tiles[5][1] = stone;
    tiles[5][2] = stone;
    tiles[5][3] = stone;
    tiles[5][4] = stone;
    tiles[5][5] = stone;
    tiles[5][6] = fire;
    tiles[5][7] = fire;
    tiles[5][8] = fire;
    tiles[5][9] = stone;
    
    tiles[6][0] = fire;
    tiles[6][1] = stone;
    tiles[6][6] = stone;
    tiles[6][9] = stone;
    
    tiles[7][1] = stone;
    tiles[7][3] = stone;
    tiles[7][4] = stone;
    tiles[7][6] = stone;
    tiles[7][8] = fire;
    
    tiles[8][1] = stone;
    tiles[8][5] = stone;
    tiles[8][6] = stone;
    tiles[8][8] = fire;
    
    tiles[10][0] = stone;
    tiles[10][1] = stone;
    tiles[10][2] = stone;
    tiles[10][4] = stone;
    tiles[10][5] = stone;
    tiles[10][8] = stone;
    tiles[10][9] = fire;
    
    tiles[11][3] = stone;
    
    tiles[12][1] = stone;
    tiles[12][5] = fire;
    tiles[12][6] = fire;
    tiles[12][7] = fire;
    tiles[12][9] = fire;
    
    tiles[13][1] = stone;
    tiles[13][2] = stone;
    tiles[13][3] = stone;
    tiles[13][7] = stone;
    
    tiles[14][0] = stone;
    tiles[14][5] = fire;
    tiles[14][6] = stone;
    tiles[14][7] = fire;
    tiles[14][8] = fire;
    
    tiles[15][0] = fire;
    tiles[15][2] = stone;
    tiles[15][3] = stone;
    tiles[15][4] = stone;
    tiles[15][5] = stone;
    
    tiles[16][0] = fire;
    tiles[16][6] = fire;
    tiles[16][7] = fire;
    tiles[16][8] = stone;
    tiles[16][9] = stone;
    
    tiles[17][3] = stone;
    tiles[17][5] = stone;
    tiles[17][8] = stone;
    
    tiles[18][1] = stone;
    tiles[18][3] = fire;
    tiles[18][4] = fire;
    tiles[18][5] = fire;
    tiles[18][6] = fire;
    tiles[18][8] = stone;
    
    tiles[19][1] = stone;
    tiles[19][8] = stone;
    
    tiles[7][5] = portal;
    
    tiles[13][0] = portal1;

    tiles[17][6] = portal2;
    
    tiles[2][4] = portal3;
    
    tiles[19][9] = home;


  }
  
  // This function must draw each tree to the screen.
  protected void drawTrees() {
    //* Exercise #2. Draw the trees.
    for (int i = 0; i < trees.length; i++) {
      drawTree(i);
    }
    //*/
  }
  
  protected void drawTiles() {
    //* Exercise #4. Draw the tiles.
    for (int i = 0; i < numTilesX; i++) {
      for (int j = 0; j < numTilesY; j++) {
    	//when a tile is set to grass draw grass 
        //otherwise draw a stone
        if (tiles[i][j] == grass) {
          Grass g = new Grass();
          drawTile(g, i, j);
        } if (tiles[i][j]==stone) {
          Stone s = new Stone();
          drawTile(s,i,j);
        } if (tiles[i][j]== fire){
        	Fire f = new Fire();
        	drawTile(f,i,j);
        } if (tiles[i][j]== building){
        	Grass g = new Grass();
        	drawTile(g,i,j);
        	Building b = new Building();
        	drawTile(b,i,j);
        }if (tiles[i][j]== portal){
        	Grass g = new Grass();
        	drawTile(g,i,j);
        	Portal p = new Portal();
        	drawTile(p,i,j);
      }if (tiles[i][j]== portal1){
      	Grass g = new Grass();
      	drawTile(g,i,j);
      	Portal1 p1 = new Portal1();
      	drawTile(p1,i,j);
      }if (tiles[i][j]== portal2){
        	Grass g = new Grass();
          	drawTile(g,i,j);
          	Portal2 p2 = new Portal2();
          	drawTile(p2,i,j);
      }if (tiles[i][j]== portal3){
        	Grass g = new Grass();
          	drawTile(g,i,j);
          	Portal3 p3 = new Portal3();
          	drawTile(p3,i,j);
     }if (tiles[i][j]== home){
       	Grass g = new Grass();
       	drawTile(g,i,j);
       	Home home = new Home();
       	drawTile(home,i,j);
     }
      
    }
    drawTile(new Sorcerer(direction), x, y);
  }
}
} 
  

