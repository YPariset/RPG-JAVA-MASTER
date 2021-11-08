package org.example.items.potion;

import org.example.destructible.hero.Hero;
import org.example.items.Item;

public class SuperPotion extends Item {

    /****************************************************/
    /***********            Methods           ***********/
    /****************************************************/

    @Override
    public int price() {
        return 40;
    }

    @Override
    public void useItem(Hero c) {
        System.out.println("You drink a potion");
        int heal = 50;
        c.heal(heal);
    }

    public String toString() {
        return "SuperPotion (+50hp)";
    }
}
