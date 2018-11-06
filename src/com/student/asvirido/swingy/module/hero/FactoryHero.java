package com.student.asvirido.swingy.module.hero;

import com.student.asvirido.swingy.module.hero.types.Archer;
import com.student.asvirido.swingy.module.hero.types.Monk;
import com.student.asvirido.swingy.module.hero.types.Rogue;
import com.student.asvirido.swingy.module.hero.types.Warrior;

public class FactoryHero {
    public Hero newHero(final String name, final String type) {
        if (type.equals("Archer")) {
            return (new Archer(name));
        }
        else if (type.equals("Monk")) {
            return (new Monk(name));
        }
        else if (type.equals("Rogue")) {
            return (new Rogue(name));
        }
        else if (type.equals("Warrior")) {
            return (new Warrior(name));
        }
        return (null);
    }
}
