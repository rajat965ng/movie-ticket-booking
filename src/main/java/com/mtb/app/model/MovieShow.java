package com.mtb.app.model;

import com.mtb.app.utils.City;
import com.mtb.app.utils.Genre;
import com.mtb.app.utils.Language;
import com.mtb.app.utils.Status;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


@MongoEntity(collection="MovieShow")
public class MovieShow extends PanacheMongoEntity {
    City city;
    String partnerName;
    String movieName;
    Genre genre;
    Language language;
    Long screenNumber;
    Map<String,Float> availableSeats;
    List<String> unAvailableSeats;
    LocalDateTime startTime;
    LocalDateTime endTime;
    Status status;

    public MovieShow() {}

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Long getScreenNumber() {
        return screenNumber;
    }

    public void setScreenNumber(Long screenNumber) {
        this.screenNumber = screenNumber;
    }

    public Map<String, Float> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Map<String, Float> availableSeats) {
        this.availableSeats = availableSeats;
    }

    public List<String> getUnAvailableSeats() {
        return unAvailableSeats;
    }

    public void setUnAvailableSeats(List<String> unAvailableSeats) {
        this.unAvailableSeats = unAvailableSeats;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
