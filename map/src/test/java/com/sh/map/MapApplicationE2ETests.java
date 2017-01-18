package com.sh.map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.sh.map.data.SFMovieTitle;
import com.sh.map.data.SFMoviesResponse;
import com.sh.map.repository.SFMovieRepository;
import com.sh.map.repository.SFMovieTitleRepository;
import com.sh.map.service.sdk.SFMovieClient;

import java.util.List;

import org.junit.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@ActiveProfiles("dev")
public class MapApplicationE2ETests {

	@Autowired
	SFMovieClient movieClient;
	
	@Test
	public void testAutoCompleteWithNull() {
		SFMoviesResponse response = movieClient.autoCompleteSearch(null);
		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getMovieLocations());
		Assert.assertEquals(0, response.getMovieLocations().size());
	}
	
	@Test
	public void testAutoCompleteWithEmpty() {
		SFMoviesResponse response = movieClient.autoCompleteSearch("");
		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getMovieLocations());
		Assert.assertEquals(0, response.getMovieLocations().size());
	}
	
	@Test
	public void testAutoComplete() {
		SFMoviesResponse response = movieClient.autoCompleteSearch("1");
		Assert.assertNotNull(response);
	}

	@Test
	public void testFindLocations() {
		SFMoviesResponse response = movieClient.listAllLocations("1");
		Assert.assertNotNull(response);
	}
	
	@Autowired
	SFMovieRepository movieRepo;
	
	@Autowired
	SFMovieTitleRepository movieTitleRepo;
	
	@Test
	public void testMovieTitleSearch() {
		List<SFMovieTitle> movieTitles = movieTitleRepo.findByTitleContainingIgnoreCase("8");
		for (SFMovieTitle sfMovieTitle : movieTitles) {
			System.out.println(sfMovieTitle.getTitle());
		}
		Assert.assertTrue(movieTitles.size() > 0);
	}
	
}
