package com.student.asvirido.swingy.module.hero;

import com.student.asvirido.swingy.module.hero.types.*;

public class FactoryHero {
    static public Hero newHero(final String name, final String type) {
        try {
            switch (type) {
                case "Archer":
                    return (new Archer(name));
                case "Monk":
                    return (new Monk(name));
                case "Rogue":
                    return (new Rogue(name));
                case "Warrior":
                    return (new Warrior(name));
                default:
                    throw new Exception("unknown type hero");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (null);
    }
}
