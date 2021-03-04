import javax.swing.JButton;

public class BookButton extends JButton{
	private final int MAX_TEXT_LENGTH = 20;
	private final String ELLIPSES = "...";
	private Book book;
	
	public BookButton(Book book) {
		this.book = book;
		String title = this.book.getTitle();
		
		if (this.book.getTitle().length() > MAX_TEXT_LENGTH) {
			title = this.book.getTitle().substring(0, MAX_TEXT_LENGTH-1) + ELLIPSES;
		}
		this.book = book;
		setTitleText(title);
	}
	
	public Book getBook() {
		return this.book;
	}
		
	private void setTitleText(String title) {
		this.setText(title);
	}
	
	
}
