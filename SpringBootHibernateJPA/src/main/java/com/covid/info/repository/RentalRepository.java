package com.covid.info.repository;

import com.covid.info.domain.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Integer> {
    @Transactional
    @Modifying
    @Query("update Rental r set r.amount = :amount where r.id = :id")
    void setRentalAmount(@Param("amount") String name, @Param("id") int id);

}
