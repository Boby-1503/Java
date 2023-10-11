package Week2;

public class Ques2_Shape
{
    private String name;
    private String color;

   public Ques2_Shape(String name, String color)
   {
       this.name=name;
       this.color=color;
   }
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public static void main(String[] args)
    {
       Ques2_Shape circle=new Ques2_Shape("Circle","Red");
       Ques2_Shape rectangle=new Ques2_Shape("Rectangle","Blue");

        System.out.println(circle.getName());
        System.out.println(circle.getColor());

        System.out.println(rectangle.getName());
        System.out.println(rectangle.getColor());



    }
}

