package com.ar.sgeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ar.sgeservice.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
