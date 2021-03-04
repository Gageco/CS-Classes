import java.util.Random;

public class BubbleSorter {	
	int[] bubbleArray;
	
	public BubbleSorter(int size) {
		bubbleArray = new int[size];
		
		Random rand = new Random();
		
		for (int i = 0; i < bubbleArray.length; i++) {
			bubbleArray[i] = rand.nextInt(21);	
		}
		
	}
	
	@Override
	public String toString() {
//		System.out.println(this.bubbleArray.length);
		String retString = new String();
		retString += "[";
		for (int i = 0; i < this.bubbleArray.length; i++) {
			if (i != this.bubbleArray.length-1) {
				retString += this.bubbleArray[i] + ", ";
			} else {
				retString += this.bubbleArray[i];
			}
			
		}
		retString += "]";
		
		return retString;
	}
	
	public void sort() {
		boolean done = false;
		
		while (!done) {
			done = true;
			for (int i = 1; i < this.bubbleArray.length; i++) {
				if(this.bubbleArray[i-1] > this.bubbleArray[i]) {
					swap(i-1, i);
					done = false;
				}
			}
		}
	}
	
	private void swap(int tic, int tak) {
		int holder = this.bubbleArray[tic];
//		System.out.println("Tic Location, Value: " + tic + ", " + this.bubbleArray[tic]);
//		System.out.println("Tak Location, Value: " + tak + ", " + this.bubbleArray[tak]);
		this.bubbleArray[tic] = this.bubbleArray[tak];
		this.bubbleArray[tak] = holder;
		
	}
	
}
