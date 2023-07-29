package com.nhom1.java6.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "`USER`")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class User implements Serializable {
    @Id
    @Column(name = "MAKH")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maKH;
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_generator")
//    @SequenceGenerator(name = "user_id_generator", sequenceName = "USER_makh_seq", allocationSize = 1)

    @Column(name = "TENKH")
    private String tenKH;

    @Column(name = "DIACHI")
    private String diaChi;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "SDT")
    private String sdt;

    @Column(name = "`ADMIN`")
    private boolean admin;

    @Column(name = "PASSWORD")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    public interface LoginInfo {}
    public interface BasicInfo{}
}
