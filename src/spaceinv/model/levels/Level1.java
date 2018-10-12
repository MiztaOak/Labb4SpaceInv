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
public class Level1 implements ILevel {
    private double startPos = 0;
    private final List<AbstractSpaceShip> ships =
            addAll(
                    distribute(asList(new Bomber(80,startPos), 10), 10),
                    distribute(asList(new BattleCruiser(80,startPos+40), 10), 10),
                    distribute(asList(new Frigate(80,startPos+80), 10), 10),
                    distribute(asList(new Bomber(80,startPos+120), 10), 10),
                    distribute(asList(new Frigate(80,startPos+160), 10), 10),
                    distribute(asList(new BattleCruiser(80,startPos+200), 10), 10)

            );
    // TODO replace null above with some ship

    @Override
    public OuterSpace getOuterSpace() {
        return new OuterSpace();

    }

    @Override
    public Ground getGround() {
        return null; // TODO new Ground(0); // Dummy for testing usage
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
