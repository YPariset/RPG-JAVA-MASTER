package org.example;

import org.example.destructible.monster.Monster;
import org.example.items.Item;
import org.example.destructible.hero.Hero;
import org.example.utils.Fight;
import org.example.matrice.Matrice;
import org.example.utils.Shop;

import java.util.Scanner;

public class Game {

    /****************************************************/
    /***********            Methods           ***********/
    /****************************************************/

    /**
     * This function is called to let the player choose what he wants to do
     * @param h Hero
     * @param m Map
     * @param sc Scanner
     */
    private static void optionPlayer(Hero h, Matrice m, Shop s, Scanner sc) throws InterruptedException {

        String choice;
        Game.displayMap(m, h);
        System.out.println("\n");
        System.out.println("<direction> : To navigate");
        System.out.println("shop : Teleport to the shop");
        System.out.println("situation : To show stats about you");
        System.out.println("inventory : To show your bag");
        System.out.println("quit : To quit the game");
        System.out.println();
        choice = sc.next();

        if (choice.equalsIgnoreCase("inventory")) {
            Item item = h.getInventory().search(sc);
            if (item != null) {
                item.useItem(h);
                System.out.println("\n(0) to exit");
                sc.next();
            }
        } else if (choice.equalsIgnoreCase("situation")) {
            System.out.println("\n" + h + "\n" + "(0) to exit");
            sc.next();

        } else if (choice.equalsIgnoreCase("shop")) {
            s.goToShop(h,sc);
        } else if (choice.equalsIgnoreCase("quit")) {
            System.out.println("You quit the game");
            System.exit(0);
        }
        h.moveTo(m, choice, sc);
    }

    /**
     * This function is called to Fight between Hero and Monster
     *
     * @param h
     * @param m
     * @param sc Scanner
     *
     * @return If you win or not
     */
    public static boolean fight(Hero h, Monster m, Scanner sc) throws InterruptedException {
        System.out.println("\n--------------------------------------------");
        System.out.println("\t\t!! a wild monster appears !!");
        System.out.println("\t\t⚔️ It's time to fight ⚔️");
        int choice;
            do {
                System.out.println("\nChoose : \n");
                System.out.println("1 : Fight the " + m.getName());
                System.out.println("2 : Run");
                try {
                    choice = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Please be focus !");
                    choice=0;
                    sc.next();
                }
            } while (choice < 1 || choice > 2);
            if (choice == 1) {
                new Fight(m, h).goFight();
            }
            else if (choice == 2) {
                if (!h.isDead()) {
                    System.out.println(h.getName() + " escaped !");
                    return false;
                }
            }
        return !h.isDead();
    }



    /**
     * This function is called to display map and valid moves of player
     * @param m Map
     * @param h Hero
     */
    private static void displayMap(Matrice m, Hero h) {
        System.out.println("\n------------------------");
        System.out.println("\t\tZONE WAR");
        System.out.println(m);
        m.displayValidMoves(h);
    }


    /**
     * This function is called to start the game and play
     * @param h Player
     * @param m Map
     * @param sc Scanner
     */
    public static void play(Hero h, Matrice m, Shop s, Scanner sc) throws InterruptedException {
        while (!h.isDead()) {
            optionPlayer(h, m, s, sc);
            if ( h.hasWon() ) {
                break;
            }
        }
        if (h.hasWon() ) {
            System.out.println("\n--------------------------------------------");
            System.out.println("\t\tCongrats 🥳 you just finished the game ! ");
        }
    }
}

