package com.example.testt.repositories;

import com.example.testt.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IuserRepository extends JpaRepository<User,Integer> {
    List<User> findByFNameAndIname(String fName, String iName);


}
