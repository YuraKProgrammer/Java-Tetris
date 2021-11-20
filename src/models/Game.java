package models;

import impl.UserRecordStorage;
import javafx.util.Duration;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Game {
    public GameField getField() {
        return field;
    }

    public int getFigureX() {
        return figureX;
    }

    private Random random = new Random();

    private int figureX;

    public int getFigureY() {
        return figureY;
    }

    private int figureY;

    private GameField field = new GameField();

    private IRecordStorage recordStorage = new UserRecordStorage();

    public void setCurrentFigure(Figure currentFigure) {
        this.currentFigure = currentFigure;
    }

    private Figure currentFigure;

    private Figure nextFigure;

    private IFigureRotator rotator = new FigureRotator2();

    private FigureFabric fabric = new FigureFabric();
    public double getScore() {
        return score;
    }

    public void setScore() {
        this.score = field.score;
    }

    private double score;

    private Date startTime;

    public Game(){
        currentFigure=fabric.create();
        figureX=random.nextInt(field.width-currentFigure.getWidth()+1);
        nextFigure=fabric.create();
        startTime=new Date();
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
        var rotated = rotator.rotate(currentFigure);
        if (figureX+rotated.getWidth()> field.width)
            return false;
        if (figureY+rotated.getHeight()>field.height)
            return false;
        if (currentFigure.getHeight()==3 && currentFigure.getWidth()%2!=0 && figureX-1+rotated.getWidth()>-1 && currentFigure!=rotated) {
            figureX = figureX - 1;
            figureY = figureY + 1;
        }
        if (currentFigure.getWidth()==3 && currentFigure.getHeight()%2!=0 && figureX+1+rotated.getWidth()>-1 && currentFigure!=rotated) {
            figureX = figureX + 1;
            figureY = figureY - 1;
        }
        if (currentFigure.getHeight()==5 && currentFigure.getWidth()%2!=0 && figureX-1+rotated.getWidth()>-1 && currentFigure!=rotated) {
            figureX = figureX - 2;
            figureY = figureY + 2;
        }
        if (currentFigure.getWidth()==5 && currentFigure.getHeight()%2!=0 && figureX+1+rotated.getWidth()>-1 && currentFigure!=rotated) {
            figureX = figureX + 2;
            figureY = figureY - 2;
        }
        currentFigure=rotated;
        return true;
    }

    /**
     * Длительность игры
     * @return
     */
    public Duration getDuration(){
        var diff = new Date().getTime()-startTime.getTime();
        return Duration.millis(diff);
    }

    public void end(int rotates){
        Record record = new Record();
        record.setCountOfTurns(rotates);
        record.setDifficulty(field.difficulty);
        record.setGameDurationSec((int)getDuration().toSeconds());
        record.setGameTime(new Date());
        record.setScore(score);
        recordStorage.add(record);
    }
}
