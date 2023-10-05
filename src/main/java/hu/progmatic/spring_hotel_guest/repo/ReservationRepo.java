package hu.progmatic.spring_hotel_guest.repo;

import hu.progmatic.spring_hotel_guest.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Integer> {
}
