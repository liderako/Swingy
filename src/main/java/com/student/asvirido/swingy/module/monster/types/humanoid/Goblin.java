package com.student.asvirido.swingy.module.monster.types.humanoid;

import com.student.asvirido.swingy.module.monster.Monster;
import com.student.asvirido.swingy.module.monster.MonsterBuilder;

public class Goblin extends Monster {
    public Goblin() {
        super(new MonsterBuilder()
                .type("Goblin")
                .attack(10)
                .defence(5)
                .hp(25)
                .exp(50)
        );
    }
}
