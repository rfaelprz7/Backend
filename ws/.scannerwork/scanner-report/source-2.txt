package com.accenture.ws.controller;

import com.accenture.ws.entity.OrderBill;
import com.accenture.ws.service.OrderService;
import com.accenture.ws.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin ("*")// Allow cross-origin requests
@RestController
@RequestMapping("/orders")
public class OrderAndBillingController {

    private final OrderService orderService;

    @Autowired
    public OrderAndBillingController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getOrderList() {
        return orderService.getAllOrders();
    }

    @PostMapping("/add")
    public void addOrder(@RequestBody Order order) {
        orderService.saveOrder(order);
    }

    @PutMapping("/update/{id}")
    public void updateOrder(@PathVariable Long id, @RequestBody Order order) {
        orderService.updateOrder(id, order);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

    @GetMapping("/totalRegularBill")
    public OrderBill getTotalRegularBill() {
        return orderService.getTotalRegularBill();
    }

    @GetMapping("/totalDiscountedBill")
    public OrderBill getTotalDiscountedBill() {
        return orderService.getTotalDiscountedBill();
    }
}
