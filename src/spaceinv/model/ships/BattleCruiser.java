package spaceinv.model.ships;

/*
 *   Type of space ship
 */
public class BattleCruiser extends AbstractSpaceShip{

    public BattleCruiser(){
        this(0,0);
    }

    public BattleCruiser(double x,double y){
        super(x,y,0,0);
    }

    @Override
    public int getPoints() {
        return 0;
    }

    @Override
    public Object copyOf() {
        BattleCruiser copy = new BattleCruiser();
        copy.setX(this.getX());
        copy.setY(this.getY());
        return copy;
    }
}
