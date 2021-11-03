import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ticket extends Thread implements ActionListener{

	
	private JPanel north,east,west,south,center , center_bottom , ui , left_panel , right_panel, centergrid;
	private JLabel heading , left , mid, right;
	private JLabel name , From , To , tclass ,date ,seat , time;//ticket left panel elemnts
	private JLabel setname , setfrom, seto, setclass , setdate , setseat , setime;//empty db space in left panle
	private JLabel cname , cfrom , cto , cclass;//mid panel elements 
	private JLabel csetname ,csetfrom , cseto ,csetclass;//empty dp space for mid panel
	private JLabel price , regdate , rtime , rseat;
	private JLabel setprice , sregdate , setrtime, setrseat;
	private JLabel bar1,bar2 , passenger , backlab ,hello;
	private JTextField search ;
	private JButton btn,back , print;
	private JPanel info ;
	private JFrame f;
	int count=0 , change=0;
	ImageIcon eye;
	
	public Ticket() {
		

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
		
		
		heading = new JLabel("Your Ticket");
		heading.setForeground(Color.white);
	   heading.setHorizontalAlignment(JLabel.CENTER);
		heading.setFont(new Font(Font.SANS_SERIF, Font.BOLD,35));
		
		
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
		
		center = new JPanel(new BorderLayout(0,10));
		info = new JPanel(new BorderLayout());
	     eye = new ImageIcon("cartoon-eyes.png");
		
	    hello = new JLabel("Hello user Please Enter your Number ");
	   hello.setHorizontalAlignment(JLabel.CENTER);
	   hello.setHorizontalTextPosition(JLabel.CENTER);
	    hello.setVerticalTextPosition(JLabel.BOTTOM);
	    hello.setFont(new Font(Font.DIALOG,Font.BOLD,30));
	    hello.setForeground(Color.black);
	    hello.setIcon(eye);
		info.add(hello,BorderLayout.CENTER);
		
		info.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		info.setBackground(Color.white);
		ui = new JPanel(new GridLayout(1,3));
		ui.setBackground(Color.white);
	
		

		
		left_panel = new JPanel();
		
		
		left = new JLabel("For Accounts");
		left.setBounds(0, 0, 500, 100);
		left.setHorizontalAlignment(JLabel.CENTER);
		left.setForeground(Color.WHITE);
		left.setFont(new Font(Font.SERIF,Font.BOLD,35));
		left.setBackground(Color.RED);
		left.setHorizontalAlignment(JLabel.LEFT);
	    left.setOpaque(true);
	    
	    name = new JLabel("Name");
	    name.setForeground(Color.DARK_GRAY);
	    name.setBounds(30,150 ,60 , 50);
	    name.setFont(new Font("Arial",Font.PLAIN,20));
	    
	    setname = new JLabel();
	    setname.setForeground(Color.DARK_GRAY);
	    setname.setBounds(100,160 ,180 , 30);
	    setname.setFont(new Font("Arial",Font.BOLD,20));
	    setname.setBackground(Color.white);
	    setname.setOpaque(true);
	    
	    
	    
	    
	    From = new JLabel("From");
	    From.setBounds(30,190 ,60 , 50);
	    From.setForeground(Color.DARK_GRAY);
	    From.setFont(new Font("Arial",Font.PLAIN,20));
	    
	    setfrom = new JLabel();
	    setfrom.setForeground(Color.DARK_GRAY);
	    setfrom.setBounds(100,200 ,180 , 30);
	    setfrom.setFont(new Font("Arial",Font.BOLD,20));
	    setfrom.setBackground(Color.white);
	    setfrom.setOpaque(true);
	    
	    
	    To= new JLabel("To");
	    To.setBounds(30,230 ,60 , 50);
	    To.setForeground(Color.DARK_GRAY);
	    To.setFont(new Font("Arial",Font.PLAIN,20));
	    
	    seto = new JLabel();
	    seto.setForeground(Color.DARK_GRAY);
	    seto.setBounds(100,240 ,180 , 30);
	    seto.setFont(new Font("Arial",Font.BOLD,20));
	    seto.setBackground(Color.white);
	    seto.setOpaque(true);
	    
	    tclass = new JLabel("Class");
	    tclass.setBounds(30,270 ,60 , 50);
	    tclass.setForeground(Color.DARK_GRAY);
	    tclass.setFont(new Font("Arial",Font.PLAIN,20));
	    
	    setclass = new JLabel();
	    setclass.setForeground(Color.DARK_GRAY);
	    setclass.setBounds(100,280 ,180 , 30);
	    setclass.setFont(new Font("Arial",Font.BOLD,20));
	    setclass.setBackground(Color.white);
	    setclass.setOpaque(true);
	    
	    date = new JLabel("Date");
	    date.setBounds(30,310 ,60 , 50);
	    date.setForeground(Color.DARK_GRAY);
	    date.setFont(new Font("Arial",Font.PLAIN,20));
	    
	    setdate = new JLabel();
	    setdate.setForeground(Color.DARK_GRAY);
	    setdate.setBounds(100,320 ,180 , 30);
	    setdate.setFont(new Font("Arial",Font.BOLD,20));
	    setdate.setBackground(Color.white);
	    setdate.setOpaque(true);
	    
	    seat = new JLabel("Seat");
	    seat.setBounds(30, 390, 60, 50);
	    seat.setForeground(Color.DARK_GRAY);
	    seat.setFont(new Font("Arial",Font.PLAIN,20));
	    
	    setseat = new JLabel();
	    setseat.setForeground(Color.DARK_GRAY);
	    setseat.setBounds(30,430 ,60 , 30);
	    setseat.setFont(new Font("Arial",Font.BOLD,20));
	    setseat.setBackground(Color.white);
	    setseat.setOpaque(true);
	    
	    setime = new JLabel();
	    setime.setForeground(Color.DARK_GRAY);
	    setime.setBounds(140,430 ,150 , 30);
	    setime.setFont(new Font("Arial",Font.BOLD,20));
	    setime.setBackground(Color.white);
	    setime.setOpaque(true);
	    
	    time = new JLabel("Depart Time");
	    time.setBounds(160, 390, 120, 50);
	    time.setForeground(Color.DARK_GRAY);
	    time.setFont(new Font("Arial",Font.PLAIN,20));
	    
	    
		left_panel.setBackground(new Color(211,211,211));
		left_panel.setBorder(BorderFactory.createDashedBorder(Color.black, 2, 5, 2, false));
		left_panel.setLayout(null);
		left_panel.add(left);
		left_panel.add(name);
		left_panel.add(setname);
		left_panel.add(From);
		left_panel.add(setfrom);
		left_panel.add(To);
		left_panel.add(tclass);
		left_panel.add(date);
		left_panel.add(seto);
		left_panel.add(setclass);
		left_panel.add(setdate);
		left_panel.add(seat);
		left_panel.add(time);
		left_panel.add(setseat);
		left_panel.add(setime);
		
	
	
		
		right_panel =  new JPanel(new BorderLayout());
		right_panel.setBackground(new Color(211,211,211));
		right_panel.setLayout(null);
		
		
		 price = new JLabel("Price");
		    price.setForeground(Color.DARK_GRAY);
		    price.setBounds(40,150 ,60 , 50);
		    price.setFont(new Font("Arial",Font.PLAIN,20));
		    
		    setprice = new JLabel();
		    setprice.setForeground(Color.DARK_GRAY);
		    setprice.setBounds(100,160 ,170 , 30);
		    setprice.setFont(new Font("Arial",Font.BOLD,25));
		    setprice.setBackground(Color.white);
		    setprice.setOpaque(true);
		    
		    regdate = new JLabel("Date");
		    regdate.setForeground(Color.DARK_GRAY);
		    regdate.setBounds(40,200 ,60 , 50);
		    regdate.setFont(new Font("Arial",Font.PLAIN,20));
		    
		    sregdate = new JLabel();
		    sregdate.setForeground(Color.DARK_GRAY);
		    sregdate.setBounds(100,210 ,170 , 30);
		    sregdate.setFont(new Font("Arial",Font.BOLD,25));
		    sregdate.setBackground(Color.white);
		    sregdate.setOpaque(true);
		    
		    rtime= new JLabel("Time");
		    rtime.setBounds(0,350 ,90 , 50);
		    rtime.setForeground(Color.DARK_GRAY);
		    rtime.setFont(new Font("Arial",Font.PLAIN,30));
		    

		    setrtime = new JLabel();
		    setrtime.setForeground(Color.DARK_GRAY);
		    setrtime.setBounds(0,400 ,100 , 30);
		    setrtime.setFont(new Font("Arial",Font.BOLD,25));
		    setrtime.setBackground(Color.white);
		    setrtime.setOpaque(true);
		    
		    rseat= new JLabel("Seat");
		    rseat.setBounds(150,350 ,90 , 50);
		    rseat.setForeground(Color.DARK_GRAY);
		    rseat.setFont(new Font("Arial",Font.PLAIN,30));
		    

		    setrseat = new JLabel();
		    setrseat.setForeground(Color.DARK_GRAY);
		    setrseat.setBounds(150,400 ,100 , 30);
		    setrseat.setFont(new Font("Arial",Font.BOLD,25));
		    setrseat.setBackground(Color.white);
		    setrseat.setOpaque(true);
		
		
		ImageIcon pic = new ImageIcon("smalltrain.png");
		
		right = new JLabel(" Ticket");
		right.setIcon(pic);
		right.setHorizontalTextPosition(JLabel.LEFT);
		right.setIconTextGap(80);
		right.setBounds(0, 0, 480, 100);
		//mid.setHorizontalAlignment(JLabel.CENTER);
		right.setForeground(Color.WHITE);
		right.setFont(new Font(Font.SERIF,Font.BOLD,35));
		right.setBackground(Color.RED);
	    right.setOpaque(true);
		right_panel.add(right);
		right_panel.add(price);
		right_panel.add(setprice);
		right_panel.add(regdate);
		right_panel.add(sregdate);
		right_panel.add(rtime);
		right_panel.add(setrtime);
		right_panel.add(rseat);
		right_panel.add(setrseat);
		
		ImageIcon b = new ImageIcon("barcodeset.png");
		bar1 = new JLabel(b);
		bar1.setBounds(10,200,40,90);
		
		bar2 = new JLabel(b);
		bar2.setBounds(10,290,40,90);
		
		  cname = new JLabel("Name");
		    cname.setForeground(Color.DARK_GRAY);
		    cname.setBounds(60,150 ,60 , 50);
		    cname.setFont(new Font("Arial",Font.PLAIN,20));
		    
		    csetname = new JLabel();
		    csetname.setForeground(Color.DARK_GRAY);
		    csetname.setBounds(120,160 ,170 , 30);
		    csetname.setFont(new Font("Arial",Font.BOLD,20));
		    csetname.setBackground(Color.white);
		    csetname.setOpaque(true);
		    
		    
		    cfrom = new JLabel("From");
		    cfrom.setBounds(60,200 ,60 , 50);
		    cfrom.setForeground(Color.DARK_GRAY);
		    cfrom.setFont(new Font("Arial",Font.PLAIN,20));
		    
		    
		    csetfrom = new JLabel();
		    csetfrom.setForeground(Color.DARK_GRAY);
		    csetfrom.setBounds(120,210 ,170 , 30);
		    csetfrom.setFont(new Font("Arial",Font.BOLD,20));
		    csetfrom.setBackground(Color.white);
		    csetfrom.setOpaque(true);
		    
		    
		    cto= new JLabel("To");
		    cto.setBounds(60,250 ,60 , 50);
		    cto.setForeground(Color.DARK_GRAY);
		    cto.setFont(new Font("Arial",Font.PLAIN,20));
		    
		    cseto = new JLabel();
		    cseto.setForeground(Color.DARK_GRAY);
		    cseto.setBounds(120,260 ,170 , 30);
		    cseto.setFont(new Font("Arial",Font.BOLD,20));
		    cseto.setBackground(Color.white);
		    cseto.setOpaque(true);
		    
		    cclass= new JLabel("Class");
		    cclass.setBounds(70,350 ,90 , 50);
		    cclass.setForeground(Color.DARK_GRAY);
		    cclass.setFont(new Font("Arial",Font.PLAIN,30));
		    

		    csetclass = new JLabel();
		    csetclass.setForeground(Color.DARK_GRAY);
		    csetclass.setBounds(70,400 ,170 , 30);
		    csetclass.setFont(new Font("Arial",Font.BOLD,20));
		    csetclass.setBackground(Color.white);
		    csetclass.setOpaque(true);
		    
		
		centergrid = new JPanel();
		centergrid.setBackground(new Color(211,211,211));
		centergrid.setLayout(null);
		centergrid.add(bar1);
		centergrid.add(bar2);
		centergrid.add(cname);
		centergrid.add(csetname);
		centergrid.add(cfrom);
		centergrid.add(csetfrom);
		centergrid.add(cto);
		centergrid.add(cseto);
		centergrid.add(cclass);
		centergrid.add(csetclass);
		//centergrid.add(name);
		

		mid = new JLabel("Train");
		mid.setHorizontalAlignment(JLabel.CENTER);
		mid.setBounds(0, 0, 480, 100);
		//mid.setHorizontalAlignment(JLabel.CENTER);
		mid.setForeground(Color.WHITE);
		mid.setFont(new Font(Font.SERIF,Font.BOLD,35));
		mid.setBackground(Color.RED);
	    mid.setOpaque(true);
		centergrid.add(mid);
		
		
		
		

		
		
		
	     
		ui.add(left_panel);
		ui.add(centergrid);
		ui.add(right_panel);
		ui.setVisible(false);
		
		center.setPreferredSize(new Dimension(100,100));
	//	center.setBackground(Color.yellow);
		center.add(center_bottom,BorderLayout.NORTH);
		//center.add(ui,BorderLayout.CENTER);
		center.add(info,BorderLayout.CENTER);
		
		north = new JPanel();
		north.setPreferredSize(new Dimension(100,100));
		north.setBackground(Color.black);
		north.setLayout(new BorderLayout());
		north.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.BLUE));
		north.add(heading,BorderLayout.CENTER);
		north.add(backlab,BorderLayout.WEST);
		
		west = new JPanel();
	//	west.setBackground(Color.black);
		west.setPreferredSize(new Dimension(50,50));
		
		east = new JPanel();
		//east.setBackground(Color.black);
		east.setPreferredSize(new Dimension(50,50));
		
		south = new JPanel();
		south.setBackground(Color.black);
		south.setPreferredSize(new Dimension(70,70));
		print = new JButton("Print");
		print.setForeground(Color.white);
		print.setBackground(new Color(30,144,255));
       print.addActionListener(this);
       print.setEnabled(false);
       south.add(print);
		
		
		f = new JFrame();
		f.setSize(1000, 800);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setLayout(new BorderLayout(0,10));
		f.add(north,BorderLayout.NORTH);
		f.add(west, BorderLayout.WEST);
		f.add(east,BorderLayout.EAST);
		f.add(south,BorderLayout.SOUTH);
		f.add(center,BorderLayout.CENTER);
	
		f.setVisible(true);
			
		
	}
	
	//Thread For blinking text
	public void run() {
		
while(true) {
		
	//Before clicking search button
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	//after clicking search button count variable will be incremented from zero 
	else if(count >= 1) {
		
		ImageIcon an = new ImageIcon("angry.png");
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
			
}//while ends
		
				
	}//run method ends
	




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == btn)
		{ 
			
		center.add(ui,BorderLayout.CENTER);
		info.remove(hello);
        center.remove(info);
        
		  try {   
			    
                 String query ="select * from customer_record where phone ="+search.getText()+";";			  
 		    	 connection cc = new connection();
				ResultSet rs = cc.ps.executeQuery(query);
			
					
				
					
			       
				while (rs.next()) {
					btn.setEnabled(false);
					search.setEditable(false);
				    change++;
					ui.setVisible(true);
					setname.setText(rs.getString(1));
					csetname.setText(rs.getString(1));
					setfrom.setText(rs.getString(4));
					csetfrom.setText(rs.getString(4));
					seto.setText(rs.getString(5));
					cseto.setText(rs.getString(5));
					setclass.setText(rs.getString(6));
					csetclass.setText(rs.getString(6));
					sregdate.setText(rs.getString(10));
					setdate.setText(rs.getString(10));
					setprice.setText(rs.getString(9));
					Random ran = new Random();
					int ranseat = ran.nextInt(1000);
					setseat.setText(String.valueOf(ranseat));
					setrseat.setText(String.valueOf(ranseat));
					print.setEnabled(true);
					
					if(setfrom.getText().equals("Karachi")) {
						setrtime.setText(" 7 am");
						setime.setText("7 am");
					}
					else if(setfrom.getText().equals("sanghar")) {
						
						setrtime.setText(" 9 am");
						setime.setText("9 am");
					}
                    else if(setfrom.getText().equals("Larkana")) {
						
						setrtime.setText(" 10 am");
						setime.setText("10 am");
					}
                     else if(setfrom.getText().equals("Hyderabad")) {
 						
						setrtime.setText(" 11 am");
						setime.setText("11 am");
					}
                     else if(setfrom.getText().equals("mirpurkhas")) {
  						
 						setrtime.setText(" 12 Pm");
 						setime.setText("12 Pm");
 					}
                     else if(setfrom.getText().equals("sukhur")) {
   						
  						setrtime.setText(" 1 Pm");
  						setime.setText("1 Pm");
  					}
                     else if(setfrom.getText().equals("Lahore")) {
   						
  						setrtime.setText(" 2 Pm");
  						setime.setText("2 Pm");
  					}
                     else if(setfrom.getText().equals("Islamabad")) {
   						
  						setrtime.setText(" 3 Pm");
  						setime.setText("3 Pm");
  					}
					
					
				} 
					
					
					
				
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		  if(change ==0) {
				info.add(hello);
				center.add(info);
				
				++count;
			
				}
			
		  }//btn ends
		
		
		
		if (e.getSource() == back) {
			f.setVisible(false);
			new MainMenu();
		}
		
	
		//for printing ticket
		if(e.getSource() == print) {
			
			PrinterJob job = PrinterJob.getPrinterJob();
			job.setJobName("Printing data");
			
			job.setPrintable(new Printable() {

				@Override
				public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
					
					if(pageIndex > 0) {
						
						return Printable.NO_SUCH_PAGE;
					}
					
					
					Graphics2D graphics2d = (Graphics2D)graphics;
					graphics2d.translate(pageFormat.getImageableX()*2, pageFormat.getImageableY()*2);
					graphics2d.scale(0.5, 0.5);
					ui.paint(graphics2d);
					return Printable.PAGE_EXISTS;
				}
				
				
			});
			
			
			  if (job.printDialog() == false)
				  return;

				  try {
				        job.print();
				  } catch (PrinterException ex) {
				        // handle exception
				  }
		     }	//print ends
	
		}//method ends


}//class ends
