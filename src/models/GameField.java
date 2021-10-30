package models;

import sample.Main;
import windows.GameWindowController;

public class GameField {
    /**
     * Количество блоков по ширине
     */
    public final int width = 10;
    /**
     * Количество блоков по высоте
     */
    public final int height = 20;

    public int score = 0;

    public boolean isGameOn() {
        return isGameOn;
    }

    public void setGameOn(boolean gameOn) {
        isGameOn = gameOn;
    }

    private boolean isGameOn = true;

    public GameField(){
    }

    private boolean[][] values = new boolean[width][height];

    public boolean getBlock(int x,int y){
        return values[x][y];
    }

    private void setBlock(int x, int y, boolean value){
        values[x][y] = value;
    }

    public boolean leftFree(Figure figure, int figureX, int figureY){
        for (var x=0; x<figure.getWidth(); x++){
            for (var y=0; y<figure.getHeight(); y++){
                if (figure.getBlock(x, y)) {
                    int y1 = y + figureY;
                    int x1 = x + figureX - 1;
                    if (x1 >= 0) {
                        if (getBlock(x1, y1))
                            return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean rightFree(Figure figure, int figureX, int figureY){
        for (var x=0; x<figure.getWidth(); x++){
            for (var y=0; y<figure.getHeight(); y++) {
                if (figure.getBlock(x, y)) {
                    int y1 = y + figureY;
                    int x1 = x + figureX + 1;
                    if (x1 <= width) {
                        if (getBlock(x1, y1))
                            return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean downFree(Figure figure, int figureX, int figureY){
        for (var x=0; x<figure.getWidth(); x++){
            for (var y=0; y<figure.getHeight(); y++){
                if (figure.getBlock(x,y)) {
                    int y1 = y + figureY + 1;
                    int x1 = x + figureX;
                    if (y1 <= height) {
                        if (getBlock(x1, y1)) {
                            return false;
                        }
                    } else
                        return false;
                }
            }
        }
        return true;
    }

    public void add(Figure figure,int figureX, int figureY){
        for (var x=0; x<figure.getWidth(); x++){
            for (var y=0; y<figure.getHeight(); y++){
                if (figure.getBlock(x,y))
                    values[figureX+x][figureY+y]=true;
            }
        }
        checkLines();
        checkTop();
    }

    private void checkLines(){
        for (var y=height-1; y>0; y--){
            if (isLineFilled(y)){
                score++;
                for (var n=0; n<width; n++){
                    values[n][y]=false;
                }
                downField(y);
            }
        }
    }

    private void checkTop(){
        for (var x=0; x<width; x++){
            if (values[x][0]){
                isGameOn=false;
            }
        }
    }

    private void downField(int y) {
        for (var x1=0; x1<width; x1++){
            for (var y1 = y-1; y1>-1; y1--){
                if (y1+1<height)
                    values[x1][y1+1]=values[x1][y1];
            }
        }
    }

    private boolean isLineFilled(int y){
        for (var x=0; x<width; x++){
            if (!values[x][y])
                return false;
        }
        return true;
    }
}
