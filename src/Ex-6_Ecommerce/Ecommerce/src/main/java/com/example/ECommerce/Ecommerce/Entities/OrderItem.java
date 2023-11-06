package com.example.ECommerce.Ecommerce.Entities;
import com.example.ECommerce.Ecommerce.Entities.Product;
import com.example.ECommerce.Ecommerce.Entities.Orders;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonBackReference
    private Orders orders;

    @Column(name = "price_per_product")
    private double pricePerProduct;
    private int quantity;
    @Column(name = "total_price")
    private double totalPrice;



    public OrderItem(Product product, Orders orders, double pricePerProduct, int quantity, double totalPrice) {
        this.product = product;
        this.orders = orders;
        this.pricePerProduct = pricePerProduct;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public OrderItem(){}

    public Integer getId() {
        return id;
    }

    public double getPricePerProduct() {
        return pricePerProduct;
    }

    public void setPricePerProduct(double pricePerProduct) {
        this.pricePerProduct = pricePerProduct;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}
