 import java.awt.*;
import java.awt.event.*;
 
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
 
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
 
import java.text.*;
import javax.swing.JFrame;

public class RegistrationForm extends JPanel {
	private Book registerbook;
	
	public RegistrationForm(Book x){
		initUI();
		this.registerbook=x;
	}
	private void initUI(){
		JLabel BookNameLabel=new JLabel("Name of Book: " + this.registerbook.Name);
		JLabel AuthorLabel=new JLabel("Name of Author: "+ this.registerbook.Author);
		JFormattedTextField nameField = new JFormattedTextField(NumberFormat.getNumberInstance());
		
	}

}
