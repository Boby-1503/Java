package com.example.ECommerce.Ecommerce.Services;

import com.example.ECommerce.Ecommerce.Repositories.ProductRepository;
import com.example.ECommerce.Ecommerce.Entities.Product;
import com.example.ECommerce.Ecommerce.Exceptions.ProductNotFoundException;
import com.example.ECommerce.Ecommerce.Exceptions.ProductValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product addProduct(Product product){
        if(product.getPrice()>=0){
            return productRepository.save(product);
        }
        throw new ProductValidationException("Price must be greater than or equal to 0");
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElseThrow(()->new ProductNotFoundException("No Product found with id:" +id));
    }
    public Product updateProduct(int id, Product product){
        Product existingProduct = getProductById(id);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());

        return productRepository.save(existingProduct);

    }
    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }
}
