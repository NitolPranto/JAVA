import java.awt.Color.*;import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class update extends JFrame implements ActionListener{
	private JTextField name,locationID;
	private JButton confirmButton,cancelButton,showButton;
	private JLabel l,l2,msg;
	private Frame parent;
	public update(){
		super("Edit Window");
		l=new JLabel("First Name: ");
		name=new JTextField(10);
		l2=new JLabel("ID: ");
		locationID=new JTextField(10);
		showButton=new JButton("Show");
		confirmButton=new JButton("Confirm");
		cancelButton=new JButton("Back");
		msg=new JLabel("msg box");
		add(l);add(name);
		add(l2);add(locationID);
		add(showButton);add(confirmButton);add(cancelButton);
		add(msg);
		
		l2.setBounds(10,60,100,30);
		locationID.setBounds(115,60,200,30);
		l.setBounds(10,95,100,30);
		name.setBounds(115,95,200,30);
		
		showButton.setBounds(10,130,100,30);
		confirmButton.setBounds(115,130,100,30);
		cancelButton.setBounds(220,130,100,30);
		msg.setBounds(115,170,200,30);
		
		showButton.addActionListener(this);
		confirmButton.addActionListener(this);
		cancelButton.addActionListener(this);
		setLayout(null);
		setLocation(100,100);
		setSize(400,500);
		getContentPane().setBackground(new Color(106,163,236));
	}
	private boolean isEmpty(JTextField s){
		boolean flag=false;
		if(s.getText().length()==0)flag=true;
		//System.out.println(s.getText()+":"+flag);
		return flag;
	}
	public void loadData(){
		String sql="select First_name from doctor where doctor_id='"+locationID.getText()+"'";
		System.out.println(sql);
		try{
			DataAccess da=new DataAccess();
			ResultSet rs=da.getData(sql);
			String data="";
			while(rs.next()){
				//data=data+rs.getString("loc_id")+"-";
				data=data+rs.getString("First_name")+"\n";
			}
			name.setText(data);
		}
		catch(Exception ex){
			System.out.println("Exception in home");
		}
	}
	public void setParent(JFrame p){
		parent=p;
	}
	public void actionPerformed(ActionEvent e){
		//System.out.println(e.getActionCommand());
		String sig=e.getActionCommand();
		if(sig.equals("Confirm")){
			String m="";
			String sql="update doctor set First_name='"+name.getText()+"' where doctor_id='"+locationID.getText()+"'";
			System.out.println(sql);
			DataAccess da=new DataAccess();
			if(isEmpty(name)){
				m="All fields are mandatory";
			}
			else{
				if(da.updateDB(sql)>0){
					m="Data Updated";
				}
				else{
					m="Update Error!";
				}
			}
			JOptionPane.showMessageDialog(this,m);
		}
		else if(sig.equals("Back")){
			//parent.setVisible(true);
			Hhome h=new Hhome();
			h.setVisible(true);
			this.setVisible(false);
		}
		else if(sig.equals("Show")){
			//parent.setVisible(true);
			//this.setVisible(false);
			loadData();
		}
	}
}