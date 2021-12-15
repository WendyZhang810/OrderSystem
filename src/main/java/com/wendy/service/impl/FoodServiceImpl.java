package com.wendy.service.impl;

import com.wendy.mapper.FoodMapper;
import com.wendy.pojo.Food;
import com.wendy.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodMapper foodMapper;

    @Override
    public List<Food> getAll() {
        return foodMapper.getAll();
    }

    @Override
    public List<Food> getFoodByCatalogId(int catalogId) {
        return foodMapper.getFoodByCatalogId(catalogId);
    }

    @Override
    public Food getFoodByFoodId(int food_id) {
        return foodMapper.getFoodByFoodId(food_id);
    }

    @Override
    public void deleteFoodById(int food_id) {
        foodMapper.deleteFoodById(food_id);
    }

    @Override
    public void alterFood(Food food) {
        foodMapper.alterFood(food);
    }

    @Override
    public void addNewFood(Food food) {
        foodMapper.addNewFood(food);
    }


}
