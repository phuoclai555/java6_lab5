package com.nhom1.java6.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Students")
public class Students {
    @Id
    @Column(name = "email", nullable = true, length = 50)
    private String email;

    @Column(name = "fullname", nullable = true, length = 50)
    private String fullname;

    @Column(name = "marks", nullable = true, precision = 0)
    private Double marks;

    @Column(name = "gender", nullable = true)
    private Boolean gender;

    @Column(name = "country", nullable = true, length = 2)
    private String country;
}
