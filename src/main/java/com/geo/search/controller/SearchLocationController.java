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
@RequestMapping("/api")
public class SearchLocationController {

	private static final Logger logger = LoggerFactory.getLogger(SearchLocationController.class);

	private SearchLocationService searchLocationService;

	public SearchLocationController(SearchLocationService searchLocationService) {
		this.searchLocationService = searchLocationService;
	}

	/**
	 * End point to get all the information for the query and then return 
	 * only the information related to the category  
	 * 
	 * @param query
	 * @param category
	 * @return 
	 * 			SearchLocationDto which contains List<Foursquare> results 
	 * 		else
	 *         SearchLocationDto which contains null;
	 */
	@GetMapping("/search")
	public SearchLocationDto searchPlaces(@RequestParam(name = "query", required = true) String query,
			@RequestParam(name = "category", required = false) String category) {
		try {
			return new SearchLocationDto(
					new Object[] { searchLocationService.getLocationDetailsByCategory(query, category) });
		} catch (Exception e) {
			logger.debug("Exception ::" + e.getMessage());
			return new SearchLocationDto("", e.getMessage(), "", false, new Object[] { null });
		}
	}
}
