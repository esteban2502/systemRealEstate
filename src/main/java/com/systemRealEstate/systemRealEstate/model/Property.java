package com.systemRealEstate.systemRealEstate.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

@Entity
@Table(name="properties")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "La propiedad debe tener un nombre")
    @Column(nullable = false)
    private String name;
    @NotBlank(message = "La propiedad debe tener una descripcion")
    @Column(nullable = false)
    private String description;
    @NotBlank(message = "Ingrese el valor de la propiedad")
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private BigDecimal latitude;
    @Column(nullable = false)
    private BigDecimal length;

    public Property() {
    }

    public Property(Long id, String name, String description, BigDecimal price, BigDecimal latitude, BigDecimal length) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.latitude = latitude;
        this.length = length;
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

    public @NotBlank(message = "Ingrese el valor de la propiedad") BigDecimal getPrice() {
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
