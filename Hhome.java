import java.awt.Color.*;import java.awt.*;
import java.awt.event.*;
import java.awt.Color.*;        //for color change
import javax.swing.*;
import java.awt.Font;
public class Hhome extends JFrame implements ActionListener{
	
	
	private JLabel l1;
	private JButton b;
	private JButton b1,b2,b3,b4;
	public static Admin admin;
	public static Doctor doctor;
	public static Assistant assistant;
	public static Patient patient;
	//public static Cancel cancel;
	//private
	
	public Hhome(){
		
		super("Welcome To Prescription Protal Service");
		
		Font f=new Font("Arial",Font.BOLD,20);
		
		l1=new JLabel("Welcome To Prescription Protal Service");
		l1.setFont(f);
		admin=new Admin();
		doctor=new Doctor();
		assistant=new Assistant();
		patient=new Patient();
		b=new JButton("Admin");
		//b.setBackground(Color.BLACK);    // for color change 
		b1=new JButton("Doctor");
		b2=new JButton("Assistant");
		b3=new JButton("Patient");
		b4=new JButton("Cancel");
		add(l1);
		add(b);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		l1.setBounds(100,10,500,30);
		b.setBounds(200,90,150,30);
		b.addActionListener(this);
		b1.setBounds(200,125,150,30);
		b1.addActionListener(this);
		b2.setBounds(200,160,150,30);
		b2.addActionListener(this);
		b3.setBounds(200,195,150,30);
		b3.addActionListener(this);
		b4.setBounds(200,230,150,30);
		b4.addActionListener(this);
		setLayout(null);getContentPane().setBackground(new Color(106,163,236));
		//setDefaultCloseOperation(JFrame.Exit_ON_CLOSE);
		//getContentPane().setBackground(Color.BLUE);      //background color
		setLocation(300,100);
		setSize(600,500);

	}
	public void actionPerformed(ActionEvent e){
		//setDefaultCloseOperation(JFrame.Exit_ON_CLOSE);
		String sig=e.getActionCommand();
		if(sig.equals("Admin")){
			this.setVisible(false);
			admin.setVisible(true);
			//log.setParent(this);
		}
		else if(sig.equals("Doctor")){
			this.setVisible(false);
			doctor.setVisible(true);
			//log1.setParent(this);
		}
		else if(sig.equals("Assistant")){
			this.setVisible(false);
			assistant.setVisible(true);
			//log2.setParent(this);
		}
		else if(sig.equals("Patient")){
			this.setVisible(false);
			patient.setVisible(true);
			//log3.setParent(this);
		}
		else if(sig.equals("Cancel")){
			System.exit(0);
		}
		
		//System.out.println(sig);
		//System.out.println(tf.getText());
		//System.out.println("Button pressed");
	}
	
}