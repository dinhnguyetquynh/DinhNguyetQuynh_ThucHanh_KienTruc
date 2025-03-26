package org.example;

import java.util.ArrayList;
import java.util.List;

public class CoffeeShop implements Item {
    //List<Item> mới đúng
    List<Item> list;

    public CoffeeShop() {
        this.list = new ArrayList<>();
    }
    public void add(Item item) {
        this.list.add(item);
    }
    @Override
    public double totalPrice() {
        double totalPrice = 0.0;
        for(Item table : list) {
            totalPrice+=table.totalPrice();
        }
        return totalPrice;
    }
}
