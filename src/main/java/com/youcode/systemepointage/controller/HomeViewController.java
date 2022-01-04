package com.youcode.systemepointage.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;

public class HomeViewController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        System.out.println("first test");
    }

    public void handleButtonAction(ActionEvent actionEvent) {
    }
}