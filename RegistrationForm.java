import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
		JPanel inputpane=new JPanel();
		inputpane.setLayout(new BoxLayout(inputpane,BoxLayout.Y_AXIS));
		buttonpanel.setSize(50, 30);
		JButton register=new JButton("Register");
		buttonpanel.add(register);
		JLabel BookName= new JLabel("Name: " + this.registerbook.Name);
		JLabel AuthorName=new JLabel("Author: " + this.registerbook.Author);
		JLabel ISBN=new JLabel("ISBN: " + this.registerbook.ISBN);
		inputpane.add(ISBN);
		inputpane.add(BookName);
		inputpane.add(AuthorName);
		frame.add(inputpane);
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
