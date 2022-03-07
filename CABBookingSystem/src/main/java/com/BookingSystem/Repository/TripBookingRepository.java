package com.BookingSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BookingSystem.Entity.TripBooking;

@Repository
public interface TripBookingRepository extends JpaRepository<TripBooking, Integer>{

}
