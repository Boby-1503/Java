package Week2;

import Week2.BankAccount;

public class BankMain
{
    public static void main(String[] args)
    {
        BankAccount account1=new BankAccount();
        BankAccount account2=new BankAccount();

        account2.setBalance(1000.0);
        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());
    }
}

