package com.student.asvirido.swingy.module.artefact.helm;

import com.student.asvirido.swingy.module.artefact.helm.types.*;

import java.util.Random;

public class FactoryHelm {
    static public  Helm newHelm(String type) {
        try {
            switch (type) {
                case "Hood":
                    return (new Hood());
                case "IronHelmet":
                    return (new IronHelmet());
                case "LeatherHelmet":
                    return (new LeatherHelmet());
                case "Hat":
                    return (new Hat());
                default:
                    throw new Exception("unknown type helm");
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
                return ("IronHelmet");
            case 2:
                return ("LeatherHelmet");
            case 3:
                return ("Hood");
        }
        return ("Hat");
    }
}
