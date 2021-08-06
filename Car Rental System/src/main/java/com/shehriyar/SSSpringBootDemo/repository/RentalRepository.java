package com.shehriyar.SSSpringBootDemo.repository;

import com.shehriyar.SSSpringBootDemo.model.Car;
import com.shehriyar.SSSpringBootDemo.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
    List<Rental> findByCustomerId(Long customerId);
    List<Rental> findByCarId(Long car);
}
