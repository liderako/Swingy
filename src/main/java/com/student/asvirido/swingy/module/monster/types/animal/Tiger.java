package com.student.asvirido.swingy.module.monster.types.animal;

import com.student.asvirido.swingy.module.monster.Monster;
import com.student.asvirido.swingy.module.monster.MonsterBuilder;

public class Tiger extends Monster {
    public Tiger() {
        super(new MonsterBuilder()
                .type("Tiger")
                .attack(30)
                .defence(5)
                .hp(35)
                .exp(250)
        );
    }
}
