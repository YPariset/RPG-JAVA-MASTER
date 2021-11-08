package org.example.utils;


import org.example.destructible.hero.Hero;
import org.example.destructible.monster.Monster;
import org.example.items.Inventory;

import java.util.Scanner;

public class Fight {

    /****************************************************/
    /*************** Attributes/Instances ***************/
    /****************************************************/

    protected Monster monster;
    protected Hero hero;
    protected Inventory inventory;

    /****************************************************/
    /***********           Constructor        ***********/
    /****************************************************/

    public Fight(Monster monster, Hero hero, Inventory inventory) {
        this.monster = monster;
        this.hero = hero;
        this.inventory = inventory;
    }

    public Fight(Monster monster, Hero hero) {
        this.monster = monster;
        this.hero = hero;

    }

    /****************************************************/
    /***********            Methods           ***********/
    /****************************************************/

    /**
     * This function is called to start a fight between the Monster and the Player
     *
     * @throws InterruptedException
     */
    public void goFight() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        while (this.monster.isAlive() && this.hero.isAlive()) {
            Thread.sleep(400);
            this.hero.attack(this.monster);
            if (this.monster.isAlive()) {
                Thread.sleep(400);
                this.monster.attack(this.hero);
            }
        }
        if (this.hero.isAlive() & !this.monster.isAlive()) {
            System.out.println("\nCongratulations ! You won against this monster \n");
            this.hero.winMoney(this.hero);
            this.hero.generateLevel(20);
            int newAttackPoints = this.hero.getAttackPoints()*this.hero.getLevel();
            this.hero.setAttackPoints(newAttackPoints);
            System.out.println("\n(0) to continue");
            sc.next();


        }
        if (!this.hero.isAlive() & this.monster.isAlive()) {
            System.out.println("\nOh no ! The monster has just killed you...\n");
            System.out.println("\n--------------------------------------------");
            System.out.println("\t\tTry again ! you can do it.");
            System.exit(0);
        }

    }

}

