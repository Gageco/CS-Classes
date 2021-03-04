import java.awt.Color;
 import java.util.ArrayList;

 public class MyTempConverter
 {
 private Color[][] grid;

 public MyTempConverter(int numRows, int numCols)
 {
	 grid = new Color[numRows][numCols];
 for(int i = 0; i < grid.length; i++) {
 for(int j = 0; j < grid[i].length; j++) {
 if(i % 2 == 0) {
 grid[i][j] = Color.BLACK;
 } else {
 grid[i][j] = Color.WHITE;
 }
 }
 }
 }

 public ArrayList<Color> getNeighbors(int i, int j)
 {
 if(i < 0 || i >= grid.length) {
 System.err.println("i must be in range");
 return null;
 }
 if(j < 0 || j >= grid.length) {
 System.err.println("j must be in range");
 return null;
 }

 ArrayList<Color> list = new ArrayList<Color>();

 list.add(grid[i-1][j]);
 list.add(grid[i][j+1]);
 list.add(grid[i+1][j]);
 list.add(grid[i][j-1]);

 return list;
 }
}