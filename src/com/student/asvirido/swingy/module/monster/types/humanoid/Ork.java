package com.student.asvirido.swingy.module.monster.types.humanoid;

import com.student.asvirido.swingy.module.monster.Monster;
import com.student.asvirido.swingy.module.monster.MonsterBuilder;

public class Ork extends Monster {
    public Ork() {
        super(new MonsterBuilder()
                .type("Ork")
                .attack(25)
                .defence(15)
                .hp(75)
                .exp(250)
        );
    }
}
