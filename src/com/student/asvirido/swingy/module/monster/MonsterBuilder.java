package com.student.asvirido.swingy.module.monster;

public class MonsterBuilder {
    private int attack;

    private int defence;

    private int exp;

    private int hp;

    private String type;

    public Monster build() {
        return (new Monster(this));
    }

    public MonsterBuilder attack(final int attack) {
        this.attack = attack;
        return (this);
    }

    public MonsterBuilder type(final String type) {
        this.type = type;
        return (this);
    }

    public MonsterBuilder defence(final int defence) {
        this.defence = defence;
        return (this);
    }

    public MonsterBuilder exp(final int exp) {
        this.exp = exp;
        return (this);
    }

    public MonsterBuilder hp(final int hp) {
        this.hp = hp;
        return (this);
    }

    public int getAttack() {
        return (attack);
    }

    public int getDefence() {
        return (defence);
    }

    public int getExp() {
        return (exp);
    }

    public int getHp() {
        return (hp);
    }
    public String getType() {
        return (type);
    }
}
