package player;

import items.*;

public class Inventory{
    private Weapon weapon;
    private Armor armor;
    private boolean wood = false;
    private boolean food = false;
    private boolean water = false;

    public Inventory() {
        this.weapon = new Weapon(0,"Punch",0,1);
        this.armor =  new Armor(0,"none",0,0);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public boolean isWood() {
        return wood;
    }

    public void setWood(boolean wood) {
        this.wood = wood;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }
}