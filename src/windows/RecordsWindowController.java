package windows;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.IRecordStorage;
import models.Record;
import models.Settings;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.Collectors;

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
        records = Arrays
                .stream(records)
                .sorted((r1,r2)->Double.compare(r2.getScore(),r1.getScore()))
                .toArray(Record[]::new);
        if (records.length>0) {
            Record r0 = records[0];
            _score1.setText("Счёт:"+ r0.getScore());
            _duration1.setText("Время(сек):"+ r0.getGameDurationSec());
            _time1.setText(dateToString(r0.getGameTime()));
            _difficulty1.setText("Сложность:"+ r0.getDifficulty());
            _countOfTurns1.setText("Повороты:"+ r0.getCountOfTurns());
        }
        if (records.length>1){
            Record r1 = records[1];
            _score2.setText("Счёт:"+ r1.getScore());
            _duration2.setText("Время(сек):"+ r1.getGameDurationSec());
            _time2.setText(dateToString(r1.getGameTime()));
            _difficulty2.setText("Сложность:"+ r1.getDifficulty());
            _countOfTurns2.setText("Повороты:"+ r1.getCountOfTurns());
        }
        if (records.length>2){
            Record r2 = records[2];
            _score3.setText("Счёт:"+ r2.getScore());
            _duration3.setText("Время(сек):"+ r2.getGameDurationSec());
            _time3.setText(dateToString(r2.getGameTime()));
            _difficulty3.setText("Сложность:"+ r2.getDifficulty());
            _countOfTurns3.setText("Повороты:"+ r2.getCountOfTurns());
        }
        if (records.length>3){
            Record r3 = records[3];
            _score4.setText("Счёт:"+ r3.getScore());
            _duration4.setText("Время(сек):"+ r3.getGameDurationSec());
            _time4.setText(dateToString(r3.getGameTime()));
            _difficulty4.setText("Сложность:"+ r3.getDifficulty());
            _countOfTurns4.setText("Повороты:"+ r3.getCountOfTurns());
        }
        if (records.length>4){
            Record r4 = records[4];
            _score5.setText("Счёт:"+ r4.getScore());
            _duration5.setText("Время(сек):"+ r4.getGameDurationSec());
            _time5.setText(dateToString(r4.getGameTime()));
            _difficulty5.setText("Сложность:"+ r4.getDifficulty());
            _countOfTurns5.setText("Повороты:"+ r4.getCountOfTurns());
        }
    }

    public static String dateToString(Date date) {
        Calendar now = Calendar.getInstance();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH)+1;
        int day = now.get(Calendar.DAY_OF_MONTH);
        int year1 = c.get(Calendar.YEAR);
        int month1 = c.get(Calendar.MONTH)+1;
        int day1 = c.get(Calendar.DAY_OF_MONTH);
        if (year == year1 && month == month1 && day == day1) {
            return intToString(c.get(Calendar.HOUR))+":"+intToString(c.get(Calendar.MINUTE));
        }
        else{
            return intToString(day1)+"."+intToString(month1)+"."+year1;
        }
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    private static String intToString(int i){
        if (i<10)
            return "0"+i;
        else
            return String.valueOf(i);
    }

}
