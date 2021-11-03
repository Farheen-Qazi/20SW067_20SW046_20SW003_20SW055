import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Addrecord extends JFrame implements ActionListener{
    
	private JLabel background1 , backlab , text;
	private JPanel heading1 , eastborder, westborder, maincenter, southborder;//main frame panels
	private JPanel journey_north , journey_center;
	private JPanel details , journey;
	private JPanel dsouth , dcenter , dcenter_left , dcenter_right;
	private JLabel name , phone , from , to ,customerdetails, journeyDetails 
	,cnic,category,trainname,tickets,space , price , pricespace;
	int no = 0 , temp = 0;
	private JTextField namefield , nofield, cnicfield ;
	private JComboBox start ,ending ,trainclass,selectname;
	private JButton plus, minus ,confirm ,   save ,back;
	Date d;
	SimpleDateFormat format;
	private JPanel splace , scategory ,send ,strain, stickets , sprice;
	private JButton spic;
	private JLabel forpic ;
	private JLabel leftmargin ;
	private JLabel rightmargin ;
	private JLabel southbutton;
	
	public Addrecord() {
		
		background1 = new JLabel();
		background1.setLayout(new BorderLayout());
		
		
		
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
	    text = new JLabel("Enter Details");
		text.setForeground(Color.white);
		text.setFont(new Font("serif",Font.BOLD,35));
		text.setHorizontalAlignment(JLabel.CENTER);
		
		
		
		heading1 = new JPanel(new BorderLayout());
		heading1.setBackground(Color.black);
		heading1.setPreferredSize(new Dimension(100,100));
		heading1.add(backlab,BorderLayout.WEST);
		heading1.add(text, BorderLayout.CENTER);
		heading1.setBorder(BorderFactory.createMatteBorder(0, 0, 10, 0,Color.white));
		eastborder = new JPanel();
	
	
		eastborder.setPreferredSize(new Dimension(100,100));
		
		westborder = new JPanel();
	
		westborder.setPreferredSize(new Dimension(100,100));
		
		southborder = new JPanel(new FlowLayout());
	
		southborder.setPreferredSize(new Dimension(100,100));
		confirm = new JButton("Confirm");
		confirm.setFont(new Font("Arial",Font.BOLD,20));
		confirm.setBackground(Color.black);
		confirm.setForeground(Color.white);
		confirm.setFocusable(false);
		
		confirm.addActionListener(this);
		save = new JButton("Save");
		save.setFont(new Font("Arial",Font.BOLD,20));
		save.setBackground(Color.black);
		save.setForeground(Color.white);
		save.setEnabled(false);
		save.addActionListener(this);
		southborder.add(confirm);
		southborder.add(save);
		
		
		maincenter = new JPanel(new GridLayout(2,1,0,10));
		maincenter.setBackground(Color.white);
		maincenter.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,Color.black));
		maincenter.setPreferredSize(new Dimension(100,100));
		
		
		
		details = new JPanel(new BorderLayout(50,20));
		customerdetails = new JLabel("Customer Details");
		customerdetails.setFont(new Font("Arial",Font.BOLD,30));
		customerdetails.setForeground(Color.white);
		
		dcenter = new JPanel(new GridLayout(1,2));
		dcenter.setBackground(Color.blue);
		dcenter_left = new JPanel();
		dcenter_right = new JPanel(new BorderLayout());
		spic = new JButton("select pic");
		spic.addActionListener(this);
		 forpic = new JLabel();
	 leftmargin = new JLabel();
		 rightmargin = new JLabel();
		 southbutton = new JLabel();
		southbutton.setLayout(new FlowLayout());
		southbutton.setPreferredSize(new Dimension(50,50));
		southbutton.add(spic);
		leftmargin.setPreferredSize(new Dimension(120,120));
		rightmargin.setPreferredSize(new Dimension(120,120));
		forpic.setBackground(Color.white);
		forpic.setHorizontalAlignment(JLabel.CENTER);
		forpic.setOpaque(true);
		dcenter_right.add(southbutton,BorderLayout.SOUTH);
		dcenter_right.add(forpic);
	    dcenter_right.add(leftmargin,BorderLayout.WEST);
	    dcenter_right.add(rightmargin,BorderLayout.EAST);
	
		dcenter.add(dcenter_left);
		dcenter.add(dcenter_right);
		
		dsouth = new JPanel();
		dsouth.add(customerdetails);
		dsouth.setBackground(new Color(30,144,255));
		name = new JLabel("Name : ");
		name.setFont(new Font("Arial",Font.BOLD,15));
		
		name.setHorizontalAlignment(JLabel.CENTER);
		phone = new JLabel("phone : ");
		phone.setFont(new Font("Arial",Font.BOLD,15));
	
		phone.setHorizontalAlignment(JLabel.CENTER);
		namefield = new JTextField(15);
		namefield.setFont(new Font("Arial",Font.BOLD,15));
		
		namefield.addActionListener(this);
	
		
		cnic = new JLabel("CNIC :");
		cnic.setFont(new Font("Arial",Font.BOLD,15));
		
		cnic.setHorizontalAlignment(JLabel.CENTER);
		nofield = new JTextField(15);
		nofield.setFont(new Font("Arial",Font.BOLD,15));
	
		//keylistener for accepting only numbers 
		
		nofield.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent ke) {
				
				if (ke.getKeyChar() >='0' && ke.getKeyChar() <='9' || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
					
					nofield.setEditable(true);
				}
					
			else {
					
					nofield.setEditable(false);
					JOptionPane.showMessageDialog(null,"Only number digits are allowed!");
				}
			}
			
		});
		
		

		cnicfield = new JTextField(13);
		cnicfield.setBounds(70, 160, 200, 30);
		cnicfield.setFont(new Font("Arial",Font.BOLD,15));
		cnicfield.addKeyListener(new KeyAdapter() {
			//keylistener for accepting only numbers 
			public void keyPressed(KeyEvent ke) {
				
				if (ke.getKeyChar() >='0' && ke.getKeyChar() <='9' || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
					
					cnicfield.setEditable(true);
					
				}else {
					
					cnicfield.setEditable(false);
					JOptionPane.showMessageDialog(null,"Only number digits are allowed!");
				}
				
			}
			
		});
		
	
		details.add(dsouth,BorderLayout.NORTH);
		details.add(dcenter,BorderLayout.CENTER);
		dcenter_left.setLayout(new GridLayout(3,2,0,50));
		dcenter_left.add(name);
		dcenter_left.add(namefield);
		dcenter_left.add(phone);
		dcenter_left.add(nofield);
		dcenter_left.add(cnic);
		dcenter_left.add(cnicfield);
		journey = new JPanel();
		journey.setLayout(new BorderLayout());
		
		journey.setBackground(Color.black);
		journeyDetails = new JLabel("Journey Details");
		journeyDetails.setFont(new Font("Arial",Font.BOLD,30));
		journeyDetails.setForeground(Color.white);
		journey_north = new JPanel();
		journey_north.setBackground(Color.green);
		journeyDetails.setForeground(Color.white);
		
		journey_north.add(journeyDetails);
		journey_north.setBackground(new Color(30,144,255));
		journey.add(journey_north , BorderLayout.NORTH);
		from = new JLabel("from : ");
		from.setBounds(20, 50, 80, 50);
		from.setFont(new Font("Arial",Font.BOLD,15));
		 to = new JLabel("To : ");
		to.setBounds(20, 100, 80, 50);
		to.setFont(new Font("Arial",Font.BOLD,15));
		
		String s[] = {"Karachi","sanghar","Larkana","Hyderabad","mirpurkhas","sukhur","Lahore","Islamabad"};
		String e[] = {"Karachi","sanghar","Larkana","Hyderabad","mirpurkhas","sukhur","Lahore","Islamabad"};
		
		start = new JComboBox(s);
		start.setBounds(70, 60, 200, 30);
		ending = new JComboBox(e);
		ending.setBounds(70, 110, 200, 30);
		ending.setFont(new Font("Arial",Font.BOLD,15));
		start.setFont(new Font("Arial",Font.BOLD,15));
		category = new JLabel("Category : ");
		category.setFont(new Font("Arial",Font.BOLD,15));
		category.setBounds(350, 50, 100, 50);
		category.setForeground(Color.black);
		
		String b[] = {"Business Class" , "Economic Class"};
		
		trainclass = new JComboBox(b);
		trainclass.setFont(new Font("Arial",Font.BOLD,15));
		trainclass.setBounds(420, 60, 150, 30);
		
	
	
		trainname = new JLabel("Train : ");
		trainname.setFont(new Font("Arial",Font.BOLD,15));
		trainname.setBounds(370, 100, 100, 50);
		trainname.setForeground(Color.black);
		
		String tname[] = {"Awami Express","Super Express","Rawalpindi Express" , "HybridExpress"};
		
		selectname = new JComboBox(tname);
		selectname.setBounds(420, 110, 150, 30);
		selectname.setFont(new Font("Arial",Font.BOLD,15));
		
		price = new JLabel("price : ");
		price.setBounds(370, 150, 100, 50);
		price.setForeground(Color.black);
		price.setFont(new Font("Arial",Font.BOLD,15));
		
		
		pricespace = new JLabel(String.valueOf(temp));
		pricespace.setBounds(420, 160, 100, 30);
		pricespace.setBackground(Color.white);
		pricespace.setFont(new Font("Arial",Font.BOLD,15));
		pricespace.setHorizontalAlignment(JLabel.CENTER);
		pricespace.setOpaque(true);
		
		tickets = new JLabel("Tickets :");
		tickets.setBounds(20, 150, 80, 50);
		tickets.setFont(new Font("Arial",Font.BOLD,15));
		
		minus = new JButton("-");
		minus.setBounds(70, 160, 40, 30);
		minus.setFocusable(false);
		minus.addActionListener(this);
		space = new JLabel(""+no);
		space.setBounds(110,160,30,30);
		space.setHorizontalAlignment(JLabel.CENTER);
		space.setBackground(Color.white);
		space.setFont(new Font("Arial",Font.BOLD,15));
		space.setOpaque(true);
		plus = new JButton("+");
		plus.setBounds(140,160,45,30);
		plus.setFocusable(false);
		plus.addActionListener(this);
		
		journey_center = new JPanel(new GridLayout(3,2));
		journey_center.setBackground(Color.pink);
		journey.add(journey_center,BorderLayout.CENTER);
		
		splace = new JPanel();
		splace.add(from);
		splace.add(start);
		
		
		scategory = new JPanel();
		scategory.add(category);
		scategory.add(trainclass);
		
		send = new JPanel();
		send.add(to);
		send.add(ending);
		
		strain = new JPanel();
		strain.add(trainname);
		strain.add(selectname);
		
		stickets = new JPanel();
		stickets.add(tickets);
		stickets.add(minus);
		stickets.add(space);
		stickets.add(plus);
		
		sprice = new JPanel();
		sprice.add(price);
		sprice.add(pricespace);
		
		journey_center.add(splace);
		journey_center.add(scategory);
		journey_center.add(send);
		journey_center.add(strain);
		journey_center.add(stickets);
		
		journey_center.add(sprice);
	
		maincenter.add(details);
		maincenter.add(journey);
	
		
		background1.add(heading1, BorderLayout.NORTH);
		background1.add(eastborder,BorderLayout.EAST);
		background1.add(southborder,BorderLayout.SOUTH);
	    background1.add(maincenter,BorderLayout.CENTER);
	    background1.add(westborder,BorderLayout.WEST);
	    
	    
	    
		
		this.setSize(1000,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(1,1));
		this.add(background1);
		this.setVisible(true);
		
		
	}
	
	
	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == plus)
		{    
			if (no < 8)
			{
			trainclass.setEnabled(false);
			no++;
			space.setText(""+no);
			
			
			if(trainclass.getSelectedItem() == "Business Class") 
			//for business class 1000 will be incremented in price
				 temp+=1000;
		
			 
			 
			 
			else
			temp+=2000;
			
			 space.setText(""+no);
			pricespace.setText(""+temp);
			}
		}
		
		
		
		if (e.getSource() == minus)
		{   
			if (no > 0)
			{  no--;
			  space.setText(""+no);
			
			  
			  if(trainclass.getSelectedItem() == "Business Class")
			 temp-=1000;
			else
			temp-=2000;
			
			  
			  pricespace.setText(""+temp);
			
			 
			if(no == 0)
			 trainclass.setEnabled(true);
			
		}
		
		}
		
		
		//action listener for confirming the form
		if(e.getSource() == confirm)
			{  
			
			if(!(namefield.getText().equals("")) && !(cnicfield.getText().equals("")) && !(nofield.getText().equals("")) && no!=0 && temp!=0) {  
			
				if(start.getSelectedItem() != ending.getSelectedItem()) {
				
					
				if(ending.getSelectedItem().equals("Islamabad")) {
					
					
					selectname.setSelectedIndex(2);
					JOptionPane.showMessageDialog(null, "only Rawalpindi express is available for destination ");
				}
				
				
				JOptionPane.showMessageDialog(null, "form submitted successfully");
              
                confirm.setEnabled(false);
				save.setEnabled(true);
				
			}
				
			else 
		JOptionPane.showMessageDialog(null, "Same starting and ending points impossible");
			
		}//main if ends
			
		else {
			JOptionPane.showMessageDialog(null, "please fill empy fields ");
		}
			
			}//confirm ends 
		
		
		
		//save starts
		if(e.getSource() == save) {
			
			try {
				
			
			connection cc = new connection();
			
			//variable for storing values of form
			String cname = namefield.getText();
			long cphone = Long.parseLong(nofield.getText());
			long ccnic = Long.parseLong(cnicfield.getText());
			String cstart = (String)start.getSelectedItem();
			String cend = (String)ending.getSelectedItem();
			String ccategory = (String) trainclass.getSelectedItem();
			String ctrain = (String)selectname.getSelectedItem();
			int ctickets = no;
			int cprice = temp;
			
			//date class is used to detect the date at the time of submisson of form
			d = new Date();
            format = new SimpleDateFormat("dd-MM-yy ");
            String cdate;
            cdate =format.format(d);
            String command = "insert into customer_record values ('"+cname+"','"+cphone+"','"+ccnic+"','"+cstart+"','"+cend+"','"+ccategory+"','"+ctrain+"',"+ctickets+","+cprice+",'"+cdate+"')";      
            cc.ps.executeUpdate(command);
			JOptionPane.showMessageDialog(null, "Data Inserted succesfully");
            new MainMenu();
            this.setVisible(false);
            
            
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			//try catch ends
			
			
		}//save ends
		
		
		//for choosing pic file 
		if(e.getSource()==spic) {
			
			JFileChooser choose = new JFileChooser();
			int result = choose.showOpenDialog(null);
			if(result == choose.APPROVE_OPTION) {
				File file = new File(choose.getSelectedFile().getAbsolutePath());
				
		        String var =file.getAbsolutePath();
		      
		        ImageIcon icon = new ImageIcon(var);
		        forpic.setIcon(icon);
				
			}
			
		}
		
		
		if (e.getSource() == back) {
			new MainMenu();
			this.setVisible(false);
		}
		
}//ActionListener ends 
	
}//class ends


