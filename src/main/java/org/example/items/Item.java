package org.example.items;

import org.example.destructible.hero.Hero;

public abstract class Item {

    /**
     * This function is called to generate price of item
     * @return price of item
     */
    public abstract int price();

    /**
     * This function is called when a character use an item
     *
     * @param c Character that use it
     */
    public abstract void useItem(Hero c);
}
