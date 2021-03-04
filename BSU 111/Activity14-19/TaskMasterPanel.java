import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Lesson 18-19: Activity - Task Master GUI
 *
 * This class represents the main TaskMaster JPanel.
 *
 * It contains a ToDoListPanel and the control sub-panel.
 *
 * @author CS121 Instructors
 * @version [semester]
 * @author [your name]
 */
@SuppressWarnings("serial")
public class TaskMasterPanel extends JPanel {
	
	ToDoListPanel listPanel = new ToDoListPanel("Main List");
	JTextField descriptionField = new JTextField(15);
	/**
	 * Creates a new TaskMasterPanel.
	 */
	public TaskMasterPanel() {
		this.setPreferredSize(new Dimension(500, 400));
	    setLayout(new BorderLayout());
	    
//		ToDoListPanel listPanel = new ToDoListPanel("Main List");
		add(listPanel, BorderLayout.CENTER);
	
		listPanel.addTask(new Task("Give Gunther a Bath", "NONE", 10));
		listPanel.addTask(new Task("Give Opal a Bath", "PERSONAL", 9));
		listPanel.addTask(new Task("Take a shower myself", "WORK", 8));	
		
		JPanel controlPanel = new JPanel();
		add(controlPanel, BorderLayout.SOUTH);
		
		JButton getWorkButton = new JButton("Get Work");
		getWorkButton.addActionListener(new GetWorkButtonListener());
		
		JButton addTaskButton = new JButton("Add Task");
		addTaskButton.addActionListener(new AddTaskButtonListener());
		
//		JTextField descriptionField = new JTextField(15);
		descriptionField.addActionListener(new AddTaskButtonListener());
		
		controlPanel.add(descriptionField);
		controlPanel.add(getWorkButton);
		controlPanel.add(addTaskButton);
		
		JScrollPane toDoListScrollPane = new JScrollPane(listPanel);
		toDoListScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		toDoListScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(toDoListScrollPane, BorderLayout.CENTER);
	}
	
	private class AddTaskButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String taskName = TaskMasterPanel.this.descriptionField.getText();
			
			TaskMasterPanel.this.listPanel.addTask(new Task(taskName));
			
		}
		
	}
	
	
	private class GetWorkButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String showText = new String();
			String findString = TaskMasterPanel.this.listPanel.list.getWork().getDescription();
			
			if (findString.equals("null")) {
				showText = "You've done all the work you had to do! Congrats!";
			} else {
				showText = "You Should " + findString + " next!";
			}
			
		    JOptionPane.showMessageDialog(null, showText); 
		}
	}
	
	public void showWorkDialog() {
			
	}
}
