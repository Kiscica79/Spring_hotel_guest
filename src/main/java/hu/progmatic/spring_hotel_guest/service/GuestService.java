package hu.progmatic.spring_hotel_guest.service;

import hu.progmatic.spring_hotel_guest.model.Guest;
import hu.progmatic.spring_hotel_guest.repo.GuestRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {

    private final GuestRepo guestRepo;

    public GuestService(GuestRepo guestRepo) {
        this.guestRepo = guestRepo;
    }

    public List<Guest> getAllGuests() {
        return guestRepo.findAll();
    }

    public Guest addNewGuest(Guest guest) {
        return guestRepo.save(guest);
    }
}
