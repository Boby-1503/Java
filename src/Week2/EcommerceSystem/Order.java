package Week2.EcommerceSystem;

public class Order {
    private Customer customer;
    private Product product;

    public Order(Customer customer, Product product)
    {
        this.customer = customer;
        this.product = product;
    }

    // Getter methods for customer and product
    public Customer getCustomer()
    {
        return customer;
    }

    public Product getProduct()
    {
        return product;
    }
}