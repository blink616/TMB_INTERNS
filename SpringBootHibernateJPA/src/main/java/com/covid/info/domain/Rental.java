package com.covid.info.domain;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="RENTAL")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    @OneToMany(mappedBy="rental")
    private List<Car> cars;
    @OneToMany(mappedBy="rental")
    private List<Person> persons;


    //    @OneToMany(targetEntity=Person.class, mappedBy="rental", fetch=FetchType.EAGER)
//    @JoinColumn(name = "id", referencedColumnName = "rental_id")
//    private List<Person> persons;
//    @OneToMany(targetEntity=Car.class, mappedBy="rental", fetch=FetchType.EAGER)
//    @JoinColumn(name = "id", referencedColumnName = "rental_id")
//    private List<Car> cars;


    @Column(name="pickup_date")
    private String pickup_date;
    @Column(name="return_date")
    private String return_date;
    @Column(name="amount")
    private int amount;

    @Id
    public int getId() {
        return id;
    }
    @Id
    public void setId(int id) {
        this.id = id;
    }


    public String getPickup_date() {
        return pickup_date;
    }

    public void setPickup_date(String pickup_date) {
        this.pickup_date = pickup_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    public int getAmount() {
        return amount;
    }


    public void setAmount(int amount) {
        this.amount = amount;
    }
    public void addPerson(Person person) {
        this.persons.add(person);
    }
}
