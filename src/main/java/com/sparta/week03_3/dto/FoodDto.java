package com.sparta.week03_3.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class FoodDto {
    private final Long restaurantId;
    private final String name;
    private final Integer price;
}
