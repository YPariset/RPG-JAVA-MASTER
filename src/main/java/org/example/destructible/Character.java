package org.example.destructible;

import org.example.items.Inventory;

public abstract class Character extends Destructible {

    /****************************************************/
    /*************** Attributes/Instances ***************/
    /****************************************************/

    protected static final int XP_TO_LEVEL = 30;
    protected String name;
    protected int lifePoints;
    protected int attackPoints;
    protected Inventory inventory;
    protected int xp;
    protected int level;

    /****************************************************/
    /***********           Constructor        ***********/
    /****************************************************/

    public Character(String name, int x, int y, int lifePoints, int attackPoints, int level) {
        super(x, y, lifePoints);
        this.name = name;
        this.attackPoints = attackPoints;
        this.inventory = new Inventory();
        this.level = level;
        this.xp = 0;

    }

    /****************************************************/
    /***********            Methods           ***********/
    /****************************************************/

    public boolean isAlive(){
        return this.lifePoints > 0;
    }

    /**
     * This function is called to check if character is dead
     *
     * @return boolean
     */
    public boolean isDead() {
        return super.isKilled();
    }

    /**
     * This function is called to add xp and generate level
     *
     * @param xp Xp added
     */
    public void generateLevel(int xp) {
        System.out.println(this.name + " gained " + xp + " xp !");
        this.xp += xp;

        // While and not a if to be able to level up multiple times in one shot
        while (this.xp >= Character.XP_TO_LEVEL * this.level ) {
            this.levelUp();
            System.out.println("LEVEL UP 💪"+"\tYou are now level:" + this.level);
            this.xp = this.xp%(Character.XP_TO_LEVEL * this.level); // We add the remaining xp points
        }
    }

    /**
     * This function is called to leveling up
     */
    public void levelUp() {
        this.level++;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", lifePoints=" + lifePoints +
                ", attackPoints=" + attackPoints +
                ", xp=" + xp +
                ", level=" + level +
                '}';
    }

    /****************************************************/
    /***********            Getters           ***********/
    /****************************************************/

    public String getName() {
        return name;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getLevel() {
        return level;
    }

    /****************************************************/
    /***********            Setters           ***********/
    /****************************************************/

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }


}

