



import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import javax.swing.*;



/**
 * @author Benjamin Oliveria & Arpit Dang
 * This class is for the LoginFormUI where the user will enter their username and password to move onto the Trading Broker UI screen
 */

public class LoginFormUI implements ActionListener {

	/**
	 * Creater class for LoginFormUI along with ActionListener class where all the button action clicked will be tracked
	 */
	private static LoginFormUI instance = null;

 
	/**
	 * JFrame provides a window for the LoginFormUI to open
	 */
	
	JFrame frame = new JFrame();
	
	/**
	 * JLabel is used to provide a title for the window
	 */
	
	JLabel titleLabel = new JLabel("Cryptocoin Trading System Login");
	
	/**
	 * JButton is used to create the log-in button
	 */
	
	JButton loginButton = new JButton("Login");
	
	/**
	 *JTextField (visible) & JPasswordField (not visible) are used for the user to enter their username and password
	 */

	JTextField usernameField = new JTextField();
	JPasswordField passwordField = new JPasswordField();
	
	/**
	 *JLabel is used for Username and Password titles so the user knows which textfield is used to enter what
	 */

  
	JLabel usernameLabel = new JLabel("Username:");
	JLabel passwordLabel = new JLabel("Password:");
	
	
	
	/**
	 * Sets the JFrame window characteristics include size, layout, and visibility
	 */
	private LoginFormUI() {

   
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}
	
	public void display() {

    /**
     * Sets the charactersitics for the titles, textboxes and buttons for an appropriate appearance
     * All the titles, textboxes, and buttons are added to the JFrame window and the JFrame window is validated
     */
		
		titleLabel.setFont(new Font(null, Font.BOLD, 20));
		titleLabel.setBounds(20, 0, 500, 30);
		
		usernameLabel.setBounds(50, 100, 75, 25);
		passwordLabel.setBounds(50, 150, 75, 25);
		
		usernameField.setBounds(125, 100, 200, 25);
		passwordField.setBounds(125, 150, 200, 25);
		
		loginButton.setBounds(125, 200, 100, 25);
		loginButton.addActionListener(this);

       
		frame.add(titleLabel, BorderLayout.NORTH);
		frame.add(usernameLabel);
		frame.add(usernameField);
		frame.add(passwordLabel);
		frame.add(passwordField);
		frame.add(loginButton);
		frame.validate();


	}

  
	/**
	 * @return instance
	 * If there is no instance, then a new LoginFormUI is formed
	 */
	
	
	public static LoginFormUI getInstance() {
		if (instance == null) {
			instance = new LoginFormUI();
		}
		return instance;
	}

	/**
	 *Once the LoginIn button is clicked, the action will be checked
	 */
	
	@Override
	
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == loginButton) {

			/**
			 *The text entered in the username and passwoerd textfields will be stored in the variables below
			 */
			
			String username = usernameField.getText();
			String password = String.valueOf(passwordField.getPassword());
			
			/**
			 *Spaces after the text will be ignored using .strip()
			 */

			username = username.strip();
			password = password.strip();
			
			/**
			 *This method will validate that the combination of username and password is true (method below)
			 */

			Boolean credentialsValid = this.validate(username, password);
			
			/**
			 *If true, the JFrame LoginIn window will close, and it will move to the BrokerLogUI window
			 */
			
      if (credentialsValid) {
				frame.dispose();
				
				/**
				 *BrokerLogUI window will open
				 */

				BrokerLogUI openLog = BrokerLogUI.getInstance();
				openLog.display();
				
				
			} else {

				/**
				 *If not a new JFrame window will open with a termination message
				 */
				
				frame.dispose();
				
				/**
				 *The code below is for the new termination window that will if the combination of username and password is incorrect
				 */
        
				JFrame failFrame = new JFrame();
				JLabel failMessage = new JLabel("Incorrect credentials! >:(");

				failMessage.setForeground(Color.RED);
				failMessage.setBounds(0, 0, 500, 100);
				
				failFrame.add(failMessage);
				failFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				failFrame.setSize(500, 100);
				failFrame.setLayout(null);
				failFrame.setVisible(true);
			}

		}
		
	}
	
	/**
	 * @param username is the username entered by the user
	 * @param password is the password entered by the user
	 * @return returns if the combination of the  username and password is true in the text file ("credentials.txt")
	 */
	private boolean validate(String username, String password) {
		
		try {
			
			File loginDatabase = new File("credentials.txt");
			Scanner reader = new Scanner(loginDatabase);
			
			while (reader.hasNextLine()) {
				
				String currentLine = reader.nextLine();
				String[] userPassArray = currentLine.split(" ");
				
				if (username.equals(userPassArray[0]) && password.equals(userPassArray[1])) {
					return true;
				} 
			}
			
			return false;
			
		} catch (FileNotFoundException e) {
			
			System.out.println("File not found.");
			return false;
			
		}
	}

	/**
	 * @param the LoginFormUI class called test is opened and displayed
	 */
	
	public static void main(String[] args) {
		
		LoginFormUI test = getInstance();
		test.display();
		

	}

	
}
