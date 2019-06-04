package com.geo.search.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.geo.search.model.Foursquare;
import com.geo.search.service.SearchLocationService;

@Service
public class SearchLocationServiceImpl implements SearchLocationService{

	@Override
	public List<Foursquare> getLocationDetailsByCategory(String category,String near) {
		try {
			// Construct data
			String data = "client_id=C45ZSXXZDSTDVOEDRRNYGSY3T2QSFWE4PXQ2NEEZSSQTCOT0"
					+ "&client_secret=RYUC1LMPGEONZ4ZYX45PRRVI1T40AYKIVORAIW3OZCG5UFLB"
					+ "&v=20190425"
					+ "&near="+near
					+ "&intent=browse";
			//		    System.out.println(data);

			URL url = new URL("https://api.foursquare.com/v2/venues/search");
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(data);
			wr.flush();

			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			wr.close();
			rd.close();

			return getLocationDetails(rd, category);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null; 
	}

	/**
	 * 
	 * @param rd
	 * @return
	 */
	public List<Foursquare> getLocationDetails(BufferedReader rd,String category){
		try {
			String readLineStr;
			List<Foursquare> fsList = new ArrayList<Foursquare>();
			Foursquare fs = new Foursquare();
			while ((readLineStr = rd.readLine()) != null) {
				JSONObject responseObject = new JSONObject(readLineStr);
				//		    	System.out.println("RESPONSE ::"+jsonObject);
				if (responseObject.has("response")) {
					if (responseObject.getJSONObject("response").has("venues")) {
						JSONArray venuesArray = responseObject.getJSONObject("response").getJSONArray("venues");
						for (int iCount = 0; iCount <venuesArray.length(); iCount++) {
							fs = new Foursquare();
							String categoryFromAPI = null;
							if (venuesArray.getJSONObject(iCount).getJSONArray("categories").length() > 0) {
								if(venuesArray.getJSONObject(iCount).getJSONArray("categories").getJSONObject(0).has("icon")) {
									categoryFromAPI = venuesArray.getJSONObject(iCount).getJSONArray("categories").getJSONObject(0).getString("name").trim();
									if(category != null)
										if(categoryFromAPI.equalsIgnoreCase(category.trim()))
											fs.setCategory(venuesArray.getJSONObject(iCount).getJSONArray("categories").getJSONObject(0).getString("name"));
										else
											continue;
								}
							}else {
								if(category != null)
									continue;
							}

							fs.setName(venuesArray.getJSONObject(iCount).has("name") ? venuesArray.getJSONObject(iCount).getString("name") : "");
							fs.setCity(venuesArray.getJSONObject(iCount).getJSONObject("location").has("city") ? 
									venuesArray.getJSONObject(iCount).getJSONObject("location").getString("city") : "");
							fs.setCountry(venuesArray.getJSONObject(iCount).getJSONObject("location").has("country") ? 
									venuesArray.getJSONObject(iCount).getJSONObject("location").getString("country") : "");
							fs.setAddress(venuesArray.getJSONObject(iCount).getJSONObject("location").has("address") ? 
									venuesArray.getJSONObject(iCount).getJSONObject("location").getString("address") : "");
							fs.setPostalCode(venuesArray.getJSONObject(iCount).getJSONObject("location").has("postalCode") ? 
									venuesArray.getJSONObject(iCount).getJSONObject("location").getString("postalCode") : "");
							fs.setState(venuesArray.getJSONObject(iCount).getJSONObject("location").has("state") ? 
									venuesArray.getJSONObject(iCount).getJSONObject("location").getString("state") : "");

							JSONArray formattedAdd = venuesArray.getJSONObject(iCount).getJSONObject("location").getJSONArray("formattedAddress");
							String formattedAddStr = "";
							if(formattedAdd.length() > 0) {
								for(int jCount = 0 ; jCount < formattedAdd.length(); jCount++) {
									if(formattedAdd.get(jCount).toString().endsWith(","))
										formattedAddStr += formattedAdd.get(jCount);
									else
										formattedAddStr += formattedAdd.get(jCount)+ ", ";
								}
							} 
							fs.setFormattedAddress(formattedAddStr.substring(0,formattedAddStr.lastIndexOf(",") - 1) + ".");

							fsList.add(fs);
						}
					}
				}	
			}
			return fsList;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
