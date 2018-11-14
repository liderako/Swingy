package com.student.asvirido.swingy.module.artefact.helm;

import com.student.asvirido.swingy.module.artefact.helm.types.*;

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
}
