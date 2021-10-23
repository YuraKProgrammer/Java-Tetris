package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import windows.GameWindowController;

import java.io.IOException;
import java.util.Objects;

public class Controller {
    @FXML
    private Button _start;

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
        controller.init(stage);
        controller.setScene(stage.getScene());
    }
}
