package Thread;

public class Account {
	private String accountNo;
	private double balance;
	private boolean flag = false;

	public Account() {
	}

	public Account(String accountNo, double balance) {
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountNo() {
		return this.accountNo;
	}

	/*
	 * public void setBalance(double balance){ this.balance = balance; }
	 */
	public double getBalance() {
		return this.balance;
	}

	public int hashCode() {
		return accountNo.hashCode();
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj != null && obj.getClass() == Account.class) {
			Account target = (Account) obj;
			return target.getAccountNo().equals(accountNo);
		}
		return false;
	}

	public synchronized void draw(double drawAmount) {
		try{
			if(!flag){
				wait();
			}
			else{
				System.out.println(Thread.currentThread().getName() + " get money: " + drawAmount);
				balance -= drawAmount;
				System.out.println("the rest money is: " + balance);
				flag = false;
				notifyAll();
			}
		}
		catch(InterruptedException ex){
			ex.printStackTrace();
		}
	}
	public synchronized void deposit(double depositAmount){
		try{
			if(flag){
				wait();
			}
			else{
				System.out.println(Thread.currentThread().getName() + " save money: " + depositAmount);
				balance += depositAmount;
				System.out.println("rest money is: " + balance);;
				flag = true;
				notifyAll();
			}
		}
		catch (InterruptedException ex){
			ex.printStackTrace();
		}
	}
}












