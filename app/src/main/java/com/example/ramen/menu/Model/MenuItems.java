package com.example.ramen.menu.Model;

import android.view.Menu;

import com.example.ramen.menu.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ramen on 3/3/17.
 */

public class MenuItems {
    private String dishName;
    private Integer unitPrice;
    private int image;
    private int rating;

    public MenuItems(String dishName, Integer unitPrice, int image, int rating) {
        this.dishName = dishName;
        this.unitPrice = unitPrice;
        this.image = image;
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDishName() {

        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }


    //Populate static menu here..
    public static List<MenuItems> generateMenu(){
        List<MenuItems> menuList = new ArrayList<MenuItems>();

        menuList.add(new MenuItems("Chicken Roast", 200, R.drawable.chicken_roast,5));
        menuList.add(new MenuItems("Chowmin", 120, R.drawable.chowmin,5));
        menuList.add(new MenuItems("Fried Rice", 140, R.drawable.friedrice,5));
        menuList.add(new MenuItems("Momo", 200, R.drawable.momo,5));
        menuList.add(new MenuItems("Sizzler", 200, R.drawable.sizzler,5));
        return menuList;
    }
}
