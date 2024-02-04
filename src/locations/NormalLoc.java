package locations;

import player.*;

public abstract class NormalLoc extends Location{
    public NormalLoc(Player player, String locName, int id) {
        super(player,locName,id);
    }
    @Override
    public boolean onLocation() {
        return true;
    }
}
