import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;
import java.awt.event.*;
import java.text.*;

public class Usersignup extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField UserNameTF,userAdressTF,userPasswordTF,userEmailTF;
	private JFormattedTextField userDateOfBirthTF, userPhoneNumberTF;
	private JLabel lblNewLabel,UserName,userEmail,userDateOfBirth,userPhoneNumber,userAdress,userPassword;
	private JButton Signup,Back;
	private MaskFormatter phoneFormat,dobFormat;
	
	public static void main(String[] args) {
		new Usersignup();
	}

	public Usersignup() {
		setTitle("Volunteer For Earth");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\saeed\\OneDrive\\Desktop\\Tree-icon.png"));
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 353);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		try {
			dobFormat = new MaskFormatter("##/##/####");
			phoneFormat = new MaskFormatter("##########");
			dobFormat.setPlaceholderCharacter('_');
			phoneFormat.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("User Sign Up");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(164, 11, 165, 38);
		contentPane.add(lblNewLabel);
		
		UserName = new JLabel("Name:");
		UserName.setFont(new Font("Tahoma", Font.BOLD, 20));
		UserName.setBounds(10, 50, 85, 38);
		contentPane.add(UserName);
		
		userEmail = new JLabel("Email:");
		userEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
		userEmail.setBounds(10, 91, 85, 38);
		contentPane.add(userEmail);
		
		userDateOfBirth = new JLabel("Date of Birth:");
		userDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 20));
		userDateOfBirth.setBounds(10, 131, 149, 38);
		contentPane.add(userDateOfBirth);
		
		userPhoneNumber = new JLabel("Phone Number:");
		userPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 20));
		userPhoneNumber.setBounds(10, 168, 165, 38);
		contentPane.add(userPhoneNumber);
		
		userAdress = new JLabel("Address:");
		userAdress.setFont(new Font("Tahoma", Font.BOLD, 20));
		userAdress.setBounds(10, 214, 165, 38);
		contentPane.add(userAdress);
		
		userPassword = new JLabel("Password:");
		userPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		userPassword.setBounds(10, 252, 165, 38);
		contentPane.add(userPassword);
		
		UserNameTF = new JTextField();
		UserNameTF.setBounds(179, 63, 206, 20);
		contentPane.add(UserNameTF);
		UserNameTF.setColumns(10);
		
		userEmailTF = new JTextField();
		userEmailTF.setBounds(179, 100, 206, 20);
		contentPane.add(userEmailTF);
		userEmailTF.setColumns(10);
		
		userDateOfBirthTF = new JFormattedTextField(dobFormat);
		userDateOfBirthTF.setColumns(10);
		userDateOfBirthTF.setBounds(179, 144, 206, 20);
		contentPane.add(userDateOfBirthTF);
		
		userPhoneNumberTF = new JFormattedTextField(phoneFormat);
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
		
		Signup = new JButton("Sign Up");
		Signup.setBounds(395, 282, 89, 23);
		contentPane.add(Signup);
		
		Signup.addActionListener(this);
		
		Back = new JButton("Back");
		Back.setBounds(395, 24, 89, 23);
		contentPane.add(Back);
		
		Back.addActionListener(this);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Back) {
			 new userpage1().setVisible(true);
			 dispose();
		} else if(e.getSource()==Signup) {
			if(!UserNameTF.getText().equals("") && !userDateOfBirthTF.getText().equals("") && !userEmailTF.getText().equals("") && !userPhoneNumberTF.getText().equals("") && !userAdressTF.getText().equals("") && !userPasswordTF.getText().equals("")) {
				new User(UserNameTF.getText(),userDateOfBirthTF.getText(),userEmailTF.getText(),userPhoneNumberTF.getText(),userAdressTF.getText(),userPasswordTF.getText());
				new userpage1().setVisible(true);
				dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Boxes have been left empty!");
			}
		}
		
	}
}
