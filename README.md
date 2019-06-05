# geolocationsearch
Overview
The script queries the official Foursquare API (with a user-provided client_id and client_secret from a Foursquare application)searches by category and returns the detailed information for that category.

API :
	 /api/search/foursquare/{near}?category={category}

INPUTS :
	near - Can be a city  with state e.g  Pune,Maharashtra or can be only city  or state ,
	category - Historic Site

OUTPUT :

e.g
{
    "errorCode": null,
    "errorMessage": null,
    "debugMessage": null,
    "status": true,
    "data": [
        [
            {
                "name": "Shaniwar Wada",
                "city": "Pune",
                "state": "Mahārāshtra",
                "country": "India",
                "address": "Shaniwar Peth",
                "formattedAddress": "Shaniwar Peth (Bajirao Road), Pune 411030, Mahārāshtra, India.",
                "postalCode": "411030",
                "category": "Historic Site"
            },
            {
                "name": "Lal Mahal",
                "city": "Pune",
                "state": "Mahārāshtra",
                "country": "India",
                "address": "Corner of Kasba Ganpati Mandir,",
                "formattedAddress": "Corner of Kasba Ganpati Mandir, (off Shivaji Road,), Pune 411030, Mahārāshtra, India.",
                "postalCode": "411030",
                "category": "Historic Site"
            },
            {
                "name": "Dakshinmukhi Maruti",
                "city": "",
                "state": "",
                "country": "India",
                "address": "",
                "formattedAddress": "India.",
                "postalCode": "",
                "category": "Historic Site"
            }
        ]
    ]
}

Usage

Foursquare venue search with near API returns all the places with categories, by using this API we can get data for the particular category.


The Foursquare API has a daily rate limit of 1,000 requests/day for free accounts, but with verification, the rate limit upgrades to 100,000/day. You can test the script with a small bounding box/low grid size to see if it fits your needs before upgrading.



