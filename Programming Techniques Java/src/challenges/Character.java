package challenges;

public class Character {

    private String name;
    private String type;
    private int health;
    private int power;
    private int specialAttackPower;
    private int speed;

    public Character(String name, String type, int power, int specialAttackPower, int speed){
        this.name = name;
        this.type = type;
        this.power = power;
        this.specialAttackPower = specialAttackPower;
        this.speed = speed;
        this.health = 100;
    }

    public void describe(){
        System.out.println("My name is " + name + " and I am a " + type);
        System.out.println("Stats:");
        System.out.println("Power: " + power);
        System.out.println("Special Attack Power: " + specialAttackPower);
        System.out.println("Speed: " + speed);
        System.out.println("Health: " + health);
    }

    public String getSummery(){
        return String.format("%s - T:%s, H:%d, P:%d, SP:%d, S:%d", name, type, health, power, specialAttackPower, speed);
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setSpecialAttackPower(int specialAttackPower) {
        this.specialAttackPower = specialAttackPower;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
