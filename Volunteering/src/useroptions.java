import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;



public class useroptions extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel userOptions,image;
	private JButton createIN,volunteer,exit;

	public static void main(String[] args) {
		useroptions frame = new useroptions();
		frame.setVisible(true);
	}

	public useroptions() {
		setTitle("Volunteer For Earth");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Tree-icon.png"));
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		userOptions = new JLabel("User Options");
		userOptions.setFont(new Font("Tahoma", Font.BOLD, 22));
		userOptions.setBounds(129, 11, 154, 42);
		contentPane.add(userOptions);
		
		createIN = new JButton("Create initiative");
		createIN.setBounds(108, 81, 191, 64);
		contentPane.add(createIN);
		
		createIN.addActionListener(this);
		
		volunteer = new JButton("Volunteer");
		volunteer.setBounds(108, 175, 191, 64);
		contentPane.add(volunteer);
		
		volunteer.addActionListener(this);
		
		
		exit = new JButton("Exit");
		exit.setBounds(313, 150, 113, 23);
		contentPane.add(exit);
		
		exit.addActionListener(this);
		
		image = new JLabel("New label");
		image.setIcon(new ImageIcon("opv.png"));
		image.setBounds(352, 22, 63, 64);
		contentPane.add(image);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == createIN) {		
            new Initiativemain().setVisible(true);
			dispose();
		}else if (e.getSource() == volunteer) {
            new Vmainpage().setVisible(true);
			dispose();
		}
		else if (e.getSource() == exit) {
            new Exit().setVisible(true);
			dispose();
		}
	}
}
