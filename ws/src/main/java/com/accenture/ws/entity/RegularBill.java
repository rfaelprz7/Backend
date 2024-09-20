package com.accenture.ws.entity;
public class RegularBill extends OrderBill {

    public RegularBill(CafeClerk clerk) {
        super(clerk);
    }

    @Override
    public double getTotalBill() {
        return orderList.stream().mapToDouble(Order::getPrice).sum();
    }
}
