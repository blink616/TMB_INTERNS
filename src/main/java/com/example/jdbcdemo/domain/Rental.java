package com.example.jdbcdemo.domain;



public class Rental {

    private long id;
    private double amount;
    private long pickUpDate;
    private long returnDate;
    private Car car;
    private Customer customer;

    public Rental() {}

    public Rental(long id, double amount, long pickUpDate, long returnDate, Car car, Customer customer) {
        this.id = id;
        this.amount = amount;
        this.pickUpDate = pickUpDate;
        this.returnDate = returnDate;
        this.car = car;
        this.customer = customer;
    }

    public long getId() {
        return id;
    }

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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
