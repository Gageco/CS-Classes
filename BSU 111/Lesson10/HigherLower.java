import java.util.Random;
import java.util.Scanner;

/**
 * Lesson 10: Activity - while Loops and Iterators 
 * 
 * @author Java Foundations
 * @author CS121 Instructors
 * @version Fall 2018
 */
public class HigherLower
{
	public static void main(String[] args)
	{
		final int MAX = 10;
		int answer;
		int guess;
		
		String wouldYouLikeToPlayAgain = "y";
		
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		
		
		

		while (wouldYouLikeToPlayAgain.equals("y")) {
			answer = random.nextInt(MAX) + 1;
			
			System.out.print("I'm thinking of a number between 1 and " + MAX + ". ");
			System.out.print("Guess what it is: ");
			
			guess = scan.nextInt();
			
			while (guess != answer) {
				
				if(guess == answer) {
					System.out.println("You got it! Good guessing! ");
				} else if (guess <= MAX && guess >= 1) {
					if (guess > answer) {
						System.out.printf("Close, guess a little lower! Guess Again: ");
						guess = scan.nextInt();
					} else if (guess < answer){
						System.out.printf("Close, guess a little higher! Guess Again: ");
						guess = scan.nextInt();
					} else {
						System.out.printf("Lol, you shouldn't be here, uh oh");
					}
				} else {
					System.out.printf("That number is out of range you silly goose. Try Again!: ");
					guess = scan.nextInt();
				}
			}
		
			System.out.println("Congrats, you got it!");
			System.out.println("Would you like to play again? (y/n): ");
			wouldYouLikeToPlayAgain = scan.next();
			
		}
		
		System.out.println("Thanks for playing!");
		scan.close();
	}
}