# geolocationsearch

	Project to use Foursquare Places API and get the results for the category in one go.

# REST API :
	 http://localhost:8080/api/search?query=Pune,Maharashtra&category=Historic Site
	
# References :
	 https://developer.foursquare.com/places-api
	 https://developer.foursquare.com/docs
	 
# Foursquare API Used :
     https://api.foursquare.com/v2/venues/search 

#Technology :
	Spring Boot 2.1.5 https://spring.io/projects/spring-boot.
	Spring Boot Reference Guide https://docs.spring.io/spring-boot/docs/2.1.5.RELEASE/reference/htmlsingle/
	
# Build The Project:
 	mvnw clean package
 	
# Run
	mvn spring-boot:run  OR 
	java -jar target/Locations-0.0.1-SNAPSHOT.war 

# Testing
	 mvnw clean test 
	
