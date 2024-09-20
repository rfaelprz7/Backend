package com.accenture.ws.service;

import com.accenture.ws.entity.CafeClerk;
import com.accenture.ws.entity.DiscountedBill;
import com.accenture.ws.entity.OrderBill;
import com.accenture.ws.entity.RegularBill;
import com.accenture.ws.repository.OrderRepository;
import com.accenture.ws.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepo;
    private final CafeClerk clerk;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepo, CafeClerk clerk) {
        this.orderRepo = orderRepo;
        this.clerk = clerk;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    public void saveOrder(Order order) {
        if (!order.getIsDiscounted()){
            order.setIsDiscountPercentage(0.0);
        }
        orderRepo.save(order);
    }

    @Override
    public void updateOrder(Long id, Order order) {
        if (orderRepo.existsById(id)){
            order.setId(id);
        }
        orderRepo.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepo.deleteById(id);
    }

    @Override
    public OrderBill getTotalRegularBill() {
        RegularBill bill = new RegularBill(clerk);
        bill.setOrderList(orderRepo.findAll());
        return bill;
    }

    @Override
    public OrderBill getTotalDiscountedBill() {
        DiscountedBill bill = new DiscountedBill(clerk);
        bill.setOrderList(orderRepo.findAll());
        return bill;
    }
}
