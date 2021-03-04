
public class GridMontitorMain {
	public static void main(String[] args) {
		GridMonitor grid = new GridMonitor("sample.txt");
		System.out.println(grid.toString());
		
		
//		printArray(grid.getSurroundingSumGrid());
//		printArray(grid.getSurroundingAvgGrid());
//		printArray(grid.getDeltaGrid());
//		printArray(grid.getDangerGrid());

	}
	
	public static void printArray(boolean[][] panelArray) {
		String retString = "\n\n[";
		
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
			retString += "]\n";
		}
		System.out.println(retString);
	}
	
	public static void printArray(double[][] panelArray) {
		String retString = "\n\n[";
		
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
			retString += "]\n";
		}
		System.out.println(retString);
	}
}
