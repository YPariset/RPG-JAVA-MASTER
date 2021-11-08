package org.example.generator;

import org.example.items.potion.HyperPotion;
import org.example.items.potion.Potion;
import org.example.items.potion.SuperPotion;

public class ItemGenerator {

    /****************************************************/
    /***********            Methods           ***********/
    /****************************************************/

    /**
     * Create Potion
     * @return Potion
     */
    public static Potion createPotion() {
        return new Potion();
    }

    /**
     * Create SuperPotion
     * @return SuperPotion
     */
    public static SuperPotion createSuperPotion() {
        return new SuperPotion();
    }

    /**
     * Create HyperPotion
     * @return HyperPotion
     */
    public static HyperPotion createHyperPotion() {
        return new HyperPotion();
    }


}
