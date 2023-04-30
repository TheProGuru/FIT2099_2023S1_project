package game.actions;


import game.actors.Player;

public interface Buyable {

    void handlePurchase(Player player);
    void handleSale(Player player);
    int getSellPrice();

    int getBuyPrice();
}