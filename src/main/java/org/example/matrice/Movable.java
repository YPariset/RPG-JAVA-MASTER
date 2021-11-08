package org.example.matrice;

import java.util.Scanner;

public abstract class Movable {

    /****************************************************/
    /*************** Attributes/Instances ***************/
    /****************************************************/

    private Point point;

    /****************************************************/
    /***********           Constructor        ***********/
    /****************************************************/

    public Movable(int x, int y) {
        point = new Point(x, y);
    }

    /****************************************************/
    /***********            Methods           ***********/
    /****************************************************/

    /**
     * This function is called to identifier coords on map
     * @param x CoordsX
     * @param y CoordsY
     */
    public void setCoords(int x, int y) {
        this.point.x = x;
        this.point.y = y;
    }

    /**
     * This function is called to move to a direction in the world map
     * @param worldMap WorldMap
     * @param direction Direction
     * @param sc Scanner
     */
    public void moveTo(WorldMap worldMap, String direction, Scanner sc) throws InterruptedException {
        if (WorldMap.isValidMove(this, direction)) {
            Point old = new Point(this.point.x, this.point.y);

            switch(direction) {
                case "top" :
                    this.point.x--;
                    break;
                case "bottom" :
                    this.point.x++;
                    break;
                case "left" :
                    this.point.y--;
                    break;
                case "right" :
                    this.point.y++;
                    break;
            }
            worldMap.moveObject(this, old, sc);
        }
    }

    /**
     * This function is called to identifier symbol on map
     *
     * @return map symbol of object
     */
    public abstract String affectedSymbol();

    /**
     * This function is called to move onto something
     *
     * @param source
     * @param sc
     * @return result
     */
    public abstract boolean moveOnSymbol(Movable source, Scanner sc) throws InterruptedException;


    /****************************************************/
    /***********            Getters           ***********/
    /****************************************************/

    public int getX() {
        return this.point.x;
    }

    public int getY() {
        return this.point.y;
    }

}


