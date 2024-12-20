package org.nerodoku.nerodoku;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class BoardView extends StackPane {

    private Cell selectedCell = null;

    private final Canvas canvas = new Canvas(GRID_SIZE * CELL_SIZE, GRID_SIZE * CELL_SIZE);

    private static final int GRID_SIZE = 9;

    private static final int CELL_SIZE = 50;

    private final GridPane grid = new GridPane();

    private final Model model;

    public BoardView(Model model) {
        this.model = model;
        this.getStyleClass().add("boardview");

        grid.setGridLinesVisible(true);
        grid.setAlignment(Pos.CENTER);

        model.getLiveBoard().generateHard();
        initialize();

        drawOverlayGrid();
        canvas.setMouseTransparent(true);

        this.getChildren().addAll(grid, canvas);
    }

    public void initialize() {
        for(int i = 0; i < GRID_SIZE; i++){
            for(int j = 0; j < GRID_SIZE; j++){
                Cell cell = new Cell(model.getLiveBoard().get(i).get(j));
                cell.setOnMouseClicked(e -> {
                    if (selectedCell != cell && selectedCell != null) {
                        selectedCell.setCellBackgroundColor("#494949");
                    }
                    selectedCell = cell;
                    cell.setCellBackgroundColor("#8C568F");
                });
                cell.setCellTextColor("#9E4DC5");
                grid.add(cell, i, j);
            }
        }
    }

    private void drawOverlayGrid() {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setStroke(Color.DARKGREY);
        gc.setLineWidth(2);

        for (int i = 0; i <= GRID_SIZE; i++) {
            double width = (i % 3 == 0) ? 4 : 1;
            gc.setLineWidth(width);

            double x = i * CELL_SIZE;
            gc.strokeLine(x, 0, x, canvas.getHeight());

            double y = i * CELL_SIZE;
            gc.strokeLine(0, y, canvas.getWidth(), y);
        }
    }
}
