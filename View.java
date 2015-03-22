import javax.swing.JFrame;
import javax.swing.JPanel;


public class View {
	private static Owner loggedin = new Owner();
	
	public static void main(String[] args){
		View view = new View();
		loggedin.setName("Þórhildur Hafsteinsdóttir");
		loggedin.setLocation("Reykjavík");
		loggedin.setEmail("totan@gmail.com");
		loggedin.setPhone("6666666");
		loggedin.setUsername("totahotty");
		MockDatabase database=new MockDatabase();
		JFrame frame = new JFrame();
		frame.setSize(300,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyPages mypages = new MyPages(frame,loggedin,database);
		frame.add(mypages.panel);
		frame.setVisible(true);
	}
}
