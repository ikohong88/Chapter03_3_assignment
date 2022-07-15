package com.sparta.week03_3.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RestaurantDto {
    private final String name;
    private final Integer minOrderPrice;
    private final Integer deliveryFee;
}
