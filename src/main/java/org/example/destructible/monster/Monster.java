package org.example.destructible.monster;

import org.example.Game;
import org.example.destructible.Character;
import org.example.destructible.hero.Hero;
import org.example.matrice.Movable;

import java.util.Scanner;

public class Monster extends Character {

    /****************************************************/
    /***********           Constructor        ***********/
    /****************************************************/

    public Monster(MonsterType type) {
        super(type.getName(), type.getX(), type.getY(), type.getLifePoints(), type.getAttackPoints(), type.getLevel());
    }

    /****************************************************/
    /***********            Methods           ***********/
    /****************************************************/

    /**
     * This function is called to attack to attack an other Character
     *
     * @param c the com.company.Character.Character to attack
     */

    public void attack(Character c) {
        System.out.println("------------------\n");
        System.out.println(this.name + " attack the player with his arm");
        c.setLifePoints(c.getLifePoints() - this.attackPoints);
        System.out.println("Now, the player has " + c.getLifePoints() + " lifepoints.");
        System.out.println();
    }

    @Override
    public String affectedSymbol() {
        return "M";
    }

    @Override
    public boolean moveOnSymbol(Movable source, Scanner sc) throws InterruptedException {
        return Game.fight((Hero)source, this, sc);
    }

}
