import java.awt.Dimension;

import javax.swing.JFrame;

public class TicTacToeMain {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Tic Tac Toe Main");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		TicTacToeGUI gui = new TicTacToeGUI();
		frame.getContentPane().add(gui);
		frame.setMinimumSize(new Dimension(600, 400));
		
		frame.pack();
		frame.setVisible(true);
		
		
	}
}
