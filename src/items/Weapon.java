package items;

import java.util.Scanner;

public class Weapon extends Item{
    private int weaponDamage;
    Scanner sc = new Scanner(System.in);

    public Weapon(int weaponID, String weaponName, int price, int weaponDamage) {
        super(weaponID,weaponName,price);
        this.weaponDamage = weaponDamage;
    }

    public static Weapon[] weapons() {
        Weapon[] weapons = new Weapon[3];
        weapons[0] = new Weapon(1, "Gun", 25, 2);
        weapons[1] = new Weapon(2, "Sword", 35, 3);
        weapons[2] = new Weapon(3, "Rifle", 45, 7);

        return weapons;
    }
    public static Weapon getWeaponByID(int id) {
        for(Weapon weapon : Weapon.weapons()) {
            if(weapon.getItemID() == id) {
                return weapon;
            }
        }
        return null;
    }

    public int getWeaponDamage() {
        return this.weaponDamage;
    }
}
