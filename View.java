
public class View {
	public Owner loggedin;
	public static void main(String[] args){
		View view = new View();
		Search search=new Search(view.loggedin);
		search.searchDialog();
	}
}
