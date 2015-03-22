import javax.swing.JFrame;
import javax.swing.JPanel;


public class View {
	private static Owner loggedin; //We do not want to put public here because then it is global
								   //Now this is a private static variable in the view class
	public static JFrame frame=new JFrame(); //We only want one application window named frame	
	public static MyPages mypage;                  //We only want one mypage, that we can change
	public final static Database database = new MockDatabase(); //And one final database
	
	public static void main(String[] args){
		View view = new View();
		loggedin=new Owner();
		loggedin.setName("Þórhildur Hafsteinsdóttir");
		loggedin.setLocation("Reykjavík");
		loggedin.setEmail("totan@gmail.com");
		loggedin.setPhone("6666666");
		loggedin.setUsername("totahotty");
		frame.setSize(300,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mypage = new MyPages(loggedin);
		frame.add(mypage.panel);
		frame.setVisible(true);
	}
}
