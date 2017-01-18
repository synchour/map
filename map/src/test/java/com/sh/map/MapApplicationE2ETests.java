package com.sh.map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.sh.map.data.SFMoviesResponse;
import com.sh.map.service.sdk.SFMovieClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class MapApplicationE2ETests {

	@Autowired
	SFMovieClient movieClient;
	
	@Test
	public void testAutoComplete() {
		SFMoviesResponse response = movieClient.autoCompleteSearch("1");
		Assert.notNull(response);
	}

	@Test
	public void testFindLocations() {
		SFMoviesResponse response = movieClient.listAllLocations("1");
		Assert.notNull(response);
	}
}
