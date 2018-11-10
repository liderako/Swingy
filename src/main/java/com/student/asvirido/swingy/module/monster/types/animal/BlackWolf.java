package com.student.asvirido.swingy.module.monster.types.animal;

import com.student.asvirido.swingy.module.monster.Monster;
import com.student.asvirido.swingy.module.monster.MonsterBuilder;

public class BlackWolf extends Monster {
    public BlackWolf() {
        super(new MonsterBuilder()
                .type("BlackWolf")
                .attack(20)
                .defence(5)
                .hp(75)
                .exp(50)
        );
    }
}
