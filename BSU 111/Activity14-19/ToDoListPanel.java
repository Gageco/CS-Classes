import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ToDoListPanel extends JPanel {
	
	ToDoList list = new ToDoList();

	ToDoListPanel(String name) {
		this.list.setName(name);
		
		
		
		JLabel panelName = new JLabel(this.list.getName());
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.add(panelName); 
	}
	
	ToDoListPanel() {
		
	}
	
//	public String getNextWork() {
//		return this.list.getWork().getDescription();
//	}
	
	public void addTask(Task t) {
		list.addTask(t);	
		
		TaskButton newTask = new TaskButton(t);
		
//		BoxLayout layout = new BoxLayout(newTask, BoxLayout.Y_AXIS);
//		newTask.setLayout(layout);
		this.add(newTask);
		revalidate();
	}


}

  