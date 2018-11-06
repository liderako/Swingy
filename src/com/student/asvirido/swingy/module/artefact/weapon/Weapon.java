package com.student.asvirido.swingy.module.artefact.weapon;

import com.student.asvirido.swingy.module.GameObject;

public class Weapon extends GameObject{
    private final int damage;

    public Weapon(final int damage, final String type) {
        super(type);
        this.damage = damage;
    }

    public int getDamage() {
        return (this.damage);
    }
}
