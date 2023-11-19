import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class Initiativemain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Initiativemain frame = new Initiativemain();
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
	public Initiativemain() {
		setForeground(Color.LIGHT_GRAY);
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
		
		JLabel lblNewLabel = new JLabel("Initiator");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(146, 11, 100, 33);
		contentPane.add(lblNewLabel);
		
		JButton editPI = new JButton("Edit Personal Info");
		editPI.setBounds(10, 91, 144, 23);
		contentPane.add(editPI);
		
		JButton AddNewInitiative = new JButton("Add new initiative");
		AddNewInitiative.setBounds(10, 57, 144, 23);
		contentPane.add(AddNewInitiative);
		
		JScrollPane MyInitiativesTable = new JScrollPane();
		MyInitiativesTable.setBounds(10, 193, 209, 59);
		contentPane.add(MyInitiativesTable);
		
		table = new JTable();
		MyInitiativesTable.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
			},
			new String[] {
				"Name", "No of Volunteers"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(46);
		table.getColumnModel().getColumn(1).setPreferredWidth(93);
		
		JButton Back = new JButton("Back");
		Back.setBounds(10, 125, 144, 23);
		contentPane.add(Back);
		
		JLabel lblNewLabel_1 = new JLabel("My Active Initiatives:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(10, 159, 194, 23);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(213, 193, 213, 23);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Edit", "Remove", "V registered"
			}
		));
		
		JButton edit2 = new JButton("E");
		edit2.setBounds(213, 236, 68, 16);
		contentPane.add(edit2);
		
		JButton edit1 = new JButton("E");
		edit1.setBounds(213, 216, 68, 23);
		contentPane.add(edit1);
		
		JButton remove1 = new JButton("R\r\n\r\n");
		remove1.setBounds(272, 216, 78, 23);
		contentPane.add(remove1);
		
		JButton remove2 = new JButton("R\r\n");
		remove2.setBounds(272, 233, 78, 19);
		contentPane.add(remove2);
		
		JButton VR1 = new JButton("V");
		VR1.setBounds(348, 216, 78, 23);
		contentPane.add(VR1);
		
		JButton VR2 = new JButton("V");
		VR2.setBounds(348, 233, 78, 19);
		contentPane.add(VR2);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\saeed\\OneDrive\\Desktop\\ini.png"));
		lblNewLabel_2.setBounds(348, 11, 68, 72);
		contentPane.add(lblNewLabel_2);
		
		JButton Exit = new JButton("Exit");
		Exit.setBounds(179, 91, 144, 23);
		contentPane.add(Exit);
	}
}
