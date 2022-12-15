package com.example.testt.repositories;

import com.example.testt.entities.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IsprintRepository extends JpaRepository<Sprint,Integer> {
}
