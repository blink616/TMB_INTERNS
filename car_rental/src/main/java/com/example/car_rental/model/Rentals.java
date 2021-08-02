package com.example.car_rental.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "rentals")
public class Rentals {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "reservation_number")
    private long id;

    @Column (name = "amount")
    private int amount;

    @Column (name = "pickup_date")
    private Date pickup_date;

    @Column (name = "return_date")
    private Date return_date;

//    @OneToMany(mappedBy="rentals")
//    private List<Car> cars;
//    @OneToMany(mappedBy="rentals")
//    private List<Customer> customers;

    public Rentals(){
    }

    public Rentals( int amount, Date pickup_date, Date return_date) {
        this.amount = amount;
        this.pickup_date = pickup_date;
        this.return_date = return_date;
    }


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getPickup_date() {
        return pickup_date;
    }

    public void setPickup_date(Date pickup_date) {
        this.pickup_date = pickup_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }
}
