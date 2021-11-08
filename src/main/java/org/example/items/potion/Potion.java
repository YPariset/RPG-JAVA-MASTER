package org.example.items.potion;

import org.example.destructible.hero.Hero;
import org.example.items.Item;

public class Potion extends Item {

    /****************************************************/
    /***********            Methods           ***********/
    /****************************************************/

    @Override
    public int price() {
        return 20;
    }

    @Override
    public void useItem(Hero c) {
        System.out.println("You drink a potion");
        int heal = 20;
        c.heal(heal);
    }

    public String toString() {
        return "Potion (+20hp)";
    }
}
