import java.awt.Color.*;import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.awt.Font;

public class view extends JFrame  {
	private JLabel l;
	private JTextArea ta1;
	private Frame parent;

	view(){
				Font f=new Font("Arial",Font.BOLD,26);
				l=new JLabel("Display Search Result");
				l.setFont(f);
				ta1=new JTextArea(100,100);
				ta1.setEditable(false);

				 l.setBounds(60,20,300,30);
				 ta1.setBounds(60,70,400,300);
				 add(l);
				 add(ta1);

				 setLayout(null);
				 setVisible(true);
				 setLocation(100,100);
				 setSize(700,700);
				 getContentPane().setBackground(new Color(106,163,236));
				 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				 loadData();
				 }

		public void loadData(){
		String sql="select *  from admin ";//where adminNum='"+ta1.getText()+"'";
		try{
			DataAccess da=new DataAccess();
			ResultSet rs=da.getData(sql);
			String data="";
			while(rs.next()){
				data=data+rs.getString("adminNum")+"-";
				data=data+rs.getString("email")+"-";
				data=data+rs.getString("pass")+"\n";
			}
			ta1.setText(data);
		}
		catch(Exception ex){
			System.out.println("Exception in home");
		}
	}		 
		public void setParent(Frame f){
		parent=f;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}		 

}