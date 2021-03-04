import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//@GageCoprivnicar


public class Library implements LibraryInterface {
	public ArrayList<Book> books;
	
	public Library() {
		this.books = new ArrayList<Book>();
	}
	
	
	
	
	/////////////////////////////////////////////
	//Visual Separation For My Sake/////////////
	///////////////////////////////////////////
	public ArrayList<Book> getBooks() {
		ArrayList<Book> tempBook = new ArrayList<Book>(this.books);
		return tempBook;
	}
	
	//AddBook
	public void addBook(Book newBook) {
		this.books.add(newBook);
	}
	
	//toString
	public String toString() {
		String finalString = "Library:\n-------------------------------\n";
		for (int i = 0; i < this.books.size(); i++) {
			finalString += "(" + i + ") " + this.books.get(i).toString() + "\n";
			}
		
		return finalString;
	}
	
	//removeBook
	public void removeBook(int remove) {
		
		if (!(remove < 0 || this.books.size() <= remove)) {
			this.books.remove(remove);
		} 
		
	}
	
	//getBook
	public Book getBook(int get) {
		
		if (get < 0 || this.books.size() <= get) {
			return null;
		} 
		return this.books.get(get);
	}

	@Override
	//loadLibraryFromCSV, create a book, add to this.books
	public void loadLibraryFromCSV(String csvFilename) {
		int i = 0;
				
		/////////////////////
		//Print Output Here/
		///////////////////
		File file = new File(csvFilename);
//		File file = new File("etext/booklist-full.csv");
		books.clear();
		Scanner csvFileScan = null;
		
		try {
			csvFileScan = new Scanner(file);
		} catch (FileNotFoundException e) {
			/////////////////////
			//Print Output Here/
			///////////////////
			System.out.println("Booklist File Not Found");
		}
		
		while (csvFileScan.hasNext()) {
			i++;
			csvFileScan.useDelimiter(",");
			
			String title = csvFileScan.next();
			String author= csvFileScan.next();
			String genre = csvFileScan.next();
			
			csvFileScan.useDelimiter("\n");
			String filepath = csvFileScan.next();
			filepath = filepath.replace(",","");
//			/////////////////////
//			//Print Output Here/
//			///////////////////
			System.out.println("filepath: " + filepath);
			
			Book newBook = new Book(title, author, genre, filepath);
			this.books.add(newBook);
//			/////////////////////
//			//Print Output Here/
//			///////////////////
//			System.out.println(newBook.toString() + " Loaded From File");
			
		}
		/////////////////////
		//Print Output Here/
		///////////////////
		System.out.println("Loaded " + i + " books from file");
	}
	
	
	
	
}
