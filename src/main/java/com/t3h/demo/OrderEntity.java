package com.t3h.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

import java.time.LocalDate;

@Entity // đánh dấu ánh xạ table
@Table(name = "orders") // trỏ bảng trong DB
@Data
public class OrderEntity {
    @Id // đánh dấu field là PK
    private Long orderNumber;
    private LocalDate orderDate;
    private LocalDate requiredDate;
    private LocalDate shippedDate;
    private String status;
    private String comments;
    private Long customerNumber;
//
    @Transient // bỏ qua filed án xạ với bảng
    private String customerName;
//    @Transient
//    private String phone;
}
