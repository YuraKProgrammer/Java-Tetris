package models;

import sample.Main;

public class Game {
    public GameField getField() {
        return field;
    }

    public int getFigureX() {
        return figureX;
    }

    private int figureX;

    public int getFigureY() {
        return figureY;
    }

    private int figureY;

    private GameField field = new GameField();

    private Figure currentFigure;

    private Figure nextFigure;

    private FigureFabric fabric = new FigureFabric();
    public int getScore() {
        return score;
    }

    public void setScore() {
        this.score = field.score;
    }

    private int score;

    public Game(){
        currentFigure=fabric.create();
        figureX=(field.width-currentFigure.getWidth())/2;
        nextFigure=fabric.create();
    }

    public Figure getCurrentFigure(){
        return currentFigure;
    }

    public Figure getNextFigure() {setScore(); return  nextFigure;}

    public boolean moveRight(){
        if (figureX+currentFigure.getWidth()>field.width-1 || !field.rightFree(currentFigure,figureX,figureY))
            return false;
        figureX++;
        return true;
    }

    public boolean moveLeft(){
        if (figureX<=0 || !field.leftFree(currentFigure,figureX,figureY))
            return false;
        figureX--;
        return true;
    }

    public void moveDown(){
        if (figureY+currentFigure.getHeight()<field.height && field.downFree(currentFigure, figureX, figureY)) {
            figureY++;
        }
        else {
            field.add(currentFigure,figureX,figureY);
            currentFigure=nextFigure;
            figureX=(field.width-currentFigure.getWidth())/2;
            figureY=0;
            nextFigure=fabric.create();
        }
    }

    public boolean rotate(){
        var rotated = createRotatedFigure();
        if (figureX+rotated.getWidth()> field.width)
            return false;
        if (figureY+rotated.getHeight()>field.height)
            return false;
        currentFigure=rotated;
        return true;
    }

    private Figure createRotatedFigure(){
        var cf = new boolean[3][3];
        for (var x=0; x<currentFigure.getWidth(); x++){
            for (var y=0; y<currentFigure.getHeight(); y++){
                cf[x][y]=currentFigure.getBlock(x,y);
            }
        }
        var rf = new boolean[3][3];
        for (var x=0; x<3; x++) {
            for (var y = 0; y<3; y++) {
                rf[x][y]=cf[y][x]; //??????????????????????
            }                                   // 1 1 0        1 1 1
        }                                       // 1 0 0  --->  0 0 1
        var x1=3-checkVoidX(rf);                // 1 0 0        0 0 0
        var y1=3-checkVoidY(rf);
        var blocks = new boolean[x1][y1];
        for (var x=0; x<x1; x++){
            for (var y=0; y<y1; y++){
                blocks[x][y]=rf[x][y];
            }
        }
        return new Figure(blocks);
    }

    private int checkVoidX(boolean[][] figure){
        var k=0;
        for(var x=0; x<3; x++){
            for(var y=0; y<3; y++){
                if(!figure[x][y])
                    k++;
                else
                    k=0;
            }
            if (k==3) {
                if (x == 0) {
                    throw new RuntimeException();
                }
                if (x == 1) {
                    return 2;
                }
                if (x == 2) {
                    return 1;
                }
            }
            if (k<3){
                continue;
            }
        }
        return 0;
    }

    private int checkVoidY(boolean[][] figure){
        var k=0;
        for(var y=0; y<3; y++){
            for(var x=0; x<3; x++){
                if(!figure[x][y])
                    k++;
                else
                    k=0;
            }
            if (k==3) {
                if (y == 0) {
                    throw new RuntimeException();
                }
                if (y == 1) {
                    return 2;
                }
                if (y == 2) {
                    return 1;
                }
            }
        }
        return 0;
    }
}
