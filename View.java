import javax.swing.JFrame;
import javax.swing.JPanel;


public class View {
	private static Owner loggedin; //We do not want to put public here because then it is global
								   //Now this is a private static variable in the view class
	public static JFrame frame=new JFrame(); //We only want one application window named frame	
	public static MyPages mypage;  //We only want one mypage, that we can change
	public static Search search;
	public final static Database database = new MockDatabase(); //And one final database
	
	public View(){
		frame = new JFrame();
	    search = new Search(loggedin, database,frame);
	    Setup();
	}
	public static void main(String[] args){
		View view = new View();
	}
	public void Setup(){
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JPanel searchpanel=search.searchDialog();
	    frame.add(searchpanel);
	    frame.setVisible(true);

	}
}
