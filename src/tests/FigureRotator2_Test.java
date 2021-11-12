package tests;

import models.Figure;
import models.FigureRotator2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class FigureRotator2_Test {
    @ParameterizedTest
    @MethodSource("getBlocks")
    public void rotate_Test1(boolean[][] blocks1, boolean[][] blocks2){
        var rotator = new FigureRotator2();
        var rotatedFigure = rotator.rotate(new Figure(blocks1));
        var expectedFigure = new Figure(blocks2);
        Assertions.assertEquals(expectedFigure.getHeight(), rotatedFigure.getHeight());
        Assertions.assertEquals(expectedFigure.getWidth(), rotatedFigure.getWidth());
        for (var x=0; x<rotatedFigure.getWidth(); x++){
            for (var y=0; y<rotatedFigure.getHeight(); y++){
                var b1= rotatedFigure.getBlock(x,y);
                var b2 = expectedFigure.getBlock(x,y);
                Assertions.assertEquals(b1,b2);
            }
        }
    }

    private static Stream<Arguments> getBlocks(){
        var f22_1 = new boolean[2][2];
        f22_1[0][0]=true;
        f22_1[1][0]=true;
        f22_1[0][1]=true;
        var f22_2 = new boolean[2][2];
        f22_2[0][0]=true;
        f22_2[1][0]=true;
        f22_2[1][1]=true;
        var f42_1 = new boolean[4][2];
        f42_1[0][1]=true;
        f42_1[1][1]=true;
        f42_1[2][1]=true;
        f42_1[3][1]=true;
        f42_1[3][0]=true;
        var f42_2 = new boolean[2][4];
        f42_2[0][0]=true;
        f42_2[0][1]=true;
        f42_2[0][2]=true;
        f42_2[0][3]=true;
        f42_2[1][3]=true;
        return Stream.of(
                Arguments.of(new boolean[1][1], new boolean[1][1]),
                Arguments.of(new boolean[3][1], new boolean[1][3]),
                Arguments.of(f22_1, f22_2),
                Arguments.of(f42_1, f42_2)
        );
    }
}
