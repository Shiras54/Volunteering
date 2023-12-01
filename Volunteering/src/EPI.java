import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;
import java.awt.event.*;
import java.text.*;

public class EPI extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameTF,emailTF,addressTF,passTF;
	private JFormattedTextField dobTF,phoneTF;
	private JLabel lbEPI,lblName,lblPhoneNumber,lblEmail,lblDateOfBirth,lblimg,addressLabel,passLabel;
	private JButton btnNewButton,btnBack;
	private MaskFormatter phoneFormat,dobFormat;
	String source="initiate";

	public static void main(String[] args) {
		new EPI();
	}


	public EPI() {
		setBackground(Color.LIGHT_GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage("Tree-icon.png"));
		setTitle("Volunteer For Earth");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 400);
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
		
		lbEPI = new JLabel("Edit Personal Info");
		lbEPI.setFont(new Font("Tahoma", Font.BOLD, 22));
		lbEPI.setBounds(110, 11, 244, 27);
		contentPane.add(lbEPI);
		
		lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblName.setBounds(10, 66, 102, 27);
		contentPane.add(lblName);
		
		lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblPhoneNumber.setBounds(10, 104, 227, 27);
		contentPane.add(lblPhoneNumber);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblEmail.setBounds(10, 142, 116, 27);
		contentPane.add(lblEmail);
		
		lblDateOfBirth = new JLabel("Date Of Birth:");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblDateOfBirth.setBounds(10, 180, 164, 27);
		contentPane.add(lblDateOfBirth);
		
		addressLabel = new JLabel("Address:");
		addressLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		addressLabel.setBounds(10, 218, 164, 27);
		contentPane.add(addressLabel);
		
		passLabel = new JLabel("Password:");
		passLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		passLabel.setBounds(10, 256, 164, 27);
		contentPane.add(passLabel);
		
		nameTF = new JTextField();
		nameTF.setBounds(219, 74, 177, 20);
		nameTF.setColumns(10);
		contentPane.add(nameTF);
		
		phoneTF = new JFormattedTextField(phoneFormat);
		phoneTF.setColumns(10);
		phoneTF.setBounds(219, 112, 177, 20);
		contentPane.add(phoneTF);
		
		emailTF = new JTextField();
		emailTF.setColumns(10);
		emailTF.setBounds(219, 150, 177, 20);
		contentPane.add(emailTF);
		
		dobTF = new JFormattedTextField(dobFormat);
		dobTF.setColumns(10);
		dobTF.setBounds(219, 188, 177, 20);
		contentPane.add(dobTF);
		
		addressTF = new JTextField();
		addressTF.setColumns(10);
		addressTF.setBounds(219, 218, 177, 20);
		contentPane.add(addressTF);
		
		passTF = new JTextField();
		passTF.setColumns(10);
		passTF.setBounds(219, 256, 177, 20);
		contentPane.add(passTF);
		
		lblimg = new JLabel("");
		lblimg.setIcon(new ImageIcon("fix.png"));
		lblimg.setBounds(377, 11, 49, 48);
		contentPane.add(lblimg);
		
		
		
		btnNewButton = new JButton("Done");
		btnNewButton.setBounds(307, 310, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(this);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(20, 310, 89, 23);
		contentPane.add(btnBack);
	
		btnBack.addActionListener(this);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnBack) {
			if(source.equals("volunteer")) {
				new Vmainpage().setVisible(true);
			} else if(source.equals("initiate")) {
				new Initiativemain().setVisible(true);
			}
			dispose();
		}else if(e.getSource()==btnNewButton) {
			User.loggedIn.changeInfo(nameTF.getText(),dobTF.getText(),emailTF.getText(),phoneTF.getText(),addressTF.getText(),passTF.getText());
			if(source.equals("volunteer")) {
				new Vmainpage().setVisible(true);
			} else if(source.equals("initiate")) {
				new Initiativemain().setVisible(true);
			}
			dispose();
		}
		
	}
}
