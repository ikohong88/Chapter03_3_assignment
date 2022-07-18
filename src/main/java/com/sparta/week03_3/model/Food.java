package com.sparta.week03_3.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Data
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Food {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private String imageURL;

    @ManyToOne(targetEntity = Food.class)
    private Long restaurantId;

    // 문제 해결 필요 - Long이 아닌 Restaurant으로 적용해야됨 - Service쪽에 Long으로 받고 있어서 다른 방법이 있는지 확인 필요
    public Food(Long restaurantId, String name, Integer price, String imageURL) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.price = price;
        this.imageURL = imageURL;
    }
}
