package com.example.conway;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Life {
    private static int[][] grid;

    public Life(int rows, int cols) {
        grid = new int[rows][cols];
    }

    public void init(FXMLLoader fxmlLoader) {
        ConwayController cc = fxmlLoader.getController();
        for (int i = 0; i<45; i++) {
            for (int j = 0; j<25; j++) {
                Pane p = new Pane();
                p.setMinHeight(10);
                p.setMinWidth(10);
                p.setStyle("-fx-background-color:#535358;-fx-border-color: #1c1c1e;-fx-border-width: 1;");
                p.setOnMouseClicked(cc::cellClicked);
                p.setId(i + "," + j);
                grid[i][j] = 0;
                GridPane.setConstraints(p,i,j);
                cc.gameGrid.getChildren().add(p);
            }
        }
    }

    public void tick() {
        for (int i = 0; i<45; i++) {
            for (int j = 0; j<25; j++) {
                // if the grid is alive
                if (grid[i][j] == 1) {
                    // if the cell does not have 3 or 3 neighbors
                    if (getAliveNeighbors(i,j) != 2 && getAliveNeighbors(i,j) != 3)
                        // die
                        grid[i][j] = 0;
                    // if the cell is dead
                } else if (grid[i][j] == 0) {
                    // if the cell has 3 neighbors
                    if (getAliveNeighbors(i,j) == 3)
                        // born
                        grid[i][j] = 1;
                }
            }
        }
    }

    public int getAliveNeighbors(int row, int column) {
        return 0;
    }

    public static int[][] getGrid() {
        return grid;
    }

    public static void setGrid(boolean alive, int row, int col) {
        if (alive) {
            grid[row][col] = 1;
        } else {
            grid[row][col] = 0;
        }
    }
}
