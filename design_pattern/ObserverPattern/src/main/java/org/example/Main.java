package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Tạo cổ phiếu
        Shares shares = new Shares(1,"Vinfast",23000);

        SharesPlayer player1 = new SharesPlayer("Quynh");
        SharesPlayer player2 = new SharesPlayer("My");

        SharesChannel channel = new SharesChannel();
        channel.attach(player1);
        channel.attach(player2);

        channel.changePriceShares(24000);

    }
}