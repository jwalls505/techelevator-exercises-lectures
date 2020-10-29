package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDAO;
import com.techelevator.reservations.dao.MemoryHotelDAO;
import com.techelevator.reservations.dao.MemoryReservationDAO;
import com.techelevator.reservations.dao.ReservationDAO;
import com.techelevator.reservations.models.Hotel;
import com.techelevator.reservations.models.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HotelController {

    private HotelDAO hotelDAO;
    private ReservationDAO reservationDAO;

    public HotelController() {
        this.hotelDAO = new MemoryHotelDAO();
        this.reservationDAO = new MemoryReservationDAO(hotelDAO);
    }

    /**
     * Return All Hotels/
     *
     * @return a list of all hotels in the system
     */
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
    public List<Hotel> list() {
        return hotelDAO.list();
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
    public Hotel get(@PathVariable int id) {
        return hotelDAO.get(id);
    }
    
    /**
     * List all reservations
     */
    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
    public List<Reservation> listReservations() {
    	return reservationDAO.findAll();
    }
    
    /** 
     * List reservation by id
     */
    @RequestMapping(path = "/reservations/{id}", method = RequestMethod.GET) 
    public Reservation getReservationById(@PathVariable int id) {
    	return reservationDAO.get(id);
    }
    
    /** 
     * List reservations for a hotel
     */
    @RequestMapping(path = "/hotels/{hotelId}/reservations", method = RequestMethod.GET)
    public List<Reservation> getReservationsForHotel(@PathVariable int hotelId) {
    	return reservationDAO.findByHotel(hotelId);
    }
    
    /**
     * Add a reservation
     */
    @RequestMapping(path = "/hotels/{hotelId}/reservations", method = RequestMethod.POST)
    public Reservation addReservation(@RequestBody Reservation reservation, @PathVariable int hotelId) {
    	return reservationDAO.create(reservation, hotelId);
    }
    
    
    /**
     * Filter hotels by state and (optionally) city
     * 
     * /hotels/filter?state=oh&city=cleveland
     * 
     * @param state
     * @param city
     * @return
     */
    @RequestMapping(path = "/hotels/filter", method = RequestMethod.GET)
    public List<Hotel> filterHotelsByStateAndCity(@RequestParam String state, 
    		@RequestParam(required=false) String city) {
    	
    	List<Hotel> hotels = new ArrayList<>();
    	
    	for(Hotel hotel : hotelDAO.list()) {
    		
    		if(hotel.getAddress().getState().equals(state)) {
    			
    			if(city != null) {
    				if(hotel.getAddress().getCity().equals(city)) { // if they gave us both and they both matched
    					hotels.add(hotel);
    				} 
    			} else { // if they only gave a state and it matched
    				hotels.add(hotel);
    			}
    		}
    		
    		
    	}
    	
    	return hotels;
    }
    
}
