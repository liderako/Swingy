package com.student.asvirido.swingy.view.console;

import com.student.asvirido.swingy.module.hero.Hero;

import java.util.ArrayList;

public class ConsoleSelectView extends ConsoleView {
    public ConsoleSelectView(String[] command) {
        super( command );
    }

    public String[] startView(Hero[] hero) {
        System.out.println("Please select hero");
        System.out.println("____________________");
        for (Hero x : hero){
            x.log();
            System.out.println("____________________");
        }
        String s = input();
        return (new String[] {"game", s});
    }
}
