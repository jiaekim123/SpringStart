package com.example.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity // order_detail에 자동으로 연결됨 (db의 snake_case 자동으로 변경)
@NoArgsConstructor
@AllArgsConstructor
//@ToString(exclude = {"user", "item"})
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private LocalDateTime orderAt;
    private LocalDateTime arrivalDate;
    private Integer quantity;
    private BigDecimal totalPrice;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;


//    // N:1 orderDetail의 입장에서 생각했을 때 user는 N:1임.
//    @ManyToOne
//    private User user; //userId로 하는 것이 아니라 user로 설정해주어야 함. (객체의 이름을 적어주면 알아서 userId를 찾아감)
//
//    @ManyToOne
//    private Item item;
}