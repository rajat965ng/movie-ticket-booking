package com.mtb.app.service;

import com.mtb.app.model.Booking;
import com.mtb.app.model.MovieShow;
import com.mtb.app.utils.Status;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class PricingServiceImpl implements PricingService {

    private final MovieShowService movieShowService;

    public PricingServiceImpl(MovieShowService movieShowService) {
        this.movieShowService = movieShowService;
    }

    @Override
    public Booking calculate(Booking booking) {
        booking.setTotalPrice(booking.getSeats().values().stream().reduce(Float::sum).get());

        if (booking.getSeats().size()>=3) {
            Discount discount = new FiftyPercentDiscount();
            booking = discount.apply(booking);
        } else if (booking.getStartTime().getHour() >= 12 || booking.getStartTime().getHour() <= 13) {
            Discount discount = new TwentyPercentDiscount();
            booking = discount.apply(booking);
        }

        booking.setFinalPrice(booking.getSeats().values().stream().reduce(Float::sum).get());

        MovieShow movieShow = movieShowService.findByCityAndPartnerNameAndScrnNumAndTimings(booking.getCity(),booking.getPartnerName(),booking.getScreenNumber(),booking.getStartTime(),booking.getEndTime());
        List<String> unavailableSeats = booking.getSeats().keySet().stream().peek(s -> {movieShow.getAvailableSeats().remove(s);}).collect(Collectors.toList());
        movieShow.getUnAvailableSeats().addAll(unavailableSeats);
        movieShowService.create(movieShow);

        booking.setStatus(Status.CONFIRMED);
        return booking;
    }
}
