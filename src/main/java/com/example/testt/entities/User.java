package com.example.testt.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String pwd;
    private String fName;
    private String Iname;
    @Enumerated(EnumType.STRING)
    private Role Role;

    @ManyToMany(mappedBy = "users")
    @JsonIgnore

    private Set<Project> projects;

    @OneToMany()

    private Set<Project> projects2;
}
