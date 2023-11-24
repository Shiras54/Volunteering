import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class GenerateReport extends JFrame {

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
					GenerateReport frame = new GenerateReport();
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
	public GenerateReport() {
		setTitle("Volunteer For Earth");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\saeed\\OneDrive\\Desktop\\Tree-icon.png"));
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 344);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel commService = new JLabel("My Community Service Report");
		commService.setBounds(81, 20, 364, 27);
		commService.setFont(new Font("Tahoma", Font.BOLD, 22));
		contentPane.add(commService);
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(462, 279, 89, 23);
		contentPane.add(backButton);

		backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	backButtonActionPerformed(evt);
            }
        });
		
		JScrollPane commTable = new JScrollPane();
		commTable.setBounds(10, 91, 541, 111);
		contentPane.add(commTable);
		
		table = new JTable();
		commTable.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Event Name", "Attended Hours", "Start-End Date", "Start-End Time", "Sus.Points"
			}
		));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\saeed\\OneDrive\\Desktop\\xp.png"));
		lblNewLabel_1.setBounds(502, 11, 49, 54);
		contentPane.add(lblNewLabel_1);
		
		JLabel atendedH = new JLabel("Total Attended Hours:");
		atendedH.setFont(new Font("Tahoma", Font.PLAIN, 17));
		atendedH.setBounds(20, 220, 171, 27);
		contentPane.add(atendedH);
		
		JLabel SusP = new JLabel("Total Sustainability Points:");
		SusP.setFont(new Font("Tahoma", Font.PLAIN, 17));
		SusP.setBounds(20, 257, 209, 27);
		contentPane.add(SusP);
		table.getColumnModel().getColumn(0).setPreferredWidth(77);
		table.getColumnModel().getColumn(1).setPreferredWidth(94);
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
	}
    private void backButtonActionPerformed(ActionEvent evt) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vmainpage().setVisible(true);
            }
        });
        dispose();
    }
	}
