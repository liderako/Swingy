package com.student.asvirido.swingy.controller;

import com.student.asvirido.swingy.module.Model;
import com.student.asvirido.swingy.module.hero.Hero;
import com.student.asvirido.swingy.view.console.ConsoleCreateHeroView;
import com.student.asvirido.swingy.view.console.ConsoleSelectView;
import com.student.asvirido.swingy.view.console.ConsoleStartView;
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
                    System.out.println("Sorry, this is hero already exists");
                    return (new String[] {"Create Hero"});
                }
                else {
                    System.out.println("Okay, hero is ready to mission, let's go!");
                    return (new String[] {"battle"});
                }
            }
            else if (view[0].equals("Select Hero")) {
                JSONObject l = model.selectHero();
                String[] command = new String[model.getAmountHeroes()];
                Hero[] hero = new Hero[model.getAmountHeroes()];
                int i = 0;

                if (!l.get("Warrior").equals("not exists")) {
                    command[i] = "Warrior";
                    model.loadHero("Warrior");
                    hero[i] = model.getHero();
                    i++;
                }
                if (!l.get("Archer").equals("not exists")) {
                    command[i] = "Archer";
                    model.loadHero("Archer");
                    hero[i] = model.getHero();
                    i++;
                }
                if (!l.get("Monk").equals("not exists")) {
                    command[i] = "Monk";
                    model.loadHero("Monk");
                    hero[i] = model.getHero();
                    i++;
                }
                if (!l.get("Rogue").equals("not exists")) {
                    command[i] = "Rogue";
                    model.loadHero("Rogue");
                    hero[i] = model.getHero();
                    i++;
                }
                ConsoleSelectView consoleSelectView = new ConsoleSelectView(command);
                String[] res = consoleSelectView.startView(hero);
                return (res);
            }
            else if (view[0].equals("battle")) {
                model.loadHero(view[1]);
                System.out.println("Okay, already done your hero " + model.getHero().getName());
                return (new String[] {"start"});
            }
        }
        return (new String[] {"start"});
    }

    public void end() throws Exception {
        model.end();
    }
}