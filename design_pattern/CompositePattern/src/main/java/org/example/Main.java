package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Product p = new Product("cà phê",20000);
        Product p1 = new Product("coca",10000);
        Product p2 = new Product("nước cam",30000);
        System.out.println(p1.totalPrice());
        System.out.println(p2.totalPrice());

        Table table1 = new Table(1);
        table1.addProduct(p);
        table1.addProduct(p1);
        table1.addProduct(p2);
        table1.addProduct(p2);
        System.out.println("Tổng tiền bàn 1:"+" "+table1.totalPrice());

        Table table2 = new Table(2);
        table2.addProduct(p);
        table2.addProduct(p1);
        table2.addProduct(p2);
        System.out.println("Tổng tiền bàn 2:"+" "+table2.totalPrice());

        Table table3 = new Table(3);
        table3.addProduct(table1);
        table3.addProduct(table2);



        CoffeeShop coffeeShop = new CoffeeShop();
        coffeeShop.add(table1);
        coffeeShop.add(table2);
        coffeeShop.add(table3);
        System.out.println("Tổng doanh thu của quán là:"+coffeeShop.totalPrice());
    }
}