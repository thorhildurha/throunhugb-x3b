import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.ScrollPaneConstants;

public class Search extends JFrame implements ActionListener
{

  private Owner user;
  private Database database;
  private JFrame frame;
  private JPanel panel;
  public static JScrollPane scrollpane;
  private Book[] books;  //stores the books that the user searched for
  private JPanel results;
  private JTextField TitleText; //Needs to be accessible in all the class
  private JTextField AuthorText;
  private JTextField isbnText;
  private JTextField courseText;
  
  public Search(Owner loggedin,Database database, JFrame frame){
    this.user=loggedin;
    this.database=database;
    this.results=new JPanel();
    this.frame=frame;
    this.books=new Book[0];

  }
  //Before: nothing
  //After: creates the JPanel for the Search Form and displays it
  public void searchDialog()
  {
	panel=null; //First we clear the panel just in case
	panel=new JPanel(); 
    JPanel searchpanel = new JPanel(); //The panel that shows the search conditions
    
	//We create the group Layout for the panels and buttons
	GroupLayout panels= new GroupLayout(panel);
	panels.setAutoCreateGaps(true);
	panels.setAutoCreateContainerGaps(true);
	panel.setLayout(panels);
	GroupLayout.SequentialGroup horiGroup=panels.createSequentialGroup();
	GroupLayout.ParallelGroup pan = panels.createParallelGroup();
	
    GroupLayout.ParallelGroup buttonpan=panels.createParallelGroup(GroupLayout.Alignment.CENTER);
    GroupLayout.ParallelGroup logoutpan=panels.createParallelGroup(GroupLayout.Alignment.CENTER);

	if(this.isloggedin()){ //If a user is loggedin then show mypages button and logout button
    	JButton mypages = new JButton("My Pages");
    	mypages.setActionCommand("mypages");
    	mypages.addActionListener(this);
    	pan.addComponent(mypages);
    	buttonpan.addComponent(mypages);
    	JButton logout = new JButton("Logout");
    	logout.setActionCommand("logout");
    	logout.addActionListener(this);
    	pan.addComponent(logout);
    	logoutpan.addComponent(logout);
    }
    else{ //if he is not loggedin show login button
    	JButton login = new JButton("Login");
    	login.setActionCommand("login");
    	login.addActionListener(this);
    	pan.addComponent(login);
    	buttonpan.addComponent(login);
    }
	pan.addComponent(searchpanel);
	pan.addComponent(results);
	horiGroup.addGroup(pan);
	panels.setHorizontalGroup(horiGroup);
	GroupLayout.SequentialGroup vertGroup = panels.createSequentialGroup();
	GroupLayout.ParallelGroup searchpan=panels.createParallelGroup(GroupLayout.Alignment.CENTER);
    GroupLayout.ParallelGroup resultpan=panels.createParallelGroup(GroupLayout.Alignment.CENTER);
    searchpan.addComponent(searchpanel);
    resultpan.addComponent(results);
    vertGroup.addGroup(buttonpan);
    vertGroup.addGroup(logoutpan);
    vertGroup.addGroup(searchpan);
    vertGroup.addGroup(resultpan);
    panels.setVerticalGroup(vertGroup);
    
    //Next we create the GroupLayout for the search conditions
    GroupLayout inputs=new GroupLayout(searchpanel);
    inputs.setAutoCreateGaps(true);
    inputs.setAutoCreateContainerGaps(true);
    GroupLayout.SequentialGroup hGroup = inputs.createSequentialGroup();
    searchpanel.setLayout(inputs);
    GroupLayout.ParallelGroup labels=inputs.createParallelGroup(); //One for Labels
    GroupLayout.ParallelGroup fields=inputs.createParallelGroup(); //Other for values/field
   
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
    
    courseText = new JTextField(20);
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

    scrollpane = new JScrollPane(panel);
    frame.add(scrollpane);
    frame.setVisible(true);
  }
  //Use: showbooks();
  //Before: Nothing
  //After: The information in Search.books[] has been displayed on the JPanel
  public void showbooks(){
	  results.removeAll(); //remove previous results
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
	  panel.revalidate(); //let the scroll pane know that changes have been made
	  frame.setVisible(true);
  }
  
  //Use: b=isloggedin();
  //Before: nothing
  //After: returns true if there is someone logged in, false otherwise
  public Boolean isloggedin(){
    if(user.isloggedin()){
      return true;
    }
    else{
      return false;
    }
  }
  //
  //Before: 
  //After: 
  public void search(){
	  String Title = TitleText.getText();
	  String Author=AuthorText.getText();
	  String isbn =isbnText.getText();
	  String Course=courseText.getText();
	  //if there are no fields filled out, there is nothing to look for
	  if(Title.isEmpty()&&Author.isEmpty()&&isbn.isEmpty()&&Course.isEmpty()){
		  JOptionPane.showMessageDialog(frame,
				    "Please type in search conditions!",
				    "Missing search conditions",
				    JOptionPane.INFORMATION_MESSAGE);
	  }
	  else{
		  Book searchfor = new Book(Title, Author, isbn);
		  books=database.search(searchfor);
		  if(books.length==0){
			  JOptionPane.showMessageDialog(frame,
					  "No search results!",
					  "No results",
					  JOptionPane.INFORMATION_MESSAGE);
		  }
		  else{
			  showbooks();
		  }
	  }
  }
  public void actionPerformed(ActionEvent e){
	  JButton source = (JButton) e.getSource();
	  String command=source.getActionCommand();
	  if("search".equals(command)){
		  search();
	  }
	  if("login".equals(command)){
		  Login loginform = new Login(user,database,frame);
	  }
	  if("mypages".equals(command)){
		  frame.remove(scrollpane);
		  panel=null;
		  MyPages mypage = new MyPages(user,frame,database);  
		  mypage.mypagesForm();
	  }
	  if("logout".equals(command)){
//		  user = null;
//		  Search newsearch = new Search(null,database,frame);
//		  newsearch.searchDialog();
//		  frame.remove(scrollpane);
//		  panel=null;
//		  View.search.searchDialog();
		  JOptionPane.showMessageDialog(frame, "Ég er frekar pirripú því þetta virkar ekki hjá mér :(",
				    "Þórhildur sár",
				    JOptionPane.ERROR_MESSAGE);
		  
	  }
	  if(books!=null){
		  for(int i=0; i<books.length; i++){
			  if(("register"+i).equals(command))
			  {	
				  if(isloggedin()){
					  RegistrationForm registerform = new RegistrationForm(books[i], frame, database);
					  frame.remove(scrollpane);
					  registerform.initUI();
				  }
				  else{
					  JOptionPane.showMessageDialog(frame,
							    "You need to be signed in!",
							    "Registration Error",
							    JOptionPane.ERROR_MESSAGE);
				  }
			  }
		  }
	  }
  }
}