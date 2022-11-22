package com.example.spring.boot.dbtojson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.boot.dbtojson.data.UserDTO;

@Repository
public interface UserRepository extends JpaRepository<UserDTO, String>{

}
