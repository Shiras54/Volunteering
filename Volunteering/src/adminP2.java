import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.event.*;


public class adminP2 extends JFrame implements ActionListener,ListSelectionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton acceptButton,rejectButton,AdminMainPageButton;
	private JLabel newInitiative;
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminP2 frame = new adminP2();
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
	public adminP2() {
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
		
		newInitiative = new JLabel("Pending initiatives:");
		newInitiative.setBounds(10, 11, 231, 27);
		newInitiative.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		contentPane.add(newInitiative);
		
<<<<<<< HEAD
		JButton AdminMainPageButton = new JButton("Admin Main Page");
		AdminMainPageButton.setBounds(130, 212, 138, 23);
=======
		acceptButton = new JButton("Accept");
		acceptButton.setBounds(27, 214, 89, 23);
		contentPane.add(acceptButton);
		acceptButton.addActionListener(this);
		
		rejectButton = new JButton("Reject");
		rejectButton.setBounds(326, 214, 89, 23);
		contentPane.add(rejectButton);
		rejectButton.addActionListener(this);
		
		AdminMainPageButton = new JButton("Admin Main Page");
		AdminMainPageButton.setBounds(152, 214, 138, 23);
>>>>>>> branch 'master' of https://github.com/Shiras54/Volunteering.git
		contentPane.add(AdminMainPageButton);
		
<<<<<<< HEAD
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 49, 388, 109);
=======
		scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 52, 388, 109);
>>>>>>> branch 'master' of https://github.com/Shiras54/Volunteering.git
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
<<<<<<< HEAD
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Name", "Number of V", "Time & Date", "Accept", "Remove"
			}
		));
=======
		Object[][] fullTable = new Object[Initiative.pendingInitiatives.size()][5];
        for (int i = 0;i<Initiative.pendingInitiatives.size();i++) {
        	fullTable[i][0]=Initiative.pendingInitiatives.get(i).getId();
        	fullTable[i][1]=Initiative.pendingInitiatives.get(i).getName();
        	fullTable[i][2]=Initiative.pendingInitiatives.get(i).getDateAsString();
        	fullTable[i][3]=Initiative.pendingInitiatives.get(i).getDescription();
        	fullTable[i][1]=Initiative.pendingInitiatives.get(i).getCredit();
        }
        DefaultTableModel model = new DefaultTableModel(fullTable,
    			new String[] {"ID","Name", "Description", "Time & Date", "credit"}) {
					private static final long serialVersionUID = 1L;
					public boolean isCellEditable(int row, int column) {
    			       return false;
    			    }};
		table.setModel(model);
		
	    table.getSelectionModel().addListSelectionListener(this);
		
>>>>>>> branch 'master' of https://github.com/Shiras54/Volunteering.git
		
		AdminMainPageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	AdminMainPageButtonActionPerformed(evt);
            }
        });
		setVisible(true);
    }

    private void AdminMainPageButtonActionPerformed(ActionEvent evt) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminmani().setVisible(true);
            }
        });
        dispose();
    }
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		EventQueue.invokeLater(new Runnable() {
            public void run() {
            	if(table.getSelectedRow()>0 && e.getSource()==acceptButton) {
            		Admin.approveInitiative(Initiative.searchForInitiative(Initiative.pendingInitiatives,(String)(table.getValueAt(table.getSelectedRow(),0))));
            	}
            	if(table.getSelectedRow()>0 && e.getSource()==rejectButton) {
            		Admin.rejectInitiative(Initiative.searchForInitiative(Initiative.pendingInitiatives,(String)(table.getValueAt(table.getSelectedRow(),0))));
            	}
            	table.repaint();
            }
		
		});		
	}
}

