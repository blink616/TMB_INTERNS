package com.covid.info.repository;

import com.covid.info.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    @Transactional
    @Modifying
    @Query("update Person p set p.last_name = :name where p.id = :id")
    void setPersonName(@Param("name") String name, @Param("id") int id);

    @Transactional(readOnly = true)
    @Query("FROM Person p where p.first_name = :first_name and  p.last_name = :last_name")
    Person getPersonByName(@Param("first_name") String first_name, @Param("last_name") String last_name);

    @Transactional(readOnly = true)
    @Query("FROM Person p where p.phone_no = :phone_no")
    Person getPersonByPhone(@Param("phone_no") String phone_no);
    @Transactional(readOnly = true)
    @Query("FROM Person p where p.address = :address")
    Person getPersonByAddress(@Param("address") String address);
    @Transactional(readOnly = true)
    @Query("FROM Person p where p.cnic = :cnic")
    Person getPersonByCnic(@Param("cnic") String cnic);
    @Transactional(readOnly = true)
    @Query("FROM Person p where p.email = :email")
    Person getPersonByEmail(@Param("email") String email);

    @Transactional(readOnly = true)
    @Query("FROM Person p where p.rental.id = :rental_id")
    Person getPersonByRentalId(@Param("rental_id") int rental_id);

}
