import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;
import java.awt.event.*;
import java.text.*;

public class userpage1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameTF,PassTF;
	JLabel user,userName,userPass,NRY;
	JButton loginButton,Signup,backButton;

	public static void main(String[] args) {
		new userpage1();
	}

	public userpage1() {
		setTitle("Volunteer For Earth");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\saeed\\OneDrive\\Desktop\\Tree-icon.png"));
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		user = new JLabel("User ");
		user.setFont(new Font("Tahoma", Font.BOLD, 22));
		user.setBounds(183, 11, 57, 27);
		contentPane.add(user);
		
		userName = new JLabel("Name:");
		userName.setFont(new Font("Tahoma", Font.BOLD, 20));
		userName.setBounds(34, 76, 77, 27);
		contentPane.add(userName);
		
		userPass = new JLabel("Password:");
		userPass.setFont(new Font("Tahoma", Font.BOLD, 20));
		userPass.setBounds(34, 146, 115, 27);
		contentPane.add(userPass);
		
		NRY = new JLabel("Not Registered Yet?");
		NRY.setFont(new Font("Tahoma", Font.ITALIC, 15));
		NRY.setBounds(268, 190, 142, 27);
		contentPane.add(NRY);
		
		loginButton = new JButton("log in");
		loginButton.setBounds(22, 213, 89, 23);
		contentPane.add(loginButton);
		
		loginButton.addActionListener(this);
		
		
		nameTF = new JTextField();
		nameTF.setBounds(147, 83, 175, 20);
		contentPane.add(nameTF);
		nameTF.setColumns(10);
		
		PassTF = new JTextField();
		PassTF.setColumns(10);
		PassTF.setBounds(147, 153, 175, 20);
		contentPane.add(PassTF);
		
		Signup = new JButton("Sign Up");
		Signup.setBounds(295, 213, 89, 23);
		contentPane.add(Signup);
		
		Signup.addActionListener(this);
		
		backButton = new JButton("Back");
		backButton.setBounds(321, 28, 89, 23);
		contentPane.add(backButton);
		
		backButton.addActionListener(this);
	}

    private void SignupActionPerformed(ActionEvent evt) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usersignup().setVisible(true);
            }
        });
        dispose();
    }
    
    private void loginButtonActionPerformed(ActionEvent evt) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new useroptions().setVisible(true);
            }
        });
        dispose();
    }

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==backButton) {
			new Page1().setVisible(true);
			dispose();
		} else if(e.getSource()==loginButton) {
			if(User.logIn(nameTF.getText(), PassTF.getText())) {
				new useroptions().setVisible(true);
				dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Username and/or Password is incorrect!");
			}
		} else if(e.getSource()==Signup) {
			new Usersignup().setVisible(true);
			dispose();
		}
	}
    
}
