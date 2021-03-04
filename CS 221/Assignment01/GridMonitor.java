/**
 * @author gagecoprivnicar
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class GridMonitor implements GridMonitorInterface{
	private double[][] panelArray;
	private double[][] extendedPanelArray;
	private int rows;
	private int cols;
	
	GridMonitor(String filename) throws FileNotFoundException {
		try {		
		//Check if the file actually exists
			File solarArrayFile = new File(filename);
//		Scanner fileScan = new Scanner("");
		
//		if (solarArrayFile.exists() && solarArrayFile.isFile()) {
		
			Scanner fileScan = new Scanner(solarArrayFile);
			
	//		}
		
			//Go through file, assigning first line the height and width of the Array, then read the rest into the array
			////Get first line
			String firstLine = "";
			
			firstLine = Files.readAllLines(Paths.get(filename)).get(0);
			
			
			firstLine = firstLine.replaceAll(" ", "");
			this.rows = Integer.parseInt(((Character.toString(firstLine.charAt(0)))));
			this.cols = Integer.parseInt(((Character.toString(firstLine.charAt(1)))));
			
			this.panelArray = new double[rows][cols];
			
			
			int extRows = rows+2;
			int extCols = cols+2;
			this.extendedPanelArray = new double[extRows][extCols];
			
			int lineNumber = 0;
			
			//Going through the rest of the file and reading it into panelArray
			while (fileScan.hasNextLine()) {
				String fileLine = fileScan.nextLine();
				
				//Parsing the file to panelArray and extendedPanelArray
				if (!firstLine.equals(fileLine.replaceAll(" ", ""))) {
									
					for (int i = 0; i < cols; i++) {
						Double setDouble;
						int spaceLocation = fileLine.indexOf(" ");
						if (spaceLocation != -1) {		
							setDouble = Double.parseDouble(fileLine.substring(0,spaceLocation));
	//						System.out.println(setDouble);
							panelArray[lineNumber-1][i] = setDouble;
							extendedPanelArray[lineNumber][i+1] = setDouble;
							
							fileLine = fileLine.substring(spaceLocation+1, fileLine.length());
						}
						else {
							panelArray[lineNumber-1][i] = Double.parseDouble(fileLine);
							extendedPanelArray[lineNumber][i+1] = Double.parseDouble(fileLine);
						}
					}
				}
			
			lineNumber += 1;
			}

			//Filling in the extendedPanelArray
			for (int i = 0; i < extRows; i++) {
				for (int j = 0; j < extCols; j++) {
					
					//set top left corner to 0
					if (i == 0 && j == 0) {
						extendedPanelArray[i][j] = 0;
					}
					//set top right corner to 0
					else if (i == 0 && j == extCols-1) {
						extendedPanelArray[i][j] = 0;
					} 
					//set bottom left corner to 0
					else if (i == extRows-1 && j == 0) {
						extendedPanelArray[i][j] = 0;
					}
					//set bottom right corner to 0
					else if (i == extRows-1 && j == extCols-1) {
						extendedPanelArray[i][j] = 0;
					}
					
					//set top row of extendedPanelArray to the top row of panelArray 
					else if (i == 0) {
						extendedPanelArray[i][j] = panelArray[i][j-1];
					}
					//set bottom row of extendedPanelArray to the bottom row of panelArray 
					else if (i == extRows-1) {
						extendedPanelArray[i][j] = panelArray[i-2][j-1];
					}
					//set left column of extendedPanelArray to the left column of panelArray
					else if (j == 0) {
						extendedPanelArray[i][j] = panelArray[i-1][j];
					}
					//set rightmost column of extendedPanelArray to the rightmost column of panelArray
					else if (j == extCols-1) {
						extendedPanelArray[i][j] = panelArray[i-1][j-2];
					}
					
				
					
				}
			} 
//		} catch (FileNotFoundException e) {
//			System.out.println("File Not Found, please try again: " + e);
////			e.printStackTrace();
////			System.exit(0);
		} catch (IOException e) {
			System.out.println("IOException" + e);
		}
		
	
	}
	/**
	 * Returns string version of the grid passed in
	 * 
	 * @return String
	 */
	public String toString() {
		String retString = "panelArray\n[";
		
		for (int i = 0; i < panelArray.length; i++) {
			for (int j = 0; j < panelArray[0].length; j++) {
				if (j == 0) {
					retString += "[";
				}
				else if (j == panelArray[0].length) {
					retString += "]";
				}
				retString += panelArray[i][j] + ", ";
			}
			retString += "]";//\n";
		}
		retString += "]";//\n\nextendedPanelArray\n";

		
////Below is the code for printing the extendedPanelArray 
		
//		for (int i = 0; i < extendedPanelArray.length; i++) {
//			for (int j = 0; j < extendedPanelArray[0].length; j++) {
//				if (j == 0) {
//					retString += "[";
//				}
//				else if (j == extendedPanelArray[0].length) {
//					retString += "]";
//				}
//				retString += extendedPanelArray[i][j] + ", ";
//			}
//			retString += "]\n";
//		}
		
		return retString;
	}
	/**
	 * Finds and returns all adjacent grid values in an array 
	 * @param i value in grid
	 * @param j value in grid
	 * @return double[] with the four adjacent values
	 */
	private double[] getAdjacent(int i, int j) {
		double[] adjValues = new double[4];
		
		//Order for grid location: Above, Left Of, Below, Right Of Grid local
		adjValues[0] = extendedPanelArray[i][j+1];
		adjValues[1] = extendedPanelArray[i+1][j];
		adjValues[2] = extendedPanelArray[i+1][j+2];
		adjValues[3] = extendedPanelArray[i+2][j+1];
		return adjValues;
	}
	

	@Override
	public double[][] getBaseGrid() {
		double[][] retArray = new double[rows][cols];
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				retArray[i][j] = panelArray[i][j];
			}
		}
		
		return retArray;
	}

	@Override
	public double[][] getSurroundingSumGrid() {
		double [][] retGrid = new double[rows][cols];
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				double[] adj = getAdjacent(i, j);
				
				double gridLocationSum = 0;
				for (int k = 0; k < adj.length; k++) {
					gridLocationSum += adj[k];
				}
				retGrid[i][j] = gridLocationSum;
				
			}
		}
		
		return retGrid;
	}

	@Override
	public double[][] getSurroundingAvgGrid() {
		double [][] retGrid = this.getSurroundingSumGrid();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				retGrid[i][j] = retGrid[i][j]/4;
			}
		}
		
		return retGrid;
	}

	@Override
	public double[][] getDeltaGrid() {
		double [][] retGrid = this.getSurroundingAvgGrid();
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				retGrid[i][j] = Math.abs(retGrid[i][j]/2);
			}
		}
		
		return retGrid;
	}

	@Override
	public boolean[][] getDangerGrid() {
		boolean[][] retGrid = new boolean[rows][cols];
		double [][] avgGrid = this.getSurroundingAvgGrid();
		double [][] delGrid = this.getDeltaGrid();

		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				retGrid[i][j] = false;
				
				if (avgGrid[i][j] < panelArray[i][j] - delGrid[i][j]) {
					retGrid[i][j] = true;
				}
				else if (avgGrid[i][j] > panelArray[i][j] + delGrid[i][j]) {
					retGrid[i][j] = true;
				}
				
			}
		}
		
		
		return retGrid;
	}
	
}
