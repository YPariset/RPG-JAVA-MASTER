package org.example.matrice;

import org.example.Game;
import org.example.destructible.Character;
import org.example.destructible.hero.Hero;
import org.example.generator.DestructibleGenerator;

import java.util.Scanner;

public class Limit extends Movable {

    /****************************************************/
    /***********           Constructor        ***********/
    /****************************************************/

    public Limit(int x, int y) {
        super(x, y);
    }

    /****************************************************/
    /***********            Methods           ***********/
    /****************************************************/

    @Override
    public String affectedSymbol() {
        return "👾";
    }

    @Override
    public boolean moveOnSymbol(Movable source, Scanner sc) throws InterruptedException {
        boolean moveOn = false;

        if ( source instanceof Hero) {
            moveOn = Game.fight((Hero) source, DestructibleGenerator.createBoss(), sc);
            if (moveOn) {
                if ( source instanceof Hero) {
                    ((Hero) source).win();
                }
            }
        }

        return moveOn;
    }
}
