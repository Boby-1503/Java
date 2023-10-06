public class Shape
{
    String name;
    String color;

    public Shape(String name,String color)  //making parametrized constructor
    {
        this.name=name;
        this.color=color;
    }
    public void print()  //method to print the name and color
    {
        System.out.println("Shape: "+name);
        System.out.println("Color: "+color);
    }

    public static void main(String[] args)
    {
        Shape Circle=new Shape("Circle","Red");
        Circle.print();  //calling the function

        Shape Rectangle=new Shape("Rectangle","Blue");
        Rectangle.print();
    }
}

