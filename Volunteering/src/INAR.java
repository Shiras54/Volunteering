import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.event.*;


public class INAR extends JFrame implements ActionListener,ListSelectionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel,image;
	private JButton backButton;
	private JScrollPane ARtable;
	private DefaultTableModel model;
	private Object[][] fullTable;

	public static void main(String[] args) {
		new INAR();
	}

	public INAR() {
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
		
		lblNewLabel = new JLabel("Initiatives already registerd in:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(10, 11, 347, 38);
		contentPane.add(lblNewLabel);
		
		image = new JLabel("New label");
		image.setIcon(new ImageIcon("C:\\Users\\saeed\\OneDrive\\Desktop\\lis.png"));
		image.setBounds(365, 10, 71, 50);
		contentPane.add(image);
		
		backButton = new JButton("Back");
		backButton.addActionListener(this);
		backButton.setBounds(10, 229, 89, 23);
		contentPane.add(backButton);
		
		ARtable = new JScrollPane();
		ARtable.setBounds(28, 112, 358, 77);
		contentPane.add(ARtable);
		
		table = new JTable();
		contentPane.add(table);
		ARtable.setViewportView(table);
		
		int j = 0;
		for(Initiative x:User.loggedIn.getVolunteeringJobs()) {
			if(x.getStatus().equals("active")) {
				j++;
			}
		}
		System.out.print(j);
		
		fullTable = new Object[j][5];
		int i = 0;
        while(i<j) {
        	if(User.loggedIn.getVolunteeringJobs().get(i).getStatus().equals("active")) {
	        	fullTable[i][0]=User.loggedIn.getVolunteeringJobs().get(i).getName();
	        	fullTable[i][1]=User.loggedIn.getVolunteeringJobs().get(i).getExpirationDateAsString();
	        	fullTable[i][2]=User.loggedIn.getVolunteeringJobs().get(i).getCredit();
	        	fullTable[i][3]=User.loggedIn.getVolunteeringJobs().get(i).getTime();
	        	i++;
        	}
        }
        model = new DefaultTableModel(fullTable,
    			new String[] {"Name", "Expire Date", "Credits", "Period"}) {
					private static final long serialVersionUID = 1L;
					public boolean isCellEditable(int row, int column) {
    			       return false;
    			    }};
		table.setModel(model);
	    table.setAutoCreateRowSorter(true);
	    
		
		setVisible(true);
	}


	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==backButton) {
			new Vmainpage().setVisible(true);
			dispose();
		}
		
	}

}
