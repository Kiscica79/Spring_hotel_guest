package hu.progmatic.spring_hotel_guest.service;

import hu.progmatic.spring_hotel_guest.model.Hotel;
import hu.progmatic.spring_hotel_guest.repo.HotelRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

private final HotelRepo hotelRepo;

    public HotelService(HotelRepo hotelRepo) {
        this.hotelRepo = hotelRepo;
    }

    public List<Hotel> getAllHotels() {
        return hotelRepo.findAll();
    }


}
