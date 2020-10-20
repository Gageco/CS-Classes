/**
 * Lesson 13: Activity - Gradebook
 *
 * @author GageCoprivnicar
 * @version Fall 2020
 */

public class Task implements Comparable<Task> {
	private String description;
	private int priority;
	private boolean completed;


	/**
	 * Create a new Task object
	 * @param description - description of Task
	 * @param priority - relative importance of Task
	 * @param completed - if Task has been completed
	 */
	public Task(String description, int priority) {
		this.description = description;
		this.priority = priority;
		this.completed = false;
	}

	public Task(String description) {
		this.description = description;
		this.priority = 0;
		this.completed = false;
	}

	// String of the task, with completed status
public String toString() {
	if (completed) {
		return "[x] " + description + ", " + priority;
	} else {
		return "[ ] " + description + ", " + priority;
		}
	}


	// Get/Set the description
	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}


	//Get/Set the priority
	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getPriority() {
		return this.priority;
	}

	//Get/Set Completed
	public boolean isCompleted() {
		if (this.completed) {
			return true;
		} else {
			return false;
		}
	}

	public void setCompleted(boolean complete) {
		this.completed = complete;
	}


	//Misc Public functions (Assignment 15 Below)

	//check if description is equal to another
	public boolean equals(String comparableTask) {
		if (this.description.equalsIgnoreCase(comparableTask)) {
			return true;
		} else {
			return false;
		}
	}

	//compare tasks
	public int compareTo(Task that) {
		//Used https://www.dreamincode.net/forums/topic/163624-is-not-abstract-and-does-not-override-abstract-method-compareto/
		// System.out.println(that.getPriority() + " " + this.isCompleted());
		// if the same priority, returns 0, if this < that, returns -1, if this > that, returns 1
		if (this.isCompleted() == that.isCompleted()) {
			if (this.getPriority() == that.getPriority()) {
				return 0;
			} else if (this.getPriority() < that.getPriority()) {
				 return -1;
			} else {
				return 1;
			}
		} else if (this.isCompleted()) {
			return -1;
		} else {
			return 1;
		}



	}

}
