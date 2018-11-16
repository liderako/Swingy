package com.student.asvirido.swingy.view.console;

import com.student.asvirido.swingy.module.hero.FactoryHero;
import com.student.asvirido.swingy.module.hero.Hero;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleCreateHeroView extends ConsoleView {
    public ConsoleCreateHeroView() {
        super(new String[] {"Archer", "Warrior", "Monk", "Rogue"});
    }

    public String[] startView() {
        Hero[] hero = new Hero[]{
                FactoryHero.newHero("", "Warrior"),
                FactoryHero.newHero("", "Archer"),
                FactoryHero.newHero("", "Rogue"),
                FactoryHero.newHero("", "Monk")
        };

        for (Hero x : hero) {
            System.out.println("|Attributes hero: " + x.getType());
            System.out.println("|Attack: " + x.getAttack());
            System.out.println("|Defence: " + x.getDefence());
            System.out.println("|Hp: " + x.getHp());
            System.out.println("|_______________________|");
        }
        System.out.println("Input type hero");
        String type = input();
        String name = inputName();
        return (new String[] {"Create Hero", type, name});
    }

    private String inputName() {
        Scanner scanner = new Scanner(System.in);
        String      message;
        boolean     found = false;

        while (true) {
            System.out.println("Please write your name, only char and digital");
            message = scanner.nextLine();
            if ((message.matches("[A-Z_a-z_0-9]+"))) {
                break ;
            }
        }
        return (message);
    }
}
