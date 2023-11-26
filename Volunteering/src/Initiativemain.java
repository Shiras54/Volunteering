import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.event.*;


public class Initiativemain extends JFrame implements ActionListener,ListSelectionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel,lblNewLabel_1,lblNewLabel_2;
	private JButton editPI,AddNewInitiative,editInitiativeButton,RemoveInitiativeButton,VolunteersButton,backButton;
	private JScrollPane MyInitiativesTable;
	private Object[][] fullTable;
	private DefaultTableModel model;

	public static void main(String[] args) {
		new Initiativemain();
	}

	public Initiativemain() {
		setForeground(Color.LIGHT_GRAY);
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
		
		lblNewLabel = new JLabel("Initiator");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(146, 11, 100, 33);
		contentPane.add(lblNewLabel);
		
		editPI = new JButton("Edit Personal Info");
		editPI.setBounds(10, 91, 144, 23);
		contentPane.add(editPI);
		editPI.addActionListener(this);
		
		AddNewInitiative = new JButton("Add new initiative");
		AddNewInitiative.setBounds(10, 57, 144, 23);
		contentPane.add(AddNewInitiative);
		AddNewInitiative.addActionListener(this);
		
		MyInitiativesTable = new JScrollPane();
		MyInitiativesTable.setBounds(10, 193, 209, 59);
		contentPane.add(MyInitiativesTable);
		
		table = new JTable();
		MyInitiativesTable.setViewportView(table);
		
		fullTable = new Object[2][2];
		if(User.loggedIn.getInitiative1()==null) {
			fullTable[0][0]=null;
			fullTable[0][1]=null;
		} else {
			fullTable[0][0]=User.loggedIn.getInitiative1().getName();
			fullTable[0][1]=User.loggedIn.getInitiative1().getVolunteers().size();
		}
		if(User.loggedIn.getInitiative2()==null) {
			fullTable[1][0]=null;
			fullTable[1][1]=null;
		} else {
			fullTable[1][0]=User.loggedIn.getInitiative2().getName();
			fullTable[1][1]=User.loggedIn.getInitiative2().getVolunteers().size();
		}
		
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		model = new DefaultTableModel(fullTable,
				new String[] {
						"Name", "No of Volunteers"
					}
				);
		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(46);
		table.getColumnModel().getColumn(1).setPreferredWidth(93);
		
		lblNewLabel_1 = new JLabel("My Active Initiatives:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(10, 159, 194, 23);
		contentPane.add(lblNewLabel_1);		
			
		
		editInitiativeButton = new JButton("Edit");
		editInitiativeButton.setBounds(230, 188, 200, 20);
		contentPane.add(editInitiativeButton);
		editInitiativeButton.addActionListener(this);
		
		
		RemoveInitiativeButton = new JButton("Remove");
		RemoveInitiativeButton.setBounds(230, 210, 200, 20);
		contentPane.add(RemoveInitiativeButton);
		RemoveInitiativeButton.addActionListener(this);

		
		VolunteersButton = new JButton("Volunteer List");
		VolunteersButton.setBounds(230, 232, 200, 20);
		contentPane.add(VolunteersButton);
		VolunteersButton.addActionListener(this);

		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\saeed\\OneDrive\\Desktop\\ini.png"));
		lblNewLabel_2.setBounds(348, 11, 68, 72);
		contentPane.add(lblNewLabel_2);

		backButton = new JButton("Back");
		backButton.addActionListener(this);
		backButton.setBounds(10, 125, 144, 23);
		contentPane.add(backButton);
		
		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(table.getSelectedRow()>=0 && e.getSource()==editInitiativeButton) {
			if(table.getSelectedRow()==0) {
				if(User.loggedIn.getInitiative1()!=null) {
					new EditingInitiative().setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Initiative does not exist!");
				}
			} else if(table.getSelectedRow() == 1) {
				if(User.loggedIn.getInitiative2()!=null) {
					new Editini2().setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Initiative does not exist!");
				}
			}
		} else if(e.getSource()==backButton) {
			new useroptions().setVisible(true);
			dispose();
		} else if(e.getSource()==AddNewInitiative) {
			new AddInitiativee().setVisible(true);
			dispose();
		} else if(table.getSelectedRow()>=0 && e.getSource()==VolunteersButton) {
			if(table.getSelectedRow()==0) {
				if(User.loggedIn.getInitiative1()!=null) {
					VolunteerDetails v = new VolunteerDetails(User.loggedIn.getInitiative1());
					v.setSource("initiate");
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Initiative does not exist!");
				}
			} else if(table.getSelectedRow() == 1) {
				if(User.loggedIn.getInitiative2()!=null) {
					VolunteerDetails v = new VolunteerDetails(User.loggedIn.getInitiative2());
					v.setSource("initiate");
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Initiative does not exist!");
				}
			}
		} else if(table.getSelectedRow()>=0 && e.getSource()==RemoveInitiativeButton) {
			if(table.getSelectedRow()==0) {
				if(User.loggedIn.getInitiative1()!=null) {
					User.loggedIn.terminate(User.loggedIn.getInitiative1());
				} else {
					JOptionPane.showMessageDialog(null, "Initiative does not exist!");
				}
			} else if(table.getSelectedRow() == 1) {
				if(User.loggedIn.getInitiative2()!=null) {
					User.loggedIn.terminate(User.loggedIn.getInitiative2());
				} else {
					JOptionPane.showMessageDialog(null, "Initiative does not exist!");
				}
			}
		} else if(e.getSource()== editPI) {
			EPI PI = new EPI();
			PI.source="initiate";
			dispose();
		}
		resetTable();
	}

	public void valueChanged(ListSelectionEvent e) {
		
	}
	
	public void resetTable() {
		if (model.getRowCount() > 0) {
		     for (int i = model.getRowCount() - 1; i > -1; i--) {
		         model.removeRow(i);
		     }
		 }
		fullTable = new Object[2][2];
		if(User.loggedIn.getInitiative1()==null) {
			fullTable[0][0]=null;
			fullTable[0][1]=null;
		} else {
			fullTable[0][0]=User.loggedIn.getInitiative1().getName();
			fullTable[0][1]=User.loggedIn.getInitiative1().getVolunteers().size();
		}
		if(User.loggedIn.getInitiative2()==null) {
			fullTable[1][0]=null;
			fullTable[1][1]=null;
		} else {
			fullTable[1][0]=User.loggedIn.getInitiative2().getName();
			fullTable[1][1]=User.loggedIn.getInitiative2().getVolunteers().size();
		}
		
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		model = new DefaultTableModel(fullTable,
    			new String[] {"Name", "No of Volunteers"}) {
					private static final long serialVersionUID = 1L;
					public boolean isCellEditable(int row, int column) {
    			       return false;
    			    }};
		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(46);
		table.getColumnModel().getColumn(1).setPreferredWidth(93);
	}
	
}
