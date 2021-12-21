package corn_snake.facade.controllers;

import corn_snake.util.IO;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML
    private AnchorPane window;

    @FXML
    private ImageView backgroundView, titleView, playButton, controlsButton, leaderboardButton, creditsButton, exitButton;

    @FXML
    private Label playLabel;

    // Images used in the title screen
    private final static Image
            BACKGROUND = new Image(MenuController.class.getResource("menu/TitleBG.png").toExternalForm()),
            TITLE = new Image(MenuController.class.getResource("menu/Title.png").toExternalForm()),
            PLAY = new Image(MenuController.class.getResource("menu/PlayButton.png").toExternalForm()),
            CONTROLS = new Image(MenuController.class.getResource("menu/ControlsButton.png").toExternalForm()),
            LEADERBOARD = new Image(MenuController.class.getResource("menu/LeaderboardButton.png").toExternalForm()),
            CREDITS = new Image(MenuController.class.getResource("menu/CreditsButton.png").toExternalForm()),
            EXIT = new Image(MenuController.class.getResource("menu/ExitButton.png").toExternalForm());

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backgroundView.setImage(BACKGROUND);

        // Loads all visuals with a 0.2 seconds delay between each image/button
        Timeline load = new Timeline(
                new KeyFrame(Duration.seconds(0.2), (event) -> titleView.setImage(TITLE)),
                new KeyFrame(Duration.seconds(0.4), (event) -> {
                    playButton.setImage(PLAY);
                    playLabel.setText("PLAY");
                }),
                new KeyFrame(Duration.seconds(0.6), (event) -> controlsButton.setImage(CONTROLS)),
                new KeyFrame(Duration.seconds(0.8), (event) -> leaderboardButton.setImage(LEADERBOARD)),
                new KeyFrame(Duration.seconds(1), (event) -> creditsButton.setImage(CREDITS)),
                new KeyFrame(Duration.seconds(1.2), (event) -> exitButton.setImage(EXIT))
        );
        load.setDelay(Duration.seconds(0.5));

        load.play();
    }

    @FXML
    public void onExitClick() {
        System.exit(0);
    }

    @FXML
    public void onPlayClick(MouseEvent event) throws IOException {
        Stage stage = (Stage) window.getScene().getWindow();
        IO.loadScene(stage, "game_field.fxml", FieldController.class, "field/FieldStyle.css");
    }

    @FXML
    public void onCreditsClick(MouseEvent event) throws IOException {
        Stage stage = (Stage) window.getScene().getWindow();

        IO.loadScene(stage, "credits.fxml", CreditsController.class);
    }

    @FXML
    public void onLeaderboardClick(MouseEvent event) throws IOException {
        Stage stage = (Stage) window.getScene().getWindow();

        IO.loadScene(stage, "leaderboard.fxml", LeaderboardController.class);
    }

    @FXML
    public void onHowToPlayClick(MouseEvent event) throws IOException {
        Stage stage = (Stage) window.getScene().getWindow();

        IO.loadScene(stage, "how_to_play.fxml", HowToPlayController.class);
    }
    /*
    private class LoadButtons implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1_000);
                titleView.setImage(title);
                Thread.sleep(500);
                playButton.setImage(play);
                Thread.sleep(500);
                controlsButton.setImage(controls);
                Thread.sleep(500);
                leaderboardButton.setImage(leaderboard);
                Thread.sleep(500);
                creditsButton.setImage(credits);
                Thread.sleep(500);
                exitButton.setImage(exit);
            } catch (InterruptedException e) {

            }
        }
    }*/
}
