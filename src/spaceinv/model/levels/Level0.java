package spaceinv.model.levels;



import spaceinv.model.Gun;
import spaceinv.model.ships.*;
import spaceinv.model.statics.Ground;
import spaceinv.model.statics.OuterSpace;

import java.util.List;

import static spaceinv.model.levels.LevelUtils.*;

/*
    Basic level to test ships and movement of

 */
public class Level0 implements ILevel {
    private double startPos = -200;
    private final List<AbstractSpaceShip> ships =
            addAll(
                    distribute(asList(new Bomber(80,startPos+200), 10), 10)
            );

    @Override
    public OuterSpace getOuterSpace() {
        return new OuterSpace(); // TODO new OuterSpace(0); // Dummy for testing usage
    }

    @Override
    public Ground getGround() {
        return new Ground(); // TODO new Ground(0); // Dummy for testing usage
    }

    @Override
    public Gun getGun() {
        return new Gun(); // TODO new Gun(0, 0, 0); // Dummy for testing usage
    }

    @Override
    public ShipFormation getFormation() {
        return new ShipFormation(ships);
    }

}
