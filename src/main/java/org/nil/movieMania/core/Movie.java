package org.nil.movieMania.core;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "nil_movies")
public class Movie {

	@Id
	@Column(name = "movie_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieId;

	@Column(name = "movie_name", nullable = false)
	@NotNull
	private String movieName;

	@Column(name = "movie_entry_date", nullable = false)
	@NotNull
	private Date movieEntryDate;

	@Column(name = "movie_watch_date", nullable = true)
	private Date movieWatchDate;

	@Column(name = "imdb_id", nullable = true)
	private String imdbId;

	@Column(name = "my_rating", nullable = true)
	private Integer myRating;

	@Column(name = "my_comment", nullable = true)
	private String myComment;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imdbId == null) ? 0 : imdbId.hashCode());
		result = prime * result + movieId;
		return result;
	}

	public Movie(int movieId, String movieName, Date movieEntryDate, Date movieWatchDate, String imdbId,
			Integer myRating, String myComment) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieEntryDate = movieEntryDate;
		this.movieWatchDate = movieWatchDate;
		this.imdbId = imdbId;
		this.myRating = myRating;
		this.myComment = myComment;
	}

	public Movie() {

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (imdbId == null) {
			if (other.imdbId != null)
				return false;
		} else if (!imdbId.equals(other.imdbId))
			return false;
		if (movieId != other.movieId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieEntryDate=" + movieEntryDate
				+ ", movieWatchDate=" + movieWatchDate + ", imdbId=" + imdbId + ", myRating=" + myRating
				+ ", myComment=" + myComment + "]";
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Date getMovieEntryDate() {
		return movieEntryDate;
	}

	public void setMovieEntryDate(Date movieEntryDate) {
		this.movieEntryDate = movieEntryDate;
	}

	public Date getMovieWatchDate() {
		return movieWatchDate;
	}

	public void setMovieWatchDate(Date movieWatchDate) {
		this.movieWatchDate = movieWatchDate;
	}

	public String getImdbId() {
		return imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	public Integer getMyRating() {
		return myRating;
	}

	public void setMyRating(Integer myRating) {
		this.myRating = myRating;
	}

	public String getMyComment() {
		return myComment;
	}

	public void setMyComment(String myComment) {
		this.myComment = myComment;
	}

}
