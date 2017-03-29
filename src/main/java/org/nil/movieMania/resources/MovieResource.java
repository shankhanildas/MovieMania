package org.nil.movieMania.resources;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.nil.movieMania.api.MovieApi;
import org.nil.movieMania.core.Movie;
import org.nil.movieMania.db.MovieDAO;

import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Path("/movies")
@Api("/movies")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MovieResource implements MovieApi {
	private final MovieDAO movieDAO;

	public MovieResource(MovieDAO movieDAO) {
		super();
		this.movieDAO = movieDAO;
	}

	@GET
	@UnitOfWork
	@ApiOperation(
            value = "Get all the movies",
            notes = "Movies reflect only if it's entered into the local mysql database",
            response = List.class,
            httpMethod = "GET"
    )
	@Override
	public List<Movie> getAllMovies() {
		return movieDAO.findAll();
	}

	@GET
	@Path("/{id}")
	@UnitOfWork
	@ApiOperation(
            value = "Get movies by id",
            notes = "Id is auto generated when movie entry is made in local database",
            response = Movie.class,
            httpMethod = "GET"
    )
	@Override
	public Optional<Movie> getMovieById(@ApiParam @PathParam("id") int id) {
		return movieDAO.findById(id);
	}

	@POST
	@UnitOfWork
	@ApiOperation(
            value = "add a movie to local database",
            notes = "Id needs not to be passed, it will be aauto generated",
            response = Movie.class,
            httpMethod = "POST"
    )
	@Override
	public Movie addMovie(@ApiParam Movie movie) {
		return movieDAO.save(movie);
	}	
}
