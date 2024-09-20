package com.accenture.ws.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderName;
    private double price;
    private boolean isDiscounted;
    private double isDiscountPercentage = 5.0;

    public Order() {}

    public Order(String orderName, double price, boolean isDiscounted, double isDiscountPercentage) {
        this.orderName = orderName;
        this.price = price;
        this.isDiscounted = isDiscounted;
this.isDiscountPercentage = isDiscountPercentage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }





    public void setIsDiscounted(boolean isDiscounted) {
        this.isDiscounted = isDiscounted;
    }

   public boolean getIsDiscounted() {
        return isDiscounted;
    }



    public double getIsDiscountPercentage() {
        return isDiscountPercentage;
    }

    public void setIsDiscountPercentage(double isDiscountPercentage) {
        this.isDiscountPercentage = isDiscountPercentage;
    }


}
