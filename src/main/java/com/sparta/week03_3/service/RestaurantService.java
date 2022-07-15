package com.sparta.week03_3.service;

import com.sparta.week03_3.dto.RestaurantDto;
import com.sparta.week03_3.model.Restaurant;
import com.sparta.week03_3.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public String registerRestaurant(RestaurantDto requestDto) {
        String name = requestDto.getName();

        // 최소주문 가격 (minOrderPrice)
        Integer minOrderPrice = requestDto.getMinOrderPrice();

        // 기본 배달비 (deliveryFee)
        Integer deliveryFee = requestDto.getDeliveryFee();

        // 1. 허용값: 1,000원 ~ 100,000원 입력
        // 2. 100 원 단위로만 입력 가능 (예. 2,220원 입력 시 에러발생. 2,300원은 입력 가능)
        // 3. 허용값이 아니거나 100원 단위 입력이 아닌 경우 에러 발생시킴
        if (minOrderPrice < 1000 || minOrderPrice > 100000) {
            throw new IllegalArgumentException("입렵값은 1,000원 이상 100,000원 이하여야합니다.");
        } else if (minOrderPrice % 100 != 0) {
            throw new IllegalArgumentException("최소 주문 가격을 100원 단위로 입력해주세요.");
        }

        // 1. 허용값: 0원 ~ 10,000원 (예. 11,000원 입력 시 에러발생.)
        // 2. 500 원 단위로만 입력 가능 (예. 2,200원 입력 시 에러발생. 2,500원 입력 가능)
        if (deliveryFee < 0 || deliveryFee > 10000) {
            throw new IllegalArgumentException("입렵값은 0원 이상 10,000원 이하여야합니다.");
        } else if (deliveryFee % 500 != 0) {
            throw new IllegalArgumentException("기본 배달비를 500원 단위로 입력해주세요.");
        }
        String result = "";

        Restaurant restaurant = new Restaurant(name,minOrderPrice,deliveryFee);
        restaurantRepository.save(restaurant);

        result = "점포 정보가 정상적으로 등록 되었습니다.";
        return result;
    }
}
