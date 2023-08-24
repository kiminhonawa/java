package edu.java.class08;

public class ClassMain08 {

	public static void main(String[] args) {

		Account account1 = new Account(1234 , 10000);
		account1.printInfo();
		
		System.out.println("입금 후 잔액은:" + account1.deposit(5000));
		System.out.println("출금 후 잔액은:" + account1.withdraw(2000));

		Account account2 = new Account(5678, 10000);
		
		account1.transfer(2000, account2);
		System.out.println("이체 후 잔액은:" + account1.balance);
		account1.printInfo();
		account2.printInfo();
	}

}
