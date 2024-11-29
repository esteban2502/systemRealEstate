package com.systemRealEstate.systemRealEstate.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="properties")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "La propiedad debe tener un nombre")
    @Column(nullable = false, length = 100)
    private String name;
    @NotBlank(message = "La propiedad debe tener una descripcion")
    @Column(nullable = false,length = 255)
    private String description;
    @Enumerated(EnumType.STRING)
    @NotNull
    private Type type;
    @NotBlank(message = "Ingrese el numero maximo de huespedes")
    @Column(length = 4,nullable = false)
    private String maxGuest;
    @NotBlank(message = "Ingrese el numero de habitaciones")
    @Column(length = 4,nullable = false)
    private String numRooms;
    @NotBlank(message = "Ingrese el numero de camas")
    @Column(length = 4, nullable = false)
    private String numBeds;
    @NotBlank(message = "Ingrese el numero de baños")
    @Column(length = 4,nullable = false)
    private String numBathrooms;
    @NotNull(message = "Ingrese el valor de la propiedad")
    @Column(nullable = false)
    private BigDecimal price;
    private List<String> images;
    @Column(nullable = false)
    private BigDecimal latitude;
    @Column(nullable = false)
    private BigDecimal length;


    public enum Type{
        Apartamento,
        Casa,
        Estudio,
        Habitacion,
        Chalet,
        Vivienda,
        Mansión,
        CasaArbol
    }



    public Property() {
    }

    public Property(Long id, String name, String description, Type type, String maxGuest, String numRooms, String numBeds, String numBathrooms, BigDecimal price, List<String> images, BigDecimal latitude, BigDecimal length) {
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


    public @NotBlank(message = "Ingrese el numero maximo de huespedes") String getMaxGuest() {
        return maxGuest;
    }

    public void setMaxGuest(@NotBlank(message = "Ingrese el numero maximo de huespedes") String maxGuest) {
        this.maxGuest = maxGuest;
    }

    public @NotBlank(message = "Ingrese el numero de habitaciones") String getNumRooms() {
        return numRooms;
    }

    public void setNumRooms(@NotBlank(message = "Ingrese el numero de habitaciones") String numRooms) {
        this.numRooms = numRooms;
    }

    public @NotBlank(message = "Ingrese el numero de camas") String getNumBeds() {
        return numBeds;
    }

    public void setNumBeds(@NotBlank(message = "Ingrese el numero de camas") String numBeds) {
        this.numBeds = numBeds;
    }

    public @NotBlank(message = "Ingrese el numero de baños") String getNumBathrooms() {
        return numBathrooms;
    }

    public void setNumBathrooms(@NotBlank(message = "Ingrese el numero de baños") String numBathrooms) {
        this.numBathrooms = numBathrooms;
    }

    public @NotNull Type getType() {
        return type;
    }

    public void setType(@NotNull Type type) {
        this.type = type;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "La propiedad debe tener un nombre") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "La propiedad debe tener un nombre") String name) {
        this.name = name;
    }

    public @NotBlank(message = "La propiedad debe tener una descripcion") String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank(message = "La propiedad debe tener una descripcion") String description) {
        this.description = description;
    }

    public @NotNull(message = "Ingrese el valor de la propiedad") BigDecimal getPrice() {
        return price;
    }

    public void setPrice(@NotBlank(message = "Ingrese el valor de la propiedad") BigDecimal price) {
        this.price = price;
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
