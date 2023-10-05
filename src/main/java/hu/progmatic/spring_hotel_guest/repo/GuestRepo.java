package hu.progmatic.spring_hotel_guest.repo;

import hu.progmatic.spring_hotel_guest.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepo  extends JpaRepository<Guest, Integer> {
}
