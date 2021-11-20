package impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.scene.Scene;
import models.IRecordStorage;
import models.Record;
import sample.Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class UserRecordStorage implements IRecordStorage {
    @Override
    public void add(Record record) {
     //   var list = Arrays.stream(load()).toList();
        var list = new ArrayList<Record>();
        var oldRecords=load();
        for (var o : oldRecords) {
            list.add(o);
        }
        list.add(record);
        save(list.toArray(new Record[0]));
    }

    private void save(Record[] records){
        var serializer = new GsonBuilder().setPrettyPrinting().create();
        var json = serializer.toJson(records);
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(getFileName());
            writer.println(json);
        }
        catch (Exception e){
            Main.showError(e);
        }
        finally {
            if (writer!=null)
                writer.close();
        }
    }

    private String getFileName() {
        //return "D:\\Школьные задания\\Программирование\\Records.json";
        return System.getProperty("user.home")+"\\TetrisRecords.json";
    }

    @Override
    public Record[] load() {
        try{
            var file = new File(getFileName());
            if (!file.exists())
                return new Record[0];
            var json = Files.readString(Path.of(getFileName()), StandardCharsets.US_ASCII);
            var serializer = new GsonBuilder().setPrettyPrinting().create();
            var records = serializer.fromJson(json,Record[].class);
            return records;
        }
        catch (Exception e){
            Main.showError(e);
            return new Record[0];
        }
    }
}
