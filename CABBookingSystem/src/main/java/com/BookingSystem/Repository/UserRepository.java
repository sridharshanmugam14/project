package com.BookingSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BookingSystem.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
