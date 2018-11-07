package com.student.asvirido.swingy.module;

import com.student.asvirido.swingy.module.hero.Hero;

import java.util.Random;


public class Model {
    private Hero hero;

    public void move(final String direction) {
        if (direction.equals("North")) {
            hero.moveUp();
        }
        else if (direction.equals("East")) {
            hero.moveLeft();
        }
        else if (direction.equals("South")) {
            hero.moveDown();
        }
        else if (direction.equals("West")) {
            hero.moveLeft();
        }
    }

    public boolean endMission() {
        int level = this.hero.getLevel();
        int size = (level - 1) * 5 + 10 - (level % 2);

        if (hero.getPosition().getX() == 0 ||  hero.getPosition().getX() == size||
                hero.getPosition().getY() == 0 || hero.getPosition().getY() == size)
        {
            return (true);
        }
        return (false);
    }

    public boolean run(final String typeMonster) {
        if (typeMonster.equals("WhiteWolf")) {
            return (false);
        }
        else if (typeMonster.equals("Thief") && hero.getInventory().getArmor().getType().equals("LightArmor")
                && hero.getInventory().getHelm().getType().equals("Hood")) {
            return (true);
        }
        else if ((new Random().nextInt((10 - 1) + 1) + 1) > 5) {
            return (true);
        }
        return (false);
    }

    public boolean fight(final String typeMonster) {
        if (typeMonster.equals("Death")) {
            return (false);
        }
        return (true);
//        else {
//            int hpHero = hero.getHp();
//            int attackHero = hero.getAttack();
//            int
//        }
    }

    public final Hero getHero() {
        return (hero);
    }
}
