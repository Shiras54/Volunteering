import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class EPI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EPI frame = new EPI();
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
	public EPI() {
		setBackground(Color.LIGHT_GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\saeed\\OneDrive\\Desktop\\Tree-icon.png"));
		setTitle("Volunteer For Earth");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbEPI = new JLabel("Edit Personal Info (V)");
		lbEPI.setFont(new Font("Tahoma", Font.BOLD, 22));
		lbEPI.setBounds(94, 11, 244, 27);
		contentPane.add(lbEPI);
		
		JLabel lblName = new JLabel("Name:\r\n");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblName.setBounds(10, 66, 102, 27);
		contentPane.add(lblName);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblPhoneNumber.setBounds(10, 104, 227, 27);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblEmail.setBounds(10, 142, 116, 27);
		contentPane.add(lblEmail);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth:");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblDateOfBirth.setBounds(10, 180, 164, 27);
		contentPane.add(lblDateOfBirth);
		
		textField = new JTextField();
		textField.setBounds(219, 74, 177, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(219, 112, 177, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(219, 150, 177, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(219, 188, 177, 20);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\saeed\\OneDrive\\Desktop\\fix.png"));
		lblNewLabel_1.setBounds(377, 11, 49, 48);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Done");
		btnNewButton.setBounds(307, 235, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	btnNewButtonActionPerformed(evt);
            }
        });
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(20, 234, 89, 23);
		contentPane.add(btnBack);
	
		btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	btnBackButtonActionPerformed(evt);
	}
		});
	}
            private void  btnNewButtonActionPerformed(ActionEvent evt) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new Vmainpage().setVisible(true);
                    }
                });
                dispose();
            }
            private void  btnBackButtonActionPerformed(ActionEvent evt) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new Vmainpage().setVisible(true);
                    }
                });
                dispose();
            }
		}
