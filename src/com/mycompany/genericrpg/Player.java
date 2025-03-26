package com.mycompany.genericrpg;

public class Player extends Entity {
    private String choice = "";
    private int wins = 0;

    // Constructor to initialize PlayerShinobi stats
    public Player() {
        this("Shinobi"); // Default name
        this.setClas("Shinobi");
        this.setLvl(1);
        this.setHp(100);
        this.setHpMax(100);
        this.setAtk(30);
        this.setHpMod(20);
        this.setAtkMod(5);
        this.setJutsu(1);
        this.setSkill(new int[]{1, 2, 1});
        this.setS1Name("Stealthy Strike");
        this.setS2Name("Shuriken Storm");
        this.setS3Name("Way of the Shinobi");
    }

    // Constructor with name
    public Player(String name) {
        this.setName(name);
        this.setClas("Shinobi");
        this.setLvl(1);
        this.setHp(100);
        this.setHpMax(100);
        this.setAtk(30);
        this.setHpMod(20);
        this.setAtkMod(5);
        this.setJutsu(1);
        this.setSkill(new int[]{1, 2, 1});
        this.setS1Name("Stealthy Strike");
        this.setS2Name("Shuriken Storm");
        this.setS3Name("Way of the Shinobi");
    }

    // Getters and Setters for the new attributes
    // (Inherited from Entity)

    // Existing getters and setters
    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public int getHealth() {
        return getHp(); // Use hp for current health
    }

    public void setHealth(int health) {
        setHp(health);
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void takeDamage(int damage) {
        this.setHp(this.getHp() - damage);
        if (this.getHp() < 0) {
            this.setHp(0);
        }
    }

    public void healHp(int healAmount) {
        this.setHp(this.getHp() + healAmount);
        if (this.getHp() > this.getHpMax()) {
            this.setHp(this.getHpMax());
        }
    }

    public void resetPlayer() {
        this.choice = "";
        this.setHp(this.getHpMax());
        this.wins = 0;
    }

    @Override
    public void skill1(Entity[] target) {
        System.out.println(getName() + " uses " + getS1Name() + "!");
        if (target != null && target.length > 0) {
            basicAttack(target[0]); // Placeholder for skill 1
        }
    }

    @Override
    public void skill2(Entity[] target) {
        System.out.println(getName() + " uses " + getS2Name() + "!");
        if (target != null && target.length > 0) {
            // Implement skill 2 logic here
            basicAttack(target[0]); // Placeholder for skill 2
        }
    }

    @Override
    public void skill3(Entity[] target) {
        System.out.println(getName() + " uses " + getS3Name() + "!");
        if (target != null && target.length > 0) {
            // Implement skill 3 logic here
            healHp(20); // Placeholder for skill 3 (heal)
            System.out.println(getName() + " heals for 20 HP!");
        }
    }
}