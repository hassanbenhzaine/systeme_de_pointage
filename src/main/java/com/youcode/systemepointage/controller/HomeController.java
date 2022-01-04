package com.youcode.systemepointage.controller;

import com.youcode.systemepointage.model.Utilisateur;
import com.youcode.systemepointage.service.UtilisateurService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.EventListener;

public class HomeController {
    private UtilisateurService utilisateurService = new UtilisateurService();

    @FXML
    private Label error;

    @FXML
    protected void onLoginButtonClick(ActionEvent event) throws IOException {
        utilisateurService.seConnecter(new Utilisateur())
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("/com.youcode.systemepointage/view/dashboard-view.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }
}