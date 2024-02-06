package locations;

import player.*;
import obstacles.*;
import java.util.Scanner;
import java.util.Random;

public abstract class BattleLoc extends Location{
    private Obstacle obstacle;
    Scanner sc = new Scanner(System.in);
    Random random = new Random();

    public BattleLoc(Player player, String locName, int locID, Obstacle obstacle) {
        super(player, locName, locID);
        this.obstacle = obstacle;
    }

    @Override
    public boolean onLocation() {
        return true;
    }
    public void fight() {
        // randomObstacleCount
        int obstacleCount;
        obstacleCount = random.nextInt(1,4);
        System.out.println("You are in the " + this.getPlayer().getLocation().getLocName() + " with " + obstacleCount + " "  + this.getObstacle().getObstacleName());

        System.out.print("do you want to fight (f) or run (r): ");
        String choice = sc.nextLine();
        if(choice.equals("r")) {
            System.out.println("System takes you map");
        }
        else if(choice.equals("f")){
            //battle
            for(int i = 1; i <= obstacleCount; i++) {
                while(this.getPlayer().getCharacter().getHealth() > 0 && this.obstacle.getObstacleHealth() > 0) {
                    System.out.println("Hit (h) or run (r): ");
                    String selectCombat = sc.nextLine();
                    if(selectCombat.equals("h")) {
                        System.out.println("You are hitting.!");
                        this.obstacle.setObstacleHealth(this.obstacle.getObstacleHealth() - this.getPlayer().getCharacter().getTotalDamage());
                        System.out.println("You hit " + this.getPlayer().getCharacter().getTotalDamage());
                        System.out.println("Opponent health: " + this.obstacle.getObstacleHealth());
                    }
                    else if(selectCombat.equals("r")) {
                        System.out.println("You running, System takes you map");
                        this.getPlayer().selectLocation();
                        break;
                    }
                    System.out.println(this.obstacle.getObstacleName() + " is hitting: " + (this.obstacle.getObstacleDamage() - this.getPlayer().getCharacter().getArmor()));
                    this.getPlayer().getCharacter().setHealth(this.getPlayer().getCharacter().getHealth() - (this.obstacle.getObstacleDamage() - this.getPlayer().getCharacter().getArmor()));
                    System.out.println("Your health: " + this.getPlayer().getCharacter().getHealth());

                    if(this.getPlayer().getCharacter().getHealth() <= 0) {
                        System.out.println("You died. TRY AGAIN");
                        this.getPlayer().isExit = true;
                        break;
                    }
                }
                while (getPlayer().isExit == false) {
                    this.obstacle.setObstacleHealth(this.obstacle.getObstacleBeginningHealth());
                    System.out.println("if exist, Another " + this.obstacle.getObstacleName());
                    break;
                }
                this.getPlayer().getCharacter().setMoney(this.getPlayer().getCharacter().getMoney() + this.obstacle.getObstacleMoney());
                System.out.println("You killed 1 " + this.obstacle.getObstacleName() + ". Your new money is: " + this.getPlayer().getCharacter().getMoney());
            }
            while (this.getPlayer().getCharacter().getHealth() > 0) {
                System.out.println("You kill all the " + this.obstacle.getObstacleName()+ "s");
                if(this.obstacle.getObstacleName().equals("Zombie")) {
                    this.getPlayer().getInventory().setFood(true);
                    System.out.println("YOU COLLECT FOOD.");
                    break;
                }
                else if(this.obstacle.getObstacleName().equals("Vampire")) {
                    this.getPlayer().getInventory().setWood(true);
                    System.out.println("YOU COLLET WOOD.");
                    break;
                }
                else if(this.obstacle.getObstacleName().equals("Bear")) {
                    this.getPlayer().getInventory().setWater(true);
                    System.out.println("YOU COLLECT WATER");
                    break;
                }
            }
        }
        else {
            System.out.println("Invalid number, system takes you main menu");
        }
    }

    public Obstacle getObstacle() {
        return obstacle;
    }
    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }
}
