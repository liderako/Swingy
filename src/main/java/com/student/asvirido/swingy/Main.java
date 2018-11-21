package com.student.asvirido.swingy;

import com.student.asvirido.swingy.controller.Controller;

public class Main {

    public static void main(String[] args) throws Exception{
        if (args.length != 1) {
            usage();
            return ;
        }
        Controller controller;

        if (args[0].equals("console")) {
            controller = new Controller(1);
        }
        else if (args[0].equals("gui")) {
            controller = new Controller(2);
        }
        else {
            usage();
            return ;
        }
        controller.run();
        controller.end();
    }

    public static void usage() {
        System.out.println("Usage:\n$java -jar swingy.jar console\n$java -jar swingy.jar gui");
    }
}
