package spaceinv.model.projectiles;


import spaceinv.model.IPositionable;
import spaceinv.model.ships.Bomber;
import spaceinv.model.statics.Ground;

// Dropped by the ships
public class Bomb implements IPositionable {

    public static final double BOMB_WIDTH = 10;
    public static final double BOMB_HEIGHT = 10;

    private double bombSpeed = 7;
    private double x,y;

    public Bomb() {
        this(0,0);
    }

    public Bomb(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void update(){
        y += bombSpeed;

        if(y >= Ground.GROUND_HEIGHT)
            Bomber.bombs.remove(this);
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
        return BOMB_WIDTH;
    }

    @Override
    public double getHeight() {
        return BOMB_HEIGHT;
    }
}
