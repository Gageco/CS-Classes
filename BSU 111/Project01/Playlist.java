import java.util.Scanner;
import java.text.DecimalFormat;

public class Playlist {
	public static void main(String[] args) {
		//Variables 
		String songTitle1;
		String songArtist1;
		String songAlbum1;
		String songLengthStr1;

		String songTitle2;
		String songArtist2;
		String songAlbum2;
		String songLengthStr2;
		
		String songTitle3;
		String songArtist3;
		String songAlbum3;
		String songLengthStr3;
		
		int songLength1;
		int songLength2;
		int songLength3;
		
		
		
		Scanner scan = new Scanner(System.in);
		
		//Song 1
		System.out.println("Song Deets Below (1/3):");
		System.out.print("Title: ");
		songTitle1 = scan.nextLine();
//		songTitle1 = "Disco Ulysses";
		
		System.out.print("Artist: ");
		songArtist1 = scan.nextLine();
//		songArtist1 = "Vulfpeck";
		
		System.out.print("Album: ");
		songAlbum1 = scan.nextLine();
//		songAlbum1 = "Hill Cimbers";
		
		System.out.print("Length (mm:ss): ");
		songLengthStr1 = scan.nextLine();
//		songLengthStr1 = "1:30";
		songLength1 = TimeConvert(songLengthStr1);
		
		Song song1 = new Song(songTitle1, songArtist1, songAlbum1, songLength1);
//		System.out.println(song1);
		
		//Song 2
		System.out.println("Song Deets Below (2/3):");
		System.out.print("Title: ");
		songTitle2 = scan.nextLine();
//		songTitle2 = "Dean Town";
		
		System.out.print("Artist: ");
		songArtist2 = scan.nextLine();
//		songArtist2 = "Vulfpeck";
		
		System.out.print("Album: ");
		songAlbum2 = scan.nextLine();
//		songAlbum2 = "Thrill of the Arts";
		
		System.out.print("Length (mm:ss): ");
		songLengthStr2 = scan.nextLine();
//		songLengthStr2 = "4:10";
		songLength2 = TimeConvert(songLengthStr2);
		
		Song song2 = new Song(songTitle2, songArtist2, songAlbum2, songLength2);
//		System.out.println(song2);
		
		//Song 3
		System.out.println("Song Deets Below (3/3):");
		System.out.print("Title: ");
		songTitle3 = scan.nextLine();
//		songTitle3 = "Tom Boy";
		
		System.out.print("Artist: ");
		songArtist3 = scan.nextLine();
//		songArtist3 = "Vulfpeck";
		
		System.out.print("Album: ");
		songAlbum3 = scan.nextLine();
//		songAlbum3 = "Mit Peck";
		
		System.out.print("Length (mm:ss): ");
		songLengthStr3 = scan.nextLine();
//		songLengthStr3 = "3:30";
		songLength3 = TimeConvert(songLengthStr3);
	
		Song song3 = new Song(songTitle3, songArtist3, songAlbum3, songLength3);
//		System.out.println(song3);
		scan.close();
		
		//Calculate Average Play Time
		DecimalFormat df = new DecimalFormat("#.00");
		double calculatedAvgLength = AverageLength(song1.getPlayTime(), song2.getPlayTime(), song3.getPlayTime());
		System.out.println("\nThe Average Song Length Is: " + df.format(calculatedAvgLength) + "s");
		
		//Calculate Song Closest to Four Minutes
		String closestFourMinSong = FourMinSong(song1, song2, song3);
		System.out.println("The Song Closest To Four Minutes is " + closestFourMinSong);
		
		//Sorting By Shortest
		String shortestSong = ShortestSong(song1, song2, song3).toString();
		String middlestSong = MiddlestSong(song1, song2, song3).toString();
		String longestSong  =  LongestSong(song1, song2, song3).toString();
		
		int formatLength = song1.toString().length();
		for (int i = 0; i < formatLength; i++) {
			System.out.print("=");
		}
		System.out.println("\nTitle                          Artist               Album                      Play Time");
		for (int i = 0; i < formatLength; i++) {
			System.out.print("=");
		}
		
		System.out.println("\n" + shortestSong);
		System.out.println(middlestSong);
		System.out.println(longestSong);
		
		for (int i = 0; i < formatLength; i++) {
			System.out.print("=");
		}
		
		
	}
	
	private static Song ShortestSong (Song song1, Song song2, Song song3) {
		Song shortestSong = new Song ("", "", "", 0);
		
		int shortestLength = Math.min(song1.getPlayTime(), Math.min(song2.getPlayTime(), song3.getPlayTime()));
		
		if (shortestLength == song1.getPlayTime()) {
			return song1;
		} else if (shortestLength == song2.getPlayTime()) {
			return song2;
		} else if (shortestLength == song3.getPlayTime()) {
			return song3;
		} else {
			return shortestSong;
		}
		
	}
	
	private static Song MiddlestSong (Song song1, Song song2, Song song3) {		
		int s1 = song1.getPlayTime();
		int s2 = song2.getPlayTime();
		int s3 = song3.getPlayTime();
		
		if ((s1 < s2 && s2 < s3) || (s3 < s2 && s2 < s1)) {
			return song2;
		} else if ((s2 < s1 && s1 < s3) || (s2 < s1 && s1 < s3)) {
			return song1;
		} else {
			return song3;
		}
	}
	
	private static Song LongestSong (Song song1, Song song2, Song song3) {
		Song longestSong = new Song ("", "", "", 0);
		
		int longestLength = Math.max(song1.getPlayTime(), Math.max(song2.getPlayTime(), song3.getPlayTime()));
		
		if (longestLength == song1.getPlayTime()) {
			return song1;
		} else if (longestLength == song2.getPlayTime()) {
			return song2;
		} else if (longestLength == song3.getPlayTime()) {
			return song3;
		} else {
			return longestSong;
		}
	}
	
	private static String FourMinSong(Song song1, Song song2, Song song3) {
		int fourMinutesInSeconds = 240;
		
		int song1Abs = Math.abs((fourMinutesInSeconds) - song1.getPlayTime());
		int song2Abs = Math.abs((fourMinutesInSeconds) - song2.getPlayTime());
		int song3Abs = Math.abs((fourMinutesInSeconds) - song3.getPlayTime());
		
		int smallestDiff = Math.min(song1Abs, Math.min(song2Abs, song3Abs));
		
		if (smallestDiff == song1Abs) {
			return song1.getTitle();
		} else if (smallestDiff == song2Abs) {
			return song2.getTitle();
		} else if (smallestDiff == song3Abs) {
			return song3.getTitle();
		}
		
		
		return "ERROR";
	}
	
	private static double AverageLength(int song1, int song2, int song3) {
		double avgLength = 0.0;
		
		avgLength = (song1 + song2 + song3) / 3;
		
		return avgLength;
	}
	
	private static int TimeConvert(String time) {
		int timeInSec = 0;
		String minute = "";
		String second = "";
//		System.out.println("LEN" + time.length());
		
		int local = time.indexOf(":");
		
		minute = time.substring(0, local);
		second = time.substring(local+1, time.length());

//		System.out.println("SEC" + second);
//		System.out.println("MIN" + minute);
		
		int timeSecond = Integer.parseInt(second);
		int timeMinute = Integer.parseInt(minute) * 60;
		
		timeInSec = timeSecond + timeMinute;
		
		return timeInSec;
	}
	
}
