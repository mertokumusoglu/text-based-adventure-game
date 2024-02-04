package locations;

import player.*;
import obstacles.*;

public class Cave extends BattleLoc{
    public Cave(Player player) {
        super(player, "Cave", 3, new Zombie());
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in the cave with " + this.getObstacle().getObstacleName());

        //battle

        return true;
    }
}
