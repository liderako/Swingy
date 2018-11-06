package com.student.asvirido.swingy.module.monster;

import com.student.asvirido.swingy.module.monster.types.animal.*;
import com.student.asvirido.swingy.module.monster.types.humanoid.*;

public class FactoryMonster {
    public Monster newMonster(String type) {
        if (type.equals("Bear")) {
            return (new Bear());
        }
        else if (type.equals("BlackBear")) {
            return (new BlackBear());
        }
        else if (type.equals("BlackWolf")) {
            return (new BlackWolf());
        }
        else if (type.equals("GrayWolf")) {
            return (new GrayWolf());
        }
        else if (type.equals("Spider")) {
            return (new Spider());
        }
        else if (type.equals("Tiger")) {
            return (new Tiger());
        }
        else if (type.equals("WhiteWolf")) {
            return (new WhiteWolf());
        }
        else if (type.equals("Wolf")) {
            return (new Wolf());
        }
        else if (type.equals("Goblin")) {
            return (new Goblin());
        }
        else if (type.equals("Ork")) {
            return (new Ork());
        }
        else if (type.equals("Thief")) {
            return (new Thief());
        }
        else if (type.equals("Death")) {
            return (new Death());
        }
        return (null);
    }
}
