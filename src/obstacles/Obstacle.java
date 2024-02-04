package obstacles;

public abstract class Obstacle {
    private String obstacleName;
    private int obstacleID;
    private int obstacleDamage;
    private int obstacleHealth;
    private int obstacleMoney;

    public Obstacle(String obstacleName, int obstacleID, int obstacleDamage, int obstacleHealth, int obstacleMoney) {
        this.obstacleName = obstacleName;
        this.obstacleID = obstacleID;
        this.obstacleDamage = obstacleDamage;
        this.obstacleHealth = obstacleHealth;
        this.obstacleMoney = obstacleMoney;
    }

    public String getObstacleName() {
        return obstacleName;
    }
    public void setObstacleName(String obstacleName) {
        this.obstacleName = obstacleName;
    }

    public int getObstacleID() {
        return this.obstacleID;
    }
    public void setObstacleID(int obstacleID) {
        this.obstacleID = obstacleID;
    }

    public int getObstacleDamage() {
        return obstacleDamage;
    }
    public void setObstacleDamage(int obstacleDamage) {
        this.obstacleDamage = obstacleDamage;
    }

    public int getObstacleHealth() {
        return obstacleHealth;
    }
    public void setObstacleHealth(int obstacleHealth) {
        this.obstacleHealth = obstacleHealth;
    }

    public int getObstacleMoney() {
        return obstacleMoney;
    }
    public void setObstacleMoney(int obstacleMoney) {
        this.obstacleMoney = obstacleMoney;
    }
}
