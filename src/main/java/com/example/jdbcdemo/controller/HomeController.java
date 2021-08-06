package com.example.jdbcdemo.controller;


import com.example.jdbcdemo.DBConnection;
import com.example.jdbcdemo.domain.Car;
import com.example.jdbcdemo.domain.Customer;
import com.example.jdbcdemo.domain.Rental;
import com.example.jdbcdemo.repository.CarRepository;
import com.example.jdbcdemo.repository.CustomerRepository;
import com.example.jdbcdemo.repository.RentalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;


@RestController
@RequestMapping("/api/")
public class HomeController {
    CarRepository carRepository = new CarRepository();
    CustomerRepository customerRepository = new CustomerRepository();
    RentalRepository rentalRepository = new RentalRepository();
    @GetMapping("car/{id}")
    public ResponseEntity car(@PathVariable Long id){
        Car car = carRepository.getById(id);
        return ResponseEntity.ok(car);
    }
    @GetMapping("cars")
    public ResponseEntity cars(){
        ArrayList<Car> cars = carRepository.getAll();
        return ResponseEntity.ok(cars);
    }
    @DeleteMapping("deletecar/{id}")
    public boolean deleteCar(@PathVariable Long id){
        return carRepository.deleteById(id);
    }
    @PostMapping("savecar")
    public boolean saveCar(@RequestBody Car car){
        return carRepository.save(car.getDesc(),car.getModel(),car.getBrand(),car.getColor(),car.getPassengerCount());
    }
    @PutMapping("updatecar/{id}")
    public boolean updateCar(@PathVariable Long id,@RequestBody Car car){
        return carRepository.update(id,car.getDesc(),car.getModel(),car.getBrand(),car.getColor(),car.getPassengerCount());
    }


    @GetMapping("customer/{id}")
    public ResponseEntity customer(@PathVariable Long id){
        Customer customer = customerRepository.getById(id);
        return ResponseEntity.ok(customer);
    }
    @GetMapping("customers")
    public ResponseEntity customers(){
        ArrayList<Customer> customers = customerRepository.getAll();
        return ResponseEntity.ok(customers);
    }
    @DeleteMapping("deletecustomer/{id}")
    public boolean deleteCustomer(@PathVariable Long id){
        return customerRepository.deleteById(id);
    }
    @PostMapping("savecustomer")
    public boolean saveCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer.getFirstName(),customer.getLastName(),customer.getEmail(),customer.getPhoneNumber());
    }
    @PutMapping("updatecustomer/{id}")
    public boolean updateCustomer(@PathVariable Long id,@RequestBody Customer customer){
        return customerRepository.update(id,customer.getFirstName(),customer.getLastName(),customer.getEmail(),customer.getPhoneNumber());
    }

    @GetMapping("rental/{id}")
    public ResponseEntity rental(@PathVariable Long id){
        Rental rental = rentalRepository.getById(id);
        return ResponseEntity.ok(rental);
    }
    @GetMapping("rentals")
    public ResponseEntity rentals(){
        ArrayList<Rental> rentals = rentalRepository.getAll();
        return ResponseEntity.ok(rentals);
    }
    @DeleteMapping("deleterental/{id}")
    public boolean deleteRental(@PathVariable Long id){
        return rentalRepository.deleteById(id);
    }
    @PostMapping("saverental/{car_id}/{customer_id}")
    public boolean saveRental(@RequestBody Rental rental,@PathVariable Long car_id,@PathVariable Long customer_id){
        return rentalRepository.save(rental.getAmount(),rental.getPickUpDate(),rental.getReturnDate(),car_id,customer_id);
    }
    @PutMapping("updaterental/{id}")
    public boolean updateRental(@PathVariable Long id,@RequestBody Rental rental){
        return rentalRepository.update(id,rental.getAmount(),rental.getPickUpDate(),rental.getReturnDate());
    }
}

