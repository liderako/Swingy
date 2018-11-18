package com.student.asvirido.swingy.module.monster.types.animal;

import com.student.asvirido.swingy.module.monster.Monster;
import com.student.asvirido.swingy.module.monster.MonsterBuilder;

public class BlackBear extends Monster {
    public BlackBear(int level) {
        super(new MonsterBuilder()
                .type("BlackBear")
                .attack(70 * level)
                .defence(25 * level)
                .hp(250 * level)
                .exp(750 / level)
        );
    }
}