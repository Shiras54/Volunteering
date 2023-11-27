import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.event.*;

public class Vmainpage extends JFrame implements ActionListener,ListSelectionListener,MouseListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel,lblActiveInitiatives,lblNewLabel_1;
	private JScrollPane scrollPane;
	private JButton Register,InitiativesAlreadyRegisteredButton,EditPersonalInfoButton,GenerateReportButton,Backbutton;
	private DefaultTableModel model;
	private Object[][] fullTable;
	private JTextArea initiativeDescription;

	public static void main(String[] args) {
		new Vmainpage();
	}

	public Vmainpage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Tree-icon.png"));
		setTitle("Volunteer For Earth");
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 362);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Volunteer");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(203, 11, 118, 48);
		contentPane.add(lblNewLabel);
		
		lblActiveInitiatives = new JLabel("Active initiatives:");
		lblActiveInitiatives.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblActiveInitiatives.setBounds(10, 81, 170, 30);
		contentPane.add(lblActiveInitiatives);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 115, 332, 78);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setForeground(Color.BLACK);
		scrollPane.setViewportView(table);
		
		fullTable = new Object[Initiative.activeInitiatives.size()][5];
        for (int i = 0;i<Initiative.activeInitiatives.size();i++) {
        	fullTable[i][0]=Initiative.activeInitiatives.get(i).getId();
        	fullTable[i][1]=Initiative.activeInitiatives.get(i).getName();
        	fullTable[i][2]=Initiative.activeInitiatives.get(i).getDateAsString();
        	fullTable[i][3]=Initiative.activeInitiatives.get(i).getCredit();
        	fullTable[i][4]=Initiative.activeInitiatives.get(i).getDescription();
        }
		
		model = new DefaultTableModel(fullTable,
				new String[] {"ID","Name", "Time & Date", "Credit", "Description"}){
					private static final long serialVersionUID = 1L;
					public boolean isCellEditable(int row, int column) {
						return false;
					}};
		table.setModel(model);
		table.addMouseListener(this);
		table.getSelectionModel().addListSelectionListener(this);
		
		Register = new JButton("Register");
		Register.setBounds(200, 200, 89, 18);
		contentPane.add(Register);
		Register.addActionListener(this);
		
		initiativeDescription = new JTextArea("Description:\n");
		initiativeDescription.setBounds(366,110,149,150);
		contentPane.add(initiativeDescription);
		initiativeDescription.setEditable(false);
		
		InitiativesAlreadyRegisteredButton = new JButton("Initiatives already registered in ");
		InitiativesAlreadyRegisteredButton.setBounds(10, 280, 218, 18);
		contentPane.add(InitiativesAlreadyRegisteredButton);
		
		InitiativesAlreadyRegisteredButton.addActionListener(this);
		
		EditPersonalInfoButton = new JButton("Edit Personal Info");
		EditPersonalInfoButton.setBounds(366, 54, 149, 18);
		contentPane.add(EditPersonalInfoButton);
		
		EditPersonalInfoButton.addActionListener(this);
		
		GenerateReportButton = new JButton("Generate Report");
		GenerateReportButton.setBounds(378, 280, 137, 18);
		contentPane.add(GenerateReportButton);
		
		GenerateReportButton.addActionListener(this);
		
		Backbutton = new JButton("Back");
		Backbutton.setBounds(366, 81, 149, 18);
		contentPane.add(Backbutton);
		
		Backbutton.addActionListener(this);
		
		lblNewLabel_1 = new JLabel("Your Points:"+User.loggedIn.getPoints());
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(10, 221, 163, 32);
		contentPane.add(lblNewLabel_1);
		
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(81);
		
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Backbutton) {
			new useroptions().setVisible(true);
			dispose();
		}else if(e.getSource()==GenerateReportButton) {
			new GenerateReport().setVisible(true);
			dispose();
		}else if(e.getSource()==EditPersonalInfoButton) {
			EPI PI = new EPI();
			PI.source="volunteer";
			dispose();
		}else if(e.getSource()==InitiativesAlreadyRegisteredButton) {
			new INAR().setVisible(true);
			dispose();
		}else if(table.getSelectedRow()>=0 && e.getSource()==Register) {
			User.loggedIn.volunteer(Initiative.searchForInitiative(Initiative.activeInitiatives,(String)(table.getValueAt(table.getSelectedRow(),0))));
		}
	}

	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
    		initiativeDescription.setText("Description:\n"+(String)(table.getValueAt(table.rowAtPoint(e.getPoint()),4)));
        }
	}
	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
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
}
