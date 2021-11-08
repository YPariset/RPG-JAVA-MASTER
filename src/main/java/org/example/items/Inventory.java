package org.example.items;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {

    /****************************************************/
    /*************** Attributes/Instances ***************/
    /****************************************************/

    private ArrayList<Item> items;
    private int money;

    /****************************************************/
    /***********           Constructor        ***********/
    /****************************************************/

    public Inventory() {
        this.items = new ArrayList<Item>();
        this.money = 0;
    }

    /****************************************************/
    /***********            Methods           ***********/
    /****************************************************/

    /**
     * This function is called to add item to inventory
     * @param item
     */
    public void addItem(Item item) {
        this.items.add(item);
    }


    /**
     * This function is called to add money to inventory
     * @param money
     */
    public void addMoney(int money) {
        this.money += money;
    }

    /**
     * This function is called to remove item in inventory
     * @param item
     */
    public void removeItem(Item item) {
        this.items.remove(item);
    }


    /**
     * This function is called to display inventory and choose an item to get
     * @param sc
     * @return
     */
    public Item search(Scanner sc) {
        int choice;
        do {
            System.out.println("\n" + this);
            System.out.println("\n(n) to use");
            System.out.println("(0) to exit");
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                choice = -1;
            }
        } while(choice < -1 || choice > this.items.size());

        try {
            Item item = this.items.get(choice-1);
            this.items.remove(choice-1);
            return item;
        } catch (Exception e) {
            return null;
        }
    }


    @Override
    public String toString() {
        String str = "Inventory :\n\tItems : {\n";

        for(int i = 0; i < this.items.size(); i++) {
            str += "\t\t" + (i+1) + " : " + this.items.get(i) + "\n";
        }

        str += "\t}\n\tMoney : " + this.money + " Golds";

        return str;
    }

    /****************************************************/
    /***********            Getters           ***********/
    /****************************************************/

    public Item getItem(int i) {
        return this.items.get(i);
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public int getMoney() {
        return this.money;
    }


}