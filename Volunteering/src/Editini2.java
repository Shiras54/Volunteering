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
import javax.swing.JTextField;
import javax.swing.JButton;

public class Editini2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField NOV;
	private JTextField timedate;
	private JTextField descriptionTF;

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
	public Editini2 () {
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
		
		JLabel Inname = new JLabel("Name:");
		Inname.setBounds(10, 62, 95, 27);
		Inname.setFont(new Font("Tahoma", Font.BOLD, 22));
		contentPane.add(Inname);
		
		JLabel editingIn = new JLabel("Editing initiative (2)");
		editingIn.setBounds(95, 11, 234, 27);
		editingIn.setFont(new Font("Tahoma", Font.BOLD, 22));
		contentPane.add(editingIn);
		
		JLabel InNOV = new JLabel("Number of Volunteers:");
		InNOV.setFont(new Font("Tahoma", Font.BOLD, 22));
		InNOV.setBounds(10, 113, 262, 27);
		contentPane.add(InNOV);
		
		JLabel INTime = new JLabel("Time & Date:\r\n");
		INTime.setFont(new Font("Tahoma", Font.BOLD, 22));
		INTime.setBounds(10, 161, 157, 27);
		contentPane.add(INTime);
		
		JLabel lnDescription = new JLabel("Description:");
		lnDescription.setFont(new Font("Tahoma", Font.BOLD, 22));
		lnDescription.setBounds(10, 204, 143, 27);
		contentPane.add(lnDescription);
		
		name = new JTextField();
		name.setBounds(95, 70, 219, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		NOV = new JTextField();
		NOV.setColumns(10);
		NOV.setBounds(267, 121, 159, 20);
		contentPane.add(NOV);
		
		timedate = new JTextField();
		timedate.setColumns(10);
		timedate.setBounds(158, 169, 219, 20);
		contentPane.add(timedate);
		
		descriptionTF = new JTextField();
		descriptionTF.setColumns(10);
		descriptionTF.setBounds(158, 212, 219, 40);
		contentPane.add(descriptionTF);
		
		JButton backbutton = new JButton("Back\r\n");
		backbutton.setBounds(337, 39, 89, 23);
		contentPane.add(backbutton);
		
		JButton btnDone = new JButton("Done");
		btnDone.setBounds(337, 69, 89, 23);
		contentPane.add(btnDone);
		
		btnDone.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	btnDoneActionPerformed(evt);
            }
        });
		
		backbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	backbuttonActionPerformed(evt);
            }
        });
    }

    private void backbuttonActionPerformed(ActionEvent evt) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Initiativemain().setVisible(true);
            }
        });
        dispose();
    }
    
    private void btnDoneActionPerformed(ActionEvent evt) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Initiativemain().setVisible(true);
            }
        });
        dispose();
    }
	}