import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class Usersignup extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField UserNameTF;
	private JTextField userDateOfBirthTF;
	private JTextField userPhoneNumberTF;
	private JTextField userAdressTF;
	private JTextField userPasswordTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usersignup frame = new Usersignup();
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
	public Usersignup() {
		setTitle("Volunteer For Earth");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\saeed\\OneDrive\\Desktop\\Tree-icon.png"));
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 353);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Sign Up");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(164, 11, 165, 38);
		contentPane.add(lblNewLabel);
		
		JLabel UserName = new JLabel("Name:");
		UserName.setFont(new Font("Tahoma", Font.BOLD, 20));
		UserName.setBounds(10, 50, 85, 38);
		contentPane.add(UserName);
		
		JLabel userId = new JLabel("Id:");
		userId.setFont(new Font("Tahoma", Font.BOLD, 20));
		userId.setBounds(10, 91, 85, 38);
		contentPane.add(userId);
		
		JLabel userDateOfBirth = new JLabel("Date of Birth:");
		userDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 20));
		userDateOfBirth.setBounds(10, 131, 149, 38);
		contentPane.add(userDateOfBirth);
		
		JLabel userPhoneNumber = new JLabel("Phone Number:");
		userPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 20));
		userPhoneNumber.setBounds(10, 168, 165, 38);
		contentPane.add(userPhoneNumber);
		
		JLabel userAdress = new JLabel("Adress:");
		userAdress.setFont(new Font("Tahoma", Font.BOLD, 20));
		userAdress.setBounds(10, 214, 165, 38);
		contentPane.add(userAdress);
		
		JLabel userPassword = new JLabel("Password:");
		userPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		userPassword.setBounds(10, 252, 165, 38);
		contentPane.add(userPassword);
		
		UserNameTF = new JTextField();
		UserNameTF.setBounds(179, 63, 206, 20);
		contentPane.add(UserNameTF);
		UserNameTF.setColumns(10);
		
		userDateOfBirthTF = new JTextField();
		userDateOfBirthTF.setColumns(10);
		userDateOfBirthTF.setBounds(179, 144, 206, 20);
		contentPane.add(userDateOfBirthTF);
		
		userPhoneNumberTF = new JTextField();
		userPhoneNumberTF.setColumns(10);
		userPhoneNumberTF.setBounds(179, 181, 206, 20);
		contentPane.add(userPhoneNumberTF);
		
		userAdressTF = new JTextField();
		userAdressTF.setColumns(10);
		userAdressTF.setBounds(179, 227, 206, 20);
		contentPane.add(userAdressTF);
		
		userPasswordTF = new JTextField();
		userPasswordTF.setColumns(10);
		userPasswordTF.setBounds(179, 263, 206, 20);
		contentPane.add(userPasswordTF);
	}

}
