package org.example.utils;

import org.example.destructible.Character;
import org.example.generator.ItemGenerator;
import org.example.items.Inventory;
import org.example.items.Item;

import java.util.ArrayList;
import java.util.Scanner;

public class Shop {

    /****************************************************/
    /*************** Attributes/Instances ***************/
    /****************************************************/

    protected Inventory inventory;


    /****************************************************/
    /***********           Constructor        ***********/
    /****************************************************/

    public Shop(Inventory inventory) {
        this.inventory = inventory;
    }


    /****************************************************/
    /***********            Methods           ***********/
    /****************************************************/

    /**
     * This function is called to add item to shop
     *
     * @param item
     */
    public void addItem(Item item) {
        this.inventory.addItem(item);
    }


    /**
     * This function is called to buy item to the shop for the character c
     *
     * @param c Character
     * @param itemID in the shop
     */
    public void buy(Character c, int itemID) {
        Item item = this.getInventory().getItem(itemID);
        Scanner sc = new Scanner(System.in);
        int price = item.price();

        if (c.getInventory().getMoney() >= price) {
            System.out.println("You bought a " + item + " for " + price + " Gold");
            c.getInventory().addMoney(-price);
            c.getInventory().addItem(item);
            System.out.println("(0) to exit");
            sc.next();
        } else {
            System.out.println("You don't have the gold to buy that !");
            System.out.println("(0) to exit");
            sc.next();
        }
    }

    /**
     * This function is called to go to the shop and let the player chose which item he wants
     *
     * @param c  Character (player)
     * @param sc Scanner
     */
    public void goToShop(Character c, Scanner sc) {
        ArrayList<Item> allItems = this.getInventory().getItems();
        int choice;

        do {
            if (allItems.size() < 1) {
                System.out.println("Everything sold out sorry :( (0 to exit)");
            } else
                System.out.println("\nChoose what do you want stranger ! (or (0) to exit): ");
            for (int i = 0; i < allItems.size(); i++) {
                System.out.println((i + 1) + " : " + allItems.get(i) + " (" + allItems.get(i).price() + " Gold)");
            }
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                choice = -1;
            }
        } while (choice < 0 || choice > allItems.size());

        switch (choice) {
            case 0:
                return;
            default:
                this.buy(c, choice - 1);
        }
    }


    public Inventory getInventory() {
        return inventory;
    }

}
