package com.example.car_rental.model;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="customer_id")
    private long id;

    @Column(name="firstname")
    private String firstname;

    @Column(name= "lastname")
    private String lastname;

    @Column(name="country")
    private String country;

    @Column(name="state")
    private String state;

    @Column(name="contact")
    private String contact;

    @Column(name = "email")
    private String email;

    @Column (name = "ssn")
    private  String ssn;

//    @Access(AccessType.FIELD)
//    @ManyToOne
//    @JoinColumn(name = "reservation_number", nullable = false)
//    private Rentals rentals;


    public Customer(String firstname, String lastname, String country, String state, String contact, String email, String ssn) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.country = country;
        this.state = state;
        this.contact = contact;
        this.email = email;
        this.ssn = ssn;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
}
