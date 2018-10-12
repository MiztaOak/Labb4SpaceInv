package spaceinv.model.ships;

/*
 *   Type of space ship
 */
public class Frigate extends AbstractSpaceShip {

    public Frigate(){
        super(0,0,0,0);
    }

    public Frigate(double x,double y){
        super(0,0,0,0);
    }

    @Override
    public int getPoints() {
        return 0;
    }

    @Override
    public Frigate copyOf() {
        Frigate copy = new Frigate();
        copy.setX(this.getX());
        copy.setY(this.getY());
        return copy;
    }

}
