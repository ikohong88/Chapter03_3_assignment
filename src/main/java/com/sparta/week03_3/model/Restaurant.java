package com.sparta.week03_3.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Restaurant {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer minOrderPrice;

    @Column(nullable = false)
    private Integer deliveryFee;

//    @OneToMany(mappedBy = "FOOD")
//    private List<Food> food = new ArrayList<>();

    public void updateRestaurant(String name, Integer minOrderPrice, Integer deliveryFee) {
        this.name = name;
        this.minOrderPrice = minOrderPrice;
        this.deliveryFee = deliveryFee;
    }


    public Restaurant(String name, Integer minOrderPrice, Integer deliveryFee) {
        this.name = name;
        this.minOrderPrice = minOrderPrice;
        this.deliveryFee = deliveryFee;
//        this.food = food;
    }
}
