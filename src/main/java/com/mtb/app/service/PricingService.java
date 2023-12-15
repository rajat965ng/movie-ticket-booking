package com.mtb.app.service;

import com.mtb.app.model.Booking;

public interface PricingService {
    public Booking calculate(Booking booking);
}
