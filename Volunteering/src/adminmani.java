import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;
import javax.swing.JButton;

public class adminmani extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminmani frame = new adminmani();
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
	public adminmani() {
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
		
		JLabel lblNewLabel = new JLabel("Search & Edit");
		lblNewLabel.setBounds(125, 11, 170, 27);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Search:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(26, 72, 94, 37);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(130, 77, 96, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Description");
		btnNewButton.setBounds(259, 138, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Description");
		btnNewButton_1.setBounds(259, 172, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Description");
		btnNewButton_2.setBounds(259, 206, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Remove");
		btnNewButton_3.setBounds(347, 138, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("Remove");
		btnNewButton_3_1.setBounds(347, 172, 89, 23);
		contentPane.add(btnNewButton_3_1);
		
		JButton btnNewButton_3_2 = new JButton("Remove");
		btnNewButton_3_2.setBounds(347, 206, 89, 23);
		contentPane.add(btnNewButton_3_2);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table.setBounds(26, 142, 223, 48);
		contentPane.add(table);
	}

}
