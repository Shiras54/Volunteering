import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import java.awt.event.*;


public class adminP2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

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
		
		JLabel newInitiative = new JLabel("Pending initiatives:");
		newInitiative.setBounds(10, 11, 231, 27);
		newInitiative.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		contentPane.add(newInitiative);
		
		JButton AdminMainPageButton = new JButton("Admin Main Page");
		AdminMainPageButton.setBounds(130, 212, 138, 23);
		contentPane.add(AdminMainPageButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 49, 388, 109);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Name", "Number of V", "Time & Date", "Accept", "Remove"
			}
		));
		
		AdminMainPageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	AdminMainPageButtonActionPerformed(evt);
            }
        });
		setVisible(true);
    }

    private void AdminMainPageButtonActionPerformed(ActionEvent evt) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminmani().setVisible(true);
            }
        });
        dispose();
    }
	}

