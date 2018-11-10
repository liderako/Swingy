package com.student.asvirido.swingy.module.monster.types.animal;

import com.student.asvirido.swingy.module.monster.Monster;
import com.student.asvirido.swingy.module.monster.MonsterBuilder;

public class Spider extends Monster {
    public Spider() {
        super(new MonsterBuilder()
                .type("Spider")
                .attack(5)
                .defence(2)
                .hp(25)
                .exp(20)
        );
    }
}
