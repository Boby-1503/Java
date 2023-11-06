package com.example.ECommerce.Ecommerce.Repositories;

import com.example.ECommerce.Ecommerce.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    boolean existsByUsername(String username);

}
