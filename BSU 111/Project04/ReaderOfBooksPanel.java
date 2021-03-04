import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class ReaderOfBooksPanel extends JPanel {
	private LibraryPanel libraryPanel;
	private ReaderPanel readerPanel;
	private ActionListener BookButtonListener;
	
	public class BookButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("BookButtonListener");
			BookButton bookButton = (BookButton)e.getSource();
			
			Book book = bookButton.getBook();
			readerPanel.loadBook(book);
		}
	}
	
	public ReaderOfBooksPanel() {
		setLayout(new BorderLayout());
		readerPanel = new ReaderPanel();
		libraryPanel = new LibraryPanel(readerPanel);
		
		
//		libraryPanel.bookButton.addActionListener(new BookButtonListener());
		
		add(libraryPanel, BorderLayout.WEST);
		add(readerPanel, BorderLayout.CENTER);

	}
	
	
	

}


	
