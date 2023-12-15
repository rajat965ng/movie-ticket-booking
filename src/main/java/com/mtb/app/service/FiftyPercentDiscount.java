package com.mtb.app.service;

import com.mtb.app.model.Booking;

import java.util.Map;

public class FiftyPercentDiscount implements Discount {
    @Override
    public Booking apply(Booking booking) {
            int counter = 1;
            for (Map.Entry<String, Float> entry : booking.getSeats().entrySet()) {
                float price = entry.getValue();
                if (counter % 3 == 0) {
                    price = price * 0.5f;
                    booking.getSeats().put(entry.getKey(), price);
                }
                counter++;
            }
            booking.setDiscount("DISCOUNT_50_ON_3RD_SEAT");
            return booking;

    }
}
