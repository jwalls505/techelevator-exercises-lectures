package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDAO;
import com.techelevator.reservations.dao.MemoryHotelDAO;
import com.techelevator.reservations.dao.MemoryReservationDAO;
import com.techelevator.reservations.dao.ReservationDAO;
import com.techelevator.reservations.models.Hotel;
import com.techelevator.reservations.models.Reservation;
import org.springframework.web.bind.annotation.*;

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
     * Return All Hotels
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
    @RequestMapping(path = "/reservations/", method = RequestMethod.GET)
    public List<Reservation> listReservation() {
    	return reservationDAO.findAll();
    }
    @RequestMapping(path = "/reservation/{id}", method = RequestMethod.GET)
    public Reservation getReservationById(@PathVariable int id) {
    	return reservationDAO.get(id);
    }
    @RequestMapping(path = "/hotels/{hotelId}/reservations",method = RequestMethod.GET)
    public List<Reservation> getReserByHotel(@PathVariable int hotelId) {
    	return reservationDAO.findByHotel(hotelId);
    }
    @RequestMapping(path = "/hotels/{hotelID}/reservation", method = RequestMethod.POST)
    public Reservation addReservation(@PathVariable int hotelId, @RequestBody Reservation reservation) {
    	return reservationDAO.create(reservation, hotelId);
    }
    @RequestMapping(path = "/hotels/filter", method = RequestMethod.GET)
    public List<Hotel> filterHotelsByStateAndCity(@RequestParam String state, @RequestParam(required =false) String city) {
    	return null;
    }
}
