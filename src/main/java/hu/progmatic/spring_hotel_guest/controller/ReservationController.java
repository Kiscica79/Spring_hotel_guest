package hu.progmatic.spring_hotel_guest.controller;

import hu.progmatic.spring_hotel_guest.model.Reservation;
import hu.progmatic.spring_hotel_guest.service.ReservationService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("")
    public Reservation createReservation(@RequestBody Reservation reservation) {
        if (reservationService.isReservationValid(reservation)) {
            return reservationService.createReservation(reservation);
        } else {
            return null;
        }
    }


}
