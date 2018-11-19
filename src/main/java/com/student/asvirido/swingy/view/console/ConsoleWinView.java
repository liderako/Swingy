package com.student.asvirido.swingy.view.console;

import com.student.asvirido.swingy.module.artefact.armor.Armor;
import com.student.asvirido.swingy.module.artefact.armor.FactoryArmor;
import com.student.asvirido.swingy.module.artefact.helm.FactoryHelm;
import com.student.asvirido.swingy.module.artefact.helm.Helm;
import com.student.asvirido.swingy.module.artefact.weapon.FactoryWeapon;
import com.student.asvirido.swingy.module.artefact.weapon.Weapon;
import com.student.asvirido.swingy.module.hero.Hero;
import com.student.asvirido.swingy.module.monster.Monster;
import org.json.simple.JSONObject;

public class ConsoleWinView extends ConsoleView {
    public ConsoleWinView(String[] command) {
        super(command);
    }

    public String startView(final Hero hero, final Monster m, JSONObject typeArtefact, boolean loot) {
        System.out.println("You win.");
        System.out.println("You got " + m.getExp() + " exp.");

        if (loot) {
            System.out.println("_______________________________________");
            System.out.println("Hero Weapon: " + hero.getInventory().getWeapon().getType() + " - damage: " + hero.getInventory().getWeapon().getDamage());
            System.out.println("Hero Armor: " + hero.getInventory().getArmor().getType() + " - dafence: " + hero.getInventory().getArmor().getDefence());
            System.out.println("Hero Helm: " + hero.getInventory().getHelm().getType() + " - bonusHp:" + hero.getInventory().getHelm().getBonusHp());
            System.out.println("_______________________________________");
            System.out.println("Loot");
            System.out.println("_______________________________________");
            try {
                Object ob = (String) typeArtefact.get("Weapon");
                if (ob.equals("null")) {
                    throw new Exception("");
                }
                Weapon a = FactoryWeapon.newWeapon(ob.toString());
                System.out.println(a.getType() + ": damage " +  a.getDamage());
            }
            catch (Exception e) { }

            try {
                Object ob = (String) typeArtefact.get("Helm");
                if (ob.equals("null")) {
                    throw new Exception("");
                }
                Helm a = FactoryHelm.newHelm(ob.toString());
                System.out.println(a.getType() + ": bonusHp " +  a.getBonusHp());
            }
            catch (Exception e) { }

            try {
                Object ob = (String) typeArtefact.get("Armor");
                if (ob.equals("null")) {
                    throw new Exception("");
                }
                Armor a = FactoryArmor.newArmor(ob.toString());
                System.out.println(a.getType() + ": dafence " +  a.getDefence());
            }
            catch (Exception e) { }
            System.out.println("_______________________________________");
        }

        String s = input();
        return (s);
    }
}
