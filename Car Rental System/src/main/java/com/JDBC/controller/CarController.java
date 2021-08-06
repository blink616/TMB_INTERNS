package com.JDBC.controller;

import com.JDBC.exception.ResourceNotFoundException;
import com.JDBC.model.Car;
import com.JDBC.model.Rental;
import com.JDBC.repository.CarRepository;
import com.JDBC.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class CarController {

    private CarRepository carRepository;
    private RentalRepository rentalRepository;

//    @GetMapping("cars")
//	public List<Car> getAllCars() {
//		return this.carRepository.findAll();
//	}
//
//	@GetMapping("cars/{id}")
//	public ResponseEntity<Car> getCar(@PathVariable Long id) throws ResourceNotFoundException {
//		Car car = carRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Car not found for this id :: " + id));
//		return ResponseEntity.ok(car);
//	}
//
//	@PostMapping("cars")
//    public Car createCar(@RequestBody Car car) {
//        return this.carRepository.save(car);
//    }
//
//    @PutMapping("cars/{id}")
//    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car carDetails) throws ResourceNotFoundException {
//        Car car = carRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Car not found for this id :: " + id));
//
//        car.setDesc(carDetails.getDesc());
//        car.setModel(carDetails.getModel());
//        car.setBrand(carDetails.getBrand());
//        car.setColor(carDetails.getColor());
//        car.setPassengerCount(carDetails.getPassengerCount());
//
//        return ResponseEntity.ok(this.carRepository.save(car));
//    }
//
//    @DeleteMapping("cars/{id}")
//    public Map<String, Boolean> deleteCar(@PathVariable Long id) throws ResourceNotFoundException {
//        Car car = carRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Car not found for this id :: " + id));
//
//        this.carRepository.delete(car);
//
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//
//        return response;
//    }
//
//    @GetMapping("cars/{id}/rentals")
//    public List<Rental> getCarRentals(@PathVariable Long id) throws ResourceNotFoundException {
//        return this.rentalRepository.findByCarId(id);
//    }
}
