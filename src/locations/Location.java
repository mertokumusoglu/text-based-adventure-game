package locations;

import player.Player;

import java.util.Scanner;

public abstract class Location {
    private Player player;
    private String locName;
    private int locID;

    Scanner sc = new Scanner(System.in);

    public Location(Player player, String locName, int locID) {
        this.player = player;
        this.locName = locName;
        this.locID = locID;
    }

}
