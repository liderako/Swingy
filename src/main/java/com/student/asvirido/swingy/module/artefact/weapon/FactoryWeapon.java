package com.student.asvirido.swingy.module.artefact.weapon;

import com.student.asvirido.swingy.module.artefact.weapon.types.*;

public class FactoryWeapon {
    public static Weapon newWeapon(String type) {
        try {
            switch (type) {
                case "Fist":
                    return (new Fist());
                case "SwordWithShield":
                    return (new SwordWithShield());
                case "Dagger":
                    return (new Dagger());
                case "Bow":
                    return (new Bow());
                default:
                    throw new Exception("unknown type weapon");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (null);
    }
}
