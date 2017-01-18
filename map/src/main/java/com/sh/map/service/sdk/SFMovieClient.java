package com.sh.map.service.sdk;


import java.net.URI;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.sh.map.data.SFMoviesResponse;

@Component
public class SFMovieClient {

	String serviceRoot = "http://localhost:8000/sfmovie";
	
	RestTemplate rest = new RestTemplate();

	public SFMoviesResponse autoCompleteSearch(String searchTerm) {
		
		URI targetUrl= UriComponentsBuilder.fromUriString(serviceRoot)
			    .path("/titles")
			    .queryParam("searchTerm", searchTerm)
			    .build()
			    .toUri();
		return rest.getForObject(targetUrl, SFMoviesResponse.class);
	}
	
	public SFMoviesResponse listAllLocations(String title) {
		URI targetUrl= UriComponentsBuilder.fromUriString(serviceRoot)
			    .path("/titleLocations")
			    .queryParam("title", title)
			    .build()
			    .toUri();
		return rest.getForObject(targetUrl, SFMoviesResponse.class);
	}

}
