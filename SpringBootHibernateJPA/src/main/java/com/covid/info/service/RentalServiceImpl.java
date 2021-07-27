package com.covid.info.service;

import com.covid.info.domain.Car;
import com.covid.info.domain.Person;
import com.covid.info.domain.Rental;
import com.covid.info.repository.CarRepository;
import com.covid.info.repository.PersonRepository;
import com.covid.info.repository.RentalRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalServiceImpl implements RentalService {

//    PersonRepository personRepository;
    @Autowired
    PersonRepository personRepository;

    @Autowired
    CarRepository carRepository;

    @Autowired
    RentalRepository rentalRepository;

//    @Autowired
//    public PersonServiceImpl(PersonRepository personRepository) {
//        this.personRepository = personRepository;
//    }

    @Override
    public void addPerson(Person person) {

        int id = getRandomNumber(1,999999999);
        while (personRepository.existsById(id)){
            id = getRandomNumber(1,999999999);
        }
        person.setId(id);
        personRepository.save(person);
    }

    @Override
    public List<Person> getAllPersons() {
       List<Person> peopleList = personRepository.findAll();
       return peopleList;
    }
    @Override
    public List<Rental> getAllRentals() {
       return rentalRepository.findAll();
    }
    @Override
    public List<Car> getAllCars() {
       return carRepository.findAll();
    }

    @Override
    public Person getPersonById(int id) {
        return personRepository.getOne(id);
    }
    @Override
    public Person getPersonByRentalId(int rental_id) {
        Rental r = rentalRepository.getOne(rental_id);
        return personRepository.getPersonByRentalId(rental_id);
    }
    @Override
    public Car getCarByRentalId(int rental_id) {
        return carRepository.getCarByRentalId(rental_id);
    }

    @Override
    public void updatePersonName(String name, int id) {
        personRepository.setPersonName(name, id);
    }

    @Override
    public void deletePersonById(int id) {
        personRepository.deleteById(id);
    }
    @Override
    public void deleteRentalById(int id) {
        rentalRepository.deleteById(id);
    }
    public void deleteCarById(int id) {
        carRepository.deleteById(id);
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    @Override
    public Rental getRental(int id) {
        return rentalRepository.getOne(id);
    }

    @Override
    public void addRental(Rental rental) {
        int id = getRandomNumber(1,999999999);
        while (rentalRepository.existsById(id)){
            id = getRandomNumber(1,999999999);
        }
        rental.setId(id);
        rentalRepository.save(rental);
    }
    @Override
    public void addCar(Car car) {
        int id = getRandomNumber(1,999999999);
        while (carRepository.existsById(id)){
            id = getRandomNumber(1,999999999);
        }
        car.setId(id);
        carRepository.save(car);
    }

    @Override
    public Person getPersonByName(String first_name, String last_name) {
        return personRepository.getPersonByName(first_name,last_name);
    }
    @Override
    public void flush(){
        rentalRepository.flush();
        personRepository.flush();
        carRepository.flush();
    }
}
