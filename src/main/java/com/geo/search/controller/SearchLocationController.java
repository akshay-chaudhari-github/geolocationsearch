package com.geo.search.controller;

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
	
	private  SearchLocationService searchLocationService;
	
	public SearchLocationController(SearchLocationService searchLocationService) {
		this.searchLocationService = searchLocationService;
	}

	@GetMapping("/foursquare/{near}")
	public SearchLocationDto getFourSqaureResponse(@PathVariable String near,
			@RequestParam(name = "category", required = false) String category) {
		return new SearchLocationDto(new Object[]{searchLocationService.getLocationDetailsByCategory(category, near)});
	}
}
