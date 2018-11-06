package com.student.asvirido.swingy.module.monster;

import com.student.asvirido.swingy.module.AliveObject;

public class Monster extends AliveObject {
    public Monster(final MonsterBuilder m) {
        super(m.getType());
        this.setAttack(m.getAttack());
        this.setDefence(m.getDefence());
        this.setExp(m.getExp());
        this.setHp(m.getHp());
        this.setMaxHp(m.getHp());
    }
}
