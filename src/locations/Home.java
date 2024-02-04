package locations;

import player.*;

public class Home extends NormalLoc{
    public Home(Player player) {
        super(player, "Home", 1);

    }

    @Override
    public boolean onLocation() {

        System.out.println("Welcome to your home");
        System.out.println("Your health fully restored");
        this.getPlayer().getCharacter().setHealth(this.getPlayer().getCharacter().getFirstHealth());

        return true;
    }
}
