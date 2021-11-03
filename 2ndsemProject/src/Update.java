import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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

public class Update extends Thread implements ActionListener{

	private JPanel Updateheading , mainpanel, leftpanel,rightpanel,bottompanel ,center_bottom , ui; 
	private JLabel Updaterecord, backlab;
	private DefaultTableModel model;
	private JTable tabel;
	private JTableHeader header;
	connection cc;
	private JButton back ,btn , update, cancel;
	private JTextField search;
	private JPanel uisouth;
	private JFrame f;
	private ImageIcon eye;
	private JLabel hello;
	int count = 0, change = 0;
	
    public Update() {
    	
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
		Updaterecord = new JLabel("Update Record");
		Updaterecord.setFont(new Font("Arial",Font.BOLD,30));
		Updaterecord.setForeground(Color.white);
		Updaterecord.setHorizontalAlignment(JLabel.CENTER);
		Updateheading = new JPanel(new BorderLayout());
		Updateheading.setPreferredSize(new Dimension(100,100));
		Updateheading.setBackground(Color.black);
		Updateheading.add(Updaterecord,BorderLayout.CENTER);
		Updateheading.add(backlab,BorderLayout.WEST);
		Updateheading.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.BLUE));
		
		
		
		center_bottom = new JPanel();
		center_bottom.setLayout(new FlowLayout());
		
		center_bottom.setPreferredSize(new Dimension(70,70));
		
		ImageIcon img = new ImageIcon("sr.png");
		
		btn = new JButton(img);
		btn.setText("Search");
		btn.setFocusable(false);
		btn.setFont(new Font(Font.SERIF,Font.BOLD,20));
		btn.addActionListener(this);
		search = new JTextField(11);
		
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
		//ui.setBackground(Color.black);
		
		
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
		     
			    
                 eye = new ImageIcon("cartoon-eyes.png");
				
			    hello = new JLabel("Hello user Please Enter your Number ");
			   hello.setHorizontalAlignment(JLabel.CENTER);
			   hello.setHorizontalTextPosition(JLabel.CENTER);
			    hello.setVerticalTextPosition(JLabel.BOTTOM);
			    hello.setFont(new Font(Font.DIALOG,Font.BOLD,30));
			    hello.setForeground(Color.black);
			    hello.setIcon(eye);
			    
			    
			    
			    uisouth = new JPanel();
			    uisouth.setPreferredSize(new Dimension(50,50));
			    update = new JButton("Update");
			    update.addActionListener(this);
			    cancel = new JButton("cancel");
			    cancel.addActionListener(this);
			    uisouth.add(update);
			    uisouth.add(cancel);
		     
		     uisouth.setVisible(false);
		   // ui.add( new JScrollPane(tabel),BorderLayout.CENTER);
		     ui.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		    ui.add(uisouth,BorderLayout.SOUTH);
		    ui.add(hello,BorderLayout.CENTER);
		    
		  
	    f = new JFrame();
	    f.setSize(900,800);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new BorderLayout(10,10));
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.add(Updateheading,BorderLayout.NORTH);
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
						// TODO Auto-generated catch block
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
				
				ImageIcon an = new ImageIcon("angry.png");
				hello.setIcon(an);
				hello.setText("Wrong number");
				hello.setVisible(true);
				
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					
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
		
		
		if (e.getSource() == update) {
			
			
			JLabel head = new JLabel("Update Details");
			head.setBounds(0, 0, 500, 100);
			head.setBackground(Color.black);
			head.setForeground(Color.white);
			head.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
			head.setHorizontalAlignment(JLabel.CENTER);
			head.setOpaque(true);
			
			JLabel name = new JLabel("Name : ");
			name.setBounds(50,150,60,30);
			name.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
			JTextField namef = new JTextField();
			namef.setBounds(150, 150, 200, 30);
			namef.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
			namef.setText((String) model.getValueAt(0, 0));
			namef.setEditable(false);

			JLabel phone = new JLabel("Phone : ");
			phone.setBounds(50,200,70,30);
			phone.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
			
			JTextField phonef = new JTextField();
			phonef.setBounds(150, 200, 200, 30);
			phonef.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
			phonef.setText((String) model.getValueAt(0, 1));
			phonef.setEditable(false);

			
			JLabel ufrom = new JLabel("From : ");
			ufrom.setBounds(50,250,60,30);
			ufrom.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));

			JTextField fromf = new JTextField();
			fromf.setBounds(150, 250, 200, 30);
			fromf.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
			fromf.setText((String) model.getValueAt(0, 3));
			fromf.setEditable(false);

			
			JLabel uto = new JLabel("To : ");
			uto.setBounds(50,300,50,30);
			uto.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));

			JTextField tof = new JTextField();
			tof.setBounds(150, 300, 200, 30);
			tof.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
			tof.setText((String) model.getValueAt(0, 4));
			tof.setEditable(false);

			JLabel tlass = new JLabel("Category :");
			tlass.setBounds(40,350,80,30);
			tlass.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));

			JTextField tlassf = new JTextField();
			tlassf.setBounds(150, 350, 200, 30);
			tlassf.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
			tlassf.setText((String) model.getValueAt(0, 5));
			tlassf.setEditable(false);

			JLabel trainu = new JLabel("Train :");
			trainu.setBounds(50,400,50,30);
			trainu.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
			

			JTextField trainf = new JTextField();
			trainf.setBounds(150, 400, 200, 30);
			trainf.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
			trainf.setText((String) model.getValueAt(0, 6));
			trainf.setEditable(false);
			
			JLabel tik = new JLabel("Tickets :");
			tik.setBounds(50,450,70,30);
			tik.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));

			JTextField tikf = new JTextField();
			tikf.setBounds(150, 450, 200, 30);
			tikf.setText((String) model.getValueAt(0, 7));
			tikf.setEditable(false);
			tikf.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
			JLabel pric = new JLabel("Price :");
			pric.setBounds(50,500,60,30);
			pric.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));

			JTextField pricf = new JTextField();
			pricf.setBounds(150, 500, 200, 30);
			pricf.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
			pricf.setText((String) model.getValueAt(0, 8));
			pricf.setEditable(false);
			
			JLabel bottom = new JLabel();
			bottom.setBounds(0, 600, 500, 200);
			bottom.setBackground(Color.black);
			bottom.setOpaque(true);
			JButton confrim = new JButton("confrim edit");
			confrim.setEnabled(false);
			JButton edit = new JButton("Edit Details");
			edit.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					namef.setEditable(true);
					phonef.setEditable(true);
					fromf.setEditable(true);
					tof.setEditable(true);
					tlassf.setEditable(true);
					trainf.setEditable(true);
					tikf.setEditable(true);
					pricf.setEditable(true);
					edit.setEnabled(false);
				     confrim.setEnabled(true);
					
				}
				
			});
			
			
			
			
			JButton cancel = new JButton("Cancel");
			bottom.add(edit);
			bottom.add(confrim);
			bottom.add(cancel);
			bottom.setLayout(new FlowLayout());
			JFrame frame = new JFrame();
			frame.setSize(500, 700);
			frame.setLayout(null);
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			frame.add(head);
			frame.add(name);
			frame.add(namef);
			frame.add(phone);
			frame.add(phonef);
			frame.add(ufrom);
			frame.add(fromf);
			frame.add(uto);
			frame.add(tof);
			frame.add(tlass);
			frame.add(tlassf);
			frame.add(trainu);
			frame.add(trainf);
			frame.add(tik);
			frame.add(tikf);
			frame.add(pric);
			frame.add(pricf);
			frame.add(bottom);
			frame.setVisible(true);
			
			
			confrim.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					System.out.println(model.getValueAt(0, 5));
						 connection con = new connection();
						 String comand = "update customer_record set"
						 		+" "+"customer_name = '"+namef.getText()+"'"+","
						 		+"phone = "+phonef.getText()+" , cnic = "+model.getValueAt(0, 2)+","+
						 		" starting_point = '"+fromf.getText()+"'"+" ,"
						 		+"end_point = '"+tof.getText()+"'"+", "+
						 		"category = '"+tlassf.getText()+"'"+", "+
						 		"train = '"+trainf.getText()+"',"+
						 		"tickets = "+tikf.getText()+", "+
						 		"price = "+pricf.getText()+", "+
						 		"date_time = '"+model.getValueAt(0, 9)+"'"+" "+
						 		"where phone = "+search.getText()+";";
						 		
						 try {
							con.ps.executeUpdate(comand);
							JOptionPane.showMessageDialog(null, "data updated succesfully");
							new Admin();
						} catch (SQLException e1) {
						
							e1.printStackTrace();
						}
					}
				});
	         }
		
		
		
		if(e.getSource() == cancel) {
			new Admin();
			f.setVisible(false);
		}
		
	}

}
