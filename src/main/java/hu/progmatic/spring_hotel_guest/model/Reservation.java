package hu.progmatic.spring_hotel_guest.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "guest_id") // Guest entitás oszlopa kapcsolat
    private Guest guest;
    @ManyToOne
    @JoinColumn(name = "room_id") // Hotel entitás oszlopa kapcsolat
    private Hotel room;
    private LocalDate startDate;
    private LocalDate endDate;

    public Reservation() {}

    public Reservation(Integer id, Guest guest, Hotel room, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.guest = guest;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Hotel getRoom() {
        return room;
    }

    public void setRoom(Hotel room) {
        this.room = room;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
