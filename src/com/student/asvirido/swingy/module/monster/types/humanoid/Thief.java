package com.student.asvirido.swingy.module.monster.types.humanoid;

import com.student.asvirido.swingy.module.monster.Monster;
import com.student.asvirido.swingy.module.monster.MonsterBuilder;

public class Thief extends Monster {
    public Thief() {
        super(new MonsterBuilder()
                .type("Thief")
                .attack(30)
                .defence(5)
                .hp(50)
                .exp(200)
        );
    }
}
