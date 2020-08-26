import java.awt.Color.*;import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.awt.Font;

public class page4 extends JFrame implements ActionListener,WindowListener {
	private JTextField tf,pf;
	private JButton update,delete,search,logout,exit,back;
	private JLabel l1;
	private JTextArea ta;
	private Frame parent;
	//public static Doctorlogin log1;
	//public static Doctorsignup sup1;
	//public static Home home;
	public page4(){
		super("Window");
		Font f=new Font("Arial",Font.BOLD,26);
		//log1=new Doctorlogin();
		//sup1=new Doctorsignup();
		
		l1=new JLabel("Window");
		l1.setFont(f);
		
		//update=new JButton("Update");
		//delete=new JButton("Delete");
		//search=new JButton("search");
		logout=new JButton("Logout");
		exit=new JButton("Exit");
		back=new JButton("Back");
		ta=new JTextArea(20,70);
		ta.setEditable(false);
		add(ta);
		add(l1);
		
		//add(update);
		//add(delete);
		//add(search);
		add(logout);
		add(back);
		add(exit);
		
		l1.setBounds(230,80,200,30);
		//add.setBounds(140,120,100,30);
		//update.setBounds(100,160,100,30);
		//delete.setBounds(100,200,100,30);
		//search.setBounds(140,240,100,30);
		logout.setBounds(100,240,100,30);
		exit.setBounds(100,280,100,30);
		back.setBounds(100,320,100,30);
		ta.setBounds(230,160,400,400);
		
		//update.addActionListener(this);
		//delete.addActionListener(this);
		//search.addActionListener(this);
		logout.addActionListener(this);
		exit.addActionListener(this);
		back.addActionListener(this);
		//back.addActionListener(this);
		addWindowListener(this);
		loadData();
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(100,100);
		setSize(700,700);getContentPane().setBackground(new Color(106,163,236));
	}
	public void loadData(){
		String sql="select *  from patient;";
		try{
			DataAccess da=new DataAccess();
			ResultSet rs=da.getData(sql);
			String data="";
			while(rs.next()){
				data=data+rs.getString("First_name")+"-";
				data=data+rs.getString("Middle_name")+"-";
				data=data+rs.getString("Last_name")+"-";
				data=data+rs.getString("DateOfBirth")+"-";
				data=data+rs.getString("Sex")+"-";
				data=data+rs.getString("Patient_id")+"-";
				data=data+rs.getString("password")+"-";
				data=data+rs.getString("phone")+"-";
				data=data+rs.getString("age")+"-";
				data=data+rs.getString("blood_group")+"-";
				data=data+rs.getString("doctor_id")+"\n";
			}
			ta.setText(data);
		}
		catch(Exception ex){
			System.out.println("Exception in home");
		}
	}
	/*public void loadData(){
		String sql="select *  from assistant";
		try{
			DataAccess da=new DataAccess();
			ResultSet rs=da.getData(sql);
			String data="";
			while(rs.next()){
				data=data+rs.getString("First_name")+"-";
				data=data+rs.getString("Middle_name")+"-";
				data=data+rs.getString("Last_name")+"-";
				data=data+rs.getString("assist_id")+"-";
				data=data+rs.getString("doctor_id")+"-";
				data=data+rs.getString("pass")+"-";
				data=data+rs.getString("phoneNumber")+"\n";
			}
			ta.setText(data);
		}
		catch(Exception ex){
			System.out.println("Exception in home");
		}
	}*/
	public void setParent(Frame f){
		parent=f;
	}

	public void actionPerformed(ActionEvent e){
		//System.out.println(e.getActionCommand());
		String sig=e.getActionCommand();
		if(sig.equals("Update")){
			this.setVisible(false);
			update up=new update();
			up.setVisible(true);
			

		}
		else if(sig.equals("Delete")){
			Admindelete ad=new Admindelete();
			ad.setVisible(true);
			this.setVisible(false);
			///log1.setVisible(true);
			//log1.setParent(this);
		}
		/*else if(sig.equals("Search")){
			this.setVisible(false);
			search s=new search();
			s.setVisible(true);
			//log.setParent(this);
		}*/

		else if(sig.equals("Logout")){
			Hhome h = new Hhome();
		    h.setVisible(true);
			this.setVisible(false);
			//log.setParent(this);
		}
		else if(sig.equals("Exit")){
			System.exit(0);
		}
		else if(sig.equals("Back")){
			Hhome h = new Hhome();
		    h.setVisible(true);
			this.setVisible(false);
			//log.setParent(this);
		}

	}
	public void windowActivated(WindowEvent e){	}
	public void windowClosed(WindowEvent e){}
	public void windowClosing(WindowEvent e){
		this.setVisible(false);
		parent.setVisible(true);}
		public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}

}