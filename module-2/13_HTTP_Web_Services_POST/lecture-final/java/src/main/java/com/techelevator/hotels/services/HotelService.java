package com.techelevator.hotels.services;

import com.techelevator.hotels.models.Hotel;
import com.techelevator.hotels.models.Reservation;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

public class HotelService {

	private final String BASE_URL;
	private final RestTemplate restTemplate = new RestTemplate();
	private final ConsoleService console = new ConsoleService();

	public HotelService(String url) {
		BASE_URL = url;
	}

	/**
	 * Create a new reservation in the hotel reservation system
	 *
	 * @param newReservation
	 * @return Reservation
	 */
	public Reservation addReservation(String newReservation) {
		if(newReservation == null) {
			return null;
		}
		
		Reservation myReservation = makeReservation(newReservation);
		
		if(myReservation == null) {
			return null;
		}
		
		HttpEntity<Reservation> entity = makeEntity(myReservation);
		
		Reservation result = null;
		
		try {
			result = restTemplate.postForObject(BASE_URL + "reservations", entity, Reservation.class);
		} catch(RestClientResponseException e) {
			int statusCode = e.getRawStatusCode();
			String statusText = e.getStatusText();
			
			console.printError("Status Code: " + statusCode + " Status Text: " + statusText);
		}
		catch(ResourceAccessException e) {
			
			console.printError(e.getMessage());
		}
		
		
		return result;
	}

	/**
	 * Updates an existing reservation by replacing the old one with a new
	 * reservation
	 *
	 * @param CSV
	 * @return
	 */
	public Reservation updateReservation(String CSV) {
		if(CSV == null) {
			return null;
		}
		
		Reservation myReservation = makeReservation(CSV);
		
		if(myReservation == null) {
			return null;
		}
		
		HttpEntity<Reservation> entity = makeEntity(myReservation);
		
		try {
			restTemplate.put(BASE_URL + "reservations/" + myReservation.getId(), entity);
			
			
		} catch(RestClientResponseException e) {
			int statusCode = e.getRawStatusCode();
			String statusText = e.getStatusText();
			
			console.printError("Status Code: " + statusCode + " Status Text: " + statusText);
			
			return null;
		}
		catch(ResourceAccessException e) {
			
			console.printError(e.getMessage());
			
			return null;
		}
		
		
		return myReservation;
	}

	/**
	 * Delete an existing reservation
	 *
	 * @param id
	 */
	public void deleteReservation(int id) {
		try {
			// e.g.  http://localhost:3000/reservations/320
			
			restTemplate.delete(BASE_URL + "reservations/" + id);
			
		} catch(RestClientResponseException e) {
			int statusCode = e.getRawStatusCode();
			String statusText = e.getStatusText();
			
			console.printError("Status Code: " + statusCode + " Status Text: " + statusText);
		}
		catch(ResourceAccessException e) {
			console.printError(e.getMessage());
		}
	}

	/* DON'T MODIFY ANY METHODS BELOW */

	/**
	 * List all hotels in the system
	 *
	 * @return
	 */
	public Hotel[] listHotels() {
		Hotel[] hotels = null;
		try {
			hotels = restTemplate.getForObject(BASE_URL + "hotels", Hotel[].class);
		} catch (RestClientResponseException ex) {
			// handles exceptions thrown by rest template and contains status codes
			console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
		} catch (ResourceAccessException ex) {
			// i/o error, ex: the server isn't running
			console.printError(ex.getMessage());
		}
		return hotels;
	}

	/**
	 * Get the details for a single hotel by id
	 *
	 * @param id
	 * @return Hotel
	 */
	public Hotel getHotel(int id) {
		Hotel hotel = null;
		try {
			hotel = restTemplate.getForObject(BASE_URL + "hotels/" + id, Hotel.class);
		} catch (RestClientResponseException ex) {
			console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
		} catch (ResourceAccessException ex) {
			console.printError(ex.getMessage());
		}
		return hotel;
	}

	/**
	 * List all reservations in the hotel reservation system
	 *
	 * @return Reservation[]
	 */
	public Reservation[] listReservations() {
		Reservation[] reservations = null;
		try {
			reservations = restTemplate.getForObject(BASE_URL + "reservations", Reservation[].class);
		} catch (RestClientResponseException ex) {
			console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
		} catch (ResourceAccessException ex) {
			console.printError(ex.getMessage());
		}
		return reservations;
	}

	/**
	 * List all reservations by hotel id.
	 *
	 * @param hotelId
	 * @return Reservation[]
	 */
	public Reservation[] listReservationsByHotel(int hotelId) {
		Reservation[] reservations = null;
		try {
			reservations = restTemplate.getForObject(BASE_URL + "hotels/" + hotelId + "/reservations",
					Reservation[].class);
		} catch (RestClientResponseException ex) {
			console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
		} catch (ResourceAccessException ex) {
			console.printError(ex.getMessage());
		}
		return reservations;
	}

	/**
	 * Find a single reservation by the reservationId
	 *
	 * @param reservationId
	 * @return Reservation
	 */
	public Reservation getReservation(int reservationId) {
		Reservation reservation = null;
		try {
			reservation = restTemplate.getForObject(BASE_URL + "reservations/" + reservationId, Reservation.class);
		} catch (RestClientResponseException ex) {
			console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
		} catch (ResourceAccessException ex) {
			console.printError(ex.getMessage());
		}
		return reservation;
	}

	private Reservation makeReservation(String CSV) {
		String[] parsed = CSV.split(",");

		// invalid input (
		if (parsed.length < 5 || parsed.length > 6) {
			return null;
		}

		// Add method does not include an id and only has 5 strings
		if (parsed.length == 5) {
			// Create a string version of the id and place into an array to be concatenated
			String[] withId = new String[6];
			String[] idArray = new String[] { new Random().nextInt(1000) + "" };
			// place the id into the first position of the data array
			System.arraycopy(idArray, 0, withId, 0, 1);
			System.arraycopy(parsed, 0, withId, 1, 5);
			parsed = withId;
		}

		return new Reservation(Integer.parseInt(parsed[0].trim()), Integer.parseInt(parsed[1].trim()), parsed[2].trim(),
				parsed[3].trim(), parsed[4].trim(), Integer.parseInt(parsed[5].trim()));
	}
	
	private HttpEntity<Reservation> makeEntity(Reservation reservation) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<Reservation> entity = new HttpEntity<>(reservation, headers);
		
		return entity;
	}

}
