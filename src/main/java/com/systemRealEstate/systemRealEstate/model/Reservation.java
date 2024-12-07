package com.systemRealEstate.systemRealEstate.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @ManyToOne
    @JoinColumn
    private Property property;
    //@NotNull
    @ManyToOne
    @JoinColumn(name ="user_id")
    private UserEntity user;
    @NotNull
    @Column(length = 10)
    private Date startDay;
    @NotNull
    @Column(length = 10)
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

    public @NotNull Property getProperty() {
        return property;
    }

    public void setProperty(@NotNull Property property) {
        this.property = property;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public @NotNull Date getStartDay() {
        return startDay;
    }

    public void setStartDay(@NotNull Date startDay) {
        this.startDay = startDay;
    }

    public @NotNull Date getEndDay() {
        return endDay;
    }

    public void setEndDay(@NotNull Date endDay) {
        this.endDay = endDay;
    }
}
