package com.student.asvirido.swingy.module.monster.types.animal;

import com.student.asvirido.swingy.module.monster.Monster;
import com.student.asvirido.swingy.module.monster.MonsterBuilder;

public class BlackBear extends Monster {
    public BlackBear() {
        super(new MonsterBuilder()
                .type("BlackBear")
                .attack(35)
                .defence(15)
                .hp(100)
                .exp(750)
        );
    }
}