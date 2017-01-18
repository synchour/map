package com.sh.map.preprocess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.sh.map.data.SFMovie;

@Component
public class MapPreprocessor{
	
	private static Logger logger = LoggerFactory.getLogger(MapPreprocessor.class);

	@Value("{GMAP_API_KEY}")
	static String googleMapKey;
	
	public void GeoCodeFromGoogle(SFMovie movieLocation) throws Exception {
		String formattedAddress = movieLocation.getFormattedAddress();
		if (formattedAddress != null && !formattedAddress.isEmpty()) {
			logger.warn( "Already geo-located");
			return;
		}
		
		String locationString = movieLocation.getLocation();
		if (locationString == null || locationString.isEmpty()) {
			logger.warn(" No location to map");
			return;
		}
		
		GeoApiContext context = new GeoApiContext().setApiKey(googleMapKey);
		GeocodingResult[] results =  GeocodingApi.geocode(context, locationString + ", San Francisco, CA").await();
		
		if (results.length == 0) {
			logger.warn(locationString + " return NO results" );
			// TODO: can do retry, eg. take out/only take text in bracket etc
			return;
		}
		
		if (results.length > 1) {
			logger.warn(locationString + " return more than 1 results, taking first one" );
		} 
		
		GeocodingResult result = results[0];
		
		logger.info(locationString + "-> " + result.formattedAddress);
		
		movieLocation.setFormattedAddress(result.formattedAddress);
		movieLocation.setLatitude(result.geometry.location.lat);
		movieLocation.setLongitude(result.geometry.location.lng);
	}
}
