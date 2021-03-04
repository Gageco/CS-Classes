/**
 * @author Gagecoprivnicar
 */

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * FormatChecker aims to verify the format of provided documents based on a few set parameters.
 * @author Gageco
 *
 */
public class FormatChecker {
	public static void main(String[] args) {
		
		if (args.length == 0) {
			System.out.println("Usage: Java FormatChecker file1 [file2...fileN]");
			System.exit(0);
		}
			
			List<List<Double>> listOfDoubles = new ArrayList<>();
			
			for (int i = 0; i < args.length; i++) {
				List<String> fileLines = FileExists(args[i]);
				if (!fileLines.isEmpty() && !fileLines.get(0).equals("null")) {
					if(AreAllValuesDoubles(fileLines)) {
						if (TheFirstLineIsIntegers(fileLines.get(0))) {					//Converts the String file to a list of a list of doubles
							listOfDoubles = ConvertStringListToDoubleList(fileLines);
							if (CheckNumberOfRows(listOfDoubles)) {					
								if (CheckNumberOfColumns(listOfDoubles)) {
									System.out.println("The file: " + args[i] + " matches all requirements\nVALID");						//Here all requirements have been met and the file is valid
									
								} else {												//Catches and prints if the number of columns doesn't match the actual number of columns
									System.out.println("The number of columns given in File" + args[i] + " doesn't match the expected number of columns: \nINVALID");
								}
							} else {													//Catches and prints if the number of rows doesn't match the actual number of rows
								System.out.println("The number of rows given in File " + args[i] + " doesn't match the expected number of rows: \nINVALID");
							}						
						} else {														//Catches and prints if the first line is not integers
							System.out.println("In the first line of File " + args[i] + " the first line does not consist of two integers: \nINVALID");
						}
					} else {															//Catches and prints if there are things that aren't doubles in the file
						System.out.println("java.lang.NumberFormatException: File " + args[i] + " has non-double values\nINVALID");
					}
				} else {																//Catches and prints if the file doesn't exist
					System.out.println("java.io.FileNotFoundException: File " + args[i] + " does not appear to exist\nINVALID");
				}
				System.out.println("");
			}
	}

	/**
	 * Checks if the first line of the file consists of two integers as expected
	 * @param firstLine - the firstLine of the file
	 * @return true if firstLine consists of two integers
	 */
	private static Boolean TheFirstLineIsIntegers(String firstLine) {
		firstLine = firstLine.replaceAll("\t", "");
		String[] hopefulIntegers = firstLine.split(" ");
		if (hopefulIntegers.length != 2) {
			return false;
		}
		
		for (int i = 0; i < hopefulIntegers.length; i++) {	
			try {
				Integer.valueOf(hopefulIntegers[i]);	
			} catch (java.lang.NumberFormatException e) {
				return false;
			}
		}
		return true;
	}
	/**
	 * Returns the boolean value if the number of columns expected, and the actual number of columns matches 
	 * @param doubleLines - a List<List<Double>> type with the relevant data
	 * @return true if the number of columns indicated in the first line of the file matches the actual number of columns
	 */
	private static Boolean CheckNumberOfColumns(List<List<Double>> doubleLines) {
		double numberOfCols = doubleLines.get(0).get(1);
		for (int i = 1; i < doubleLines.size(); i++) {
			double rowSize = doubleLines.get(i).size();
			
			if (!(rowSize == numberOfCols)) {
				return false;
			}
		}
		return true;
	}
	/**
	 * Returns the boolean value if the number of rows expected, and the actual number of rows matches
	 * @param doubleLines - List<List<Double>> type with the relevant data
	 * @return true if the number of rows indicated in the first line of the file matches the actual number of rows
	 */
	private static Boolean CheckNumberOfRows(List<List<Double>> doubleLines) {
		double numberOfRowsExpected = doubleLines.get(0).get(0);
		double actualNumberOfRows = doubleLines.size() - 1;
		
		return numberOfRowsExpected == actualNumberOfRows;
	}
	/**
	 * Converts the file data from List<String> form to  List<List<Double>> form
	 * @param fileLines - file data in List<String> form
	 * @return List<List<Double>> - the converted form of the file data
	 */
	private static  List<List<Double>> ConvertStringListToDoubleList(List<String> fileLines) {
		List<List<Double>> fileLinesDouble = new ArrayList<>();
		List<Double> fileDouble = new ArrayList<>();
		String[] fileStringDoubles;
		
		for (int i = 0; i < fileLines.size(); i++) {
			fileStringDoubles = fileLines.get(i).split(" ");
			fileDouble = new ArrayList<>();
			for (int j = 0; j < fileStringDoubles.length; j++) {
				
				if (!fileStringDoubles[j].isEmpty()) {
					Double convertedDouble = Double.valueOf(fileStringDoubles[j]);
					fileDouble.add(convertedDouble);
				}
			}
			if (!fileDouble.isEmpty()) {
				fileLinesDouble.add(fileDouble);
			}
		}
		return fileLinesDouble;
	}
	/**
	 * Checks if all the values in the file are doubles as they should be
	 * @param fileLines - the file data in List<String> form
	 * @return true if all the values are doubles
	 */
	private static Boolean AreAllValuesDoubles(List<String> fileLines) {
		for (int i = 0; i < fileLines.size(); i++) {
			String[] hopefulDoubles = fileLines.get(i).split(" ");
			for (int j = 0; j< hopefulDoubles.length; j++) {
				try {
					if (!hopefulDoubles[j].isEmpty()) {
						Double.valueOf(hopefulDoubles[j]);	
					}
				} catch (java.lang.NumberFormatException e) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	/**
	 * This function aims to check if the file exists, and if it does, it will return all lines in the file in an ArrayList String
	 * @param filename - the name of the file to check
	 * @return List<String> with the file information formatted
	 */
	private static List<String> FileExists(String filename) {
		File file = new File(filename);
		List<String> fileLines = new ArrayList<>();
		Scanner fileScan = new Scanner("");
		
		if (file.exists() && file.isFile()) {
			try {
				fileScan = new Scanner(file);
			} catch (FileNotFoundException e) {
				fileLines.add("null");
				return fileLines;
			}
		} 
		while(fileScan.hasNextLine()) {
			fileLines.add(fileScan.nextLine());
		}
		
		
		return fileLines;
	}
}