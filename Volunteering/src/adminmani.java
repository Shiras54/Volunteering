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
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

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
		
		JButton btnNewButton = new JButton("D");
		btnNewButton.setBounds(278, 156, 83, 16);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("R");
		btnNewButton_3.setBounds(360, 156, 76, 16);
		contentPane.add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 133, 269, 80);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"", null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Name", "Number of Volunteers", "Time & Date"
			}
		));
		
		JButton btnD = new JButton("D");
		btnD.setBounds(272, 177, 89, 16);
		contentPane.add(btnD);
		
		JButton btnD_1 = new JButton("D");
		btnD_1.setBounds(272, 197, 89, 16);
		contentPane.add(btnD_1);
		
		JButton btnNewButton_3_3 = new JButton("R");
		btnNewButton_3_3.setBounds(360, 177, 76, 16);
		contentPane.add(btnNewButton_3_3);
		
		JButton btnNewButton_3_4 = new JButton("R");
		btnNewButton_3_4.setBounds(360, 197, 76, 16);
		contentPane.add(btnNewButton_3_4);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\saeed\\OneDrive\\Desktop\\sr.png"));
		lblNewLabel_2.setBounds(349, 11, 77, 73);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_4 = new JButton("Exit");
		btnNewButton_4.setBounds(10, 229, 89, 23);
		contentPane.add(btnNewButton_4);
		table.getColumnModel().getColumn(1).setPreferredWidth(118);
	}

}
