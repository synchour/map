package com.sh.map.data;

import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.univocity.parsers.annotations.Parsed;

@Document
public class SFMovie {
	@Parsed(field = "Title")
	@Indexed
	private String title;
	@Parsed(field = "Release Year")
	private String releaseYear;
	@Parsed(field = "Locations")
	private String location;
	@Parsed(field = "Production Company")
	private String productionCompany;
	
	@Parsed(field = "Latitude")
	private double latitude;
	@Parsed(field = "Longitude")
	private double longitude;
	
	@GeoSpatialIndexed
	private Point geoLocation;
	
	@Parsed(field = "FormattedAddress")
	private String formattedAddress;
	
	public void updateGeoLocation() {
		this.geoLocation = new Point(latitude, longitude);
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}
	public String getProductionCompany() {
		return productionCompany;
	}
	public void setProductionCompany(String productionCompany) {
		this.productionCompany = productionCompany;
	}
	public String getFormattedAddress() {
		return formattedAddress;
	}
	public void setFormattedAddress(String formattedAddress) {
		this.formattedAddress = formattedAddress;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public Point getGeoLocation() {
		return geoLocation;
	}
	public void setGeoLocation(Point geoLocation) {
		this.geoLocation = geoLocation;
	}
}