package com.sparta.week03_3.controller;

import com.sparta.week03_3.dto.RestaurantDto;
import com.sparta.week03_3.service.RestaurantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

// 추가사항 - 음식점 관리자 / 고객을 분리하여 관리 필요? (Admin / User)

@RestController
public class RestaurantController {
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    //1. 음식점 등록 및 조회
//    - 음식점 정보 입력받아 등록
//        1. 음식점 이름 (name)
//        2. 최소주문 가격 (minOrderPrice)
//            1. 허용값: 1,000원 ~ 100,000원 입력
//            2. 100 원 단위로만 입력 가능 (예. 2,220원 입력 시 에러발생. 2,300원은 입력 가능)
//            3. 허용값이 아니거나 100원 단위 입력이 아닌 경우 에러 발생시킴
//        3. 기본 배달비 (deliveryFee)
//            1. 허용값: 0원 ~ 10,000원 (예. 11,000원 입력 시 에러발생.)
//            2. 500 원 단위로만 입력 가능 (예. 2,200원 입력 시 에러발생. 2,500원 입력 가능)
    @PostMapping("/restaurant/register")
    public String restaurantsRegister(RestaurantDto restaurantDto) {
        return restaurantService.registerRestaurant(restaurantDto);
    }


//- 음식점 조회
//    - 등록된 모든 음식점 정보 조회 가능
//        1. 등록 시 입력한 음식점 정보 (name, minOrderPrice, deliveryFee)
//        2. DB 테이블 ID (id)
    @GetMapping("/restaurants")
    public void searchRestaurants() {
        // Response Body
//        [
//        {
//            id: 1
//            name: "쉐이크쉑 청담점",
//                    minOrderPrice: 5000,
//                deliveryFee: 2000
//        }
//]
    }
//2. 음식 등록 및 메뉴판 조회
//- 음식점 ID 및 음식 정보 입력받아 등록
//    1. 음식점 ID (restaurantId)
//        1. 음식점 DB 테이블 ID
//    2. 음식명 (name)
//        1. 같은 음식점 내에서는 음식 이름이 중복될 수 없음 (예. '자담치킨 강남점'에 '후라이드치킨' 이 이미 등록되어 있다면 중복하여 등록할 수 없지만, 다른 음식점인 '맘스터치 강남점'에는 '후라이드치킨' 을 등록 가능)
//    3. 가격 (price)
//        1. 허용값: 100원 ~ 1,000,000원
//        2. 100 원 단위로만 입력 가능 (예. 2,220원 입력 시 에러발생. 2,300원 입력 가능)
//        3. 허용값이 아니거나 100원 단위 입력이 아닌 경우 에러 발생시킴
    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void foodRegister(@PathVariable String restaurantId) {

    }

//- 메뉴판 조회
//    - 하나의 음식점에 등록된 모든 음식 정보 조회
//        1. 등록 시 입력한 음식 정보 (name, price)
//        2. DB 테이블 ID (id)
    @GetMapping("/restaurant/{restaurantId}/foods")
    public void searchFood(@PathVariable String restaurantId) {

    }
}
