package com.student.asvirido.swingy.controller;

import com.student.asvirido.swingy.module.Model;
import com.student.asvirido.swingy.module.hero.Hero;
import com.student.asvirido.swingy.module.monster.Monster;
import com.student.asvirido.swingy.view.console.*;
import com.student.asvirido.swingy.view.gui.GameView;
import com.sun.org.apache.bcel.internal.generic.Select;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class Controller {
     private Model   model;
     private int     status;
     private  GameView gameView;

     public Controller(int status) throws Exception {
        model = new Model();
        this.status = status;
     }

    public void run() throws SQLException, IOException,InterruptedException {
        String[] view = new String[] {"start"};
        int timeClock = 0;

        while (true) {
            if (status == 1) {
                view[0] = "start";
                while (true) {
                    view = runGame(view);
                    if (view[0].equals("end")) {
                        break;
                    }
                }
            } else {
                gameView = new GameView();
                view[0] = "start";
                while (true) {
                    view = runGameGui(view);
                    if (view[0].equals("end")) {
                        break;
                    }
                    if (view[0].equals("Create Hero")) {
                        TimeUnit.SECONDS.sleep(1);
                        if (gameView.getErrorFieldStatusVisible()) {
                            timeClock++;
                        }
                        if (timeClock == 2) {
                            gameView.setErrorFieldStatusVisible(false);
                            timeClock = 0;
                        }
                    } else {
                        TimeUnit.MICROSECONDS.sleep(400);
                    }
                }
            }
        }
    }

    private String[] runGameGui(String[] view) throws SQLException, IOException, InterruptedException {
         if (view[0].equals("start")) {
             gameView.displayStartView();
             String res = gameView.getStatusStartView();
             if (res.equals("Create Hero")) {
                 if (model.getAmountHeroes() == 4) {
                     gameView.setBoundsError(270, 100, 400, 20);
                     gameView.setErrorField("You can't create hero. You need select already exists hero");
                     gameView.setStatusStartView("Select Hero");
                     gameView.setErrorFieldStatusVisible(true);
                     TimeUnit.SECONDS.sleep(2);
                     gameView.setErrorFieldStatusVisible(false);
                     gameView.displaySelectHeroView(model.getAmountHeroes(),model.selectHero());
                     return (new String[] {"Select Hero"});
                 }
                 gameView.displayCreateHeroView();
                 return (new String[] {"Create Hero"});
             }
             else if (res.equals("Select Hero")) {
                 if (model.getAmountHeroes() == 0) {
                     gameView.setBoundsError(270, 100, 400, 20);
                     gameView.setErrorField("You can't select hero. You need create hero");
                     gameView.setErrorFieldStatusVisible(true);
                     TimeUnit.SECONDS.sleep(2);
                     gameView.setErrorFieldStatusVisible(false);
                     gameView.setStatusStartView("Create Hero");
                     gameView.displayCreateHeroView();
                     return (new String[] {"Create Hero"});
                 }
                 gameView.displaySelectHeroView(model.getAmountHeroes(),model.selectHero());
                 return (new String[] {"Select Hero"});
             }
             else if (res.equals("console")) {
                 status = 1;
                 gameView.end();
                 return (new String[] {"end"});
             }
             else {
                 return (new String[] {"start"});
             }
         }
         else if (view[0].equals("Create Hero")) {
             String res = gameView.getStatusStartView();
             if (res.equals("game")) {
                 String typeHero = gameView.getTypeHero();
                 String nameHero = gameView.getNameHero();
                 if(!model.createHero(nameHero, typeHero)) {
                     gameView.setErrorField(" Sorry, this is hero already exists.");
                     gameView.setErrorFieldStatusVisible(true);
                     gameView.setStatusStartView("Create Hero");
                     return (new String[] {"Create Hero"});
                 }
                 else {
                     model.loadHero(typeHero);
                     gameView.displayGameView(model.getHero());
                     return (new String[] {"game"});
                 }
             }
             return (new String[] {"Create Hero"});
         }
         else if (view[0].equals("Select Hero")) {
             String type = gameView.getTypeHero();
             if (!type.equals("null")) {
                 model.loadHero(type);
                 gameView.displayGameView(model.getHero());
                 return (new String[] {"game"});
             }
             return (new String[] {"Select Hero"});
         }
         else if (view[0].equals("game")) {
             if (!gameView.getDirection().equals("null")) {
                 model.move(gameView.getDirection());
                 if (model.checkEndMission()) {
                     gameView.setBoundsError(270, 100, 400, 20);
                     gameView.setErrorField("Mission done, congratulations. You got 250 exp.");
                     gameView.setErrorFieldStatusVisible(true);
                     TimeUnit.SECONDS.sleep(2);
                     gameView.setErrorFieldStatusVisible(false);
                     gameView.setStatusStartView("start");
                     gameView.displayStartView();
                     return (new String[] {"start"});
                 }
                 else if (model.findMonster()) {
                     gameView.setBoundsError(270, 100, 400, 20);
                     gameView.setErrorField("You find monster " + model.getMonster().getType() + ".");
                     gameView.setErrorFieldStatusVisible(true);
                     TimeUnit.SECONDS.sleep(2);
                     gameView.setErrorFieldStatusVisible(false);
                     gameView.setStatusStartView("battle");
                     gameView.displayBattleView(model.getHero(), model.getMonster());
                     return (new String[] {"battle"});
                 }
                 gameView.displayGameView(model.getHero());
                 TimeUnit.MICROSECONDS.sleep(30);
             }
             return (new String[] {"game"});
         }
         else if (view[0].equals("battle")) {
             String res = gameView.getStatusStartView();
             if (!res.equals("battle")) {
                 return (new String[] {res});
             }
             return (new String[] {"battle"});
         }
         else if (view[0].equals("Run")) {
             if (model.run()) {
                 gameView.setBoundsError(270, 100, 400, 20);
                 gameView.setErrorField("You successfully ran away.");
                 gameView.setErrorFieldStatusVisible(true);
                 TimeUnit.SECONDS.sleep(2);
                 gameView.setErrorFieldStatusVisible(false);
                 gameView.setStatusStartView("game");
                 gameView.displayGameView(model.getHero());
                 return (new String[] {"game"});
             }
             else {
                 gameView.setBoundsError(270, 100, 400, 20);
                 gameView.setErrorField("You did not successfully run away." + "Fight started.");
                 gameView.setErrorFieldStatusVisible(true);
                 TimeUnit.SECONDS.sleep(2);
                 gameView.setErrorFieldStatusVisible(false);
                 return (new String[] {"Fight"});
             }
         }
         else if (view[0].equals("Fight")) {
             if (model.fight()) {
                 gameView.setStatusStartView("win");
                 if (model.findLoot()) {
                     JSONObject loot = model.generataLoot();
                     gameView.displayWin(model.getHero(), model.getMonster(), loot, true);
                 }
                 else {
                     gameView.displayWin(model.getHero(), model.getMonster(), new JSONObject(), false);
                 }
                 return (new String[] {"win"});
             }
             else {
                 gameView.displayDeath(model.getMonster());
                 return (new String[]{"death"});
             }
         }
         else if (view[0].equals("death")) {
             if (gameView.getStatusStartView().equals("start")) {
                 model.deleteHero();
                 gameView.displayStartView();
                 TimeUnit.SECONDS.sleep(1);
                 return (new String[] {"start"});
             }
             return (new String[] {"death"});
         }
         else if (view[0].equals("win")) {
             if (gameView.getStatusStartView().equals("game")) {
                 if (gameView.getIsTakeLoot()) {
                     model.equipLoot(gameView.getLoot());
                 }
                 gameView.displayGameView(model.getHero());
                 return (new String[] {"game"});
             }
             return (new String[] {"win"});
         }
         return (new String[] {"start"});
    }
//----------------------------------------------------------------------
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
            else if (view[0].equals("gui")) {
                status = 2;
                return (new String[]{"end"});
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
            return (new String[] {"start"});
        }
        return (new String[] {"end"});
    }

    public void end() throws Exception {
        model.end();
    }
}

