package com.sh.map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.sh.map.data.SFMoviesResponse;
import com.sh.map.data.SFMoviesTitleResponse;
import com.sh.map.service.sdk.SFMovieClient;

import org.junit.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@ActiveProfiles("dev")
public class MapApplicationE2ETests {
	
	@Autowired
	SFMovieClient movieClient;
	
	private boolean titleContainsExactOnce(SFMoviesTitleResponse response, String title) {
		return response.getMovieLocations().stream().filter(m -> m.getTitle().equals(title)).count() == 1;
	}
	
	@Test
	public void testAutoCompleteWithNull() {
		SFMoviesTitleResponse response = movieClient.autoCompleteSearch(null);
		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getMovieLocations());
		Assert.assertEquals(0, response.getMovieLocations().size());
	}
	
	@Test
	public void testAutoCompleteWithEmpty() {
		SFMoviesTitleResponse response = movieClient.autoCompleteSearch("");
		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getMovieLocations());
		Assert.assertEquals(0, response.getMovieLocations().size());
	}
	
	@Test
	public void testAutoCompleteExactMatch() {
		SFMoviesTitleResponse response = movieClient.autoCompleteSearch("180");
		Assert.assertNotNull(response);
		Assert.assertEquals(1, response.getMovieLocations().size());
		Assert.assertTrue(titleContainsExactOnce(response, "180"));
	}
	
	@Test
	public void testAutoCompleteContains() {
		SFMoviesTitleResponse response = movieClient.autoCompleteSearch("of");
		Assert.assertNotNull(response);
		Assert.assertEquals(2, response.getMovieLocations().size());
		Assert.assertTrue(titleContainsExactOnce(response, "A Night Full of Rain"));
		Assert.assertTrue(titleContainsExactOnce(response, "Age of Adaline"));
		//V2: this movie is filtered since there is no geo-location
		//Assert.assertTrue(titleContainsExactOnce(response, "Attack of the Killer Tomatoes"));
	}

	@Test
	public void testFindLocationsInvalidTitle() {
		SFMoviesResponse response = movieClient.listAllLocations("19");
		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getMovieLocations());
		Assert.assertEquals(0, response.getMovieLocations().size());
	}
	
	@Test
	public void testFindLocationsPartialTitle() {
		SFMoviesResponse response = movieClient.listAllLocations("of");
		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getMovieLocations());
		Assert.assertEquals(0, response.getMovieLocations().size());
	}
	
	@Test
	public void testFullTitle() {
		SFMoviesResponse response = movieClient.listAllLocations("A Night Full of Rain");
		Assert.assertNotNull(response);
		//Only showing 2 locations since other 2 don't have coordinates
		//The design can be changed to also send the raw address to the client
		Assert.assertEquals(2, response.getMovieLocations().size());
	}
}
