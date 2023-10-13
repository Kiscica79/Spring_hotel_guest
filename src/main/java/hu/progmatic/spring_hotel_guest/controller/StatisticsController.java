package hu.progmatic.spring_hotel_guest.controller;

import hu.progmatic.spring_hotel_guest.model.Guest;
import hu.progmatic.spring_hotel_guest.model.Hotel;
import hu.progmatic.spring_hotel_guest.model.Reservation;
import hu.progmatic.spring_hotel_guest.service.GuestService;
import hu.progmatic.spring_hotel_guest.service.HotelService;
import hu.progmatic.spring_hotel_guest.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/statistics")
public class StatisticsController {

    private final HotelService hotelService;
    private final ReservationService reservationService;
    private final GuestService guestService;

    @Autowired
    public StatisticsController(HotelService hotelService, ReservationService reservationService, GuestService guestService) {
        this.hotelService = hotelService;
        this.reservationService = reservationService;
        this.guestService = guestService;

    }

    // Szálloda jelenlegi telítettsége
    @GetMapping("/currentOccupancy")
    public double getCurrentOccupancy() {
        int totalGuests = reservationService.getCurrentOccupancy();
        int maxCapacity = hotelService.calculateMaxCapacity();
        return (double) totalGuests / maxCapacity * 100;
    }


    // Szálloda adott napon lévő telítettsége
    @GetMapping("/occupancyOnDate")
    public double getOccupancyOnDate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        int totalGuests = reservationService.calculateOccupancyOnDate(date);
        int maxCapacity = hotelService.calculateMaxCapacity();
        return (double) totalGuests / maxCapacity * 100;
    }

    // Adott időintervallumban elérhető szobák lekérése
    @GetMapping("/availableRooms")
    public List<Hotel> getAvailableRooms(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return reservationService.getAvailableRooms(startDate, endDate);
    }

    // Adott foglalás végösszegének lekérése
    @GetMapping("/totalPrice")
    public int getReservationTotalPrice(@RequestParam("reservationId") Integer reservationId) {
        Reservation reservation = reservationService.getReservationById(reservationId);
        return reservationService.calculateTotalPrice(reservation);
    }
    // Adott napon születésnapos vendégek lekérése
    @GetMapping("/birthday")
    public List<Guest> getBirthdayGuestsOnDate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return guestService.getGuestsByBirthday(date);
    }

}
