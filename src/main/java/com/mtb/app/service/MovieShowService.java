package com.mtb.app.service;

import com.mtb.app.model.MovieShow;
import com.mtb.app.utils.City;

import java.time.LocalDateTime;
import java.util.List;

public interface MovieShowService {
    public MovieShow create(MovieShow movieShow);

    public List<MovieShow> createBulk(List<MovieShow> movieShows);

    public List<MovieShow> listAll();

    public List<MovieShow> searchByNameAndCity(String movieName, City city);

    public MovieShow findByCityAndPartnerNameAndScrnNumAndTimings(City city, String partnerName, Long screenNumber, LocalDateTime startTime, LocalDateTime endTime);
}
