package windows;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.IRecordStorage;
import models.Settings;

import java.util.Arrays;

public class RecordsWindowController {
    @FXML
    private Text _score1;
    @FXML
    private Text _duration1;
    @FXML
    private Text _time1;
    @FXML
    private Text _difficulty1;
    @FXML
    private Text _countOfTurns1;
    @FXML
    private Text _score2;
    @FXML
    private Text _duration2;
    @FXML
    private Text _time2;
    @FXML
    private Text _difficulty2;
    @FXML
    private Text _countOfTurns2;
    @FXML
    private Text _score3;
    @FXML
    private Text _duration3;
    @FXML
    private Text _time3;
    @FXML
    private Text _difficulty3;
    @FXML
    private Text _countOfTurns3;
    @FXML
    private Text _score4;
    @FXML
    private Text _duration4;
    @FXML
    private Text _time4;
    @FXML
    private Text _difficulty4;
    @FXML
    private Text _countOfTurns4;
    @FXML
    private Text _score5;
    @FXML
    private Text _duration5;
    @FXML
    private Text _time5;
    @FXML
    private Text _difficulty5;
    @FXML
    private Text _countOfTurns5;

    private Scene scene;

    public void init(Stage stage, IRecordStorage recordStorage) {
        var records =recordStorage.load();
        if (records.length>0) {
            _score1.setText("Счёт:"+records[0].getScore());
            _duration1.setText("Время(сек):"+records[0].getGameDurationSec());
            _time1.setText(String.valueOf(records[0].getGameTime()));
            _difficulty1.setText(String.valueOf(records[0].getDifficulty()));
            _countOfTurns1.setText("Повороты:"+records[0].getCountOfTurns());
        }
        if (records.length>1){
            _score2.setText("Счёт:"+records[1].getScore());
            _duration2.setText("Время(сек):"+records[1].getGameDurationSec());
            _time2.setText(String.valueOf(records[1].getGameTime()));
            _difficulty2.setText(String.valueOf(records[1].getDifficulty()));
            _countOfTurns2.setText("Повороты:"+records[1].getCountOfTurns());
        }
        if (records.length>2){
            _score3.setText("Счёт:"+records[2].getScore());
            _duration3.setText("Время(сек):"+records[2].getGameDurationSec());
            _time3.setText(String.valueOf(records[2].getGameTime()));
            _difficulty3.setText(String.valueOf(records[2].getDifficulty()));
            _countOfTurns3.setText("Повороты:"+records[2].getCountOfTurns());
        }
        if (records.length>3){
            _score4.setText("Счёт:"+records[3].getScore());
            _duration4.setText("Время(сек):"+records[3].getGameDurationSec());
            _time4.setText(String.valueOf(records[3].getGameTime()));
            _difficulty4.setText(String.valueOf(records[3].getDifficulty()));
            _countOfTurns4.setText("Повороты:"+records[3].getCountOfTurns());
        }
        if (records.length>4){
            _score5.setText("Счёт:"+records[4].getScore());
            _duration5.setText("Время(сек):"+records[4].getGameDurationSec());
            _time5.setText(String.valueOf(records[4].getGameTime()));
            _difficulty5.setText(String.valueOf(records[4].getDifficulty()));
            _countOfTurns5.setText("Повороты:"+records[4].getCountOfTurns());
        }
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }


}
