import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class EditingInitiative extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditingInitiative frame = new EditingInitiative();
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
	public EditingInitiative() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\saeed\\OneDrive\\Desktop\\Tree-icon.png"));
		setTitle("Volunteer For Earth");
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 62, 95, 27);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 22));
		contentPane.add(lblName);
		
		JLabel lblNewLabel = new JLabel("Editing initiative");
		lblNewLabel.setBounds(120, 11, 183, 27);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		contentPane.add(lblNewLabel);
		
		JLabel lblNumberOfVolunteers = new JLabel("Number of Volunteers:");
		lblNumberOfVolunteers.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNumberOfVolunteers.setBounds(10, 113, 262, 27);
		contentPane.add(lblNumberOfVolunteers);
		
		JLabel lblTimeDate = new JLabel("Time & Date:\r\n");
		lblTimeDate.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTimeDate.setBounds(10, 161, 157, 27);
		contentPane.add(lblTimeDate);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblDescription.setBounds(10, 204, 143, 27);
		contentPane.add(lblDescription);
		
		textField = new JTextField();
		textField.setBounds(95, 70, 219, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(267, 121, 159, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(158, 169, 219, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(158, 212, 219, 40);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("Back\r\n");
		btnNewButton.setBounds(337, 39, 89, 23);
		contentPane.add(btnNewButton);
	}

}
