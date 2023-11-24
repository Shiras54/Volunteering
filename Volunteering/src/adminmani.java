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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class adminmani extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField searchTF;
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
		setBounds(100, 100, 608, 365);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel searchandedit = new JLabel("Search & Edit");
		searchandedit.setBounds(207, 11, 170, 27);
		searchandedit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		contentPane.add(searchandedit);
		
		JLabel search = new JLabel("Search:");
		search.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		search.setBounds(26, 72, 94, 37);
		contentPane.add(search);
		
		searchTF = new JTextField();
		searchTF.setBounds(130, 77, 96, 27);
		contentPane.add(searchTF);
		searchTF.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 133, 504, 80);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
<<<<<<< HEAD
			new Object[][] {
				{"", null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
=======
			new Object[Initiative.pendingInitiatives.size()][3],
>>>>>>> branch 'master' of https://github.com/Shiras54/Volunteering.git
			new String[] {
				"Name", "Number of Volunteers", "Time & Date", "Description", "Remove"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(118);
<<<<<<< HEAD
		table.getColumnModel().getColumn(3).setPreferredWidth(82);
		table.getColumnModel().getColumn(4).setPreferredWidth(78);
=======
		
		JButton d2 = new JButton("D");
		d2.setBounds(272, 177, 89, 16);
		contentPane.add(d2);
		
		JButton d3 = new JButton("D");
		d3.setBounds(272, 197, 89, 16);
		contentPane.add(d3);
		
		JButton r2 = new JButton("R");
		r2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		r2.setBounds(360, 177, 76, 16);
		contentPane.add(r2);
		
		JButton r3 = new JButton("R");
		r3.setBounds(360, 197, 76, 16);
		contentPane.add(r3);
>>>>>>> branch 'master' of https://github.com/Shiras54/Volunteering.git
		
		JLabel image = new JLabel("New label");
		image.setIcon(new ImageIcon("C:\\Users\\saeed\\OneDrive\\Desktop\\sr.png"));
		image.setBounds(495, 11, 77, 73);
		contentPane.add(image);
		
		JButton Exitbutton = new JButton("Exit");
		Exitbutton.setBounds(10, 272, 89, 23);
		contentPane.add(Exitbutton);
<<<<<<< HEAD
=======
		
		setVisible(true);
>>>>>>> branch 'master' of https://github.com/Shiras54/Volunteering.git
	}
}
