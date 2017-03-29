package org.nil.movieMania;

import org.nil.movieMania.core.Movie;
import org.nil.movieMania.db.MovieDAO;
import org.nil.movieMania.resources.MovieResource;

import io.dropwizard.Application;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class MovieManiaApplication extends Application<MovieManiaConfiguration> {

	private final HibernateBundle<MovieManiaConfiguration> hibernateBundle = new HibernateBundle<MovieManiaConfiguration>(Movie.class) {

		@Override
		public PooledDataSourceFactory getDataSourceFactory(MovieManiaConfiguration conf) {
			return conf.getDataSourceFactory();
		}
	};
	
    public static void main(final String[] args) throws Exception {
        new MovieManiaApplication().run(args);
    }

    @Override
    public String getName() {
        return "MovieMania";
    }

    @Override
    public void initialize(final Bootstrap<MovieManiaConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(final MovieManiaConfiguration configuration,
                    final Environment environment) {
    	
    	final MovieDAO movieDAO = new MovieDAO(hibernateBundle.getSessionFactory());
    	
        environment.jersey().register(new MovieResource(movieDAO));
    }
}
