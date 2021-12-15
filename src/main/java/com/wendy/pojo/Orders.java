package com.wendy.pojo;

public class Orders {
    private int o_id;
    private String order_id;
    private int table_id;
    private int food_id;
    private int quantity;
    private int order_status;
    private String note;

    public int getO_id() {
        return o_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }

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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "o_id=" + o_id +
                ", order_id='" + order_id + '\'' +
                ", table_id=" + table_id +
                ", food_id=" + food_id +
                ", quantity=" + quantity +
                ", order_status=" + order_status +
                ", note='" + note + '\'' +
                '}';
    }
}
