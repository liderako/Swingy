package com.student.asvirido.swingy.module.hero.types;

import com.student.asvirido.swingy.module.hero.FactoryHero;
import com.student.asvirido.swingy.module.hero.Hero;
import com.student.asvirido.swingy.module.hero.HeroBuilder;
import com.student.asvirido.swingy.module.artefact.Inventory;

public class Archer extends Hero {
    public Archer(final String name) {
        super(new HeroBuilder()
                .name(name)
                .type("Archer")
                .attack(40)
                .defence(25)
                .hp(200)
                .experience(0)
                .level(1)
                .inventory(new Inventory())
        );
    }
}

