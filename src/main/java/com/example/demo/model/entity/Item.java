package com.example.demo.model.entity;

import com.example.demo.model.enumclass.ItemStatus;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"orderDetailList", "partner"})
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private ItemStatus status; // 등록 , 해지, 검수중(등록대기중)
    private String name;
    private String title;
    private String content;
    private BigDecimal price;
    private String brandName;
    private LocalDateTime registeredAt;
    private LocalDateTime unregisteredAt;
    @CreatedDate
    private LocalDateTime createdAt;
    @CreatedBy
    private String createdBy;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    @LastModifiedBy
    private String updatedBy;

//    private Long partnerId;
    // Item N : 1  Partner
    @ManyToOne
    private Partner partner;

    //Item 1:N orderDetail
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<OrderDetail> orderDetailList;
//    // item : orderDetail / 1:N
//    // FetchType: LAZY = 지연 로딩 / EAGER = 즉시 로딩
//    // LAZY는 orderDetailList 변수에 대해 get메소드를 호출하지 않는 이상 연관관계가 설정된 테이블에 대해 select하지 않겠다
//    // EAGER는 즉시 연관관계가 설정된 모든 테이블에 대해 조회를 하겠다
//    // 즉, EAGER는 데이터 양이 많은 것에서 사용할 경우 성능저하나 가져오지 못할 위험이 있음.
//    // (1:1 경우 EAGER추천, 1:N등의 경우는 LAZY를 추천)
//
//    // LAZY = select * from item where id = ?
//
//    // EAGER =
//    // item_id = order_detail.item.id 조인
//    // user_id = order_detail.user_id 조인
//    // where item.id = ?
//
//    // Hibernate: select item0_.id as id1_0_0_, item0_.content as content2_0_0_, item0_.name as name3_0_0_, item0_.price as price4_0_0_, orderdetai1_.item_id as item_id3_1_1_, orderdetai1_.id as id1_1_1_, orderdetai1_.id as id1_1_2_, orderdetai1_.item_id as item_id3_1_2_, orderdetai1_.order_at as order_at2_1_2_, orderdetai1_.user_id as user_id4_1_2_, user2_.id as id1_2_3_, user2_.account as account2_2_3_, user2_.created_at as created_3_2_3_, user2_.created_by as created_4_2_3_, user2_.email as email5_2_3_, user2_.phone_number as phone_nu6_2_3_, user2_.updated_at as updated_7_2_3_, user2_.updated_by as updated_8_2_3_ from item item0_ left outer join order_detail orderdetai1_ on item0_.id=orderdetai1_.item_id left outer join user user2_ on orderdetai1_.user_id=user2_.id where item0_.id=?
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
//    private List<OrderDetail> orderDetailList;

}
