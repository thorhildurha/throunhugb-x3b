import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MyPages extends JPanel implements ActionListener{

//	private Database database;
	private Book[] books;
	public static JPanel panel = new JPanel();
//	private JPanel panel;
	private Owner user;
//	private Book book1;
//	private Book book2;
	
	public MyPages(Owner owner){
//		this.book1 = book1;
//		this.book2 = book2;
//		this.database = data;
		this.user=owner;
		this.books = View.database.searchByUser(user);
	}
	
//	Use: displayBooks(x,y,z);
//	Before: x is a JFrame, y is an Owner, z is a Book[]
//	After: Shows information about the Owner and the books that he is selling.
	public JPanel mypagesForm() {
		
		View.frame.setTitle("My Pages"); // Set a new title to the frame
		JPanel labelpanel = new JPanel();
		JPanel bookspanel = new JPanel();
		panel=new JPanel();
		BoxLayout paneling = new BoxLayout(panel,BoxLayout.Y_AXIS);
		panel.setLayout(paneling);
		
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
		
		JButton updateOwnerButton = new JButton("Update Owner");
		updateOwnerButton.addActionListener(this);
		
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
		fields.addComponent(updateOwnerButton);
		
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
		GroupLayout.ParallelGroup buttonGroup = inputs.createParallelGroup(GroupLayout.Alignment.CENTER);
		
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
		buttonGroup.addComponent(updateOwnerButton);
		
		vGroup.addGroup(nameGroup);
		vGroup.addGroup(emailGroup);
		vGroup.addGroup(locationGroup);
		vGroup.addGroup(phoneGroup);
		vGroup.addGroup(usernameGroup);
		vGroup.addGroup(buttonGroup);
		inputs.setVerticalGroup(vGroup);
		
//		updateOwnerButton.addActionListener(new ActionListener()
//		{
//			@Override
//			public void actionPerformed(ActionEvent e)
//			{
//				JButton source = (JButton) e.getSource();
//				JOptionPane.showMessageDialog(source, "Viljum við leyfa þetta?");
//				
//			}
//		});
		
		
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
		hGrouptwo.addGroup(labelstwo);
		hGrouptwo.addGroup(valuestwo);
		hGrouptwo.addGroup(updatebutton);
		bookslayout.setHorizontalGroup(hGrouptwo);
		bookslayout.setVerticalGroup(vGrouptwo);
		
		panel.add(labelpanel);
		panel.add(bookspanel);
		return panel;
		
		
		
//		JLabel nameLabel = new JLabel("Name :");
//		nameLabel.setBounds(10, 10, 80, 25);
//		panel.add(nameLabel);
//		
//		JLabel nameVal=new JLabel(user.getName());
//		nameVal.setBounds(100, 10, 160, 25);
//		panel.add(nameVal);
//		
//		JLabel emailLabel = new JLabel("Email :");
//		emailLabel.setBounds(10, 40, 80, 25);
//		panel.add(emailLabel);
//		
//		JLabel emailVal = new JLabel(user.getEmail());
//		emailVal.setBounds(100, 40, 160, 25);
//		panel.add(emailVal);
//		
//		JLabel locationLabel = new JLabel("Location :");
//		locationLabel.setBounds(10, 70, 80, 25);
//		panel.add(locationLabel);
//		
//		JLabel locationVal = new JLabel(user.getLocation());
//		locationVal.setBounds(100, 70, 160, 25);
//		panel.add(locationVal);
//		
//		JLabel phoneLabel = new JLabel("Phone :");
//		phoneLabel.setBounds(10, 100, 80, 25);
//		panel.add(phoneLabel);
//		
//		JLabel phoneVal = new JLabel(user.getPhone());
//		phoneVal.setBounds(100, 100, 160, 25);
//		panel.add(phoneVal);
//		
//		JLabel usernameLabel = new JLabel("Username :");
//		usernameLabel.setBounds(10, 130, 80, 25);
//		panel.add(usernameLabel);
//		
//		JLabel userVal = new JLabel(user.getUsername());
//		userVal.setBounds(100, 130, 160, 25);
//		panel.add(userVal);
//		
//		JButton updateOwnerButton = new JButton("Update Owner");
//		updateOwnerButton.setBounds(180, 160, 115, 25);
//		panel.add(updateOwnerButton);
//		
//		JLabel yourBooksLabel = new JLabel("YOUR BOOKS");
//		yourBooksLabel.setBounds(85, 190, 80, 25);
//		panel.add(yourBooksLabel);
//		
//		for(int i = 0; i< books.length; i++){
//			if(books[i].getOwner().equals(user))
//			{
//				int k = i+1;
//				JLabel BookLabel = new JLabel("Book "+ k +" :");
//				BookLabel.setBounds(10, 220+30*i, 80, 25);
//				panel.add(BookLabel);
//				
//				JLabel BookVal = new JLabel(books[i].getName());
//				BookVal.setBounds(100, 220+30*i, 160, 25);
//				panel.add(BookVal);
//				
//				JButton updateBookButton = new JButton("Update ISBN:" + books[i].getIsbn() );
//				updateBookButton.setBounds(220, 220+30*i, 142, 25);
//				panel.add(updateBookButton);
//				
//				ActionListener updateBookButtonListener = new ActionListener() {
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						JButton source = (JButton) e.getSource();
//						for(int i = 0; i< books.length; i++){
//							if(source.getText().equals("Update ISBN:"+ books[i].getIsbn())){
//								panel.setVisible(false);
//								JPanel updating= new JPanel();
//								Update updateForm=new Update(books[i]);
//								updating=updateForm.initUI();
//								View.frame.add(updating);
//								View.frame.setVisible(true);
//								break;
//							}
//						}
//					}
//				};
//				updateBookButton.addActionListener(updateBookButtonListener);
//				
//				
//			} 
//		}
//			
//		ActionListener updateOwnerButtonListener = new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				JButton source = (JButton) e.getSource();
//				JOptionPane.showMessageDialog(source, "Viljum við leyfa þetta?");
//			}
//		};
//		
//		
//		updateOwnerButton.addActionListener(updateOwnerButtonListener);
//		return panel;
		}
	public void actionPerformed(ActionEvent e){
		JButton source = (JButton) e.getSource();
		String command = source.getActionCommand();
		if(source.getText().equals("Update Owner")){
		  JOptionPane.showMessageDialog(source, "Viljum við leyfa þetta?");  
		  }
		if(books!=null){
			  for(int i=0; i<books.length; i++){
				  if(("update"+i).equals(command))
				  {	
					  panel.setVisible(false);
					  JPanel updating= new JPanel();
					  Update updateForm = new Update(books[i]);
					  updating = updateForm.initUI();
					  View.frame.add(updating);
					  View.frame.setVisible(true);
					  break;
				  }
				}  
			 }
	}
	


	
}

