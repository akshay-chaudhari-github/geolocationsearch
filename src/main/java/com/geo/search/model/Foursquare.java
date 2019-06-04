package com.geo.search.model;

public class Foursquare {
    private String name;
    private String city;
    
    private String state;
    private String country;
    private String address;
    private String formattedAddress;
    private String postalCode;
 
    private String category;
 
    public Foursquare() {
        this.name = "";
        this.city = "";
        this.setCategory("");
        this.address="";
        this.state="";
        this.country="";
        this.formattedAddress="";
        this.postalCode="";
    }
 
    public Foursquare(String name, String city, String state, String country, String address, String formattedAddress,
			String postalCode, String category) {
		super();
		this.name = name;
		this.city = city;
		this.state = state;
		this.country = country;
		this.address = address;
		this.formattedAddress = formattedAddress;
		this.postalCode = postalCode;
		this.category = category;
	}



	public String getCity() {
        if (city.length() > 0) {
            return city;
        }
        return city;
    }
 
    public void setCity(String city) {
        if (city != null) {
            this.city = city.replaceAll("\\(", "").replaceAll("\\)", "");
            ;
        }
    }
 
    public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setName(String name) {
        this.name = name;
    }
 
    public String getName() {
        return name;
    }
 
    public String getCategory() {
        return category;
    }
 
    public void setCategory(String category) {
        this.category = category;
    }

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFormattedAddress() {
		return formattedAddress;
	}

	public void setFormattedAddress(String formattedAddress) {
		this.formattedAddress = formattedAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public String toString() {
		return "Foursquare [name=" + name + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", address=" + address + ", formattedAddress=" + formattedAddress + ", postalCode=" + postalCode
				+ ", category=" + category + "]";
	}

	
}
