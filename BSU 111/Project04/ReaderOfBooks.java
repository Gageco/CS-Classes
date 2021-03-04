import java.awt.Dimension;

import javax.swing.JFrame;

public class ReaderOfBooks {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Reader of Books");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ReaderOfBooksPanel panel = new ReaderOfBooksPanel();
		frame.getContentPane().add(panel);
		frame.setMinimumSize(new Dimension(600, 400));

		frame.pack();
		frame.setVisible(true);
	}
}
