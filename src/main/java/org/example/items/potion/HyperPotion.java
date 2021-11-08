package org.example.items.potion;

import org.example.destructible.hero.Hero;
import org.example.items.Item;

public class HyperPotion extends Item {

    /****************************************************/
    /***********            Methods           ***********/
    /****************************************************/

    @Override
    public int price() {
        return 60;
    }

    @Override
    public void useItem(Hero c) {
        System.out.println("You drink a potion");
        int heal = 100;
        c.heal(heal);
    }

    public String toString() {
        return "HyperPotion (+100hp)";
    }
}