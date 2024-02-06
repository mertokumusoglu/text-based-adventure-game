package player;

public abstract class Characters {
    private String charName;
    private int charID;
    private int damage;
    private int armor;
    private int health;
    private int money;
    private int firstHealth;

    public Characters(String charName, int charID, int damage,int armor ,int health, int money) {
        this.charName = charName;
        this.charID = charID;
        this.damage = damage;
        this.armor = armor;
        this.health = health;
        this.money = money;
        this.firstHealth = health;
    }

    // CHAR METHODS
    public String getCharName() {
        return this.charName;
    }
    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getCharID() {
        return charID;
    }
    public void setCharID(int charID) {
        this.charID = charID;
    }

    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getArmor() {
        return armor;
    }
    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        if(health < 0) {
            health = 0;
        }
        this.health = health;
    }

    public int getFirstHealth() {
        return firstHealth;
    }
    public void setFirstHealth(int firstHealth) {
        this.firstHealth = firstHealth;
    }

    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
}