package com.property.sales.app.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name;
    private String gender;
    private String dob;
    private int age;
    @Column(nullable = false)
    private String aadharNumber;
    @Column(nullable = false)
    private String panNumber;
    @Column(nullable = false)
    private String phoneNumber;
    private String emailAddress;
    private String address;
    @Column(nullable = false)
    private String panPath;
    @Column(nullable = false)
    private String aadharPath;
}
