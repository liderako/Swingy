package com.student.asvirido.swingy.module.hero.types;

import com.student.asvirido.swingy.module.hero.Hero;
import com.student.asvirido.swingy.module.hero.HeroBuilder;
import com.student.asvirido.swingy.module.artefact.Inventory;

public class Rogue extends Hero {
    public Rogue(final String name) {
        super(new HeroBuilder()
                .name(name)
                .type("Rogue")
                .attack(45)
                .defence(10)
                .hp(150)
                .maxHp(150)
                .experience(0)
                .level(1)
                .inventory(new Inventory())
        );
    }
}