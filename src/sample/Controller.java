package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import models.Settings;
import windows.GameWindowController;

import java.io.IOException;
import java.util.Objects;

public class Controller {
    @FXML
    private Button _start;
    @FXML
    private RadioButton _speed05;
    @FXML
    private RadioButton _speed1;
    @FXML
    private RadioButton _speed2;

    Settings settings = new Settings();

    private Scene scene;
    public void setScene(Scene scene) {
        this.scene = scene;
        _start.setOnAction(actionEvent -> {
            try {
                showGameWindow();
            }
            catch (Exception e){
                Main.showError(e);
            }
        });
    }

    private void showGameWindow() throws IOException {
        var loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("../windows/GameWindow.fxml")));
        var root = (Parent)loader.load();

        var stage = new Stage();
        stage.initOwner(scene.getWindow());
        stage.setScene(new Scene(root, 400, 500));
        stage.show();

        var controller = loader.<GameWindowController>getController();
        if (_speed05.isSelected())
            settings.setTimerDuration(0.5);
        if (_speed1.isSelected())
            settings.setTimerDuration(1);
        if (_speed2.isSelected())
            settings.setTimerDuration(2);
        controller.init(stage,settings);
        controller.setScene(stage.getScene());
    }
}
