import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MyPages extends JPanel implements ActionListener{
	private Book[] books;
	public static JPanel panel = new JPanel();
	private Owner user;
	private JFrame frame;
	private Database database;
	
	public MyPages(Owner owner, JFrame frame, Database database){
		this.user=owner;
		this.database=database;
		this.books = database.searchByUser(user);
		this.frame=frame;
	}
	
//	Use: displayBooks(x,y,z);
//	Before: x is a JFrame, y is an Owner, z is a Book[]
//	After: Shows information about the Owner and the books that he is selling.
	public void mypagesForm() {
		frame.setTitle("My Pages"); // Set a new title to the frame
		JPanel labelpanel = new JPanel();
		JPanel bookspanel = new JPanel();
		panel=new JPanel();
		BoxLayout paneling = new BoxLayout(panel,BoxLayout.Y_AXIS);
		panel.setLayout(paneling);
		
		JButton back=new JButton("Back to Search");
		back.addActionListener(this);
		
		JLabel nameLabel = new JLabel("Name :");
		JLabel nameVal = new JLabel(user.getName());
		
		JLabel emailLabel = new JLabel("Email :");
		JLabel emailVal = new JLabel(user.getEmail());
		
		JLabel locationLabel = new JLabel("Location :");
		JLabel locationVal = new JLabel(user.getLocation());
		
		JLabel phoneLabel = new JLabel("Phone :");
		JLabel phoneVal = new JLabel(user.getPhone());
		
		JLabel usernameLabel = new JLabel("Username :");
		JLabel userVal = new JLabel(user.getUsername());
		
		GroupLayout inputs=new GroupLayout(labelpanel);
		labelpanel.setLayout(inputs);
		inputs.setAutoCreateGaps(true);
		//First Sequential Group
		GroupLayout.SequentialGroup hGroup = inputs.createSequentialGroup();
		GroupLayout.ParallelGroup labels = inputs.createParallelGroup(); //One for Labels
		GroupLayout.ParallelGroup fields = inputs.createParallelGroup(); //Other for values/fields
		
		labels.addComponent(nameLabel);
		labels.addComponent(emailLabel);
		labels.addComponent(locationLabel);
		labels.addComponent(phoneLabel);
		labels.addComponent(usernameLabel);
		fields.addComponent(nameVal);
		fields.addComponent(emailVal);
		fields.addComponent(locationVal);
		fields.addComponent(phoneVal);
		fields.addComponent(userVal);
		
		hGroup.addGroup(labels);
		hGroup.addGroup(fields);
		//Then horizontal Group
		inputs.setHorizontalGroup(hGroup);
		GroupLayout.SequentialGroup vGroup = inputs.createSequentialGroup();
		
		GroupLayout.ParallelGroup nameGroup = inputs.createParallelGroup(GroupLayout.Alignment.CENTER);
		GroupLayout.ParallelGroup emailGroup = inputs.createParallelGroup(GroupLayout.Alignment.CENTER);
		GroupLayout.ParallelGroup locationGroup = inputs.createParallelGroup(GroupLayout.Alignment.CENTER);
		GroupLayout.ParallelGroup phoneGroup = inputs.createParallelGroup(GroupLayout.Alignment.CENTER);
		GroupLayout.ParallelGroup usernameGroup = inputs.createParallelGroup(GroupLayout.Alignment.CENTER);
		
		nameGroup.addComponent(nameLabel);
		nameGroup.addComponent(nameVal);
		emailGroup.addComponent(emailLabel);
		emailGroup.addComponent(emailVal);
		locationGroup.addComponent(locationLabel);
		locationGroup.addComponent(locationVal);
		phoneGroup.addComponent(phoneLabel);
		phoneGroup.addComponent(phoneVal);
		usernameGroup.addComponent(usernameLabel);
		usernameGroup.addComponent(userVal);
		vGroup.addGroup(nameGroup);
		vGroup.addGroup(emailGroup);
		vGroup.addGroup(locationGroup);
		vGroup.addGroup(phoneGroup);
		vGroup.addGroup(usernameGroup);
		inputs.setVerticalGroup(vGroup);
		
		GroupLayout bookslayout =new GroupLayout(bookspanel);
		bookspanel.setLayout(bookslayout);
		bookslayout.setAutoCreateGaps(true);
		bookslayout.setAutoCreateContainerGaps(true);
		
		GroupLayout.SequentialGroup hGrouptwo = bookslayout.createSequentialGroup();
		GroupLayout.ParallelGroup labelstwo = bookslayout.createParallelGroup(); //One for Labels
		GroupLayout.ParallelGroup valuestwo = bookslayout.createParallelGroup(); //One for Labels
		GroupLayout.ParallelGroup updatebutton = bookslayout.createParallelGroup();
		GroupLayout.SequentialGroup vGrouptwo = bookslayout.createSequentialGroup();
		GroupLayout.ParallelGroup booksGroupTitle[]= new GroupLayout.ParallelGroup[books.length];
		JLabel BookNameLabel[]=new JLabel[books.length];
		JButton UpdateButton[]=new JButton[books.length];
		
		for(int i = 0; i<books.length; i++){
			int k = i+1;
			booksGroupTitle[i] = bookslayout.createParallelGroup();
			JLabel TitleLabel= new JLabel("Book "+k+" :");
			BookNameLabel[i] = new JLabel(books[i].getName());
			labelstwo.addComponent(TitleLabel);
			valuestwo.addComponent(BookNameLabel[i]);
			booksGroupTitle[i].addComponent(TitleLabel);
			booksGroupTitle[i].addComponent(BookNameLabel[i]);
			UpdateButton[i] = new JButton("update");
			UpdateButton[i].setActionCommand("update"+i);
			UpdateButton[i].addActionListener(this);
			updatebutton.addComponent(UpdateButton[i]);
			booksGroupTitle[i].addComponent(UpdateButton[i]);
			vGrouptwo.addGroup(booksGroupTitle[i]);
			}
		GroupLayout.ParallelGroup backGroup=bookslayout.createParallelGroup(GroupLayout.Alignment.CENTER);
		backGroup.addComponent(back);
		vGrouptwo.addGroup(backGroup);
		valuestwo.addComponent(back);
		hGrouptwo.addGroup(labelstwo);
		hGrouptwo.addGroup(valuestwo);
		hGrouptwo.addGroup(updatebutton);
		bookslayout.setHorizontalGroup(hGrouptwo);
		bookslayout.setVerticalGroup(vGrouptwo);
		
		panel.add(labelpanel);
		panel.add(bookspanel);
		frame.add(panel);
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		JButton source = (JButton) e.getSource();
		String command = source.getActionCommand();
//		if(source.getText().equals("Update Owner")){
//		  JOptionPane.showMessageDialog(source, "Viljum vi� leyfa �etta?");  
//		  }
		if(books!=null){
			  for(int i=0; i<books.length; i++){
				  if(("update"+i).equals(command))
				  {	
					  panel.setVisible(false);
					  JPanel updating= new JPanel();
					  Update updateForm = new Update(books[i]);
					  updating = updateForm.initUI();
					  frame.add(updating);
					  frame.setVisible(true);
					  break;
				  }
				}  
			 }
		if(source.getText().equals("Back to Search")){
			frame.remove(panel);
			View.search.searchDialog();

		}
	}
	


	
}

