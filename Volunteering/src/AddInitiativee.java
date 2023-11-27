import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.*;
import java.text.ParseException;


public class AddInitiativee extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameTF,timeTF,creditTF;
	private JLabel lblNewLabel,lnName,lnTime,lnDescription,lnCredit,dateLabel;
	private JButton backButton,btnDone;
	private JTextArea descriptionTA;
	private JScrollPane scrollPane;
	private JFormattedTextField date;
	private MaskFormatter format;

	public static void main(String[] args) {
		new AddInitiativee();
	}

	public AddInitiativee() {
		setTitle("Volunteer For Earth");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\saeed\\OneDrive\\Desktop\\Tree-icon.png"));
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 430);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		try {
			format = new MaskFormatter("##/##/#### ##:##:##");
			format.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Creating new initiative");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(93, 11, 280, 27);
		contentPane.add(lblNewLabel);
		
		lnName = new JLabel("Name:");
		lnName.setFont(new Font("Tahoma", Font.BOLD, 22));
		lnName.setBounds(10, 63, 85, 27);
		contentPane.add(lnName);
		
		lnTime = new JLabel("Period (Hrs):");
		lnTime.setFont(new Font("Tahoma", Font.BOLD, 22));
		lnTime.setBounds(10, 119, 146, 27);
		contentPane.add(lnTime);
		
		lnDescription = new JLabel("Description:");
		lnDescription.setFont(new Font("Tahoma", Font.BOLD, 22));
		lnDescription.setBounds(10, 170, 146, 27);
		contentPane.add(lnDescription);
		
		lnCredit = new JLabel("Credits:");
		lnCredit.setFont(new Font("Tahoma", Font.BOLD, 22));
		lnCredit.setBounds(10, 250, 146, 27);
		contentPane.add(lnCredit);

		dateLabel = new JLabel("Date & Time:");
		dateLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		dateLabel.setBounds(10, 290, 146, 27);
		contentPane.add(dateLabel);
		
		nameTF = new JTextField();
		nameTF.setBounds(182, 68, 250, 25);
		contentPane.add(nameTF);
		nameTF.setColumns(10);
		
		timeTF = new JTextField();
		timeTF.setColumns(10);
		timeTF.setBounds(182, 124, 250, 25);
		contentPane.add(timeTF);
		
		date = new JFormattedTextField(format);
		date.setBounds(182, 290, 250, 25);
		contentPane.add(date);
		date.setColumns(10);
		
		
		descriptionTA = new JTextArea();
		contentPane.add(descriptionTA);
		descriptionTA.setBounds(182, 171, 250, 70);
		descriptionTA.setLineWrap(true);
		descriptionTA.setWrapStyleWord(true);
		descriptionTA.setEditable(true);
		descriptionTA.setEnabled(true);
		
		scrollPane = new JScrollPane(descriptionTA);
		scrollPane.setBounds(182, 171, 250, 70);
		contentPane.add(scrollPane);
		

		creditTF = new JTextField();
		creditTF.setColumns(10);
		creditTF.setBounds(182, 250, 250, 25);
		contentPane.add(creditTF);
		
		backButton = new JButton("Back");
		backButton.addActionListener(this);
		backButton.setBounds(337, 330, 89, 23);
		contentPane.add(backButton);
		
		btnDone = new JButton("Done");
		btnDone.setBounds(25, 330, 89, 23);
		contentPane.add(btnDone);

		btnDone.addActionListener(this);
		setVisible(true);
	}

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == backButton) {
			new Initiativemain().setVisible(true);
			dispose();
		}else if (e.getSource() == btnDone) {
			new Initiativemain().setVisible(true);
			dispose();
			User.loggedIn.initiate(nameTF.getText(),date.getText(),descriptionTA.getText(),Integer.parseInt(creditTF.getText()),Integer.parseInt(timeTF.getText()));
		}
	}
}
