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
        Model model = new Model();

        model.selectHero();
//        Hero hero2 = FactoryHero.newHero("asviridoArcher", "Archer");
//        System.out.println(model.createHero("asvirido", "Warrior"));
//        System.out.println(model.createHero("asvirido", "Archer"));

        //model.dataManager.createHero(hero2);

//        Hero tmp = model.dataManager.loadHero("Archer");
//        model.dataManager.saveHero(tmp);

        model.end();
    }
}