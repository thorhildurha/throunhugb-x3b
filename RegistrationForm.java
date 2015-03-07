import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import java.awt.Container;

import javax.swing.JComponent;
import javax.swing.GroupLayout;

public class RegistrationForm extends JPanel{
	private Book registerbook; //The book to register
	private JFrame frame; //The frame for the program 
	private JPanel buttonpanel;
	private JPanel center;
	
	public RegistrationForm(Book x, JFrame frame){
		this.registerbook=x;
		this.frame=frame;
		initUI();	
	}
	private void initUI(){
		frame.setTitle("Registration Form"); // Set a new title to the frame
		//Create elements
		buttonpanel=new JPanel();
		JPanel labelpane=new JPanel();
		center=new JPanel();
		BoxLayout centering=new BoxLayout(center,BoxLayout.Y_AXIS);
		center.setLayout(centering);
		
		JLabel NameLabel= new JLabel("Name: ");
		JLabel NameVal=new JLabel(this.registerbook.Name);
		JLabel AuthorLabel=new JLabel("Author: ");
		JLabel AuthorVal = new JLabel(this.registerbook.Author);
		JLabel IsbnLabel=new JLabel("ISBN: ");
		JLabel IsbnVal=new JLabel(this.registerbook.ISBN);
		JLabel price=new JLabel("Price:");
		JLabel conditionLabel = new JLabel("Condition:");
		JTextField pricefield=new JTextField();
		String[] conditions={"like new","very good","good","fair","bad","very bad"};
		JComboBox conditionField=new JComboBox(conditions);
		JButton register=new JButton("Register");
		register.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String inputprice=pricefield.getText();
				String inputcondition=conditionField.getSelectedItem().toString();
				Boolean registered=registerbook.register(inputprice,inputcondition);
				if(registered){
					frame.remove(buttonpanel);
					frame.remove(center);
					frame.validate();
					frame.repaint();
					JOptionPane.showMessageDialog(frame, "Thank you! \n We have successfully registered your book");
				}
				else{
					JOptionPane.showMessageDialog(frame,
						    "Something went wrong! \n Please try again",
						    "Registration Error",
						    JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		//Create Groups for Labels and values/inputfields
		GroupLayout inputs=new GroupLayout(labelpane);
		labelpane.setLayout(inputs);
		inputs.setAutoCreateGaps(true);
		//First Sequential Group
		GroupLayout.SequentialGroup hGroup = inputs.createSequentialGroup();
		GroupLayout.ParallelGroup labels=inputs.createParallelGroup(); //One for Labels
		GroupLayout.ParallelGroup fields=inputs.createParallelGroup(); //Other for values/fields
		labels.addComponent(IsbnLabel);
		labels.addComponent(NameLabel);
		labels.addComponent(AuthorLabel);
		labels.addComponent(price);
		labels.addComponent(conditionLabel);
		fields.addComponent(IsbnVal);
		fields.addComponent(NameVal);
		fields.addComponent(AuthorVal);
		fields.addComponent(pricefield,GroupLayout.DEFAULT_SIZE,100,GroupLayout.PREFERRED_SIZE);
		fields.addComponent(conditionField,GroupLayout.DEFAULT_SIZE,100,GroupLayout.PREFERRED_SIZE);
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
		vGroup.addGroup(IsbnGroup);
		vGroup.addGroup(NameGroup);
		vGroup.addGroup(AuthorGroup);
		vGroup.addGroup(priceGroup);
		vGroup.addGroup(conditionGroup);
		inputs.setVerticalGroup(vGroup);
		
		buttonpanel.setSize(50, 30);
		buttonpanel.add(register);
		center.add(labelpane);
		frame.add(center);
		frame.add(buttonpanel,BorderLayout.PAGE_END);
		frame.setVisible(true);
	}
	
	public static void main(String[] args){
		Book register=new Book("Litla gula hænan","Andrés Pétursson","02024");
		JFrame frame = new JFrame("Your app");
		frame.setSize(300,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		EventQueue.invokeLater(new Runnable() {
	        
            @Override
            public void run() {
                RegistrationForm ex = new RegistrationForm(register,frame);
            }
        });
	}
	
	

}
