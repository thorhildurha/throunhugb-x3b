import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class Search extends JFrame implements ActionListener
{

  private Owner user;
  private Database database;
  public static JPanel panel;
  private Book[] books;
  private JPanel results;
  private JTextField TitleText; //Needs to be accessible in all the class
  private JTextField AuthorText;
  private JTextField isbnText;
  
  public Search(Owner loggedin,Database database, JFrame frame){
    this.user=loggedin;
    this.database=database;
	this.results=new JPanel();

  }
  
  //Before: nothing
  //After: returns the Panel for the Search Form
  public void searchDialog()
  {
	panel=new JPanel();
    JPanel searchpanel = new JPanel();
    GroupLayout inputs=new GroupLayout(searchpanel);
    inputs.setAutoCreateGaps(true);
    inputs.setAutoCreateContainerGaps(true);
    GroupLayout.SequentialGroup hGroup = inputs.createSequentialGroup();
    searchpanel.setLayout(inputs);
    GroupLayout.ParallelGroup labels=inputs.createParallelGroup(); //One for Labels
    GroupLayout.ParallelGroup fields=inputs.createParallelGroup(); //Other for values/fields
    
    if(this.isloggedin()){
    	JButton mypages = new JButton("My Pages");
    	mypages.setActionCommand("mypages");
    	mypages.addActionListener(this);
    	panel.add(mypages,BorderLayout.WEST);
    }
    else{
    	JButton login = new JButton("Login");
    	login.setActionCommand("login");
    	login.addActionListener(this);
    	panel.add(login,BorderLayout.WEST);
    }
    JButton searchButton = new JButton("Search");
    JLabel titleLabel = new JLabel ("Book title");
    labels.addComponent(titleLabel);
    
    JLabel authorLabel = new JLabel ("Author");
    labels.addComponent(authorLabel);
    
    JLabel isbnLabel = new JLabel ("ISBN");
    labels.addComponent(isbnLabel);
    
    JLabel courseLabel= new JLabel ("Course");
    labels.addComponent(courseLabel);
    
    JLabel priceLabel= new JLabel ("Price (optional) <=");
    labels.addComponent(priceLabel);
    
    TitleText = new JTextField(20);
    fields.addComponent(TitleText,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
    
    AuthorText = new JTextField(20);
    fields.addComponent(AuthorText,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
    
    isbnText = new JTextField(20);
    fields.addComponent(isbnText,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
    
    JTextField courseText = new JTextField(20);
    fields.addComponent(courseText,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
    
    JTextField priceText = new JTextField(6);
    fields.addComponent(priceText,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
    fields.addComponent(searchButton);
    
    hGroup.addGroup(labels);
    hGroup.addGroup(fields);
    
    inputs.setHorizontalGroup(hGroup);
    
    GroupLayout.SequentialGroup vGroup = inputs.createSequentialGroup();
    
    GroupLayout.ParallelGroup IsbnGroup=inputs.createParallelGroup(GroupLayout.Alignment.CENTER);
    GroupLayout.ParallelGroup TitleGroup=inputs.createParallelGroup(GroupLayout.Alignment.CENTER);
    GroupLayout.ParallelGroup AuthorGroup=inputs.createParallelGroup(GroupLayout.Alignment.CENTER);
    GroupLayout.ParallelGroup CourseGroup=inputs.createParallelGroup(GroupLayout.Alignment.CENTER);
    GroupLayout.ParallelGroup PriceGroup=inputs.createParallelGroup(GroupLayout.Alignment.CENTER);
	GroupLayout.ParallelGroup buttonGroup=inputs.createParallelGroup(GroupLayout.Alignment.CENTER);
    IsbnGroup.addComponent(isbnLabel);
    IsbnGroup.addComponent(isbnText,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
    TitleGroup.addComponent(titleLabel);
    TitleGroup.addComponent(TitleText,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
    AuthorGroup.addComponent(authorLabel);
    AuthorGroup.addComponent(AuthorText,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
    CourseGroup.addComponent(courseLabel);
    CourseGroup.addComponent(courseText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
    PriceGroup.addComponent(priceLabel);
    PriceGroup.addComponent(priceText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
	buttonGroup.addComponent(searchButton);

    vGroup.addGroup(IsbnGroup);
    vGroup.addGroup(TitleGroup);
    vGroup.addGroup(AuthorGroup);
    vGroup.addGroup(CourseGroup);
    vGroup.addGroup(PriceGroup);
    vGroup.addGroup(buttonGroup);
    inputs.setVerticalGroup(vGroup);
    
    searchButton.setActionCommand("search");
    searchButton.addActionListener(this);
    panel.add(searchpanel);
    panel.add(results);
    View.frame.add(panel);
    View.frame.setVisible(true);
  }
  public void showbooks(){
	  GroupLayout result =new GroupLayout(results);
	  results.setLayout(result);
	  result.setAutoCreateGaps(true);
	  result.setAutoCreateContainerGaps(true);
	  
	  GroupLayout.SequentialGroup hGroup = result.createSequentialGroup();
	  GroupLayout.ParallelGroup labels=result.createParallelGroup(); //One for Labels
	  GroupLayout.ParallelGroup values=result.createParallelGroup(); //One for Labels
	  GroupLayout.ParallelGroup registerbutton = result.createParallelGroup();
	  
	  GroupLayout.SequentialGroup vGroup = result.createSequentialGroup();
	  GroupLayout.ParallelGroup resultGroupTitle[]= new GroupLayout.ParallelGroup[books.length];
	  GroupLayout.ParallelGroup resultGroupAuthor[]=new GroupLayout.ParallelGroup[books.length];
	  GroupLayout.ParallelGroup resultGroupPrice[]=new GroupLayout.ParallelGroup[books.length];
	  JLabel BookNameLabel[]=new JLabel[books.length];
	  JLabel BookAuthorLabel[]=new JLabel[books.length];
	  JLabel BookPriceLabel[]=new JLabel[books.length];
	  JButton RegisterButton[]=new JButton[books.length];

	  String isbn="";

	  for(int i = 0; i<books.length; i++){
		  resultGroupTitle[i]=result.createParallelGroup();
		  resultGroupAuthor[i]=result.createParallelGroup();
		  resultGroupPrice[i]=result.createParallelGroup();
		  resultGroupPrice[i].addGap(50);

		  
		  JLabel TitleLabel= new JLabel("Title:");
		  JLabel AuthorLabel = new JLabel("Author:");
		  JLabel PriceLabel= new JLabel("Price:");
		  BookNameLabel[i] = new JLabel(books[i].getName());
		  BookAuthorLabel[i] = new JLabel(books[i].getAuthor());
		  BookPriceLabel[i] = new JLabel(books[i].getPrice());
		  labels.addComponent(TitleLabel);
		  labels.addComponent(AuthorLabel);
		  labels.addComponent(PriceLabel);
		  values.addComponent(BookNameLabel[i]);
		  values.addComponent(BookAuthorLabel[i]);
		  values.addComponent(BookPriceLabel[i]);
		  
		  resultGroupTitle[i].addComponent(TitleLabel);
		  resultGroupTitle[i].addComponent(BookNameLabel[i]);
		  resultGroupAuthor[i].addComponent(AuthorLabel);
		  resultGroupAuthor[i].addComponent(BookAuthorLabel[i]);
		  RegisterButton[i] = new JButton("register");
		  RegisterButton[i].setActionCommand("register"+i);
		  RegisterButton[i].addActionListener(this);
		  registerbutton.addComponent(RegisterButton[i]);
		  resultGroupAuthor[i].addComponent(RegisterButton[i]);
		  resultGroupPrice[i].addComponent(PriceLabel);
		  resultGroupPrice[i].addComponent(BookPriceLabel[i]);
		  vGroup.addGroup(resultGroupTitle[i]);
		  vGroup.addGroup(resultGroupAuthor[i]);
		  vGroup.addGroup(resultGroupPrice[i]);
		  

	  }
	  hGroup.addGroup(labels);
	  hGroup.addGroup(values);
	  hGroup.addGroup(registerbutton);
	  result.setHorizontalGroup(hGroup);
	  result.setVerticalGroup(vGroup);
	  
  }
  public Boolean isloggedin(){
    if(user.isloggedin()){
      return true;
    }
    else{
      return false;
    }
  }
  public void actionPerformed(ActionEvent e){
	  JButton source = (JButton) e.getSource();
	  String command=source.getActionCommand();
	  if("search".equals(command)){
		  books = new Book[2];
		  Book searchfor = new Book(TitleText.getText(), AuthorText.getText(),isbnText.getText());
		  books=database.search(searchfor);
		  showbooks();
	  }
	  if("login".equals(command)){
		  Login loginform = new Login(user,database);
	  }
	  if("mypages".equals(command)){
		MyPages mypage = new MyPages(user);  
		JPanel mypagePanel=	mypage.mypagesForm();
		panel.setVisible(false);
		View.frame.add(mypagePanel);
		View.frame.setVisible(true);
	  }
	  if(books!=null){
		  for(int i=0; i<books.length; i++){
			  if(("register"+i).equals(command))
			  {	
				  if(isloggedin()){
					  RegistrationForm registerform = new RegistrationForm(books[i], View.frame, database);
					  panel.setVisible(false);
					  registerform.initUI();
				  }
				  else{
					  JOptionPane.showMessageDialog(View.frame,
							    "You need to be signed in!",
							    "Registration Error",
							    JOptionPane.ERROR_MESSAGE);
				  }
			  }
		  }
	  }
  }
}