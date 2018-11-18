package com.student.asvirido.swingy.view.console;

import com.student.asvirido.swingy.module.hero.Hero;
import com.student.asvirido.swingy.module.monster.Monster;

public class ConsoleGameBattle extends ConsoleView {
    public ConsoleGameBattle() {
        super(new String[] {"Run", "Fight"});
    }

    public String startView(final Hero hero, final Monster monster) {
        System.out.println("___________________");
        System.out.println(hero.getName());
        System.out.println("Attack : " + hero.getAttack());
        System.out.println("Defence : " + hero.getDefence());
        System.out.println("Hp : " + hero.getHp() + "/" + hero.getMaxHp());
        System.out.println("Exp : " + hero.getExp() + "/" + hero.getNeedExp() );
        System.out.println("___________________");

        if (!monster.getType().equals("Death")) {
            System.out.println("Monster: " + monster.getType());
            System.out.println("Attack : " + monster.getAttack());
            System.out.println("Defence : " + monster.getDefence());
            System.out.println("Hp : " + monster.getHp());
            System.out.println("___________________");
        }
        String s = input();
        return (s);
    }
}
