/**
* Will display a ascii image
* @Gage Coprivnicar cs121 
* Project 1
*/

public class ModernArt {
	public static void main(String[] args) {
/**
*    /\
*   /  \
*  |    |
*  | 00 |
* /      \
*|        |
*|  |  |  |
*|  |  |  |
*|/\/\/\/\|
*|/\/\/\/\|
*/
		//Constant Variables
		final String BOTTOM_PART = "|/\\/\\/\\/\\|";
		final String BORDER_HORI = "|______________|";
		
		//Variables
		String modernArtEyes = "00";
		
		//Output
		System.out.println(BORDER_HORI);
		System.out.println("|      /\\      |");
		System.out.println("|     /  \\     |");
		System.out.println("|    |    |    |");
		System.out.print("|    |");
		System.out.print(" " + modernArtEyes + " ");
		System.out.print("|    |" +"\n");
		System.out.println("|   /      \\   |");
		System.out.println("|  |        |  |");
		System.out.println("|  |  |  |  |  |");
		System.out.println("|  |  |  |  |  |");
		System.out.println("|  " + BOTTOM_PART + "  |");
		System.out.println("|  " + BOTTOM_PART + "  |");
		System.out.println(BORDER_HORI);
	}
}
