package com.example.car_rental.controller;

import com.example.car_rental.exceptions.ResourceNotFoundException;
import com.example.car_rental.model.Car;
import com.example.car_rental.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.desktop.SystemEventListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    //get Cars
    @GetMapping("cars")
    public List<Car> getAllCars(){
        return this.carRepository.findAll();
    }

    //get Car by ID
    @GetMapping("cars/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable(value = "id") Long carId) throws ResourceNotFoundException {
        Car car = carRepository.findById(carId).orElseThrow(()-> new ResourceNotFoundException("Car not found"));
        return ResponseEntity.ok().body(car);
    }

    @PostMapping("cars")
    public Car createCar(@RequestBody Car car){
        System.out.println(car);
        return this.carRepository.save(car);
    }

    @PutMapping ("cars/{id}")
    public ResponseEntity<Car> updateCar (@PathVariable(value = "id") Long carId,@RequestBody Car carDetails) throws ResourceNotFoundException{
        Car car = carRepository.findById(carId).orElseThrow(()->new ResourceNotFoundException("Car not found"));
        car.setCar_description(carDetails.getCar_description());
        car.setBrand(carDetails.getBrand());
        car.setColor(carDetails.getColor());
        car.setModel(carDetails.getModel());
        car.setPurchase_date(carDetails.getPurchase_date());

        return ResponseEntity.ok(this.carRepository.save(car));
    }

    @DeleteMapping("cars/{id}")
    public Map<String,Boolean> deleteEmployees(@PathVariable(value = "id") Long carId) throws ResourceNotFoundException{
        Car car = carRepository.findById(carId).orElseThrow(()->new ResourceNotFoundException("Car not found"));
        this.carRepository.delete(car);

        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return  response;
    }
}
