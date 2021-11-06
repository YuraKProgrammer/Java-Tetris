package tests;

import models.Figure;
import models.FigureRotator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FigureRotator_Test {
    @Test
    public void rotate_Test1(){
        FigureRotator rotator = new FigureRotator();
        var blocks = new boolean[2][3];
        blocks[0][0] = true;
        blocks[1][0] = true;
        blocks[0][1] = true;
        blocks[0][2] = true;
        Figure currentFigure = new Figure(blocks);
        var result = rotator.rotate(currentFigure);
        var expectation = new boolean[3][2];
        expectation[0][0] = true;
        expectation[1][0] = true;
        expectation[2][0] = true;
        expectation[2][1] = true;
        Assertions.assertTrue(new Figure(expectation).areEquals(result));
    }
    @Test
    public void rotate_Test2(){
        FigureRotator rotator = new FigureRotator();
        var blocks = new boolean[2][2];
        blocks[0][0] = true;
        blocks[1][0] = true;
        blocks[0][1] = true;
        blocks[1][1] = true;
        Figure currentFigure = new Figure(blocks);
        var result = rotator.rotate(currentFigure);
        var expectation = new boolean[2][2];
        expectation[0][0] = true;
        expectation[1][0] = true;
        expectation[0][1] = true;
        expectation[1][1] = true;
        Assertions.assertTrue(new Figure(expectation).areEquals(result));
    }
    @Test
    public void rotate_Test3(){
        FigureRotator rotator = new FigureRotator();
        var blocks = new boolean[1][3];
        blocks[0][0] = true;
        blocks[0][1] = true;
        blocks[0][2] = true;
        Figure currentFigure = new Figure(blocks);
        var result = rotator.rotate(currentFigure);
        var expectation = new boolean[3][1];
        expectation[0][0] = true;
        expectation[1][0] = true;
        expectation[2][0] = true;
        Assertions.assertTrue(new Figure(expectation).areEquals(result));
    }
}
