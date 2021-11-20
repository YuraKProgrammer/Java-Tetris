package impl;

import models.IRecordStorage;
import models.Record;

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
    }

    @Override
    public Record[] load() {
        Record r1 = new Record();
        r1.setScore(120);
        r1.setGameDurationSec(50);
        r1.setDifficulty(2);
        r1.setCountOfTurns(15);
        Record r2 = new Record();
        r2.setScore(100);
        r2.setGameDurationSec(10);
        r2.setDifficulty(1);
        r2.setCountOfTurns(50);
        Record r3 = new Record();
        r3.setScore(90);
        r3.setGameDurationSec(5);
        r3.setDifficulty(4);
        r3.setCountOfTurns(9);
        Record r4 = new Record();
        r4.setScore(87);
        r4.setGameDurationSec(123);
        r4.setDifficulty(0.5);
        r4.setCountOfTurns(12);
        Record r5 = new Record();
        r5.setScore(50);
        r5.setGameDurationSec(50);
        r5.setDifficulty(1);
        r5.setCountOfTurns(500);
        if (r5!=null)
            return new Record[]{r1,r2,r3,r4,r5};
        if (r4!=null)
            return new Record[]{r1,r2,r3,r4};
        if (r3!=null)
            return new Record[]{r1,r2,r3};
        if (r2!=null)
            return new Record[]{r1,r2};
        if (r1!=null)
            return new Record[]{r1};
        return new Record[0];
    }
}
