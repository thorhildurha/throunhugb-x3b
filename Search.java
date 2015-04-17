import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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
  private ArrayList<Book> usedbooks;  //stores the books that the user searched for
  private ArrayList<Book> newbooks;
  private JPanel results;
  private JTextField TitleText; //Needs to be accessible in all the class
  private JTextField AuthorText;
  private JTextField isbnText;

  private JComboBox categoryText;
  private JComboBox subcategoryText;
  private ComboBoxModel[] models = new ComboBoxModel[7];
//  private DefaultComboBoxModel everything;
//  private DefaultComboBoxModel education;
//  private DefaultComboBoxModel engineering;
//  private DefaultComboBoxModel health;
//  private DefaultComboBoxModel inter;
//  private DefaultComboBoxModel humanity;
//  private DefaultComboBoxModel social;

  private JCheckBox wanttoregister;

  
  public Search(Owner loggedin,Database database, JFrame frame){
    this.user=loggedin;
    this.database=database;
    this.results=new JPanel();
    this.frame=frame;
    this.usedbooks=new ArrayList<Book>();
    this.newbooks=new ArrayList<Book>();


  }
  //Before: nothing
  //After: creates the JPanel for the Search Form and displays it
  public void searchDialog()
  {
	frame.setTitle("Search");
	panel=null; //First we clear the panel just in case
	panel=new JPanel(); 
    JPanel searchpanel = new JPanel(); //The panel that shows the search conditions
    
    JLabel Iwanttoregister=new JLabel("I want to register a book");
    wanttoregister=new JCheckBox();
	//We create the group Layout for the panels and buttons
	GroupLayout panels= new GroupLayout(panel);
	panels.setAutoCreateGaps(true);
	panels.setAutoCreateContainerGaps(true);
	panel.setLayout(panels);
	GroupLayout.SequentialGroup horiGroup=panels.createSequentialGroup();
	GroupLayout.ParallelGroup pan = panels.createParallelGroup(GroupLayout.Alignment.LEADING);
    GroupLayout.ParallelGroup buttonpan=panels.createParallelGroup();
    GroupLayout.ParallelGroup logoutpan=panels.createParallelGroup();

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
	GroupLayout.ParallelGroup searchpan=panels.createParallelGroup();
    GroupLayout.ParallelGroup resultpan=panels.createParallelGroup();
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
    GroupLayout.ParallelGroup labels=inputs.createParallelGroup(GroupLayout.Alignment.LEADING); //One for Labels
    GroupLayout.ParallelGroup fields=inputs.createParallelGroup(GroupLayout.Alignment.LEADING); //Other for values/field
   
    JButton searchButton = new JButton("Search");
    JLabel titleLabel = new JLabel ("Book title");
    labels.addComponent(titleLabel);
    
    JLabel authorLabel = new JLabel ("Author");
    labels.addComponent(authorLabel);
    
    JLabel isbnLabel = new JLabel ("ISBN");
    labels.addComponent(isbnLabel);
    
    JLabel categoryLabel= new JLabel ("Faculty");
    labels.addComponent(categoryLabel);
    
    JLabel subcategoryLabel =new JLabel("Programme");
    labels.addComponent(subcategoryLabel);
        
    TitleText = new JTextField(20);
    fields.addComponent(TitleText,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
    
    AuthorText = new JTextField(20);
    fields.addComponent(AuthorText,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
    
    isbnText = new JTextField(20);
    fields.addComponent(isbnText,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
    
    String[] faculty = {"","Education","Engineering", "Health", "Humanity","Social", "Inter"};
    categoryText = new JComboBox(faculty);

    fields.addComponent(categoryText,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
    categoryText.addActionListener(this);
    subcategoryText = new JComboBox();
    fields.addComponent(subcategoryText,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
    
    models[0] = new DefaultComboBoxModel(new String[]{"","ÖLL FÖGIN"});
    models[1] = new DefaultComboBoxModel(new String[]{"","education 1", "education 2", "education 3"});
    models[2] = new DefaultComboBoxModel(new String[]{"","engineering 1", "engineering 2", "engineering 3"});
    models[3] = new DefaultComboBoxModel(new String[]{"","health 1", "health 2", "health 3"});
    models[4] = new DefaultComboBoxModel(new String[]{"","humanity 1", "humanity 2", "humanity 3"});
    models[5] = new DefaultComboBoxModel(new String[]{"","social 1", "social 2", "social 3"});
    models[6] = new DefaultComboBoxModel(new String[]{"","inter 1", "inter 2", " inter 3"});
    
    subcategoryText.setModel(models[0]);


    
//    everything = new DefaultComboBoxModel(new String[]{"","ÖLL FÖGIN"});
//    education = new DefaultComboBoxModel(new String[]{"","education 1", "education 2", "education 3"});
//    engineering = new DefaultComboBoxModel(new String[]{"","engineering 1", "engineering 2", "engineering 3"});
//    health = new DefaultComboBoxModel(new String[]{"","health 1", "health 2", "health 3"});
//    humanity = new DefaultComboBoxModel(new String[]{"","humanity 1", "humanity 2", "humanity 3"});
//    inter = new DefaultComboBoxModel(new String[]{"","inter 1", "inter 2", " inter 3"});
//    social = new DefaultComboBoxModel(new String[]{"","social 1", "social 2", "social 3"});


    labels.addComponent(Iwanttoregister);
    fields.addComponent(wanttoregister);
    fields.addComponent(searchButton);
    
    hGroup.addGroup(labels);
    hGroup.addGroup(fields);
    
    inputs.setHorizontalGroup(hGroup);
    
    GroupLayout.SequentialGroup vGroup = inputs.createSequentialGroup();
    
    GroupLayout.ParallelGroup IsbnGroup=inputs.createParallelGroup(GroupLayout.Alignment.CENTER);
    GroupLayout.ParallelGroup TitleGroup=inputs.createParallelGroup(GroupLayout.Alignment.CENTER);
    GroupLayout.ParallelGroup AuthorGroup=inputs.createParallelGroup(GroupLayout.Alignment.CENTER);
    GroupLayout.ParallelGroup CategoryGroup=inputs.createParallelGroup(GroupLayout.Alignment.CENTER);
    GroupLayout.ParallelGroup SubCategoryGroup=inputs.createParallelGroup(GroupLayout.Alignment.CENTER);
	GroupLayout.ParallelGroup registerGroup=inputs.createParallelGroup(GroupLayout.Alignment.CENTER);
    GroupLayout.ParallelGroup buttonGroup=inputs.createParallelGroup(GroupLayout.Alignment.CENTER);
    IsbnGroup.addComponent(isbnLabel);
    IsbnGroup.addComponent(isbnText,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
    TitleGroup.addComponent(titleLabel);
    TitleGroup.addComponent(TitleText,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
    AuthorGroup.addComponent(authorLabel);
    AuthorGroup.addComponent(AuthorText,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
    CategoryGroup.addComponent(categoryLabel);
    CategoryGroup.addComponent(categoryText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
    SubCategoryGroup.addComponent(subcategoryLabel);
    SubCategoryGroup.addComponent(subcategoryText,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
	buttonGroup.addComponent(searchButton);
	registerGroup.addComponent(Iwanttoregister);
	registerGroup.addComponent(wanttoregister);
	registerGroup.addGap(50);
	buttonGroup.addGap(50);
    vGroup.addGroup(IsbnGroup);
    vGroup.addGroup(TitleGroup);
    vGroup.addGroup(AuthorGroup);
    vGroup.addGroup(CategoryGroup);
    vGroup.addGroup(SubCategoryGroup);
    vGroup.addGroup(registerGroup);
    vGroup.addGroup(buttonGroup);
    inputs.setVerticalGroup(vGroup);
    
    searchButton.setActionCommand("search");
    searchButton.addActionListener(this);
    
    scrollpane = new JScrollPane(panel);
    frame.add(scrollpane);
    frame.setVisible(true);
  }
  
  public void shownewbooks(){
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
	  GroupLayout.ParallelGroup resultGroupTitle[]= new GroupLayout.ParallelGroup[newbooks.size()];
	  GroupLayout.ParallelGroup resultGroupAuthor[]=new GroupLayout.ParallelGroup[newbooks.size()];
	  GroupLayout.ParallelGroup resultGroupPrice[]=new GroupLayout.ParallelGroup[newbooks.size()];
	  JLabel BookNameLabel[]=new JLabel[newbooks.size()];
	  JLabel BookAuthorLabel[]=new JLabel[newbooks.size()];
	  JLabel BookPriceLabel[]=new JLabel[newbooks.size()];
	  JButton RegisterButton[]=new JButton[newbooks.size()];

	  String isbn="";
	  for(int i = 0; i<newbooks.size(); i++){
		  resultGroupTitle[i]=result.createParallelGroup();
		  resultGroupAuthor[i]=result.createParallelGroup();
		  resultGroupPrice[i]=result.createParallelGroup();
		  resultGroupPrice[i].addGap(50);

		  
		  JLabel TitleLabel= new JLabel("Title:");
		  JLabel AuthorLabel = new JLabel("Author:");
		  JLabel PriceLabel= new JLabel("Price:");
		  BookNameLabel[i] = new JLabel(newbooks.get(i).getName());
		  BookAuthorLabel[i] = new JLabel(newbooks.get(i).getAuthor());
		  BookPriceLabel[i] = new JLabel(newbooks.get(i).getPrice());
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
  //Use: showbooks();
  //Before: Nothing
  //After: The information in Search.books[] has been displayed on the JPanel
  public void showbooks(){
	  frame.setTitle("Search");
	  results.removeAll(); //remove previous results
	  GroupLayout result =new GroupLayout(results);
	  results.setLayout(result);
	  result.setAutoCreateGaps(true);
	  result.setAutoCreateContainerGaps(true);
	  
	  GroupLayout.SequentialGroup hGroup = result.createSequentialGroup();
	  GroupLayout.ParallelGroup labels=result.createParallelGroup(); //One for Labels
	  GroupLayout.ParallelGroup values=result.createParallelGroup(); //One for Labels
	  
	  GroupLayout.SequentialGroup vGroup = result.createSequentialGroup();
	  GroupLayout.ParallelGroup resultGroupTitle[]= new GroupLayout.ParallelGroup[usedbooks.size()];
	  GroupLayout.ParallelGroup resultGroupAuthor[]=new GroupLayout.ParallelGroup[usedbooks.size()];
	  GroupLayout.ParallelGroup resultGroupPrice[]=new GroupLayout.ParallelGroup[usedbooks.size()];
	  GroupLayout.ParallelGroup resultGroupCondition[] = new GroupLayout.ParallelGroup[usedbooks.size()];
	  GroupLayout.ParallelGroup seller[] = new GroupLayout.ParallelGroup[usedbooks.size()];
	  GroupLayout.ParallelGroup email[] = new GroupLayout.ParallelGroup[usedbooks.size()];
	  
	  JLabel BookNameLabel[]=new JLabel[usedbooks.size()];
	  JLabel BookAuthorLabel[]=new JLabel[usedbooks.size()];
	  JLabel BookPriceLabel[]=new JLabel[usedbooks.size()];
	  JLabel BookConditionLabel[] = new JLabel[usedbooks.size()];
	  JButton[] BookSellerLabel=new JButton[usedbooks.size()];

	  String isbn="";
	  for(int i = 0; i<usedbooks.size(); i++){
		  resultGroupTitle[i]=result.createParallelGroup();
		  resultGroupAuthor[i]=result.createParallelGroup();
		  resultGroupPrice[i]=result.createParallelGroup();
		  resultGroupCondition[i]=result.createParallelGroup();
		  seller[i]=result.createParallelGroup(GroupLayout.Alignment.BASELINE);
		  email[i]=result.createParallelGroup();
		  email[i].addGap(50);

		  
		  JLabel TitleLabel= new JLabel("Title:");
		  JLabel AuthorLabel = new JLabel("Author:");
		  JLabel PriceLabel= new JLabel("Price:");
		  JLabel SellerLabel=new JLabel("Owner:");
		  JLabel ConditionLabel = new JLabel("Condition:");
		  
		  BookNameLabel[i] = new JLabel(usedbooks.get(i).getName());
		  BookAuthorLabel[i] = new JLabel(usedbooks.get(i).getAuthor());
		  BookPriceLabel[i] = new JLabel(usedbooks.get(i).getPrice());
		  BookSellerLabel[i]=new JButton(usedbooks.get(i).getOwner().getName());
		  BookSellerLabel[i].setBorderPainted(false);
		  BookSellerLabel[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
		  BookConditionLabel[i]=new JLabel(usedbooks.get(i).getCondition());
		  labels.addComponent(TitleLabel);
		  labels.addComponent(AuthorLabel);
		  labels.addComponent(PriceLabel);
		  labels.addComponent(ConditionLabel);
		  labels.addComponent(SellerLabel);
		  values.addComponent(BookNameLabel[i]);
		  values.addComponent(BookAuthorLabel[i]);
		  values.addComponent(BookPriceLabel[i]);
		  values.addComponent(BookConditionLabel[i]);
		  values.addComponent(BookSellerLabel[i]);
		  
		  resultGroupTitle[i].addComponent(TitleLabel);
		  resultGroupTitle[i].addComponent(BookNameLabel[i]);
		  resultGroupAuthor[i].addComponent(AuthorLabel);
		  resultGroupAuthor[i].addComponent(BookAuthorLabel[i]);
		  resultGroupPrice[i].addComponent(PriceLabel);
		  resultGroupPrice[i].addComponent(BookPriceLabel[i]);
		  resultGroupCondition[i].addComponent(ConditionLabel);
		  resultGroupCondition[i].addComponent(BookConditionLabel[i]);
		  seller[i].addComponent(SellerLabel);
		  seller[i].addComponent(BookSellerLabel[i]);
		  vGroup.addGroup(resultGroupTitle[i]);
		  vGroup.addGroup(resultGroupAuthor[i]);
		  vGroup.addGroup(resultGroupPrice[i]);
		  vGroup.addGroup(resultGroupCondition[i]);
		  vGroup.addGroup(seller[i]);
		  vGroup.addGroup(email[i]);
	  }
	  hGroup.addGroup(labels);
	  hGroup.addGroup(values);
	  result.setHorizontalGroup(hGroup);
	  result.setVerticalGroup(vGroup);
	  panel.revalidate(); //let the scroll pane know that changes have been made
	  frame.setVisible(true);
  }
  
  //Use: b=isloggedin();
  //Before: nothing
  //After: returns true if there is someone logged in, false otherwise
  public boolean isloggedin(){
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

//	  String category=categoryText.getText();
//	  String subcategory=subcategoryText.getText();

	  String category=categoryText.getSelectedItem().toString();

	  Boolean register= wanttoregister.isSelected();
	  //if there are no fields filled out, there is nothing to look for
	  if(Title.isEmpty()&&Author.isEmpty()&&isbn.isEmpty()){
		  JOptionPane.showMessageDialog(frame,
				    "Please type in search conditions!",
				    "Missing search conditions",
				    JOptionPane.INFORMATION_MESSAGE);
	  }
	  else{
		  Book searchfor = new Book(Title, Author, isbn);
		  newbooks=database.search(searchfor);
		  if(!register){
			  usedbooks=database.search(searchfor);
		  }
		  if(usedbooks.size()==0 && newbooks.size()==0){
			  JOptionPane.showMessageDialog(frame,
					  "No search results!",
					  "No results",
					  JOptionPane.INFORMATION_MESSAGE);
		  }
		  else{
			  Collections.sort(usedbooks, new Comparator<Book>() {
			        @Override
			        public int compare(Book  book1, Book  book2)
			        {

			            return  book1.getPrice().compareTo(book2.getPrice());
			        }
			    });
			  Collections.sort(newbooks, new Comparator<Book>() {
			        @Override
			        public int compare(Book  book1, Book  book2)
			        {

			            return  book1.getPrice().compareTo(book2.getPrice());
			        }
			    });
			  if(register){
				  shownewbooks();
			  }
			  else{
				  showbooks();
			  }

		  }
	  }
  }
  
  public void actionPerformed(ActionEvent e){
	  int k = categoryText.getSelectedIndex();
	  subcategoryText.setModel(models[k]);
//	  if ("All faculties".equals(categoryText.getSelectedItem())){
//			subcategoryText.setModel(everything);    
//	      }
//	  if ("Education".equals(categoryText.getSelectedItem())){
//		subcategoryText.setModel(education);    
//      }
//	  if ("Health".equals(categoryText.getSelectedItem())){
//			subcategoryText.setModel(health);    
//	      }
//	  if ("Engineering".equals(categoryText.getSelectedItem())){
//			subcategoryText.setModel(engineering);    
//	      }
//	  if ("Inter".equals(categoryText.getSelectedItem())){
//			subcategoryText.setModel(inter);    
//	      }
//	  if ("Humanity".equals(categoryText.getSelectedItem())){
//			subcategoryText.setModel(humanity);    
//	      }
//	  if ("Social".equals(categoryText.getSelectedItem())){
//			subcategoryText.setModel(social);    
//	      }
	  

	  String command=e.getActionCommand();
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
//		  Search newsearch = new Search(null,database,frame);
//		  newsearch.searchDialog();
//		  frame.remove(scrollpane);
//		  panel=null;
//		  View.search.searchDialog();
		  user.setloggedin(false);
		  frame.remove(scrollpane);
		  searchDialog();		  
	  }
	  if(newbooks!=null){
		  for(int i=0; i<newbooks.size(); i++){
			  if(("register"+i).equals(command))
			  {	
				  if(isloggedin()){
					  RegistrationForm registerform = new RegistrationForm(newbooks.get(i), frame, database);
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