package locations;

import player.*;
import obstacles.*;

public abstract class BattleLoc extends Location{
    private Obstacle obstacle;

    public BattleLoc(Player player, String locName, int locID, Obstacle obstacle) {
        super(player, locName, locID);
        this.obstacle = obstacle;
    }

    @Override
    public boolean onLocation() {
        return true;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }
    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }
}
