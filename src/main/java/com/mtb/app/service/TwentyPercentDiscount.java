package com.mtb.app.service;

import com.mtb.app.model.Booking;

import java.util.Map;

public class TwentyPercentDiscount implements Discount {
    @Override
    public Booking apply(Booking booking) {
        for (Map.Entry<String, Float> entry : booking.getSeats().entrySet()) {
            float price = entry.getValue();
            price = price * 0.8f;
            booking.getSeats().put(entry.getKey(), price);
        }
        booking.setDiscount("DISCOUNT_20_AFTERNOON");
        return booking;
    }
}
