import java.awt.Color.*;import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;
public class Patientsignup extends JFrame implements ActionListener{
	private TextField fname,mname,lname,dob,sex,pass,phone,age,bgrp,d_id;
	private JButton signupButton,cancelButton;
	private JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9;//,msg;
	
	public Patientsignup(){
		super("Patient Signup Window");
		Font f=new Font("Arial",Font.BOLD,24);
		Font f1=new Font("Arial",Font.BOLD,18);
		l9=new JLabel("Patient SignUp Window");
		l9.setFont(f);
		
		l=new JLabel("First Name: ");
		l.setFont(f1);
		fname=new TextField(10);
		
		l1=new JLabel("Midddle Name: ");
		l1.setFont(f1);
		mname=new TextField(10);
		
		l2=new JLabel("Last Name: ");
		l2.setFont(f1);
		lname=new TextField(10);
		
		l3=new JLabel("Date of Birth: ");
		l3.setFont(f1);
		dob=new TextField(10);
		
		l4=new JLabel("Sex: ");
		l4.setFont(f1);
		sex=new TextField(10);
		
		l5=new JLabel("Password: ");
		l5.setFont(f1);
		pass=new TextField(10);
		
		l6=new JLabel("Phone Number: ");
		l6.setFont(f1);
		phone=new TextField(10);
		
		l7=new JLabel("Age: ");
		l7.setFont(f1);
		age=new TextField(10);
		
		l8=new JLabel("Blood Group: ");
		l8.setFont(f1);
		bgrp=new TextField(10);
		

		signupButton=new JButton("Signup");
		cancelButton=new JButton("Cancel");
		//msg=new Label("msg box");
		
		l9.setBounds(100,20,300,30);
		
		l.setBounds(30,90,145,30);
		fname.setBounds(185,90,230,30);
		
		l1.setBounds(30,135,145,30);
		mname.setBounds(185,135,230,30);
		
		l2.setBounds(30,175,145,30);
		lname.setBounds(185,175,230,30);
		
		l3.setBounds(30,215,145,30);
		dob.setBounds(185,215,230,30);
		
		l4.setBounds(30,255,145,30);
		sex.setBounds(185,255,230,30);
		
		l5.setBounds(30,295,145,30);
		pass.setBounds(185,295,230,30);
		
		l6.setBounds(30,335,145,30);
		phone.setBounds(185,335,230,30);
		
		l7.setBounds(30,375,145,30);
		age.setBounds(185,375,230,30);
		
		l8.setBounds(30,415,145,30);
		bgrp.setBounds(185,415,230,30);
		
		signupButton.setBounds(115,465,100,30);
		cancelButton.setBounds(220,465,100,30);
		
		
		add(l);add(fname);
		add(l1);add(mname);
		add(l2);add(lname);
		add(l3);add(dob);
		add(l4);add(sex);
		add(l5);add(pass);
		add(l6);add(phone);
		add(l7);add(age);
		add(l8);add(bgrp);
		add(l9);
		add(signupButton);add(cancelButton);
		//add(msg);
		
		
		signupButton.addActionListener(this);
		cancelButton.addActionListener(this);
		setLayout(null);
		setLocation(300,100);
		setSize(500,550);getContentPane().setBackground(new Color(106,163,236));
	}

	//public void actionPerformed(ActionEvent e){
	//	System.out.println(e.getActionCommand());
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);}
		
	private boolean isEmpty(TextField s){
		boolean flag=false;
		if(s.getText().length()==0)flag=true;
		//System.out.println(s.getText()+":"+flag);
		return flag;
	}
	/*private boolean isValidEmail(String e){
		boolean flag=true;
		int atIdx=e.indexOf("@");
		int dotIdx=e.indexOf(".");
		if(dotIdx<=atIdx)flag=false;
		return flag;
	}*/
	public void actionPerformed(ActionEvent e){
		//System.out.println(e.getActionCommand());
		String sig=e.getActionCommand();
		
		if(sig.equals("Signup")){
			if(isEmpty(fname)){
				JOptionPane.showMessageDialog(this,"All fields are mandatory");
			}
			/*else if(!isValidEmail(email.getText())){
				JOptionPane.showMessageDialog(this,"Invalid Email");
			}*/
			else{
				DataAccess da=new DataAccess();
				//String sql="insert into patient values('"+name.getText()+"','111','"+email.getText()+"')";
				String sql="INSERT INTO `patient` (`First_name`, `Middle_name`, `Last_name`, `DateOfBirth`, `Sex`, `Patient_id`, `password`, `phone`, `age`, `blood_group`, `doctor_id`) VALUES ('"+fname.getText()+"', '"+mname.getText()+"', '"+lname.getText()+"', '"+dob.getText()+"', '"+sex.getText()+"', NULL, '"+pass.getText()+"', '"+phone.getText()+"', '"+age.getText()+"', '"+bgrp.getText()+"', NULL)";
				if(da.updateDB(sql)>0){
					JOptionPane.showMessageDialog(this,"Signup Complete!");
				}
			Admin ad =new Admin();
			ad.setVisible(true);
			this.setVisible(false);
			}
		}
		else if(sig.equals("Cancel")){
			System.exit(0);
		}
	}
}