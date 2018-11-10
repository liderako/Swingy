package com.student.asvirido.swingy.module;

import com.student.asvirido.swingy.module.file.FileManager;
import com.student.asvirido.swingy.module.hero.FactoryHero;
import com.student.asvirido.swingy.module.hero.Hero;
import com.student.asvirido.swingy.module.hero.types.Archer;
import com.student.asvirido.swingy.module.monster.FactoryMonster;
import com.student.asvirido.swingy.module.monster.Monster;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

        File fileSave = new File(FileManager.fileName);
        System.out.println("____________");
        if (fileSave.exists()) {
            if (!checkIfTypeClassIsEmpty(type)) {
                return (false);
            }
        }
        writeDataHeroToTheFile();
        return (true);
    }

    private boolean checkIfTypeClassIsEmpty(final String type) throws  IOException {
        FileManager fileManager = new FileManager();
        JSONParser parser = new JSONParser();
        int[] countType = new int[]{0, 0, 0, 0};

        try {
            String s[] = fileManager.readFile(fileManager.getFileName()).split("\n");
            for (String x : s) {
                Object obj = parser.parse(x);
                JSONObject jsonObject = (JSONObject) obj;
                String t = (String) jsonObject.get("typeClass");
                String n = (String) jsonObject.get("namePlayer");
                if (t.equals("Monk")) {
                    countType[0] += 1;
                    if (countType[0] > 1) {
                        throw new Exception("save file broken");
                    }
                } else if (t.equals("Warrior")) {
                    countType[1] += 1;
                    if (countType[1] > 1) {
                        throw new Exception("save file broken");
                    }
                } else if (t.equals("Archer")) {
                    countType[2] += 1;
                    if (countType[2] > 1) {
                        throw new Exception("save file broken");
                    }
                } else if (t.equals("Rogue")) {
                    countType[3] += 1;
                    if (countType[3] > 1) {
                        throw new Exception("save file broken");
                    }
                } else {
                    throw new Exception("Doesn't know what is that class");
                }
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Sorry, your save file broken and deleted. Be careful, you can't edit save file");
            fileManager.deleteFile();
            return (true);
        }

        if (type.equals("Monk") && countType[0] == 1) {
            return (false);
        }
        else if (type.equals("Warrior") && countType[1] == 1) {
            return (false);
        }
        else if (type.equals("Archer") && countType[2] == 1) {
            return (false);
        }
        else if (type.equals("Rogue") && countType[3] == 1) {
            return (false);
        }
        return (true);
    }

    private void writeDataHeroToTheFile() throws IOException {
        FileManager fileManager = new FileManager();

        JSONObject obj = new JSONObject();
        obj.put("typeClass", hero.getType());
        obj.put("namePlayer", hero.getName());
        obj.put("typeWeapon", hero.getInventory().getWeapon().getType());
        obj.put("typeArmor", hero.getInventory().getArmor().getType());
        obj.put("typeHelm", hero.getInventory().getHelm().getType());
        fileManager.writeFile(obj.toJSONString());
        fileManager.writeFile("\n");
        fileManager.closeFile();
        System.out.println(obj);
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
}
