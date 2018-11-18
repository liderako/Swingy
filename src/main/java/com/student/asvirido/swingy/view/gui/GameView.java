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
    private JButton createHeroButton;
    private JButton selectHeroButton;
    private String statusStartView;
    private int flag;

    public GameView() {
        initGameWindow();
        statusStartView = "start";
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
        createHeroButton = new JButton("Create Hero");
        selectHeroButton = new JButton("Select Hero");

        createHeroButton.setBounds(100, 100, 200, 200);
        selectHeroButton.setBounds(600, 100, 200, 200);
    }

    private void initPanel() {
        panelStartView = new Panel();
        panelStartView.setBounds(200, 200, 400, 400);
        panelStartView.setLayout(null);
        panelStartView.add(createHeroButton);
        panelStartView.add(selectHeroButton);
    }

    private void createButtonListen() {
        createHeroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statusStartView = "Create Hero";
            }
        });
    }

    private void selectHeroButtonListener() {
        selectHeroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statusStartView = "Select Hero";
            }
        });
    }

    public void displayStartView()  {
        if (flag == 0) {
            initButton();
            initPanel();
            createButtonListen();
            selectHeroButtonListener();
            panelStartView.setVisible(true);
            add(panelStartView);
            flag = 1;
        }
    }

    public void switchOffStartView() {
        panelStartView.setVisible(false);
        remove(panelStartView);
    }

    public String getStatusStartView() {
        return (statusStartView);
    }

    public void setStatusStartView(String status) {
        statusStartView = status;
    }
}