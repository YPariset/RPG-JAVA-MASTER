package org.example;

import org.example.generator.DestructibleGenerator;
import org.example.destructible.hero.Hero;
import org.example.generator.ItemGenerator;
import org.example.items.Inventory;
import org.example.matrice.Matrice;
import org.example.utils.Shop;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------------------");
        System.out.println("\t\t\t\t\t⚔");
        System.out.println("The story takes place in a war-torn nation" +
                "\nduring your adventure you will have to beat many goblins" +
                "\n(you can always try to dodge them but good luck...)" +
                "\nin order to face the supreme golem, a force the world has never seen.");
        Hero hero = DestructibleGenerator.createHero(sc);
        Matrice matrice = new Matrice();
        Shop shop = new Shop(new Inventory());
        shop.addItem(ItemGenerator.createPotion());
        shop.addItem(ItemGenerator.createSuperPotion());
        shop.addItem(ItemGenerator.createHyperPotion());
        matrice.placeObject(hero);
        Game.play(hero, matrice, shop, sc);
    }
}
