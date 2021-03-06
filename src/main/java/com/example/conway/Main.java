package com.example.conway;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    private static HostServices hostServices;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("conway.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 620, 400);
        Life life = new Life(45,25);
        ConwayController cc = fxmlLoader.getController();
        cc.setLife(life);
        life.init(fxmlLoader);
        stage.setTitle("Conway's Game of Life");
        stage.setScene(scene);
        stage.setAlwaysOnTop(true);
        stage.getIcons().add(new Image(Objects.requireNonNull(Main.class.getResourceAsStream("icon.png"))));
        stage.show();
        hostServices = getHostServices();
    }

    public static void main(String[] args) {
        launch();
    }

    public static HostServices getHS() {
        return hostServices;
    }
}