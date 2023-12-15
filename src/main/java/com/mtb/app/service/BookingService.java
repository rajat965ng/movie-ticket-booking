package com.mtb.app.service;

import com.mtb.app.model.Booking;
import org.bson.types.ObjectId;

import java.util.List;

public interface BookingService {
    public Booking book(Booking booking);

    public List<Booking> bulkBook(List<Booking> bookings);

    public Booking findById(String objectId);

    public List<Booking> findAll();
}
