package com.geo.search.service;

import java.util.List;

import com.geo.search.model.Foursquare;

public interface SearchLocationService {

	public List<Foursquare> getLocationDetailsByCategory(String category,String near);
}
