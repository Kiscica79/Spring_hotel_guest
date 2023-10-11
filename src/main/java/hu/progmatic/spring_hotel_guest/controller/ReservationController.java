package hu.progmatic.spring_hotel_guest.controller;

import hu.progmatic.spring_hotel_guest.model.Reservation;
import hu.progmatic.spring_hotel_guest.service.ReservationService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    // új foglalás létrehozása
    @PostMapping("")
    public Reservation createReservation(@RequestBody Reservation reservation) {
            return reservationService.createReservation(reservation);
    }

    // meglévő foglalás módosítása
    @PostMapping("/update/{id}")
    public Reservation updateReservation(@PathVariable Integer id, @RequestBody Reservation reservation) {
        Reservation existingReservation = reservationService.getReservationById(id);
        if (existingReservation == null) {
            System.out.println("Foglalás nem található az azonosító alapján: " + id);
        }

        if (reservationService.isReservationValid(reservation)) {
            assert existingReservation != null;
            existingReservation.setGuest(reservation.getGuest());
            existingReservation.setRoom(reservation.getRoom());
            existingReservation.setGuestCount(reservation.getGuestCount());
            existingReservation.setStartDate(reservation.getStartDate());
            existingReservation.setEndDate(reservation.getEndDate());
            return reservationService.saveReservation(existingReservation);
        } else {
            return null;
        }
    }

    // foglalás törlése
    @DeleteMapping("/delete/{id}")
    public void deleteReservation(@PathVariable Integer id) {
        Reservation reservation = reservationService.getReservationById(id);
        if (reservation == null) {
            System.out.println("Foglalás nem található az azonosító alapján: " + id);
        }
        reservationService.deleteReservation(id);
    }

}



