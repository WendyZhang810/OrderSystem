package com.wendy.pojo;

public class Food {
    private int food_id;
    private int catalog_id;
    private String food_name;
    private Double food_price;

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public int getCatalog_id() {
        return catalog_id;
    }

    public void setCatalog_id(int catalog_id) {
        this.catalog_id = catalog_id;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public Double getFood_price() {
        return food_price;
    }

    public void setFood_price(Double food_price) {
        this.food_price = food_price;
    }

    @Override
    public String toString() {
        return "Food{" +
                "food_id=" + food_id +
                ", catalog_id=" + catalog_id +
                ", food_name='" + food_name + '\'' +
                ", food_price=" + food_price +
                '}';
    }
}
