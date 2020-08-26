import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color.*;
public class Assistantlogin extends JFrame implements ActionListener{
	private TextField uname,pass;
	private JButton b,b2;
	private JLabel l,l1,l2;
	private Frame parent;
	public Assistantlogin(){
		super("Assistant Login Window");
		Font f=new Font("Arial",Font.BOLD,26);
		Font f1=new Font("Arial",Font.PLAIN,18);
		l1=new JLabel("Assistant Login Window");
		l1.setFont(f);
		l=new JLabel("User Id ");
		l.setFont(f1);
		l2=new JLabel("Password ");
		l2.setFont(f1);
		uname=new TextField(10);
		pass=new TextField(10);
		pass.setEchoChar('*');
		b=new JButton("Login");
		b2=new JButton("Back");
		
		l1.setBounds(60,20,350,30);
		l.setBounds(30,100,90,20);
		uname.setBounds(140,100,200,20);
		l2.setBounds(30,130,90,20);
		pass.setBounds(140,130,200,20);
		b.setBounds(80,170,100,20);
		b2.setBounds(190,170,100,20);
		
		add(l);add(uname);
		add(l2);add(pass);
		add(b);add(b2);add(l1);
		b.addActionListener(this);
		b2.addActionListener(this);
		setLayout(null);
		setLocation(300,200);
		setSize(400,300);getContentPane().setBackground(new Color(106,163,236));
	}
	public void setParent(Frame f){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		parent=f;
	}


	//public void actionPerformed(ActionEvent e){
	//	System.out.println(e.getActionCommand());}
	private boolean checkAuth(){
		boolean flag=false;
		String n=uname.getText();
		String p=pass.getText();
		String sql="select * from assistant where assist_id='"+n+"' and pass='"+p+"'";
		//System.out.println(sql);
		try{
			DataAccess da=new DataAccess();
			ResultSet rs=da.getData(sql);
			while(rs.next()){
					flag=true;
			}
		}
		catch(Exception ex){
			System.out.println("Exception occurred");
		}
		return flag;
	}
	public void actionPerformed(ActionEvent e){
		//System.out.println(e.getActionCommand());
		String sig=e.getActionCommand();
		if(sig.equals("Login")){
			if(checkAuth()){
				//System.out.println("Success");
				//Assistant.home.setVisible(true);
				//Assistant.home.setParent(this);
				//Assistant.home.loadData();
				page3 p= new page3();
				p.setVisible(true);
				this.setVisible(false);
				
			}
			else{
				System.out.println("Incorrect");
			}
		}
		else if(sig.equals("Back")){
			Assistant ast = new Assistant();
			ast.setVisible(true);
			this.setVisible(false);
		}
	}
}