package spaceinv.model.projectiles;


import spaceinv.model.IPositionable;
import spaceinv.model.statics.OuterSpace;

// Shoot by the gun
public class Rocket implements IPositionable {
    private double rocketSpeed = 5;
    private double x,y;
    private double width = 10;
    private double height = 15;

    private boolean hit = false;

    public Rocket() {
        this(0,0);
    }

    public Rocket(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void update(){
        y -= rocketSpeed;
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
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }
}
