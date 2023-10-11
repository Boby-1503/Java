package Week2;

abstract class Employee
{
    String name;
    double salary;
    public Employee(String name,double salary)
    {
        this.name=name;
        this.salary=salary;
    }

    public abstract double calculateSalary();
}

class Manager extends Employee
{
  public Manager(String name,double salary)
  {
      super(name,salary);  //to call the constructor of the parent class
  }

    @Override
    public double calculateSalary()
    {
        return salary+5000;
    }


}

class Developer extends Employee
{
    public Developer(String name,double salary)
    {
        super(name,salary);
    }

    @Override
    public double calculateSalary()
    {
        return salary+2500;
    }
}