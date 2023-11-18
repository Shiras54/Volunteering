import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class adminP2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminP2 frame = new adminP2();
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
	public adminP2() {
		setTitle("Volunteer For Earth");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\saeed\\OneDrive\\Desktop\\Tree-icon.png"));
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel newInitiative = new JLabel("New initiative:");
		newInitiative.setBounds(10, 40, 163, 27);
		newInitiative.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		contentPane.add(newInitiative);
		
		JButton acceptButton = new JButton("Accept");
		acceptButton.setBounds(27, 214, 89, 23);
		contentPane.add(acceptButton);
		
		JButton rejectButton = new JButton("Reject");
		rejectButton.setBounds(326, 214, 89, 23);
		contentPane.add(rejectButton);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(55, 98, 314, 83);
		contentPane.add(textPane);
		
		JButton btnAdminMainPage = new JButton("Admin Main Page");
		btnAdminMainPage.setBounds(152, 214, 138, 23);
		contentPane.add(btnAdminMainPage);
	}
}
