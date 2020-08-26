
import java.util.Scanner;

public class AC{
	public static void main(String w[] ){
    	Contact cn=new Contact();

		System.out.println("Enter name:  ");
		Scanner sc=new Scanner(System.in);
		String n=sc.nextLine();
		cn.setpersonName(n);

		System.out.println("Enter ID:  ");
		Scanner sc2=new Scanner(System.in);
		String i=sc2.nextLine();
		cn.setpersonId(i);


		System.out.println("Enter age:  ");
		Scanner sc3=new Scanner(System.in);
		int a=sc3.nextInt();
		cn.setage(a);

		System.out.println("Enter  Mobile number:  ");
		Scanner sc4=new Scanner(System.in);
		String m=sc4.nextLine();
		cn.setmobileNumber(m);	

		System.out.println("Enter gender:  ");
		Scanner sc5=new Scanner(System.in);
		String  c=sc5.nextLine();
		cn.setgender(n);

		cn.showInfo();
		cn.detectMobileOperator(m);
		cn.contactValidity(m);
		//cn.checkGender(n);
		cn.checkAge(a);
	
	}
}
class Contact{
	private String personName;
	private String personId;
	private int age;
	private String mobileNumber;
	private String gender;
	
	public Contact(){}
	public Contact(String n, String i){
	personName=n;
	personId=i;}
	

	public void setpersonName(String n){personName=n;}
	public void setpersonId(String i){personId=i;}	
	public void setage(int a){age=a;}
	public void setmobileNumber(String m){mobileNumber=m;}
	public void setgender(String n){gender=n;}
	
	public void showInfo(){
		System.out.println("Person Name : "+personName);
		System.out.println("Person ID : "+personId);
		System.out.println("Age : "+age);
		System.out.println("Mobile Number : "+mobileNumber);
		//System.out.println("Gender : "+gender);
		
	}
	public void detectMobileOperator(String m){
		String st=m;
		char e=st.charAt(2);
		if(e=='7'){
			System.out.println("This is Grameenphone");
		}
		else if(e=='8'){
			System.out.println("This is Robi");
		}
		else if(e=='9'){
			System.out.println("This is Banglalink");
		}
		else if(e=='6'){
			System.out.println("This is Airtel");
		}
		else if(e=='5'){
			System.out.println("This is Teletalk");
		}
		else{
			System.out.println("Unknown carrier");
		}
	}

	public void contactValidity(String m){
		if (m.length()==11| m.length()==14){
			System.out.println("Valid Number");
		}
		else{System.out.println("Invalid Number");
		}

	} 

	//public void checkGender(String n){
	//	char n=gender;
	//	char gender=String.valueOf(gender);
	//	if(gender=='F'){
	//	System.out.println("Valid Gender");	
	//	}
	//	else if(gender=='M'){
	//		System.out.println("Valid Gender");
	//	}
	//	else{System.out.println("Invalid Gender");}

	//}

	public void checkAge(int a){
		if(a>=10){
			System.out.println("Valid Age");
		}
		else{System.out.println("Invalid Age");
	}
	}	

	}