import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color.*;
public class Assistant extends JFrame implements ActionListener{
	private JButton signupButton,loginButton,back;
	private JLabel l1;
	public static Assistantlogin log2;
	public static Assistantsignup sup2;

	public Assistant(){
		super("Assistant Window");
		Font f=new Font("Arial",Font.BOLD,26);
		log2=new Assistantlogin();
		sup2=new Assistantsignup();
		
		l1=new JLabel("Assistant Window");
		l1.setFont(f);
		loginButton=new JButton("Login");
		signupButton=new JButton("Signup");
		back=new JButton("Back");
		l1.setBounds(80,20,300,30);
		loginButton.setBounds(140,120,100,30);
		signupButton.setBounds(140,160,100,30);
		back.setBounds(140,200,100,30);
		add(l1);
		add(loginButton);
		add(back);
		add(signupButton);
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
			sup2.setVisible(true);
		}
		else if(sig.equals("Login")){
			this.setVisible(false);
			log2.setVisible(true);
			//log2.setParent(this);
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