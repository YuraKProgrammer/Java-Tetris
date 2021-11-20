package sample;

import impl.UserRecordStorage;
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
import windows.RecordsWindowController;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Controller {
    @FXML
    private Button _start;
    @FXML
    private Button _records;
    @FXML
    private RadioButton _speed01;
    @FXML
    private RadioButton _speed025;
    @FXML
    private RadioButton _speed05;
    @FXML
    private RadioButton _speed1;
    @FXML
    private RadioButton _speed2;
    @FXML
    private RadioButton _speed4;
    @FXML
    private RadioButton _bgBlack;
    @FXML
    private RadioButton _bgWhite;
    @FXML
    private RadioButton _bgRed;
    @FXML
    private RadioButton _bgBlue;
    @FXML
    private RadioButton _bgYellow;
    @FXML
    private RadioButton _bgGreen;
    @FXML
    private RadioButton _fiBlack;
    @FXML
    private RadioButton _fiWhite;
    @FXML
    private RadioButton _fiRed;
    @FXML
    private RadioButton _fiBlue;
    @FXML
    private RadioButton _fiYellow;
    @FXML
    private RadioButton _fiGreen;
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
        _records.setOnAction(actionEvent -> {
            try {
                showRecordsWindow();
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
        stage.setTitle("Тетрис");
        stage.setScene(new Scene(root, 400, 500));
        stage.show();

        var controller = loader.<GameWindowController>getController();
        if (_speed01.isSelected())
            settings.setTimerDuration(0.1);
        if (_speed025.isSelected())
            settings.setTimerDuration(0.25);
        if (_speed05.isSelected())
            settings.setTimerDuration(0.5);
        if (_speed1.isSelected())
            settings.setTimerDuration(1);
        if (_speed2.isSelected())
            settings.setTimerDuration(2);
        if (_speed4.isSelected())
            settings.setTimerDuration(4);
        if (_bgBlack.isSelected())
            settings.setBackgroundColor(Color.BLACK);
        if (_bgWhite.isSelected())
            settings.setBackgroundColor(Color.WHITE);
        if (_bgRed.isSelected())
            settings.setBackgroundColor(Color.RED);
        if (_bgBlue.isSelected())
            settings.setBackgroundColor(Color.BLUE);
        if (_bgYellow.isSelected())
            settings.setBackgroundColor(Color.YELLOW);
        if (_bgGreen.isSelected())
            settings.setBackgroundColor(Color.GREEN);
        if (_fiBlack.isSelected()) {
            settings.setFigureColor(Color.DARK_GRAY);
            settings.setBlockColor(Color.BLACK);
        }
        if (_fiWhite.isSelected()) {
            settings.setFigureColor(Color.WHITE);
            settings.setBlockColor(new Color(150, 150, 150));
        }
        if (_fiRed.isSelected()) {
            settings.setFigureColor(Color.RED);
            settings.setBlockColor(new Color(150, 0, 0));
        }
        if (_fiBlue.isSelected()) {
            settings.setFigureColor(Color.BLUE);
            settings.setBlockColor(new Color(0, 0, 150));
        }
        if (_fiYellow.isSelected()) {
            settings.setFigureColor(Color.YELLOW);
            settings.setBlockColor(new Color(150, 150, 0));
        }
        if (_fiGreen.isSelected()) {
            settings.setFigureColor(Color.GREEN);
            settings.setBlockColor(new Color(0, 150, 0));
        }
        controller.init(stage,settings);
        controller.setScene(stage.getScene());
    }

    private void showRecordsWindow() throws IOException {
        var loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("../windows/RecordsWindow.fxml")));
        var root = (Parent)loader.load();

        var stage = new Stage();
        stage.initOwner(scene.getWindow());
        stage.setTitle("Рекорды");
        stage.setScene(new Scene(root, 500, 175));
        stage.show();

        var controller = loader.<RecordsWindowController>getController();

        controller.init(stage,new UserRecordStorage());
        controller.setScene(stage.getScene());
    }
}
