    package hu.progmatic.spring_hotel_guest.service;

    import hu.progmatic.spring_hotel_guest.model.Guest;
    import hu.progmatic.spring_hotel_guest.repo.GuestRepo;
    import org.springframework.stereotype.Service;

    import java.time.LocalDate;
    import java.util.ArrayList;
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

        public void addNewGuest(Guest guest) {
            guestRepo.save(guest);
        }

        public List<Guest> getGuestsByBirthday(LocalDate date) {
            List<Guest> guestsByBirthday = new ArrayList<>();
            List<Guest> allGuests = guestRepo.findAll();

            for (Guest guest : allGuests) {
                if (guest.getDateOfBirth().getMonth() == date.getMonth() &&
                        guest.getDateOfBirth().getDayOfMonth() == date.getDayOfMonth()) {
                    guestsByBirthday.add(guest);
                }
            }
            return guestsByBirthday;
        }
    }
