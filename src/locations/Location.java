package locations;

import player.*;
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
    public abstract boolean onLocation();

    public Player getPlayer() {
        return this.player;
    }

    public String getLocName() {
        return locName;
    }
    public void setLocName(String locName) {
        this.locName = locName;
    }

    public int getLocID() {
        return locID;
    }
    public void setLocID(int locID) {
        this.locID = locID;
    }
}