import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JButton;

public class adminP1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameTF;
	private JTextField passTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminP1 frame = new adminP1();
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
	public adminP1() {
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
		
		JLabel adminN = new JLabel("Name:");
		adminN.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		adminN.setBounds(33, 81, 100, 25);
		contentPane.add(adminN);
		
		JLabel adminLogin = new JLabel("Admin Login Page");
		adminLogin.setBounds(113, 11, 221, 25);
		adminLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		contentPane.add(adminLogin);
		
		nameTF = new JTextField();
		nameTF.setBounds(190, 88, 96, 20);
		contentPane.add(nameTF);
		nameTF.setColumns(10);
		
		JLabel adminPass = new JLabel("Password:");
		adminPass.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		adminPass.setBounds(33, 154, 129, 25);
		contentPane.add(adminPass);
		
		passTF = new JTextField();
		passTF.setColumns(10);
		passTF.setBounds(190, 154, 96, 20);
		contentPane.add(passTF);
		
		JButton loginButton = new JButton("log in");
		loginButton.setBounds(314, 217, 89, 23);
		contentPane.add(loginButton);
	}
}
