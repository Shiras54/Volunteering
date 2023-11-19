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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel searchandedit = new JLabel("Search & Edit");
		searchandedit.setBounds(125, 11, 170, 27);
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
		
		JButton d1 = new JButton("D");
		d1.setBounds(278, 156, 83, 16);
		contentPane.add(d1);
		
		JButton r1 = new JButton("R");
		r1.setBounds(360, 156, 76, 16);
		contentPane.add(r1);
		
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
		
		JLabel image = new JLabel("New label");
		image.setIcon(new ImageIcon("C:\\Users\\saeed\\OneDrive\\Desktop\\sr.png"));
		image.setBounds(349, 11, 77, 73);
		contentPane.add(image);
		
		JButton Exitbutton = new JButton("Exit");
		Exitbutton.setBounds(10, 229, 89, 23);
		contentPane.add(Exitbutton);
		table.getColumnModel().getColumn(1).setPreferredWidth(118);
	}

}
