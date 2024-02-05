package items;

import java.util.Scanner;

public class Armor extends Item{
    private int blocking;
    Scanner sc = new Scanner(System.in);

    public Armor(int armorID, String armorName, int price, int blocking) {
        super(armorID,armorName,price);
        this.blocking = blocking;
    }

    public static Armor[] armors() {
        Armor[] armors = new Armor[3];
        armors[0] = new Armor(1,"Leather", 15, 1);
        armors[1] = new Armor(2,"Iron", 25, 3);
        armors[2] = new Armor(3,"Diamond", 40, 5);
        return armors;
    }


    public static Armor getArmorByID(int id) {
        for(Armor armor : Armor.armors()) {
            if(armor.getItemID() == id) {
                return armor;
            }
        }
        return null;
    }


    public int getBlocking() {
        return blocking;
    }
    public void setBlocking(int blocking) {
        this.blocking = blocking;
    }
}
