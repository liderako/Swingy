package com.student.asvirido.swingy.module;

public class AliveObject extends GameObject {
    private int attack;
    private int defence;
    private int exp;
    private int hp;
    private int maxHp;

    public AliveObject(final String type) {
        super(type);
    }

    public int getAttack() {
        return (attack);
    }

    public int getDefence() {
        return (defence);
    }

    public int getMaxHp() {
        return (maxHp);
    }

    public int getExp() {
        return (exp);
    }

    public int getHp() {
        return (hp);
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }
}
