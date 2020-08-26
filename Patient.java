import java.awt.Color.*;import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.awt.Font;
public class Patient extends JFrame implements ActionListener{
	private JLabel l1;
	private JButton signupButton,loginButton,back;
	public static Patientlogin log3;
	public static Patientsignup sup3;
	//public static Home home;
	public Patient(){
		super("Patient Window");
		Font f=new Font("Arial",Font.BOLD,26);
		log3=new Patientlogin();
		sup3=new Patientsignup();
		//home=new Home();
		l1=new JLabel("Patient Window");
		l1.setFont(f);
		loginButton=new JButton("Login");
		signupButton=new JButton("Signup");
		back=new JButton("Back");
		l1.setBounds(95,20,200,30);
		loginButton.setBounds(140,120,100,30);
		signupButton.setBounds(140,160,100,30);
		back.setBounds(140,200,100,30);
		add(l1);
		add(loginButton);add(signupButton);add(back);
		signupButton.addActionListener(this);
		loginButton.addActionListener(this);
		back.addActionListener(this);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(300,100);
		setSize(400,500);getContentPane().setBackground(new Color(106,163,236));
	}
	public void actionPerformed(ActionEvent e){
		//System.out.println(e.getActionCommand());
		String sig=e.getActionCommand();
		if(sig.equals("Signup")){
			this.setVisible(false);
			sup3.setVisible(true);
		}
		else if(sig.equals("Login")){
			this.setVisible(false);
			log3.setVisible(true);
			//log3.setParent(this);
		}
		else if(sig.equals("Back")){
			Hhome h = new Hhome();
		    h.setVisible(true);
			this.setVisible(false);
			//log.setParent(this);
		}
		else if(sig.equals("Cancel")){
			System.exit(0);
		}
	}
}