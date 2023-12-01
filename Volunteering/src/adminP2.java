import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.event.*;


public class adminP2 extends JFrame implements ActionListener,MouseListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton acceptButton,rejectButton,AdminMainPageButton;
	private JLabel newInitiative;
	private JTextArea initiativeDescription;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	private Object[][] fullTable;

	public static void main(String[] args) {
		new adminP2();
	}


	public adminP2() {
		setTitle("Volunteer For Earth");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\saeed\\OneDrive\\Desktop\\Tree-icon.png"));
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 300);
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
		
		AdminMainPageButton = new JButton("Admin Main Page");
		AdminMainPageButton.setBounds(130, 212, 138, 23);
		acceptButton = new JButton("Accept");
		acceptButton.setBounds(77, 214, 89, 23);
		contentPane.add(acceptButton);
		acceptButton.addActionListener(this);
		
		rejectButton = new JButton("Reject");
		rejectButton.setBounds(276, 214, 89, 23);
		contentPane.add(rejectButton);
		rejectButton.addActionListener(this);
		
		AdminMainPageButton = new JButton("Admin Main Page");
		AdminMainPageButton.setBounds(456, 214, 138, 23);
		contentPane.add(AdminMainPageButton);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 52, 388, 150);
		contentPane.add(scrollPane);
		
		initiativeDescription = new JTextArea("Description:\n");
		initiativeDescription.setBounds(430,52,190,150);
		contentPane.add(initiativeDescription);
		initiativeDescription.setEditable(false);
		
		table = new JTable();
		scrollPane.setViewportView(table);

		fullTable = new Object[Initiative.pendingInitiatives.size()][5];
        for (int i = 0;i<Initiative.pendingInitiatives.size();i++) {
        	fullTable[i][0]=Initiative.pendingInitiatives.get(i).getId();
        	fullTable[i][1]=Initiative.pendingInitiatives.get(i).getName();
        	fullTable[i][3]=Initiative.pendingInitiatives.get(i).getDateAsString();
        	fullTable[i][2]=Initiative.pendingInitiatives.get(i).getDescription();
        	fullTable[i][4]=Initiative.pendingInitiatives.get(i).getCredit();
        }
        model = new DefaultTableModel(fullTable,
    			new String[] {"ID","Name", "Description", "Time & Date", "Credit"}) {
					private static final long serialVersionUID = 1L;
					public boolean isCellEditable(int row, int column) {
    			       return false;
    			    }};
		table.setModel(model);
	    table.setAutoCreateRowSorter(true);

		
	    table.addMouseListener(this);
				
		AdminMainPageButton.addActionListener(this);
		setVisible(true);
    }


	public void valueChanged(ListSelectionEvent e) {		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
    	if(table.getSelectedRow()>=0 && e.getSource()==acceptButton) {
    		Admin.approveInitiative(Initiative.searchForInitiative(Initiative.pendingInitiatives,(String)(table.getValueAt(table.getSelectedRow(),0))));
    		
    	} else if(table.getSelectedRow()>=0 && e.getSource()==rejectButton) {
    		Admin.rejectInitiative(Initiative.searchForInitiative(Initiative.pendingInitiatives,(String)(table.getValueAt(table.getSelectedRow(),0))));
    	} else if(e.getSource()==AdminMainPageButton) {
    		new adminmani().setVisible(true);
    		dispose();
    	}
    	resetFrame();
    	
    }
	public void resetFrame() {
		if (model.getRowCount() > 0) {
		     for (int i = model.getRowCount() - 1; i > -1; i--) {
		         model.removeRow(i);
		     }
		 }
		fullTable = new Object[Initiative.pendingInitiatives.size()][5];
        for (int i = 0;i<Initiative.pendingInitiatives.size();i++) {
        	fullTable[i][0]=Initiative.pendingInitiatives.get(i).getId();
        	fullTable[i][1]=Initiative.pendingInitiatives.get(i).getName();
        	fullTable[i][3]=Initiative.pendingInitiatives.get(i).getDateAsString();
        	fullTable[i][2]=Initiative.pendingInitiatives.get(i).getDescription();
        	fullTable[i][4]=Initiative.pendingInitiatives.get(i).getCredit();
        }
        model = new DefaultTableModel(fullTable,
    			new String[] {"ID","Name", "Description", "Time & Date", "credit"}) {
					private static final long serialVersionUID = 1L;
					public boolean isCellEditable(int row, int column) {
    			       return false;
    			    }};
		table.setModel(model);
		
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
    		initiativeDescription.setText("Description:\n"+(String)(table.getValueAt(table.rowAtPoint(e.getPoint()),2)));
        }
	}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}
}

