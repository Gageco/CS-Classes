import java.util.Scanner;

//@GageCoprivnicar

public class LibraryOfBooks {
	public static void main(String[] args) {
		
		Library libOfBooks = new Library();
		
		boolean continueLoop = true;
		
		while (continueLoop) {
			System.out.println(
					"\n\n\n*****************************\r\n" + 
					"*      Library Menu         *\r\n" + 
					"*****************************\r"
					);
			
			Scanner userChoiceScan = new Scanner(System.in);
			System.out.print(
					"(P)rint Library\r\n" + 
					"(A)dd Book\r\n" + 
					"(D)elete Book\r\n" + 
					"(R)ead A Book\r\n" + 
					"(Q)uit\r\n" + 
					"\r\n" + 
					"Please enter a command (press 'm' for Menu): ");
			
			
			String userChoice = userChoiceScan.nextLine();
			
			//Print Library
			if (userChoice.toLowerCase().equals("p")) {
				System.out.println(libOfBooks.toString());
				
				
			//Add Book
			} else if (userChoice.toLowerCase().equals("a")) {
				Book newBook = new Book();
				
				System.out.print("What is the title of the book you want to add?: ");
				newBook.setTitle(userChoiceScan.nextLine());
				
				System.out.print("Who is the author?: ");
				newBook.setAuthor(userChoiceScan.nextLine());
				
				System.out.print("What is the genre?: ");
				newBook.setGenre(userChoiceScan.nextLine());
				
				System.out.print("What is the filename?: ");
				newBook.setFilename(userChoiceScan.nextLine());
//				newBook.setFilename("Alice-in-Wonderland.txt");
//				System.out.println(newBook.toString());
				
				libOfBooks.addBook(newBook);
				
				
				
			//Delete Book
			} else if (userChoice.toLowerCase().equals("d")) {
				System.out.print("What's the index of the book you'd like to delete from your library?: ");
				String deleteChoice = userChoiceScan.nextLine();
				
				libOfBooks.removeBook(Integer.parseInt(deleteChoice));
				
				
			//Read Book
			} else if (userChoice.toLowerCase().equals("r")) {
				System.out.print("What's the index of the book you'd like to read from your library?: ");
				String printChoice = userChoiceScan.nextLine();
				Book tempBook = libOfBooks.getBook(Integer.parseInt(printChoice));
				System.out.println(tempBook.getText());
				
				
			//Quit
			} else if (userChoice.toLowerCase().equals("q")) {
				System.out.println("Thanks for using our automagical library system!");
				continueLoop = false;
				
				
				
			} else {
				
			}
			
		}
	}
}
