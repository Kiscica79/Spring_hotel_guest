package hu.progmatic.spring_hotel_guest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer roomNumber;
    private Integer maxCapacity;
    private Integer nightlyRate;
    private boolean hasJacuzzi;
    private boolean hasSauna;

    public Hotel() {}

    public Hotel(Integer id, Integer roomNumber, Integer maxCapacity, Integer nightlyRate, boolean hasJacuzzi, boolean hasSauna) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.maxCapacity = maxCapacity;
        this.nightlyRate = nightlyRate;
        this.hasJacuzzi = hasJacuzzi;
        this.hasSauna = hasSauna;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Integer getNightlyRate() {
        return nightlyRate;
    }

    public void setNightlyRate(Integer nightlyRate) {
        this.nightlyRate = nightlyRate;
    }

    public boolean isHasJacuzzi() {
        return hasJacuzzi;
    }

    public void setHasJacuzzi(boolean hasJacuzzi) {
        this.hasJacuzzi = hasJacuzzi;
    }

    public boolean isHasSauna() {
        return hasSauna;
    }

    public void setHasSauna(boolean hasSauna) {
        this.hasSauna = hasSauna;
    }
}
