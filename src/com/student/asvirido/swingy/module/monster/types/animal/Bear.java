package com.student.asvirido.swingy.module.monster.types.animal;

import com.student.asvirido.swingy.module.monster.Monster;
import com.student.asvirido.swingy.module.monster.MonsterBuilder;

public class Bear extends Monster {
    public Bear() {
        super(new MonsterBuilder()
                .type("Bear")
                .attack(35)
                .defence(10)
                .hp(100)
                .exp(500)
        );
    }
}
