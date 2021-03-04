import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookButtonListener implements ActionListener {
	ReaderPanel readerPanel;
	BookButtonListener(ReaderPanel readPanel) {
		this.readerPanel = readPanel;
//		readerPanel = new ReaderPanel();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("BookButtonListener");
		BookButton bookButton = (BookButton)e.getSource();
		
		Book book = bookButton.getBook();
		System.out.println(book.toString());
		readerPanel.loadBook(book);
	}

}
