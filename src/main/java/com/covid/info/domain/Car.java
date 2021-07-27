package com.covid.info.domain;

import javax.persistence.*;

@Entity
@Table(name="CAR")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    @Column(name="model")
    private String model;
    @Column(name="brand")
    private String brand;
    @Column(name="color")
    private String color;
    @Column(name="date_of_purchase")
    private String date_of_purchase;
    @Column(name="description")
    private String description;

    @Access(AccessType.FIELD)
    @ManyToOne
    @JoinColumn(name="rental_id", nullable=false)
    private Rental rental;

    @Id
    public int getId() {
        return id;
    }
    @Id
    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDate_of_purchase() {
        return date_of_purchase;
    }

    public void setDate_of_purchase(String date_of_purchase) {
        this.date_of_purchase = date_of_purchase;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Rental getRental() {
        return rental;
    }
    public void setRental(Rental rental) {
        this.rental = rental;
    }

}
