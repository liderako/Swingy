package com.student.asvirido.swingy.module.monster.types.animal;

import com.student.asvirido.swingy.module.monster.Monster;
import com.student.asvirido.swingy.module.monster.MonsterBuilder;

public class WhiteWolf extends Monster {
    public WhiteWolf(int level) {
        super(new MonsterBuilder()
                .type("WhiteWolf")
                .attack(55 * level)
                .defence(55 * level)
                .hp(250 * level)
                .exp(250 / level)
        );
    }
}
