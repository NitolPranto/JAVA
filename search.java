import java.awt.Color.*;import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.awt.Font;

class search extends JFrame{
	//Jlabel l1;
	JButton b1,b3;
	JTextField t1;
	JTextArea ta1;
	
	search(){
		Font f=new Font("Arial",Font.BOLD,26);
		Font f2=new Font("Arial",Font.BOLD,20);
		//l1=new JLabel("Search Id");
		//l1.setFont(f);
		b1=new JButton("Search");
		t1=new JTextField("Search");
		ta1=new JTextArea(100,100);
		ta1.setEditable(false);
		b3=new JButton("Back");
		
		t1.setBounds(150,30,300,30);
		b1.setBounds(230,70,150,20);
		ta1.setBounds(80,110,420,300);
		b3.setBounds(410,430,90,20);
		
		add(t1);
		add(b1);
		add(ta1);
		add(b3);
		
		setLayout(null);
		setVisible(true);
		setSize(600,600);getContentPane().setBackground(new Color(106,163,236));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	
}