import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MyPages extends JPanel{

//	private Database database;
	private JFrame frame;
	private Owner user;
	private Book[] books;
	private Database database;
	public static JPanel panel = new JPanel();
//	private Book book1;
//	private Book book2;
	
	public MyPages(JFrame frame, Owner owner, Database database){
		this.user = owner;
//		this.book1 = book1;
//		this.book2 = book2;
//		this.database = data;
		this.books = database.searchByUser(user);
		this.database=database;
		this.frame=frame;
		mypagesForm();
	}
	
//	Use: mypagesForm();
//	Before: nothing
//	After: mypagesForm has been created
	public void mypagesForm() {
		displayBooks(user, books);
	}

//	Use: displayBooks(x,y,z);
//	Before: x is a JFrame, y is an Owner, z is a Book[]
//	After: Shows information about the Owner and the books that he is selling.
	private void displayBooks(Owner user, Book[] books) {
		panel.setLayout(null);
		
		JLabel nameLabel = new JLabel("Name :");
		nameLabel.setBounds(10, 10, 80, 25);
		panel.add(nameLabel);
		
		JLabel nameVal=new JLabel(user.getName());
		nameVal.setBounds(100, 10, 160, 25);
		panel.add(nameVal);
		
		JLabel emailLabel = new JLabel("Email :");
		emailLabel.setBounds(10, 40, 80, 25);
		panel.add(emailLabel);
		
		JLabel emailVal = new JLabel(user.getEmail());
		emailVal.setBounds(100, 40, 160, 25);
		panel.add(emailVal);
		
		JLabel locationLabel = new JLabel("Location :");
		locationLabel.setBounds(10, 70, 80, 25);
		panel.add(locationLabel);
		
		JLabel locationVal = new JLabel(user.getLocation());
		locationVal.setBounds(100, 70, 160, 25);
		panel.add(locationVal);
		
		JLabel phoneLabel = new JLabel("Phone :");
		phoneLabel.setBounds(10, 100, 80, 25);
		panel.add(phoneLabel);
		
		JLabel phoneVal = new JLabel(user.getPhone());
		phoneVal.setBounds(100, 100, 160, 25);
		panel.add(phoneVal);
		
		JLabel usernameLabel = new JLabel("Username :");
		usernameLabel.setBounds(10, 130, 80, 25);
		panel.add(usernameLabel);
		
		JLabel userVal = new JLabel(user.getUsername());
		userVal.setBounds(100, 130, 160, 25);
		panel.add(userVal);
		
		JButton updateOwnerButton = new JButton("Update Owner");
		updateOwnerButton.setBounds(180, 160, 115, 25);
		panel.add(updateOwnerButton);
		
		JLabel yourBooksLabel = new JLabel("YOUR BOOKS");
		yourBooksLabel.setBounds(85, 190, 80, 25);
		panel.add(yourBooksLabel);
		
		for(int i = 0; i< books.length; i++){
			if(books[i].getOwner().equals(user))
			{
				int k = i+1;
				JLabel BookLabel = new JLabel("Book "+ k +" :");
				BookLabel.setBounds(10, 220+30*i, 80, 25);
				panel.add(BookLabel);
				
				JLabel BookVal = new JLabel(books[i].getName());
				BookVal.setBounds(100, 220+30*i, 160, 25);
				panel.add(BookVal);
				
				JButton updateBookButton = new JButton("Update ISBN:" + books[i].getIsbn() );
				updateBookButton.setBounds(220, 220+30*i, 142, 25);
				panel.add(updateBookButton);
				
				ActionListener updateBookButtonListener = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JButton source = (JButton) e.getSource();
						for(int i = 0; i< books.length; i++){
							if(source.getText().equals("Update ISBN:"+ books[i].getIsbn())){
								panel.setVisible(false);
								JPanel updating= new JPanel();
								Update updateForm=new Update(books[i],frame,database);
								updating=updateForm.initUI();
								frame.add(updating);
								frame.setVisible(true);
								break;
							}
						}
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
