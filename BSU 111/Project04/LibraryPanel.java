import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.*;

public class LibraryPanel extends JPanel {
	private Library library = new Library();
	private ActionListener bookButtonListener;
	private JPanel bookListPanel;
	private JScrollPane bookListScrollPane;
	private JPanel importPanel;
	private JTextField importTextField;
	private JButton importButton;
	
	private ReaderPanel readerPanel;
	
	public BookButton bookButton;
	
	public LibraryPanel(ReaderPanel readPanel) {
		setLayout(new BorderLayout());
		this.readerPanel = readPanel;
		
		bookListPanel = new JPanel();
		bookListScrollPane = new JScrollPane(bookListPanel);
		bookListScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		bookListScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		bookListPanel.setLayout(new BoxLayout(bookListPanel, BoxLayout.Y_AXIS));
		
		/////////////////////////////////////////////
		//Visual Separation For My Sake/////////////
		///////////////////////////////////////////
		
		this.importPanel = new JPanel();
		this.importTextField = new JTextField(15);
		this.importTextField.addActionListener(new ImportActionListener());
		
		
		this.importButton = new JButton("Load Book");
		this.importButton.addActionListener(new ImportActionListener());
		
		
		importPanel.add(importTextField, BorderLayout.CENTER);
		importPanel.add(importButton, BorderLayout.SOUTH);
		
		add(bookListScrollPane, BorderLayout.CENTER);
		add(importPanel, BorderLayout.SOUTH);
	}
	
	
	
	private class ImportActionListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			bookListPanel.removeAll();
			
			
			String csvFile = importTextField.getText();
			library.loadLibraryFromCSV(csvFile);
			
			for (int i = 0; i < library.books.size(); i++) {
				bookButton = new BookButton(library.books.get(i));
				bookButton.setAlignmentX(Component.CENTER_ALIGNMENT);
				bookListPanel.add(Box.createRigidArea(new Dimension(0,15)));
				bookButton.addActionListener(new BookButtonListener(readerPanel));
				bookListPanel.add(bookButton);
				revalidate();
			}
			
		}
		
	}
	
}