import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Viewrecord extends JFrame implements ActionListener{

	
	private JPanel recordheading , mainpanel, leftpanel,rightpanel,bottompanel , uisouth; 
	private JLabel viewrecord, backlab, totalprofit , totaltiks, tcustomer;
	private DefaultTableModel model;
	private JTable tabel;
	connection cc;
	private JButton back;
	int count = 0 , totalprice = 0 , totaltikets = 0;
	private JTextField a , b, c;
	
	public Viewrecord() {

		back = new JButton("Back");
		back.setBounds(10, 20, 90, 40);
		back.setBackground(new Color(30,144,255));
		back.setForeground(Color.white);
		backlab = new JLabel();
		backlab.setPreferredSize(new Dimension(100,100));
		backlab.setLayout(null);
		back.setFocusable(false);
		back.setFont(new Font("serif",Font.BOLD,25));
		back.addActionListener(this);
		backlab.add(back);
		viewrecord = new JLabel("View Record");
		viewrecord.setFont(new Font("Arial",Font.BOLD,30));
		viewrecord.setForeground(Color.white);
		viewrecord.setHorizontalAlignment(JLabel.CENTER);
		recordheading = new JPanel(new BorderLayout());
	    recordheading.setPreferredSize(new Dimension(100,100));
	    recordheading.setBackground(Color.black);
	    recordheading.add(viewrecord,BorderLayout.CENTER);
	    recordheading.add(backlab,BorderLayout.WEST);
	    recordheading.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.BLUE));
		mainpanel = new JPanel(new BorderLayout());
		leftpanel = new JPanel();
		
		rightpanel = new JPanel();
	    bottompanel = new JPanel();
	    bottompanel.setPreferredSize(new Dimension(100,100));
		
		bottompanel.setBackground(Color.black);
		  model = new DefaultTableModel();
	    String columsn[]= {"cutomer_name ","phone","cnic","starting","Ending","category","train","tickets","price","date"};
	   
	    for (int i=0 ; i<columsn.length; i++) {
	    	model.addColumn(columsn[i]);
	    }
	    try {
	    cc = new connection();
	    
	    ResultSet rs = cc.ps.executeQuery("select * from customer_record;");
	    while(rs.next()) {
	    	model.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)});
	        count++;
	        totalprice+=Integer.parseInt(rs.getString(9));
	        totaltikets+=Integer.parseInt(rs.getString(8));
	        
	    }
	    } 
	    catch(Exception e1) {
	    	e1.printStackTrace();
	    }
	    
	 
	    
	    
	    tabel = new JTable(model);
	    tabel.setBackground(new Color(211,211,211));
	    tabel.setForeground(Color.black);
	    tabel.setFont(new Font(Font.DIALOG,Font.ROMAN_BASELINE,17));
	    
	    
	    JTableHeader header = tabel.getTableHeader();
	    header.setBackground(new Color(30,144,255));
	    header.setForeground(Color.white);
	    header.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
	    
	    uisouth = new JPanel();
	    uisouth.setPreferredSize(new Dimension(60,60));
	    totalprofit = new JLabel("Total Price");
	    totalprofit.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
	    a = new JTextField(String.valueOf(totalprice));
	    a.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
	    a.setEditable(false);
	    a.setBackground(Color.black);
	    a.setForeground(Color.white);
	    totaltiks = new JLabel("Tickets booked");
	    totaltiks.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
	    b = new JTextField(String.valueOf(totaltikets));
	    b.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
	    b.setEditable(false);
	    b.setBackground(Color.black);
	    b.setForeground(Color.white);
	    tcustomer = new JLabel("customers");
	    tcustomer.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
	    c = new JTextField(String.valueOf(count));
	    c.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
	    c.setEditable(false);
	    c.setBackground(Color.black);
	    c.setForeground(Color.white);
	    
	    
	    
	    uisouth.add(tcustomer);
	    uisouth.add(c);
	    uisouth.add(totalprofit);
	    uisouth.add(a);
	    uisouth.add(totaltiks);
	    uisouth.add(b);
	    mainpanel.add( new JScrollPane(tabel),BorderLayout.CENTER);
	    mainpanel.add(uisouth,BorderLayout.SOUTH);
	   
	   // mainpanel.setFont(new Font("Arial",Font.BOLD,30));
		this.setSize(900,900);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout(10,10));
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.add(recordheading,BorderLayout.NORTH);
		this.add(mainpanel,BorderLayout.CENTER);
		this.add(bottompanel,BorderLayout.SOUTH);
		this.add(leftpanel,BorderLayout.EAST);
	    this.add(rightpanel,BorderLayout.WEST);
		
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==back) {
			this.setVisible(false);
			
			new Admin();
		}
	}
}
