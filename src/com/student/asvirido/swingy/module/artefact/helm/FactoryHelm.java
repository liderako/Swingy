package com.student.asvirido.swingy.module.artefact.helm;

import com.student.asvirido.swingy.module.artefact.helm.types.*;

public class FactoryHelm {
    public Helm newHelm(String type) {
        if (type.equals("Hood")) {
            return (new Hood());
        }
        else if (type.equals("IronHelmet")) {
            return (new IronHelmet());
        }
        else if (type.equals("LeatherHelmet")) {
            return (new LeatherHelmet());
        }
        return (new Hat());
    }
}
