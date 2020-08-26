import java.util.Scanner;

public class Acnt{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		Account a =new Account();
		OverdraftAccount o= new OverdraftAccount();

		
		
	
		
		
		
		System.out.println("Enter name");
		String n =sc.nextLine();
		a.setName(n);
		System.out.println("Enter id");
		String i =sc.nextLine();
		a.setId(i);
		System.out.println("Enter balance");
		int b = sc.nextInt();
		a.setBalance(b);
		System.out.println("Enter diposit");
		int d = sc.nextInt();
		a.setDeposit(d);
		System.out.println("Enter Withdraw");
		int w = sc.nextInt();
		
		a.setWithdraw(w);
		a.showInfo();
		
		o.showInfo();
		o.setBalance(30000);
		o.setOverdraft(25000);
		
		
	}
}

class Account {
	
	private String accName;
	private String accID;
	private int balance;
	
	
	public Account(){
		
	}
	//public Account("name","11-00",00){
		
	//}
	public Account(String n, String i, int b)
	{ accName=n;
	accID=i;
	balance=b;
	}
	
	
	
	
	public void setName(String n){
		accName=n;
	}
	public void setId(String i){
		accID=i;
	}
	public void setBalance(int b){
		balance=b;
	}
	public void setDeposit(int x){
		if(x>0){
			balance = balance + x;
			System.out.println("Successful");
		}
		else{
			System.out.println("Only positive ammount should be deposited ");
		}
	}
	public void setWithdraw(int x){
		if(x<=balance){
			balance = balance - x;
			System.out.println("Successful");
		}
		else{
			System.out.println("Low Balance");
		}
		
	}
	
	public boolean withdraw(int x){
		if(x>balance){
			return false;
		}
		else{
			if(x>=0){
				balance=balance-x;
				return true;
			}
			return false;
		}
	}
	
	public void showInfo(){
		System.out.println("Name is "+accName);
		System.out.println("Id is "+accID);
		System.out.println("Balance  is "+balance);
	}

}


class OverdraftAccount extends Account{
	private int overdraftLimit;
	public OverdraftAccount(){
		this(10000);
	}
	public OverdraftAccount(int o){
		setOverdraft(o);
	}
	public boolean withdraw(int w){
		if(getBalance()>=w & overdraftLimit>=w & w>0){
			setBalance(getBalance()-w);
			return true;
		}
		else{
			return false;
		}	
	}
	public void setOverdraft(int overdraftLimit){
		this.overdraftLimit=overdraftLimit;
	}
	
	
}