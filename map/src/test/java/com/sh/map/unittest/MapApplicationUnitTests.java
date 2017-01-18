package com.sh.map.unittest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sh.map.data.SFMovie;

@RunWith(SpringJUnit4ClassRunner.class)
public class MapApplicationUnitTests {

	static double comparisonDelta = 0.001;
	
	@Test
	public void testSFMovieUpdate() {
		SFMovie movie = new SFMovie();
		movie.setLatitude(123);
		Assert.assertNull(movie.getGeoLocation());
		
		movie.updateGeoLocation();
		Assert.assertNotNull(movie.getGeoLocation());
		// y is latitude for Geo point
		Assert.assertEquals(0, movie.getGeoLocation().getY(), comparisonDelta);
		Assert.assertEquals(123, movie.getGeoLocation().getX(), comparisonDelta);
		
		movie.setLongitude(-12);
		movie.updateGeoLocation();
		
		Assert.assertEquals(-12, movie.getGeoLocation().getY(), comparisonDelta);
		Assert.assertEquals(123, movie.getGeoLocation().getX(), comparisonDelta);
	}
}
