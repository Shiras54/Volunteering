import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class userpage1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameTF;
	private JTextField PassTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userpage1 frame = new userpage1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
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
		
		JLabel user = new JLabel("User ");
		user.setFont(new Font("Tahoma", Font.BOLD, 22));
		user.setBounds(183, 11, 57, 27);
		contentPane.add(user);
		
		JLabel userName = new JLabel("Name:");
		userName.setFont(new Font("Tahoma", Font.BOLD, 20));
		userName.setBounds(34, 76, 77, 27);
		contentPane.add(userName);
		
		JLabel userPass = new JLabel("Password:");
		userPass.setFont(new Font("Tahoma", Font.BOLD, 20));
		userPass.setBounds(34, 146, 115, 27);
		contentPane.add(userPass);
		
		JLabel NRY = new JLabel("Not Registered Yet?");
		NRY.setFont(new Font("Tahoma", Font.ITALIC, 15));
		NRY.setBounds(268, 190, 142, 27);
		contentPane.add(NRY);
		
		JButton loginButton = new JButton("log in");
		loginButton.setBounds(22, 213, 89, 23);
		contentPane.add(loginButton);
		
		nameTF = new JTextField();
		nameTF.setBounds(147, 83, 175, 20);
		contentPane.add(nameTF);
		nameTF.setColumns(10);
		
		PassTF = new JTextField();
		PassTF.setColumns(10);
		PassTF.setBounds(147, 153, 175, 20);
		contentPane.add(PassTF);
		
		JButton Signup = new JButton("Sign Up");
		Signup.setBounds(295, 213, 89, 23);
		contentPane.add(Signup);
		
		Signup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	SignupActionPerformed(evt);
            }
        });
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(321, 28, 89, 23);
		contentPane.add(backButton);
		
		backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	backButtonActionPerformed(evt);
            }
        });
	}
    private void backButtonActionPerformed(ActionEvent evt) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Page1().setVisible(true);
            }
        });
        dispose();
    }
    private void SignupActionPerformed(ActionEvent evt) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usersignup().setVisible(true);
            }
        });
        dispose();
    }
}
