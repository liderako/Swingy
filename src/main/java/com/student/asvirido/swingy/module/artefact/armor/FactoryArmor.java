package com.student.asvirido.swingy.module.artefact.armor;

import com.student.asvirido.swingy.module.artefact.armor.types.*;

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
}
