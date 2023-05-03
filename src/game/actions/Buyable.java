package game.actions;
/**
 * Interface for items that can be bought by a Merchant.
 *
 * As well as providing methods needed by Buyables, this interface is used in buy and sell actions to
 * determinethe price of a Buyable.
 */
public interface Buyable {

    /**
     * The price of the Buyable when actor is selling it to a Merchant
     *
     * @return the price in int
     */
    int getSellPrice();
    /**
     * The price of the Buyable when actor is buying it from a Merchant
     *
     * @return the price in int
     */
    int getBuyPrice();
}