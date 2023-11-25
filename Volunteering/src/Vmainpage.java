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
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class Vmainpage extends JFrame {

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
					Vmainpage frame = new Vmainpage();
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
	public Vmainpage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\saeed\\OneDrive\\Desktop\\Tree-icon.png"));
		setTitle("Volunteer For Earth");
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 362);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Volunteer");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(203, 11, 118, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lblActiveInitiatives = new JLabel("Active initiatives:");
		lblActiveInitiatives.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblActiveInitiatives.setBounds(10, 81, 170, 30);
		contentPane.add(lblActiveInitiatives);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 115, 332, 78);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setForeground(Color.BLACK);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Name", "Time & Date", "Sus.Points", "Description"
			}
		));
		
		JButton R1 = new JButton("register");
		R1.setBounds(337, 138, 89, 18);
		contentPane.add(R1);
		
		JButton R2 = new JButton("register");
		R2.setBounds(337, 157, 89, 18);
		contentPane.add(R2);
		
		JButton R3 = new JButton("register");
		R3.setBounds(337, 175, 89, 18);
		contentPane.add(R3);
		
		JButton InitiativesAlreadyRegisteredButton = new JButton("Initiatives already registered in ");
		InitiativesAlreadyRegisteredButton.setBounds(10, 280, 218, 18);
		contentPane.add(InitiativesAlreadyRegisteredButton);
		
		InitiativesAlreadyRegisteredButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	InitiativesAlreadyRegisteredButtonActionPerformed(evt);
            }
        });
		
		JButton EditPersonalInfoButton = new JButton("Edit Personal Info");
		EditPersonalInfoButton.setBounds(366, 54, 149, 18);
		contentPane.add(EditPersonalInfoButton);
		
		EditPersonalInfoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	EditPersonalInfoButtonActionPerformed(evt);
            }
        });
		
		JButton GenerateReportButton = new JButton("Generate Report");
		GenerateReportButton.setBounds(378, 280, 137, 18);
		contentPane.add(GenerateReportButton);
		
		GenerateReportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	GenerateReportButtonActionPerformed(evt);
            }
        });
		
		JButton Backbutton = new JButton("Back");
		Backbutton.setBounds(366, 81, 149, 18);
		contentPane.add(Backbutton);
		
		Backbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	BackbuttonActionPerformed(evt);
            }
        });
		
		JLabel lblNewLabel_1 = new JLabel("Your Sus.Points:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(10, 221, 163, 32);
		contentPane.add(lblNewLabel_1);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(81);
	}
    private void GenerateReportButtonActionPerformed(ActionEvent evt) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GenerateReport().setVisible(true);
            }
        });
        dispose();
    }
    private void InitiativesAlreadyRegisteredButtonActionPerformed(ActionEvent evt) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new INAR().setVisible(true);
            }
        });
        dispose();
    }
    private void BackbuttonActionPerformed(ActionEvent evt) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new useroptions().setVisible(true);
            }
        });
        dispose();
    }
    private void EditPersonalInfoButtonActionPerformed(ActionEvent evt) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EPI().setVisible(true);
            }
        });
        dispose();
    }
}
