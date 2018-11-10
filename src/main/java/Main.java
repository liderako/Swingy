import com.student.asvirido.swingy.module.Model;
import com.student.asvirido.swingy.module.hero.FactoryHero;
import com.student.asvirido.swingy.module.hero.Hero;
import com.student.asvirido.swingy.view.console.ConsoleView;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Model model = new Model();
        try {
            model.createHero("asvirido", "Archer");
            System.out.println("Hello world");
        }
        catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
}
