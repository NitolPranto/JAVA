import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color.*;
public class Assistantsignup extends JFrame implements ActionListener{
	private TextField fname,mname,lname,doctor_id,pass,p_number;
	private JButton signupButton,cancelButton;
	private JLabel l,l1,l2,l3,l4,l5,l6;//,msg;
	public Assistantsignup(){
		super("Assistant Signup Window");
		Font f=new Font("Arial",Font.BOLD,24);
		Font f1=new Font("Arial",Font.BOLD,18);
		l5=new JLabel("Assistant SignUp Window");
		l5.setFont(f);
		l=new JLabel("First Name: ");
		l.setFont(f1);
		fname=new TextField(10);
		l1=new JLabel("Middlle Name: ");
		l1.setFont(f1);
		mname=new TextField(10);
		l2=new JLabel("Last Name: ");
		l2.setFont(f1);
		lname=new TextField(10);
		l3=new JLabel("Phone Number: ");
		l3.setFont(f1);
		p_number=new TextField(10);
		l4=new JLabel("Doctor ID:");
		l4.setFont(f1);
		doctor_id=new TextField(10);
		l6=new JLabel("Password: ");
		l6.setFont(f1);
		pass=new TextField(10);
		
		signupButton=new JButton("Signup");
		cancelButton=new JButton("Cancel");
		//msg=new Label("msg box");
		add(l);add(fname);
		add(l1);add(mname);
		add(l2);add(lname);
		add(l3);add(p_number);
		add(l5);//add(email);
		add(l4);add(doctor_id);
		add(l6);add(pass);
		add(signupButton);add(cancelButton);
		//add(msg);
		
		l5.setBounds(100,20,300,30);
		
		l.setBounds(30,90,145,30);
		fname.setBounds(185,90,230,30);
		
		l1.setBounds(30,135,145,30);
		mname.setBounds(185,135,230,30);
		
		l2.setBounds(30,175,145,30);
		lname.setBounds(185,175,230,30);
		
		l3.setBounds(30,215,145,30);
		p_number.setBounds(185,215,230,30);
		
		l4.setBounds(30,255,145,30);
		doctor_id.setBounds(185,255,230,30);
		
		l6.setBounds(30,295,145,30);
		pass.setBounds(185,295,230,30);

		signupButton.setBounds(115,345,100,30);
		cancelButton.setBounds(220,345,100,30);
		//msg.setBounds(215,300,200,30);
		
		signupButton.addActionListener(this);
		cancelButton.addActionListener(this);
		setLayout(null);
		setLocation(300,100);
		setSize(500,500);getContentPane().setBackground(new Color(106,163,236));
	}

	//public void actionPerformed(ActionEvent e){
	//	System.out.println(e.getActionCommand());
//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);}}
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
				//String sql="INSERT INTO `assistant` (`First_name`, `Middle_name`, `Last_name`, `assistan_id`, `pass`, `phoneNumber`) VALUES ('"+fname.getText()+"', '"+mname.getText()+"', '"+lname.getText()+"', NULL, '"+pass.getText()+"', '"+p_number.getText()+"');";
				String sql="INSERT INTO `assistant` (`First_name`, `Middle_name`, `Last_name`, `assist_id`, `doctor_id`, `pass`, `phoneNumber`) VALUES ('"+fname.getText()+"', '"+mname.getText()+"', '"+lname.getText()+"', NULL, '"+doctor_id.getText()+"', '"+pass.getText()+"', '"+p_number.getText()+"')";
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
	}}
