package org.example;

import java.util.ArrayList;
import java.util.List;

public class SharesChannel implements Subject {
    Shares shares;
    List<Observer> observers;

    public SharesChannel() {
        observers = new ArrayList<Observer>();
    }
    public void changePriceShares(double price){
        shares =new Shares();
        shares.setPrice(price);
        notifyObservers();
    }
    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {

    }

    @Override
    public void notifyObservers() {
        for(Observer o : observers){
            o.recieved("Giá cổ phiếu mới thay đổi");
        }
    }


}
