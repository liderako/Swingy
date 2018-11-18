package com.student.asvirido.swingy.module.monster.types.humanoid;

import com.student.asvirido.swingy.module.monster.Monster;
import com.student.asvirido.swingy.module.monster.MonsterBuilder;

public class Death extends Monster {
    public Death() {
        super(new MonsterBuilder()
                .type("Death")
                .attack(0xFFFFFF)
                .defence(0xFFFFFF)
                .hp(0xFFFFFF)
                .exp(0)
        );
    }
}