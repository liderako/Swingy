package com.student.asvirido.swingy.module.artefact.weapon;

import com.student.asvirido.swingy.module.artefact.weapon.types.*;

public class FactoryWeapon {
    public Weapon newArmor(String type) {
        if (type.equals("Bow")) {
            return (new Bow());
        }
        else if (type.equals("Dagger")) {
            return (new Dagger());
        }
        else if (type.equals("SwordWithShield")) {
            return (new SwordWithShield());
        }
        return (new Fist());
    }
}
