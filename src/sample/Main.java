package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        var loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("StartWindow.fxml")));
        var root = (Parent)loader.load();
        primaryStage.setTitle("Тетрис");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        var controller = loader.<Controller>getController();
        controller.setScene(primaryStage.getScene());
    }

    public static void showError(Exception exc) {
        System.out.println(exc);
        var alert = new Alert(Alert.AlertType.ERROR, exc.getMessage());
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
