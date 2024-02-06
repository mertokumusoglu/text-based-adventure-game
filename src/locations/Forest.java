package locations;

import obstacles.Vampire;
import player.*;

public class Forest extends BattleLoc{
    public Forest(Player player) {
        super(player,"Forest",4,new Vampire());
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in the forest with " + this.getObstacle().getObstacleName());
        fight();
        return true;
    }
}
