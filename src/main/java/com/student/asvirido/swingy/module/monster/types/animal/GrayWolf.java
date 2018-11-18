package com.student.asvirido.swingy.module.monster.types.animal;

import com.student.asvirido.swingy.module.monster.Monster;
import com.student.asvirido.swingy.module.monster.MonsterBuilder;

public class GrayWolf extends Monster {
    public GrayWolf(int level) {
        super(new MonsterBuilder()
                .type("GrayWolf")
                .attack(50 * level)
                .defence(25 * level)
                .hp(150 * level)
                .exp(50 / level)
        );
    }
}
