package com.mtb.app;

import com.mtb.app.model.MovieShow;
import com.mtb.app.service.MovieShowService;
import jakarta.ws.rs.*;

import java.util.List;

@Path("/v1/partner")
@Produces("application/json")
@Consumes("application/json")
public class PartnerController {
    private final MovieShowService movieShowService;
    public PartnerController(MovieShowService movieShowService) {
        this.movieShowService = movieShowService;
    }

    @POST
    @Path("/onboard")
    public MovieShow create(MovieShow movieShow) {
        return movieShowService.create(movieShow);
    }

    @POST
    @Path("/onboard/bulk")
    public List<MovieShow> createBulk(List<MovieShow> movieShows) {
        return movieShowService.createBulk(movieShows);
    }

    @GET
    @Path("")
    public List<MovieShow> listAll() {
        return movieShowService.listAll();
    }

}
