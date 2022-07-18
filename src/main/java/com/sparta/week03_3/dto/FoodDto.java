package com.sparta.week03_3.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class FoodDto {
    private final Long restaurantId;
    private final String name;
    private final Integer price;
    private final String imageURL;
}
