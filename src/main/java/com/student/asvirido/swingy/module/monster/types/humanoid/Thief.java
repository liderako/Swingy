package com.student.asvirido.swingy.module.monster.types.humanoid;

import com.student.asvirido.swingy.module.monster.Monster;
import com.student.asvirido.swingy.module.monster.MonsterBuilder;

public class Thief extends Monster {
    public Thief(int level) {
        super(new MonsterBuilder()
                .type("Thief")
                .attack(70 * level)
                .defence(15 * level)
                .hp(200 * level)
                .exp(200 / level)
        );
    }
}
