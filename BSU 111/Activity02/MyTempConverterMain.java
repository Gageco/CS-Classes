import java.awt.Color;
import java.util.ArrayList;

public class MyTempConverterMain {
	public static void main(String[] args) {
		MyTempConverter temp = new MyTempConverter(3,3);
		ArrayList<Color> neigh = temp.getNeighbors(1,1);
		System.out.println(neigh);
	}
}
