import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color.*;
public class assistandelete extends JFrame implements ActionListener{
	private JTextField Id;
	private JButton confirmButton,cancelButton;
	private JLabel l,msg;
	private JFrame parent;
	
	public assistandelete(){
		super("Delete Window");
		l=new JLabel("ID: ");
		Id=new JTextField(10);
		confirmButton=new JButton("Confirm");
		cancelButton=new JButton("Back");
		msg=new JLabel("msg box");
		add(l);add(Id);
		add(confirmButton);add(cancelButton);
		add(msg);
		
		l.setBounds(10,60,50,30);
		Id.setBounds(115,60,200,30);
		confirmButton.setBounds(120,130,100,30);
		cancelButton.setBounds(220,130,100,30);
		msg.setBounds(115,170,200,30);
		
		confirmButton.addActionListener(this);
		cancelButton.addActionListener(this);
		setLayout(null);
		setLocation(200,50);
		setSize(400,500);getContentPane().setBackground(new Color(106,163,236));
	}
	private boolean isEmpty(JTextField s){
		boolean flag=false;
		if(s.getText().length()==0)flag=true;
		//System.out.println(s.getText()+":"+flag);
		return flag;
	}
	public void setParent(JFrame p){
		parent=p;
	}
	public void actionPerformed(ActionEvent e){
		//System.out.println(e.getActionCommand());
		String sig=e.getActionCommand();
		String m="";
		if(sig.equals("Confirm")){
			String sql="delete from admin where assist_id='"+Id.getText()+"'";
			m=sql;
			DataAccess da=new DataAccess();
			if(isEmpty(Id)){
				m="All fields are mandatory";
			}
			else{
				if(da.updateDB(sql)>0){
					m="Data Deleted";
				}
				else{
					m="Delete Error!";
				}
			}
		}
		else if(sig.equals("Back")){
			//parent.setVisible(true);
			//Navigate.home.loadData();
			Hhome h=new Hhome();
			h.setVisible(true);
			this.setVisible(false);
		}
		if(m.length()>0){
			msg.setText(m);
			JOptionPane.showMessageDialog(this,m);
		}
	}
}