import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color.*;
public class Adminsignup extends JFrame implements ActionListener{
	private TextField email,password;
	private JButton signupButton,cancelButton;
	private JLabel l,l1,l2,l3,l4,l5;//,msg;
	public Adminsignup(){
		super("Admin Signup Window");
		Font f=new Font("Arial",Font.BOLD,24);
		Font f1=new Font("Arial",Font.BOLD,18);
		l5=new JLabel("Admin SignUp Window");
		l5.setFont(f);
		l=new JLabel("Email: ");
		l.setFont(f1);
		email=new TextField(10);
		
		l4=new JLabel("Password: ");
		l4.setFont(f1);
		password=new TextField(10);
		signupButton=new JButton("Signup");
		cancelButton=new JButton("Cancel");
		
		
		add(l5);
		add(password);
		add(l);
		add(l4);
		add(email);
		add(signupButton);add(cancelButton);
		
		l5.setBounds(100,20,300,30);
		
		l.setBounds(30,90,145,30);
		email.setBounds(185,90,230,30);
		
		
		l4.setBounds(30,135,145,30);
		password.setBounds(185,135,230,30);
		
		signupButton.setBounds(115,305,100,30);
		cancelButton.setBounds(220,305,100,30);
		
		
		signupButton.addActionListener(this);
		cancelButton.addActionListener(this);
		setLayout(null);
		setLocation(300,100);
		setSize(500,500);getContentPane().setBackground(new Color(106,163,236));
	}


	
	private boolean isEmpty(TextField s){
		boolean flag=false;
		if(s.getText().length()==0)flag=true;
		return flag;
	}
	private boolean isValidEmail(String e){
		boolean flag=true;
		int atIdx=e.indexOf("@");
		int dotIdx=e.indexOf(".");
		if(dotIdx<=atIdx)flag=false;
		return flag;
	}
	public void actionPerformed(ActionEvent e){
		String sig=e.getActionCommand();
		
		if(sig.equals("Signup")){
			if(isEmpty(password) || isEmpty(email)){
				JOptionPane.showMessageDialog(this,"All fields are mandatory");
			}
			else if(!isValidEmail(email.getText())){
				JOptionPane.showMessageDialog(this,"Invalid Email");
			}
			else{
				DataAccess da=new DataAccess();
				String sql="INSERT INTO `admin` (`adminNum`, `email`, `pass`) VALUES ('0', '"+email.getText()+"', '"+password.getText()+"')";
				if(da.updateDB(sql)>0){
					JOptionPane.showMessageDialog(this,"Signup Complete!");
					
				}
			
			};
			Admin ad =new Admin();
			ad.setVisible(true);
			this.setVisible(false);

		}
		else if(sig.equals("Cancel")){
			System.exit(0);
		}
	}
}