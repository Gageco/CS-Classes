/**
 * Convert seconds to Hours, Min, Seconds based on user input
 * @author Gageco
 *
 */
import java.util.Scanner; //Import Scanner

public class ConvertToHMS {
	public static void main(String[] args) {
		//Take User Input
		Scanner rawSeconds = new Scanner(System.in);
		System.out.print("Input Number of Seconds to Convert: ");
		int processedSeconds = Integer.parseInt(rawSeconds.nextLine());
		rawSeconds.close();
		
		
		//Variables
		int hour = 0, minute = 0;
		final int inputSec = processedSeconds;
		
		//Parse Hours from processedSeconds
		if (processedSeconds >= 3600) {
			for (int i = 0; processedSeconds > 3600; i++) {
				processedSeconds -= 3600;
				hour = i+1;
			}
		}
		
		
		//Parse Minutes from processedSeconds
		if (processedSeconds >= 60) {
			for (int i = 0; processedSeconds > 60; i++) {
				processedSeconds -= 60;
				minute = i+1;
				//System.out.println("Min, secRemain " + minute + ", " + processedSeconds);
			}
		} 
		
		if (inputSec < 60) {
			processedSeconds = inputSec;
		} 
		;
		System.out.println(inputSec + " seconds is: " + hour + " hour(s), " + minute + " minute(s), and " + processedSeconds + " second(s)!");
		
		
	}

}
