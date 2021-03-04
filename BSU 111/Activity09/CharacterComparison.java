/**
 * Lesson 9: Activity
 * 
 * @author CS121 Instructors
 * @version Fall 2018
 */
public class CharacterComparison
{
	public static void main(String[] args)
	{
		String word = "/urple";
		char firstLetter = word.charAt(0);
		int asciiValue =  (int)firstLetter;
		
		//2) The value of firstLetter is p, and the asciiValue is 112
		System.out.println("The ascii value of " + firstLetter + " is " + asciiValue);
		
		if(firstLetter >= 'a' && firstLetter <= 'z')
		{
			System.out.println("It is a lower case letter");
		}
		else if(firstLetter >= 'A' && firstLetter <= 'Z')
		{
			System.out.println("It is an upper case letter");
		}
		else
		{
			System.out.println("It is a number");
		}
	}
} //When putting in an uppercase letter the program goes into the else if statement only. I also put in a '/' to see what would happen and the program identified it as a number. By comparing the ascii value of the letter to the actual letter it figures out what kind of character it is