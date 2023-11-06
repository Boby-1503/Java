package com.example.ECommerce.Ecommerce.Services;


import com.example.ECommerce.Ecommerce.Entities.OrderItem;
import com.example.ECommerce.Ecommerce.Entities.Orders;
import com.example.ECommerce.Ecommerce.Entities.Product;
import com.example.ECommerce.Ecommerce.Exceptions.OrderValidationException;
import com.example.ECommerce.Ecommerce.Exceptions.OrderNotFoundException;
import com.example.ECommerce.Ecommerce.Services.ProductService;
import com.example.ECommerce.Ecommerce.Repositories.OrderRepository;
import com.example.ECommerce.Ecommerce.Repositories.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductService productService;

    @Autowired
    private OrderItemRepository orderItemRepository;


    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    public Orders createOrder(Orders order) throws OrderValidationException {
        // Custom order validation logic
        if (order.getItems() == null || order.getItems().isEmpty()) {
            throw new OrderValidationException("Order must contain at least one item.");
        }

        for (OrderItem item : order.getItems()) {
            if (item.getQuantity() <= 0) {
                throw new OrderValidationException("Order item quantity must be greater than 0.");
            }

            // Assuming you have a ProductService to retrieve the product details by ID
            Product product = productService.getProductById(item.getProduct().getId());
            if (product == null) {
                throw new OrderValidationException("Product with ID " + item.getProduct().getId() + " not found.");
            }

            item.setProduct(product);
            item.setPricePerProduct(product.getPrice());  // Set the price per product based on the retrieved product
            item.setTotalPrice(item.getPricePerProduct() * item.getQuantity());
        }

        return orderRepository.save(order);
    }


    public Orders getOrderById(int id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("No Order found with id: " + id));
    }

    public Orders updateOrder(int id, Orders order) {
        Orders existingOrder = getOrderById(id);
        existingOrder.setCustomerName(order.getCustomerName());
        existingOrder.setItems(order.getItems());


        return orderRepository.save(existingOrder);
    }

    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }

    public void addOrderItem(int orderId, OrderItem orderItem) {
        Orders order = getOrderById(orderId);

        // Fetch the product from the database based on the product ID
        Product product = productService.getProductById(orderItem.getProduct().getId());

        // Calculate the price per product and the total price
        double pricePerProduct = product.getPrice();
        double totalPrice = pricePerProduct * orderItem.getQuantity();

        // Set the calculated values in the order item
        orderItem.setOrders(order);
        orderItem.setProduct(product);
        orderItem.setPricePerProduct(pricePerProduct);
        orderItem.setTotalPrice(totalPrice);

        OrderItem savedOrderItem = orderItemRepository.save(orderItem);

        order.getItems().add(orderItem);
        orderRepository.save(order);

        // Print the added OrderItem with the associated Order ID
        System.out.println("Added OrderItem with Order ID " + orderId);
        System.out.println("OrderItem ID: " + orderItem.getId());
        System.out.println("Product: " + orderItem.getProduct().getName());
        System.out.println("Quantity: " + orderItem.getQuantity());
        System.out.println("Price: " + orderItem.getPricePerProduct());
        System.out.println();
    }

}