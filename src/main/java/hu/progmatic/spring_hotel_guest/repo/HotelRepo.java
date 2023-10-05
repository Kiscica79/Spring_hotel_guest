package hu.progmatic.spring_hotel_guest.repo;


import hu.progmatic.spring_hotel_guest.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, Integer> {
}
