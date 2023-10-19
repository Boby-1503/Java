package Week2;

abstract class Shape
{
    abstract double getArea();

    abstract double getParameter();
}

class Circle extends Shape
{
  private double radius;
  public Circle(double radius)
  {
      this.radius=radius;
  }
 public double getArea()
  {
      return Math.PI * radius *radius;
  }

    @Override
    public double getParameter()
    {
        return 2 * Math.PI * radius;
    }

}

class Rectangle extends Shape
{
    private double length,breadth;

    public Rectangle(double length,double breadth)
    {
        this.length=length;
        this.breadth=breadth;
    }

    public double getArea()
    {
        return length * breadth;
    }

    @Override
    public double getParameter()
    {
        return 2 * (length + breadth);
    }
}

class Triangle extends Shape
{
    private double side1,side2,side3;
    public Triangle(double side1,double side2,double side3)
    {
        this.side1=side1;
        this.side2=side2;
        this.side3=side3;
    }

    @Override
    public double getArea()
    {
        double s= (side1+side2+side3)/2;
        return (s * (s-side1) * (s-side2) * (s-side3));
    }

    @Override
    public double getParameter()
    {
        return side1+side2+side3;
    }
}

