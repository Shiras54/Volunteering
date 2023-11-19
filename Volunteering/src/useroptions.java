import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class useroptions extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					useroptions frame = new useroptions();
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
	public useroptions() {
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
		
		JLabel userOptions = new JLabel("User Options");
		userOptions.setFont(new Font("Tahoma", Font.BOLD, 22));
		userOptions.setBounds(129, 11, 154, 42);
		contentPane.add(userOptions);
		
		JButton createIN = new JButton("Create initiative");
		createIN.setBounds(108, 81, 191, 64);
		contentPane.add(createIN);
		
		JButton Volunteer = new JButton("Volunteer");
		Volunteer.setBounds(108, 175, 191, 64);
		contentPane.add(Volunteer);
		
		JButton Exit = new JButton("Exit");
		Exit.setBounds(313, 150, 113, 23);
		contentPane.add(Exit);
		
		JLabel image = new JLabel("New label");
		image.setIcon(new ImageIcon("C:\\Users\\saeed\\OneDrive\\Desktop\\opv.png"));
		image.setBounds(352, 22, 63, 64);
		contentPane.add(image);
	}
}
