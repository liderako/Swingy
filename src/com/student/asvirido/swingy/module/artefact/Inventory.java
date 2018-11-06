package com.student.asvirido.swingy.module.artefact;

import com.student.asvirido.swingy.module.artefact.armor.Armor;
import com.student.asvirido.swingy.module.artefact.armor.types.Shirt;
import com.student.asvirido.swingy.module.artefact.helm.Helm;
import com.student.asvirido.swingy.module.artefact.helm.types.Hat;
import com.student.asvirido.swingy.module.artefact.weapon.Weapon;
import com.student.asvirido.swingy.module.artefact.weapon.types.Fist;

public class Inventory {
    private Armor armor;
    private Weapon weapon;
    private Helm helm;

    public Inventory() {
        armor = new Shirt();
        weapon = new Fist();
        helm = new Hat();
    }

    public void setArmor(final Armor armor) {
        this.armor = armor;
    }

    public void setWeapon(final Weapon weapon) {
        this.weapon = weapon;
    }

    public void setHelm(final Helm helm) {
        this.helm = helm;
    }

    public Armor getArmor() {
        return (this.armor);
    }

    public Weapon getWeapon() {
        return (this.weapon);
    }

    public Helm getHelm() {
        return (this.helm);
    }
}
