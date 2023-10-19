package Week2;

// Define the Drawable interface
interface Drawable
{
    void draw();   //declare the draw method
}
// Implement the Drawable interface in the circle class
class circle implements Drawable
{
    public void draw()
    {
        System.out.println("Draw a circle.");

    }
}


// Implement the Drawable interface in the rectangle class
class rectangle implements Drawable
{
    public void draw()
    {
        System.out.println("Draw a rectangle.");

    }
}


// Implement the Drawable interface in the triangle class
class triangle implements Drawable
{

    public void draw()
    {
        System.out.println("Draw a triangle.");
    }
}

public class Ques4
{
    public static void main(String[] args)
    {

        circle circle = new circle();
        rectangle rectangle = new rectangle();
        triangle triangle = new triangle();

        circle.draw();
        rectangle.draw();
        triangle.draw();
    }
}

