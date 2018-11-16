package com.student.asvirido.swingy.module.artefact.armor;

import com.student.asvirido.swingy.module.artefact.armor.types.*;

import java.util.Random;

public class FactoryArmor {
    static public Armor newArmor(String type) {
        try {
            switch (type) {
                case "HeavyArmor":
                    return (new HeavyArmor());
                case "LightArmor":
                    return (new LightArmor());
                case "MediumArmor":
                    return (new MediumArmor());
                case "Shirt":
                    return (new Shirt());
                default:
                    throw new Exception("unknown type armor");
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
                return ("HeavyArmor");
            case 2:
                return ("LightArmor");
            case 3:
                return ("MediumArmor");
        }
        return ("Shirt");
    }
}
