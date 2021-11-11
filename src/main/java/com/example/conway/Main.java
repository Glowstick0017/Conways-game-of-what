package com.example.conway;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("conway.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Life life = new Life(45,25);
        ConwayController cc = fxmlLoader.getController();
        cc.setLife(life);
        cc.setFxmlLoader(fxmlLoader);
        life.init(fxmlLoader);
        stage.setTitle("Conway's Game of Life");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}