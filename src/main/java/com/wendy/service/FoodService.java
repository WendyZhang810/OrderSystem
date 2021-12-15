package com.wendy.service;

import com.wendy.pojo.Food;

import java.util.List;

public interface FoodService {

    List<Food> getAll();

    List<Food> getFoodByCatalogId(int catalogId);


    Food getFoodByFoodId(int food_id);

    void deleteFoodById(int food_id);

    void alterFood(Food food);

    void addNewFood(Food food);
}
