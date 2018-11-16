package com.student.asvirido.swingy.view.console;

import java.util.Arrays;
import java.util.Scanner;

public class ConsoleView {
    private String[] command;

    public ConsoleView(String[] command) {
        this.command = command;
    }

    private void help() {
        System.out.println("Please write command:");
        for (String x : command) {
            System.out.println(x);
        }
    }

    protected String input() {
        Scanner     scanner = new Scanner(System.in);
        String      message;
        boolean     found = false;

        while (true) {
            help();
            message = scanner.nextLine();
            for (String s : command) {
                if (s.equals(message)) {
                    found = true;
                    break ;
                }
            }
            if (found) {
                break ;
            }
        }
        return (message);
    }
}
