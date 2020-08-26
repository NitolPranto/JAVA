import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color.*;
public class Doctor extends JFrame implements ActionListener{
	private JButton signupButton,loginButton,back;
	private JLabel l1;
	public static Doctorlogin log1;
	public static Doctorsignup sup1;
	//public static Home home;
	public Doctor(){
		super("Doctor Window");
		Font f=new Font("Arial",Font.BOLD,26);
		log1=new Doctorlogin();
		sup1=new Doctorsignup();
		
		l1=new JLabel("Doctor Window");
		l1.setFont(f);
		loginButton=new JButton("Login");
		signupButton=new JButton("Signup");
		back=new JButton("Back");
		add(loginButton);
		add(back);
		add(signupButton);
		add(l1);
		l1.setBounds(95,20,200,30);
		loginButton.setBounds(140,120,100,30);
		signupButton.setBounds(140,160,100,30);
		back.setBounds(140,200,100,30);
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
			sup1.setVisible(true);
		}
		else if(sig.equals("Login")){
			this.setVisible(false);
			log1.setVisible(true);
			//log1.setParent(this);
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