package com.mycompany.genericrpg;

import java.util.Random;

class Enemy extends Entity {
    private String enemyType; // To identify the specific type of enemy

    // Constructor for Minion Shinobi
    public Enemy(String name) {
        super(); // Call the Entity constructor
        this.enemyType = "Minion_Shinobi";
        setName(name);
        setHp(100);
        setHpMax(100);
        setAtk(30);
        setJutsu(1);
        setSkill(new int[]{1}); // Assuming skill index 1 corresponds to their skill
        setS1Name("Not-As-Stealthy Strike");
    }

    // Constructor for Minion Warrior
    public Enemy(String name, String type) {
        super();
        this.enemyType = "Minion_Warrior";
        setName(name);
        setHp(120);
        setHpMax(120);
        setAtk(35);
        setJutsu(1);
        setSkill(new int[]{1});
        setS1Name("Road Rage");
    }

    // Constructor for Minion Wildcat
    public Enemy(String name, String type, int extra) {
        super();
        this.enemyType = "Minion_Wildcat";
        setName(name);
        setHp(90);
        setHpMax(90);
        setAtk(40);
        setJutsu(1);
        setSkill(new int[]{1});
        setS1Name("MissionVision");
    }

    // You can add more constructors for other enemy types (including bosses)
    // For example, for a boss:
    public Enemy(String name, String type, int hp, int atk, int jutsu, int[] skills, String s1Name, String s2Name, String s3Name) {
        super();
        this.enemyType = type;
        setName(name);
        setHp(hp);
        setHpMax(hp);
        setAtk(atk);
        setJutsu(jutsu);
        setSkill(skills);
        setS1Name(s1Name);
        setS2Name(s2Name);
        setS3Name(s3Name);
    }

    public String getEnemyType() {
        return enemyType;
    }

    @Override
    public void skill1(Entity[] target) {
        switch (enemyType) {
            case "Minion_Shinobi":
                System.out.println(getName() + " tiptoes a bit before attacking!");
                for (Entity t : target) {
                    int dmg = (int) (getAtk() * 1.2f);
                    dmg = dmgVariance(dmg);
                    if (t.getAegis() > 0) dmg /= 2;
                    System.out.println(getName() + " not-so-stealthily attacks " + t.getName() + " for " + dmg + " damage!");
                    if (t.getAegis() > 0) {
                        System.out.println(t.getName() + "'s Aegis reflects damage back!");
                        System.out.println(getName() + " takes " + dmg + " damage!");
                        takeDmg(dmg);
                    }
                    t.takeDmg(dmg);
                }
                break;
            case "Minion_Warrior":
                System.out.println(getName() + " gets in a car and attempts to run over you!");
                for (Entity t : target) {
                    int dmg = (int) (getAtk() * 1.5f);
                    dmg = dmgVariance(dmg);
                    if (t.getAegis() > 0) dmg /= 2;
                    System.out.println(getName() + " (and car) ram into " + t.getName() + " for " + dmg + " damage!");
                    if (t.getAegis() > 0) {
                        System.out.println(t.getName() + "'s Aegis reflects damage back!");
                        System.out.println(getName() + " takes " + dmg + " damage!");
                        takeDmg(dmg);
                    }
                    t.takeDmg(dmg);
                }
                break;
            case "Minion_Wildcat":
                System.out.println(getName() + " recites the Mission-Vision!");
                for (Entity t : target) {
                    int dmg = (int) (getAtk() * 1.75f);
                    dmg = dmgVariance(dmg);
                    if (t.getAegis() > 0) dmg /= 2;
                    System.out.println("Mission deals " + t.getName() + " for " + dmg + " damage!");
                    if (t.getAegis() > 0) {
                        System.out.println(t.getName() + "'s Aegis reflects damage back!");
                        System.out.println(getName() + " takes " + dmg + " damage!");
                        takeDmg(dmg);
                    }
                    t.takeDmg(dmg);
                    dmg = (int) (getAtk() * 1.75f);
                    dmg = dmgVariance(dmg);
                    if (t.getAegis() > 0) dmg /= 2;
                    System.out.println("Vision deals " + t.getName() + " for " + dmg + " damage!");
                    if (t.getAegis() > 0) {
                        System.out.println(t.getName() + "'s Aegis reflects damage back!");
                        System.out.println(getName() + " takes " + dmg + " damage!");
                        takeDmg(dmg);
                    }
                    t.takeDmg(dmg);
                }
                break;
            // Add cases for other enemy types and their skill 1 implementations
            default:
                super.skill1(target); // Default behavior if type is not recognized
                break;
        }
    }

    // You'll need to override skill2 and skill3 similarly if different enemy types have unique skills
    @Override
    public void skill2(Entity[] target) {
        // Implement skill 2 based on enemyType
        super.skill2(target);
    }

    @Override
    public void skill3(Entity[] target) {
        // Implement skill 3 based on enemyType
        super.skill3(target);
    }
}