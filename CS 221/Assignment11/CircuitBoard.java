import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Represents a 2D circuit board as read from an input file.
 *  
 * @author mvail
 */
public class CircuitBoard {
	/** current contents of the board */
	private char[][] circuitBoard;
	/** location of row,col for '1' */
	private Point startingPoint;
	/** location of row,col for '2' */
	private Point endingPoint;

	//constants you may find useful
	private int ROWS = 0;
	private int COLS = 0;
	private final char OPEN = 'O'; //capital 'o'
	private final char TRACE = 'T';
	private final char START = '1';
	private final char END = '2';
	private final String ALLOWED_CHARS = "OXT12";

	/** Construct a CircuitBoard from a given board input file, where the first
	 * line contains the number of rows and columns as ints and each subsequent
	 * line is one row of characters representing the contents of that position.
	 * Valid characters are as follows:
	 *  'O' an open position
	 *  'X' an occupied, unavailable position
	 *  '1' first of two components needing to be connected
	 *  '2' second of two components needing to be connected
	 *  'T' is not expected in input files - represents part of the trace
	 *   connecting components 1 and 2 in the solution
	 * 
	 * @param filename file containing a grid of characters
	 * @throws FileNotFoundException if Scanner cannot read the file
	 * @throws InvalidFileFormatException for any other format or content issue that prevents reading a valid input file
	 */
	public CircuitBoard(String filename) throws FileNotFoundException, InvalidFileFormatException {
		
		Scanner fileScan = new Scanner(new File(filename));
		String line = fileScan.nextLine();
		Scanner lineScanner = new Scanner(line);

		//Checks if the first line has an integer for rows and columns.
		try {
			ROWS = lineScanner.nextInt(); 
			COLS = lineScanner.nextInt();
			
		} catch (Exception e) {
			lineScanner.close();
			throw new InvalidFileFormatException("First row doesn't consist of integers for rows and columns");
		}
		
		//Checks if the first line has more then two arguments
		if (lineScanner.hasNext()) {
			lineScanner.close();
			throw new InvalidFileFormatException("First line has too many items");
		}
		
		lineScanner.close();
		
		circuitBoard = new char[ROWS][COLS];
		for (int i = 0; i < ROWS; i++) {
			//Not enough rows indicated in file
			if (!fileScan.hasNext()) {
				throw new InvalidFileFormatException("Not enough rows to match indicated number");
			}
			
			line = fileScan.nextLine();
			lineScanner = new Scanner(line);
			
			//Not enough columns indicated in file
			for (int j = 0; j < COLS; j++) {

				//Not enough columns indicated in file
				if (!lineScanner.hasNext()) {
					lineScanner.close();
					throw new InvalidFileFormatException("Not enough columns to match indicated number");
				}
					
				String scannedLine = lineScanner.next();
				
				//File has too many starting points indicated
				if (scannedLine.charAt(0) == START) {
					if (startingPoint == null) {
						startingPoint = new Point(i,j);
					} else {
						lineScanner.close();
						throw new InvalidFileFormatException("File has too many starting points indicated");
					}
				}
				
				//File has too many ending points indicated
				if (scannedLine.charAt(0) == END) {
					if (endingPoint == null) {
						endingPoint = new Point(i,j);
					} else {
						lineScanner.close();
						throw new InvalidFileFormatException("File has too many ending points indicated");
					}
				}
				
				//Checks that the file has the allowable characters
				if (!ALLOWED_CHARS.contains(scannedLine)) {
					lineScanner.close();
					throw new InvalidFileFormatException(scannedLine + " is not an allowable character");
				}
				
				//Not enough columns indicated in file
				circuitBoard[i][j] = scannedLine.charAt(0);
				if (lineScanner.hasNext() && j == COLS - 1) {
					lineScanner.close();
					throw new InvalidFileFormatException("Not enough columns to match indicated number");
				}
				

			}
			
			//Not enough rows indicated in file
			if (fileScan.hasNextLine() && i == ROWS - 1) {
				lineScanner.close();
				throw new InvalidFileFormatException("Not enough rows to match indicated number");
			}
			
			lineScanner.close();
			
		//Checks if ending point exists
		} if (endingPoint == null) {
			throw new InvalidFileFormatException("No ending point.");
		} 
		//Checks if starting point exists
		if (startingPoint == null) {
			throw new InvalidFileFormatException("No startinging point.");
		}
		
		fileScan.close();
	}
	
	/** Copy constructor - duplicates original board
	 * 
	 * @param original board to copy
	 */
	public CircuitBoard(CircuitBoard original) {
		circuitBoard = original.getBoard();
		startingPoint = new Point(original.startingPoint);
		endingPoint = new Point(original.endingPoint);
		ROWS = original.numRows();
		COLS = original.numCols();
	}

	/** utility method for copy constructor
	 * @return copy of board array */
	private char[][] getBoard() {
		char[][] copy = new char[circuitBoard.length][circuitBoard[0].length];
		for (int row = 0; row < circuitBoard.length; row++) {
			for (int col = 0; col < circuitBoard[row].length; col++) {
				copy[row][col] = circuitBoard[row][col];
			}
		}
		return copy;
	}
	
	/** Return the char at board position x,y
	 * @param row row coordinate
	 * @param col col coordinate
	 * @return char at row, col
	 */
	public char charAt(int row, int col) {
		return circuitBoard[row][col];
	}
	
	/** Return whether given board position is open
	 * @param row
	 * @param col
	 * @return true if position at (row, col) is open 
	 */
	public boolean isOpen(int row, int col) {
		if (row < 0 || row >= circuitBoard.length || col < 0 || col >= circuitBoard[row].length) {
			return false;
		}
		return circuitBoard[row][col] == OPEN;
	}
	
	/** Set given position to be a 'T'
	 * @param row
	 * @param col
	 * @throws OccupiedPositionException if given position is not open
	 */
	public void makeTrace(int row, int col) {
		if (isOpen(row, col)) {
			circuitBoard[row][col] = TRACE;
		} else {
			throw new OccupiedPositionException("row " + row + ", col " + col + "contains '" + circuitBoard[row][col] + "'");
		}
	}
	
	/** @return starting Point(row,col) */
	public Point getStartingPoint() {
		return new Point(startingPoint);
	}
	
	/** @return ending Point(row,col) */
	public Point getEndingPoint() {
		return new Point(endingPoint);
	}
	
	/** @return number of rows in this CircuitBoard */
	public int numRows() {
		return ROWS;
	}
	
	/** @return number of columns in this CircuitBoard */
	public int numCols() {
		return COLS;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (int row = 0; row < circuitBoard.length; row++) {
			for (int col = 0; col < circuitBoard[row].length; col++) {
				str.append(circuitBoard[row][col] + " ");
			}
			str.append("\n");
		}
		return str.toString();
	}
	
}// class CircuitBoard