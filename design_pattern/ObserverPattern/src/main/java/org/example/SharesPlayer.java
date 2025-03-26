package org.example;

public class SharesPlayer implements Observer{

    private String name;

    public SharesPlayer(String name) {
        this.name = name;
    }

    @Override
    public void recieved(String message) {
        System.out.println(message);
    }
}
