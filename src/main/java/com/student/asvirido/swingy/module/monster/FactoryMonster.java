package com.student.asvirido.swingy.module.monster;

import com.student.asvirido.swingy.module.monster.types.animal.*;
import com.student.asvirido.swingy.module.monster.types.humanoid.*;

import java.util.Random;

public class FactoryMonster {
    static public Monster newMonster(String type, int level) {
        try {
            switch (type) {
                case "Bear":
                    return (new Bear(level));
                case "BlackBear":
                    return (new BlackBear(level));
                case "GrayWolf":
                    return (new GrayWolf(level));
                case "BlackWolf":
                    return (new BlackWolf(level));
                case "Spider":
                    return (new Spider(level));
                case "Tiger":
                    return (new Tiger(level));
                case "WhiteWolf":
                    return (new WhiteWolf(level));
                case "Wolf":
                    return (new Wolf(level));
                case "Goblin":
                    return (new Goblin(level));
                case "Ork":
                    return (new Ork(level));
                case "Thief":
                    return (new Thief(level));
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

    static public String randomType() {
        int result = new Random().nextInt(12 - 1) + 1;

        switch (result) {
            case 1:
                return ("Bear");
            case 2:
                return ("BlackBear");
            case 3:
                return ("GrayWolf");
            case 4:
                return ("BlackWolf");
            case 5:
                return ("Spider");
            case 6:
                return ("Tiger");
            case 7:
                return ("WhiteWolf");
            case 8:
                return ("Wolf");
            case 9:
                return ("Goblin");
            case 10:
                return ("Ork");
            case 11:
                return ("Thief");
            case 12:
                return ("Death");
        }
        return ("Death");
    }
}