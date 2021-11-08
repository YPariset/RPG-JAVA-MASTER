package org.example.destructible.monster;

public enum MonsterType {
    GOLEM("Golem", 2, 0,250, 100, "Huge creature with an rock body ", 5),
    GOBELINS("Gobelins", 2, 0,40, 10, "Smart creature with a knife", 5);

    /****************************************************/
    /*************** Attributes/Instances ***************/
    /****************************************************/

    private String name;
    private int x;
    private int y;
    private String description;
    private int lifePoints;
    private int attackPoints;
    private int level;

    /****************************************************/
    /***********           Constructor        ***********/
    /****************************************************/

    MonsterType(String name, int x, int y, int lifePoints, int attackPoints, String description, int level) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.lifePoints = lifePoints;
        this.attackPoints = attackPoints;
        this.description = description;
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
