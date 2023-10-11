package Week2.EcommerceSystem;

public class Main
{
    public static void main(String[] args)
    {
        Product P1=new Product("Product A",100.0);
        System.out.println("Product name: "+P1.getProductName());
        System.out.println("Product price: "+"$"+P1.getProductPrice());

        Customer C=new Customer("John Doe");
        System.out.println("Customer name: "+C.getCustomerName());

        ShoppingCart shoppingCart = new ShoppingCart(C);

        // Add Product A to John's shopping cart
        shoppingCart.addItem(P1);

        // Create an order for John Doe's shopping cart
        Order order = new Order(C,P1);

        System.out.println("\nShopping Cart Contents for Customer: " + shoppingCart.getCustomer().getCustomerName());
        for (Product item : shoppingCart.getItems())
        {
            System.out.println("Product: " + item.getProductName());
            System.out.println("Price: $" + item.getProductPrice());
        }
        System.out.println("Order Placed!");
    }
}

