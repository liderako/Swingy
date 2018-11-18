package com.student.asvirido.swingy.module.monster.types.animal;

import com.student.asvirido.swingy.module.monster.Monster;
import com.student.asvirido.swingy.module.monster.MonsterBuilder;

public class Tiger extends Monster {
    public Tiger(int level) {
        super(new MonsterBuilder()
                .type("Tiger")
                .attack(60 * level)
                .defence(35 * level)
                .hp(150 * level)
                .exp(250 / level)
        );
    }
}
