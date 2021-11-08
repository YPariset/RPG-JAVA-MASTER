package org.example.destructible.hero;

public enum HeroType {
    BARBARIAN("Barbarian", 9, 0,200, 20, "Sword", 1),
    SORCERER("Sorcerer", 9, 0,100, 30, "Magic", 1),
    NINJA("Ninja", 9, 0,300, 10, "Kunai", 1);

    /****************************************************/
    /*************** Attributes/Instances ***************/
    /****************************************************/

    private String name;
    private int x;
    private int y;
    private String arm;
    private int lifePoints;
    private int attackPoints;
    private int level;

    /****************************************************/
    /***********           Constructor        ***********/
    /****************************************************/

    HeroType(String name, int x, int y, int lifePoints, int attackPoints, String arm, int level) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.lifePoints = lifePoints;
        this.attackPoints = attackPoints;
        this.arm = arm;
        this.level = level;
    }

    /****************************************************/
    /***********            Methods           ***********/
    /****************************************************/

    public String toString() {
        return name;
    }

    /****************************************************/
    /***********            Getters           ***********/
    /****************************************************/

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public int getLevel() {
        return level;
    }
}
