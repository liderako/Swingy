package com.student.asvirido.swingy.module.artefact;

import com.student.asvirido.swingy.module.artefact.armor.Armor;
import com.student.asvirido.swingy.module.artefact.armor.FactoryArmor;
import com.student.asvirido.swingy.module.artefact.helm.FactoryHelm;
import com.student.asvirido.swingy.module.artefact.helm.Helm;
import com.student.asvirido.swingy.module.artefact.weapon.FactoryWeapon;
import com.student.asvirido.swingy.module.artefact.weapon.Weapon;

public class InventoryBuilder {
    private Weapon weapon;
    private Armor armor;
    private Helm helm;

    public InventoryBuilder weapon(final String typeWeapon) {
        this.weapon = FactoryWeapon.newWeapon(typeWeapon);
        return (this);
    }

    public InventoryBuilder armor(final String typeArmor) {
        this.armor = FactoryArmor.newArmor(typeArmor);
        return (this);
    }

    public InventoryBuilder helm(final String typeHelm) {
        this.helm = FactoryHelm.newHelm(typeHelm);
        return (this);
    }

    public Armor getArmor() {
        return (armor);
    }

    public Weapon getWeapon() {
        return (weapon);
    }

    public Helm getHelm() {
        return (helm);
    }

    public Inventory build() {
        return (new Inventory(this));
    }
}
