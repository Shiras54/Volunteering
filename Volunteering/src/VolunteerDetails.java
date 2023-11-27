import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.event.*;

public class VolunteerDetails extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel VDetails;
	private JButton removeButton,adminButton;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	private Object[][] fullTable;
	private JTable table;
	private Initiative j;
	private String source;


	public static void main(String[] args) {
		new VolunteerDetails(new Initiative());
	}

	public VolunteerDetails(Initiative j) {
		this.j=j;
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
		
		VDetails = new JLabel("Volunteer Details");
		VDetails.setFont(new Font("Tahoma", Font.BOLD, 22));
		VDetails.setBounds(10, 11, 300, 46);
		contentPane.add(VDetails);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 75, 350, 130);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		fullTable = new Object[j.getVolunteers().size()][5];
        for (int i = 0;i<j.getVolunteers().size();i++) {
        	fullTable[i][0]=j.getVolunteers().get(i).getId();
        	fullTable[i][1]=j.getVolunteers().get(i).getName();
        	fullTable[i][3]=j.getVolunteers().get(i).getEmail();
        	fullTable[i][2]=j.getVolunteers().get(i).getPhone();
        	fullTable[i][4]=j.getVolunteers().get(i).getPoints();
        }
        model = new DefaultTableModel(fullTable,
    			new String[] {"ID","Name", "Email", "Phone", "Points"}) {
					private static final long serialVersionUID = 1L;
					public boolean isCellEditable(int row, int column) {
    			       return false;
    			    }};
	    table.setModel(model);
	    table.setAutoCreateRowSorter(true);

		
		removeButton = new JButton("Remove");
		removeButton.setBounds(337, 28, 89, 23);
		contentPane.add(removeButton);
		removeButton.addActionListener(this);
		
		adminButton = new JButton("Back");
		adminButton.setBounds(241, 229, 89, 23);
		contentPane.add(adminButton);
		adminButton.addActionListener(this);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==adminButton) {
			if(source.equals("admin")) {
				new adminmani();
				dispose();
			} else if(source.equals("initiate")) {
				new Initiativemain();
				dispose();
			}
		}else if(table.getSelectedRow()>=0 && e.getSource()==removeButton) {
			j.removeVolunteer(User.searchForUser((String)(table.getValueAt(table.getSelectedRow(),0))));
			resetFrame();
		}
		
	}
	
	public void resetFrame() {
		if (model.getRowCount() > 0) {
		     for (int i = model.getRowCount() - 1; i > -1; i--) {
		         model.removeRow(i);
		     }
		 }
		fullTable = new Object[j.getVolunteers().size()][5];
        for (int i = 0;i<j.getVolunteers().size();i++) {
        	fullTable[i][0]=j.getVolunteers().get(i).getId();
        	fullTable[i][1]=j.getVolunteers().get(i).getName();
        	fullTable[i][3]=j.getVolunteers().get(i).getEmail();
        	fullTable[i][2]=j.getVolunteers().get(i).getPhone();
        	fullTable[i][4]=j.getVolunteers().get(i).getPoints();
        }
        model = new DefaultTableModel(fullTable,
    			new String[] {"ID","Name", "Email", "Phone", "Points"}) {
					private static final long serialVersionUID = 1L;
					public boolean isCellEditable(int row, int column) {
    			       return false;
    			    }};
	    table.setModel(model);
	}
	
	public void setSource(String s) {
		source=s;
	}

}
