package org.nil.movieMania;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

public class MovieManiaConfiguration extends Configuration {
	@NotNull
	@Valid
	private final DataSourceFactory dataSourceFactory = new DataSourceFactory();

	@NotNull
	@Valid
	public SwaggerBundleConfiguration swaggerBundleConfiguration;

	@JsonProperty("database")
	public DataSourceFactory getDataSourceFactory() {
		return dataSourceFactory;
	}

	@JsonProperty("swagger")
	public SwaggerBundleConfiguration getSwaggerBundleConfiguration() {
		return swaggerBundleConfiguration;
	}
}
