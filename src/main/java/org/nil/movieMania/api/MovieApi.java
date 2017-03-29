package org.nil.movieMania.api;

import java.util.List;
import java.util.Optional;

import org.nil.movieMania.core.Movie;

public interface MovieApi {
	public List<Movie> getAllMovies();
	public Optional<Movie> getMovieById(int id);
	public Movie addMovie(Movie movie);
}
