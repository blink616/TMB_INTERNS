package com.example.car_rental.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "vin")
    private long id;

    @Column (name = "car_description")
    private String car_description;

    @Column (name = "model")
    private String model;

    @Column (name = "brand")
    private String brand;

    @Column (name = "color")
    private String color;

    @Column (name = "purchase_date")
    private String purchase_date;

//    @Access(AccessType.FIELD)
//    @ManyToOne
//    @JoinColumn(name = "reservation_number", nullable = false)
//    private Rentals rentals;

    public Car(){}

    public Car( String car_description, String model, String brand, String color, String purchase_date) {
        this.car_description = car_description;
        this.model = model;
        this.brand = brand;
        this.color = color;
        this.purchase_date = purchase_date;
    }


    public String getCar_description() {
        return car_description;
    }

    public void setCar_description(String car_description) {
        this.car_description = car_description;
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

    public String getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(String purchase_date) {
        this.purchase_date = purchase_date;
    }
}
