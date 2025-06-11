package pt.isec.pa.tictactoe.ui;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import pt.isec.pa.tictactoe.model.GameManager;

public class RootPane extends BorderPane {
    GameManager gameManager;
    GameMenuBar menu;
    GameBoardCanvas boardCanvas;
    Pane boardPane;
    AudioPlayer audioPlayer;

    public RootPane(GameManager gameManager) {
        this.gameManager = gameManager;
        gameManager.reset();

        createViews();
        registerHandlers();
        update();
    }

    private void createViews() {
        this.setStyle("-fx-background-color: #eeeeee;");

        menu = new GameMenuBar(gameManager);
        boardCanvas = new GameBoardCanvas(gameManager);
        boardPane = new Pane(boardCanvas);
        audioPlayer = new AudioPlayer(gameManager, menu);

        this.setTop(gameMenuBar);
        this.setCenter(gameBoardPane);
    }

    private void registerHandlers() {
        boardPane.widthProperty().addListener(observable -> boardCanvas.resizeBoard(getWidth(), getHeight() - menu.getHeight()));
        boardPane.heightProperty().addListener(observable -> boardCanvas.resizeBoard(getWidth(), getHeight() - menu.getHeight()));
    }

    private void update() {}

}
