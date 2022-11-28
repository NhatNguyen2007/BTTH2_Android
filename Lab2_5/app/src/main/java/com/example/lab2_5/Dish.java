package com.example.lab2_5;

public class Dish {
    private String DishName;
    private int DishImg;

    public Dish(String dishName, int dishImg) {
        this.DishName = dishName;
        this.DishImg = dishImg;
    }

    public void setDishName(String dishName) {
        DishName = dishName;
    }

    public void setDishImg(int dishImg) {
        DishImg = dishImg;
    }

    public String getDishName() {
        return DishName;
    }

    public int getDishImg() {
        return DishImg;
    }
}
