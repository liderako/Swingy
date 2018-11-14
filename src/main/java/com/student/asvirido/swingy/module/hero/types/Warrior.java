package com.student.asvirido.swingy.module.hero.types;

import com.student.asvirido.swingy.module.hero.Hero;
import com.student.asvirido.swingy.module.hero.HeroBuilder;
import com.student.asvirido.swingy.module.artefact.Inventory;

public class Warrior extends Hero {
    public Warrior(final String name) {
        super(new HeroBuilder()
                .name(name)
                .type("Warrior")
                .attack(20)
                .defence(50)
                .hp(500)
                .maxHp(500)
                .experience(0)
                .level(1)
                .inventory(new Inventory())
        );
    }
}
