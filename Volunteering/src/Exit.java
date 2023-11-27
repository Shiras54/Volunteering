import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class Exit extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel,lblNewLabel_1;
	private JButton login;


	public static void main(String[] args) {
		new Exit();
	}


	public Exit() {
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
		
		lblNewLabel = new JLabel("Thank You For Using Our APP");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(51, 11, 336, 33);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("vv.png"));
		lblNewLabel_1.setBounds(138, 76, 147, 150);
		contentPane.add(lblNewLabel_1);
		
		login = new JButton("Log in");
		login.setBounds(321, 217, 89, 23);
		contentPane.add(login);
		
        login.addActionListener(this);
        
        setVisible(true);
        
        Initiative.checkTime();
		Initiative.saveInitiatives();
		User.saveUsers();
		
	}



	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login) {
			new Page1();
			dispose();
		}
	}
}
