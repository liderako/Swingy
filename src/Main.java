import com.student.asvirido.swingy.view.console.ConsoleView;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int randomNum = new Random().nextInt((10 - 1) + 1) + 1;
        System.out.println(randomNum);
//        String[] s = {"run", "fight"};
//        ConsoleView consoleView = new ConsoleView( s);
//
//        System.out.println("Please choise command");
//        System.out.println("run");
//        System.out.println("fight");
//        consoleView.input();
//        System.out.println("You are a dead");
    }

}
