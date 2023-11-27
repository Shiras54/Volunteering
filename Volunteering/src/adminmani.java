import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.Font;
import javax.swing.table.*;
import java.awt.event.*;

public class adminmani extends JFrame implements ActionListener,ListSelectionListener,MouseListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField searchTF;
    private JTable table;
    private JTextArea initiativeDescription;
    private Object[][] fullTable;
    private DefaultTableModel model;
    private JLabel image,search,searchandedit;
    private JScrollPane scrollPane;
    private JButton exitButton,pendingI,removeButton,volunteersButton,initiatorButton;

    public static void main(String[] args) {
        adminmani frame = new adminmani();
        frame.setVisible(true);
    }

    public adminmani() {
        setTitle("Volunteer For Earth");
        setIconImage(Toolkit.getDefaultToolkit().getImage("Tree-icon.png"));
        setBackground(Color.LIGHT_GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 750, 365);
        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        searchandedit = new JLabel("Admin Main Page");
        searchandedit.setBounds(173, 11, 218, 27);
        searchandedit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
        contentPane.add(searchandedit);

        search = new JLabel("Search:");
        search.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        search.setBounds(26, 72, 94, 37);
        contentPane.add(search);

        searchTF = new JTextField();
        searchTF.setBounds(130, 77, 96, 27);
        contentPane.add(searchTF);
        searchTF.addActionListener(this);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 120, 504, 120);
        contentPane.add(scrollPane);
        
        initiativeDescription = new JTextArea("Description:\n");
		initiativeDescription.setBounds(530,100,190,150);
		contentPane.add(initiativeDescription);
		initiativeDescription.setEditable(false);

        table = new JTable();
        scrollPane.setViewportView(table);
        fullTable = new Object[Initiative.activeInitiatives.size()][5];
        int i = 0;
        for (Initiative x: Initiative.activeInitiatives) {
        	if(!Initiative.activeInitiatives.get(i).getName().contains(searchTF.getText())) {
        		continue;
        	}
        	fullTable[i][0]=x.getId();
        	fullTable[i][1]=x.getName();
        	fullTable[i][2]=x.getVolunteers().size();
        	fullTable[i][3]=x.getDateAsString();
        	fullTable[i][4]=x.getCredit();
        	i++;
        }
        model = new DefaultTableModel(fullTable,
    			new String[] {"ID","Name", "No. of Volunteers", "Time & Date", "Credit"}) {
					private static final long serialVersionUID = 1L;
					public boolean isCellEditable(int row, int column) {
    			       return false;
    			    }};
        table.setModel(model);
        
	    table.getSelectionModel().addListSelectionListener(this);
	    table.addMouseListener(this);
	    table.setAutoCreateRowSorter(true);
	    


        image = new JLabel("New label");
        image.setIcon(new ImageIcon("sr.png"));
        image.setBounds(495, 11, 77, 73);
        contentPane.add(image);

        exitButton = new JButton("Exit");
        exitButton.setBounds(10, 272, 89, 23);
        contentPane.add(exitButton);
        
        exitButton.addActionListener(this);
        
        pendingI = new JButton("Pending Initiatives");
        pendingI.setBounds(389, 272, 159, 23);
        contentPane.add(pendingI);
        
        pendingI.addActionListener(this);
        
        removeButton = new JButton("Remove");
        removeButton.setBounds(200,272,100,23);
        contentPane.add(removeButton);
        
        removeButton.addActionListener(this);
        
        volunteersButton = new JButton("Volunteers");
        volunteersButton.setBounds(250,77,100,23);
        contentPane.add(volunteersButton);
        
        volunteersButton.addActionListener(this);
        
        initiatorButton = new JButton("Initiator");
        initiatorButton.setBounds(360,77,100,23);
        contentPane.add(initiatorButton);
        
        initiatorButton.addActionListener(this);
        
        setVisible(true);
    }


	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
    		initiativeDescription.setText("Description:\n"+Initiative.searchForInitiative(Initiative.activeInitiatives,(String)(table.getValueAt(table.rowAtPoint(e.getPoint()),0))).getDescription());
        }		
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exitButton) {
        	new Exit().setVisible(true);
        	dispose();
        } else if(e.getSource()==pendingI) {
        	new adminP2().setVisible(true);
        	dispose();
        } else if(table.getSelectedRow()>=0 && e.getSource()==removeButton) {
    		Admin.removeInitiative(Initiative.searchForInitiative(Initiative.activeInitiatives,(String)(table.getValueAt(table.getSelectedRow(),0))));
    	} else if(e.getSource()==searchTF) {
    		resetFrame();
    	} else if(table.getSelectedRow()>=0 && e.getSource()==volunteersButton) {
    		VolunteerDetails v = new VolunteerDetails(Initiative.searchForInitiative(Initiative.activeInitiatives,(String)(table.getValueAt(table.getSelectedRow(),0))));
    		v.setSource("admin");
    		dispose();
    	} else if(table.getSelectedRow()>=0 && e.getSource()==initiatorButton) {
    		new InitiatorDetails(Initiative.searchForInitiative(Initiative.activeInitiatives,(String)(table.getValueAt(table.getSelectedRow(),0))).getInitiator());
    		dispose();
    	}
    	
    	resetFrame();
    }


	public void resetFrame() {
		if (model.getRowCount() >= 0) {
		     for (int i = model.getRowCount() - 1; i > -1; i--) {
		         model.removeRow(i);
		     }
		 }
		int t = 0;
		for (Initiative x: Initiative.activeInitiatives) {
        	if(x.getName().contains(searchTF.getText())) {
            	t++;
        	}
		}
		fullTable = new Object[t][5];
		int p = 0;
        for (Initiative x: Initiative.activeInitiatives) {
        	if(x.getName().contains(searchTF.getText())) {
        		fullTable[p][0]=x.getId();
            	fullTable[p][1]=x.getName();
            	fullTable[p][2]=x.getVolunteers().size();
            	fullTable[p][3]=x.getDateAsString();
            	fullTable[p][4]=x.getCredit();
            	p++;
        	}
        }
        model = new DefaultTableModel(fullTable,
    			new String[] {"ID","Name", "No. of Volunteers", "Time & Date", "Credit"}) {
					private static final long serialVersionUID = 1L;
					public boolean isCellEditable(int row, int column) {
    			       return false;
    			    }};
		table.setModel(model);
		
		System.out.print(searchTF.getText());
		
	}
}
