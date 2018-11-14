package com.student.asvirido.swingy.module.hero.types;

import com.student.asvirido.swingy.module.hero.Hero;
import com.student.asvirido.swingy.module.hero.HeroBuilder;
import com.student.asvirido.swingy.module.artefact.Inventory;

public class Monk extends Hero {
    public Monk(final String name) {
        super(new HeroBuilder()
                .name(name)
                .type("Monk")
                .attack(35)
                .defence(20)
                .hp(350)
                .maxHp(350)
                .experience(0)
                .level(1)
                .inventory(new Inventory())
        );
    }
}