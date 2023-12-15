package com.mtb.app.model;

import com.mtb.app.utils.City;
import com.mtb.app.utils.Genre;
import com.mtb.app.utils.Language;
import com.mtb.app.utils.Status;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.Map;

@MongoEntity(collection="Booking")
public class Booking extends PanacheMongoEntity {
    City city;
    String partnerName;
    String movieName;
    Genre genre;
    Language language;
    Long screenNumber;
    LocalDateTime startTime;
    LocalDateTime endTime;
    Map<String,Float> seats;
    Float totalPrice;
    String discount;
    Float finalPrice;
    Status status;

    public Booking() {}

    public Map<String, Float> getSeats() {
        return seats;
    }

    public void setSeats(Map<String, Float> seats) {
        this.seats = seats;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public Float getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Float finalPrice) {
        this.finalPrice = finalPrice;
    }

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
