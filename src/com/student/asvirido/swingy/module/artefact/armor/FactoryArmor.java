package com.student.asvirido.swingy.module.artefact.armor;

import com.student.asvirido.swingy.module.artefact.armor.types.*;

public class FactoryArmor {

    public Armor newArmor(String type) {
        if (type.equals("HeavyArmor")) {
            return (new HeavyArmor());
        }
        else if (type.equals("LightArmor")) {
            return (new LightArmor());
        }
        else if (type.equals("MediumArmor")) {
            return (new MediumArmor());
        }
        return (new Shirt());
    }
}
