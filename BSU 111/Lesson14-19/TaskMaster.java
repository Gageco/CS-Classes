import java.util.*;

public class TaskMaster {
	public static void main(String[] args) {
		// //JUNK TO DELETE
		// ToDoList todo1 = new ToDoList("Second List");
		//
		// System.out.println(todo1.getWork().toString());
		//
		// //END JUNK TO DELETE



	//Task 1 Stuff
	Task task1 = new Task("Finish Activity 14");

	// System.out.println("Task 1\n" + task1.toString());

	task1.setCompleted(true);

	// System.out.println("Task 1 is completed: " + task1.isCompleted());
	// System.out.println(task1.toString() + "\n");


	//Task 2 Stuff
Task task2 = new Task("Give Gunther a Bath", "NONE", 10);

// System.out.println("Task 2\n" + task2.toString());

task2.setPriority(20);

// System.out.println("Task 2 Priority: " + task2.getPriority());
// System.out.println(task2.toString());


//Assignment 15 Stuff Below
//Task 3 Stuff
Task task3 = new Task("Finish Activity 14");

// boolean theSameTaskDesc = task1.equals(task3.getDescription());
// if (theSameTaskDesc) {
// 	System.out.println("\nTask 1 & Task 3 are the same");
// 	task3 = task1;
// } else {
// 	System.out.println("\nTask 1 & Task 3 are different");
// }

//Checking if equal
// System.out.println("\nComparing Task 1 & Task 3...");
// if (task1.compareTo(task3) == 0) {
// 	System.out.println("Task 1 & Task 3 Are The Same Priority");
// } else {
// 	System.out.println("Task 1 & Task 3 Are Different Priorities");
// }
//
// System.out.println("\nComparing Task 1 & Task 2...");
// if (task1.compareTo(task2) < 0) {
// 	System.out.println("Task 1 Is Less Important Then Task 2");
// }

//Assignment 16 Stuff Below
task3.setDescription("Keep the lawn green");
task3.setCompleted(true);
task1.setPriority(21);

task1.setCategory("WORK");
task2.setCategory("PERSONAL");

ToDoList todo = new ToDoList("Main To Do List");
todo.addTask(task1);
todo.addTask(task2);
todo.addTask(task3);

todo.addTask("Open up the music market");

System.out.println(todo.toString());


System.out.println(todo.getWork().toString());

	}
}
