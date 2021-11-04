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

public class Admin extends MouseAdapter implements ActionListener{


    JLabel item1,item2 ,item3,backlab;
    JButton view , delete , update , back;
	JLabel background;
	JPanel heading;
	JLabel text;
	JPanel head1;
	JPanel menu , east, west , south;
	JFrame f = new JFrame();
	
	public Admin() {
		
		
    ImageIcon u = new ImageIcon(getClass().getClassLoader().getResource("criminal-record.png"));
	item1 = new JLabel(u);
	item1.setLayout(new BorderLayout());
    view= new JButton("View Record");
    view.setPreferredSize(new Dimension(100,50));

    item1.setBackground(new Color(30,144,255));
    view.setBackground(Color.white);
	view.setForeground(new Color(30,144,255));
	view.setFont(new Font("serif",Font.BOLD,30));
	
	view.setFocusable(false);
	view.addActionListener(this);
	//item1.setIcon(item1Image);
	item1.add(view,BorderLayout.SOUTH);

	item1.setHorizontalAlignment(JButton.CENTER);
	item1.setVerticalAlignment(JLabel.CENTER);
	
	 item1.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5,new Color(30,144,255)));
	 item1.addMouseListener(this);
	 
	 
	 
    item1.setOpaque(true);
    
    ImageIcon c = new ImageIcon(getClass().getClassLoader().getResource("update (1).png"));
   
	item2 = new JLabel(c);
    
	update = new JButton("Update");
	update.setPreferredSize(new Dimension(50,50));
	update.setBackground(Color.white);
	update.setForeground(new Color(30,144,255));
	update.setFocusable(false);
	item2.setLayout(new BorderLayout());
	item2.setBackground(new Color(30,144,255));
	 item2.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5,new Color(30,144,255)));
	item2.setForeground(Color.white);
	update.setFont(new Font("serif",Font.BOLD,30));
	update.addActionListener(this);
//	item2.setIcon(item2Image);
	item2.add(update,BorderLayout.SOUTH);
	item2.setHorizontalAlignment(JLabel.CENTER);
	item2.setVerticalAlignment(JLabel.CENTER);
	// item2.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.GREEN));
	 item2.addMouseListener(this);
	item2.setOpaque(true);
	
	
	ImageIcon d = new ImageIcon(getClass().getClassLoader().getResource("trash.png"));
	item3 = new JLabel(d);
	item3.setLayout(new BorderLayout());
    delete= new JButton("delete");
    delete.setPreferredSize(new Dimension(100,50));

    item3.setBackground(new Color(30,144,255));
    delete.setBackground(Color.white);
	delete.setForeground(new Color(30,144,255));
	delete.setFont(new Font("serif",Font.BOLD,30));
	
	delete.setFocusable(false);
	delete.addActionListener(this);
	//item1.setIcon(item1Image);
	item3.add(delete,BorderLayout.SOUTH);

	item3.setHorizontalAlignment(JButton.CENTER);
	item3.setVerticalAlignment(JLabel.CENTER);
	
	 item3.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5,new Color(30,144,255)));
	 item3.addMouseListener(this);
	 
	 
	 
    item3.setOpaque(true);
    
	
	
	menu = new JPanel(new GridLayout(2,2,30,30));
	east = new JPanel();
	west = new JPanel();
	south = new JPanel();
	
	east.setPreferredSize(new Dimension(100,100));
	east.setBackground(new Color(0,0,0,0));
	west.setPreferredSize(new Dimension(100,100));
	
	west.setBackground(new Color(0,0,0,0));
	south.setPreferredSize(new Dimension(100,50));
	south.setBackground(new Color(0,0,0,0));
	
	
	menu.setBackground(new Color(0,0,0,0));
	menu.add(item1);
	menu.add(item2);
    menu.add(item3);
		
	text = new JLabel("Admin Portal");
	text.setForeground(Color.white);
	text.setFont(new Font("serif",Font.BOLD,35));
	text.setHorizontalAlignment(JLabel.CENTER);
	
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
	
	
	
	heading = new JPanel();	
	heading.setLayout(new BorderLayout());
	ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("newback.jpg"));	
	background = new JLabel();

	Image rimg = img.getImage();
	Image tempimg = rimg.getScaledInstance(1600, 900, Image.SCALE_SMOOTH);
	img = new ImageIcon(tempimg);
	
	background.setIcon(img);
	background.setLayout(new BorderLayout(50,30));
     heading.setPreferredSize(new Dimension(100,100));
   
    heading.setBackground(Color.black);
   
     heading.add(text,BorderLayout.CENTER);
     heading.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.BLUE));
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
	
	if (e.getSource() == view)
	{
	  f.setVisible(false);
	  new Viewrecord();
	    
	}
	
	if(e.getSource()==delete) {
		
		f.setVisible(false);
		new Delete().start();
	}
			
	
	if(e.getSource() == update) {
		
		f.setVisible(false);
		new Update().start();
	}
		
	if(e.getSource() == back) {
		
		f.setVisible(false);
		new Start();
	}

	
}


public void mouseEntered(MouseEvent e) {
	   
	if(e.getSource() == item1) {
		item1.setBackground(Color.white);
		item1.setForeground(new Color(30,144,255));
		view.setBackground(new Color(30,144,255));
		view.setForeground(Color.white);
		
	}
	
	if(e.getSource() == item2) {
		item2.setBackground(Color.white);
		item2.setForeground(Color.black);
		update.setBackground(new Color(30,144,255));
		update.setForeground(Color.white);
		
		
	}
	
	if(e.getSource() == item3) {
		item3.setBackground(Color.white);
		item3.setForeground(Color.black);
		delete.setBackground(new Color(30,144,255));
		delete.setForeground(Color.white);
		
		
	}
	

}

@Override
public void mouseExited(MouseEvent e) {

    if (e.getSource() == item1) {
	item1.setBackground(new Color(30,144,255));
	item1.setForeground(Color.white);
	 view.setBackground(Color.white);
	 view.setForeground(new Color(30,144,255));
    }
    
    if (e.getSource() == item2) {
		item2.setBackground(new Color(30,144,255));
		item2.setForeground(Color.white);
		update.setBackground(Color.white);
		update.setForeground(new Color(30,144,255));
		
	    } 
    
    if (e.getSource() == item3) {
 		item3.setBackground(new Color(30,144,255));
 		item3.setForeground(Color.white);
 		delete.setBackground(Color.white);
 		delete.setForeground(new Color(30,144,255));
 		
 	    }


}

}
