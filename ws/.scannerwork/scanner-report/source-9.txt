package com.accenture.ws.service;

import com.accenture.ws.entity.Order;
import com.accenture.ws.entity.OrderBill;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    void saveOrder(Order order);
    void updateOrder(Long id, Order order);
    void deleteOrder(Long id);
    OrderBill getTotalRegularBill();
    OrderBill getTotalDiscountedBill();
}
