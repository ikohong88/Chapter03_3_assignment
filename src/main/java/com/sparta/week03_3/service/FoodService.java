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

    public String registerFood(FoodDto requestDto, Long restaurantId) {
        String name = requestDto.getName();
        Integer price = requestDto.getPrice();
        String imageURL = requestDto.getImageURL();

        if (imageURL.equals("")) {
            imageURL = "https://www.urbanbrush.net/web/wp-content/uploads/edd/2019/03/urbanbrush-20190324064729186591.png";
        }

//        Optional<Food> check_id = foodRepository.findByRestaurantId(restaurantId);
//        Optional<Food> check_name = foodRepository.findbyName(name);

        if (name.equals("")) {
            throw new IllegalArgumentException("식품명을 입력해주세요.");
        } else if  (price < 100 || price > 1000000) {
            throw new IllegalArgumentException("식품 가격은 100원 ~ 1,000,000원 사이로 입력해주세요.");
        } else if (price % 100 != 0) {
            throw  new IllegalArgumentException("식품 가격은 100원 단위로 입력해주세요.");
        }

        Food food = new Food(restaurantId,name,price,imageURL);
        foodRepository.save(food);

        return "식품 정보가 정상적으로 등록 되었습니다.";
    }
}
