package com.student.asvirido.swingy.module.monster.types.animal;

import com.student.asvirido.swingy.module.monster.Monster;
import com.student.asvirido.swingy.module.monster.MonsterBuilder;

public class Wolf extends Monster {
    public Wolf(int level) {
        super(new MonsterBuilder()
                .type("Wolf")
                .attack(25 * level)
                .defence(5 * level)
                .hp(100 * level)
                .exp(25 / level)
        );
    }
}
