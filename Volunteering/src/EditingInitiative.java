import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;
import java.awt.event.*;
import java.text.*;

public class EditingInitiative extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name,NOV,timedate;
	private JLabel Inname,editingIn,InNOV,INTime,lnDescription,dateLabel;
	private JButton backbutton,btnDone;
	private JTextArea descriptionTA;
	private JScrollPane scrollPane;
	private JFormattedTextField date;
	private MaskFormatter format;

	public static void main(String[] args) {
		new EditingInitiative();
	}

	public EditingInitiative() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\saeed\\OneDrive\\Desktop\\Tree-icon.png"));
		setTitle("Volunteer For Earth");
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 450);
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
		
		Inname = new JLabel("Name:");
		Inname.setBounds(10, 62, 95, 27);
		Inname.setFont(new Font("Tahoma", Font.BOLD, 22));
		contentPane.add(Inname);
		
		editingIn = new JLabel("Editing initiative (1)");
		editingIn.setBounds(95, 11, 234, 27);
		editingIn.setFont(new Font("Tahoma", Font.BOLD, 22));
		contentPane.add(editingIn);
		
		InNOV = new JLabel("Credits:");
		InNOV.setFont(new Font("Tahoma", Font.BOLD, 22));
		InNOV.setBounds(10, 113, 262, 27);
		contentPane.add(InNOV);
		
		INTime = new JLabel("Time:\n");
		INTime.setFont(new Font("Tahoma", Font.BOLD, 22));
		INTime.setBounds(10, 161, 157, 27);
		contentPane.add(INTime);
		
		lnDescription = new JLabel("Description:");
		lnDescription.setFont(new Font("Tahoma", Font.BOLD, 22));
		lnDescription.setBounds(10, 204, 143, 27);
		contentPane.add(lnDescription);
		
		dateLabel = new JLabel("Date & Time:");
		dateLabel.setBounds(10, 300, 200, 27);
		dateLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		contentPane.add(dateLabel);
		
		name = new JTextField();
		name.setBounds(158, 66, 219, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		NOV = new JTextField();
		NOV.setColumns(10);
		NOV.setBounds(158, 115, 219, 20);
		contentPane.add(NOV);
		
		timedate = new JTextField();
		timedate.setColumns(10);
		timedate.setBounds(158, 165, 219, 20);
		contentPane.add(timedate);
		
		descriptionTA = new JTextArea();
		contentPane.add(descriptionTA);
		descriptionTA.setBounds(158, 212, 219, 80);
		descriptionTA.setLineWrap(true);
		descriptionTA.setWrapStyleWord(true);
		descriptionTA.setEditable(true);
		descriptionTA.setEnabled(true);
		
		scrollPane = new JScrollPane(descriptionTA);
		scrollPane.setBounds(158, 212, 219, 80);
		contentPane.add(scrollPane);
		
		date = new JFormattedTextField(format);
		date.setBounds(158, 305, 219, 20);
		contentPane.add(date);
		date.setColumns(10);
		
		backbutton = new JButton("Back\r\n");
		backbutton.setBounds(25, 360, 89, 23);
		contentPane.add(backbutton);
		backbutton.addActionListener(this);
		
		btnDone = new JButton("Done");
		btnDone.setBounds(275, 360, 89, 23);
		contentPane.add(btnDone);
		backbutton.addActionListener(this);
		
		setVisible(true);
    }

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==backbutton) {
			new Initiativemain().setVisible(true);
			dispose();
		}else if(e.getSource()==btnDone) {
			new Initiativemain().setVisible(true);
			User.loggedIn.changeInitiative1(name.getText(),date.getText(),timedate.getText(),NOV.getText(),descriptionTA.getText());
			dispose();
		}
		
	}
	}