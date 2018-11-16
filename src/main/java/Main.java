import com.student.asvirido.swingy.controller.Controller;
import com.student.asvirido.swingy.module.Model;
import com.student.asvirido.swingy.module.artefact.armor.types.HeavyArmor;
import com.student.asvirido.swingy.module.artefact.helm.FactoryHelm;
import com.student.asvirido.swingy.module.artefact.helm.Helm;
import com.student.asvirido.swingy.module.artefact.weapon.FactoryWeapon;
import com.student.asvirido.swingy.module.hero.FactoryHero;
import com.student.asvirido.swingy.module.hero.Hero;
import com.student.asvirido.swingy.view.console.ConsoleView;

import javax.validation.constraints.Min;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws Exception{
        Controller controller = new Controller(1);

        controller.run();
        controller.end();
    }
}