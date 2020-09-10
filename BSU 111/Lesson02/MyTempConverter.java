/**
 * A Java program to convert Celsius to Fahrenheit to learn about data types
 * @author Gageco
 *
 */
public class MyTempConverter {
	public static void main(String[] args) {
		//Variable declarations
		final double CONVERSION = 9.0 / 5.0;
		
		double fahrenheitTemp;
		
		//Celsius temp to convert
		int celsiusTemp = -40;
		
		fahrenheitTemp = (CONVERSION * celsiusTemp) + 32;
		
		System.out.println(celsiusTemp + "C is " + fahrenheitTemp + "F");
	}

}
