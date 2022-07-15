package com.sparta.week03_3.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class OrderDto {
    private final Long restaurantId;
    private final String foods;
    private final Integer quantity;
}
