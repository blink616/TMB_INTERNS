package com.example.carRental1.model;

import javax.persistence.*;

@Entity
@Table(name= "rentals")
public class Rentals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "amount")
    private String amount;
    @Column(name = "pick_up_date")
    private String pick_up_date;
    @Column(name = "return_date")
    private String return_date;

    @ManyToOne
    private Customers customers;

    @ManyToOne
    private Cars cars;

    public Rentals() {
    }

    public Rentals(long id, String amount, String pick_up_date, String return_date) {
        this.id = id;
        this.amount = amount;
        this.pick_up_date = pick_up_date;
        this.return_date = return_date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPick_up_date() {
        return pick_up_date;
    }

    public void setPick_up_date(String pick_up_date) {
        this.pick_up_date = pick_up_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }
}
