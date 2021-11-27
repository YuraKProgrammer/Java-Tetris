package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import windows.RecordsWindowController;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.stream.Stream;

public class RecordsWindowController_Test {
    @ParameterizedTest
    @MethodSource("getTestData")
    public void dateToString_Test(Date date, String string){
        var result = RecordsWindowController.dateToString(date);
        Assertions.assertEquals(string,result);
    }
    private static Stream<Arguments> getTestData() {
        Calendar now = Calendar.getInstance();
        return Stream.of(
                Arguments.of(new GregorianCalendar(2021, 9 - 1, 4, 11, 11, 11).getTime(),"04.09.2021"),
                Arguments.of(new GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH), 10, 30, 15).getTime(),"10:30")
        );
    }
}
