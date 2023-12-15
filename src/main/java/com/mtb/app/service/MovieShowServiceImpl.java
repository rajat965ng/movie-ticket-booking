package com.mtb.app.service;

import com.mtb.app.model.Booking;
import com.mtb.app.model.MovieShow;
import com.mtb.app.repository.MovieShowRepository;
import com.mtb.app.utils.City;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class MovieShowServiceImpl implements MovieShowService {
    private MovieShowRepository movieShowRepository;

    public MovieShowServiceImpl(MovieShowRepository movieShowRepository) {
        this.movieShowRepository = movieShowRepository;
    }

    @Override
    public MovieShow create(MovieShow movieShow) {
        return movieShowRepository.save(movieShow);
    }

    @Override
    public List<MovieShow> createBulk(List<MovieShow> movieShows) {
        return movieShowRepository.saveAll(movieShows);
    }

    @Override
    public List<MovieShow> listAll() {
        return movieShowRepository.listAll();
    }

    @Override
    public List<MovieShow> searchByNameAndCity(String movieName, City city) {
        MovieShow movieShow = new MovieShow();
        movieShow.setCity(city);
        movieShow.setMovieName(movieName);
        return movieShowRepository.listByNameAndCity(movieShow);
    }

    @Override
    public MovieShow findByCityAndPartnerNameAndScrnNumAndTimings(City city, String partnerName,
                                                                  Long screenNumber,
                                                                  LocalDateTime startTime,
                                                                  LocalDateTime endTime) {
        MovieShow movieShow = new MovieShow();
        movieShow.setCity(city);
        movieShow.setPartnerName(partnerName);
        movieShow.setScreenNumber(screenNumber);
        movieShow.setStartTime(startTime);
        movieShow.setEndTime(endTime);
        return movieShowRepository.findByCityAndPartnerNameAndScrnNumAndTimings(movieShow);
    }
}
