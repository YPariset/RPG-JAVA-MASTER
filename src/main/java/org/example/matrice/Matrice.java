package org.example.matrice;

import org.example.generator.DestructibleGenerator;

import java.util.Random;
import java.util.Scanner;

public class Matrice {

    /****************************************************/
    /*************** Attributes/Instances ***************/
    /****************************************************/

    private Movable[][] map;
    private static final String[] DIRECTION = {"top", "bottom", "right", "left"};
    private static final int LENGHT_X = 10;
    private static final int LENGHT_Y = 10;

    /****************************************************/
    /***********           Constructor        ***********/
    /****************************************************/

    public Matrice() {
        this.map = new Movable[LENGHT_X][LENGHT_Y];
        this.init();
    }

    /****************************************************/
    /***********            Methods           ***********/
    /****************************************************/

    /**
     * This function is called to init map with random result
     */
    public void init() {
        for (int i = 0; i < map.length-1; i++) {
            for (int j = 0; j < map.length-1; j++) {
                if (roll6()%2 == 0) {
                    this.map[i][j] = null;
                } else {
                    this.map[i][j] = DestructibleGenerator.createMonster(i, j);
                }
            }
        }
        this.map[0][0] = null;
        this.map[LENGHT_X - 1][LENGHT_Y - 1] = null;
        Limit limitWorld = new Limit(LENGHT_X - 10, LENGHT_Y - 1);
        this.placeObject(limitWorld);
    }

    /**
     * This function is called to display all valid moves in the position of the movable m
     *
     * @param m Movable
     */
    public void displayValidMoves(Movable m) {
        String str = "You can move :";

        for (int i = 0; i < DIRECTION.length; i++) {
            if (Matrice.isValidMove(m, DIRECTION[i])) {
                str += "\n\t- " + DIRECTION[i];
            }
        }

        System.out.println(str);
    }

    /**
     * This function is called to move m to its new position and clear its old coords
     *
     * @param m         Movable
     * @param oldCoords Point
     * @param sc        Scanner
     */
    public void moveObject(Movable m, Point oldCoords, Scanner sc) throws InterruptedException {
        if (this.map[m.getX()][m.getY()] == null) {
            this.map[oldCoords.x][oldCoords.y] = null;
            this.map[m.getX()][m.getY()] = m;
        } else {
            if (this.map[m.getX()][m.getY()].moveOnSymbol(m, sc)) {
                this.map[oldCoords.x][oldCoords.y] = null;
                this.map[m.getX()][m.getY()] = m;
            } else {
                m.setCoords(oldCoords.x, oldCoords.y);
            }
        }
    }

    /**
     * This function is called to check if move is valid
     *
     * @param m         Movable
     * @param direction Direction
     * @return boolean
     */
    public static boolean isValidMove(Movable m, String direction) {
        int x = m.getX();
        int y = m.getY();

        switch (direction) {
            case "top":
                x--;
                break;
            case "bottom":
                x++;
                break;
            case "left":
                y--;
                break;
            case "right":
                y++;
                break;
            default:
                return false;
        }

        if ((x >= 0 && x < LENGHT_X) && (y >= 0 && y < LENGHT_Y)) {
            return true;
        }

        return false;
    }

    /**
     * Roll a dice
     * @return dice result
     */
    public static int roll6(){
        Random rand = new Random();
        int n = rand.nextInt(7);
        while(n == 0){
            n = rand.nextInt(7);
        }//1-6
        return n;
    }

    /**
     * This function is called to place a Movable on the map
     *
     * @param m Movable
     */
    public void placeObject(Movable m) {
        if (this.map[m.getX()][m.getY()] == null) {
            this.map[m.getX()][m.getY()] = m;
        }
    }


    @Override
    public String toString() {
        String str = "- - - - - - - - - - - -";
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if ( j == 0 ) {
                    str += "\n|";
                }

                if ( this.map[i][j] != null ) {
                    str += " " + this.map[i][j].affectedSymbol();
                } else {
                    str += "  ";
                }

                if ( j == map.length-1 ) {
                    str += " |";
                }
            }
        }

        str += "\n- - - - - - - - - - - -";

        return str;
    }

}
