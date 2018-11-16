package com.student.asvirido.swingy.controller;

import com.student.asvirido.swingy.module.Model;
import com.student.asvirido.swingy.view.console.ConsoleCreateHeroView;
import com.student.asvirido.swingy.view.console.ConsoleSelectView;
import com.student.asvirido.swingy.view.console.ConsoleStartView;
import org.json.simple.JSONObject;

import java.sql.SQLException;

public class Controller {
    private Model   model;
    private int     status;

    public Controller(int status) throws Exception {
        model = new Model();
        this.status = status;
    }

    public void run() throws SQLException {
        if (status == 1) {
            ConsoleStartView consoleStartView = new ConsoleStartView();

            String resultStartView = consoleStartView.startView(model.getAmountHeroes());

            if (resultStartView.equals("Create Hero")) {
                ConsoleCreateHeroView consoleCreateHeroView = new ConsoleCreateHeroView();

            } else {
                ConsoleSelectView consoleSelectView = new ConsoleSelectView();
            }
        }
    }

    public void end() throws Exception {
        model.end();
    }
}
