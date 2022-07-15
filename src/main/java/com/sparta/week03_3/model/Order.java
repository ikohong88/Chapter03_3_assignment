package com.sparta.week03_3.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
@Table(name="OrderFood")
public class Order extends Timestamped{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long restaurantId;

    @Column(nullable = false)
    private String foods;

    @Column(nullable = false)
    private Integer quantity;

    public Order(Long restaurantId, Long userId, String foods, Integer quantity) {
        this.restaurantId = restaurantId;
        this.userId = userId;
        this.foods = foods;
        this.quantity = quantity;
    }
}
