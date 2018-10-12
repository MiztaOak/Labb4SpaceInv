package spaceinv.model;

import spaceinv.event.Event;
import spaceinv.event.EventService;
import spaceinv.model.levels.ILevel;
import spaceinv.model.levels.Level0;
import spaceinv.model.projectiles.Rocket;
import spaceinv.model.ships.AbstractSpaceShip;
import spaceinv.model.ships.Bomber;
import spaceinv.model.ships.ShipFormation;
import spaceinv.model.statics.Ground;
import spaceinv.model.statics.OuterSpace;
import sun.util.locale.provider.SPILocaleProviderAdapter;

import java.util.ArrayList;
import java.util.List;

import static spaceinv.model.Gun.GUN_WIDTH;
import static spaceinv.model.Gun.MAX_SPEED;

/*
 * Logic for the SpaceInv Game
 * Model class representing the "overall" game logic
 *
 * Nothing visual here
 *
 * See:
 * - week6/samples/catchtherain
 */
public class SpaceInv {

    public static final double GAME_WIDTH = 800;
    public static final double GAME_HEIGHT = 400;

    public static final long ONE_SEC = 1_000_000_000;
    public static final long HALF_SEC = 500_000_000;
    public static final long TENTH_SEC = 100_000_000;
    public static final long TWENTYTH_SEC = 50_000_000;

    private final List<AbstractSpaceShip> ships;

    private final Ground ground;           // Border for bombs
    private final OuterSpace outerSpace;   // Border for rocket
    private final Gun gun;
    private final ShipFormation formation;


    private Rocket rocket;
    private int points;

    public SpaceInv(ILevel level) {
        ground = level.getGround();
        outerSpace = level.getOuterSpace();
        gun = level.getGun();
        formation = level.getFormation();
        ships = formation.getShips();

        points = 0;
    }

    public SpaceInv() {
        this(new Level0());
    }


    // Timing. All timing handled here!
    private long timeForLastMove;
    private long timeForlastFire;
    private long shipMoveDelay = TWENTYTH_SEC;
    //private long shipMoveDelay = 1_000_000;

    // ------ Game loop (called by timer) -----------------

    public void update(long now) {
        for(int i = 0; i < Bomber.bombs.size(); i++){
            Bomber.bombs.get(i).update();
        }
        if(gun.checkHit()){
            EventService.add(new Event(Event.Type.GAME_OVER));
        }

        if(rocket != null) {
            formation.killShips(rocket);
            if(rocket.getY()+rocket.getHeight() < OuterSpace.OUTERSPACE_HEIGHT)
                rocket = null;
            else
                rocket.update();
        }

        if(now - timeForLastMove >= shipMoveDelay){
            timeForLastMove = now;
            formation.updateFormation();
        }
        gun.moveGun();
        if(rocket != null)
            if(rocket.isHit())
                rocket = null;
    }

    // ------------- Increase pressure on player
    private boolean finalSpeed = false;
    private boolean incSpeed = false;

    // ---------- Interaction with GUI  -------------------------

    public void fireGun() {
        if (rocket == null) {
            rocket = new Rocket(gun.getX()+GUN_WIDTH/2,gun.getY());
        }
    }

    public void moveGunLeft() {
        gun.setDir(-1);
    }

    public void moveGunRight() {
        gun.setDir(1);
    }

    public void stopGun() {
        gun.setDir(0);
    }

    // --------- Send everything to be rendered --------------

    public List<IPositionable> getPositionables() {
        List<IPositionable> ps = new ArrayList<>();
        ps.add(gun);
        ps.addAll(ships);
        ps.add(gun);
        if(!Bomber.bombs.isEmpty())
            ps.addAll(Bomber.bombs);
        if (rocket != null) {
            ps.add(rocket);
        }
        return ps;
    }

    public int getPoints() {
        return points;
    }


}
