package com.shehriyar.SSSpringBootDemo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Car {

    private long id;
    private String desc, model, brand, color;
    private int passengerCount;

    public Car() {}

    public long getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public void setCarFromResultSet(ResultSet db_row) {
        try {
            this.id = db_row.getLong("id");
            this.brand = db_row.getString("brand");
            this.color = db_row.getString("color");
            this.desc = db_row.getString("description");
            this.model = db_row.getString("model");
            this.passengerCount = db_row.getInt("passenger_count");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
