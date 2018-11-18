package com.student.asvirido.swingy.view.console;

import com.student.asvirido.swingy.module.hero.Hero;

public class ConsoleGameView extends ConsoleView {

    public ConsoleGameView() {
        super(new String[]{"North", "East", "South", "West"});
    }

    public String[] startView(final Hero hero) {
        int size = (hero.getLevel() - 1) * 5 + 10 - (hero.getLevel() % 2);
        System.out.print(" ");
        for (int i = 0; i < size; i++) {
            System.out.print("_");
        }
        System.out.print("\n");

        for (int y = 0; y <= size; y++) {
            System.out.print("|");
            for (int x = 0; x <= size; x++) {
                if (x == hero.getPosition().getX() && y == hero.getPosition().getY()) {
                    System.out.print("P");
                }
                else {
                    System.out.print(".");
                }
            }
            System.out.println("|");
        }

        System.out.print(" ");
        for (int i = 0; i < size; i++) {
            System.out.print("_");
        }
        System.out.println("");
        String s = input();
        return (new String[] {s});
    }
}
