package com.student.asvirido.swingy.module.monster.types.animal;

import com.student.asvirido.swingy.module.monster.Monster;
import com.student.asvirido.swingy.module.monster.MonsterBuilder;

public class WhiteWolf extends Monster {
    public WhiteWolf() {
        super(new MonsterBuilder()
                .type("WhiteWolf")
                .attack(25)
                .defence(5)
                .hp(100)
                .exp(250)
        );
    }
}
