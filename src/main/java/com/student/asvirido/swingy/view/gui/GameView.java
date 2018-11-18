package com.student.asvirido.swingy.view.gui;

import com.student.asvirido.swingy.controller.Controller;
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

    private String statusStartView;
    private String typeHero;
    private String nameHero;
    private int flag;

    public GameView() {
        initGameWindow();
        initButton();
        initPanel();
        buttonOneListener();
        buttonTwoListener();
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
    }

    public void displayCreateHeroView() {
        typeHero = "null";
        nameHero = "null";
        setCenterButtons();
        buttonOkayCenter();
        buttonOne.setText("Archer");
        buttonTwo.setText("Warrior");
        buttonThree.setText("Monk");
        buttonFour.setText("Monk");
        buttonOne.setVisible(true);
        buttonTwo.setVisible(true);
        buttonThree.setVisible(true);
        buttonFour.setVisible(true);
        buttonOkay.setVisible(true);
    }

    public String getStatusStartView() {
        return (statusStartView);
    }

    public String getTypeHero() {return typeHero;}

    public String getNameHero() {return nameHero;}

    public void setStatusStartView(String status) {
        statusStartView = status;
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
                }
            }
        });
    }

    private void buttonOkayListener() {
        buttonOkay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (statusStartView.equals("Create Hero")) {
                    if (typeHero.equals("null")) {

                    }
                }
            }
        });
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
        panelStartView.setVisible(true);
        add(panelStartView);
    }
}