package com.BookingSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BookingSystem.Entity.Driver;
@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer>{

}
