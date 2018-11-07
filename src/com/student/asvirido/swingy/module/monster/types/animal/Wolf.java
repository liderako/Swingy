package com.student.asvirido.swingy.module.monster.types.animal;

import com.student.asvirido.swingy.module.monster.Monster;
import com.student.asvirido.swingy.module.monster.MonsterBuilder;

public class Wolf extends Monster {
    public Wolf() {
        super(new MonsterBuilder()
                .type("Wolf")
                .attack(25)
                .defence(5)
                .hp(50)
                .exp(25)
        );
    }
}
