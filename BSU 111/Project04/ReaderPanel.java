

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ReaderPanel extends JPanel {
	private JPanel infoPanel;
	private JLabel titleLabel;
	private JLabel authorLabel;
	private JTextArea bookTextArea;
	private JScrollPane bookTextScrollPane;
	
	public ReaderPanel() {
		setLayout(new BorderLayout());		
		
		this.infoPanel = new JPanel();
		this.titleLabel = new JLabel("Title: ");
		this.authorLabel = new JLabel("Author: ");
		infoPanel.add(titleLabel);
		infoPanel.add(authorLabel);
		
		
		this.bookTextArea = new JTextArea();
		this.bookTextScrollPane = new JScrollPane(bookTextArea);
		bookTextScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		bookTextScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		this.add(infoPanel, BorderLayout.NORTH);
		this.add(bookTextScrollPane, BorderLayout.CENTER);
	}
	
	public void loadBook(Book book) {
		this.titleLabel.setText(("Title: " + book.getTitle()));
		this.authorLabel.setText("Author: " + book.getAuthor());
		this.bookTextArea.setText(book.getText());
	}

}
