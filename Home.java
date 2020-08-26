import java.awt.Color.*;import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class Home extends JFrame implements ActionListener, WindowListener{
	private TextField tf,pf;
	private JButton logoutButton,exitButton,updateButton,deleteButton,searchButton;
	private TextArea ta;
	private Frame parent;
	public Home(){
		super("Home Window");
		
		updateButton=new JButton("Update");
		deleteButton=new JButton("Delete");
		searchButton=new JButton("Search");
		logoutButton=new JButton("Logout");
		exitButton=new JButton("Exit");
		
		ta=new TextArea(30,80);
		ta.setEditable(false);
		add(ta);
		add(logoutButton);add(exitButton);
		add(updateButton);
		logoutButton.addActionListener(this);
		exitButton.addActionListener(this);
		updateButton.addActionListener(this);
		addWindowListener(this);
		setLayout(new FlowLayout());
		setSize(600,400);getContentPane().setBackground(new Color(106,163,236));
	}
	public void loadData(){
		String sql="select * from admin";
		try{
			DataAccess da=new DataAccess();
			ResultSet rs=da.getData(sql);
			String data="";
			while(rs.next()){
				data=data+rs.getString("adminNum")+"-";
				data=data+rs.getString("email")+"-";
				data=data+rs.getString("pass")+"\n";
			}
			ta.setText(data);
		}
		catch(Exception ex){
			System.out.println("Exception in home");
		}
	}
	public void setParent(Frame f){
		parent=f;
	}
	public void actionPerformed(ActionEvent e){	
		if(e.getSource()==logoutButton){
			this.setVisible(false);
			parent.setVisible(true);
		}
		else if(e.getSource()==exitButton){
			System.exit(0);
		}
		else if(e.getSource()==updateButton){
			Hhome h1 = new Hhome();
			h1.setVisible(true);
			//h1.setParent(this);
			this.setVisible(false);
		}
	}
	public void windowActivated(WindowEvent e){	}
	public void windowClosed(WindowEvent e){}
	public void windowClosing(WindowEvent e){
		this.setVisible(false);
		parent.setVisible(true);
	}
	public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}
}