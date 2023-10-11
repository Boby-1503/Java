package Week2.EcommerceSystem;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart
{
    private Customer customer;
    private List<Product> items;

    public ShoppingCart(Customer customer)
    {
        this.customer = customer;
        this.items = new ArrayList<>();
    }

    // Add a product to the shopping cart
    public void addItem(Product product)
    {
        items.add(product);
    }

    // Getter methods for customer and items
    public Customer getCustomer()
    {
        return customer;
    }

    public List<Product> getItems()
    {
        return items;
    }
}