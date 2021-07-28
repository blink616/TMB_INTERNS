package com.example.carRental1.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "customers")
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "First_name")
    private String First_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "SSN")
    private String SSN;
    @Column(name = "email")
    private String email;
    @Column(name = "mobile_phone")
    private String mobile_phone;
    @Column(name = "state")
    private String state;
    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy= "customers")
    private List<Rentals> rentals;

    public Customers() {
    }

    public Customers(long id, String first_name, String last_name, String SSN, String email, String mobile_phone, String state, String country) {
        this.id = id;
        this.First_name = first_name;
        this.last_name = last_name;
        this.SSN = SSN;
        this.email = email;
        this.mobile_phone = mobile_phone;
        this.state = state;
        this.country = country;
    }

    public long getCustomer_id() {
        return id;
    }

    public void setCustomer_id(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return First_name;
    }

    public void setFirst_name(String first_name) {
        this.First_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

