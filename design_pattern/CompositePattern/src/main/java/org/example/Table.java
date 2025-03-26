package org.example;

import java.util.ArrayList;
import java.util.List;

public class Table implements Item{
    private int tableID;
    private List<Item> items;
    public Table(){

    }
    public Table(int tableID){
        this.tableID = tableID;
        items = new ArrayList<>();
    }
    public void addProduct(Item item){
        items.add(item);
    }
    @Override
    public double totalPrice() {
        double sumTable =0;
        for(Item p : items){
            sumTable+= p.totalPrice();
        }
        return sumTable;
    }
}
