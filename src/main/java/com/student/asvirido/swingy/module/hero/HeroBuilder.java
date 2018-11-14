package com.student.asvirido.swingy.module.hero;

import com.student.asvirido.swingy.module.artefact.Inventory;

public class HeroBuilder {
    private String name;
    private String type;
    private int hp;
    private int maxHp;
    private int attack;
    private int defence;
    private int experience;
    private int level;
    private Inventory inventory;

    public HeroBuilder name(final String name) {
        this.name = name;
        return (this);
    }

    public HeroBuilder type(final String type) {
        this.type = type;
        return (this);
    }

    public HeroBuilder hp(final int hp) {
        this.hp = hp;
        return (this);
    }

    public HeroBuilder maxHp(final int hp) {
        this.hp = hp;
        return (this);
    }

    public HeroBuilder attack(final int attack) {
        this.attack = attack;
        return (this);
    }

    public HeroBuilder defence(final int defence) {
        this.defence = defence;
        return (this);
    }

    public HeroBuilder experience(final int experience) {
        this.experience = experience;
        return (this);
    }

    public HeroBuilder level(final int level) {
        this.level = level;
        return (this);
    }

    public HeroBuilder inventory(Inventory inventory) {
        this.inventory = inventory;
        return (this);
    }

    public int getAttack() {
        return (attack);
    }

    public int getMaxHp() {
        return (maxHp);
    }

    public int getDefence() {
        return (defence);
    }

    public String getType() {
        return (type);
    }

    public int getExperience() {
        return (experience);
    }

    public int getHp() {
        return (hp);
    }

    public int getLevel() {
        return (level);
    }

    public Inventory getInventory() {
        return (inventory);
    }

    public String getName() {
        return (name);
    }

    public Hero build() {
        return (new Hero(this));
    }
}
