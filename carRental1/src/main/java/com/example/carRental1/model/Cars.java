package com.example.carRental1.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "cars")
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "car_Description")
    private String carDescription;
    @Column(name = "model")
    private String model;
    @Column(name = "brand")
    private String brand;
    @Column(name = "color")
    private String color;
    @Column(name = "purchase_Date")
    private String purchase_Date;

    @OneToMany(mappedBy = "cars")
    private List<Rentals> rentals;


    public Cars() {
    }

    public Cars(long id, String carDescription, String model, String brand, String color, String purchase_Date) {
        this.id = id;
        this.carDescription = carDescription;
        this.model = model;
        this.brand = brand;
        this.color = color;
        this.purchase_Date = purchase_Date;
    }

    public long getCarNumber() {
        return id;
    }

    public void setCarNumber(long id) {
        this.id = id;
    }

    public String getCarDescription() {
        return carDescription;
    }

    public void setCarDescription(String carDescription) {
        this.carDescription = carDescription;
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

    public String getPurchase_Date() {
        return purchase_Date;
    }

    public void setPurchase_Date(String purchase_Date) {
        this.purchase_Date = purchase_Date;
    }
}
