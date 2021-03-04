import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class JukeboxHero {
	public static void main(String[] args) throws FileNotFoundException {

		boolean continueProgram = true;
		
		System.out.println("*****************************\r\n" + 
				"*      Program Menu         *\r\n" + 
				"*****************************\r");
		
		System.out.print("(L)oad catalog\r\n" + 
				"(S)earch catalog\r\n" + 
				"(A)nalyse catalog\r\n" + 
				"(P)rint catalog\r\n" + 
				"(Q)uit\r\n" + 
				"\r\n");
		
		ArrayList<Song> songCatalog = new ArrayList<Song>();
		
		Scanner userChoiceScan = new Scanner(System.in);
		
		while (continueProgram) {
//			System.out.println("*****************************\r\n" + 
//					"*      Program Menu         *\r\n" + 
//					"*****************************\r");
//			
			System.out.print("Please enter a command (press 'm' for Menu): ");
//			
			

			String userChoice = userChoiceScan.nextLine();
			
			
			//Load Catalog
			if (userChoice.toLowerCase().equals("l")) {
				songCatalog = LoadCatalog();
			
			//Search Catalog
			} else if (userChoice.toLowerCase().equals("s")) {
				System.out.println(SearchCatalog(songCatalog));
				
			//Analyze Catalog
			} else if (userChoice.toLowerCase().equals("a")) {
				System.out.println(AnalyzeCatalog(songCatalog));	
				
			//Print Catalog
			} else if (userChoice.toLowerCase().equals("p")) {
//				System.out.println(songCatalog);
				System.out.println(PrintCatalog(songCatalog));
				
			//Quit Program
			} else if (userChoice.toLowerCase().equals("q")) {
				System.out.println("Thanks for using The Jukebox!\n\n\n");
				continueProgram = false;	
				
				
			}  else if (userChoice.toLowerCase().equals("m")) {
				System.out.println("*****************************\r\n" + 
						"*      Program Menu         *\r\n" + 
						"*****************************\r");
				
				System.out.print("(L)oad catalog\r\n" + 
						"(S)earch catalog\r\n" + 
						"(A)nalyse catalog\r\n" + 
						"(P)rint catalog\r\n" + 
						"(Q)uit\r\n" + 
						"\r\n" + 
						"Please enter a command (press 'm' for Menu): ");	
				
				
			} else {
				System.out.println("Not Valid");
			}
				
			
			
			
			
		}
	}
	
private static String SearchCatalog(ArrayList<Song> songList) {
	String finalString = "";
	String songString = "";
	int songsFound = 0;
	
	Scanner fileNameScan = new Scanner(System.in);
	System.out.print("Search Query: ");
//	String searchQuery =  "refugee";
	String searchQuery = fileNameScan.nextLine().toLowerCase();
	
	for (int i = 0; i < songList.size(); i++) {
		String songName = songList.get(i).getTitle().toLowerCase();
		
		if (songName.contains(searchQuery)) {
			songString += songList.get(i).toString() + "\n";
			songsFound += 1;
		}
	}
	
	finalString = "Found " + Integer.toString(songsFound) + " matches\n------------------------------\n";
	finalString += songString;
	
	return finalString;
}

private static String AnalyzeCatalog(ArrayList<Song> songList) {
	String finalString = "";
	
	ArrayList<String> artistList = new ArrayList<String>();
	ArrayList<String> albumList = new ArrayList<String>();
	int totalSongLength = 0;
	
	for (int i = 0; i < songList.size(); i++) {
		
		String songArtist = songList.get(i).getArtist();
		String songAlbum = songList.get(i).getAlbum();
		
		if (!artistList.contains(songArtist)) {
			artistList.add(songArtist);
		}
		
		if (!albumList.contains(songAlbum)) {
			albumList.add(songAlbum);
		}
		
		totalSongLength += songList.get(i).getPlayTime();
	}
	
	finalString = "\n\n\nCatalog Analysis: \n" + "--------------------\n" + "Number of Artists: " + Integer.toString(artistList.size()) + "\nNumber of Albums: " + Integer.toString(albumList.size()) + "\nNumber of Songs: " + songList.size() + "\nTotal Playtime: " + Integer.toString(totalSongLength) + "s econds";
	
	return finalString;
	
}
	
	
private static String PrintCatalog(ArrayList<Song> songList) {
	String songString = "Song List Contains " + songList.size() + " songs\n-----------------------------\n";
	
	for (int i = 0; i < songList.size(); i++) {
		songString += songList.get(i).toString() + "\n";
	}
	
	
	return songString;
}

private static ArrayList<Song> LoadCatalog() throws FileNotFoundException {
	ArrayList<Song> songList = new ArrayList<Song>();
	Scanner fileNameScan = new Scanner(System.in);
	System.out.print("File Name: ");
	String fileName = fileNameScan.nextLine();
//	String fileName = "music-collection.csv";

	File file = new File(fileName);	
	
	int i = 0;

			if(file.exists() && file.isFile()) {
				System.out.println("");
			} else {
				System.out.println("Sorry, the file wasn't found. May the name is wrong?\n\n\n");
				return songList;
			}

	
	Scanner fileScan = new Scanner(file);
	
	while (fileScan.hasNext()) {
		i++;
		fileScan.useDelimiter(",");
		String artist = fileScan.next();
		String album = fileScan.next();
		String name = fileScan.next();
		
		fileScan.useDelimiter("\n");
		String length = fileScan.next();
		length = length.replace(",","");

//		System.out.println(length);
		Song newSong = new Song(name, artist, album, Integer.parseInt(length));
		songList.add(newSong);
		fileScan.nextLine();
	}
	
	System.out.println("\n\n\nSuccessfully loaded " + i +  " songs from the file!");

	return songList;
}
}




