package com.student.asvirido.swingy.view.console;

import com.student.asvirido.swingy.module.hero.FactoryHero;
import com.student.asvirido.swingy.module.hero.Hero;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class ConsoleCreateHeroView extends ConsoleView {
    public ConsoleCreateHeroView() {
        super(new String[] {"Archer", "Warrior", "Monk", "Rogue"});
    }

    @NotNull
    @Size(min = 6, max = 12, message = "Name size 6-12 char")
    @Pattern(regexp = "[A-Z_a-z_0-9]+", message = "Please write your name, only char and digital")
    private String name;
    public String[] startView() {
        Hero[] hero = new Hero[]{
                FactoryHero.newHero("", "Warrior"),
                FactoryHero.newHero("", "Archer"),
                FactoryHero.newHero("", "Rogue"),
                FactoryHero.newHero("", "Monk")
        };

        for (Hero x : hero) {
            System.out.println("|Attributes hero: " + x.getType());
            System.out.println("|Attack: " + (x.getAttack() - x.getInventory().getWeapon().getDamage()));
            System.out.println("|Defence: " + (x.getDefence() - x.getInventory().getArmor().getDefence()));
            System.out.println("|Hp: " + (x.getHp() - x.getInventory().getArmor().getDefence()));
            System.out.println("|_______________________|");
        }
        System.out.println("Input type hero");
        String type = input();
        String name = inputName();
        return (new String[] {"Create Hero", type, name});
    }

    public boolean validate(Object object, Validator validator) {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object);

        System.out.println(String.format("Count error: %d", constraintViolations.size()));

        for (ConstraintViolation<Object> cv : constraintViolations)
            System.out.println(String.format("Warning Error! property: [%s], value: [%s], message: [%s]",
                    cv.getPropertyPath(),
                    cv.getInvalidValue(),
                    cv.getMessage()));
        if (constraintViolations.size() == 0) {
            return (true);
        }
        return (false);
    }

    private String inputName() {
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();
        Scanner scanner = new Scanner(System.in);
        boolean     found = false;

        System.out.println("Please write your name, only char and digital");
        System.out.println("Name size 6-12 char");
        while (true) {
            name = scanner.nextLine();
            if (validate(this, validator)) {
                break ;
            }
        }
        return (name);
    }
}
