package Week2;

public class Main
{
    public static void main(String [] args)
    {
//        Circle C1=new Circle(5.0);
//        System.out.println("Area of Circle: "+C1.getArea());
//        System.out.println("Perimeter of Circle: "+C1.getParameter());
//
//        Rectangle R1=new Rectangle(4,6);
//        System.out.println("Area of Rectangle: "+R1.getArea());
//        System.out.println("Perimeter of Rectangle: "+R1.getParameter());
//
//        Triangle T1=new Triangle(12,6,2);
//        System.out.println("Area of Triangle: "+T1.getArea());
//        System.out.println("Perimeter of Triangle: "+T1.getParameter());

        Manager M=new Manager("Alice",80000.0);
        Developer D=new Developer("Bob",60000.0);
        System.out.println("Manger: "+M.name);
        System.out.println("Manager's Salary: "+"$"+M.calculateSalary());
        System.out.println("Developer: "+D.name);
        System.out.println("Developer's Salary: "+"$"+D.calculateSalary());
    }
}
