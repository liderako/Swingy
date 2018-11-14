package com.student.asvirido.swingy.module;

import com.student.asvirido.swingy.module.database.DataManager;
import com.student.asvirido.swingy.module.hero.FactoryHero;
import com.student.asvirido.swingy.module.hero.Hero;
import com.student.asvirido.swingy.module.monster.FactoryMonster;
import com.student.asvirido.swingy.module.monster.Monster;

import java.io.IOException;
import java.util.Random;


public class Model {
    private Hero hero;
    public DataManager dataManager;

    public Model() throws Exception {
        dataManager = new DataManager();
    }

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
            hero.run();
            return (true);
        }
        else if ((new Random().nextInt((10 - 1) + 1) + 1) > 5) {
            hero.run();
            return (true);
        }
        return (false);
    }

    public boolean createHero(final String name, final String type) throws IOException{
        hero = FactoryHero.newHero(name, type);
        return (true);
    }

    public boolean fight(final String typeMonster) {
        Monster monster = FactoryMonster.newMonster(typeMonster);
        if (typeMonster.equals("Death")) {
            return (false);
        }
        else {
            int i = 0;
            int damageHero;
            int damageMonster;
            while (hero.getHp() > 0 && monster.getHp() > 0) {
                damageHero = (monster.getDefence() - i) - ((new Random().nextInt((hero.getAttack() * 2) + 1) + hero.getAttack()));
                damageMonster = (hero.getDefence() - i) - ((new Random().nextInt((monster.getAttack() * 2) + 1) + monster.getAttack()));
                if (damageHero < 0) {
                    monster.setHp(monster.getHp() - (damageHero * -1));
                }
                if (monster.getHp() <= 0) {
                    return (true);
                }
                if (damageMonster < 0) {
                    hero.setHp(hero.getHp() - (damageMonster * -1));
                }
                if (hero.getHp() <= 0) {
                    return (false);
                }
                i++;
            }
        }
        return (true);
    }

    public final Hero getHero() {
        return (hero);
    }

    public void end() throws Exception {
        dataManager.end();
    }
}

