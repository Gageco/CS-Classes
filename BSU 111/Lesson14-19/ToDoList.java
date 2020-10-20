import java.util.*;
/**
 * Lesson 13: Activity - Gradebook
 *
 * @author GageCoprivnicar
 * @version Fall 2020
 */

public class ToDoList implements ToDoListInterface {
	private String name;
	private ArrayList<Task> tasks = new ArrayList<Task>();

			//INIT FOR ToDoList
	public ToDoList(String name) {
		this.name = name;
	}

	public ToDoList(String name, Task t) {
		this.name = name;
		this.tasks.add(t);
	}


			//GET FUNCTIONS
	public String getName() {
		return this.name;
	}

	public Task getWork() {

		if (this.tasks.isEmpty()) {
			Task temp = new Task("null");
    	return temp;
		}

		//Source Stuff
		//- https://stackoverflow.com/questions/1938101/how-to-initialize-an-array-in-java
		//- https://www.geeksforgeeks.org/java-program-for-program-to-find-largest-element-in-an-array/
		//- https://www.geeksforgeeks.org/arraylist-isempty-java-example/
		// ArrayList<int> compareArray = new ArrayList<int>;;
		int[] compareArray = new int[this.tasks.size()];

		for (int i = 0; i < this.tasks.size(); i++) {
			compareArray[i] = 0;
			for (int j = 0; j < this.tasks.size(); j++ ) {
				compareArray[i] += this.tasks.get(i).compareTo(this.tasks.get(j));
			}
		}

		// System.out.println("CompareArray:");
		// for (int i = 0; i < compareArray.length; i++) {
		// 	System.out.print(compareArray[i]+", ");
		// }
		int maxArrayIndex = 0;
		int maxArrayMath = compareArray[0];
		for (int i = 0; i < compareArray.length; i++) {
			if (compareArray[i] > maxArrayMath) {
				maxArrayMath = compareArray[i];
				maxArrayIndex = i;
			}
		}

		// System.out.println("\n\n");


		return this.tasks.get(maxArrayIndex);
	}

	public ArrayList<Task> getTaskList() {
		ArrayList<Task> hold = new ArrayList<Task>();
		hold = tasks;
		return hold;
	}

			//ADD FUNCTIONS
	public void addTask(Task t) {
		this.tasks.add(t);
	}

	public void addTask(String desc) {
		Task temp = new Task(desc);
		this.tasks.add(temp);
	}

	public String toString() {
		String header = "-------------\n" + this.name + "\n-------------\n";

		for (int i = 0; i < this.tasks.size(); i++) {
			header += this.tasks.get(i).toString() + "\n";
		}

		return header;

	}
}
