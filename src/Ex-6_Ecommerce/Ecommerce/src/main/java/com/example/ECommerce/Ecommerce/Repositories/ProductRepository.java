package com.example.ECommerce.Ecommerce.Repositories;

import com.example.ECommerce.Ecommerce.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
