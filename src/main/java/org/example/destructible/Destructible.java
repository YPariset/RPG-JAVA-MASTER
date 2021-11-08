package org.example.destructible;

import org.example.matrice.Movable;

public abstract class Destructible extends Movable {

    /****************************************************/
    /*************** Attributes/Instances ***************/
    /****************************************************/

    protected int lifePoints;

    /****************************************************/
    /***********           Constructor        ***********/
    /****************************************************/

    public Destructible(int x, int y, int lifePoints) {
        super(x, y);
        this.lifePoints = lifePoints;
    }

    /****************************************************/
    /***********            Methods           ***********/
    /****************************************************/

    /**
     * This function is called to check if the destructible is destroyed
     * @return boolean
     */
    public boolean isKilled() {
        return this.lifePoints <= 0;
    }

}

