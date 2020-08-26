import java.awt.*;
import java.awt.event.*;
public class square extends Frame implements ActionListener{
	private TextField tf;
	private Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,
	b15;
	private Label l;
	public square(){
		super();
		l=new Label();
		tf=new TextField(10);
		b1=new Button("1");
		b2=new Button("2");
		b3=new Button("3");
		b4=new Button("0");
		b5=new Button("/n+");

		b6=new Button("4");
		b7=new Button("5");
		b8=new Button("6");
		b9=new Button("C");
		b10=new Button("-");

		b11=new Button("7");
		b12=new Button("8");
		b13=new Button("9");
		b14=new Button("M");
		b15=new Button("*");

		add(l);add(tf);add(b1);add(b2);add(b3);add(b4);add(b5);
		add(b6);add(b7);add(b8);add(b9);add(b10);add(b11);add(b12)
		;add(b13);add(b14);add(b15);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);b5.addActionListener(this);
		b6.addActionListener(this);b7.addActionListener(this);
		b8.addActionListener(this);b9.addActionListener(this);
		b10.addActionListener(this);b11.addActionListener(this);
		b12.addActionListener(this);b13.addActionListener(this);
		b14.addActionListener(this);b15.addActionListener(this);
	
		setLayout(new FlowLayout());
		setSize(400,500);
	}
	public void actionPerformed(ActionEvent e){
		String sig=e.getActionCommand();
		System.out.print(sig);
		System.out.print(" ");
		System.out.print(tf.getText());
		System.out.print(" ");
		//System.out.println("Button pressed");
	}
}