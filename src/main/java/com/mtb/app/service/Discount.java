package com.mtb.app.service;

import com.mtb.app.model.Booking;

public interface Discount {
    public Booking apply(Booking booking);
}
