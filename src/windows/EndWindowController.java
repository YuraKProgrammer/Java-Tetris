package windows;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.Main;

public class EndWindowController {
    @FXML
    private Text _score;

    private Scene scene;

    private double score=0;

    public void setScene(Scene scene) {
        this.scene = scene;
        try {
             _score.setText("Счёт: " + score);
        }
        catch (Exception e){
            Main.showError(e);
        }
    }
    public void init(Stage stage, double score) {
        this.score=score;
    }
}
