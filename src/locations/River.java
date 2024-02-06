package locations;

import obstacles.Bear;
import player.*;

public class River extends BattleLoc{
    public River(Player player) {
        super(player,"River",6, new Bear());
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in the river with " + this.getObstacle().getObstacleName());
        fight();
        return true;
    }
}