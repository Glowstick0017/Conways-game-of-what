package com.example.conway;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class ConwayController {
    public GridPane gameGrid;
    public Button startStop;


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

    public void startStopClicked(ActionEvent event) {
        if (startStop.getText().equals("Start")) {
            startStop.setText("Stop");
        } else {
            startStop.setText("Start");
        }
    }

    public void helpClicked(ActionEvent event) {
    }
}
