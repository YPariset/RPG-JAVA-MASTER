package org.example.generator;

import org.example.destructible.hero.Hero;
import org.example.destructible.hero.HeroType;
import org.example.destructible.monster.Monster;
import org.example.destructible.monster.MonsterType;

import java.util.Scanner;

public class DestructibleGenerator {

    /****************************************************/
    /***********            Methods           ***********/
    /****************************************************/

    /**
     * This function is called to create the Hero to play
     * @param sc
     * @return Hero
     */
    public static Hero createHero(Scanner sc) {
        Hero barbarian = new Hero(HeroType.BARBARIAN, sc);
        Hero ninja = new Hero(HeroType.NINJA, sc);
        Hero sorcerer = new Hero(HeroType.SORCERER, sc);

        System.out.println("--------------------------------------------");
        System.out.println("\n\t\t 🕵️‍ ️Welcome to you brave fighter ! What's your name ?");


        String name;
        do {
            System.out.println("Enter your name :");
            name = sc.nextLine();
        } while (name.isEmpty() || name.trim() == "");

        int playerClass;
        do {
            System.out.println("\n");
            System.out.println("--------------------------------------------");
            System.out.println("\t\t 👩‍🎤 Choose a fighter and try to survive");

            System.out.println();
            System.out.println("(1). BARBARIAN");
            System.out.println("----------");
            System.out.println("A melee attacker with a hell of a mustache and an equally hellish temper.");
            System.out.println();
            System.out.println("(2). NINJA");
            System.out.println("----------");
            System.out.println("A cold-hearted assassin who lives in the shadows. He specializes in his unique fighting technique, \"Ninja Art\".");
            System.out.println();
            System.out.println("(3). SORCERER");
            System.out.println("----------");
            System.out.println("\n" +
                    "The sorcerer's beauty will set your heart on fire... just like his fireballs.");
            System.out.println();
            System.out.println("--------------------------------------------");
            System.out.print("Choose >: ");
            System.out.println();
            try {
                playerClass = sc.nextInt();
            } catch(Exception e) {
                System.out.println("Invalid");
                playerClass = 0;
            }
        } while (playerClass < 1 || playerClass > 3);

        switch(playerClass) {
            case 1:
                System.out.println("Good luck, Barbarian " + name + " !");
                barbarian.setLifePoints(200);
                return barbarian;
            case 2:
                System.out.println("Good luck, Ninja " + name + " !");
                ninja.setLifePoints(300);
                return ninja;
            case 3:
                System.out.println("Good luck Sorcerer " + name + " !");
                sorcerer.setLifePoints(100);
                return sorcerer;
            default:
                barbarian.setLifePoints(200);
                return barbarian;
        }
    }

    /**
     * This function is called to create monster
     * @param x
     * @param y
     * @return Monster m
     */
    public static Monster createMonster(int x, int y) {
        Monster m = new Monster(MonsterType.GOBELINS);
        m.setLifePoints(40);
        m.setCoords(x, y);

        return m;
    }

    /**
     * This function is called to create Boss
     * @return Monster m
     */
    public static Monster createBoss() {
        Monster m = new Monster(MonsterType.GOLEM);
        m.setLifePoints(250);

        return m;
    }

}

