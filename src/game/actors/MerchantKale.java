package game.actors;

import game.items.weapons.Club;
import game.items.weapons.GreatKnife;
import game.items.weapons.HeavyCrossbow;
import game.items.weapons.Uchigatana;


public class MerchantKale extends Merchant{

    public MerchantKale(){
        super("Merchant Kale",'K',100);
        addValuableToInventory(new Club());
        addValuableToInventory(new Uchigatana());
        addValuableToInventory(new GreatKnife());
        addValuableToInventory(new HeavyCrossbow());
    }
}