import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class LiteBriteBoardPanel extends JPanel {
	private int height;
	private int width;
	private LitePegButton[][] litePegButton;
	
	public LiteBriteBoardPanel(ActionListener actList, int height, int width) {
		this.height = height;
		this.width = width;
		
		this.litePegButton = new LitePegButton[height][width];;
		
		GridLayout litePegLayout = new GridLayout(height, width);
		this.setLayout(litePegLayout);
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
			
				litePegButton[i][j] = new LitePegButton();
				litePegButton[i][j].addActionListener(actList);
				this.add(litePegButton[i][j]);
			
			}
		}
	}

	public void clear() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				litePegButton[i][j].resetColor();
			}
		}
		
	}
}
