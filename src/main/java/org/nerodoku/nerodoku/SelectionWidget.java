package org.nerodoku.nerodoku;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class SelectionWidget extends HBox {

    private Integer selection;

    public SelectionWidget() {
        super(10);
        this.getStyleClass().add("selection-widget");

        initialize();
    }

    public void initialize(){
        for(int i = 1; i <= 9; i++){
            this.getChildren().add(createButton(i));
        }
    }

    public Button createButton(Integer value){
        Button button = new Button(value.toString());
        button.getStyleClass().add("selection-button");
        button.setOnAction(e -> {selection = value;});
        return button;
    }

    public Integer getSelection() {
        return selection;
    }
}
