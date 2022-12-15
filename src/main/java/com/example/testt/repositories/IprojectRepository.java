package com.example.testt.repositories;

import com.example.testt.entities.Project;
import com.example.testt.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IprojectRepository extends JpaRepository<Project,Integer> {
}
