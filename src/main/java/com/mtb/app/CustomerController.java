package com.mtb.app;

import com.mtb.app.model.Booking;
import com.mtb.app.model.MovieShow;
import com.mtb.app.service.BookingService;
import com.mtb.app.service.MovieShowService;
import com.mtb.app.utils.City;
import jakarta.ws.rs.*;

import java.util.List;

@Path("/v1/customer")
@Produces("application/json")
@Consumes("application/json")
public class CustomerController {
    private final MovieShowService movieShowService;
    private final BookingService bookingService;

    public CustomerController(MovieShowService movieShowService, BookingService bookingService) {
        this.movieShowService = movieShowService;
        this.bookingService = bookingService;
    }

    @GET
    @Path("/shows/{movieName}/{city}")
    public List<MovieShow> find(@PathParam("movieName") String movieName, @PathParam("city") City city) {
        return movieShowService.searchByNameAndCity(movieName,city);
    }

    @POST
    @Path("/booking")
    public Booking booking(Booking booking) {
        return bookingService.book(booking);
    }

    @POST
    @Path("/booking/bulk")
    public List<Booking> bulkBooking(List<Booking> bookings) {
        return bookingService.bulkBook(bookings);
    }

    @GET
    @Path("/booking/{id}")
    public Booking findById(@PathParam("id") String id) {
        return bookingService.findById(id);
    }

    @GET
    @Path("/booking")
    public List<Booking> findAll() {
        return bookingService.findAll();
    }

}
