import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Delete extends Thread implements ActionListener{

	private JPanel Deleteheading , mainpanel, leftpanel,rightpanel,bottompanel ,center_bottom , ui; 
	private JLabel Deleterecord, backlab;
	private DefaultTableModel model;
	private JTable tabel;
	private JTableHeader header;
	connection cc;
	private JButton back ,btn , delete, cancel;
	private JTextField search;
	private JPanel uisouth;
	private ImageIcon eye;
	private JLabel hello;
	private JFrame f;
	
   int count = 0, change = 0;
	public Delete() {
		

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
		Deleterecord = new JLabel("Delete Record");
		Deleterecord.setFont(new Font("Arial",Font.BOLD,30));
		Deleterecord.setForeground(Color.white);
		Deleterecord.setHorizontalAlignment(JLabel.CENTER);
		Deleteheading = new JPanel(new BorderLayout());
		Deleteheading.setPreferredSize(new Dimension(100,100));
		Deleteheading.setBackground(Color.black);
		Deleteheading.add(Deleterecord,BorderLayout.CENTER);
		Deleteheading.add(backlab,BorderLayout.WEST);
		Deleteheading.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.BLUE));
		
		
		
		center_bottom = new JPanel();
		center_bottom.setLayout(new FlowLayout());
		
		center_bottom.setPreferredSize(new Dimension(70,70));
		
		ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("sr.png"));
		
		btn = new JButton(img);
		btn.setText("Search");
		btn.setFocusable(false);
		btn.setFont(new Font(Font.SERIF,Font.BOLD,20));
		btn.addActionListener(this);
		search = new JTextField(11);
		search.setText("Enter Phone no ..");
		search.setFont(new Font(Font.SERIF,Font.BOLD,20));
		  search.addKeyListener(new KeyAdapter() {
				
				public void keyPressed(KeyEvent ke) {
					
					if (ke.getKeyChar() >='0' && ke.getKeyChar() <='9' || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
						
						search.setEditable(true);
						
					}else {
						
						search.setEditable(false);
						JOptionPane.showMessageDialog(null,"Only number digits are allowed!");
					}
					
				}
				
			});
		  
		center_bottom.add(search);
		center_bottom.add(btn);
		
		ui = new JPanel(new BorderLayout());
		
		
		
		mainpanel = new JPanel(new BorderLayout());
		mainpanel.add(center_bottom,BorderLayout.NORTH);
		mainpanel.add(ui,BorderLayout.CENTER);
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
		    tabel = new JTable(model);
		     header = tabel.getTableHeader();
		     
		     tabel.setBackground(new Color(211,211,211));
			    tabel.setForeground(Color.black);
			    tabel.setFont(new Font(Font.DIALOG,Font.ROMAN_BASELINE,17));
			    
			    
			   
			    header.setBackground(new Color(30,144,255));
			    header.setForeground(Color.white);
			    header.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
		     
			    uisouth = new JPanel();
			    uisouth.setPreferredSize(new Dimension(50,50));
			    delete = new JButton("Delete");
			    delete.addActionListener(this);
			    cancel = new JButton("cancel");
			    cancel.addActionListener(this);
			    uisouth.add(delete);
			    uisouth.add(cancel);
			    uisouth.setVisible(false);
		     
			    eye = new ImageIcon(getClass().getClassLoader().getResource("cartoon-eyes.png"));
				
			    hello = new JLabel("Hello user Please Enter your Number ");
			   hello.setHorizontalAlignment(JLabel.CENTER);
			   hello.setHorizontalTextPosition(JLabel.CENTER);
			    hello.setVerticalTextPosition(JLabel.BOTTOM);
			    hello.setFont(new Font(Font.DIALOG,Font.BOLD,30));
			    hello.setForeground(Color.black);
			    hello.setIcon(eye);
			    
			//  ui.add( new JScrollPane(tabel),BorderLayout.CENTER);
		      ui.add(uisouth,BorderLayout.SOUTH);
		        
		      ui.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		     ui.add(hello, BorderLayout.CENTER);
		     
		         
	    f = new JFrame();
	    f.setSize(900,800);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new BorderLayout(10,10));
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.add(Deleteheading,BorderLayout.NORTH);
		f.add(mainpanel,BorderLayout.CENTER);
		f.add(bottompanel,BorderLayout.SOUTH);
		f.add(leftpanel,BorderLayout.EAST);
	    f.add(rightpanel,BorderLayout.WEST);
		
	}
	
	
	
	
	
	public void run() {
		
		while(true) {
				
			if(count == 0) {
					hello.setVisible(false);
					
					
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					
					hello.setVisible(true);
					hello.setIcon(eye);
					
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
			}
			else if(count >= 1) {
				
				ImageIcon an = new ImageIcon(getClass().getClassLoader().getResource("angry.png"));
				hello.setIcon(an);
				hello.setText("Wrong number");
				hello.setVisible(true);
				
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				hello.setVisible(false);
				
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
					
		}
				
	}			
	
	
	
	
	
	
	
	
	



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== back) {
			f.setVisible(false);
			new Admin();
		}
		
	
		if(e.getSource() == btn) {
		 ui.add( new JScrollPane(tabel),BorderLayout.CENTER);
		 ui.add(uisouth,BorderLayout.SOUTH);
		 hello.setVisible(false);
		 ui.remove(hello);
		 
		
			try {
				
			    cc = new connection();
			    
			    ResultSet rs = cc.ps.executeQuery("select * from customer_record where phone = "+search.getText()+";");
			    while(rs.next()) {
			    	btn.setEnabled(false);
			    	search.setEditable(false);
			    	change++;
			    	uisouth.setVisible(true);
			    	ui.setVisible(true);
			    	model.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)});
			    }
			    } 
			    catch(Exception e1) {
			    	e1.printStackTrace();
			    }
			 
			if(change == 0) {
				ui.remove(new JScrollPane(tabel));
				ui.remove(uisouth);
				hello.setVisible(true);
				ui.add(hello);
			    ++count;
				
				
			}
			
			
			
			
			}
		
		
		if(e.getSource()==delete) {
			
			 cc = new connection();
			 try {
				cc.ps.executeUpdate("delete from customer_record where phone = "+search.getText()+";");
				JOptionPane.showMessageDialog(null, "deleted succesfully");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
			 tabel.setVisible(false);
			 header.setVisible(false);
			 new Admin();
			 f.setVisible(false);
			
		}
		
		if(e.getSource() == cancel) {
			
			new Admin();
			f.setVisible(false);
		}
		
	}

}
