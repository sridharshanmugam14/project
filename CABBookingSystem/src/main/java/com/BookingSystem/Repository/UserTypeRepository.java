package com.BookingSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BookingSystem.Entity.UserType;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Integer> {

}
