import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/**
 * Lesson 12: Activity - ArrayLists
 *
 * @author CS121 Instructors
 * @version Fall2020
 * @author Gage
 */
public class MASHgame {

	public static void main(String[] args) {

		/* Define list of options */
		ArrayList<String> homeList = new ArrayList<String>();
		ArrayList<String> femaleSpouseList = new ArrayList<String>();
		ArrayList<String> maleSpouseList = new ArrayList<String>();
		ArrayList<String> occupationList = new ArrayList<String>();
		ArrayList<String> transportationList = new ArrayList<String>();
		ArrayList<String> hometownList = new ArrayList<String>();

		/* Add items to home list */
		homeList.add("mansion");
		homeList.add("apartment");
		homeList.add("shack");
		homeList.add("house");

		/* TODO: 1. Add items to femaleSpouseList */
		femaleSpouseList.add("Margery");
		femaleSpouseList.add("Debra");
		femaleSpouseList.add("Adrienne");
		femaleSpouseList.add("Adrianna");

		/* TODO: 2. Add items to maleSpouseList */
		maleSpouseList.add("Madden");
		maleSpouseList.add("Cormoran");
		maleSpouseList.add("Vega");
		maleSpouseList.add("Mr. Robot");

		/* TODO: 3. Add items to occupationList */
		occupationList.add("Teacher");
		occupationList.add("CS Professor");
		occupationList.add("Teachers Aid");
		occupationList.add("Lifelong Student, learning from the school of hardknocks");

		/* TODO: 4. Add items to transportationList */
		transportationList.add("Car");
		transportationList.add("Moped");
		transportationList.add("Train");
		transportationList.add("Walk");

		/* TODO: 5. Add items to hometownList */
		hometownList.add("Boise");
		hometownList.add("Kuna");
		hometownList.add("Littleton");
		hometownList.add("California");
		
		/* Print the database */
		System.out.println("--------------------- Future Possibilities Database ------------------------");
		System.out.print("Home List: ");
		for (String item: homeList) {
			System.out.print(item + " ");
		}
		System.out.println();
		
//		System.out.println(homeList.get(0));
		
		/* TODO: 6. Print the items in the femaleSpouseList using the ArrayList toString() method */
		System.out.print("Wife List: ");
		for (String item: femaleSpouseList) {
			System.out.print(item + " ");
		}
		System.out.println();
		
		/* TODO: 7. Print the items in the maleSpouseList using a for loop (IE: use indexes to print items ) */
		System.out.print("Husband List: ");
		for (String item: maleSpouseList) {
			System.out.print(item + " ");
		}
		System.out.println();
		
		/* TODO: 8. Print the items in the occupationList using the ArrayList iterator and a while loop */
		System.out.print("Job List: ");
		for (String item: occupationList) {
			System.out.print(item + " ");
		}
		System.out.println();
		
		/* TODO: 9. Print the items in the transportationList using a foreach loop */
		System.out.print("Transportation List: ");
		for (String item: transportationList) {
			System.out.print(item + " ");
		}
		System.out.println();
		
		/* TODO: 10. Print the items in the hometownList using the method of your choice */
		System.out.print("Hometown List: ");
		for (String item: hometownList) {
			System.out.print(item + " ");
		}
		System.out.println();
		
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("\n");

		/* Ask the player for their name */
		Scanner kbd = new Scanner(System.in);
		System.out.print("Please enter your name: ");
		String name = kbd.nextLine();
		kbd.close();
		System.out.println("\n\n");
		
		/* Randomly choose items from each List */
		Random rand = new Random();
		String firstHome = homeList.get(rand.nextInt(homeList.size()));	
		
		/* TODO: 11. Use rand object to select each of the following future 
		 * components from above lists. 
		 * */
		String secondHome = homeList.get(rand.nextInt(homeList.size()));
		String occupation = occupationList.get(rand.nextInt(occupationList.size()));
		String transportation = transportationList.get(rand.nextInt(transportationList.size()));
		String hometown = hometownList.get(rand.nextInt(hometownList.size()));
		
		/* TODO: 12. Use the coin to determine whether player's spouse is male or female, 
		 * then randomly select spouse from the cooresponding list.
		 */
		String spouse = "?";
		
		boolean coin = rand.nextBoolean();
		if (coin) {
			spouse = maleSpouseList.get(rand.nextInt(maleSpouseList.size()));
		} else {
			spouse = femaleSpouseList.get(rand.nextInt(femaleSpouseList.size()));
		}
		

		/* Randomly choose number of years player will be married */
		int yearsOfMarriage = rand.nextInt(30) + 1;


		/* Print the player's future*/
		System.out.println("Welcome "+ name + ", this is your future...");
		System.out.println("You will marry " + spouse + " and live in a " + firstHome + ".");
		System.out.println("After " + yearsOfMarriage + (yearsOfMarriage == 1?" year":" years") +" of marriage, you will finally get your dream job of being a " + occupation + ".");
		System.out.println("Your family will move to a " + secondHome + " in " + hometown + " where you will " + transportation + " to work each day.");











	}

}