package com.student.asvirido.swingy.view.gui;

import com.student.asvirido.swingy.module.artefact.armor.Armor;
import com.student.asvirido.swingy.module.artefact.armor.FactoryArmor;
import com.student.asvirido.swingy.module.artefact.helm.FactoryHelm;
import com.student.asvirido.swingy.module.artefact.helm.Helm;
import com.student.asvirido.swingy.module.artefact.weapon.FactoryWeapon;
import com.student.asvirido.swingy.module.artefact.weapon.Weapon;
import com.student.asvirido.swingy.module.hero.FactoryHero;
import com.student.asvirido.swingy.module.hero.Hero;
import com.student.asvirido.swingy.module.monster.Monster;
import javafx.geometry.Bounds;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class GameView extends JFrame {
    private Panel panelStartView;
    private JButton buttonOne;
    private JButton buttonTwo;
    private JButton buttonThree;
    private JButton buttonFour;
    private JTextField nameField;
    private JTextArea errorField;
    private JTextArea heroesData;
    private JTextArea noteOne;

    private Font fontSmall;
    private Font fontNorm;

    private String statusStartView;
    private String typeHero;
    private String nameHero;
    private String direction;
    private boolean isTakeLoot;
    private JSONObject loot;

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

        fontNorm = heroesData.getFont();
        fontSmall = fontNorm.deriveFont(fontNorm.getSize() * 0.8F);
    }

    public void displayStartView()  {
        offAll();
        setCenterTwoButtons();
        buttonOne.setVisible(true);
        buttonTwo.setVisible(true);
        buttonOne.setText("Create Hero");
        buttonTwo.setText("Select Hero");
    }

    public void displayBattleView(final Hero hero, final Monster monster) {
        offAll();
        setCenterTwoButtons();
        buttonOne.setVisible(true);
        buttonTwo.setVisible(true);
        buttonOne.setText("Fight");
        buttonTwo.setText("Run");

        initBattleMap(hero, monster);
    }

    public void displayCreateHeroView() {
        offAll();
        typeHero = "null";
        nameHero = "null";
        errorField.setText("ERROR TEXT");
        setCenterButtons();
        buttonOne.setText("Archer");
        buttonTwo.setText("Warrior");
        buttonThree.setText("Monk");
        buttonFour.setText("Rogue");
        noteOne.setText("Name:");
        buttonOne.setVisible(true);
        buttonTwo.setVisible(true);
        buttonThree.setVisible(true);
        buttonFour.setVisible(true);
        heroesData.setVisible(true);
        nameField.setVisible(true);
        noteOne.setVisible(true);
        heroesData.setBackground(new Color(0xEEEEEE));
        nameField.setBounds(450, 600, 100, 42);
        noteOne.setBounds(410, 610, 40,42);
        noteOne.setBackground(Color.darkGray);
        errorField.setBounds(400, 100, 215, 20);
        heroesData.setFont(fontNorm);
        initHeroesDataCreateHero();
    }

    public void displaySelectHeroView(int amountHero, Hero heroes[]) {
        offAll();
        typeHero = "null";
        heroesData.setVisible(true);
        heroesData.setBackground(new Color(0xEEEEEE));
        if (amountHero == 4) {
            heroesData.setBounds(25, 0, 170, 1000);
            heroesData.setFont(fontSmall);
            setCenterButtons();
            buttonFour.setVisible(true);
            buttonThree.setVisible(true);
            buttonTwo.setVisible(true);
            buttonOne.setVisible(true);
            buttonOne.setText(heroes[0].getType());
            buttonTwo.setText(heroes[1].getType());
            buttonThree.setText(heroes[2].getType());
            buttonFour.setText(heroes[3].getType());
        }
        else if (amountHero == 3) {
            heroesData.setBounds(25, 10, 170, 850);
            heroesData.setFont(fontNorm);
            setCenterThreeButtons();
            buttonThree.setVisible(true);
            buttonTwo.setVisible(true);
            buttonOne.setVisible(true);
            buttonOne.setText(heroes[0].getType());
            buttonTwo.setText(heroes[1].getType());
            buttonThree.setText(heroes[2].getType());
        }
        else if (amountHero == 2) {
            heroesData.setBounds(25, 200, 170, 580);
            heroesData.setFont(fontNorm);
            setCenterTwoButtons();
            buttonTwo.setVisible(true);
            buttonOne.setVisible(true);
            buttonOne.setText(heroes[0].getType());
            buttonTwo.setText(heroes[1].getType());
        }
        else if (amountHero == 1) {
            heroesData.setBounds(25, 300, 170, 300);
            heroesData.setFont(fontNorm);
            setCenterOneButtons();
            buttonOne.setText(heroes[0].getType());
            buttonOne.setVisible(true);
        }
        initHeroesDataSelectHero(heroes);
    }

    public void displayGameView(final Hero hero) {
        heroesData.setFont(fontNorm);
        statusStartView = "game";
        direction = "null";
        offAll();
        setCenterButtons();
        buttonFour.setVisible(true);
        buttonThree.setVisible(true);
        buttonTwo.setVisible(true);
        buttonOne.setVisible(true);
        buttonOne.setText("North");
        buttonTwo.setText("East");
        buttonThree.setText("South");
        buttonFour.setText("West");
        initMapGame(hero);
    }

    public void displayDeath(final Monster m) {
        offAll();
        buttonOne.setBounds(450, 700, 100, 100);
        buttonOne.setText("Okay");
        statusStartView = "death";
        errorField.setVisible(true);
        if (m.getType().equals("Death")) {
            errorField.setBounds(450, 100, 100, 60);
            errorField.setText(" A-HA-HA-HA " + "\n It's your time." + "\n You die.\n");
        }
        else {
            errorField.setBounds(450, 100, 400, 20);
            errorField.setText("Don't worry, if you die.");
        }
        buttonOne.setVisible(true);
    }

    public void displayWin(final Hero hero, final Monster m, JSONObject typeArtefact, boolean isLoot) {
        offAll();
        buttonOne.setVisible(true);
        this.loot = typeArtefact;
        isTakeLoot = false;
        errorField.setText("You win." + "\n" + "You got " + m.getExp() + " exp.\n");
        errorField.setVisible(true);
        errorField.setBounds(450, 100, 150, 60);
        if (isLoot) {
            setCenterTwoButtons();
            buttonTwo.setVisible(true);
            buttonOne.setText("Take");
            buttonTwo.setText("Don't touch");
            initLootData(hero, typeArtefact);
        }
        else {
            buttonOne.setBounds(450, 700, 100, 100);
            buttonOne.setText("Okay");
        }
    }

    public String getStatusStartView() {
        return (statusStartView);
    }

    public String getTypeHero() {return typeHero;}

    public String getNameHero() {return nameHero;}

    public JSONObject getLoot() {return loot;}

    public String getDirection() {return direction;}

    public boolean getIsTakeLoot() {return isTakeLoot;}

    public boolean getErrorFieldStatusVisible() {
        return (errorField.isVisible());
    }

    public void setBoundsError(int x, int y, int w, int h) {
        errorField.setBounds(x, y, w, h);
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
                else if (statusStartView.equals("Select Hero")) {
                    typeHero = buttonOne.getText();
                }
                else if (statusStartView.equals("game")) {
                    direction = buttonOne.getText();
                }
                else if (statusStartView.equals("battle")) {
                    statusStartView = "Fight";
                }
                else if (statusStartView.equals("death")) {
                    statusStartView = "start";
                }
                else if (statusStartView.equals("win")) {
                    if (buttonOne.getText().equals("Okay")) {
                        statusStartView = "game";
                    }
                    else {
                        isTakeLoot = true;
                        statusStartView = "game";
                    }
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
                else if (statusStartView.equals("Select Hero")) {
                    typeHero = buttonTwo.getText();
                }
                else if (statusStartView.equals("game")) {
                    direction = buttonTwo.getText();
                }
                else if (statusStartView.equals("battle")) {
                    statusStartView = "Run";
                }
                else if (statusStartView.equals("win")) {
                    statusStartView = "game";
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
                else if (statusStartView.equals("Select Hero")) {
                    typeHero = buttonThree.getText();
                }
                else if (statusStartView.equals("game")) {
                    direction = buttonThree.getText();
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
                else if (statusStartView.equals("Select Hero")) {
                    typeHero = buttonFour.getText();
                }
                else if (statusStartView.equals("game")) {
                    direction = buttonFour.getText();
                }
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
            nameHero = nameField.getText();
            statusStartView = "game";
        }
        else if (nameField.getText().length() < 6 || nameField.getText().length() > 21){
            errorField.setText("Name size 6-21 char");
            errorField.setVisible(true);
            errorField.setBounds(400, 100, 215, 20);
        }
        else if (typeHero.equals("null")) {
            errorField.setText("Please choose type hero");
            errorField.setVisible(true);
            errorField.setBounds(400, 100, 215, 20);
        }
    }

    private void initMapGame(final Hero hero) {
        int size = (hero.getLevel() - 1) * 5 + 10 - (hero.getLevel() % 2);

        heroesData.setBounds(450, 400, 500, 500);
        heroesData.setBackground(Color.darkGray);
        String s = " ";

        s += '\n';
        for (int y = 0; y < size; y++) {
            s += "|";
            for (int x = 0; x < size; x++) {
                if (x == hero.getPosition().getX() && y == hero.getPosition().getY()) {
                    s += "P";
                }
                else {
                    s += "#";
                }
            }
            s += "|\n";
        }
        heroesData.setVisible(true);
        heroesData.setText(s);
    }

    private void initHeroesDataCreateHero() {
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

    private void initLootData(final Hero hero, JSONObject typeArtefact) {
        heroesData.setVisible(true);
        heroesData.setBounds(20, 100, 350, 200);
        heroesData.setBackground(new Color(0xEEEEEE));
        String s = "";
            s += (" _______________________________________" + "\n");
            s += (" Hero Weapon: " + hero.getInventory().getWeapon().getType() + " - damage: " + hero.getInventory().getWeapon().getDamage()+ "\n");
            s += (" Hero Armor: " + hero.getInventory().getArmor().getType() + " - dafence: " + hero.getInventory().getArmor().getDefence()+ "\n");
            s += (" Hero Helm: " + hero.getInventory().getHelm().getType() + " - bonusHp:" + hero.getInventory().getHelm().getBonusHp()+ "\n");
            s += (" _______________________________________" + "\n");
            s += (" Loot" + "\n");
            s += (" _______________________________________"+ "\n");
            try {
                Object ob = (String) typeArtefact.get("Weapon");
                if (ob.equals("null")) {
                    throw new Exception("");
                }
                Weapon a = FactoryWeapon.newWeapon(ob.toString());
                s += (" " + a.getType() + ": damage " +  a.getDamage() + "\n");
            }
            catch (Exception e) { }

            try {
                Object ob = (String) typeArtefact.get("Helm");
                if (ob.equals("null")) {
                    throw new Exception("");
                }
                Helm a = FactoryHelm.newHelm(ob.toString());
                s += (" " + a.getType() + ": bonusHp " +  a.getBonusHp() + "\n");
            }
            catch (Exception e) { }

            try {
                Object ob = (String) typeArtefact.get("Armor");
                if (ob.equals("null")) {
                    throw new Exception("");
                }
                Armor a = FactoryArmor.newArmor(ob.toString());
                s += (" " + a.getType() + ": dafence " +  a.getDefence() + "\n");
            }
            catch (Exception e) { }
            s += (" _______________________________________") + "\n";
            heroesData.setText(s);
    }

    private void initBattleMap(final Hero hero, final Monster monster) {
        String s = "";
        heroesData.setVisible(true);
        heroesData.setBounds(20, 100, 200, 200);
        heroesData.setBackground(new Color(0xEEEEEE));
        s += (" ___________________" + "\n");
        s +=(" " + hero.getName()+ "\n");
        s +=(" Attack : " + hero.getAttack()+ "\n");
        s +=(" Defence : " + hero.getDefence()+ "\n");
        s +=(" Hp : " + hero.getHp() + "/" + hero.getMaxHp())+ "\n";
        s +=(" Exp : " + hero.getExp() + "/" + hero.getNeedExp() + "\n");
        s +=(" ___________________"+ "\n");

        if (!monster.getType().equals("Death")) {
            s +=(" Monster: " + monster.getType()+ "\n");
            s +=(" Attack : " + monster.getAttack()+ "\n");
            s +=(" Defence : " + monster.getDefence()+ "\n");
            s +=(" Hp : " + monster.getHp()+ "\n");
            s +=(" ___________________"+ "\n");
        }
        heroesData.setText(s);
    }

    private void initHeroesDataSelectHero(Hero[] heroes) {
        String s = " _______________________\n";
        for (Hero x : heroes) {
            s += x.getLog();
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

        setCenterButtons();
    }

    private void initTextField() {
        nameField = new JTextField(42);
        errorField = new JTextArea();
        errorField.setEditable(false);
        heroesData = new JTextArea();
        heroesData.setEditable(false);
        heroesData.setSelectedTextColor(new Color(0xEEEEEE));

        noteOne = new JTextArea();
        noteOne.setEditable(false);
    }

    private void setCenterButtons() {
        buttonOne.setBounds(300, 800, 100, 100);
        buttonTwo.setBounds(400, 800, 100, 100);
        buttonThree.setBounds(500, 800, 100, 100);
        buttonFour.setBounds(600, 800, 100, 100);
    }

    private void setCenterThreeButtons() {
        buttonOne.setBounds(300, 800, 100, 100);
        buttonTwo.setBounds(450, 800, 100, 100);
        buttonThree.setBounds(600, 800, 100, 100);
    }

    private void setCenterTwoButtons() {
        buttonOne.setBounds(300, 800, 100, 100);
        buttonTwo.setBounds(600, 800, 100, 100);
    }

    private void setCenterOneButtons() {
        buttonOne.setBounds(450, 800, 100, 100);
    }

    private void offAll() {
        buttonOne.setVisible(false);
        buttonTwo.setVisible(false);
        buttonThree.setVisible(false);
        buttonFour.setVisible(false);
        nameField.setVisible(false);
        errorField.setVisible(false);
        heroesData.setVisible(false);
        noteOne.setVisible(false);
    }

    private void initPanel() {
        panelStartView = new Panel();
        panelStartView.setBounds(200, 200, 400, 400);
        panelStartView.setLayout(null);

        panelStartView.add(buttonOne);
        panelStartView.add(buttonTwo);
        panelStartView.add(buttonThree);
        panelStartView.add(buttonFour);
        panelStartView.add(nameField);
        panelStartView.add(errorField);
        panelStartView.add(heroesData);
        panelStartView.add(noteOne);
        panelStartView.setBackground(Color.darkGray);
        add(panelStartView);
    }
}