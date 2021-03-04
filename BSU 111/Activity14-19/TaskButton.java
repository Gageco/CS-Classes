import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class TaskButton extends JButton {
  private Task task;

  public TaskButton(Task task) {
    this.task = task;
    this.setText(task.toString());  
    
    this.addActionListener(new TaskButtonListener());
  
  
  }

  
  private class TaskButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (TaskButton.this.task.isCompleted()) {
			TaskButton.this.setForeground(Color.BLACK);
			TaskButton.this.task.setCompleted(false);
		} else {
			TaskButton.this.setForeground(Color.GRAY);
			TaskButton.this.task.setCompleted(true);
		}	
	    TaskButton.this.setText(task.toString());  

//		System.out.println("clicked");
	}
  }
}
