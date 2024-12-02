package com.systemRealEstate.systemRealEstate.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private Property property;
    @NotEmpty
    private UserEntity user;
    @NotEmpty
    private Date startDay;
    @NotEmpty
    private Date endDay;


    public Reservation() {
    }

    public Reservation(Long id, Property property, UserEntity user, Date startDay, Date endDay) {
        this.id = id;
        this.property = property;
        this.user = user;
        this.startDay = startDay;
        this.endDay = endDay;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotEmpty Property getProperty() {
        return property;
    }

    public void setProperty(@NotEmpty Property property) {
        this.property = property;
    }

    public @NotEmpty UserEntity getUser() {
        return user;
    }

    public void setUser(@NotEmpty UserEntity user) {
        this.user = user;
    }

    public @NotEmpty Date getStartDay() {
        return startDay;
    }

    public void setStartDay(@NotEmpty Date startDay) {
        this.startDay = startDay;
    }

    public @NotEmpty Date getEndDay() {
        return endDay;
    }

    public void setEndDay(@NotEmpty Date endDay) {
        this.endDay = endDay;
    }
}
