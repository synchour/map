package com.sh.map.unittest;

import org.junit.Assert;
import org.junit.Test;

import com.sh.map.data.SFMovie;

public class MapApplicationUnitTests {

	@Test
	public void testSFMovieUpdate() {
		SFMovie movie = new SFMovie();
		movie.setLatitude(123);
		Assert.assertNull(movie.getGeoLocation());
		
		movie.updateGeoLocation();
		Assert.assertNotNull(movie.getGeoLocation());
		// y is latitude for Geo point
		Assert.assertEquals(0, movie.getGeoLocation().getY(), 0.001);
		Assert.assertEquals(123, movie.getGeoLocation().getX(), 0.001);
		
		movie.setLongitude(-12);
		movie.updateGeoLocation();
		
		Assert.assertEquals(-12, movie.getGeoLocation().getY(), 0.001);
		Assert.assertEquals(123, movie.getGeoLocation().getX(), 0.001);
	}
}
