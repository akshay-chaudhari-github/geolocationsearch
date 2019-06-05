package com.geo.search.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.geo.search.model.Foursquare;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchLocationServiceImplTest {

	@MockBean
	SearchLocationServiceImpl searchLocationService;

	@Test
	public void test() {
		try {
			Foursquare f = new Foursquare("Chicago Helicopter Experience", "Chicago", "IL", "United States",
					"2420 S Halsted St", "2420 S Halsted St, Chicago, IL 60608, United State.", "60608", "Heliport");
			List<Foursquare> fList = new ArrayList<Foursquare>();
			fList.add(f);

			when(searchLocationService.getLocationDetailsByCategory("Chicago,IL", "Heliport")).thenReturn(fList);

			assertEquals(fList, searchLocationService.getLocationDetailsByCategory("Chicago,IL", "Heliport"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
