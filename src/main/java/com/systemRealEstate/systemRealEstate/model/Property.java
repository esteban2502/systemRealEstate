package com.systemRealEstate.systemRealEstate.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @NotNull(message = "Ingrese el numero maximo de huespedes")
    @Column(length = 4,nullable = false)
    private Integer maxGuest;
    @NotNull(message = "Ingrese el numero de habitaciones")
    @Column(length = 4,nullable = false)
    private Integer numRooms;
    @NotNull(message = "Ingrese el numero de camas")
    @Column(length = 4, nullable = false)
    private Integer numBeds;
    @NotNull(message = "Ingrese el numero de baños")
    @Column(length = 4,nullable = false)
    private Integer numBathrooms;
    @NotNull(message = "Ingrese el valor de la propiedad")
    @Column(nullable = false)
    private BigDecimal price;
    private List<String> images;
    @Column(nullable = false)
    private BigDecimal latitude;
    @Column(nullable = false)
    private BigDecimal length;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;



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

    public Property(Long id, String name, String description, Type type, Integer maxGuest, Integer numRooms, Integer numBeds, Integer numBathrooms, BigDecimal price, List<String> images, BigDecimal latitude, BigDecimal length, UserEntity user) {
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

    public @NotNull(message = "Ingrese el numero maximo de huespedes") Integer getMaxGuest() {
        return maxGuest;
    }

    public void setMaxGuest(@NotNull(message = "Ingrese el numero maximo de huespedes") Integer maxGuest) {
        this.maxGuest = maxGuest;
    }

    public @NotNull(message = "Ingrese el numero de habitaciones") Integer getNumRooms() {
        return numRooms;
    }

    public void setNumRooms(@NotNull(message = "Ingrese el numero de habitaciones") Integer numRooms) {
        this.numRooms = numRooms;
    }

    public @NotNull(message = "Ingrese el numero de camas") Integer getNumBeds() {
        return numBeds;
    }

    public void setNumBeds(@NotNull(message = "Ingrese el numero de camas") Integer numBeds) {
        this.numBeds = numBeds;
    }

    public @NotNull(message = "Ingrese el numero de baños") Integer getNumBathrooms() {
        return numBathrooms;
    }

    public void setNumBathrooms(@NotNull(message = "Ingrese el numero de baños") Integer numBathrooms) {
        this.numBathrooms = numBathrooms;
    }

    public Type getType() {
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
