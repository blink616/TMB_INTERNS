package com.shehriyar.SSSpringBootDemo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Rental {

    private long id, pickUpDate, returnDate, carId, customerId;
    private double amount;

    public Rental() {}

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(long pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public long getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(long returnDate) {
        this.returnDate = returnDate;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public void setRentalFromResultSet(ResultSet db_row) {
        try {
            this.id = db_row.getLong("id");
            this.amount = db_row.getDouble("amount");
            this.pickUpDate = db_row.getLong("pick_up_date");
            this.returnDate = db_row.getLong("return_date");
            this.carId = db_row.getLong("car_id");
            this.customerId = db_row.getLong("customer_id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
