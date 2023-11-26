import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class Page1 extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel,admin,user,KUV,Application;
	private JButton adminButton,userButton;

    public static void main(String[] args) {
        Page1 frame = new Page1();
        frame.setVisible(true);
    }

    public Page1() {
  	
    	
        setTitle("Volunteer For Earth");
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\saeed\\OneDrive\\Desktop\\Tree-icon.png"));
        setForeground(Color.WHITE);
        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 428, 287);
        contentPane = new JPanel();
        contentPane.setForeground(Color.LIGHT_GRAY);
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(335, 21, 0, 0);
		contentPane.add(lblNewLabel);
		
        admin = new JLabel("Admin");
        admin.setFont(new Font("Tahoma", Font.BOLD, 15));
        admin.setBounds(39, 209, 49, 14);
        contentPane.add(admin);

        user = new JLabel("User");
        user.setFont(new Font("Tahoma", Font.BOLD, 15));
        user.setBounds(308, 209, 49, 14);
        contentPane.add(user);

        adminButton = new JButton("Admin");
        adminButton.setForeground(Color.WHITE);
        adminButton.setBackground(Color.WHITE);
        adminButton.setIcon(new ImageIcon("C:\\Users\\saeed\\OneDrive\\Desktop\\use.png"));
        adminButton.setBounds(27, 119, 72, 74);
        contentPane.add(adminButton);

        adminButton.addActionListener(this);

        userButton = new JButton("User");
        userButton.setBackground(Color.WHITE);
        userButton.setForeground(Color.WHITE);
        userButton.setIcon(new ImageIcon("C:\\Users\\saeed\\OneDrive\\Desktop\\usx.png"));
        userButton.setBounds(293, 119, 72, 74);
        contentPane.add(userButton);

        userButton.addActionListener(this);

        KUV = new JLabel("KU Volunteer for the Earth ");
        KUV.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
        KUV.setBounds(90, 11, 245, 46);
        contentPane.add(KUV);

        Application = new JLabel("Application ");
        Application.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
        Application.setBounds(135, 51, 112, 28);
        contentPane.add(Application);
        setVisible(true);
    }

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==adminButton) {
			new adminP1().setVisible(true);
			dispose();

		} else if(e.getSource()==userButton) {
			new userpage1().setVisible(true);
			dispose();
		}
	}
    
}
