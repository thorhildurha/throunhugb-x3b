import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {
	public static void main(String[] args) {
		new Login().loginDialog();
//		new Login().NewUserForm();

	}
	
	public void loginDialog() {
		JFrame frame = new JFrame("Login application");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		placeLoginComponents(frame);
		frame.setVisible(true);
	}
	
	public void NewUserForm() {
		JFrame frame = new JFrame("New user application");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		placeNewUserComponents(frame);
		frame.setVisible(true);
		
	}
	
	private static void placeNewUserComponents(JFrame frame) {
		frame.setLayout(null);
	
		JLabel nameLabel = new JLabel("Name *");
		nameLabel.setBounds(10, 10, 80, 25);
		frame.add(nameLabel);
		
		JTextField nameText = new JTextField(20);
		nameText.setBounds(100, 10, 160, 25);
		frame.add(nameText);
		
		JLabel emailLabel = new JLabel("Email *");
		emailLabel.setBounds(10, 40, 80, 25);
		frame.add(emailLabel);
		
		JTextField emailText = new JTextField(20);
		emailText.setBounds(100, 40, 160, 25);
		frame.add(emailText);
		
		JLabel locationLabel = new JLabel("Location");
		locationLabel.setBounds(10, 70, 80, 25);
		frame.add(locationLabel);
		
		JTextField locationText = new JTextField(20);
		locationText.setBounds(100, 70, 160, 25);
		frame.add(locationText);
		
		JLabel phoneLabel = new JLabel("Phone");
		phoneLabel.setBounds(10, 100, 80, 25);
		frame.add(phoneLabel);
		
		JTextField phoneText = new JTextField(20);
		phoneText.setBounds(100, 100, 160, 25);
		frame.add(phoneText);
		
		JLabel usernameLabel = new JLabel("Username *");
		usernameLabel.setBounds(10, 130, 80, 25);
		frame.add(usernameLabel);
		
		JTextField userText = new JTextField(20);
		userText.setBounds(100, 130, 160, 25);
		frame.add(userText);
		
		JLabel passwordLabel = new JLabel("Password *");
		passwordLabel.setBounds(10, 160, 80, 25);
		frame.add(passwordLabel);

		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 160, 160, 25);
		frame.add(passwordText);

		JButton submitButton = new JButton("submit");
		submitButton.setBounds(10, 200, 80, 25);
		frame.add(submitButton);

		JButton cancelButton = new JButton("cancel");
		cancelButton.setBounds(180, 200, 80, 25);
		frame.add(cancelButton);
		
		ActionListener submitButtonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton source = (JButton) e.getSource();
				if (nameText.getText().trim().isEmpty()||emailText.getText().trim().isEmpty() ||userText.getText().trim().isEmpty() || passwordText.getPassword().length == 0 ) {
					JOptionPane.showMessageDialog(source, "You have to fill out required fields (*)");	
				} else {
					JOptionPane.showMessageDialog(source, "Welcome "+ nameText.getText() + " you have been registered");
//					B�a til n�jan notanda
				}
			}
		};
		
		submitButton.addActionListener(submitButtonListener);
		
		ActionListener cancelButtonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton source = (JButton) e.getSource();
				new Login().loginDialog();
				frame.setVisible(false);
				frame.dispose();
			}
		};
		
		cancelButton.addActionListener(cancelButtonListener);
	}
	
	private static void placeLoginComponents(JFrame frame) {
		frame.setLayout(null);

		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(10, 10, 80, 25);
		frame.add(userLabel);
		
		JTextField userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		frame.add(userText);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		frame.add(passwordLabel);

		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
		frame.add(passwordText);

		JButton loginButton = new JButton("login");
		loginButton.setBounds(10, 80, 80, 25);
		frame.add(loginButton);

		JButton registerButton = new JButton("register");
		registerButton.setBounds(180, 80, 80, 25);
		frame.add(registerButton);
		
		ActionListener loginButtonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton source = (JButton) e.getSource();
				if (Login.authenticate(userText.getText(), passwordText.getPassword())) {
					JOptionPane.showMessageDialog(source, "Welcome "+ userText.getText() + " you have been logged in");	
				} else {
					JOptionPane.showMessageDialog(source, "Invalid username or password");	
				}
			}
		};
		
		loginButton.addActionListener(loginButtonListener);
		
		ActionListener registerButtonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton source = (JButton) e.getSource();
				new Login().NewUserForm();
				frame.setVisible(false);
				frame.dispose();
//				JOptionPane.showMessageDialog(source, source.getText()
//						+ " button has been pressed");
			}
		};
		
		registerButton.addActionListener(registerButtonListener);
	}

	
	public static boolean authenticate(String username, char[] password) {
        // hardcoded username and password
		char[] correctPassword = "secret".toCharArray();
        if (username.equals("bob") && Arrays.equals(password, correctPassword)) {
            return true;
        }
        return false;
    }
	


}
