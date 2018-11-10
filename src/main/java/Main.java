import com.student.asvirido.swingy.module.Model;
import com.student.asvirido.swingy.module.hero.FactoryHero;
import com.student.asvirido.swingy.module.hero.Hero;
import com.student.asvirido.swingy.view.console.ConsoleView;

import javax.validation.constraints.Min;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Model model = new Model();
        try {
            System.out.println("Res " + model.createHero("asvirido", "Monk"));
//            System.out.println("Res " + model.createHero("asvirido", "Archer"));
//            System.out.println("Res " + model.createHero("asvirido", "Warrior"));
//            System.out.println("Res " + model.createHero("asvirido", "Rogue"));
        }
        catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
}