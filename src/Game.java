import player.Player;

import java.util.Scanner;

public class Game {
    Scanner sc = new Scanner(System.in);

    public void start() {
        System.out.println("Hello Adventurer, are you ready to join a new adventure?");
        System.out.print("Please enter your name: ");
        String playerName = sc.nextLine();

        Player player = new Player(playerName);
        System.out.println("Hi " + player.getPlayerName() + ", let's go on an adventure!");
        System.out.println("You will win the game when you collect food, water and wood and returned home. " +
                "\nYou have to go to 3 different area in the map and collect items." +
                "\nThere is a store in the map where you can strengthen yourself, you can go there and buy things whenever you want" +
                "\nAnd there is a home in the map, when you go to your home your health will be full." +
                "\nATTENTION '!' Locations are war locations. Be careful.");

        System.out.println("-------------------- Characters --------------------");
        player.selectChar();
        player.printInfo();

        player.selectLocation();
    }
}