package com.systemRealEstate.systemRealEstate.controller.DTO;


import com.systemRealEstate.systemRealEstate.model.Property;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.util.List;

public class PropertyDTO {
    private Long id;
    private String name;
    private String description;
    private Property.Type type;
    private String maxGuest;
    private String numRooms;
    private String numBeds;
    private String numBathrooms;
    private BigDecimal price;
    private List<String> images;
    private BigDecimal latitude;
    private BigDecimal length;


    public PropertyDTO() {
    }

    public PropertyDTO(Long id, String name, String description, Property.Type type, String maxGuest, String numRooms, String numBeds, String numBathrooms, BigDecimal price, List<String> images, BigDecimal latitude, BigDecimal length) {
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
    }

    public String getMaxGuest() {
        return maxGuest;
    }

    public void setMaxGuest(String maxGuest) {
        this.maxGuest = maxGuest;
    }

    public String getNumRooms() {
        return numRooms;
    }

    public void setNumRooms(String numRooms) {
        this.numRooms = numRooms;
    }

    public String getNumBeds() {
        return numBeds;
    }

    public void setNumBeds(String numBeds) {
        this.numBeds = numBeds;
    }

    public String getNumBathrooms() {
        return numBathrooms;
    }

    public void setNumBathrooms(String numBathrooms) {
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
