package com.student.asvirido.swingy.module.monster;

import com.student.asvirido.swingy.module.monster.types.animal.*;
import com.student.asvirido.swingy.module.monster.types.humanoid.*;

public class FactoryMonster {
    static public Monster newMonster(String type) {
        try {
            switch (type) {
                case "Bear":
                    return (new Bear());
                case "BlackBear":
                    return (new BlackBear());
                case "GrayWolf":
                    return (new GrayWolf());
                case "BlackWolf":
                    return (new BlackWolf());
                case "Spider":
                    return (new Spider());
                case "Tiger":
                    return (new Tiger());
                case "WhiteWolf":
                    return (new WhiteWolf());
                case "Wolf":
                    return (new Wolf());
                case "Goblin":
                    return (new Goblin());
                case "Ork":
                    return (new Ork());
                case "Thief":
                    return (new Thief());
                case "Death":
                    return (new Death());
                default: throw new Exception("unknown type monster");
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return (null);
    }
}