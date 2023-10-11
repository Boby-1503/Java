package Week2.EcommerceSystem;

public class Product
{
    private String ProductName;
    private double ProductPrice;

    public Product(String ProductName,double ProductPrice)
    {
        this.ProductName=ProductName;
        this.ProductPrice=ProductPrice;
    }

    public String getProductName()
    {
        return ProductName;
    }

    public double getProductPrice()
    {
        return ProductPrice;
    }

}
