package org.nerodoku.nerodoku;

import javafx.scene.control.TextField;

public class Cell extends TextField implements Subscriber {

    private Integer value;

    public Cell(Integer value) {
        this.value = value;

        this.getStyleClass().add("cell");
        this.setEditable(false);

        modelChanged();
    }

    public void setCellTextColor(String color) {
        this.setStyle("-fx-text-fill: " + color + ";");
    }

    public void setCellBackgroundColor(String color) {
        this.setStyle("-fx-background-color: " + color + ";");
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public void modelChanged() {
        this.setText(value == null ? "" : value.toString());
    }
}
