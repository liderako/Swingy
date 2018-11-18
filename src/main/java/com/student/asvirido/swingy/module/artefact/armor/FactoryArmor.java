package com.student.asvirido.swingy.module.artefact.armor;

import com.student.asvirido.swingy.module.artefact.armor.types.HeavyArmor;
import com.student.asvirido.swingy.module.artefact.armor.types.LightArmor;
import com.student.asvirido.swingy.module.artefact.armor.types.MediumArmor;
import com.student.asvirido.swingy.module.artefact.armor.types.Shirt;
import com.student.asvirido.swingy.module.artefact.armor.types.BedСover;

import java.util.Random;

public class FactoryArmor {
    static private int amountType = 5;

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
                case "BedCover":
                    return (new BedСover());
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
        int result = new Random().nextInt(amountType - 1) + 1;

        switch (result) {
            case 1:
                return ("HeavyArmor");
            case 2:
                return ("LightArmor");
            case 3:
                return ("MediumArmor");
            case 4:
                return ("BedCover");
        }
        return ("Shirt");
    }
}
