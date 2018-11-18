package com.student.asvirido.swingy.view.console;

public class ConsoleStartView extends ConsoleView {

    public ConsoleStartView() {
        super( new String[] {"Create Hero", "Select Hero"});
    }

    public String[] startView(int amount) {
        String s = input();

        if (s.equals("Create Hero") && amount == 4) {
            System.out.println("You can't create hero. You need select already exists hero");
            s = "Select hero";
        }
        else if (s.equals("Select Hero") && amount == 0) {
            System.out.println("You can't select hero. You need create hero");
            s = "Create Hero";
        }
        return(new String[]{s});
    }
}
