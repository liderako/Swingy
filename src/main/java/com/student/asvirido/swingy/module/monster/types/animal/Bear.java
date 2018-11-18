package com.student.asvirido.swingy.module.monster.types.animal;

import com.student.asvirido.swingy.module.monster.Monster;
import com.student.asvirido.swingy.module.monster.MonsterBuilder;

public class Bear extends Monster {
    public Bear(int level) {
        super(new MonsterBuilder()
                .type("Bear")
                .attack(70 * level)
                .defence(20 * level)
                .hp(200 * level)
                .exp(400 / level)
        );
    }
}
