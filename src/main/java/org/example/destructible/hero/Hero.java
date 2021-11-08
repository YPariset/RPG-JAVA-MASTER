package org.example.destructible.hero;

import org.example.matrice.Movable;
import org.example.destructible.Character;

import java.util.Scanner;

public class Hero extends Character {

    /****************************************************/
    /*************** Attributes/Instances ***************/
    /****************************************************/

    protected Scanner scanner;
    protected boolean hasWon;

    /****************************************************/
    /***********           Constructor        ***********/
    /****************************************************/

    public Hero(HeroType type, Scanner scanner) {
        super(type.getName(), type.getX(), type.getY(), type.getLifePoints(), type.getAttackPoints(), type.getLevel());
        this.scanner = scanner;
        this.inventory.addMoney(20);
        this.hasWon = false;
    }

    /****************************************************/
    /***********            Methods           ***********/
    /****************************************************/

    /**
     * This function is called to set hasWon to true
     */
    public void win() {
        hasWon = true;
    }

    /**
     * This function is called to check if player has won
     * @return boolean has won
     */
    public boolean hasWon() {
        return hasWon;
    }

    /**
     * This function is called to attack an other Character
     *
     * @param c the com.company.Character.Character to attack
     */

    public void attack(Character c) {
        System.out.println("------------------\n");
        System.out.println(this.name + " attack the monster with his arm");
        c.setLifePoints(c.getLifePoints() - this.attackPoints);
        System.out.println("Now, the monster has " + c.getLifePoints() + " lifepoints.");
        System.out.println();
    }

    /**
     * This function is called to add money in the inventory of character
     * @param c
     */
    public void winMoney(Character c) {
        this.inventory.addMoney(20);
        System.out.println("20 Gold added in your bag !");
    }

    /**
     * This function is called to heal the hero
     * @param heal Heal amount
     */
    public void heal(int heal) {
        this.lifePoints += heal;

        System.out.println("You healed for " + heal + " HP");
        System.out.println("You have " + this.lifePoints + " HP left");
    }

    @Override
    public String affectedSymbol() {
        return "J";
    }

    @Override
    public boolean moveOnSymbol(Movable source, Scanner sc) {
        return false;
    }
}

