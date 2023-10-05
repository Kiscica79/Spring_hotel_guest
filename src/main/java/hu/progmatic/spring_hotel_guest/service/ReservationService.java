package hu.progmatic.spring_hotel_guest.service;

import hu.progmatic.spring_hotel_guest.model.Reservation;
import hu.progmatic.spring_hotel_guest.repo.ReservationRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepo reservationRepo;

    public ReservationService(ReservationRepo reservationRepo) {
        this.reservationRepo = reservationRepo;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepo.findAll();
    }

    // Ellenőrizze, hogy a foglalás érvénytelen, ha a szobában lévő vendégek száma meghaladja a szoba kapacitását
    public boolean isReservationValid(Reservation reservation) {
        int guestsCount = reservation.getRoom().size();
        int maxCapacity = reservation.getRoom().getMaxCapacity();
        return guestsCount <= maxCapacity;
    }


    public Reservation createReservation(Reservation reservation) {
        return reservationRepo.save(reservation);
    }
}
