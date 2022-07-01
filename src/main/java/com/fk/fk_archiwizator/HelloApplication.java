package com.fk.fk_archiwizator;

import com.fk.fk_archiwizator.controllers.HelloController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/hello.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Archiwizator");
        stage.setScene(scene);
        HelloController.setMainStage(stage);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}