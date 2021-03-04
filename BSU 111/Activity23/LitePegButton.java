import javax.swing.JButton;
import java.awt.Color;

public class LitePegButton extends JButton {
	private final Color[] COLORS = {Color.BLACK, Color.GREEN, Color.BLUE, Color.GRAY, Color.RED};
	private int colorIndex;
	
	public LitePegButton() {
		this.resetColor();
	}
	
	public Color getColor() {
		return COLORS[colorIndex];
		
	}
	
	public void changeColor() {
		this.colorIndex++;
		colorIndex = colorIndex % COLORS.length;
		
		this.setBackground(COLORS[colorIndex]);
	}

	public void resetColor() {
		this.setBackground(COLORS[0]);
		
	}
	
}
