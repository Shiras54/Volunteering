import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class InitiatorDetails extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitiatorDetails frame = new InitiatorDetails();
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
	public InitiatorDetails() {
		setTitle("Volunteer For Earth");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\saeed\\OneDrive\\Desktop\\Tree-icon.png"));
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Idetails = new JLabel("(Initiator Name) Details");
		Idetails.setFont(new Font("Tahoma", Font.BOLD, 22));
		Idetails.setBounds(21, 21, 297, 27);
		contentPane.add(Idetails);
		
		JLabel IName = new JLabel("Name:");
		IName.setFont(new Font("Tahoma", Font.BOLD, 20));
		IName.setBounds(21, 71, 84, 27);
		contentPane.add(IName);
		
		JLabel IAge = new JLabel("Age:");
		IAge.setFont(new Font("Tahoma", Font.BOLD, 20));
		IAge.setBounds(21, 106, 66, 27);
		contentPane.add(IAge);
		
		JLabel IId = new JLabel("Id:");
		IId.setFont(new Font("Tahoma", Font.BOLD, 20));
		IId.setBounds(21, 148, 84, 27);
		contentPane.add(IId);
		
		JLabel NOAI = new JLabel("Number of active initiatives:");
		NOAI.setFont(new Font("Tahoma", Font.BOLD, 20));
		NOAI.setBounds(21, 185, 297, 27);
		contentPane.add(NOAI);
		
		JButton remove = new JButton("Remove");
		remove.setBounds(337, 28, 89, 23);
		contentPane.add(remove);
		
		JButton back = new JButton("Back to Admin Main Page");
		back.setBounds(231, 223, 195, 23);
		contentPane.add(back);
	}

}
