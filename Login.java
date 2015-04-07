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
		this.newuserpanel=new JPanel();
		this.dialog = new JDialog();		
		loginDialog();
		NewUserForm();
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
		dialog.setSize(350,450);
		newuserpanel=new JPanel();
		GroupLayout newinputs = new GroupLayout(newuserpanel);
	    newinputs.setAutoCreateGaps(true);
	    newinputs.setAutoCreateContainerGaps(true);
	    GroupLayout.SequentialGroup newhGroup = newinputs.createSequentialGroup();
	    newuserpanel.setLayout(newinputs);
	    GroupLayout.ParallelGroup newlabels = newinputs.createParallelGroup(); //One for Labels
	    GroupLayout.ParallelGroup newfields = newinputs.createParallelGroup(); //Other for values/fields
	    
	    JLabel nameLabel = new JLabel("Name *");
	    newlabels.addComponent(nameLabel);
	    
	    JTextField nameText = new JTextField(20);
	    newfields.addComponent(nameText,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
	    
	    JLabel emailLabel = new JLabel("Email *");
	    newlabels.addComponent(emailLabel);
	    
	    JTextField emailText = new JTextField(20);
	    newfields.addComponent(emailText,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
	    
	    JLabel locationLabel = new JLabel("Location");
	    newlabels.addComponent(locationLabel);
	    
	    JTextField locationText = new JTextField(20);
	    newfields.addComponent(locationText,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
	    
	    JLabel phoneLabel = new JLabel("Phone");
	    newlabels.addComponent(phoneLabel);
	    
	    JTextField phoneText = new JTextField(20);
	    newfields.addComponent(phoneText,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
	    
	    JLabel usernameLabel = new JLabel("Username *");
	    newlabels.addComponent(usernameLabel);
	    
	    JTextField userText = new JTextField(20);
	    newfields.addComponent(userText,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
	    
	    JLabel passwordLabel = new JLabel("Password *");
	    newlabels.addComponent(passwordLabel);
	    
	    JPasswordField passwordText = new JPasswordField(20);
	    newfields.addComponent(passwordText,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
	    
		JButton submitButton = new JButton("submit");
		submitButton.setBounds(225, 200, 80, 25);
		newuserpanel.add(submitButton);

		JButton cancelButton = new JButton("cancel");
		cancelButton.setBounds(10, 200, 80, 25);
		newuserpanel.add(cancelButton);
		
		submitButton.setActionCommand("login");
	    submitButton.addActionListener(this);
	    cancelButton.setActionCommand("cancel");
	    cancelButton.addActionListener(this);
	    
	    newhGroup.addGroup(newlabels);
	    newhGroup.addGroup(newfields);
	    
	    newinputs.setHorizontalGroup(newhGroup);
	    
	    GroupLayout.SequentialGroup newvGroup = newinputs.createSequentialGroup();  
	    GroupLayout.ParallelGroup NameGroup = newinputs.createParallelGroup(GroupLayout.Alignment.CENTER);
	    GroupLayout.ParallelGroup EmailGroup = newinputs.createParallelGroup(GroupLayout.Alignment.CENTER);
	    GroupLayout.ParallelGroup LocationGroup = newinputs.createParallelGroup(GroupLayout.Alignment.CENTER);
	    GroupLayout.ParallelGroup PhoneGroup = newinputs.createParallelGroup(GroupLayout.Alignment.CENTER);
	    GroupLayout.ParallelGroup UsernameGroup = newinputs.createParallelGroup(GroupLayout.Alignment.CENTER);
	    GroupLayout.ParallelGroup PasswordGroup = newinputs.createParallelGroup(GroupLayout.Alignment.CENTER);
	    
	    NameGroup.addComponent(nameLabel);
	    NameGroup.addComponent(nameText,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
	    EmailGroup.addComponent(emailLabel);
	    EmailGroup.addComponent(emailText,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
	    LocationGroup.addComponent(locationLabel);
	    LocationGroup.addComponent(locationText,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
	    PhoneGroup.addComponent(phoneLabel);
	    PhoneGroup.addComponent(phoneText,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
	    UsernameGroup.addComponent(usernameLabel);
	    UsernameGroup.addComponent(userText,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
	    PasswordGroup.addComponent(passwordLabel);
	    PasswordGroup.addComponent(passwordText,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
	    
	    newvGroup.addGroup(NameGroup);
	    newvGroup.addGroup(EmailGroup);
	    newvGroup.addGroup(LocationGroup);
	    newvGroup.addGroup(PhoneGroup);
	    newvGroup.addGroup(UsernameGroup);
	    newvGroup.addGroup(PasswordGroup);

	    newinputs.setVerticalGroup(newvGroup);
	    


		
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
					JOptionPane.showMessageDialog(source, "Welcome "+ nameText.getText() + " you have been registered");
				
//					TODO: Setja newuser inn � gagnagrunn
					
//					JOptionPane.showMessageDialog(source, newuser.getinfo());
					dialog.remove(newuserpanel);
					loginDialog();
				}
			}
		};
		
		submitButton.addActionListener(submitButtonListener);
		
		ActionListener cancelButtonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newuserpanel.setVisible(false);
				dialog.remove(newuserpanel);
				dialog.add(loginpanel);
				dialog.setVisible(true);
			}
		};
		
		cancelButton.addActionListener(cancelButtonListener);
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
		if("newuser".equals(command)){
			dialog.remove(loginpanel);
			dialog.add(newuserpanel);
			newuserpanel.setVisible(true);
			dialog.setVisible(true);
		}
		
	}

//	Use: a.authenticate(x,y);
//	Before: a is a class, x is a string, y is a char[]
//	After: Check if x is the correct username and y is the correct password
	private boolean authenticate(String username, String password) {
//		TODO: Tj�kkum hvort username og lykilor� passi vi� eitthva� � gagnagrunninum, 
//			  �� true annars false
		
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
