package com.sparta.week03_3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
//3. 주문 요청하기 및 주문 조회
//- 주문 요청 시 배달 음식점 및 음식 정보 입력받음
//    1. 음식점 ID (restaurantId)
//    2. 음식 주문 정보 (foods)
//        1. 음식 ID (id)
//        2. 음식을 주문할 수량 (quantity)
//            1. 허용값: 1 ~ 100
//        2. 허용값이 아니면 에러 발생시킴
//- 주문 요청에 대한 응답으로 다음 정보를 포함시킴
//    1. 주문 음식점 이름 (restaurantName)
//    2. 주문 음식 정보 (foods)
//        - 주문 음식명 (name)
//        - 주문 수량 (quantity)
//        - 주문 음식의 가격 (price)
//            - 계산방법
//                - 주문 음식 1개의 가격 * 주문 수량
//    3. 배달비 (deliveryFee)
//        - 주문 음식점의 기본 배달비
//    4. 최종 결제 금액 (totalPrice)
//        - 계산방법
//            - 주문 음식 가격들의 총 합 + 배달비
//        - "주문 음식 가격들의 총 합" 이 주문 음식점의 "최소주문 가격" 을 넘지 않을 시 에러 발생시킴
    @PostMapping("/order/request")
    public void orderRequest() {
//        {
//            restaurantName: "쉐이크쉑 청담점",
//                    foods: [
//            {
//                name: "쉑버거 더블",
//                        quantity: 1,
//                    price: 10900
//            },
//            {
//                name: "치즈 감자튀김",
//                        quantity: 2,
//                    price: 9800
//            },
//            {
//                name: "쉐이크",
//                        quantity: 3,
//                    price: 17700
//            }
//  ],
//            deliveryFee: 2000,
//                    totalPrice: 40400
//        }
    }
//- 주문 조회
//    - 그동안 성공한 모든 주문 요청을 조회 가능
    @GetMapping("/orders")
    public void searchOrders() {

    }
}
