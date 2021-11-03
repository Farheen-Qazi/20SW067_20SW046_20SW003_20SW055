import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Aboutus extends MouseAdapter implements ActionListener{


	private JLabel item1,item2 ,item3 , item4;
	private JLabel user , admin , play , backlab , About;
	private	JLabel background;
	private	JPanel heading;
	private	JLabel text;
	private	JPanel head1;
	private	JPanel menu , east, west , south;
	private JButton back;
	private	JFrame f = new JFrame();
		
		
	
	 //code for the Start class inside the constructor
	   public Aboutus() {
			
		//code for the userportal box starts	
	    ImageIcon u = new ImageIcon("user.png");
		item1 = new JLabel(u);
		item1.setLayout(new BorderLayout());
		item1.setText("Shahzad Haider");
        item1.setHorizontalTextPosition(JLabel.CENTER);
        item1.setVerticalTextPosition(JLabel.BOTTOM);
		item1.setIconTextGap(20);
	    user= new JLabel("(20SW067)");
	    user.setPreferredSize(new Dimension(100,100));
	    user.setHorizontalAlignment(JLabel.CENTER);
	    user.setVerticalAlignment(JLabel.BOTTOM);
	    user.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
	    user.setForeground(Color.white);
	    
        item1.add(user,BorderLayout.SOUTH);
	    item1.setBackground(new Color(30,144,255));
        item1.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        item1.setForeground(Color.white);
		item1.setHorizontalAlignment(JButton.CENTER);
		item1.setVerticalAlignment(JLabel.CENTER);
		item1.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5,Color.black));
		item1.addMouseListener(this);
		item1.setOpaque(true);
	    
		//code for user portal box ends here 
		
		
		//code for admin box starts 
	    ImageIcon c = new ImageIcon("user.png");
	   
		item2 = new JLabel(c);
	    item2.setText("Zameer Ali");
	    item2.setHorizontalTextPosition(JLabel.CENTER);
        item2.setVerticalTextPosition(JLabel.BOTTOM);
		item2.setIconTextGap(20);
		admin = new JLabel("(20SW046)");
	  
	    admin.setHorizontalAlignment(JLabel.CENTER);
	    admin.setVerticalAlignment(JLabel.BOTTOM);
	    admin.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
	    admin.setForeground(Color.white);
	
		item2.setLayout(new BorderLayout());
		item2.setBackground(new Color(30,144,255));
	
		item2.setForeground(Color.white);
		item2.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		item2.add(admin,BorderLayout.SOUTH);
		item2.setHorizontalAlignment(JLabel.CENTER);
		item2.setVerticalAlignment(JLabel.CENTER);
	    item2.addMouseListener(this);
		item2.setOpaque(true);
		item2.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5,Color.black));
		//code for admin box ends
		
		
		
		    //code for game box starts
		    ImageIcon p = new ImageIcon("user.png");
			item3 = new JLabel(p);
			item3.setLayout(new BorderLayout());
			item3.setText("Zaid Ahmed");
			 item3.setHorizontalTextPosition(JLabel.CENTER);
		     item3.setVerticalTextPosition(JLabel.BOTTOM);
			item3.setIconTextGap(20);
			item3.setForeground(Color.white);
			item3.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));	
			  play= new JLabel("(20SW003)");
			  play.setHorizontalAlignment(JLabel.CENTER);
			  play.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
			  play.setForeground(Color.white);
            item3.setBackground(new Color(30,144,255));
			
			item3.add(play,BorderLayout.SOUTH);
            item3.setHorizontalAlignment(JButton.CENTER);
			item3.setVerticalAlignment(JLabel.CENTER);
			item3.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5,Color.black));
			item3.addMouseListener(this);
			item3.setOpaque(true);
			  //game box ends
			  
			  
			  //about box starts
			    ImageIcon a = new ImageIcon("user.png");
				item4 = new JLabel(a);
				item4.setLayout(new BorderLayout());
				item4.setText("Farheen Qazi");
				 item4.setHorizontalTextPosition(JLabel.CENTER);
			        item4.setVerticalTextPosition(JLabel.BOTTOM);
					item4.setIconTextGap(20);
				    About= new JLabel("(20SW055)");
				    About.setHorizontalAlignment(JLabel.CENTER);
				    About.setVerticalAlignment(JLabel.BOTTOM);
				    About.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
					About.setForeground(Color.white);
					  
                item4.setBackground(new Color(30,144,255));
                item4.setForeground(Color.white);
    			item4.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));	
				item4.add(About,BorderLayout.SOUTH);
                item4.setHorizontalAlignment(JButton.CENTER);
				item4.setVerticalAlignment(JLabel.CENTER);
				item4.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5,Color.black));
				 item4.addMouseListener(this);
				 item4.setOpaque(true);
				 //ends
				 
		
		
		menu = new JPanel(new GridLayout(2,2,50,50));
		east = new JPanel();
		west = new JPanel();
		south = new JPanel();
		JLabel rights = new JLabel("copyrights@ 2021 || AZTech Squad");
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
		
		
			
		text = new JLabel("Project Members");
		text.setForeground(Color.white);
		text.setFont(new Font("serif",Font.BOLD,35));
		text.setHorizontalAlignment(JLabel.CENTER);
		heading = new JPanel();	
		heading.setLayout(new BorderLayout());
		ImageIcon img = new ImageIcon("newback.jpg");	
		
		Image rimg = img.getImage();
		Image tempimg = rimg.getScaledInstance(1600, 900, Image.SCALE_SMOOTH);
		img = new ImageIcon(tempimg);
		
		
		background = new JLabel();

		
		background.setLayout(new BorderLayout(30,30));
	     heading.setPreferredSize(new Dimension(100,100));
	   
	    heading.setBackground(Color.black);
	   
	     heading.add(text,BorderLayout.CENTER);
	     heading.add(backlab,BorderLayout.WEST);
	    
	 
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
	
	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == back) {
			
			new Start();
			f.setVisible(false);
		}
		
	}

}
