import java.util.*;
public class Person
{
    String name;
    int age;
    public Person(String name, int age)
    {
        this.name=name;
        this.age=age;
    }
//getter setter--alt+insert
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the name of the first and second person: ");
        String name1=sc.nextLine();
        String name2=sc.nextLine();

        System.out.println("Enter the age of first person and second person: ");
        int age1=sc.nextInt();
        int age2=sc.nextInt();

        Person p1=new Person(name1,age1);
        Person p2=new Person(name2,age2);

        System.out.println("First person's name: "+p1.name+" and age: "+p1.age);
        System.out.println("Second person's name: "+p2.name+" and age: "+p2.age);


    }
}
