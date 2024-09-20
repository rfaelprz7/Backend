package com.accenture.ws.entity;
public class DiscountedBill extends OrderBill {

    public DiscountedBill(CafeClerk clerk) {
        super(clerk);
    }

    @Override
    public double getTotalBill() {
        double total = orderList.stream()
                .mapToDouble(order -> order.getIsDiscounted() ? order.getPrice() * (1 - order.getIsDiscountPercentage() / 100) : order.getPrice())
                .sum();
        return Math.round(total * 100.0) / 100.0;
    }
}
