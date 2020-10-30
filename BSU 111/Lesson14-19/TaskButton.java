import javax.swing.JButton;


public class TaskButton extends JButton {
  private Task task;

  public TaskButton(Task task) {
    this.task = task;

    this.setText("task.toString()");
  }
}
