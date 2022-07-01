package com.fk.fk_archiwizator.controllers;

import com.fk.fk_archiwizator.mail.Connect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class MainScreenController {

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField imapAddress;

    @FXML
    private CheckBox anotherImapServer;

    @FXML
    private ListView emailHeadersFields;

    @FXML
    public void initialize() {

    }

    @FXML
    public void checkedOrNot() { // This function checks checkbox status
        if(anotherImapServer.isSelected()) {
            imapAddress.setDisable(false);
        } else {
            imapAddress.setDisable(true);
            imapAddress.setText("imap.flagi.pl");
        }
    }

    @FXML
    public void logIn() {
        if(!validateData()) {
            System.out.println("Action aborted...");
        } else {
            System.out.println("Data OK. Trying to log in...");
        }

    }

    @FXML
    public void startArchiving() {
        Connect connect = new Connect();
        connect.sendEmail();
    }

    private boolean validateData() {
        if(loginField.getText().isEmpty()) {
            System.out.println("Pole login jest puste");
            loginField.setStyle("-fx-border-color: RED");
            return false;
        } else if (!loginField.getText().contains("@")){
            System.out.println("Niepoprawny format adresu e-mail");
            loginField.setStyle("-fx-border-color: red");
            return false;
        } else {
            loginField.setStyle("-fx-border-color: default");
        }

        if(passwordField.getText().isEmpty()) {
            System.out.println("Pole hasło jest puste");
            passwordField.setStyle("-fx-border-color: red");
            return false;
        } else {
            passwordField.setStyle("-fx-border-color: default");
        }

        return true;
    }

}
