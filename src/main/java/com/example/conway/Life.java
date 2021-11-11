package com.example.conway;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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

    public void tick(Scene scene) {
        for (int i = 0; i<45; i++) {
            for (int j = 0; j<25; j++) {
                // if the grid is alive
                if (grid[i][j] == 1) {
                    // if the cell does not have 3 or 3 neighbors
                    if (getAliveNeighbors(i,j) != 2 && getAliveNeighbors(i,j) != 3) {
                        // die
                        grid[i][j] = 0;
                        ConwayController.changeCell(scene, i, j);
                    }
                    // if the cell is dead
                } else if (grid[i][j] == 0) {
                    // if the cell has 3 neighbors
                    if (getAliveNeighbors(i,j) == 3) {
                        // born
                        grid[i][j] = 1;
                        ConwayController.changeCell(scene, i, j);
                    }
                }
            }
        }
    }

    public int getAliveNeighbors(int row, int column) {

        // absolutely no idea whats going on here

        int sum = 0;
        int iStart = row == 0 ? 0 : -1;
        int iEndInclusive = row == grid.length - 1 ? 0 : 1;
        int jStart = column == 0 ? 0 : -1;
        int jEndInclusive = column == grid[0].length - 1 ? 0 : 1;

        for (int k = iStart; k <= iEndInclusive; k++) {
            for (int l = jStart; l <= jEndInclusive; l++) {
                sum += grid[row + k][l + column];
            }
        }

        sum -= grid[row][column];

        return sum;
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
