package locations;

import items.*;
import player.*;
import java.util.Scanner;

public class Shop extends NormalLoc{
    public Weapon selectedWeapon;
    public Armor selectedArmor;
    Scanner sc = new Scanner(System.in);

    public Shop(Player player) {
        super(player, "Shop",2);
    }

    @Override
    public boolean onLocation() {
        System.out.println("Welcome to shop.");
        System.out.println("Your money is: " + this.getPlayer().getCharacter().getMoney());
        menu();
        return true;
    }
    public void menu() {
        System.out.println("What do you want to buy ?\n" +
                "1 - Weapons \n" +
                "2 - Armors \n" +
                "3 - Exit");
        int choice = sc.nextInt();
        while(choice < 1 || choice > 3) {
            System.out.println("You entered invalid number, please try again");
            choice = sc.nextInt();
        }
        switch (choice) {
            case 1:
                printWeapons();
                break;
            case 2:
                printArmors();
                break;
            case 3:
                System.out.println("Good bye.");
                break;
        }

    }
    // WEAPON SECTİON
    public void printWeapons() {
        System.out.println("your damage is: " + this.getPlayer().getCharacter().getDamage());
        System.out.println("------ Weapons ------");
        for(int i = 0; i < Weapon.weapons().length; i++) {
            System.out.println("ID: " + Weapon.weapons()[i].getItemID() +
                    " | Weapon Name: " + Weapon.weapons()[i].getItemName() +
                    " | Weapon Damage: " + Weapon.weapons()[i].getWeaponDamage() +
                    " | Weapon Money: " + Weapon.weapons()[i].getPrice());
        }
        buyWeapon();
    }

    public void buyWeapon() {
        System.out.print("Enter the ID of the weapon you want to buy ( 0 for exit ): ");
        int selectedWeaponID = sc.nextInt();
        while(selectedWeaponID < 0 || selectedWeaponID > Weapon.weapons().length) {
            System.out.println("You entered invalid number, please try again.!");
            selectedWeaponID = sc.nextInt();
        }
        if (selectedWeaponID == 0) {
           System.out.println("MAP");
        }
        else {
            selectedWeapon = Weapon.getWeaponByID(selectedWeaponID);

            if(selectedWeapon != null) {
                if(selectedWeapon.getPrice() > this.getPlayer().getCharacter().getMoney()) {
                    System.out.println("You haven't got enough money");
                }
                else {
                    // buying
                    this.getPlayer().getCharacter().setMoney(this.getPlayer().getCharacter().getMoney() - selectedWeapon.getPrice());
                    System.out.println("Your new money: " + this.getPlayer().getCharacter().getMoney());
                    System.out.println("item added your inventory");
                    // item add inventory
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Your new weapon is: " + this.getPlayer().getInventory().getWeapon().getItemName());
                    this.getPlayer().getCharacter().setTotalDamage(this.getPlayer().getCharacter().getDamage() + this.getPlayer().getInventory().getWeapon().getWeaponDamage());
                    System.out.println("Your new damage: " + this.getPlayer().getCharacter().getTotalDamage());
                }
            }
            menu();
        }
    }
    // ARMOR SECTİON
    public void printArmors() {
        System.out.println("------ Armors ------");
        for(int i = 0; i < Armor.armors().length; i++) {
            System.out.println("ID: " + Armor.armors()[i].getItemID() +
                    " | Armor Name: " + Armor.armors()[i].getItemName() +
                    " | Armor Blocking: " + Armor.armors()[i].getBlocking() +
                    " | Armor Money: " + Armor.armors()[i].getPrice());
        }
        buyArmor();
    }
    public void buyArmor() {
        System.out.print("Enter the ID of the armor you want to buy ( 0 for exit ): ");
        int selectedArmorID = sc.nextInt();
        while (selectedArmorID < 0 || selectedArmorID > 3) {
            System.out.println("You entered invalid number, please try again");
            selectedArmorID = sc.nextInt();
        }
        if(selectedArmorID == 0) {
                System.out.println("MAP");
        }
        else {
            selectedArmor = Armor.getArmorByID(selectedArmorID);

            if(selectedArmor != null) {
                if(selectedArmor.getPrice() > this.getPlayer().getCharacter().getMoney()) {
                    System.out.println("You haven't got enough money");
                    buyArmor();
                }
                else {
                    // buying
                    this.getPlayer().getCharacter().setMoney(this.getPlayer().getCharacter().getMoney() - selectedArmor.getPrice());
                    System.out.println("Your new money: " + this.getPlayer().getCharacter().getMoney());
                    System.out.println("item added your inventory");
                    // item add inventory
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Your new armor is: " + this.getPlayer().getInventory().getArmor().getItemName());
                    this.getPlayer().getCharacter().setArmor(selectedArmor.getBlocking());
                    System.out.println("Your new blocking: " + this.getPlayer().getCharacter().getArmor());
                }
            }
        }
        menu();
    }
}
