import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class AddInitiativee extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameTF;
	private JTextField timeTF;
	private JTextField descriptionTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddInitiativee frame = new AddInitiativee();
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
	public AddInitiativee() {
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
		
		JLabel lblNewLabel = new JLabel("Creating new initiative");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(93, 11, 280, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lnName = new JLabel("Name:");
		lnName.setFont(new Font("Tahoma", Font.BOLD, 22));
		lnName.setBounds(10, 63, 85, 27);
		contentPane.add(lnName);
		
		JLabel lnTime = new JLabel("Time & Date:");
		lnTime.setFont(new Font("Tahoma", Font.BOLD, 22));
		lnTime.setBounds(10, 119, 146, 27);
		contentPane.add(lnTime);
		
		JLabel lnDescription = new JLabel("Description:");
		lnDescription.setFont(new Font("Tahoma", Font.BOLD, 22));
		lnDescription.setBounds(10, 170, 146, 27);
		contentPane.add(lnDescription);
		
		nameTF = new JTextField();
		nameTF.setBounds(182, 68, 221, 27);
		contentPane.add(nameTF);
		nameTF.setColumns(10);
		
		timeTF = new JTextField();
		timeTF.setColumns(10);
		timeTF.setBounds(182, 124, 221, 27);
		contentPane.add(timeTF);
		
		descriptionTF = new JTextField();
		descriptionTF.setColumns(10);
		descriptionTF.setBounds(182, 171, 224, 56);
		contentPane.add(descriptionTF);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backButtonActionPerformed(e);   
				}
			});
		backButton.setBounds(337, 238, 89, 23);
		contentPane.add(backButton);
		
		JButton btnDone = new JButton("Done");
		btnDone.setBounds(25, 238, 89, 23);
		contentPane.add(btnDone);

		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDoneActionPerformed(e);   
				}
			});
	}
	private void backButtonActionPerformed(ActionEvent evt) {
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
