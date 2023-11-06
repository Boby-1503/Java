package com.example.ECommerce.Ecommerce.Repositories;

import com.example.ECommerce.Ecommerce.Entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
}
