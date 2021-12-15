package com.wendy.mapper;

import com.wendy.pojo.Catalog;
import com.wendy.pojo.Food;

import java.util.List;

public interface FoodMapper {

    public List<Food> getAll();

    public List<Food> getFoodByCatalogId(int CatalogId);

    public Food getFoodByFoodId(int food_id);

    void deleteFoodById(int food_id);

    void alterFood(Food food);

    void addNewFood(Food food);
}

