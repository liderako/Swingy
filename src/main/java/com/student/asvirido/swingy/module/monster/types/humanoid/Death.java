package com.student.asvirido.swingy.module.monster.types.humanoid;

import com.student.asvirido.swingy.module.monster.Monster;
import com.student.asvirido.swingy.module.monster.MonsterBuilder;

public class Death extends Monster {
    public Death() {
        super(new MonsterBuilder()
                .type("Death")
                .attack(99999)
                .defence(9999)
                .hp(99999)
                .exp(0)
        );
    }
}