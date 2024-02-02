package player;

import locations.*;
import java.util.Scanner;

public class Player {
    private String playerName;
    private Characters character;
    private Location location;
    private Scanner sc = new Scanner(System.in);

    public Player(String playerName) {
        this.playerName = playerName;
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

    public void selectChar() {
        Characters[] charList = {new Samurai(), new Archer(), new Knight()};
        for(int i = 0; i < charList.length; i++) {
            System.out.println("CharacterId: " + charList[i].getCharID() +
                    " | Character name: " + charList[i].getCharName() +
                    " | Attributes; Damage: " + charList[i].getDamage() +
                    " Health: " + charList[i].getHealth() +
                    " Money: " + charList[i].getMoney());
        }
        boolean selectedTrue;
        do {
            System.out.print("Let's select the character (write character id: ");
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
        System.out.println("that is your character's attributes: ");
        System.out.println("Name: " + this.getPlayerName() +
                "\nCharacter: " + character.getCharName() +
                "\nDamage: " + character.getDamage() +
                "\nHealth: " + character.getHealth() +
                "\nMoney: " + character.getMoney());
    }
    public void selectLocation() {
        System.out.println("selecting location");
    }
}
