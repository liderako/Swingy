package com.student.asvirido.swingy.module;

import com.student.asvirido.swingy.module.database.DataManager;
import com.student.asvirido.swingy.module.hero.FactoryHero;
import com.student.asvirido.swingy.module.hero.Hero;
import com.student.asvirido.swingy.module.monster.FactoryMonster;
import com.student.asvirido.swingy.module.monster.Monster;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;


public class Model {
    private Hero hero;
    private DataManager dataManager;
    private Monster monster;

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

    public JSONObject selectHero() throws SQLException {
        return(dataManager.getHeroes());
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

    public boolean loadHero(final String typeClass) throws SQLException {
        try {
            hero = dataManager.loadHero(typeClass);
            return (true);
        }
        catch (SQLException e) {
            return (false);
        }
    }

    public boolean run() {
        final String typeMonster = this.monster.getType();

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

    public boolean deleteHero() throws SQLException {
        try {
            dataManager.deleteHero(hero.getType());
            hero = null;
            return (true);
        }
        catch (SQLException e) {
           return false;
        }
    }

    public boolean createHero(final String name, final String type) throws IOException, SQLException{
        JSONObject heroes = dataManager.getHeroes();
        if (type.equals("Warrior") && !heroes.get("Warrior").equals("not exists")) {
            return (false);
        }
        else if (type.equals("Archer") && !heroes.get("Archer").equals("not exists")) {
            return (false);
        }
        else if (type.equals("Monk") && !heroes.get("Monk").equals("not exists")) {
            return (false);
        }
        else if (type.equals("Rogue") && !heroes.get("Rogue").equals("not exists")) {
            return (false);
        }
        hero = FactoryHero.newHero(name, type);
        dataManager.createHero(hero);
        return (true);
    }

    public boolean fight() {
        final String typeMonster = this.monster.getType();

        this.monster = FactoryMonster.newMonster(this.monster.getType());

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

    public boolean findMonster() {
        if (new Random().nextInt(10 - 1) > 5) {
            generateMonster();
            return (true);
        }
        else if (hero.getLevel() >= 7) {
            generateMonster();
            return (true);
        }
        return (false);
    }

    public int getAmountHeroes() throws SQLException {
        int amount = 0;
        JSONObject heroes = selectHero();

        if (!heroes.get("Warrior").equals("not exists")) {
            amount++;
        }
        if (!heroes.get("Monk").equals("not exists")) {
            amount++;
        }
        if (!heroes.get("Rogue").equals("not exists")) {
            amount++;
        }
        if (!heroes.get("Archer").equals("not exists")) {
            amount++;
        }
        return (amount);
    }

    public JSONObject generataLoot() {
        JSONObject loot = new JSONObject();
        int resTypeLoot = new Random().nextInt(4 - 1) + 1;
        int resType = new Random().nextInt(5 - 1) + 1;

        if (resTypeLoot == 1) {
            switch (resType) {
                case 1:
                    loot.put("Helm", "Hood");
                    break ;
                case 2:
                    loot.put("Helm", "IronHelmet");
                    break ;
                case 3:
                    loot.put("Helm", "LeatherHelmet");
                    break ;
                case 4:
                    loot.put("Helm", "Hat");
                    break ;
            }
        }
        else if (resTypeLoot == 2) {
            switch (resType) {
                case 1:
                    loot.put("Weapon", "Fist");
                    break ;
                case 2:
                    loot.put("Weapon", "SwordWithShield");
                    break ;
                case 3:
                    loot.put("Weapon", "Dagger");
                    break ;
                case 4:
                    loot.put("Weapon", "Bow");
                    break ;
            }
        }
        else {
            switch (resType) {
                case 1:
                    loot.put("Armor","HeavyArmor");
                    break ;
                case 2:
                    loot.put("Armor","LightArmor");
                    break ;
                case 3:
                    loot.put("Armor","MediumArmor");
                    break ;
                case 4:
                    loot.put("Armor","Shirt");
                    break ;
            }
        }
        return (loot);
    }

    public void end() throws Exception {
        dataManager.end();
    }

    public final Hero getHero() {
        return (hero);
    }

    public final Monster getMonster() { return (monster); }

    private void generateMonster() {
        if (hero.getLevel() >= 7) {
            this.monster = FactoryMonster.newMonster("Death");
        }
        this.monster = FactoryMonster.newMonster(FactoryMonster.randomType());
    }
}

