package com.example.ramen.menu.Model;

/**
 * Created by ramen on 3/3/17.
 */

public class Order {

    //private String SessionId;
    private static Integer TableNo;  //Table number made static because once the user
                                    // enters table number it will not change fot the entire session
    private String DishName;
    private Integer Quantity;
    private OrderStatus Status;
    private Integer UnitPrice;

    public Order() {
    }

    public Order(String DishName, Integer Quantity, OrderStatus Status, Integer UnitPrice) {

        this.DishName = DishName;
        this.Quantity = Quantity;
        this.Status = Status;
        this.UnitPrice = UnitPrice;
    }

    public static Integer  getTableNo() {
        return TableNo;
    }

    public void setTableNo(Integer TableNo) {
        this.TableNo = TableNo;
    }

    public String getDishName() {
        return DishName;
    }

    public void setDishName(String DishName) {
        this.DishName = DishName;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer Quantity) {
        this.Quantity = Quantity;
    }

    public OrderStatus getStatus() {
        return Status;
    }

    public void setStatus(OrderStatus Status) {
        this.Status = Status;
    }

    public Integer getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(Integer UnitPrice) {
        this.UnitPrice = UnitPrice;
    }


}