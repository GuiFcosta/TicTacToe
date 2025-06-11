package pt.isec.pa.tictactoe.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import pt.isec.pa.tictactoe.model.GameManager;

import java.util.Objects;

public class MainJFX extends Application {
    GameManager gameManager = new GameManager();

    @Override
    public void start(Stage stage){
        createStage(stage);
    }
    public void createStage(Stage stage) {
        RootPane root = new RootPane(gameManager);
        Scene scene = new Scene(root, 680, 720);

        // Add the canvas and menu bar to the scene
        stage.setTitle("TicTacToe");
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("res/images/Tictactoe.png"))));
        stage.setScene(scene);
        stage.show();
    }
}
