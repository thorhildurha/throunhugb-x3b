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
public class SearchKolbrun extends JFrame
{
private Owner user;
private Database database;
private JPanel panel;
private JFrame frame;
private Book[] books;
private JPanel results;
public SearchKolbrun(Owner loggedin,Database database, JFrame frame){
this.user=loggedin;
this.database=database;
this.frame=frame;
searchDialog();
}
public static void main(String[] args)
{
Owner lol=new Owner();
JFrame frame = new JFrame();
frame.setSize(300, 150);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
MockDatabase database = new MockDatabase();
Search search = new Search(lol, database,frame);
}
public void searchDialog()
{
panel=new JPanel();
JPanel searchpanel = new JPanel();
results = new JPanel();
GroupLayout inputs=new GroupLayout(searchpanel);
inputs.setAutoCreateGaps(true);
inputs.setAutoCreateContainerGaps(true);
GroupLayout.SequentialGroup hGroup = inputs.createSequentialGroup();
searchpanel.setLayout(inputs);
GroupLayout.ParallelGroup labels=inputs.createParallelGroup(); //One for Labels
GroupLayout.ParallelGroup fields=inputs.createParallelGroup(); //Other for values/fields
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
JTextField titleText = new JTextField(20);
fields.addComponent(titleText,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
JTextField authorText = new JTextField(20);
fields.addComponent(authorText,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
JTextField isbnText = new JTextField(20);
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
TitleGroup.addComponent(titleText,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
AuthorGroup.addComponent(authorLabel);
AuthorGroup.addComponent(authorText,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
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
if public void isloggedin(){
  JButton mypages = new JButton("My pages");
  mypagesbutton.addComponent(mypages);
}
else{
  JButton login = new JButton("login");
  loginbutton.addComponent(login);
}
ActionListener searchButtonListener = new ActionListener()
{
@Override
public void actionPerformed(ActionEvent e)
{
JButton source = (JButton) e.getSource();
books = new Book[2];
Book searchfor = new Book(titleText.getText(), authorText.getText(),isbnText.getText());
books=database.search(searchfor);
showbooks();
}
}
ActionListener mypagesButtonListener = new ActionListener()
{
  @Override
  public void actionPerformed(ActionEvent e)
  {
  MyPages = MyPages.MyPages();
  }

ActionListener loginListener = new ActionListener()
{
  @Override
  public void actionPerformed(ActionEvent e)
  {
    login = Login.loginDialog();
  }
}
searchButton.addActionListener(searchButtonListener);
panel.add(searchpanel);
panel.add(results);
frame.add(panel);
frame.setVisible(true);
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
if(!isbn.equals(books[i].getIsbn())){
JButton register = new JButton("register");
isbn=books[i].getIsbn();
registerbutton.addComponent(register);
resultGroupAuthor[i].addComponent(register);


}
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
ActionListener registerButtonListener = new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
JButton source = (JButton) e.getSource();
NewUserForm();
frame.setVisible(false);
frame.dispose();

public Boolean isloggedin(){
if(this.user!=null){
return true;
}
else{
return false;
}
}

