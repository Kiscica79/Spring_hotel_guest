package hu.progmatic.spring_hotel_guest.service;

import hu.progmatic.spring_hotel_guest.model.Hotel;
import hu.progmatic.spring_hotel_guest.model.Reservation;
import hu.progmatic.spring_hotel_guest.repo.ReservationRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        int guestsCount = reservation.getGuestCount();
        int maxCapacity = reservation.getRoom().getMaxCapacity();
        return guestsCount <= maxCapacity;
    }

    // új
    public Reservation createReservation(Reservation reservation) {
        return reservationRepo.save(reservation);
    }

    // megtalálás ID alapján
    public Reservation getReservationById(Integer id) {
        Optional<Reservation> reservation = reservationRepo.findById(id);
        return reservation.orElse(null);
    }

    // törlés
    public void deleteReservation(Integer id) {
        Reservation reservation = getReservationById(id);
        if (reservation == null) {
            System.out.println("Foglalás nem található az azonosító alapján: " + id);
        }
        assert reservation != null;
        reservationRepo.delete(reservation);
    }

    // elmentés
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepo.save(reservation);
    }
    public int getCurrentOccupancy() {
        List<Reservation> allReservations = getAllReservations();
        int totalGuests = 0;
        for (Reservation reservation : allReservations) {
            totalGuests += reservation.getGuestCount();
        }
        return totalGuests;
    }

        public int calculateOccupancyOnDate(LocalDate date) {
        List<Reservation> reservationsOnDate = getReservationsOnDate(date);
        int totalGuests = 0;

        for (Reservation reservation : reservationsOnDate) {
            totalGuests += reservation.getGuestCount();
        }

        return totalGuests;
    }

    public List<Reservation> getReservationsOnDate(LocalDate date) {
        List<Reservation> reservationsOnDate = new ArrayList<>();
        List<Reservation> allReservations = reservationRepo.findAll();

        for (Reservation reservation : allReservations) {
            if (reservation.getStartDate().isBefore(date) && reservation.getEndDate().isAfter(date)) {
                reservationsOnDate.add(reservation);
            }
        }
        return reservationsOnDate;
    }


    public int calculateTotalPrice(Reservation reservation) {
            LocalDate startDate = reservation.getStartDate();
            LocalDate endDate = reservation.getEndDate();
            int numberOfNights = (int) ChronoUnit.DAYS.between(startDate, endDate);
            int totalPrice = reservation.getRoom().getNightlyRate() * numberOfNights;

            return totalPrice;
    }

    public List<Hotel> getAvailableRooms(LocalDate startDate, LocalDate endDate) {
        return null;
    }
}
