import java.awt.Component;
import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		JLabel titleLabel = new JLabel ("Book title");
		titleLabel.setBounds(10, 10, 80, 35);
		frame.add(titleLabel);
		JTextField titleText = new JTextField(30);
		titleText.setBounds(100, 10, 160, 35);
		frame.add(titleText);
		
		JLabel authorLabel = new JLabel ("Author");
		authorLabel.setBounds(10, 40, 80, 35);
		frame.add(authorLabel);
		JTextField authorText = new JTextField(30);
		authorText.setBounds(100, 40, 160, 35);
		frame.add(authorText);
		
		JLabel isbnLabel = new JLabel ("ISBN");
		isbnLabel.setBounds(10, 70, 80, 35);
		frame.add(isbnLabel);
		JTextField isbnText = new JTextField(30);
		isbnText.setBounds(100, 70, 160, 35);
		frame.add(isbnText);
		
		JLabel courseLabel= new JLabel ("Course");
		courseLabel.setBounds(10, 100, 80, 35);
		frame.add(courseLabel);
		JTextField courseText = new JTextField(30);
		courseText.setBounds(100, 100, 160, 35);
		frame.add(courseText);
		
		JButton searchButton = new JButton("Search");
    searchButton.setBounds(10, 80, 80, 25);
    frame.add(searchButton);
}
}