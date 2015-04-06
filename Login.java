import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JDialog implements ActionListener{
	private Database database;
	private Owner newuser;
	private JDialog dialog;
	private JPanel loginpanel;
	private JPanel newuserpanel;
	private JTextField userText;
	private JPasswordField passwordText;
	
	public Login(Owner owner, Database data){
		this.newuser=owner;
		this.database = data;
		this.loginpanel = new JPanel();
		this.dialog = new JDialog();		
		loginDialog();
		owner=newuser;
	}
//	Use: new Login().loginDialog();
//	Before: nothing
//	After: loginDialog has been created
	public void loginDialog() {
		dialog.setSize(350,200);
	    GroupLayout inputs = new GroupLayout(loginpanel);
	    inputs.setAutoCreateGaps(true);
	    inputs.setAutoCreateContainerGaps(true);
	    GroupLayout.SequentialGroup hGroup = inputs.createSequentialGroup();
	    loginpanel.setLayout(inputs);
	    GroupLayout.ParallelGroup labels = inputs.createParallelGroup(); //One for Labels
	    GroupLayout.ParallelGroup fields = inputs.createParallelGroup(); //Other for values/fields
	    
	    JLabel userLabel = new JLabel("User");
	    labels.addComponent(userLabel);
	    
	    userText = new JTextField(20);
	    fields.addComponent(userText,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
	    
	    JLabel passwordLabel = new JLabel("Password");
	    labels.addComponent(passwordLabel);
	    
	    passwordText = new JPasswordField(20);
	    fields.addComponent(passwordText,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
	    
	    JButton loginButton = new JButton("login");
	    loginButton.setBounds(225, 80, 80, 25);
	    loginpanel.add(loginButton);
	    JButton signupButton = new JButton("sign up");
	    signupButton.setBounds(10, 80, 80, 25);
	    loginpanel.add(signupButton);
	    loginButton.setActionCommand("login");
	    loginButton.addActionListener(this);
	    signupButton.setActionCommand("newuser");
	    signupButton.addActionListener(this);
	    
	    hGroup.addGroup(labels);
	    hGroup.addGroup(fields);
	    
	    inputs.setHorizontalGroup(hGroup);
	    
	    GroupLayout.SequentialGroup vGroup = inputs.createSequentialGroup();  
	    GroupLayout.ParallelGroup UserGroup = inputs.createParallelGroup(GroupLayout.Alignment.CENTER);
	    GroupLayout.ParallelGroup PasswordGroup = inputs.createParallelGroup(GroupLayout.Alignment.CENTER);
	    
	    UserGroup.addComponent(userLabel);
	    UserGroup.addComponent(userText,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
	    PasswordGroup.addComponent(passwordLabel);
	    PasswordGroup.addComponent(passwordText,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE); 
	    
	    vGroup.addGroup(UserGroup);
	    vGroup.addGroup(PasswordGroup);

	    inputs.setVerticalGroup(vGroup);
		
		dialog.add(loginpanel);
		dialog.setVisible(true);
		
	}
	
//	Use: new Login().NewUserForm();
//	Before: nothing
//	After: NewUserForm has been created
	public void NewUserForm() {
		dialog.setSize(250,450);

		newuserpanel=new JPanel();
		
		JLabel nameLabel = new JLabel("Name *");
		nameLabel.setBounds(10, 10, 80, 25);
		newuserpanel.add(nameLabel);
		
		JTextField nameText = new JTextField(20);
		nameText.setBounds(100, 10, 160, 25);
		newuserpanel.add(nameText);
		
		JLabel emailLabel = new JLabel("Email *");
		emailLabel.setBounds(10, 40, 80, 25);
		newuserpanel.add(emailLabel);
		
		JTextField emailText = new JTextField(20);
		emailText.setBounds(100, 40, 160, 25);
		newuserpanel.add(emailText);
		
		JLabel locationLabel = new JLabel("Location");
		locationLabel.setBounds(10, 70, 80, 25);
		newuserpanel.add(locationLabel);
		
		JTextField locationText = new JTextField(20);
		locationText.setBounds(100, 70, 160, 25);
		newuserpanel.add(locationText);
		
		JLabel phoneLabel = new JLabel("Phone");
		phoneLabel.setBounds(10, 100, 80, 25);
		newuserpanel.add(phoneLabel);
		
		JTextField phoneText = new JTextField(20);
		phoneText.setBounds(100, 100, 160, 25);
		newuserpanel.add(phoneText);
		
		JLabel usernameLabel = new JLabel("Username *");
		usernameLabel.setBounds(10, 130, 80, 25);
		newuserpanel.add(usernameLabel);
		
		JTextField userText = new JTextField(20);
		userText.setBounds(100, 130, 160, 25);
		newuserpanel.add(userText);
		
		JLabel passwordLabel = new JLabel("Password *");
		passwordLabel.setBounds(10, 160, 80, 25);
		newuserpanel.add(passwordLabel);

		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 160, 160, 25);
		newuserpanel.add(passwordText);

		JButton submitButton = new JButton("submit");
		submitButton.setBounds(180, 200, 80, 25);
		newuserpanel.add(submitButton);

		JButton cancelButton = new JButton("cancel");
		cancelButton.setBounds(10, 200, 80, 25);
		newuserpanel.add(cancelButton);
		
		ActionListener submitButtonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton source = (JButton) e.getSource();
				if (nameText.getText().trim().isEmpty()||emailText.getText().trim().isEmpty() ||userText.getText().trim().isEmpty() || passwordText.getPassword().length == 0 ) {
					JOptionPane.showMessageDialog(source, "You have to fill out the required fields (*)");	
				} else {
					newuser=new Owner();
					newuser.setName(nameText.getText());
					newuser.setLocation(locationText.getText());
					newuser.setEmail(emailText.getText());
					newuser.setPhone(phoneText.getText());
					newuser.setUsername(userText.getText());
//					JOptionPane.showMessageDialog(source, "Welcome "+ nameText.getText() + " you have been registered");
				
//					TODO: Setja newuser inn í gagnagrunn
					
					JOptionPane.showMessageDialog(source, newuser.getinfo());
					dialog.remove(newuserpanel);
					loginDialog();
				}
			}
		};
		
		submitButton.addActionListener(submitButtonListener);
		
		ActionListener cancelButtonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				JButton source = (JButton) e.getSource();
				dialog.remove(newuserpanel);
				dialog.add(loginpanel);
				dialog.setVisible(true);
			}
		};
		
		cancelButton.addActionListener(cancelButtonListener);
		dialog.add(newuserpanel);
		dialog.setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e){
		JButton source = (JButton) e.getSource();
		String command = source.getActionCommand();
		if("login".equals(command)){
			if (authenticate(userText.getText(), passwordText.getPassword().toString())) {
			JOptionPane.showMessageDialog(source, "Welcome "+ userText.getText() + " you have been logged in");	
			View.frame.remove((View.search).panel);
			View.search.searchDialog();
			View.frame.add(View.search.panel);
			View.frame.setVisible(true);
			dialog.dispose();
			} 
		else {
			JOptionPane.showMessageDialog(source, "Invalid username or password");	
			}
		}
		else if("newuser".equals(command)){
			dialog.remove(loginpanel);
			NewUserForm();
			
//			JOptionPane.showMessageDialog(source, source.getText()
//					+ " button has been pressed");
		}
		
	}

//	Use: a.authenticate(x,y);
//	Before: a is a class, x is a string, y is a char[]
//	After: Check if x is the correct username and y is the correct password
	private boolean authenticate(String username, String password) {
//		TODO: Tjékkum hvort username og lykilorð passi við eitthvað í gagnagrunninum, 
//			  þá true annars false
		
        // hardcoded username and password
		
		Boolean correctpw=database.isuser(username, password);
		if(correctpw){
			newuser.setloggedin();
			newuser.setUsername(username);
			return true;	
		}
		else{
			return false;
		}
		

    }

}
