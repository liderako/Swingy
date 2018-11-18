package com.student.asvirido.swingy.controller;

import com.student.asvirido.swingy.module.Model;
import com.student.asvirido.swingy.module.hero.Hero;
import com.student.asvirido.swingy.view.console.*;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.sql.SQLException;

public class Controller {
    private Model   model;
    private int     status;

    public Controller(int status) throws Exception {
        model = new Model();
        this.status = status;
    }

    public void run() throws SQLException, IOException {
        String[] view = new String[] {"start"};

        while (true) {
            view = runGame(view);
            if (view.equals("end")) {
                break ;
            }
        }
    }

    private String[] runGame(String[] view) throws SQLException, IOException {
        if (status == 1) {
            if (view[0].equals("start")) {
                ConsoleStartView consoleStartView = new ConsoleStartView();
                return (consoleStartView.startView(model.getAmountHeroes()));
            }
            else if (view[0].equals("Create Hero")) {
                ConsoleCreateHeroView consoleCreateHeroView = new ConsoleCreateHeroView();
                String[] res = consoleCreateHeroView.startView();

                if (!model.createHero(res[2], res[1])) {
                    System.out.println("Sorry, this is hero already exists.");
                    return (new String[] {"Create Hero"});
                }
                else {
                    System.out.println("Okay, hero is ready to mission, let's go!");
                    model.loadHero(res[1]);
                    return (new String[] {"game"});
                }
            }
            else if (view[0].equals("Select Hero")) {
                Hero[] hero = model.selectHero();
                String[] command = new String[hero.length];
                for (int i = 0; i < hero.length; i++) {
                    command[i] = hero[i].getType();
                }
                ConsoleSelectView consoleSelectView = new ConsoleSelectView(command);
                String[] res = consoleSelectView.startView(hero);
                model.loadHero(res[1]);
                return (res);
            }
            else if (view[0].equals("game")) {
                ConsoleGameView consoleGameView = new ConsoleGameView();
                String[] res = consoleGameView.startView(model.getHero());
                model.move(res[0]);
                if (model.checkEndMission()) {
                    System.out.println("Mission done, congratulations.");
                    System.out.println("You got 250 exp.");
                    return (new String[] {"start"});
                }
                else if (model.findMonster()) {
                    System.out.println("You find monster " + model.getMonster().getType() + ".");
                    return (new String[] {"battle"});
                }
                return (new String[] {"game"});
            }
            else if (view[0].equals("battle")) {
                ConsoleGameBattle consoleGameBattle = new ConsoleGameBattle();

                String res = consoleGameBattle.startView(model.getHero(), model.getMonster());
                return (new String[]{res});
            }
            else if (view[0].equals("Fight")) {
                if (model.fight()) {
                    return (new String[] {"win"});
                }
                else {
                    return (new String[] {"death"});
                }
            }
            else if (view[0].equals("Run")) {
                if (model.run()) {
                    System.out.println("You successfully ran away.");
                    return (new String[] {"game"});
                }
                else {
                    System.out.println("You did not successfully run away.");
                    System.out.println("Fight started.");
                    return (new String[] {"Fight"});
                }
            }
            else if (view[0].equals("death")) {
                ConsoleDeathView consoleDeathView = new ConsoleDeathView();

                consoleDeathView.startView(model.getMonster());
                model.deleteHero();
                return (new String[] {"start"});
            }
            else if (view[0].equals("win")) {
                ConsoleWinView consoleWinView;
                if (model.findLoot()) {
                   consoleWinView = new ConsoleWinView(new String[] {"Don't touch", "Take"});
                   JSONObject loot = model.generataLoot();
                   if (consoleWinView.startView(model.getHero(), model.getMonster(), loot, true).equals("Take")) {
                       model.equipLoot(loot);
                   }
                }
                else {
                    consoleWinView = new ConsoleWinView(new String[]{"Okay"});
                    consoleWinView.startView(model.getHero(), model.getMonster(), new JSONObject(), false);
                }
                return (new String[] {"game"});
            }
        }
        return (new String[] {"start"});
    }

    public void end() throws Exception {
        model.end();
    }
}