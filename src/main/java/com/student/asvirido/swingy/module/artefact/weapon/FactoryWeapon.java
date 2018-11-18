package com.student.asvirido.swingy.module.artefact.weapon;

import com.student.asvirido.swingy.module.artefact.weapon.types.*;

import java.util.Random;

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
                case "Knife":
                    return (new Knife());
                default:
                    throw new Exception("unknown type weapon");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (null);
    }

    static public String randomType() {
        int result = new Random().nextInt(4 - 1) + 1;

        switch (result) {
            case 1:
                return ("SwordWithShield");
            case 2:
                return ("Dagger");
            case 3:
                return ("Bow");
            case 4:
                return ("Knife");
        }
        return ("Fist");
    }
}
