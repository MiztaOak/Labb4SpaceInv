package spaceinv.model.ships;

import spaceinv.model.IPositionable;

import java.util.Random;


/*
 * An alien attacker for the space invaders game
 *
 * Base class for all ships
 */

public abstract class AbstractSpaceShip  implements IPositionable {

    public static final double SHIP_WIDTH = 40;
    public static final double SHIP_HEIGHT = 30;
    public static final double SHIPS_DX = 5;
    public static final double SHIPS_DY = 7;

    private double dir = 1;

    private static Random rand = new Random();   // TODO

    private double minX;  // min and max for ship to move i x-dir
    private double maxX;

    private double x;
    private double y;

    public AbstractSpaceShip(double x, double y, double maxX, double minX){
        this.x = x;
        this.y = y;
        this.maxX = maxX;
        this.minX = minX;
    }

    // To be overridden
    public abstract int getPoints();

    // To be overridden
    public abstract Object copyOf();

    public Random getRand(){
        return rand;
    }

    // For ships moving back and forth
    public void setMoveInterval(double minX, double maxX) {
        this.minX = minX;
        this.maxX = maxX;
    }

    public void update() {
        if(x+SHIPS_DX*dir >= minX && x+SHIPS_DX*dir <= maxX){
            x += SHIPS_DX*dir;
        }else {
            if(x+SHIPS_DX*dir >= maxX)
                y += SHIPS_DY;
            dir *= -1;
            x += SHIPS_DX*dir;
        }
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return SHIP_WIDTH;
    }

    public double getHeight() {
        return SHIP_HEIGHT;
    }

    public void setDir(int dir){
        this.dir = dir;
    }

    public void setMaxX(double maxX) {
        this.maxX = maxX;
    }

    public void setMinX(double minX) {
        this.minX = minX;
    }
}
