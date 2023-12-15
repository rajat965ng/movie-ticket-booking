package com.mtb.app.service;

import com.mtb.app.model.Booking;
import com.mtb.app.repository.BookingRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class BookingServiceImpl implements BookingService{

    private final BookingRepository bookingRepository;
    private final PricingService pricingService;

    public BookingServiceImpl(BookingRepository bookingRepository, PricingService pricingService) {
        this.bookingRepository = bookingRepository;
        this.pricingService = pricingService;
    }

    @Override
    public Booking book(Booking booking) {
        booking = pricingService.calculate(booking);
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> bulkBook(List<Booking> bookings) {
        bookings = bookings.stream().map(pricingService::calculate).map(bookingRepository::save).collect(Collectors.toList());
        return bookings;
    }

    @Override
    public Booking findById(String objectId) {
        return bookingRepository.findById(objectId);
    }

    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll().list();
    }
}
