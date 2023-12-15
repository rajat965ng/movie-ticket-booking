package com.mtb.app.repository;

import com.mtb.app.model.Booking;
import com.mtb.app.model.MovieShow;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class BookingRepository implements PanacheMongoRepository<Booking> {

    public Booking save(Booking booking) {
        booking.persistOrUpdate();
        return booking;
    }

    public List<Booking> saveAll(List<Booking> bookings) {
        return bookings.stream().peek(booking -> booking.persistOrUpdate()).collect(Collectors.toList()); }

    public List<Booking> listAll() {
        return findAll(Sort.by("city")).list();
    }

    public Booking findById(String id) {
        return findById(new ObjectId(id));
    }
}
