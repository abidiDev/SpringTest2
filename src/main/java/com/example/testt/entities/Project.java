package com.example.testt.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@ToString
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Id ;
    String title ;
    String description ;

    @ManyToMany()
    @JsonIgnore

    private Set<User> users;


    @OneToMany(mappedBy = "project")

    private Set<Sprint> sprints;
}
