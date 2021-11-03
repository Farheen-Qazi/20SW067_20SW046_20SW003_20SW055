import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu extends MouseAdapter implements ActionListener{
   private JLabel item1,item2,item3,item4 , backlab;
   private JButton book , view ,back;
   private JLabel background;
   private JPanel heading;
   private JLabel text;
   private JPanel head1;
   private JPanel menu , east, west , south;
   private JLabel southlab;
   private JFrame f = new JFrame();
	
   
   public MainMenu() {
	
		
		
	ImageIcon item1Image = new ImageIcon("train.png");
	ImageIcon item2Image = new ImageIcon("guarantee.png");
	
	
	item1 = new JLabel();
	item1.setLayout(new BorderLayout());
    book = new JButton("Book Here");
    book.setPreferredSize(new Dimension(100,50));
    item1.setBackground(new Color(30,144,255));
    book.setBackground(Color.white);
	book.setForeground(new Color(30,144,255));
	book.setFont(new Font("serif",Font.BOLD,30));
	book.setFocusable(false);
	book.addActionListener(this);
	item1.setIcon(item1Image);
	item1.add(book,BorderLayout.SOUTH);
    item1.setHorizontalAlignment(JButton.CENTER);
	item1.setVerticalAlignment(JLabel.TOP);
     item1.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5,new Color(30,144,255)));
	 item1.addMouseListener(this);
	 item1.setOpaque(true);
	 
	 
	 
	 
	item2 = new JLabel();
	view = new JButton("Your Ticket ");
	view.setPreferredSize(new Dimension(50,50));
	view.setBackground(Color.white);
	view.setForeground(new Color(30,144,255));
	view.setFocusable(false);
	item2.setLayout(new BorderLayout());
	item2.setBackground(new Color(30,144,255));
	 item2.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5,new Color(30,144,255)));
	item2.setForeground(Color.white);
	view.setFont(new Font("serif",Font.BOLD,30));
	view.addActionListener(this);
	item2.setIcon(item2Image);
	item2.add(view,BorderLayout.SOUTH);
	item2.setHorizontalAlignment(JLabel.CENTER);
	item2.setVerticalAlignment(JLabel.TOP);
	
	 item2.addMouseListener(this);
	item2.setOpaque(true);
	
	
	menu = new JPanel(new GridLayout(2,1,0,80));
	east = new JPanel();
	west = new JPanel();
	south = new JPanel();
	
	east.setPreferredSize(new Dimension(100,100));
	east.setBackground(new Color(0,0,0,0));
	west.setPreferredSize(new Dimension(100,100));
	
	west.setBackground(new Color(0,0,0,0));
	south.setPreferredSize(new Dimension(100,50));
	south.setBackground(Color.black);
	southlab = new JLabel("copyright@shahza-haider || 20SW067");
	southlab.setForeground(Color.white);
	southlab.setFont(new Font("Arial",Font.BOLD,15));
	south.add(southlab);
	menu.setBackground(new Color(0,0,0,0));
	menu.add(item1);
	menu.add(item2);
	
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
    text = new JLabel("User Portal");
	text.setForeground(Color.white);
	text.setFont(new Font("serif",Font.BOLD,35));
	text.setHorizontalAlignment(JLabel.CENTER);
	heading = new JPanel();	
	heading.setLayout(new BorderLayout());
	ImageIcon img = new ImageIcon("newback.jpg");	
	background = new JLabel();

	Image rimg = img.getImage();
	Image tempimg = rimg.getScaledInstance(1600, 900, Image.SCALE_SMOOTH);
	img = new ImageIcon(tempimg);
	
	background.setIcon(img);
	background.setLayout(new BorderLayout(150,50));
     heading.setPreferredSize(new Dimension(100,100));
     heading.setBackground(Color.black);
    
    heading.add(backlab,BorderLayout.WEST);
     heading.add(text,BorderLayout.CENTER);
    
     heading.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.BLUE));
    //heading.add(head1,BorderLayout.EAST);
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
	//constructor ends 

	
	
	@Override
	public void mouseEntered(MouseEvent e) {
	   
		if(e.getSource() == item1) {
			item1.setBackground(Color.white);
			book.setBackground(new Color(30,144,255));
			book.setForeground(Color.white);
			
		}
		
		if(e.getSource() == item2) {
			item2.setBackground(Color.white);
			item2.setForeground(Color.black);
			view.setBackground(new Color(30,144,255));
			view.setForeground(Color.white);
			
			
		}

			
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
	
	    if (e.getSource() == item1) {
		item1.setBackground(new Color(30,144,255));
		item1.setForeground(Color.white);
		 book.setBackground(Color.white);
			book.setForeground(new Color(30,144,255));
	    }
	    
	    if (e.getSource() == item2) {
			item2.setBackground(new Color(30,144,255));
			item2.setForeground(Color.white);
			view.setBackground(Color.white);
			view.setForeground(new Color(30,144,255));
			
		    }
	    

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource() == book)
		{
			//new Addrecord();
			new Addrecord();
			f.setVisible(false);
		}
		
		if(e.getSource() == view) {
			
			Ticket t1 =new Ticket();
			t1.start();
			f.setVisible(false);
		}
		
		if(e.getSource() == back) {
			new Start();
			f.setVisible(false);
		}
		
	}


}
