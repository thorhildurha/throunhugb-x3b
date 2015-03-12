import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class MyPages {

//	private Database database;
	private Owner user;
	private Book[] books;
//	private Book book1;
//	private Book book2;
	
	public MyPages(Owner owner, Book[] books){
		this.user = owner;
//		this.book1 = book1;
//		this.book2 = book2;
//		this.database = data;
		this.books = books;
		mypagesForm();
	}
	public static void main(String[] args) {
//		Owner someone=null;
//		MockDatabase database = new MockDatabase();
//		MyPages mypages = new MyPages(someone, database);
		Owner someone = new Owner("Þórhildur Hafsteinsdóttir", "Reykjavík", "totan@gmail.com", "6666666", "totahotty");
		Owner beib= new Owner("Jón Jónsson", "Reykjavík", "totan@gmail.com", "6666666", "totahotty");
		Book gula = new Book("Litla gula hænan","Andrés Pétursson","02024");
		Book kukur = new Book("Litli kúkurinn","Þórhildur Hafsteinsdóttir","02024");
		gula.setOwner(someone);
//		gula.setOwner(beib);
		kukur.setOwner(someone);
		Book[] baekur = {gula,kukur};
		MyPages mypages = new MyPages(someone, baekur);

	}
	
//	Use: mypagesForm();
//	Before: nothing
//	After: mypagesForm has been created
	public void mypagesForm() {
		JFrame frame = new JFrame("My Pages");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		displayBooks(frame, user, books);
		frame.setVisible(true);
	}
	
	private void displayBooks(JFrame frame, Owner user, Book[] books) {
		frame.setLayout(null);
		
		JLabel nameLabel = new JLabel("Name :");
		nameLabel.setBounds(10, 10, 80, 25);
		frame.add(nameLabel);
		
		JLabel nameVal=new JLabel(user.getName());
		nameVal.setBounds(100, 10, 160, 25);
		frame.add(nameVal);
		
		JLabel emailLabel = new JLabel("Email :");
		emailLabel.setBounds(10, 40, 80, 25);
		frame.add(emailLabel);
		
		JLabel emailVal = new JLabel(user.getEmail());
		emailVal.setBounds(100, 40, 160, 25);
		frame.add(emailVal);
		
		JLabel locationLabel = new JLabel("Location :");
		locationLabel.setBounds(10, 70, 80, 25);
		frame.add(locationLabel);
		
		JLabel locationVal = new JLabel(user.getLocation());
		locationVal.setBounds(100, 70, 160, 25);
		frame.add(locationVal);
		
		JLabel phoneLabel = new JLabel("Phone :");
		phoneLabel.setBounds(10, 100, 80, 25);
		frame.add(phoneLabel);
		
		JLabel phoneVal = new JLabel(user.getPhone());
		phoneVal.setBounds(100, 100, 160, 25);
		frame.add(phoneVal);
		
		JLabel usernameLabel = new JLabel("Username :");
		usernameLabel.setBounds(10, 130, 80, 25);
		frame.add(usernameLabel);
		
		JLabel userVal = new JLabel(user.getUsername());
		userVal.setBounds(100, 130, 160, 25);
		frame.add(userVal);
		
		JButton updateOwnerButton = new JButton("Update Owner");
		updateOwnerButton.setBounds(180, 160, 115, 25);
		frame.add(updateOwnerButton);
		
		JLabel yourBooksLabel = new JLabel("YOUR BOOKS");
		yourBooksLabel.setBounds(85, 190, 80, 25);
		frame.add(yourBooksLabel);
		
		for(int i = 0; i< books.length; i++){
			if(books[i].getOwner().equals(user))
			{
				JLabel BookLabel = new JLabel("Book :");
				BookLabel.setBounds(10, 220+30*i, 80, 25);
				frame.add(BookLabel);
				
				JLabel BookVal = new JLabel(books[i].getName());
				BookVal.setBounds(100, 220+30*i, 160, 25);
				frame.add(BookVal);
				
				JButton updateBookButton = new JButton("Update");
				updateBookButton.setBounds(220, 220+30*i, 80, 25);
				frame.add(updateBookButton);
				
				ActionListener updateBookButtonListener = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JButton source = (JButton) e.getSource();
						JOptionPane.showMessageDialog(source, "Guðrún forritar þetta");
					}
				};
				updateBookButton.addActionListener(updateBookButtonListener);
				
				
			} 
		}
			
		ActionListener updateOwnerButtonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton source = (JButton) e.getSource();
				JOptionPane.showMessageDialog(source, "Viljum við leyfa þetta?");
			}
		};
		
		
		updateOwnerButton.addActionListener(updateOwnerButtonListener);
		
		
		
	}

	
	
}
