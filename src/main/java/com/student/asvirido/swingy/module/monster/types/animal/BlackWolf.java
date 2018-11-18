package com.student.asvirido.swingy.module.monster.types.animal;

import com.student.asvirido.swingy.module.monster.Monster;
import com.student.asvirido.swingy.module.monster.MonsterBuilder;

public class BlackWolf extends Monster {
    public BlackWolf(int level) {
        super(new MonsterBuilder()
                .type("BlackWolf")
                .attack(60 * level)
                .defence(15 * level)
                .hp(250 * level)
                .exp(100 / level)
        );
    }
}
