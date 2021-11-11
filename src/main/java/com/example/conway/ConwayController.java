package com.example.conway;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class ConwayController {
    public GridPane gameGrid;
    public Button startStop;
    private Life life;
    private FXMLLoader fxmlLoader;

    public void cellClicked(MouseEvent mouseEvent) {
        Pane p = (Pane) mouseEvent.getSource();
        String[] coord;
        int row = 0;
        int column = 0;
        try {
            coord = p.getId().split(",");
            row = Integer.parseInt(coord[0]);
            column = Integer.parseInt(coord[1]);
        } catch (NumberFormatException ignored) {}
        if (Life.getGrid()[row][column] == 0) {
            p.setStyle("-fx-background-color:#097adb;-fx-border-color: #1c1c1e;-fx-border-width: 1;");
            Life.setGrid(true,row,column);
        } else {
            p.setStyle("-fx-background-color:#535358;-fx-border-color: #1c1c1e;-fx-border-width: 1;");
            Life.setGrid(false,row,column);
        }
    }

    public static void changeCell(Scene scene, int row, int col, int[][] grid) {
        Pane p = (Pane) scene.lookup("#" + row  + "," + col);
        if (grid[row][col] == 1) {
            p.setStyle("-fx-background-color:#097adb;-fx-border-color: #1c1c1e;-fx-border-width: 1;");
        } else {
            p.setStyle("-fx-background-color:#535358;-fx-border-color: #1c1c1e;-fx-border-width: 1;");
        }
    }

    public void startStopClicked(ActionEvent event) {
        AnimationTimer runAnimation = new AnimationTimer() {
            private long lastUpdate = 0;

            @Override
            public void handle(long now) {
                // only update once every second
                if ((now - lastUpdate) >= TimeUnit.MILLISECONDS.toNanos(500)) {
                    life.tick(startStop.getScene());
                    lastUpdate = now;
                }
                if (startStop.getText().equals("Start")) {
                    this.stop();
                }
            }
        };
        if (startStop.getText().equals("Start")) {
            runAnimation.start();
            startStop.setText("Stop");
        } else {
            startStop.setText("Start");
        }
    }

    public void helpClicked(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("help.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.setAlwaysOnTop(true);
        stage.getIcons().add(new Image(Objects.requireNonNull(Main.class.getResourceAsStream("icon.png"))));
        stage.show();

    }

    public void setLife(Life life) {
        this.life = life;
    }

    public void resetClicked(ActionEvent event) {
        life.reset(startStop.getScene());
    }

    public void setFxmlLoader(FXMLLoader fxmlLoader) {
        this.fxmlLoader = fxmlLoader;
    }
}
