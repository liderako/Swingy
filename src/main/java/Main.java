import com.student.asvirido.swingy.module.Model;
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
        Hero hero = FactoryHero.newHero("asvirido", "Warrior");
        Hero hero2 = FactoryHero.newHero("asviridoArcher", "Archer");
        model.dataManager.saveHero(hero);
        model.dataManager.saveHero(hero2);

        Hero tmp = model.dataManager.loadHero(hero.getType());
        tmp.log();
        tmp = model.dataManager.loadHero(hero2.getType());
        System.out.println("_________");
        tmp.log();
        model.end();
    }
}