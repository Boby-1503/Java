package com.example.ECommerce.Ecommerce.Controllers;

import com.example.ECommerce.Ecommerce.Entities.OrderItem;
import com.example.ECommerce.Ecommerce.Entities.Orders;
import com.example.ECommerce.Ecommerce.Exceptions.OrderValidationException;
import com.example.ECommerce.Ecommerce.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Orders> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Orders getOrderById(@PathVariable int id) {
        return orderService.getOrderById(id);
    }

    @PostMapping
    public void createOrder(@RequestBody Orders order) throws OrderValidationException {
        orderService.createOrder(order);
    }

    @PutMapping("/{id}")
    public void updateOrder(@PathVariable int id, @RequestBody Orders order) {
        orderService.updateOrder(id, order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
    }

    @PostMapping("/{orderId}/items")
    public void addOrderItem(@PathVariable int orderId, @RequestBody OrderItem orderItem) {
        orderService.addOrderItem(orderId, orderItem);
    }
}
