import javax.swing.JPanel;
import java.awt.Dimension;

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
public class TaskMasterPanel extends JPanel
{
	/**
	 * Creates a new TaskMasterPanel.
	 */
	public TaskMasterPanel()
	{
		this.setPreferredSize(new Dimension(500, 400));
		Task newTask = new Task("Give Gunther A Bath", "NONE", 10);
		TaskButton button = new TaskButton(newTask);
		// frame.add(button);
	}
}
