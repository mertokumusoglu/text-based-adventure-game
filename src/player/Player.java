package player;

import items.Armor;
import items.Weapon;

import locations.*;
import java.util.Scanner;

public class Player {
    private String playerName;
    private Characters character;
    private Location location;
    private Inventory inventory;
    public boolean isExit = false;

    private Scanner sc = new Scanner(System.in);

    public Player(String playerName) {
        this.playerName = playerName;
        this.inventory = new Inventory();
    }

    public String getPlayerName() {
        return this.playerName;
    }
    public void setPlayerName(String newName) {
        this.playerName = newName;
        System.out.println("Player's new name is " + this.getPlayerName());
    }

    public Location getLocation() {
        return this.location;
    }

    public Characters getCharacter() {
        return this.character;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void selectChar() {
        Characters[] charList = {new Samurai(), new Archer(), new Knight()};
        for(int i = 0; i < charList.length; i++) {
            System.out.println("CharacterId: " + charList[i].getCharID() +
                    " | Character name: " + charList[i].getCharName() +
                    " | Attributes- Damage: " + charList[i].getDamage() +
                    " Health: " + charList[i].getHealth() +
                    " Money: " + charList[i].getMoney());
        }
        boolean selectedTrue;
        do {
            System.out.print("Let's select the character (write character id): ");
            int selected = sc.nextInt();
            switch (selected) {
                case 1:
                    selectedTrue = true;
                    this.character = new Samurai();
                    break;
                case 2:
                    selectedTrue = true;
                    this.character = new Archer();
                    break;
                case 3:
                    selectedTrue = true;
                    this.character = new Knight();
                    break;
                default:
                    selectedTrue = false;
                    System.out.println("you wrote wrong number, please write character id");
                    break;
            }

        } while(!selectedTrue);
    }

    public void printInfo() {
        System.out.println("That is your character's attributes: ");
        System.out.println("Name: " + this.getPlayerName() +
                "\nCharacter: " + character.getCharName() +
                "\nDamage: " + character.getDamage() +
                "\nHealth: " + character.getHealth() +
                "\nMoney: " + character.getMoney());
    }
    public void selectLocation() {
        //create inventory
        do {
            if(isExit) {
                System.out.println("See you later.");
                break;
            }

            System.out.println("-----------------------------------------------");
            System.out.println("Select the location you want to go: (write location id)");
            System.out.println("1 - Home\n2 - Shop\n3 - Cave! (food)\n4 - Forest! (wood)\n5 - River! (water)\n0 - Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 0:
                    isExit = true;
                    break;
                case 1:
                    this.location = new Home(this);
                    if(this.getInventory().isFood() && this.getInventory().isWater() && this.getInventory().isWood()) {
                        System.out.println("You collect all items and win the game");
                        isExit = true;
                    }
                    break;
                case 2:
                    this.location = new Shop(this);
                    break;
                case 3:
                    this.location = new Cave(this);
                    break;
                case 4:
                    this.location = new Forest(this);
                    break;
                case 5:
                    this.location = new River(this);
                    break;
                default:
                    System.out.println("The system automatically takes you home.");
                    this.location = new Home(this);
                    break;
            }

            if(isExit) {
                System.out.println("See you later.");
                break;
            }

        } while (location.onLocation());
    }
}