package com.example.conway;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("conway.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        ConwayController cc = fxmlLoader.getController();
        for (int i = 0; i<500; i++) {
            cc.gameGrid.addRow(0, new Tile());
            cc.gameGrid.addColumn(0, new Tile());
        }
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}