package com.mtb.app.repository;

import com.mtb.app.model.MovieShow;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class MovieShowRepository implements PanacheMongoRepository<MovieShow> {
    /**
     *
     * @param movieShow
     * @return
     */
    public MovieShow save(MovieShow movieShow) {
        movieShow.persistOrUpdate();
        return movieShow;
    }

    /**
     *
     * @param movieShows
     * @return
     */
    public List<MovieShow> saveAll(List<MovieShow> movieShows) {
        return movieShows.stream().peek(movieShow -> movieShow.persistOrUpdate()).collect(Collectors.toList()); }

    /**
     *
     * @return
     */
    public List<MovieShow> listAll() {
        return findAll(Sort.by("city")).list();
    }

    /**
     *
     * @param movieShow
     * @return
     */
    public List<MovieShow> listByNameAndCity(MovieShow movieShow) {
        return list("movieName = ?1 and city = ?2",movieShow.getMovieName(),movieShow.getCity());
    }

    /**
     *
     * @param movieShow
     * @return
     */
    public MovieShow findByCityAndPartnerNameAndScrnNumAndTimings(MovieShow movieShow) {
        return find("city = ?1 and partnerName = ?2 and screenNumber = ?3 and startTime = ?4 and endTime = ?5",
                movieShow.getCity(),movieShow.getPartnerName(),movieShow.getScreenNumber(),movieShow.getStartTime(),movieShow.getEndTime()).firstResult();
    }
}
