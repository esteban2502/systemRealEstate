package com.systemRealEstate.systemRealEstate.controller.DTO;


import java.math.BigDecimal;
import java.util.List;

public class PropertyDTO {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private List<String> images;
    private BigDecimal latitude;
    private BigDecimal length;


    public PropertyDTO() {
    }

    public PropertyDTO(Long id, String name, String description, BigDecimal price, List<String> images, BigDecimal latitude, BigDecimal length) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.images = images;
        this.latitude = latitude;
        this.length = length;
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
