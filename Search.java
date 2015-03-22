import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class Search extends JFrame
{
  private Owner user;
  
  public Search(Owner loggedin){
    this.user=loggedin;
  }

  public static void main(String[] args)
  { 
    Owner lol=new Owner();
    new Search(lol).searchDialog();
  }

  public void searchDialog()
  {
    JFrame frame = new JFrame ("Book search");
    frame.setSize (400, 200);
    placeSearchcomponents(frame);
    frame.setVisible(true);
  }
  private static void placeSearchcomponents (JFrame frame)
  {
    JPanel buttonpanel=new JPanel();
    JPanel inputpanel=new JPanel();
    GroupLayout inputs=new GroupLayout(inputpanel);
    inputs.setAutoCreateGaps(true);
    GroupLayout.SequentialGroup hGroup = inputs.createSequentialGroup();
    inputpanel.setLayout(inputs);
    GroupLayout.ParallelGroup labels=inputs.createParallelGroup(); //One for Labels
    GroupLayout.ParallelGroup fields=inputs.createParallelGroup(); //Other for values/fields

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
    
    hGroup.addGroup(labels);
    hGroup.addGroup(fields);
    
    inputs.setHorizontalGroup(hGroup);
    
    GroupLayout.SequentialGroup vGroup = inputs.createSequentialGroup();
    
    GroupLayout.ParallelGroup IsbnGroup=inputs.createParallelGroup(GroupLayout.Alignment.CENTER);
    GroupLayout.ParallelGroup TitleGroup=inputs.createParallelGroup(GroupLayout.Alignment.CENTER);
    GroupLayout.ParallelGroup AuthorGroup=inputs.createParallelGroup(GroupLayout.Alignment.CENTER);
    GroupLayout.ParallelGroup CourseGroup=inputs.createParallelGroup(GroupLayout.Alignment.CENTER);
    GroupLayout.ParallelGroup PriceGroup=inputs.createParallelGroup(GroupLayout.Alignment.CENTER);
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
    
    vGroup.addGroup(IsbnGroup);
    vGroup.addGroup(TitleGroup);
    vGroup.addGroup(AuthorGroup);
    vGroup.addGroup(CourseGroup);
    vGroup.addGroup(PriceGroup);
    inputs.setVerticalGroup(vGroup);
    JButton searchButton = new JButton("Search");
    searchButton.setBounds(10, 80, 80, 25);
    buttonpanel.add(searchButton);

    ActionListener searchButtonListener = new ActionListener()
    {
    	@Override
        public void actionPerformed(ActionEvent e)
        {
    		JButton source = (JButton) e.getSource();
    		JOptionPane.showMessageDialog(source, source.getText() + " button has been pressed");	
    		
//            leit.leitarfunction();
        }
    };
    searchButton.addActionListener(searchButtonListener);


    frame.add(inputpanel);
    frame.add(buttonpanel,BorderLayout.SOUTH);
  }
  public Boolean isloggedin(){
    if(this.user!=null){
      return true;
    }
    else{
      return false;
    }
  }
}