package com.geo.search.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geo.search.service.SearchLocationService;
import com.geo.search.service.dto.SearchLocationDto;

@RestController
@RequestMapping("/api/search")
public class SearchLocationController {

	private static final Logger logger = LoggerFactory.getLogger(SearchLocationController.class);

	private  SearchLocationService searchLocationService;

	public SearchLocationController(SearchLocationService searchLocationService) {
		this.searchLocationService = searchLocationService;
	}

	@GetMapping("/foursquare/{near}")
	public SearchLocationDto getFourSqaureResponse(@PathVariable String near,
			@RequestParam(name = "category", required = false) String category) { 
		try {
			return new SearchLocationDto(new Object[]{searchLocationService.getLocationDetailsByCategory(near,category)});
		} catch (Exception e) {
			return new SearchLocationDto("", e.getMessage(), "", false, new Object[] {null});
		}
	}
}
