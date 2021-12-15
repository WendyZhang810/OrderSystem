package com.wendy.pojo;

public class FoodOrder {
    private String order_id;
    private int table_id;
    private int food_id;
    private int quantity;
    private int order_status;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public int getTable_id() {
        return table_id;
    }

    public void setTable_id(int table_id) {
        this.table_id = table_id;
    }

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOrder_status() {
        return order_status;
    }

    public void setOrder_status(int order_status) {
        this.order_status = order_status;
    }

    @Override
    public String toString() {
        return "FoodOrder{" +
                "order_id='" + order_id + '\'' +
                ", table_id=" + table_id +
                ", food_id=" + food_id +
                ", quantity=" + quantity +
                ", order_status=" + order_status +
                '}';
    }
}
