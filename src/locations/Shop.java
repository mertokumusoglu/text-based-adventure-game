package locations;

import player.*;

public class Shop extends NormalLoc{
    public Shop(Player player) {
        super(player, "Shop",2);
    }

    @Override
    public boolean onLocation() {
        return true;
    }
}
