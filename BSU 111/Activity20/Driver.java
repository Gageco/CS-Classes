
public class Driver {
	public static void main(String[] args) {
		BubbleSorter bubbles= new BubbleSorter(12);
		
		System.out.println("Before Bubble Sort:\n" + bubbles.toString());
		
		bubbles.sort();
		
		System.out.println("After Bubble Sort:\n" + bubbles.toString());
	}
}
