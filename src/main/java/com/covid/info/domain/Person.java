package com.covid.info.domain;

import javax.persistence.*;

@Entity
@Table(name="PERSON")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

//    @Column(name="rental_id")
//    private int rental_id;
    @Column(name="first_name")
    private String first_name;
    @Column(name="last_name")
    private String last_name;
    @Column(name="address")
    private String address;
    @Column(name="phone_no")
    private String phone_no;
    @Column(name="email")
    private String email;
    @Column(name="cnic")
    private String cnic;
    @Access(AccessType.FIELD)
    @ManyToOne
    @JoinColumn(name="rental_id", nullable=false)
    private Rental rental;

//    public Person(String name) {
//        this.name = name;
//    }

    public Person() {
    }


    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    @Id
    public void setId(int id) {
        this.id = id;
    }

    @Id
    public int getId() {
        return id;
    }
    public Rental getRental() {
        return rental;
    }
    public void setRental(Rental rental) {
        this.rental = rental;
    }

}