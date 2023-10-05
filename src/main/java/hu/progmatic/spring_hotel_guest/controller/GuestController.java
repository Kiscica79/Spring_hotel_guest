package hu.progmatic.spring_hotel_guest.controller;

import hu.progmatic.spring_hotel_guest.model.Guest;
import hu.progmatic.spring_hotel_guest.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guests")
public class GuestController {

    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping
    public List<Guest> getAllGuests() {
        return guestService.getAllGuests();
    }

    // új vendég hozzáadása
    @PostMapping("")
    public Guest addNewGuest(@RequestBody Guest guest) {
        return guestService.addNewGuest(guest);
    }

}
