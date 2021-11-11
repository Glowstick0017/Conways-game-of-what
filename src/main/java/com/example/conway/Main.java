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
        ConwayController cc = fxmlLoader.getController();
        for (int i = 0; i<45; i++) {
            for (int j = 0; j<25; j++) {
                Pane p = new Pane();
                p.setMinHeight(10);
                p.setMinWidth(10);
                p.setStyle("-fx-background-color:#535358;-fx-border-color: #1c1c1e;-fx-border-width: 1;");
                p.setOnMouseClicked(cc::cellClicked);
                p.setId(i + "," + j);
                GridPane.setConstraints(p,i,j);
                cc.gameGrid.getChildren().add(p);
            }
        }
        stage.setTitle("Conway's Game of Life");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}