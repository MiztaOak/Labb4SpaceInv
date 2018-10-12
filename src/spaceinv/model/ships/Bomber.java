package spaceinv.model.ships;

import spaceinv.model.projectiles.Bomb;

import java.util.ArrayList;
import java.util.List;

/*
 *   Type of space ship
 */
public class Bomber extends AbstractSpaceShip{

    public static List<Bomb> bombs = new ArrayList<Bomb>();

    public Bomber(){
        super(0,0,0,0);
    }

    public Bomber(double x,double y){
        super(x,y,0,0);
    }

    @Override
    public int getPoints() {
        return 0;
    }

    @Override
    public Object copyOf() {
        Bomber copy = new Bomber();
        copy.setX(this.getX());
        copy.setY(this.getY());
        return copy;
    }

    public void update(){
        super.update();
        if(getY()+getHeight() >= 0) {
            int r = getRand().nextInt(100);
            if (r == 0) {
                bombs.add(new Bomb(getX(), getY()));
            }
        }
    }
}
