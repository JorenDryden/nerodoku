package org.nerodoku.nerodoku;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) throws Exception {
        MainUI mainUI = new MainUI();

        Scene scene = new Scene(mainUI, 1200, 800);
        mainUI.getStylesheets().add(Objects.requireNonNull(Application.class.getResource("/styles.css")).toExternalForm());

        stage.setTitle("Nerodoku");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
