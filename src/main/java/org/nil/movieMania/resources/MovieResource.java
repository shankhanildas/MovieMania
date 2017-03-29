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

@Path("/movies")
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
	@Override
	public List<Movie> getAllMovies() {
		return movieDAO.findAll();
	}

	@GET
	@Path("/{id}")
	@UnitOfWork
	@Override
	public Optional<Movie> getMovieById(@PathParam("id") int id) {
		return movieDAO.findById(id);
	}

	@POST
	@UnitOfWork
	@Override
	public Movie addMovie(Movie movie) {
		return movieDAO.save(movie);
	}	
}
