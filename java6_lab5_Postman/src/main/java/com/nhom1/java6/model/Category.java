package com.nhom1.java6.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "LOAI")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Category implements Serializable {
    @Id
    @Column(name = "MALOAI")
    private Integer maLoai;

    @Column(name = "TENLOAI")
    private String tenLoai;

}
