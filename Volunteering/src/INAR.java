import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class INAR extends JFrame {

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
					INAR frame = new INAR();
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
	public INAR() {
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
		
		JLabel lblNewLabel = new JLabel("Initiatives already registerd in:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(10, 11, 347, 38);
		contentPane.add(lblNewLabel);
		
		JLabel image = new JLabel("New label");
		image.setIcon(new ImageIcon("C:\\Users\\saeed\\OneDrive\\Desktop\\lis.png"));
		image.setBounds(365, 10, 71, 50);
		contentPane.add(image);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backButtonActionPerformed(e);   
			}
		});
		
		backButton.setBounds(10, 229, 89, 23);
		contentPane.add(backButton);
		
		JScrollPane ARtable = new JScrollPane();
		ARtable.setBounds(28, 112, 358, 77);
		contentPane.add(ARtable);
		
		table = new JTable();
		ARtable.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Name", "Expire Date", "Sus.Points", "Withdraw"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(86);
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
