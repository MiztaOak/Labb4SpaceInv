package spaceinv.model;


import spaceinv.model.projectiles.Bomb;
import spaceinv.model.projectiles.Rocket;
import spaceinv.model.ships.Bomber;

import java.awt.geom.Rectangle2D;

import static spaceinv.model.SpaceInv.GAME_HEIGHT;
import static spaceinv.model.SpaceInv.GAME_WIDTH;

/*
 * A Gun for the SpaceInv game
 */
public class Gun implements IPositionable{

    public static final double MAX_SPEED = 2;
    public static final double GUN_WIDTH = 30;
    public static final double GUN_HEIGHT = 40;

    private double x,y;
    private int dir = 0;

    public Gun(){
        this.x = GAME_WIDTH/2-GUN_WIDTH/2;
        this.y = GAME_HEIGHT-GUN_HEIGHT;
    }

    public Gun(double x, double y) {
        this.x = x;
        this.y = y;
        this.dir = 0;
    }

    public void moveGun(){
        x += dir*MAX_SPEED;

        if(x+GUN_WIDTH > GAME_WIDTH)
            x = GAME_WIDTH-GUN_WIDTH;
        else if(x < 0)
            x = 0;
    }

    public boolean checkHit(){
        Rectangle2D r = new Rectangle2D.Double(x,y,GUN_WIDTH,GUN_HEIGHT);
        for (Bomb b: Bomber.bombs){
            if(r.intersects(b.getX(),b.getY(),b.getWidth(),b.getWidth())) {
                Bomber.bombs.remove(b);
                return true;
            }
        }

        return false;
    }

    public void setX(double x){
        this.x = x;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getWidth() {
        return GUN_WIDTH;
    }

    @Override
    public double getHeight() {
        return GUN_HEIGHT;
    }

    public void setDir(int dir){
        this.dir = dir;
    }
}
