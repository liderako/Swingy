package com.student.asvirido.swingy.view.gui;

import com.student.asvirido.swingy.controller.Controller;
import com.student.asvirido.swingy.module.hero.FactoryHero;
import com.student.asvirido.swingy.module.hero.Hero;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class GameView extends JFrame {
    private Panel panelStartView;
    private JButton buttonOne;
    private JButton buttonTwo;
    private JButton buttonThree;
    private JButton buttonFour;
    private JButton buttonOkay;
    private JTextField nameField;
    private JTextArea errorField;
    private JTextArea heroesData;
    private JTextArea noteOne;

    private String statusStartView;
    private String typeHero;
    private String nameHero;
    private int flag;

    public GameView() {
        initGameWindow();
        initButton();
        initTextField();
        initPanel();
        buttonOneListener();
        buttonTwoListener();
        buttonFourListener();
        buttonThreeListener();
        nameFieldListener();
        statusStartView = "start";
    }

    public void displayStartView()  {
        buttonOne.setVisible(true);
        buttonTwo.setVisible(true);
        buttonOne.setBounds(300, 800, 100, 100);
        buttonTwo.setBounds(600, 800, 100, 100);
        buttonOne.setText("Create Hero");
        buttonTwo.setText("Select Hero");
        buttonThree.setVisible(false);
        buttonFour.setVisible(false);
        buttonOkay.setVisible(false);
        nameField.setVisible(false);
        errorField.setVisible(false);
        heroesData.setVisible(false);
        noteOne.setVisible(false);
    }

    public void displayCreateHeroView() {
        typeHero = "null";
        nameHero = "null";
        errorField.setText("ERROR TEXT");
        setCenterButtons();
        buttonOkayCenter();
        buttonOne.setText("Archer");
        buttonTwo.setText("Warrior");
        buttonThree.setText("Monk");
        buttonFour.setText("Rogue");
        noteOne.setText("Name:");
        buttonOne.setVisible(true);
        buttonTwo.setVisible(true);
        buttonThree.setVisible(true);
        buttonFour.setVisible(true);
        buttonOkay.setVisible(false);
        errorField.setVisible(false);
        heroesData.setVisible(true);
        nameField.setVisible(true);
        noteOne.setVisible(true);
        nameField.setBounds(450, 600, 100, 42);
        noteOne.setBounds(410, 610, 40,42);
        noteOne.setBackground(Color.darkGray);
        errorField.setBounds(400, 100, 215, 20);
        initHeroesData();
    }

    public void displaySelectHeroView(int amountHero) {
        if (amountHero == 4) {
            buttonFour.setVisible(true);
        }
        if (amountHero == 3) {
            buttonThree.setVisible(true);
        }
        if (amountHero == 2) {
            buttonTwo.setVisible(true);
        }
        if (amountHero == 1) {
            buttonOne.setVisible(true);
        }
    }

    public void displayGameView() {
        buttonOne.setVisible(false);
        buttonTwo.setVisible(false);
        buttonThree.setVisible(false);
        buttonFour.setVisible(false);
        buttonOkay.setVisible(false);
        nameField.setVisible(false);
        errorField.setVisible(false);
        heroesData.setVisible(false);
    }

    public String getStatusStartView() {
        return (statusStartView);
    }

    public String getTypeHero() {return typeHero;}

    public String getNameHero() {return nameHero;}

    public boolean getErrorFieldStatusVisible() {
        return (errorField.isVisible());
    }

    public void setErrorFieldStatusVisible(boolean status) {
        errorField.setVisible(status);
    }

    public void setStatusStartView(String status) {
        statusStartView = status;
    }

    public void setErrorField(String s) {
        errorField.setText(s);
    }

    private void buttonOneListener() {
        buttonOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (statusStartView.equals("start")) {
                    statusStartView = "Create Hero";
                }
                else if (statusStartView.equals("Create Hero")) {
                    typeHero = buttonOne.getText();
                    errorManagerCreateHero();
                }
            }
        });
    }

    private void buttonTwoListener() {
        buttonTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (statusStartView.equals("start")) {
                    statusStartView = "Select Hero";
                }
                else if (statusStartView.equals("Create Hero")) {
                    typeHero = buttonTwo.getText();
                    errorManagerCreateHero();
                }
            }
        });
    }

    private void buttonThreeListener() {
        buttonThree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (statusStartView.equals("Create Hero")) {
                    typeHero = buttonThree.getText();
                    errorManagerCreateHero();
                }
            }
        });
    }

    private void buttonFourListener() {
        buttonFour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (statusStartView.equals("Create Hero")) {
                    typeHero = buttonFour.getText();
                    errorManagerCreateHero();
                }
            }
        });
    }

    private void buttonOkayListener() {
        buttonOkay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void nameFieldListener() {
        nameField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (statusStartView.equals("Create Hero")) {
                    errorManagerCreateHero();
                }
            }
        });
    }

    private void errorManagerCreateHero() {
        if (nameField.getText().length() >= 6 && nameField.getText().length() <= 21 && !typeHero.equals("null")) {
            nameHero = nameField.getName();
            statusStartView = "game";
        }
        else if (nameField.getText().length() < 6 || nameField.getText().length() > 21){
            errorField.setText("Name size 6-21 char");
            errorField.setVisible(true);
        }
        else if (typeHero.equals("null")) {
            errorField.setText("Please choose type hero");
            errorField.setVisible(true);
        }
    }

    private void initHeroesData() {
        Hero[] hero = new Hero[]{
                FactoryHero.newHero("", "Warrior"),
                FactoryHero.newHero("", "Archer"),
                FactoryHero.newHero("", "Rogue"),
                FactoryHero.newHero("", "Monk")
        };
        heroesData.setBounds(100, 100, 200, 350);
        String s = " _______________________\n";
        for (Hero x : hero) {
            s += (" Attributes hero: " + x.getType() + "\n");
            s += (" Attack: " + (x.getAttack() - x.getInventory().getWeapon().getDamage()) + "\n");
            s += (" Defence: " + (x.getDefence() - x.getInventory().getArmor().getDefence()) + "\n");
            s += (" Hp: " + (x.getHp() - x.getInventory().getArmor().getDefence()) + "\n");
            s += (" _______________________\n");
        }
        heroesData.setText(s);
    }

    private void initGameWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Swingy");
        setVisible(true);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setBounds(dimension.width / 4, dimension.height / 4, 1000, 1000);
    }

    private void initButton() {
        buttonOne = new JButton();
        buttonTwo = new JButton();
        buttonThree = new JButton();
        buttonFour = new JButton();
        buttonOkay = new JButton("Okay");

        setCenterButtons();
    }

    private void initTextField() {
        nameField = new JTextField(42);
        errorField = new JTextArea();
        errorField.setEditable(false);
        heroesData = new JTextArea();
        heroesData.setEditable(false);
        heroesData.setSelectedTextColor(new Color(0xEEEEEE));
        heroesData.setBorder(new RoundedBorder(1));

        noteOne = new JTextArea();
        noteOne.setEditable(false);
    }

    private void setCenterButtons() {
        buttonOne.setBounds(300, 800, 100, 100);
        buttonTwo.setBounds(400, 800, 100, 100);
        buttonThree.setBounds(500, 800, 100, 100);
        buttonFour.setBounds(600, 800, 100, 100);
    }

    private void buttonOkayCenter() {
        buttonOkay.setBounds(450, 700, 100, 100);
    }

    private void initPanel() {
        panelStartView = new Panel();
        panelStartView.setBounds(200, 200, 400, 400);
        panelStartView.setLayout(null);

        panelStartView.add(buttonOne);
        panelStartView.add(buttonTwo);
        panelStartView.add(buttonThree);
        panelStartView.add(buttonFour);
        panelStartView.add(buttonOkay);
        panelStartView.add(nameField);
        panelStartView.add(errorField);
        panelStartView.add(heroesData);
        panelStartView.add(noteOne);
        panelStartView.setBackground(Color.darkGray);
        add(panelStartView);
    }
}