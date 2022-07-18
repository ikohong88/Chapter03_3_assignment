package com.sparta.week03_3.service;

import com.sparta.week03_3.dto.FoodDto;
import com.sparta.week03_3.model.Food;
import com.sparta.week03_3.model.Restaurant;
import com.sparta.week03_3.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FoodService {
    private final FoodRepository foodRepository;
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public String registerFood(FoodDto requestDto) {
        String name = requestDto.getName();
        Integer price = requestDto.getPrice();
        Long restaurantId = requestDto.getRestaurantId();
        String imageURL = requestDto.getImageURL();

//        Optional<Food> check_id = foodRepository.findByRestaurantId(restaurantId);
//        Optional<Food> check_name = foodRepository.findbyName(name);

        if (name.equals("")) {
            throw new IllegalArgumentException("식품명을 입력해주세요.");
        }

        String result = "";

        Food food = new Food(restaurantId,name,price,imageURL);
        foodRepository.save(food);

        result = "식품 정보가 정상적으로 등록 되었습니다.";
        return result;
    }
}
