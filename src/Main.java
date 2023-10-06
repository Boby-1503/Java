//public class Main
//{
//    public static void main(String [] args)
//    {
//      Dog D1=new Dog();
//      D1.setName("Charlie");
//      D1.setBreed("Bulldog");
//      System.out.println(D1.getName());
//      System.out.println(D1.getBreed());
//    }
//
//}

public class Main
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