package com.fk.fk_archiwizator.controllers;

import com.fk.fk_archiwizator.HelloApplication;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class HelloController {

    public static Stage mainStage; // main window

    @FXML
    public void initialize() {

    }

    @FXML
    public void onStartButtonClick() {

        setScene("fxml/mainScreen.fxml");

    }

    @FXML
    public void onVersionButtonClick() {

        setScene("fxml/test.fxml");

    }

    public static void setMainStage(Stage stage) {
        mainStage = stage;
    }

    public void setScene(String pathToFXML) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(pathToFXML));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch(Exception exception) {
            System.out.println("Something is wrong with fxml file... Aborting an action");
            Platform.exit();
        }
        // if file exist, load scene
        mainStage.setScene(scene);
    }

}