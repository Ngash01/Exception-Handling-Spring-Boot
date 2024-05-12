package com.ngash.javatechie.ExceptionHandling.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Users_Table")
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Builder
public class User {

    @Id
    @SequenceGenerator(name = "users_sequence", allocationSize = 10, sequenceName = "users_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_sequence")
    private int userId;
    private String name;
    private String email;
    private String mobile;
    private String gender;
    private int age;
    private String nationality;

}

