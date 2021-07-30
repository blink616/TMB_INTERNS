package com.covid.info.service;

import com.covid.info.domain.Car;
import com.covid.info.domain.Person;
import com.covid.info.domain.Rental;

import java.util.List;

public interface RentalService {
    void addPerson(Person person);
    List<Person> getAllPersons();
    List<Rental> getAllRentals();
    List<Car> getAllCars();
    Person getPersonById(int id);
    Person getPersonByRentalId(int rental_id);
    Car getCarByRentalId(int rental_id);
    Person getPersonByName(String first_name, String last_name);
    Person getPersonByPhone(String phone_no);
    void updatePersonName(String name, int id);
    void deletePersonById(int id);
    void deleteRentalById(int id);
    void deleteCarById(int id);
    Rental getRental(int id);
    void addRental(Rental rental);
    void addCar(Car car);
    void flush();
}
