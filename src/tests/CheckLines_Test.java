package tests;

import models.GameField;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckLines_Test {
    @Test
    public void checkLines_Test1(){
        var field = new GameField();
        field.setBlock(0,1, true);
        field.setBlock(1,1, true);
        field.setBlock(2,1, true);
        field.setBlock(3,1, true);
        field.setBlock(4,1, true);
        field.setBlock(5,1, true);
        field.setBlock(6,1, true);
        field.setBlock(7,1, true);
        field.setBlock(8,1, true);
        field.setBlock(9,1, true);
        boolean result = field.checkLines();
        Assertions.assertTrue(result);
    }
    @Test
    public void checkLines_Test2(){
        var field = new GameField();
        field.setBlock(0,13, true);
        field.setBlock(1,13, true);
        field.setBlock(2,13, true);
        field.setBlock(3,13, true);
        field.setBlock(4,13, true);
        field.setBlock(5,13, true);
        field.setBlock(6,13, true);
        field.setBlock(7,13, true);
        field.setBlock(8,13, true);
        field.setBlock(9,13, true);
        field.setBlock(9,14, true);
        field.setBlock(5,12, true);
        boolean result = field.checkLines();
        Assertions.assertTrue(result);
    }
    @Test
    public void checkLines_Test3(){
        var field = new GameField();
        field.setBlock(2,0, true);
        field.setBlock(2,1, true);
        field.setBlock(2,2, true);
        field.setBlock(2,3, true);
        field.setBlock(2,4, true);
        field.setBlock(2,5, true);
        field.setBlock(2,6, true);
        field.setBlock(2,7, true);
        field.setBlock(2,8, true);
        field.setBlock(2,9, true);
        boolean result = field.checkLines();
        Assertions.assertFalse(result);
    }
    @Test
    public void checkLines_Test4(){
        var field = new GameField();
        field.setBlock(0,14, true);
        field.setBlock(1,14, true);
        field.setBlock(2,14, true);
        field.setBlock(3,14, true);
        field.setBlock(4,14, true);
        field.setBlock(5,14, true);
        field.setBlock(6,14, true);
        field.setBlock(7,14, true);
        field.setBlock(8,14, true);
        boolean result = field.checkLines();
        Assertions.assertFalse(result);
    }
}
