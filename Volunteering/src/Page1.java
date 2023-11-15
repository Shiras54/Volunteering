
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import java.awt.Toolkit;

public class Page1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Page1 frame = new Page1();
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
	public Page1() {
		setTitle("Volunteer for Earth");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\saeed\\OneDrive\\Desktop\\Tree-icon.png"));
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 287);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(335, 21, 0, 0);
		contentPane.add(lblNewLabel);
		
		JLabel admin = new JLabel("Admin");
		admin.setFont(new Font("Tahoma", Font.BOLD, 15));
		admin.setBounds(39, 209, 49, 14);
		contentPane.add(admin);
		
		JLabel user = new JLabel("User");
		user.setFont(new Font("Tahoma", Font.BOLD, 15));
		user.setBounds(308, 209, 49, 14);
		contentPane.add(user);
		
		JButton adminButton = new JButton("New button");
		adminButton.setForeground(Color.WHITE);
		adminButton.setBackground(Color.WHITE);
		adminButton.setIcon(new ImageIcon("C:\\Users\\saeed\\OneDrive\\Desktop\\use.png"));
		adminButton.setBounds(27, 119, 72, 74);
		contentPane.add(adminButton);
		
		JButton userButton = new JButton("New button");
		userButton.setBackground(Color.WHITE);
		userButton.setForeground(Color.WHITE);
		userButton.setIcon(new ImageIcon("C:\\Users\\saeed\\OneDrive\\Desktop\\usx.png"));
		userButton.setBounds(293, 119, 72, 74);
		contentPane.add(userButton);
		
		JLabel KUV = new JLabel("KU Volunteer for the Earth ");
		KUV.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		KUV.setBounds(90, 11, 245, 46);
		contentPane.add(KUV);
		
		JLabel Application = new JLabel("Application ");
		Application.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		Application.setBounds(135, 51, 112, 28);
		contentPane.add(Application);
	}
}
