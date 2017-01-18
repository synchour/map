package com.sh.map.data;

import java.util.ArrayList;
import java.util.Collection;

public class SFMoviesResponse {
	private Collection movieLocations;

	public SFMoviesResponse() {
		this.movieLocations = new ArrayList();
	}
	public SFMoviesResponse(Collection movieLocations) {
		if (movieLocations == null) {
			this.movieLocations = new ArrayList();
		} else {
			this.movieLocations = movieLocations;			
		}
	}
	
	public Collection getMovieLocations() {
		return movieLocations;
	}

	public void setMovieLocations(Collection movieLocations) {
		this.movieLocations = movieLocations;
	}
}
