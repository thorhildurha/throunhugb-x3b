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
	public static void main(String[] args)
	{
		new Search().searchDialog();
	}
	public void searchDialog()
	{
		JFrame frame = new JFrame ("Book search");
		frame.setSize (300, 150);
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
		
		JTextField titleText = new JTextField(20);
		fields.addComponent(titleText);
		
		JTextField authorText = new JTextField(20);
		fields.addComponent(authorText);
		
		JTextField isbnText = new JTextField(20);
		fields.addComponent(isbnText);
		
		JTextField courseText = new JTextField(20);
		fields.addComponent(courseText);
		hGroup.addGroup(labels);
		hGroup.addGroup(fields);
		
		inputs.setHorizontalGroup(hGroup);
		
		GroupLayout.SequentialGroup vGroup = inputs.createSequentialGroup();
		
		GroupLayout.ParallelGroup IsbnGroup=inputs.createParallelGroup(GroupLayout.Alignment.CENTER);
		GroupLayout.ParallelGroup TitleGroup=inputs.createParallelGroup(GroupLayout.Alignment.CENTER);
		GroupLayout.ParallelGroup AuthorGroup=inputs.createParallelGroup(GroupLayout.Alignment.CENTER);
		GroupLayout.ParallelGroup CourseGroup=inputs.createParallelGroup(GroupLayout.Alignment.CENTER);
		IsbnGroup.addComponent(isbnLabel);
		IsbnGroup.addComponent(isbnText);
		TitleGroup.addComponent(titleLabel);
		TitleGroup.addComponent(titleText);
		AuthorGroup.addComponent(authorLabel);
		AuthorGroup.addComponent(authorText);
		CourseGroup.addComponent(courseLabel);
		CourseGroup.addComponent(courseText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);		
		vGroup.addGroup(IsbnGroup);
		vGroup.addGroup(TitleGroup);
		vGroup.addGroup(AuthorGroup);
		vGroup.addGroup(CourseGroup);
		inputs.setVerticalGroup(vGroup);
		JButton searchButton = new JButton("Search");
		searchButton.setBounds(10, 80, 80, 25);
		buttonpanel.add(searchButton);
		frame.add(inputpanel);
		frame.add(buttonpanel,BorderLayout.SOUTH);
}
}
