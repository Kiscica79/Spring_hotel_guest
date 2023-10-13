package hu.progmatic.spring_hotel_guest.controller;

import hu.progmatic.spring_hotel_guest.model.Guest;
import hu.progmatic.spring_hotel_guest.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
    public String getAllGuests(Model model) {
        List<Guest> guests = guestService.getAllGuests();
        model.addAttribute("guests", guests);
        return "guests";  // Ez az elérési út a Thymeleaf sablonhoz a templates mappában
    }

    // új vendég hozzáadása
    @PostMapping("")
    public String addNewGuest(Guest guest) {
        guestService.addNewGuest(guest);
        return "redirect:/guests";
    }

}
