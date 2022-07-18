package com.sparta.week03_3.repository;

import com.sparta.week03_3.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Long> {
//    List<Food> findAllByOrderByModifiedAtDesc();
//    Optional<Food> findByRestaurantId(Long restaurantId);
//    Optional<Food> findByName(String name);
}
