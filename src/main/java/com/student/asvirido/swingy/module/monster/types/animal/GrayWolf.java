package com.student.asvirido.swingy.module.monster.types.animal;

import com.student.asvirido.swingy.module.monster.Monster;
import com.student.asvirido.swingy.module.monster.MonsterBuilder;

public class GrayWolf extends Monster {
    public GrayWolf() {
        super(new MonsterBuilder()
                .type("GrayWolf")
                .attack(20)
                .defence(5)
                .hp(50)
                .exp(50)
        );
    }
}
