package com.youcode.systemepointage;

import com.youcode.systemepointage.model.Utilisateur;
import com.youcode.systemepointage.service.UtilisateurService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.EventListener;

public class HomeController {
    private UtilisateurService utilisateurService = new UtilisateurService();

    @FXML
    private Utilisateur utilisateur;
    @FXML
    private TextField email;
    @FXML
    private PasswordField motDePasse;

    @FXML
    private Label errorMsg;

    @FXML
    protected void onLoginButtonClick(ActionEvent event) throws IOException {
        utilisateur = utilisateurService.seConnecter(Utilisateur.builder()
                .email(email.getText())
                .motDePasse(motDePasse.getText())
                .build()
        );

        if(utilisateur != null){
            Parent fxmlLoader = FXMLLoader.load(getClass().getResource("/com.youcode.systemepointage/view/dashboard-view.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxmlLoader);
            stage.setScene(scene);
            stage.show();
        }else{
            errorMsg.setText("Email ou mot de passe incorrect");
        }

    }
}