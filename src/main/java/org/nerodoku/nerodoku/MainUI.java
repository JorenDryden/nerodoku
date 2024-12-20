package org.nerodoku.nerodoku;

import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class MainUI extends BorderPane {

    private final Model model = new Model();

    private final BoardView boardView = new BoardView(model);

    private final SelectionWidget selectionWidget = new SelectionWidget();

    public MainUI() {
        super();
        this.getStyleClass().add("root");

        VBox panel = new VBox(boardView, selectionWidget);
        panel.setAlignment(Pos.CENTER);
        this.setCenter(panel);
    }

    public SelectionWidget getSelectionWidget() {
        return selectionWidget;
    }
}
