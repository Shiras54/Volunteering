import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.event.*;

public class GenerateReport extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel commService,image,atendedH,SusP;
	private JButton backButton;
	private JScrollPane commTable;
	private Object[][] fullTable;
	private DefaultTableModel model;


	public static void main(String[] args) {
		new GenerateReport();
	}

	public GenerateReport() {
		setTitle("Volunteer For Earth");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\saeed\\OneDrive\\Desktop\\Tree-icon.png"));
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 344);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		commService = new JLabel("My Community Service Report");
		commService.setBounds(81, 20, 364, 27);
		commService.setFont(new Font("Tahoma", Font.BOLD, 22));
		contentPane.add(commService);
		
		backButton = new JButton("Back");
		backButton.setBounds(462, 279, 89, 23);
		contentPane.add(backButton);

		backButton.addActionListener(this);
		
		commTable = new JScrollPane();
		commTable.setBounds(10, 91, 541, 111);
		contentPane.add(commTable);
		
		table = new JTable();
		commTable.setViewportView(table);
		
		fullTable = new Object[User.loggedIn.getVolunteeringJobs().size()][5];
        for (int i = 0;i<User.loggedIn.getVolunteeringJobs().size();i++) {
        	fullTable[i][0]=User.loggedIn.getVolunteeringJobs().get(i).getName();
        	fullTable[i][1]=User.loggedIn.getVolunteeringJobs().get(i).getTime();
        	fullTable[i][2]=User.loggedIn.getVolunteeringJobs().get(i).getDateAsString().substring(0, 8);
        	fullTable[i][3]=User.loggedIn.getVolunteeringJobs().get(i).getDateAsString().substring(11, 19);
        	fullTable[i][4]=User.loggedIn.getVolunteeringJobs().get(i).getCredit();
        }
        model = new DefaultTableModel(fullTable,
    			new String[] {"Event Name", "Attended Hours", "Date", "Time", "Sus.Points"}) {
					private static final long serialVersionUID = 1L;
					public boolean isCellEditable(int row, int column) {
    			       return false;
    			    }};
		table.setModel(model);
	    table.setAutoCreateRowSorter(true);
		
		image = new JLabel("New label");
		image.setIcon(new ImageIcon("C:\\Users\\saeed\\OneDrive\\Desktop\\xp.png"));
		image.setBounds(502, 11, 49, 54);
		contentPane.add(image);
		
		int hours=0;
		for(Initiative i:User.loggedIn.getVolunteeringJobs()) {
			hours+=i.getTime();
		}
		int credit=0;
		for(Initiative i:User.loggedIn.getVolunteeringJobs()) {
			credit+=i.getCredit();
		}
		
		atendedH = new JLabel("Total Attended Hours: "+hours+" Hours");
		atendedH.setFont(new Font("Tahoma", Font.PLAIN, 17));
		atendedH.setBounds(20, 220, 300, 27);
		contentPane.add(atendedH);
		
		SusP = new JLabel("Total Sustainability Points:"+credit+" Points");
		SusP.setFont(new Font("Tahoma", Font.PLAIN, 17));
		SusP.setBounds(20, 257, 300, 27);
		contentPane.add(SusP);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(77);
		table.getColumnModel().getColumn(1).setPreferredWidth(94);
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==backButton) {
			new Vmainpage().setVisible(true);
			dispose();
		}
		
	}
	}
