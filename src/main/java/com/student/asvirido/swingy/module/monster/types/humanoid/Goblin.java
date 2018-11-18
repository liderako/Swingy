package com.student.asvirido.swingy.module.monster.types.humanoid;

import com.student.asvirido.swingy.module.monster.Monster;
import com.student.asvirido.swingy.module.monster.MonsterBuilder;

public class Goblin extends Monster {
    public Goblin(int level) {
        super(new MonsterBuilder()
                .type("Goblin")
                .attack(10 * level)
                .defence(5 * level)
                .hp(25 * level)
                .exp(50 / level)
        );
    }
}
