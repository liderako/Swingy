package com.student.asvirido.swingy.view.console;

import com.student.asvirido.swingy.module.monster.Monster;

public class ConsoleDeathView extends ConsoleView {

    public ConsoleDeathView() {
        super( new String[] {"Enter"});
    }

    public void startView(final Monster m) {
        if (m.getType().equals("Death")) {
            System.out.println(" A-HA-HA-HA ");
            System.out.println(" It's your time.");
            System.out.println(" You die.");
        }
        else {
            System.out.println("Don't worry, if you die.");
        }
    }
}
