package com.dem5.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table

public class Patients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    @Column(nullable = false)
    private String patientName;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private String address;

}
