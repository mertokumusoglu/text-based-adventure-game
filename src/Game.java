import player.Player;

import java.util.Scanner;

public class Game {
    Scanner sc = new Scanner(System.in);

    public void start() {
        System.out.println("Hello Adventurer, are you ready to join a new adventure?");
        System.out.print("Please enter your name: ");
        String playerName = sc.nextLine();

        Player player = new Player(playerName);
        System.out.println("Hi " + player.getPlayerName() + ", let's go on an adventure");
        System.out.println("You will win the game when you collect food, water and wood.");

        player.selectChar();
        player.printInfo();

    }
}