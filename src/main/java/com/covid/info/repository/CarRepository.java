package com.covid.info.repository;

import com.covid.info.domain.Car;
import com.covid.info.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    @Transactional(readOnly = true)
    @Query("FROM Car c where c.rental.id = :rental_id")
    Car getCarByRentalId(@Param("rental_id") int rental_id);
}
