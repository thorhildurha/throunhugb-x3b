import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Container;

import javax.swing.JComponent;
import javax.swing.GroupLayout;

public class RegistrationForm extends JFrame{
	private Book registerbook;
	
	public RegistrationForm(Book x){
		this.registerbook=x;
		initUI();	
	}
	private void initUI(){
		JFrame frame = new JFrame("Registration Form");
		frame.setSize(300,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel buttonpanel=new JPanel();
		JPanel labelpane=new JPanel();
		JLabel price=new JLabel("Price");
		JLabel condition = new JLabel("Condition");
		JTextField pricefield=new JTextField();
		JTextField conditionField=new JTextField(3);
		JLabel BookName= new JLabel("Name: ");
		JLabel name=new JLabel(this.registerbook.Name);
		GroupLayout inputs=new GroupLayout(labelpane);
		labelpane.setLayout(inputs);
		inputs.setAutoCreateGaps(true);
		GroupLayout.SequentialGroup hGroup = inputs.createSequentialGroup();
		GroupLayout.ParallelGroup labels=inputs.createParallelGroup();
		GroupLayout.ParallelGroup fields=inputs.createParallelGroup();
		labels.addComponent(BookName);
		labels.addComponent(price);
		labels.addComponent(condition);
		fields.addComponent(name);
		fields.addComponent(pricefield,GroupLayout.DEFAULT_SIZE,100,GroupLayout.PREFERRED_SIZE);
		fields.addComponent(conditionField);
		hGroup.addGroup(labels);
		hGroup.addGroup(fields);
		inputs.setHorizontalGroup(hGroup);
		GroupLayout.SequentialGroup vGroup = inputs.createSequentialGroup();
		GroupLayout.ParallelGroup priceGroup=inputs.createParallelGroup();
		GroupLayout.ParallelGroup conditionGroup=inputs.createParallelGroup();
		GroupLayout.ParallelGroup nameGroup= inputs.createParallelGroup();
		nameGroup.addComponent(BookName);
		nameGroup.addComponent(name);
		priceGroup.addComponent(price);
		priceGroup.addComponent(pricefield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);		
		conditionGroup.addComponent(condition);
		conditionGroup.addComponent(conditionField,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
		vGroup.addGroup(priceGroup);
		vGroup.addGroup(conditionGroup);
		vGroup.addGroup(nameGroup);
		inputs.setVerticalGroup(vGroup);
		buttonpanel.setSize(50, 30);
		JButton register=new JButton("Register");
		buttonpanel.add(register);
		JLabel AuthorName=new JLabel("Author: " + this.registerbook.Author);
		JLabel ISBN=new JLabel("ISBN: " + this.registerbook.ISBN);
		labelpane.add(ISBN);
		labelpane.add(BookName);
		labelpane.add(AuthorName);
		frame.add(labelpane);
		frame.add(buttonpanel,BorderLayout.PAGE_END);
		frame.setVisible(true);
	}
	public static void main(String[] args){
		Book register=new Book("Litla gula hænan","Andrés Pétursson","02024");
		EventQueue.invokeLater(new Runnable() {
	        
            @Override
            public void run() {
                RegistrationForm ex = new RegistrationForm(register);
            }
        });
	}

}
