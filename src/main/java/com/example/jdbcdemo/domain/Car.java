package com.example.jdbcdemo.domain;


public class Car {

    private long id;

    private String description;

    private String model;

    private String brand;

    private String color;

    private int passengerCount;

    public Car() {}

    public Car(long id, String description, String model, String brand, String color, int passengerCount) {
        this.id = id;
        this.description = description;
        this.model = model;
        this.brand = brand;
        this.color = color;
        this.passengerCount = passengerCount;
    }

    public long getId() {
        return id;
    }

    public String getDesc() {
        return description;
    }

    public void setDesc(String desc) {
        this.description = desc;
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

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }
}
