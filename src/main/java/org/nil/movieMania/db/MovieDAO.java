package org.nil.movieMania.db;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.SessionFactory;
import org.nil.movieMania.core.Movie;

import io.dropwizard.hibernate.AbstractDAO;

public class MovieDAO extends AbstractDAO<Movie>{

	public MovieDAO(SessionFactory sessionFactory) {
		super(sessionFactory);		
	}
	
	public List<Movie> findAll() {
		CriteriaQuery<Movie> criteria = currentSession().getCriteriaBuilder().createQuery(Movie.class);
		Root<Movie> movieRoot = criteria.from(Movie.class);
		criteria.select(movieRoot);
			
		return list(criteria);
	}

	public Optional<Movie> findById(int id) {
		return Optional.ofNullable(get(id));
	}

	public Movie save(Movie movie) {
		return persist(movie);		
	}
}
