package com.systemRealEstate.systemRealEstate.controller.DTO;

import com.systemRealEstate.systemRealEstate.model.Property;
import com.systemRealEstate.systemRealEstate.model.UserEntity;


import java.util.Date;

public class ReservationDTO {
    private Long id;
    private Property property;
    private UserEntity user;
    private Date startDay;
    private Date endDay;


    public ReservationDTO() {
    }

    public ReservationDTO(Long id, Property property, UserEntity user, Date startDay, Date endDay) {
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

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }
}
