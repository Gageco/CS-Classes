///*
// * @author Gage Coprivnicar for CS 121
// */
//
import java.util.Scanner;
import java.text.NumberFormat;

public class AdGenerator {
	public static void main(String[] args) {
		//Variable declaration
		final String Borders = "======================================";
		
		System.out.println("Welcome to AdGenerator!\n Please enter your profile information.");
		System.out.println(Borders);
		
		
		//User Input
		Scanner scan = new Scanner(System.in);
		
		System.out.print("First Name: ");
		String firstName = scan.nextLine();
		
		System.out.print("Middle Name: ");
		String middleName = scan.nextLine();
		
		System.out.print("LastName: ");
		String lastName = scan.nextLine();
		
		System.out.print("Job Title: ");
		String jobTitle = scan.nextLine();
	
		System.out.print("Phone Number (10 digit): ");
		String phoneNumber = scan.nextLine();
		
		System.out.print("Hourly Rate: ");
		double hourlyRate = scan.nextDouble();
		
		scan.close();
		
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		
		//Print it all out
		System.out.println("\n\n\n" + Borders);
		System.out.println("Need a " + jobTitle + "???");
		System.out.println("CALL NOW!!! (" + phoneNumber.substring(0,3) + ") " + phoneNumber.substring(3,6) + "-" + phoneNumber.substring(6,10));
		System.out.println("Ask For " + firstName + " " + middleName.charAt(0) + ". " + lastName);
		System.out.println("(Rates start at " + formatter.format(hourlyRate) + "/hour)");
		System.out.println(Borders);

	}
}

