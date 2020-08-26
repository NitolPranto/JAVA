import java.util.Scanner;
public class Abc{
	public static void main(String w[]){
		
		System.out.println("Enter Book name: ");
		Scanner sc=new Scanner(System.in);
		String n=sc.nextLine();
		
		Scanner sc2=new Scanner(System.in);
		Scanner sc3=new Scanner(System.in);
		Scanner sc4=new Scanner(System.in);
		Scanner sc5=new Scanner(System.in);
		
		
		String a=sc2.nextLine();
		String i=sc3.nextLine();
		String t=sc4.nextLine();
		int  c=sc5.nextInt();
		
		Book b=new Book();
		b.setName(n);
		b.setAuthor(a);
		b.setId(i);
		b.setType(t);
		b.setCopy(c);
		
		b.showInfo();
		
		System.out.println("Enter Add copy Number: ");
		int c1 = sc.nextInt();
		
		b.addBookCopy(3);
		
		
	}
}
class Book{
	private String bookName;
	private String bookAuthor;
	private String bookId;
	private String bookType;
	private int bookCopy;
	
	public Book(){}
	public Book(String n, String i){
	bookName=n;
	bookId=i;
	
	}
	

	public void setName(String n){bookName=n;}
	public void setAuthor(String a){bookAuthor=a;}	
	public void setId(String i){bookId=i;}
	public void setType(String t){bookType=t;}
	public void setCopy(int c){bookCopy=c;}
	
	public void showInfo(){
		System.out.println("Book Name : "+bookName);
		System.out.println("Book Author : "+bookAuthor);
		System.out.println("Book ID : "+bookId);
		System.out.println("Book Type : "+bookType);
		System.out.println("Book Copy : "+bookCopy);
		
	}
	
	public void addBookCopy(int c1){
		bookCopy=bookCopy+c1;
		System.out.println("Successful Added : " +bookCopy);
	}


}