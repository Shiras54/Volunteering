import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class InitiatorDetails extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel Idetails,IName,IAge,IId,NOAI;
	private JButton remove,back;
	private User i;

	public static void main(String[] args) {
		new InitiatorDetails(new User());
	}

	public InitiatorDetails(User i) {
		this.i=i;
		setTitle("Volunteer For Earth");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Tree-icon.png"));
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Idetails = new JLabel(i.getName()+" Details");
		Idetails.setFont(new Font("Tahoma", Font.BOLD, 22));
		Idetails.setBounds(21, 21, 400, 27);
		contentPane.add(Idetails);
		
		IName = new JLabel("Email: "+i.getEmail());
		IName.setFont(new Font("Tahoma", Font.BOLD, 20));
		IName.setBounds(21, 71, 400, 27);
		contentPane.add(IName);
		
		IAge = new JLabel("DoB: "+i.getDobAsString());
		IAge.setFont(new Font("Tahoma", Font.BOLD, 20));
		IAge.setBounds(21, 106, 400, 27);
		contentPane.add(IAge);
		
		IId = new JLabel("Id: "+i.getId());
		IId.setFont(new Font("Tahoma", Font.BOLD, 20));
		IId.setBounds(21, 148, 400, 27);
		contentPane.add(IId);
		
		int j=0;
		
		if(i.getInitiative1()!=null && i.getInitiative2()!=null && !i.getInitiative1().getStatus().equals("expired") && !i.getInitiative2().getStatus().equals("expired")) {
			j = 2;
		} else if((i.getInitiative1()!=null && !i.getInitiative1().getStatus().equals("expired")) ^ (i.getInitiative2()!=null && !i.getInitiative2().getStatus().equals("expired"))){
			j = 1;
		}else {
			j = 0;
		}
		
		NOAI = new JLabel("Number of active initiatives: "+j);
		NOAI.setFont(new Font("Tahoma", Font.BOLD, 20));
		NOAI.setBounds(21, 185, 400, 27);
		contentPane.add(NOAI);
		
		remove = new JButton("Remove User");
		remove.setBounds(305, 25, 120, 23);
		contentPane.add(remove);
		remove.addActionListener(this);
		
		back = new JButton("Back to Admin Main Page");
		back.setBounds(231, 223, 195, 23);
		contentPane.add(back);
		back.addActionListener(this);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			new adminmani();
			dispose();
		} else if(e.getSource()==remove) {
			Admin.removeUser(i);
			new adminmani();
			dispose();
		}
	}

}
