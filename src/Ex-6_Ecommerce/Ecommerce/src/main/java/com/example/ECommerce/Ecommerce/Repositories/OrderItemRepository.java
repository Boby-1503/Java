package com.example.ECommerce.Ecommerce.Repositories;

import com.example.ECommerce.Ecommerce.Entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
