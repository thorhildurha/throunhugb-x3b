import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Update extends JPanel{
	private Database database;
	private Book registerbook; //The book to update
	private JFrame frame; //The frame for the program 
	private JPanel buttonpanel;
	private JPanel center;
	
	public Update(Book x, JFrame frame, Database data){
		this.registerbook=x;
		this.frame=frame;
		this.database=data;
	}
	public JPanel initUI(){
		frame.setTitle("Update"); // Set a new title to the frame
		//Create elements
		JPanel labelpane=new JPanel();
		center=new JPanel();
		BoxLayout centering=new BoxLayout(center,BoxLayout.Y_AXIS);
		center.setLayout(centering);

		JLabel SoldLabel= new JLabel("Sold:");
		JCheckBox Sold = new JCheckBox();
		JLabel NameLabel= new JLabel("Name: ");
		JLabel NameVal=new JLabel(this.registerbook.getName());
		JLabel AuthorLabel=new JLabel("Author: ");
		JLabel AuthorVal = new JLabel(this.registerbook.getAuthor());
		JLabel IsbnLabel=new JLabel("ISBN: ");
		JLabel IsbnVal=new JLabel(this.registerbook.getIsbn());
		JLabel price=new JLabel("Price:");
		JLabel conditionLabel = new JLabel("Condition:");
		JTextField pricefield=new JTextField(registerbook.getPrice());
		String[] conditions={"like new","very good","good","fair","bad","very bad"};
		JComboBox conditionField=new JComboBox(conditions);
		JButton update=new JButton("Update");
		
		//Create Groups for Labels and values/inputfields
		GroupLayout inputs=new GroupLayout(labelpane);
		labelpane.setLayout(inputs);
		inputs.setAutoCreateGaps(true);
		//First Sequential Group
		GroupLayout.SequentialGroup hGroup = inputs.createSequentialGroup();
		GroupLayout.ParallelGroup labels=inputs.createParallelGroup(); //One for Labels
		GroupLayout.ParallelGroup fields=inputs.createParallelGroup(); //Other for values/fields
		labels.addComponent(SoldLabel);
		labels.addComponent(IsbnLabel);
		labels.addComponent(NameLabel);
		labels.addComponent(AuthorLabel);
		labels.addComponent(price);
		labels.addComponent(conditionLabel);
		fields.addComponent(Sold);
		fields.addComponent(IsbnVal);
		fields.addComponent(NameVal);
		fields.addComponent(AuthorVal);
		fields.addComponent(pricefield,GroupLayout.DEFAULT_SIZE,100,GroupLayout.PREFERRED_SIZE);
		fields.addComponent(conditionField,GroupLayout.DEFAULT_SIZE,100,GroupLayout.PREFERRED_SIZE);
		fields.addComponent(update);
		
		hGroup.addGroup(labels);
		hGroup.addGroup(fields);
		//Then horizontal Group
		inputs.setHorizontalGroup(hGroup);
		GroupLayout.SequentialGroup vGroup = inputs.createSequentialGroup();
		
		GroupLayout.ParallelGroup IsbnGroup=inputs.createParallelGroup(GroupLayout.Alignment.CENTER);
		GroupLayout.ParallelGroup NameGroup=inputs.createParallelGroup(GroupLayout.Alignment.CENTER);
		GroupLayout.ParallelGroup AuthorGroup=inputs.createParallelGroup(GroupLayout.Alignment.CENTER);
		GroupLayout.ParallelGroup priceGroup=inputs.createParallelGroup(GroupLayout.Alignment.CENTER);
		GroupLayout.ParallelGroup conditionGroup=inputs.createParallelGroup(GroupLayout.Alignment.CENTER);
		GroupLayout.ParallelGroup buttonGroup=inputs.createParallelGroup(GroupLayout.Alignment.CENTER);
		GroupLayout.ParallelGroup soldGroup = inputs.createParallelGroup(GroupLayout.Alignment.CENTER);
		soldGroup.addComponent(SoldLabel);
		soldGroup.addComponent(Sold);
		IsbnGroup.addComponent(IsbnLabel);
		IsbnGroup.addComponent(IsbnVal);
		NameGroup.addComponent(NameLabel);
		NameGroup.addComponent(NameVal);
		AuthorGroup.addComponent(AuthorLabel);
		AuthorGroup.addComponent(AuthorVal);
		priceGroup.addComponent(price);
		priceGroup.addComponent(pricefield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);		
		conditionGroup.addComponent(conditionLabel);
		conditionGroup.addComponent(conditionField,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
		buttonGroup.addComponent(update);
		vGroup.addGroup(soldGroup);
		vGroup.addGroup(IsbnGroup);
		vGroup.addGroup(NameGroup);
		vGroup.addGroup(AuthorGroup);
		vGroup.addGroup(priceGroup);
		vGroup.addGroup(conditionGroup);
		vGroup.addGroup(buttonGroup);
		inputs.setVerticalGroup(vGroup);
		update.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String inputprice=pricefield.getText();
				String inputcondition=conditionField.getSelectedItem().toString();
				Boolean updated=registerbook.update(inputprice,inputcondition);
				Boolean registered = database.register(registerbook);
				if(updated&&registered){
					center.setVisible(false);
					Owner user= new Owner();
					MyPages mypage= new MyPages(frame, user , database);
					mypage.panel.setVisible(true);
					JOptionPane.showMessageDialog(frame, "Thank you! \n We have successfully updated your book");
					
				}
				else{
					JOptionPane.showMessageDialog(frame,
						    "Something went wrong! \n Please try again",
						    "Registration Error",
						    JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		center.add(labelpane);
		return center;

	}

	
	public static void main(String[] args){
		MockDatabase database=new MockDatabase();
		Book update=new Book("Litla gula h�nan","Andr�s P�tursson","02024");
		JFrame frame = new JFrame("Your app");
		frame.setSize(300,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		EventQueue.invokeLater(new Runnable() {
	        
            @Override
            public void run() {
                Update ex = new Update(update,frame,database);
                ex.initUI();
            }
        });
	}

}