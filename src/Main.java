import com.student.asvirido.swingy.module.Model;
import com.student.asvirido.swingy.module.hero.FactoryHero;
import com.student.asvirido.swingy.module.hero.Hero;
import com.student.asvirido.swingy.view.console.ConsoleView;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Hero h = FactoryHero.newHero("asvirido", "Archer");
    }

}
