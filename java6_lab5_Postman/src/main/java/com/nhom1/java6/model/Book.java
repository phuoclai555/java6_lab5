package com.nhom1.java6.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "SACH")
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class Book implements Serializable {
    @Id
    @Column(name = "MASACH")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_id_generator")
    @SequenceGenerator(name = "book_id_generator", sequenceName = "sach_masach_seq", allocationSize = 1)
    private Integer maSach;

    @ManyToOne()
    @JoinColumn(name = "MALOAI")
    private Category loai;

    @Column(name = "TENSACH")
    private String tenSach;

    @Column(name = "TACGIA")
    private String tacGia;

    @Column(name = "NXB")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date nxb;

    @Column(name = "GIA")
    private Double gia;

    @Column(name = "IMG")
    private String img;

    @Column(name = "SOLUONG")
    private Integer soLuong;

    @OneToMany(mappedBy = "book")
    private List<OrderDetails> orderDetails;

    @Transient
    private int soLuongMua;
}
