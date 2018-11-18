package com.student.asvirido.swingy.module.monster.types.humanoid;

import com.student.asvirido.swingy.module.monster.Monster;
import com.student.asvirido.swingy.module.monster.MonsterBuilder;

public class Ork extends Monster {
    public Ork(int level) {
        super(new MonsterBuilder()
                .type("Ork")
                .attack(35 * level)
                .defence(25 * level)
                .hp(145 * level)
                .exp(250 / level)
        );
    }
}
