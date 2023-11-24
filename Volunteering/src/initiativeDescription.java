import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class initiativeDescription extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initiativeDescription frame = new initiativeDescription();
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
	public initiativeDescription() {
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
		
		JLabel INdescription = new JLabel("(initiative name) Description:");
		INdescription.setBounds(10, 23, 335, 27);
		INdescription.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		contentPane.add(INdescription);
		
		textField = new JTextField();
		textField.setBounds(31, 72, 370, 77);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton BTAMP = new JButton("Back to Admin main page");
		BTAMP.setBounds(236, 207, 190, 23);
		contentPane.add(BTAMP);
		BTAMP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	BTAMPActionPerformed(evt);
            }
        });
		
		JButton R = new JButton("Remove");
		R.setBounds(48, 207, 89, 23);
		contentPane.add(R);
	}

	private void BTAMPActionPerformed(ActionEvent evt) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vmainpage().setVisible(true);
            }
        });
        dispose();
    }
}
