package com.systemRealEstate.systemRealEstate.controller.DTO;


import com.systemRealEstate.systemRealEstate.model.Property;
import com.systemRealEstate.systemRealEstate.model.UserEntity;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.util.List;

public class PropertyDTO {
    private Long id;
    private String name;
    private String description;
    private Property.Type type;
    private Integer maxGuest;
    private Integer numRooms;
    private Integer numBeds;
    private Integer  numBathrooms;
    private BigDecimal price;
    private List<String> images;
    private BigDecimal latitude;
    private BigDecimal length;
    private UserEntity user;


    public PropertyDTO() {
    }

    public PropertyDTO(Long id, String name, String description, Property.Type type, Integer maxGuest, Integer numRooms, Integer numBeds, Integer numBathrooms, BigDecimal price, List<String> images, BigDecimal latitude, BigDecimal length, UserEntity user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.maxGuest = maxGuest;
        this.numRooms = numRooms;
        this.numBeds = numBeds;
        this.numBathrooms = numBathrooms;
        this.price = price;
        this.images = images;
        this.latitude = latitude;
        this.length = length;
        this.user = user;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Integer getMaxGuest() {
        return maxGuest;
    }

    public void setMaxGuest(Integer maxGuest) {
        this.maxGuest = maxGuest;
    }

    public Integer getNumRooms() {
        return numRooms;
    }

    public void setNumRooms(Integer numRooms) {
        this.numRooms = numRooms;
    }

    public Integer getNumBeds() {
        return numBeds;
    }

    public void setNumBeds(Integer numBeds) {
        this.numBeds = numBeds;
    }

    public Integer getNumBathrooms() {
        return numBathrooms;
    }

    public void setNumBathrooms(Integer numBathrooms) {
        this.numBathrooms = numBathrooms;
    }

    public Property.Type getType() {
        return type;
    }

    public void setType(Property.Type type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }
}
