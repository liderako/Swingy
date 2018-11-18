package com.student.asvirido.swingy.module.monster.types.animal;

import com.student.asvirido.swingy.module.monster.Monster;
import com.student.asvirido.swingy.module.monster.MonsterBuilder;

public class Spider extends Monster {
    public Spider(int level) {
        super(new MonsterBuilder()
                .type("Spider")
                .attack(10 * level)
                .defence(10 * level)
                .hp(25 * level)
                .exp(10 / level)
        );
    }
}
