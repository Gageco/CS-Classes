import java.io.File;

//@GageCoprivnicar

import java.io.FileNotFoundException;
import java.util.Scanner;

//@GageCoprivnicar


public class Book implements BookInterface {
	private String title;
	private String author;
	private String genre;
	private String filename;
	
	
	//Base Initializer
	public Book() {
		this.title = null;
		this.author = null;
		this.genre = null;
		this.filename = null;
	}
	
	//Var Initializer
	public Book(String title, String author, String genre, String filename) {
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.filename = filename;
	}
	
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
		this.genre = null;
		this.filename = null;
	}
	
	
	
	
	/////////////////////////////////////////////
	////////////////////////////////////////////
	///////////////////////////////////////////
	//Get Set Title
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	//Get Set Author
	public String getAuthor() {
		return this.author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	//Get Set Genre
	public String getGenre() {
		return this.genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
	//Get Set Filename
	public String getFilename() {
		return this.filename;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
	
	
	/////////////////////////////////////////////
	////////////////////////////////////////////
	///////////////////////////////////////////
	public String toString() {
		return "Book: " + this.title + "    Author: " + this.author + "    Genre: " + this.genre + "    Filename: " + this.filename;
	}
	
	
	
	
	/////////////////////////////////////////////
	////////////////////////////////////////////
	///////////////////////////////////////////
	public boolean isValid() {
		if (this.title != null && this.author != null && this.genre != null && this.filename != null) {
			File file = new File(this.filename);
			if (file.exists() && file.isFile() ) {
				return true;
			} else {
				return false;
			}
			
		} else {
			return false;
		}
	}
	
	
	
	
	/////////////////////////////////////////////
	////////////////////////////////////////////
	///////////////////////////////////////////
	public String getText() {
		String totalText = "";
		File file = new File(this.filename);
		Scanner readText;
		try {
			readText = new Scanner(file);
			
			if(file.exists() && file.isFile()) {
				while (readText.hasNext()) {
					totalText += readText.nextLine() + "\n";
				}
			}
			
		} catch (FileNotFoundException e) {
			return "File is not able to be opened";
		}
		
		return totalText;
	}
}











