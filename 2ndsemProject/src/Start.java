import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Start extends MouseAdapter implements ActionListener{
	
	
	private JLabel item1,item2 ,item3 , item4;
	private JButton user , admin , play , back , About;
	private	JLabel background;
	private	JPanel heading;
	private	JLabel text;
	private	JPanel head1;
	private	JPanel menu , east, west , south;
	private	JFrame f = new JFrame();
		
		
	
	 //code for the Start class inside the constructor
	   public Start() {
			
		//code for the userportal box starts	
	    ImageIcon u = new ImageIcon("user.png");
		item1 = new JLabel(u);
		item1.setLayout(new BorderLayout());
	    user= new JButton("User Portal");
	    user.setPreferredSize(new Dimension(100,50));

	    item1.setBackground(new Color(30,144,255));
	    user.setBackground(Color.white);
		user.setForeground(new Color(30,144,255));
		user.setFont(new Font("serif",Font.BOLD,30));
		
		user.setFocusable(false);
		user.addActionListener(this);
		
		item1.add(user,BorderLayout.SOUTH);
		item1.setHorizontalAlignment(JButton.CENTER);
		item1.setVerticalAlignment(JLabel.CENTER);
		item1.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5,new Color(30,144,255)));
		item1.addMouseListener(this);
		item1.setOpaque(true);
	    
		//code for user portal box ends here 
		
		
		//code for admin box starts 
	    ImageIcon c = new ImageIcon("admin.png");
	   
		item2 = new JLabel(c);
	    
		admin = new JButton("Admin Portal");
		admin.setPreferredSize(new Dimension(50,50));
		admin.setBackground(Color.white);
		admin.setForeground(new Color(30,144,255));
		admin.setFocusable(false);
		item2.setLayout(new BorderLayout());
		item2.setBackground(new Color(30,144,255));
		item2.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5,new Color(30,144,255)));
		item2.setForeground(Color.white);
		admin.setFont(new Font("serif",Font.BOLD,30));
		admin.addActionListener(this);
		item2.add(admin,BorderLayout.SOUTH);
		item2.setHorizontalAlignment(JLabel.CENTER);
		item2.setVerticalAlignment(JLabel.CENTER);
	    item2.addMouseListener(this);
		item2.setOpaque(true);
		//code for admin box ends
		
		
		
		    //code for game box starts
		    ImageIcon p = new ImageIcon("games.png");
			item3 = new JLabel(p);
			item3.setLayout(new BorderLayout());
		    play= new JButton("Play Game");
		    play.setPreferredSize(new Dimension(100,50));
            item3.setBackground(new Color(30,144,255));
		    play.setBackground(Color.white);
			play.setForeground(new Color(30,144,255));
			play.setFont(new Font("serif",Font.BOLD,30));
			play.setFocusable(false);
			play.addActionListener(this);
			
			item3.add(play,BorderLayout.SOUTH);
            item3.setHorizontalAlignment(JButton.CENTER);
			item3.setVerticalAlignment(JLabel.CENTER);
			 item3.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5,new Color(30,144,255)));
			 item3.addMouseListener(this);
			  item3.setOpaque(true);
			  //game box ends
			  
			  
			  //about box starts
			    ImageIcon a = new ImageIcon("information-button.png");
				item4 = new JLabel(a);
				item4.setLayout(new BorderLayout());
			    About= new JButton("About");
			    About.setPreferredSize(new Dimension(100,50));
                item4.setBackground(new Color(30,144,255));
			    About.setBackground(Color.white);
				About.setForeground(new Color(30,144,255));
				About.setFont(new Font("serif",Font.BOLD,30));
				About.setFocusable(false);
				About.addActionListener(this);
				item4.add(About,BorderLayout.SOUTH);
                item4.setHorizontalAlignment(JButton.CENTER);
				item4.setVerticalAlignment(JLabel.CENTER);
				item4.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5,new Color(30,144,255)));
				 item4.addMouseListener(this);
				 item4.setOpaque(true);
				 //ends
				 
		
		
		menu = new JPanel(new GridLayout(2,2,50,50));
		east = new JPanel();
		west = new JPanel();
		south = new JPanel();
		JLabel rights = new JLabel("copyrights@ 2021 || Shahzad Haider");
		rights.setForeground(Color.white);
		rights.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		east.setPreferredSize(new Dimension(100,100));
		east.setBackground(new Color(0,0,0,0));
		west.setPreferredSize(new Dimension(100,100));
		
		west.setBackground(new Color(0,0,0,0));
		south.setPreferredSize(new Dimension(100,50));
		south.setBackground(Color.black);
		south.add(rights);
		
		menu.setBackground(new Color(0,0,0,0));
		menu.add(item1);
		menu.add(item2);
		menu.add(item3);
		menu.add(item4);
	
			
		text = new JLabel("Train  Reservation  System");
		text.setForeground(Color.white);
		text.setFont(new Font("serif",Font.BOLD,35));
		text.setHorizontalAlignment(JLabel.CENTER);
		heading = new JPanel();	
		heading.setLayout(new GridLayout(1,1));
		ImageIcon img = new ImageIcon("newback.jpg");	
		
		Image rimg = img.getImage();
		Image tempimg = rimg.getScaledInstance(1600, 900, Image.SCALE_SMOOTH);
		img = new ImageIcon(tempimg);
		
		
		background = new JLabel();

		background.setIcon(img);
		background.setLayout(new BorderLayout(30,30));
	     heading.setPreferredSize(new Dimension(100,100));
	   
	    heading.setBackground(Color.black);
	   
	     heading.add(text);
	    // heading.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 0, Color.blue));
	 
		background.add(heading,BorderLayout.NORTH);
		background.add(south,BorderLayout.SOUTH);
		background.add(east,BorderLayout.EAST);
		background.add(west,BorderLayout.WEST);
		background.add(menu,BorderLayout.CENTER);
		f.setTitle("Train Reservation System");
		f.setSize(900, 800);
		 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 f.setLocationRelativeTo(null);
		 f.setLayout(new GridLayout(1,1));
		 f.add(background);
		 f.setVisible(true);
		}
	
	
	
	public static void main(String[] args) {
		

		
		new Start();
	}
	



//ActionListener Method for all the buttons 
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == user)
		{
			
			new MainMenu();
			f.setVisible(false);
			
			
		}
		
		
		if (e.getSource() == admin)
		{
			
			//verifying password for admin through mysql database
			String adminpass = JOptionPane.showInputDialog("Enter user Password?");
			String adminq = "select adminpass from login where adminpass = '"+adminpass+"'";
			connection conn = new connection();
			
			
			try {
				ResultSet rs = conn.ps.executeQuery(adminq);
				if (rs.next())
				{   f.setVisible(false);
					new Admin();
					
					
				}else {
					JOptionPane.showMessageDialog(null, "wrong passs");
				}
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			}//end of admin button
		
		
		
		
		
		if(e.getSource() == play) {
			
			
			//space for the game developed by zameer
			new CarGame();
			f.setVisible(false);
		}
		
		
		
		
		if(e.getSource() == About) {
			
			new Aboutus();
			f.setVisible(false);
		
		}
		
	}//end of Action Listener method
	
	
	
	
	//Mouse listener for hovering effect
	public void mouseEntered(MouseEvent e) {
		   
		if(e.getSource() == item1) {
			item1.setBackground(Color.white);
		
			user.setBackground(new Color(30,144,255));
			user.setForeground(Color.white);
			
		}
		
		if(e.getSource() == item2) {
			item2.setBackground(Color.white);
			item2.setForeground(Color.black);
			admin.setBackground(new Color(30,144,255));
			admin.setForeground(Color.white);
			
			
		}
		if(e.getSource() == item3) {
			item3.setBackground(Color.white);
		//	item1.setForeground(new Color(30,144,255));
			play.setBackground(new Color(30,144,255));
			play.setForeground(Color.white);
			
		}
		
		if(e.getSource() == item4) {
			item4.setBackground(Color.white);
			item4.setForeground(Color.black);
			About.setBackground(new Color(30,144,255));
			About.setForeground(Color.white);
			
			
		}
		

	}//end of method
	
	@Override
	public void mouseExited(MouseEvent e) {
	
	    if (e.getSource() == item1) {
		item1.setBackground(new Color(30,144,255));
		item1.setForeground(Color.white);
		 user.setBackground(Color.white);
			user.setForeground(new Color(30,144,255));
	    }
	    
	    if (e.getSource() == item2) {
			item2.setBackground(new Color(30,144,255));
			item2.setForeground(Color.white);
			admin.setBackground(Color.white);
			admin.setForeground(new Color(30,144,255));
			
		    }
	    
	    if (e.getSource() == item3) {
			item3.setBackground(new Color(30,144,255));
			item3.setForeground(Color.white);
			 play.setBackground(Color.white);
				play.setForeground(new Color(30,144,255));
		    }
		    
		    if (e.getSource() == item4) {
				item4.setBackground(new Color(30,144,255));
				item4.setForeground(Color.white);
				About.setBackground(Color.white);
				About.setForeground(new Color(30,144,255));
				
			    }
          }//end of method

	

}//end of class
