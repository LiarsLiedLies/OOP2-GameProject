package com.mycompany.genericrpg;
import java.util.*;

// Superclass for Enemy.java and Player.java
abstract class Entity {
    public static final Random rand = new Random();

    // Different stats used by the Combat class
    private int lvl;
    private String name;
    private int hp;
    private int hpMax;
    private int hpMod;
    private int atk;
    private int atkMod;
    private int jutsu;
    private String clas;
    private int aegis;
    private int taunt;
    private int dodge;

    private int[] skill;
    private String s1Name;
    private String s2Name;
    private String s3Name;


    // SetterGetters ////////////////////////
    public int getLvl() {
        return lvl;
    }
    public void setLvl(int lvl) {
        this.lvl = lvl;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getHpMax() {
        return hpMax;
    }
    public void setHpMax(int hpMax) {
        this.hpMax = hpMax;
    }
    public int getHpMod() {
        return hpMod;
    }
    public void setHpMod(int hpMod) {
        this.hpMod = hpMod;
    }
    public int getAtk() {
        return atk;
    }
    public void setAtk(int atk) {
        this.atk = atk;
    }
    public int getAtkMod() {
        return atkMod;
    }
    public void setAtkMod(int atkMod) {
        this.atkMod = atkMod;
    }
    public int getJutsu() {
        return jutsu;
    }
    public void setJutsu(int jutsu) {
        this.jutsu = jutsu;
    }
    public int getAegis() {
        return aegis;
    }
    public void setAegis(int aegis) {
        this.aegis = aegis;
    }
    public int getTaunt() {
        return taunt;
    }
    public void setTaunt(int taunt) {
        this.taunt = taunt;
    }
    public int getDodge() {
        return dodge;
    }
    public void setDodge(int dodge) {
        this.dodge = dodge;
    }
    public int[] getSkill() {
        return skill;
    }
    public void setSkill(int[] skill) {
        this.skill = skill;
    }
    public String getS1Name() {
        return s1Name;
    }
    public void setS1Name(String s1Name) {
        this.s1Name = s1Name;
    }
    public String getS2Name() {
        return s2Name;
    }
    public void setS2Name(String s2Name) {
        this.s2Name = s2Name;
    }
    public String getS3Name() {
        return s3Name;
    }
    public void setS3Name(String s3Name) {
        this.s3Name = s3Name;
    }
    public String getClas() {
        return clas;
    }
    public void setClas(String clas) {
        this.clas = clas;
    }
    // End of SetterGetters ////////////////////////

    // Increment the entity's LVL by 1, then increase hpMax and atk values
    public void lvlUp() {
        lvl += 1;
        hpMax += 10 * (lvl-1) + ( hpMod * lvl );
        atk += 5 * (lvl-1) + ( atkMod * lvl );
    }

    // takeDmg Method that takes an int parameter then reduces hp by that variable
    // if hp goes below 0, set to 0
    // if dodge > 0, dont take damage, and reduce dodge by 1
    public void takeDmg(int dmg) {
        if(dodge>=1){
            System.out.println("But "+ name + " dodged the attack!");
            dodge--;
        }
        else{
            hp -= dmg;
            if(hp <0)
                hp = 0;
        }
    }

    // same as above method, but for heals
    public void healHp(int heal) {
        hp += heal;
        if(hp > hpMax)
            hp = hpMax;
    }

    // Method that takes an int parameter "dmg", then gives it a 10% variance
    // then returns the new damage value
    public int dmgVariance(int dmg) {
        float newDamage = ( dmg * (rand.nextFloat() * 0.2f - 0.1f) ) + dmg;
        return (int)newDamage;
    }

    // boolean method that returns true if this entity is alive
    public boolean isAlive() {
        return hp > 0;
    }

    // method that reduces aegis and taunt variables by 1
    // used in Combat.java to remove these status effects at the start of a turn
    public void reduceAegisAndTaunt() {
        if(aegis>0)
            aegis--;
        if(taunt>0)
            taunt--;
    }

    // Method for the basic attack that all entities can use
    // Simply takes the entity's atk, gives it a 10% variance, then deals that damage
    // to an enemy target via parameter
    public void basicAttack(Entity target) {
        int dmg = dmgVariance(atk);
        if(target.getAegis()>0)
            dmg /= 2;
        System.out.println(name + " attacks " + target.getName() + " for " + dmg + " damage!");
        if(getAegis()>0) {
            System.out.println(target.getName()+"'s Aegis reflects damage back!");
            System.out.println(getName() + " takes " + dmg + " damage!");
            takeDmg(dmg);
        }
        target.takeDmg(dmg);
    }

    // Only skill1 is abstracted because some Entities do not have a 2nd or 3rd skill
    public void skill1(Entity[] target) {
        // Default skill 1 behavior, perhaps a basic attack?
        if (target != null && target.length > 0) {
            basicAttack(target[0]); // Attack the first target by default
        } else {
            System.out.println(name + " used a skill, but nothing happened.");
        }
    }

    public void skill2(Entity[] target) {
        System.out.println("Nothing happen!");
    }

    public void skill3(Entity[] target) {
        System.out.println("Nothing happen!");
    }
}