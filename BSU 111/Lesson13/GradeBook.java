import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Lesson 13: Activity - GradeBook
 *
 * @author CS121 Instructors
 * @version Fall2020
 * @author Gage
 */
public class GradeBook {

	public static void main(String[] args) throws FileNotFoundException {

		/* TODO: 1. Create a new ArrayList of Student objects called gradebook. */
		ArrayList<Student> gradebook = new ArrayList<Student>();

		/* TODO: 2. Create a new File object for gradebook.csv and
		 * a new Scanner object to parse it. Catch any required
		 * exceptions and display a useful message to the user.
		 */
		File file = new File("gradebook.csv");
		Scanner fileScan = new Scanner(file);


		if(file.exists() && file.isFile()) {
			try {
				fileScan = new Scanner(file);
			} catch (FileNotFoundException e) {
				System.out.println("Sorry, the file wasn't found. May the name is wrong?");
			}
		} else {
			System.out.println("Not a valid file, sorry.");
		}



			/* TODO: 3. Use a while loop and the Scanner created above to iterate
			 * through the lines in the gradebook.csv file.
			 */
		while (fileScan.hasNextLine()) {
			String studentLine = fileScan.nextLine();

			/* TODO: 4. For each line (student record), use a second
			 * Scanner object to tokenize the line using a comma (',')
			 * as the delimiter, extract values for lastName, firstName,
			 * id and grade and store them to local variables.
		 	 */


			int firstComma = studentLine.indexOf(",");
			String studentLastName = studentLine.substring(0,firstComma);
			String remainingStudentInfo = studentLine.substring(firstComma+1, studentLine.length());

			firstComma = remainingStudentInfo.indexOf(",");
			String studentFirstName = remainingStudentInfo.substring(0, firstComma);
			remainingStudentInfo = remainingStudentInfo.substring(firstComma+1, remainingStudentInfo.length());

			firstComma = remainingStudentInfo.indexOf(",");
			String studentID= remainingStudentInfo.substring(0, firstComma);
			remainingStudentInfo = remainingStudentInfo.substring(firstComma+1, remainingStudentInfo.length());

			String studentGrade= remainingStudentInfo.substring(0, remainingStudentInfo.length());

//			System.out.println(studentLastName);
//			System.out.println(studentFirstName);
//			System.out.println(studentID);
//			System.out.println(studentGrade);


		 	/* TODO: 5. Create a new Student object using the local variables
		 	 * create above, set the student's grade, and finally add the
		 	 * new Student object to the gradebook ArrayList.
			 */
			Student studInfo = new Student(studentFirstName, studentLastName, Integer.parseInt(studentID));
			studInfo.setGrade(Integer.parseInt(studentGrade));
			gradebook.add(studInfo);


		}

		for (int i = 0; i < gradebook.size(); i++) {
			System.out.println(gradebook.get(i).getFirstName() + " " + gradebook.get(i).getLastName() + " has a " + NumberToLetterGrade(gradebook.get(i).getGrade()) + ".");
		}


		fileScan.close();
	}

	private static String NumberToLetterGrade(int numberGrade) {
		if (numberGrade < 60) {
			return "F";
		} else if (numberGrade >= 60 && numberGrade < 70) {
			return "D";
		} else if (numberGrade >= 70 && numberGrade < 80) {
			return "C";
		} else if (numberGrade >= 80 && numberGrade < 90) {
			return "B";
		}
		else {
			return "A";
		}
	}



































}
